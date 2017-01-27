package service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import po.Permission;
import service.PermissionService;
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=5)
public class PermissionServiceImpl implements PermissionService {

	public Permission createPermission(Permission permission) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletePermission(Long permissionId) {
		// TODO Auto-generated method stub
		
	}

}
