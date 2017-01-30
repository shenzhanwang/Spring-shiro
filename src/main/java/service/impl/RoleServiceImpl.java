package service.impl;

import java.util.List;

import mapper.RoleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import po.Role;
import service.RoleService;
@Service
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=5)
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleMapper rolemapper;
	
	public Role createRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteRole(Long roleId) {
		// TODO Auto-generated method stub
		
	}

	public void correlationPermissions(Long roleId, Long... permissionIds) {
		// TODO Auto-generated method stub
		
	}

	public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
		// TODO Auto-generated method stub
		
	}

	public List<Role> getroles() {
		return rolemapper.getRoles();
	}

	public List<Role> getpagerole(int pagenum, int pagesize) {
		PageHelper.startPage(pagenum,pagesize);
		List<Role> list=rolemapper.getRoles();
		return list;
	}


}
