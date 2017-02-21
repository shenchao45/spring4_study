package com.shenchao;

import com.shenchao.domain.config.jpa.entity.MyUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by shenchao on 2017/2/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application_jpa.xml"})
@WebAppConfiguration
@Transactional
public class SpringJPATest {
    @PersistenceContext
    private EntityManager entityManager;
    @Test
    @Commit
    public void testSave(){
        MyUser user = new MyUser();
        user.setName("哈哈");
        entityManager.persist(user);
    }
}
