package example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


import javax.inject.Inject;

import example.entity.Member;

/**
 * Created by root on 17-3-17.
 */
@Repository
public class MemberDao {

    @Inject
    private SessionFactory sessionFactory;

    public String test() {
        Session session = sessionFactory.getCurrentSession();
        sessionFactory.openSession();
        try {
            //Transaction ts = session.beginTransaction();
            Member member = new Member();
            member.setPassword("test1");
            member.setUsername("test1");
            session.save(member);
            //ts.commit();
            Member member1 = new Member();
            member.setPassword("test2");
            session.save(member1);
            //ts.commit();
        } finally {
            //session.close();
            //sessionFactory.close();
            System.out.println("test");
        }
        return "testdao";
    }

}
