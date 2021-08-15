package org.lin.service;

import org.lin.bean.User;

import java.util.List;

public interface UserService {

  public Integer login(User user);

  public int addUser(User user);

  public int deleteUser(int id);

  public int editUser(User user);

  public List<User> getAllUser();
}
