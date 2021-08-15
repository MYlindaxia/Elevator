package org.lin.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Order {
  /**
   * 订单id
   */
  private Integer orderId;

  /**
   * 出错电梯id
   */
  private Integer elevatorId;

  /**
   * 订单创建时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
  private Date createTime;

  /**
   * 订单创建小区
   */
  private String createVillage;

  /**
   * 问题
   */
  private String problem;

  /**
   * 结果
   */
  private String result;

  /**
   * 修复时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
  private Date resultTime;

  public Order(Integer elevatorId, Date createTime, String createVillage, String problem, String result, Date resultTime) {
    this.elevatorId = elevatorId;
    this.createTime = createTime;
    this.createVillage = createVillage;
    this.problem = problem;
    this.result = result;
    this.resultTime = resultTime;
  }
}

