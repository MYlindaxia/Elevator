package org.lin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.lin.bean.Token;
import org.lin.bean.User;
import org.lin.mapper.TokenMapper;
import org.lin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;
  @Autowired
  private TokenMapper tokenMapper;
  ObjectMapper mapper = new ObjectMapper();

  @PostMapping(value = "/login",produces = "application/json;charset=utf-8")
  public String login(@RequestBody User user) throws JsonProcessingException {

    Map<String,Object> map = new HashMap<>();
    String token = null;
    Integer login = userService.login(user);
    if(login != 0) {
       token = UUID.randomUUID() + "";
       token = DigestUtils.md5Hex(token + "0123456789");
       token = DigestUtils.sha1Hex(token+"9876543210");
    }

    Token token1 = new Token(token, user.getUserName());
    Integer integer = tokenMapper.addToken(token1);
    map.put("token",token);
    map.put("login",login);
    String s = mapper.writeValueAsString(map);
    return s;
  }

  @DeleteMapping("/{userId}")
  public String delete(@PathVariable("userId") int userId) throws JsonProcessingException {
    int i = userService.deleteUser(userId);
    String s = mapper.writeValueAsString(i);
    return s;
  }

  @GetMapping("/getAll")
  public String getAllUser() throws JsonProcessingException {
    List<User> allUser = userService.getAllUser();
    String s = mapper.writeValueAsString(allUser);
    return s;
  }

  @PutMapping(value = "/update",produces = "application/json")
  public String updateUser(@RequestBody User user) throws JsonProcessingException {
    int i = userService.editUser(user);
    String s = mapper.writeValueAsString(i);
    return s;
  }

  @PostMapping(value = "/add",produces = "application/json")
  public String add(@RequestBody User user) throws JsonProcessingException {
    int i = userService.addUser(user);
    String s = mapper.writeValueAsString(i);
    return s;
  }
}
