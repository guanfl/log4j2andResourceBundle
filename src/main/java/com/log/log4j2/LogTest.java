/**
* ClassName : LogTest.java
* Create on : 2016年8月10日
* Author : guanfl
* Email : guanfl@ifeng.com
* Copyright 2016 ifeng.com All Rights Reserved
*/
package com.log.log4j2;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    private static final Logger log = LoggerFactory.getLogger(Test.class);
    @Test
    public void testLog4j2(){
        log.debug("log4j debug");
    }
}
