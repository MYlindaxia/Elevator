package org.lin.service;

import org.lin.bean.User;
import org.lin.mapper.TokenMapper;
import org.lin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService{

  @Autowired
  private UserMapper userMapper;
  @Autowired
  private TokenMapper tokenMapper;

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
  public int addUser(User user, String token) {
    Integer power = tokenMapper.realGetPowerByToken(token);
    if(power == 0) {
      return userMapper.addUser(user);

    }else {
      return 0;
    }
  }

  @Override
  public int deleteUser(int id, String token) {

    Integer power = tokenMapper.realGetPowerByToken(token);
    if(power == 0) {
      return userMapper.deleteUser(id);
    }else {
      return 0;
    }
  }

  @Override
  public int editUser(User user, String token) {

    Integer power = tokenMapper.realGetPowerByToken(token);
    if(power == 0) {
      return userMapper.editUser(user);
    }else {
      return 0;
    }
  }

  @Override
  public List<User> getAllUser(){
    return userMapper.getAllUser();
  }
}
