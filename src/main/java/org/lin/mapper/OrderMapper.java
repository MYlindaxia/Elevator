package org.lin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lin.bean.Order;

import java.util.List;

@Mapper
public interface OrderMapper {

  public List<Order> getAllOrder();

  public Order getOrderById(@Param("orderId") int orderId);

  public List<Order> getOrderByelevatorId(@Param("elevatorId") int id);

  public List<Order> getOrderByVillage(@Param("createVillage") String village);

  public List<Order> getOrderByProblem(@Param("problem") String problem);

  public List<Order> getOrderByResult(@Param("result") int result);

  public int addOrder(@Param("order") Order order);

  public int editOrder(@Param("order") Order order);

  public int deleteOrder(@Param("orderId") int orderId);

  public List<Order> getOrderByLimit(@Param("page") int page,@Param("size") int size);
}
