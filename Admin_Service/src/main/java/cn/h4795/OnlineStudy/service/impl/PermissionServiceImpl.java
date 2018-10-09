package cn.h4795.OnlineStudy.service.impl;
import java.util.List;

import cn.h4795.OnlineStudy.Mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
// import cn.h4795.mapper. PermissionMapper;
// import cn.h4795.pojo. Permission;

// import com.pinyougou.pojo. PermissionExample;
import cn.h4795.OnlineStudy.Pojo.Permission;
import cn.h4795.OnlineStudy.Pojo.PermissionExample;
import cn.h4795.OnlineStudy.Pojo.PermissionExample.Criteria;
// import com.pinyougou.pojo. PermissionExample.Criteria;
import cn.h4795.OnlineStudy.service.PermissionService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List< Permission> findAll() {
		return permissionMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Permission> page=   (Page< Permission>) permissionMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add( Permission permission) {
		permissionMapper.insert(permission);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update( Permission permission){
		permissionMapper.updateByPrimaryKey(permission);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Permission findOne(Integer id){
		return permissionMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			permissionMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage( Permission permission, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 PermissionExample example=new  PermissionExample();
		Criteria criteria = example.createCriteria();
		
		if(permission!=null){			
						if(permission.getUsername()!=null && permission.getUsername().length()>0){
				criteria.andUsernameLike("%"+permission.getUsername()+"%");
			}
			if(permission.getRole()!=null && permission.getRole().length()>0){
				criteria.andRoleLike("%"+permission.getRole()+"%");
			}
	
		}
		
		Page< Permission> page= (Page< Permission>)permissionMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
