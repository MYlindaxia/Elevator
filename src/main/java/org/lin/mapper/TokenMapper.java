package org.lin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lin.bean.Token;

@Mapper
public interface TokenMapper {
  public Integer check(@Param("token") String token);

  public Integer addToken(@Param("token")Token token);

  public String getPowerByToken(@Param("tokenValue") String token);

  public Integer realGetPowerByToken(@Param("token") String token);
}
