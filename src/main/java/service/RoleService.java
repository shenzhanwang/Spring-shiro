package service;

import java.util.List;

import po.Role;


public interface RoleService {


    public Role createRole(Role role);
    public void deleteRole(Long roleId);

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void correlationPermissions(Long roleId, Long... permissionIds);

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void uncorrelationPermissions(Long roleId, Long... permissionIds);
    
    public List<Role> getroles();
    
    public List<Role> getpagerole(int pagenum, int pagesize);
}
