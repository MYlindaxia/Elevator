package org.lin.service;

import org.lin.bean.User;
import org.lin.mapper.TokenMapper;
import org.lin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService{

  @Autowired
  private UserMapper userMapper;

  @Override
  public Integer login(User user) {
    Integer login = userMapper.login(user);
    if(login == null) {
      return 0;
    }else {
      return login;
    }
  }

  @Override
  public int addUser(User user) {
    return userMapper.addUser(user);
  }

  @Override
  public int deleteUser(int id) {
    return userMapper.deleteUser(id);
  }

  @Override
  public int editUser(User user) {
    return userMapper.editUser(user);
  }

  @Override
  public List<User> getAllUser(){
    return userMapper.getAllUser();
  }
}
