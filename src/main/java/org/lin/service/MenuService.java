package org.lin.service;


import org.lin.bean.Menu;

import java.util.List;

public interface MenuService {

  public List<Menu> getMenu(Integer order);

  public int getPower(String token);

  public List<Menu> getMenuByToken(String token);
}
