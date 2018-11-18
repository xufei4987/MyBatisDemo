package com.youxu.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.youxu.mybatis.model.QueryVo;
import com.youxu.mybatis.model.User;

public class UserMapperImpl implements UserMapper{

	private SqlSessionFactory sqlSessionFactory;
	
	public UserMapperImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User queryUserById(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = (User) sqlSession.selectOne("queryUserById", id);
		return user;
	}

	@Override
	public List<User> queryUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> userList = sqlSession.selectList("queryUser");
		return userList;
	}

	@Override
	public List<User> queryUserByQueryVo(QueryVo queryVo) {
		// TODO Auto-generated method stub
		return null;
	}

}
