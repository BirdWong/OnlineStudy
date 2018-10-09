package cn.h4795.OnlineStudy.service;

import cn.h4795.OnlineStudy.Pojo.Problem;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @date 2018/8/8 0008
 */
public interface ProblemService {

	/**
	 * 添加题目，分别添加question和choice
	 * @param problem
	 */
	public void add(Problem problem);

	/**
	 * 删除题目，需要删除choice和question
	 *
	 * ids为question的id
	 * @param ids
	 */
	public void delete(Integer[] ids);

	/**
	 * 通过paper 的id删除一个列表的question 和 choice
	 * @param id
	 */
	public void deleteByPaper(Integer id);

	/**
	 * 通过question的id返回一个完整的题目
	 * @param id
	 * @return
	 */
	public Problem findOne(Integer id);

	/**
	 * 通过paper的id返回一个题目列表
	 * @param pid
	 * @param uid
	 * @return
	 */
	public List<Problem> findByPaperId(Integer pid,Integer uid);


	/**
	 * 检查答卷
	 *
	 * 提交要求
	 *
	 * {
	 *         'pid':****,
	 *         'uid':***,
	 *         'qid':'aswer',
	 *         'qid':'aswer'
	 * }
	 * @param test
	 * @return
	 */
	public Map judge(Map test);
}
