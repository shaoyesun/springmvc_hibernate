package example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import example.dao.MemberDao;

/**
 * Created by root on 17-3-17.
 */
@Service
@Transactional
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    public String test() {
        return memberDao.test();
    }

}
