package mapper;

import java.util.List;
import po.Role;


public interface RoleMapper {
	List<Role> getRoles();
	void addRole(Role role);
	void deleterole(long roleid);
	void addRolePermission(long roleid,long permissionid);
	void deleterole_permission(long roleid,long permissionid);
	Role getRolebyid(long roleid);
}
