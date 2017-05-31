package example.service.shiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import example.dao.shiro.PermissionDao;
import example.dao.shiro.RoleDao;
import example.dao.shiro.UserDao;
import example.entity.shiro.Permission;
import example.entity.shiro.Role;
import example.entity.shiro.User;
import example.entity.shiro.UserRole;

/**
 * Created by root on 17-5-27.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private RoleDao roleDao;

    //通过用户名获取用户对象
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    //通过用户名获取用户角色
    public List<String> findPermByRoleId(String username) {
        System.out.println("调用");
        User user = getUserByUserName(username);
        if (user == null) {
            return null;
        }
        List<String> list = new ArrayList<String>();
        for (UserRole userRole : user.getUserRoles()) {
            Role role = userRole.getRole();
            List<Permission> permissions = permissionDao.findPermByRoleId(role.getId());
            for (Permission p : permissions) {
                list.add(p.getUrl());
            }
        }
        return list;
    }

    //通过用户名获取权限资源
    public Set<String> findRolesByUsername(String username) {
        User user = userDao.getUserByUserName(username);
        List<UserRole> userRoles = user.getUserRoles();
        Set<String> roleName = new HashSet<String>();
        for(UserRole ur : userRoles) {
            roleName.add(ur.getRole().getName());
        }
        return roleName;
    }

}
