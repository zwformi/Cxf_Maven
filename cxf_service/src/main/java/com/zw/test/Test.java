package com.zw.test;

import com.zw.webservice.Hello;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * Created by Administrator on 2017/5/27.
 */
public class Test {
   public static void main(String[] args){

       // 创建WebService客户端代理工厂
       JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
       // 判断是否抛出异常
       factory.getOutInterceptors().add(new LoggingInInterceptor());
       // 注册webservice接口
       factory.setServiceClass(Hello.class);
       // 配置webservice地址
       factory.setAddress("http://localhost:8080/service/Hello?wsdl");
       // 获得接口对象
       Hello service = (Hello) factory.create();
       // 调用接口方法
       String result = service.say("zzw");
       System.out.println("调用结果:" + result);
       // 关闭接口连接
       System.exit(0);
   }
}
