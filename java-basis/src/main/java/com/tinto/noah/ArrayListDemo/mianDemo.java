package com.tinto.noah.ArrayListDemo;

/**
 * @ClassName mianDemo
 * @Description TODO
 * @Author noah
 * @Date 1/29/21 2:49 PM
 * @Version 1.0
 **/
public class mianDemo {
    public static void main(String[] args) {
        String Str = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIzMzcyMjc3MTM4MTE1Nzg4OCIsInVzZXJJZCI6IjEyMzQ1Njc4OSIsIm5hbWUiOiLotoXnuqfnrqHnkIblkZgiLCJjb3JwaWQiOiJwb2xpdGljYWxFZHVjYXRpb24iLCJ0ZXJtaW5hbCI6MSwiZXhwIjoxNjEyMzU3Mzc0fQ.MPvk2nnOsg_F7Nr1iVEb23WyxHix2OLagcWr-hqKuIbn2iKexUR-uDAZUMmgG0dkr4Uzdekrs_cskwj3bDo0pb05f2j-T31hcvkAl0juUySC4DbVUvDza7f8PrW_c8PB1-j2YOH0TQlBqLZ-bxwTX3HW9Du79jTPNUAYd0nU384";
        int i = Str.indexOf(".");
        System.out.println(i);
        String[] split = Str.split("\\.");
        for (int i1 = 0; i1 < split.length; i1++) {
            System.out.println(split[i1]);
        }
    }


}
