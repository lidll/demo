package com.noah.demo.cache;

import com.noah.demo.domain.UserDO;
import com.noah.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @ClassName CacheTestServiceImpl
 * @Description TODO
 * @Author noah
 * @Date 2019-06-05 17:17
 * @Version 1.0
 **/
@Component
public class CacheTestServiceImpl implements CacheTestService{

    @Autowired
    private UserService userService;

    @Override
    @Cacheable("Users")
    public UserDO getByName(Long id){
        ThreadSleep();
        UserDO user = userService.getUser(id);
        return user ;
    }

    private void ThreadSleep(){
        try {
            Long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
