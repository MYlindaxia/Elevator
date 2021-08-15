package org.lin.service;

import org.lin.bean.Order;
import org.lin.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService{

  @Autowired
  private OrderMapper orderMapper;

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
  public int addOrder(Order order) {
    return orderMapper.addOrder(order);
  }

  @Override
  public int update(Order order) {
    return orderMapper.editOrder(order);
  }

  @Override
  public int delete(int orderId) {
    return orderMapper.deleteOrder(orderId);
  }

  @Override
  public List<Order> getOrderByLimit(int page, int size) {
    return orderMapper.getOrderByLimit((page-1)*size,size);
  }
}
