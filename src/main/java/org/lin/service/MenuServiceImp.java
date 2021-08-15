package org.lin.service;

import org.lin.bean.Menu;
import org.lin.mapper.MenuMapper;
import org.lin.mapper.TokenMapper;
import org.lin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImp implements MenuService{

  @Autowired
  private MenuMapper menuMapper;
  @Autowired
  private TokenMapper tokenMapper;
  @Autowired
  private UserMapper userMapper;

  @Override
  public List<Menu> getMenu(Integer order) {
    return menuMapper.getMenu(order);
  }

  @Override
  public int getPower(String token) {
    String userName = tokenMapper.getPowerByToken(token);
    int power = userMapper.getPower(userName);
    return power;
  }

  @Override
  public List<Menu> getMenuByToken(String token) {
    int power = getPower(token);
    System.out.println(power);
    List<Menu> menu = getMenu(power);
    return menu;
  }
}
