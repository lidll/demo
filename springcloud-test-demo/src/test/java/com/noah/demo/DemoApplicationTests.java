package com.noah.demo;

import com.noah.demo.domain.UserDO;
import com.noah.demo.service.UserService;
import com.noah.demo.tools.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        String s = "-1-2-3-4-5-";
        String[] split = s.split("-");
        System.out.println(split[split.length - 1]);
    }

    @Test
    public void createUser(){
        UserDO userDO = new UserDO();
        userDO.setAge(20);
        userDO.setName("张大佬");
        userDO.setCreateDate(new Date());
    }

    @Test
    public void arrayCompare(){
        String[] array1 = new String[]{"1","2","4","1","0"};
        String[] array2 = new String[]{"2","1","0","4","1"};
        Arrays.sort(array1);
        Arrays.sort(array2);
        System.out.println(Arrays.equals(array1,array2));
    }

    @Test
    public void subString(){
        String s = "12345,";
        s = s.substring(0,s.length() -1);
        System.out.println(s);
    }

    @Test
    public void testException(){
        String[] strings = new String[1];
        try {
            strings[3] = "";
        } catch (Exception e){
            if (e instanceof IndexOutOfBoundsException){
                System.out.println("空指针异常");
            }else{
                System.out.println("其他异常");
            }

        }
    }

    @Test
    public void testStringBufferd(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        stringBuffer.append("b");
        stringBuffer.append("c");
        String join = StringUtils.join(stringBuffer, ",");
        System.out.println(join);

        String[] str = new String[3];
        str[0] = "1";
        str[1] = "2";
        str[2] = "3";
        String join1 = StringUtils.join(str, ",");
        System.out.println(join1);
    }
}
