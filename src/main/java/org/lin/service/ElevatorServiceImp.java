package org.lin.service;

import org.lin.bean.Elevator;
import org.lin.mapper.ElevatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElevatorServiceImp implements ElevatorService{

  @Autowired
  private ElevatorMapper elevatorMapper;

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
  public int eidtElevatorById(Elevator elevator) {
    return elevatorMapper.eidtElevatorById(elevator);
  }

  @Override
  public int deleteElevatorById(int elevatorId) {
    return elevatorMapper.deleteElevatorById(elevatorId);
  }

  @Override
  public int addElevator(String elevatorName) {
    return elevatorMapper.addElevator(elevatorName);
  }
}
