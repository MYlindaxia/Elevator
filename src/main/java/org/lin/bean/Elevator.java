package org.lin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Elevator {
  /**
   * 电梯Id
   */
  private Integer elevatorId;

  /**
   *电梯名字
   */
  private String elevatorName;
}

