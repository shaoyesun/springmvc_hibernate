package example.service.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by root on 17-5-31.
 */
public class CustomRolesAuthorizationFilter extends AuthorizationFilter {
    protected boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object mappedValue) throws Exception {
        Subject subject = getSubject(req, resp);
        String[] rolesArray = (String[]) mappedValue;

        if (rolesArray == null || rolesArray.length == 0) { //没有角色限制，有权限访问
            return true;
        }
        for (int i = 0; i < rolesArray.length; i++) {
            if (subject.hasRole(rolesArray[i])) { //若当前用户是rolesArray中的任何一个，则有权限访问
                return true;
            }
        }

        return false;
    }
}
