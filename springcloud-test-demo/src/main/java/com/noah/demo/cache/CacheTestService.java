package com.noah.demo.cache;

import com.noah.demo.domain.UserDO;

/**
 * @ClassName CacheTestService
 * @Description TODO
 * @Author noah
 * @Date 2019-06-05 17:38
 * @Version 1.0
 **/
public interface CacheTestService {
    UserDO getByName(Long id);
}
