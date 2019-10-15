//package com.noah.demo.cache;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
///**
// * @ClassName AppRunner
// * @Description TODO
// * @Author noah
// * @Date 2019-06-05 17:33
// * @Version 1.0
// **/
//@Component
//public class AppRunner implements CommandLineRunner {
//
//    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);
//
//    private final CacheTestService cacheTestService;
//
//    public AppRunner(CacheTestService cacheTestService){
//        this.cacheTestService = cacheTestService;
//    }
//    @Override
//    public void run(String... args) {
//        new Thread(){
//            @Override
//            public void run(){
//                logger.info(".... Fetching books");
//                logger.info("isbn-1 -->" + cacheTestService.getByName(1L));
//                logger.info("isbn-2 -->" + cacheTestService.getByName(2L));
//                logger.info("isbn-3 -->" + cacheTestService.getByName(1L));
//                logger.info("isbn-4 -->" + cacheTestService.getByName(2L));
//                logger.info("isbn-5 -->" + cacheTestService.getByName(1L));
//                logger.info("isbn-6 -->" + cacheTestService.getByName(2L));
//            }
//        }.start();
//    }
//}
