package org.lin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lin.bean.Menu;

import java.util.List;

@Mapper
public interface MenuMapper {

  public List<Menu> getMenu(@Param("power") int power);

}
