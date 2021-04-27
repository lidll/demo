package com.notNullTest;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName DemoDO
 * @Description TODO
 * @Author noah
 * @Date 3/4/21 5:01 PM
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class DemoDO {

    public Integer id;
    private Integer parentId;
    private String location;

}
