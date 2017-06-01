package example.service.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

import example.entity.shiro.User;

/**
 * Created by root on 17-5-27.
 *
 * @ 用户的信息认证器和用户的权限认证器，需要自己来实现Realms来自定义的管理系统内部的权限规则
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        String username = (String) pc.fromRealm(getName()).iterator().next();
        if (username != null) {
            List<String> pers = userService.findPermByRoleId(username);
            Set<String> roleName = userService.findRolesByUsername(username);
            if (pers != null && !pers.isEmpty()) {
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                //将用户角色添加到用户信息中
                info.setRoles(roleName);
                for (String each : pers) {
                    //将权限资源添加到用户信息中
                    info.addStringPermission(each);
                }
                return info;
            }
        }
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) at;
        // 通过表单接收的用户名
        String username = token.getUsername();
        if (username != null && !"".equals(username)) {
            User user = userService.getUserByUserName(username);
            if (user != null) {
                return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
            }
        }

        return null;
    }

}
