package org.lin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class User {
  /**
   * 用户id
   */
  private Integer userId;

  /**
   * 用户名称
   */
  private String userName;

  /**
   * 用户密码
   */
  private String userPwd;

  /**
   *
   */
  private Integer userPower;

  public User(String userName, String userPwd, Integer userPower) {
    this.userName = userName;
    this.userPwd = userPwd;
    this.userPower = userPower;
  }

  public User(String userName, String userPwd) {
    this.userName = userName;
    this.userPwd = userPwd;
  }
}

