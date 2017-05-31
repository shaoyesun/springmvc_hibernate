package example.dao.shiro;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import example.dao.BaseDao;
import example.entity.shiro.User;

/**
 * Created by root on 17-5-27.
 */
@Repository
public class UserDao extends BaseDao<User, Long> {

    //通过用户名获取用户对象
    public User getUserByUserName(String userName) {
        Criteria c = getSession().createCriteria(User.class)
                .add(Restrictions.eq("username", userName));
        return (User) c.uniqueResult();
    }



}
