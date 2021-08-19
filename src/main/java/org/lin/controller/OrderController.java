package org.lin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.lin.bean.Order;
import org.lin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/order", produces = "application/json;charset=UTF-8")
public class OrderController {

  @Autowired
  private OrderService orderService;
  ObjectMapper mapper = new ObjectMapper();
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @GetMapping("/getAll")
  public String getAllOrder(Model model) throws JsonProcessingException {
    List<Order> allOrder = orderService.getAllOrder();
    String json = mapper.writeValueAsString(allOrder);
    return json;
  }

  

  @GetMapping(value = "/orderId", produces = "application/json")
  public String getOrderById(@RequestBody Integer id) throws JsonProcessingException {
    Order orderById = orderService.getOrderById(id);
    String json = mapper.writeValueAsString(orderById);
    return json;
  }

  @GetMapping("/levatorId/{id}")
  public String getOrderBylevatorId(Model model, @PathVariable("id") int id) throws JsonProcessingException {
    List<Order> orderByelevatorId = orderService.getOrderByelevatorId(id);
    String json = mapper.writeValueAsString(orderByelevatorId);
    return json;
  }

  @GetMapping("/village/{village}")
  public String getOrderByVillage(Model model,@PathVariable("village") String village) throws JsonProcessingException {
    List<Order> orderByVillage = orderService.getOrderByVillage(village);
    String s = mapper.writeValueAsString(orderByVillage);
    return s;
  }

  @GetMapping("/problem/{problem}")
  public String getOrderByProblem(Model model,@PathVariable("problem") String problem) throws JsonProcessingException {
    List<Order> orderByProblem = orderService.getOrderByProblem(problem);
    String s = mapper.writeValueAsString(orderByProblem);
    return s;
  }

  @GetMapping("/result/{id}")
  public String getOrderByResult(Model model,@PathVariable("id") int id) throws JsonProcessingException {
    List<Order> orderByResult = orderService.getOrderByResult(id);
    String s = mapper.writeValueAsString(orderByResult);
    return s;
  }

  @PostMapping("/add")
  public String addOrder(@RequestBody Order order, HttpServletRequest request) throws ParseException, JsonProcessingException {
    String token = request.getHeader("token");
    String createTime = sdf.format(order.getCreateTime());
    int i = orderService.addOrder(order,token);
    String json = mapper.writeValueAsString(i);
//    return json;
    return "OK";
  }

  @DeleteMapping(value = "/delete/{id}")
  public String deleteOrder(@PathVariable("id") int id,HttpServletRequest request) throws JsonProcessingException {
    String token = request.getHeader("token");
    int delete = orderService.delete(id,token);
    String s = mapper.writeValueAsString(delete);
    return s;
  }

  @PutMapping("/update")
  public String updateOrder(@RequestBody Order order,HttpServletRequest request) throws ParseException, JsonProcessingException {
    String token = request.getHeader("token");
    int i = orderService.update(order,token);
    String json = mapper.writeValueAsString(i);
    return json;
  }

  @GetMapping("/getByLimit/{page}/{size}")
  public String getByLimit(@PathVariable("page") int page,@PathVariable("size") int size) throws JsonProcessingException {
    List<Order> orderByLimit = orderService.getOrderByLimit(page, size);
    String s = mapper.writeValueAsString(orderByLimit);
    return s;
  }


}
