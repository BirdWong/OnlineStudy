package cn.h4795.OnlineStudy.service.impl;
import java.util.List;

import cn.h4795.OnlineStudy.Mapper.AdminMapper;
import cn.h4795.OnlineStudy.Mapper.PermissionMapper;
import cn.h4795.OnlineStudy.Pojo.PermissionExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
// import cn.h4795.mapper. AdminMapper;
// import cn.h4795.pojo. Admin;

// import com.pinyougou.pojo. AdminExample;
import cn.h4795.OnlineStudy.Pojo.Admin;
import cn.h4795.OnlineStudy.Pojo.AdminExample;
import cn.h4795.OnlineStudy.Pojo.AdminExample.Criteria;
// import com.pinyougou.pojo. AdminExample.Criteria;
import cn.h4795.OnlineStudy.service.AdminService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private PermissionMapper permissionMapper ;
	
	/**
	 * 查询全部
	 */
	@Override
	public List< Admin> findAll() {
		return adminMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Admin> page=   (Page< Admin>) adminMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add( Admin admin) {
		adminMapper.insert(admin);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update( Admin admin){
		adminMapper.updateByPrimaryKey(admin);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Admin findOne(String id){
		return adminMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(String[] ids) {
		for(String id:ids){

			PermissionExample permissionExample = new PermissionExample();

			PermissionExample.Criteria criteria = permissionExample.createCriteria();

			criteria.andUsernameEqualTo(id);

			permissionMapper.deleteByExample(permissionExample);

			adminMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage( Admin admin, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 AdminExample example=new  AdminExample();
		Criteria criteria = example.createCriteria();
		
		if(admin!=null){			
						if(admin.getUsername()!=null && admin.getUsername().length()>0){
				criteria.andUsernameLike("%"+admin.getUsername()+"%");
			}
			if(admin.getPassword()!=null && admin.getPassword().length()>0){
				criteria.andPasswordLike("%"+admin.getPassword()+"%");
			}
	
		}
		
		Page< Admin> page= (Page< Admin>)adminMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
