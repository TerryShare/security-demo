package com.xdclass.web.async;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * Greated by Terry on 2019/4/19
 * Time: 4:00
 */
@RestController
public class AsyncController {
    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private MockQuery mockQuery;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @RequestMapping("order")
    public DeferredResult<String> order() throws Exception {
        logger.info("主线程开始");
        String orderNumber=RandomStringUtils.randomNumeric(8);
        mockQuery.setPlaceOrder(orderNumber);

        DeferredResult<String> result=new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber,result);
 //       Callable<String> result=new Callable<String>() {
        //           @Override
        //  public String call() throws Exception {
        //      logger.info("副线程开始");
        //      Thread.sleep(1000);
        //      logger.info("副线程返回");
        //      return "SUCCESS";
        //  }
        //};
        logger.info("主线程返回");
        return result;
    }
}
