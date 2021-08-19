package org.lin.service;

import org.lin.bean.Order;
import org.lin.mapper.OrderMapper;
import org.lin.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService{

  @Autowired
  private OrderMapper orderMapper;
  @Autowired
  private TokenMapper tokenMapper;

  @Override
  public List<Order> getAllOrder() {
    return orderMapper.getAllOrder();
  }

  @Override
  public Order getOrderById(int id) {
    return orderMapper.getOrderById(id);
  }

  @Override
  public List<Order> getOrderByelevatorId(int id) {
    return orderMapper.getOrderByelevatorId(id);
  }

  @Override
  public List<Order> getOrderByVillage(String village) {
    return orderMapper.getOrderByVillage(village);
  }

  @Override
  public List<Order> getOrderByProblem(String problem) {
    return orderMapper.getOrderByProblem(problem);
  }

  @Override
  public List<Order> getOrderByResult(int result) {
    return orderMapper.getOrderByResult(result);
  }

  @Override
  public int addOrder(Order order,String token) {
    Integer power = tokenMapper.realGetPowerByToken(token);
    if(power == 0) {
      return orderMapper.addOrder(order);
    }else {
      return 0;
    }
  }

  @Override
  public int update(Order order,String token) {

    Integer power = tokenMapper.realGetPowerByToken(token);
    if(power == 0) {
      return orderMapper.editOrder(order);
    }else {
      return 0;
    }
  }

  @Override
  public int delete(int orderId,String token) {

    Integer power = tokenMapper.realGetPowerByToken(token);
    if(power == 0) {
      return orderMapper.deleteOrder(orderId);
    }else {
      return 0;
    }
  }

  @Override
  public List<Order> getOrderByLimit(int page, int size) {
    return orderMapper.getOrderByLimit((page-1)*size,size);
  }
}
