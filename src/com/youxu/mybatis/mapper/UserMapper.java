package com.youxu.mybatis.mapper;

import java.util.List;

import com.youxu.mybatis.model.QueryVo;
import com.youxu.mybatis.model.User;

public interface UserMapper {
	public User queryUserById(int id);
	public List<User> queryUser();
	public List<User> queryUserByQueryVo(QueryVo queryVo);
}
