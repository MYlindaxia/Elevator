package org.lin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {
  /**
   * Token的Id
   */
  private Integer tokenId;

  /**
   * Token值
   */
  private String token;

  /**
   *
   */
  private String userName;


  public Token(String token, String userName) {
    this.token = token;
    this.userName = userName;
  }
}

