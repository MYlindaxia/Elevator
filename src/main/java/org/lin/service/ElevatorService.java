package org.lin.service;

import org.apache.ibatis.annotations.Param;
import org.lin.bean.Elevator;

import java.util.List;

public interface ElevatorService {
  public List<Elevator> getAllElevator();

  public List<Elevator> getElevatorByName(String elevatorName);

  public Elevator getElevatorById(int elevatorId);

  public int eidtElevatorById(Elevator elevator);

  public int deleteElevatorById(int elevatorId);

  public int addElevator(String elevatorName);
}
