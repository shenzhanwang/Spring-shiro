package mapper;

import java.util.List;
import po.Permission;

public interface PermissionMapper {
	List<Permission> getPermissions();
	void addpermission(Permission permission);
	void deletepermission(long pid);
}
