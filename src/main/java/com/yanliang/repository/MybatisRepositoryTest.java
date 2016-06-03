package com.yanliang.repository;

import com.yanliang.entity.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author yanliang
 * @ClassName MybatisRepositoryTest
 * @Description
 * @Date 2016/5/20
 */
public class MybatisRepositoryTest {

    public static void mainTest(String[] args) {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSession sqlSession = null;
        //create factory
        try {
            SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("config/mybatis-config.xml"));
            sqlSession = factory.openSession();
//            List<Person> person = sqlSession.selectList("com.yanliang.repository.PersonMapper.selectAll");

            //use mapper interface
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);

            List<Person> mapperResultPerson = mapper.selectAll();

//            System.out.println("sqlSession:"+person);
            System.out.println("mapper:"+mapperResultPerson);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(sqlSession != null)
                sqlSession.close();
        }
    }

}
