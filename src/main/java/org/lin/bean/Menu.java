package org.lin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
  /**
   * 菜单id
   */
  private Integer menuId;

  /**
   * 菜单名称
   */
  private String menuName;

  /**
   * 菜单写入权限
   */
  private Object menuWritePower;

  /**
   * 菜单读入权限
   */
  private Object menuReadPower;
}

