package com.zhu.test;

import com.zhu.dao.IUserDao;
import com.zhu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 注解方式CRUD的测试
 */
public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public  void init()throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public  void destroy()throws  Exception{
        session.commit();
        session.close();
        in.close();
    }


    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("梅西");
        user.setAddress("西班牙");

        userDao.saveUser(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(7);
        user.setUsername("梅老板");
        user.setAddress("西班牙马德里");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }


    @Test
    public void testDelete(){
        userDao.deleteUser(7);
    }

    @Test
    public void testFindOne(){
        User user = userDao.findById(6);
        System.out.println(user);
    }


    @Test
    public  void testFindByName(){
        List<User> users = userDao.findUserByName("林");
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public  void testFindTotal(){
        int total = userDao.findTotalUser();
        System.out.println(total);
    }
}
