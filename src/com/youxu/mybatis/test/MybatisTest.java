package com.youxu.mybatis.test;


import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.youxu.mybatis.mapper.UserMapper;
import com.youxu.mybatis.model.User;

public class MybatisTest {

	private SqlSessionFactory sqlSessionFactory = null;
	
	@Before
	public void init() throws Exception {
		// 1. 创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 2. 加载SqlMapConfig.xml配置文件
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		// 3. 创建SqlSessionFactory对象
		this.sqlSessionFactory = sessionFactoryBuilder.build(is);
	}
	
	@Test
	public void test1() throws Exception {
		// 4. 创建SqlSession对象
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// 5. 执行SqlSession对象执行查询，获取结果User
		// 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		Object user = sqlSession.selectOne("queryUserById", 1);
		
		System.out.println(user);
		
		List<Object> selectList = sqlSession.selectList("queryUser");
		
		System.out.println(selectList);
		
		sqlSession.commit();
		
		sqlSession.close();
		
	}
	
	@Test
	public void test2() throws Exception {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();

		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		User user = mapper.queryUserById(1);
		
		System.out.println(user);
		
		List<User> userList = mapper.queryUser();
		
		System.out.println(userList);
		
		sqlSession.commit();
		
		sqlSession.close();
		
	}
	
}
