package cn.h4795.OnlineStudy.service.impl;
import java.util.List;

import cn.h4795.OnlineStudy.Mapper.CategoryMapper;
import cn.h4795.OnlineStudy.service.VidioService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.h4795.OnlineStudy.Pojo.Category;
import cn.h4795.OnlineStudy.Pojo.CategoryExample;
import cn.h4795.OnlineStudy.Pojo.CategoryExample.Criteria;
import cn.h4795.OnlineStudy.service.CategoryService;

import entity.PageResult;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	@Autowired
	private RedisTemplate redisTemplate;

	@Reference
	private VidioService vidioService;
	
	/**
	 * 查询全部
	 */
	@Override
	public List< Category> findAll() {
		return categoryMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Category> page=   (Page< Category>) categoryMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add( Category category) {
		categoryMapper.insert(category);
		if (redisTemplate.hasKey("category") && redisTemplate.boundHashOps("category").hasKey(category.getCid())){
			redisTemplate.boundHashOps("category").delete(category.getCid());

		}
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update( Category category){
	    Integer id = category.getId();
	    Integer cid = categoryMapper.selectByPrimaryKey(category.getId()).getCid();
	    if (redisTemplate.hasKey("category") && redisTemplate.boundHashOps("category").hasKey(cid)){
		    redisTemplate.boundHashOps("category").delete(cid);
	    }
		categoryMapper.updateByPrimaryKey(category);
		if(cid.intValue() != category.getCid()){
			if (redisTemplate.hasKey("category") && redisTemplate.boundHashOps("category").hasKey(category.getCid()))
		    redisTemplate.boundHashOps("category").delete(category.getCid());
        }
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Category findOne(Integer id){
		return categoryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			categoryMapper.deleteByPrimaryKey(id);
			Integer cid = categoryMapper.selectByPrimaryKey(id).getCid();
			if (redisTemplate.hasKey("category") && redisTemplate.boundHashOps("category").hasKey(cid)){
				redisTemplate.boundHashOps("category").delete(cid);
			}
		}
	}
	
	
		@Override
	public PageResult findPage( Category category, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 CategoryExample example=new  CategoryExample();
		Criteria criteria = example.createCriteria();
		
		if(category!=null){			
						if(category.getCname()!=null && category.getCname().length()>0){
				criteria.andCnameLike("%"+category.getCname()+"%");
			}
	
		}
		
		Page< Category> page= (Page< Category>)categoryMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}



	@Override
	public List<Category> findByParentId(Integer id) {

		List<Category> categoryList = null;

		if (redisTemplate.hasKey("category") ){
				if (redisTemplate.boundHashOps("category").hasKey(id)){
					categoryList = (List<Category>) redisTemplate.boundHashOps("category").get(id);
				}
		}


		if(categoryList == null){
			    CategoryExample categoryExample = new CategoryExample();

			    Criteria criteria = categoryExample.createCriteria();
			    //建立查询
			    criteria.andCidEqualTo(id);

			    categoryExample.setOrderByClause("id");

			    categoryList= categoryMapper.selectByExample(categoryExample);

			    redisTemplate.boundHashOps("category").put(id,categoryList);

		}

		return categoryList;


	}

	@Override
	public void deleteByParentId(Integer id) {

		CategoryExample example = new CategoryExample();

		Criteria criteria  = example.createCriteria();

		criteria.andCidEqualTo(id);

		List<Category> list = categoryMapper.selectByExample(example);

		for (Category category : list){
			vidioService.deleteByCategoryId(category.getId());

			categoryMapper.deleteByPrimaryKey(category.getId());
		}




	}


}
