package com.youxu.mybatis.test;


import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.youxu.mybatis.mapper.UserMapper;
import com.youxu.mybatis.model.QueryVo;
import com.youxu.mybatis.model.User;

public class MybatisTest2 {

	private SqlSessionFactory sqlSessionFactory = null;
	
	@Before
	public void init() throws Exception {
		// 1. 创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 2. 加载SqlMapConfig.xml配置文件
		InputStream is = Resources.getResourceAsStream("sqlMapConfig2.xml");
		// 3. 创建SqlSessionFactory对象
		this.sqlSessionFactory = sessionFactoryBuilder.build(is);
	}
	
	@Test
	public void test1() throws Exception {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();

		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		User user = mapper.queryUserById(1);
		
		System.out.println(user);
		
		List<User> userList = mapper.queryUser();
		
		System.out.println(userList);
		
		sqlSession.commit();
		
		sqlSession.close();
		
	}
	
	@Test
	public void test2() throws Exception {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();

		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		QueryVo queryVo = new QueryVo();
		
		User user = new User();
		
		user.setNick("tom1");
		
		queryVo.setUser(user);
			
		List<User> userList = mapper.queryUserByQueryVo(queryVo);
		
		System.out.println(userList);
		
		sqlSession.commit();
		
		sqlSession.close();
	}
	
}
