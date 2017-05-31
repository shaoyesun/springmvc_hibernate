package example.dao.shiro;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

import example.dao.BaseDao;
import example.entity.shiro.Permission;

/**
 * Created by root on 17-5-27.
 */
@Repository
public class PermissionDao extends BaseDao<Permission, Long> {

    public List<Permission> findPermByRoleId(Long roleId) {
        Criteria c = getSession().createCriteria(Permission.class)
                .add(Restrictions.eq("roleId", roleId));
        return c.list();
    }

}
