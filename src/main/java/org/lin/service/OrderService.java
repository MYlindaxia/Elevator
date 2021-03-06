package org.lin.service;

import org.apache.ibatis.annotations.Param;
import org.lin.bean.Order;

import java.util.List;

public interface OrderService {
  List<Order> getAllOrder();

  Order getOrderById(int id);

  List<Order> getOrderByelevatorId(int id);

  List<Order> getOrderByVillage(String village);

  List<Order> getOrderByProblem(String problem);

  List<Order> getOrderByResult(int result);

  int addOrder(Order order,String token);

  int update(Order order,String token);

  int delete(int orderId,String token);

  List<Order> getOrderByLimit(int page,int size);
}
