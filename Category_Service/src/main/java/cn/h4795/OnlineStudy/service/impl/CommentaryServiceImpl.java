package cn.h4795.OnlineStudy.service.impl;
import java.util.List;

import cn.h4795.OnlineStudy.Mapper.CommentaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
// import cn.h4795.mapper. CommentaryMapper;
// import cn.h4795.pojo. Commentary;

// import com.pinyougou.pojo. CommentaryExample;
import cn.h4795.OnlineStudy.Pojo.Commentary;
import cn.h4795.OnlineStudy.Pojo.CommentaryExample;
import cn.h4795.OnlineStudy.Pojo.CommentaryExample.Criteria;
// import com.pinyougou.pojo. CommentaryExample.Criteria;
import cn.h4795.OnlineStudy.service.CommentaryService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class CommentaryServiceImpl implements CommentaryService {

	@Autowired
	private CommentaryMapper commentaryMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List< Commentary> findAll() {
		return commentaryMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Commentary> page=   (Page< Commentary>) commentaryMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add( Commentary commentary) {
		commentaryMapper.insert(commentary);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update( Commentary commentary){
		commentaryMapper.updateByPrimaryKey(commentary);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Commentary findOne(Integer id){
		return commentaryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			commentaryMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage( Commentary commentary, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 CommentaryExample example=new  CommentaryExample();
		Criteria criteria = example.createCriteria();
		
		if(commentary!=null){			
						if(commentary.getCtext()!=null && commentary.getCtext().length()>0){
				criteria.andCtextLike("%"+commentary.getCtext()+"%");
			}
	
		}
		
		Page< Commentary> page= (Page< Commentary>)commentaryMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public List<Commentary> findByCourseId(Integer id) {

		CommentaryExample example = new CommentaryExample();

		Criteria criteria = example.createCriteria();

		criteria.andCidEqualTo(id);

		example.setOrderByClause("ctime");

		List<Commentary> commentaries = commentaryMapper.selectByExample(example);

		return commentaries;
	}

	@Override
	public void deleteByParentId(Integer id) {

		CommentaryExample example = new CommentaryExample();

		Criteria criteria = example.createCriteria();

		criteria.andCidEqualTo(id);

		commentaryMapper.deleteByExample(example);

	}

}
