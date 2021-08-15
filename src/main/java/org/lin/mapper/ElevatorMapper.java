package org.lin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lin.bean.Elevator;

import java.util.List;

@Mapper
public interface ElevatorMapper {
  public List<Elevator> getAllElevator();

  public List<Elevator> getElevatorByName(@Param("elevatorName") String elevatorName);

  public Elevator getElevatorById(@Param("elevatorId") int elevatorId);

  public int eidtElevatorById(@Param("elevator") Elevator elevator);

  public int deleteElevatorById(@Param("elevatorId") int elevatorId);

  public int addElevator(@Param("elevatorName") String elevatorName);
}
