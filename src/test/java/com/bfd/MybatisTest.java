package com.bfd;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by jinwei.li@baifendian.com on 2016/5/5.
 */
public class MybatisTest {
    SqlSessionFactory sqlSessionFactory;


    @Before
    public void setUp() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        sqlSessionFactory.getConfiguration().addMapper(MDocumentCategoryMapper.class);
    }

    @Test
    public void testSingleSelect() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
           List list =  session.selectList("queryUserByCondition");
            list.forEach(o->{
                System.out.println(o);
            });
        } finally {

            session.close();
        }
    }


}
