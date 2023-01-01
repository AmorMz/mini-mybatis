package pers.muzi.orm.core;

import org.junit.Test;

import java.util.HashMap;

import pers.muzi.orm.UserDAO;

public class MapperProxyFactoryTest {

  @Test
  public void testProxyFactory() {
    MapperProxyFactory<UserDAO> mapperProxyFactory = new MapperProxyFactory<>(UserDAO.class);
    HashMap<String, String> sqlSession = new HashMap<>();
    sqlSession.put("pers.muzi.orm.UserDAO.selectUserNameById", " 执行Select");
    UserDAO proxy = mapperProxyFactory.createProxy(sqlSession);
    String result = proxy.selectUserNameById(1);
    System.out.println(result);
  }
}
