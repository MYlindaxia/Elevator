//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.lin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.lin.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

public class BaseInterceptor implements HandlerInterceptor {
  @Autowired
  private TokenMapper tokenMapper;

  public BaseInterceptor() {
  }

  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    System.out.println(request.getMethod());
    if(request.getMethod().equals("OPTIONS")) {
      System.out.println("跳过");
      return true;
    }

    String token = request.getHeader("token");
    if (token == null) {
      return false;
    } else {
      Integer check = this.tokenMapper.check(token);
      boolean result = (check != null);
      return result;
    }
  }
}
