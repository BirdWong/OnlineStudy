package cn.h4795.OnlineStudy.service.impl;
import java.util.List;

import cn.h4795.OnlineStudy.Mapper.PersonalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
// import cn.h4795.mapper. PersonalMapper;
// import cn.h4795.pojo. Personal;

// import com.pinyougou.pojo. PersonalExample;
import cn.h4795.OnlineStudy.Pojo.Personal;
import cn.h4795.OnlineStudy.Pojo.PersonalExample;
import cn.h4795.OnlineStudy.Pojo.PersonalExample.Criteria;
// import com.pinyougou.pojo. PersonalExample.Criteria;
import cn.h4795.OnlineStudy.service.PersonalService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class PersonalServiceImpl implements PersonalService {

	@Autowired
	private PersonalMapper personalMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List< Personal> findAll() {
		return personalMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Personal> page=   (Page< Personal>) personalMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add( Personal personal) {
		personalMapper.insert(personal);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update( Personal personal){
		personalMapper.updateByPrimaryKey(personal);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Personal findOne(Integer id){
		return personalMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			personalMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage( Personal personal, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 PersonalExample example=new  PersonalExample();
		Criteria criteria = example.createCriteria();
		
		if(personal!=null){			
						if(personal.getPname()!=null && personal.getPname().length()>0){
				criteria.andPnameLike("%"+personal.getPname()+"%");
			}
			if(personal.getPurl()!=null && personal.getPurl().length()>0){
				criteria.andPurlLike("%"+personal.getPurl()+"%");
			}
			if(personal.getPaddress()!=null && personal.getPaddress().length()>0){
				criteria.andPaddressLike("%"+personal.getPaddress()+"%");
			}
			if(personal.getPschool()!=null && personal.getPschool().length()>0){
				criteria.andPschoolLike("%"+personal.getPschool()+"%");
			}
			if(personal.getPcompany()!=null && personal.getPcompany().length()>0){
				criteria.andPcompanyLike("%"+personal.getPcompany()+"%");
			}
	
		}
		
		Page< Personal> page= (Page< Personal>)personalMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public Personal findByParentId(Integer id) {
		PersonalExample example = new PersonalExample();

		Criteria criteria = example.createCriteria();

		criteria.andUidEqualTo(id);

		List<Personal> personals = personalMapper.selectByExample(example);

		Personal personal = null;
		try {
			personal = (Personal) personals.get(0);
		}catch (Exception e){
			personal = new Personal();
			personal.setPname("请完善用户信息");
			System.out.println("当前用户没有信息");
		}

		return personal;

	}

}
