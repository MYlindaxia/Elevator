package org.lin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.lin.bean.Menu;
import org.lin.mapper.MenuMapper;
import org.lin.service.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/menu")
public class MenuController {

  @Autowired
  private MenuMapper menuMapper;
  ObjectMapper mapper = new ObjectMapper();
  @Autowired
  private MenuServiceImp menuServiceImp;

  @RequestMapping("/getMenu/{order}")
  public String getMenu(@PathVariable("order") int order) throws JsonProcessingException {
    List<Menu> menu = menuMapper.getMenu(order);
    String json = mapper.writeValueAsString(menu);
    return json;
  }

  @RequestMapping("/getMenuByToken")
  public String getMenuByToken(HttpServletRequest request) throws JsonProcessingException {
    String token = request.getHeader("token");
    List<Menu> menuByToken = menuServiceImp.getMenuByToken(token);
    String s = mapper.writeValueAsString(menuByToken);
    return s;
  }
}
