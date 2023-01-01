package pers.muzi.orm.core;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class MapperProxy<T> implements InvocationHandler, Serializable {

  private static final Long SERIAL_VERSION_UID = -214753344324343L;

  private final Class<T> mapperInterface;

  private Map<String, String> sqlSession;

  public MapperProxy(Class<T> mapperInterface, Map<String, String> sqlSession) {
    this.mapperInterface = mapperInterface;
    this.sqlSession = sqlSession;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (Object.class.equals(method.getDeclaringClass())) {
      return method.invoke(this, args);
    }


    return "你被代理了" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
  }
}
