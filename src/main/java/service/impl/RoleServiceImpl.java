package service.impl;

import java.util.List;

import mapper.RoleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import po.Role;
import service.RoleService;
@Service
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


}
