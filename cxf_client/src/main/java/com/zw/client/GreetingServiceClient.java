package com.zw.client;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import javax.xml.namespace.QName;

/**
 * Created by Administrator on 2017/5/27.
 */
public class GreetingServiceClient {

    public static void main(String[] args) {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf
                .createClient("http://localhost:8080/service/Hello?wsdl");
        // url为调用webService的wsdl地址
        QName name = new QName("http://webservice.zw.com/", "say");
        // namespace是命名空间，methodName是方法名
        String xmlStr = "zzzww";
        // paramvalue为参数值
        Object[] objects;
        try {
            objects = client.invoke(name, xmlStr);
            System.out.println(objects[0].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
