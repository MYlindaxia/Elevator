package org.lin.service;

import org.lin.bean.Elevator;
import org.lin.mapper.ElevatorMapper;
import org.lin.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElevatorServiceImp implements ElevatorService{

  @Autowired
  private ElevatorMapper elevatorMapper;
  @Autowired
  private TokenMapper tokenMapper;

  @Override
  public List<Elevator> getAllElevator() {
    return elevatorMapper.getAllElevator();
  }

  @Override
  public List<Elevator> getElevatorByName(String elevatorName) {
    return elevatorMapper.getElevatorByName(elevatorName);
  }

  @Override
  public Elevator getElevatorById(int elevatorId) {
    return elevatorMapper.getElevatorById(elevatorId);
  }

  @Override
  public int eidtElevatorById(Elevator elevator,String token) {
    Integer power = tokenMapper.realGetPowerByToken(token);

    if(power == 0) {
      return elevatorMapper.eidtElevatorById(elevator);
    }else {
      return 0;
    }
  }

  @Override
  public int deleteElevatorById(int elevatorId,String token) {
    Integer power = tokenMapper.realGetPowerByToken(token);

    if(power == 0) {
      return elevatorMapper.deleteElevatorById(elevatorId);
    }else {
      return 0;
    }
  }

  @Override
  public int addElevator(String elevatorName,String token) {
    Integer power = tokenMapper.realGetPowerByToken(token);

    if(power == 0) {
      return elevatorMapper.addElevator(elevatorName);
    }else {
      return 0;
    }
  }
}
