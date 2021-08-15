package org.lin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.lin.bean.Elevator;
import org.lin.service.ElevatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/elevator")
public class ElevatorController {

  @Autowired
  private ElevatorService elevatorService;
  ObjectMapper mapper = new ObjectMapper();

  @RequestMapping("/getAll")
  public String getAll() throws JsonProcessingException {
    List<Elevator> allElevator = elevatorService.getAllElevator();
    String json = mapper.writeValueAsString(allElevator);
    return json;
  }

  @RequestMapping("/getByName/{name}")
  public String getByName(@PathVariable("name") String name) throws JsonProcessingException {
    List<Elevator> elevatorByName = elevatorService.getElevatorByName(name);
    String json = mapper.writeValueAsString(elevatorByName);
    return json;
  }

  @RequestMapping("/getById/{id}")
  public String getById(@PathVariable("id") int id) throws JsonProcessingException {
    Elevator elevatorByName = elevatorService.getElevatorById(id);
    String json = mapper.writeValueAsString(elevatorByName);
    return json;
  }

  @RequestMapping("/edit/{id}/{name}")
  public String edit(@PathVariable("id") int id,@PathVariable("name") String name) throws JsonProcessingException {
    Elevator elevator = new Elevator(id, name);
    int i = elevatorService.eidtElevatorById(elevator);
    String s = mapper.writeValueAsString(i);
    return s;
  }

  @RequestMapping("/del/{id}")
  public String delete(@PathVariable("id") int id) throws JsonProcessingException {
    int i = elevatorService.deleteElevatorById(id);
    String s = mapper.writeValueAsString(i);
    return s;
  }

  @RequestMapping("/add/{name}")
  public String add(@PathVariable("name") String name) throws JsonProcessingException {
    int i = elevatorService.addElevator(name);
    String s = mapper.writeValueAsString(i);
    return s;
  }





}
