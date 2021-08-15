package org.lin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lin.bean.User;

import java.util.List;

@Mapper
public interface UserMapper {
  public Integer login(@Param("user") User user);

  public int addUser(@Param("user") User user);

  public int editUser(@Param("user") User user);

  public int deleteUser(@Param("userId") int userId);

  public int getPower(@Param("userName") String username);

  public List<User> getAllUser();
}
