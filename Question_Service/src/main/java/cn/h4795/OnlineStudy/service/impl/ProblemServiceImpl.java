package cn.h4795.OnlineStudy.service.impl;

import cn.h4795.OnlineStudy.Mapper.ChoiceMapper;
import cn.h4795.OnlineStudy.Mapper.QuestionMapper;
import cn.h4795.OnlineStudy.Mapper.UpqMapper;
import cn.h4795.OnlineStudy.Mapper.UsertestrecordMapper;
import cn.h4795.OnlineStudy.Pojo.*;
import cn.h4795.OnlineStudy.service.ProblemService;
import cn.h4795.OnlineStudy.service.QuestionService;
import cn.h4795.OnlineStudy.service.UsertestrecordService;
import com.alibaba.dubbo.config.annotation.Service;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author Administrator
 * @date 2018/8/8 0008
 */

@Service(timeout = 10000)
public class ProblemServiceImpl implements ProblemService {

	@Autowired
	private QuestionMapper questionMapper ;


	@Autowired
	private ChoiceMapper choiceMapper;

	@Autowired
	private UpqMapper upqMapper ;

	@Autowired
	private UsertestrecordMapper usertestrecordMapper;





	/**
	 * 添加题目，分别添加question和choice
	 * @param problem
	 */
	@Override
	public void add(Problem problem) {


		//1.提取question对象
		Question question = new Question();

		question.setAswer(problem.getAnswer());

		Date date = new Date();

		question.setCreatedata(date);

		question.setDescription(problem.getQuestion());

		question.setKid(problem.getKid());

		question.setUid(problem.getUid());

		question.setScore(problem.getGrade());

		questionMapper.insert(question);


		//2.获取question对象的id
		QuestionExample example = new QuestionExample();

		QuestionExample.Criteria criteria  = example.createCriteria();

		criteria.andDescriptionEqualTo(problem.getQuestion());

		criteria.andCreatedataEqualTo(date);

		Question question1 = questionMapper.selectByExample(example).get(0);

		Integer qid = question1.getId();

		//3获取choice的map对象
		Map choiceMap = problem.getChoice();

		for (Object obj : choiceMap.keySet()){


			Choice choice = new Choice();

			choice.setDescription(choiceMap.get(obj).toString());

			choice.setQid(qid);

			choice.setSequence(Integer.valueOf(obj.toString()));

			choiceMapper.insert(choice);
		}
	}


	/**
	 *  删除题目，需要删除choice和question
	 *
	 *  ids为question的id
	 * @param ids
	 */
	@Override
	public void delete(Integer[] ids) {
		for (Integer id : ids){
			//1.先删除选项，选项中外键为question
			ChoiceExample example  = new ChoiceExample() ;

			ChoiceExample.Criteria criteria = example.createCriteria();

			criteria.andQidEqualTo(id);

			choiceMapper.deleteByExample(example);
			//2删除question
			questionMapper.deleteByPrimaryKey(id);
		}
	}


	/**
	 * 通过paper 的id删除一个列表的question 和 choice
	 * @param id
	 */
	@Override
	public void deleteByPaper(Integer id) {

		UpqExample example = new UpqExample();

		UpqExample.Criteria criteria = example.createCriteria();

		criteria.andPidEqualTo(id);

		List<Upq> upqList = upqMapper.selectByExample(example);


		List<Integer> ids = new ArrayList<>();
		for (Upq upq: upqList) {
			ids.add(upq.getQid());
		}
		delete((Integer[]) ids.toArray());
	}


	/**
	 * 通过question的id返回一个完整的题目
	 * @param id
	 * @return
	 */
	@Override
	public Problem findOne(Integer id) {

		Question question = questionMapper.selectByPrimaryKey(id);

		ChoiceExample example = new ChoiceExample();

		ChoiceExample.Criteria criteria = example.createCriteria();

		criteria.andQidEqualTo(id);

		List<Choice> choices = choiceMapper.selectByExample(example);

		Map<String,Choice> choiceKeyMap = new HashMap();

		for (Choice choice : choices){
			choiceKeyMap.put(choice.getSequence().toString(),choice);
		}

		Object[] keys =choiceKeyMap.keySet().toArray();

		Arrays.sort(keys);

		Map<String,String> choiceMap = new LinkedHashMap();
		for (Object key:keys){
			choiceMap.put(key.toString(),choiceKeyMap.get(key.toString()).getDescription());
		}



		return toProblem(choiceMap,question);
	}

	/**
	 * 通过paper的id返回一个题目列表
	 * @param pid
	 * @param uid
	 * @return
	 */
	@Override
	public List<Problem> findByPaperId(Integer pid,Integer uid) {





		UpqExample example = new UpqExample();

		UpqExample.Criteria criteria = example.createCriteria();

		criteria.andPidEqualTo(pid);

		example.setOrderByClause("id");

		List<Upq> upqList = upqMapper.selectByExample(example);

		List<Problem> list = new LinkedList();
		for (Upq upq :
		    upqList) {

			list.add(findOne(upq.getQid()));
		}


		return list;
	}

	@Override
	public Map judge(Map test) {
		Integer pid = Integer.valueOf((String)test.get("pid"));
		Integer uid = Integer.valueOf((String)test.get("uid"));

		if (pid == null || uid == null){
			HashMap hashMap = new HashMap();
			hashMap.put("error","请求错误，可能是没有该题组或者用户");
			return hashMap;
		}

		List<Problem> problemList = findByPaperId(pid, uid);

		test.remove("pid");
		test.remove("uid");

		int sumScore = 0;
		List<Result> resultList = new ArrayList<>();
		for (Problem problem  : problemList){
			Integer qid = problem.getQid();

			Result result = null;
			if (test.get(qid) ==problem.getAnswer()){
				result = new Result(true,qid.toString());
				resultList.add(result);
				sumScore += problem.getGrade();
			}else {
				result = new Result(false,qid.toString());
				resultList.add(result);
			}
		}

		Map resultMap = new HashMap();

		resultMap.put("problem",problemList);
		resultMap.put("result",resultList);
		resultMap.put("sumScore",sumScore);

		Usertestrecord usertestrecord = new Usertestrecord();

		usertestrecord.setUid(uid);
		usertestrecord.setPid(pid);
		usertestrecord.setScore(sumScore);
		usertestrecord.setTesttime(new Date());
		usertestrecordMapper.updateByPrimaryKey(usertestrecord);
		return resultMap;
	}

	/**
	 * 将choice的map对象和question封装，
	 * @param choice
	 * @param question
	 * @return
	 */
	private Problem toProblem(Map<String,String> choice,Question question){
		Problem problem = new Problem();

		problem.setAnswer(String.valueOf(letterToNumber(question.getAswer())));

		problem.setChoice(choice);

		problem.setGrade(question.getScore());

		problem.setKid(question.getKid());

		problem.setQuestion(question.getDescription());

		problem.setUid(question.getUid());

		problem.setQid(question.getId());

		return problem;
	}


	private int letterToNumber(String letter) {
		int length = letter.length();
		int num = 0;
		int number = 0;
		for(int i = 0; i < length; i++) {
			char ch = letter.charAt(length - i - 1);
			num = (int)(ch - 'A' + 1) ;
			num *= Math.pow(26, i);
			number += num;
		}
		return number;
	}
}
