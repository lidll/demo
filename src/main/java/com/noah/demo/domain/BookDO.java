package com.noah.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName BookDO
 * @Description TODO
 * @Author noah
 * @Date 2019-06-05 16:12
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class BookDO {
    private String title;
    private String type;
}
