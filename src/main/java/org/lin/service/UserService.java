package org.lin.service;

import org.lin.bean.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

  public Integer login(User user);

  public int addUser(User user, String token);

  public int deleteUser(int id, String token);

  public int editUser(User user, String token);

  public List<User> getAllUser();
}
