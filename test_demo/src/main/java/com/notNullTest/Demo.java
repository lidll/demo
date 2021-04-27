package com.notNullTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.*;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author noah
 * @Date 2020-09-17 15:07
 * @Version 1.0
 **/
public class Demo {

    public static Map<String,String> deptNameAndDeptId = new HashMap<>();

    public static Map<String,String> deptIdAndDeptName = new HashMap<>();

    public static Map<String,String> deptIdAndParentDeptId = new HashMap<>();

    public static Map<String,String> idAndLocation = new HashMap<>();

    public static String downloadUrl = "https://www.hbezxn.cn/evaluation-manager-api/whpy/manage/deptSetting/getAllQrCode/%s/1";

    public static String authorization = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImFkbWluIn0.JWHhz0coI-SYyInjtUdxGTfb7YMkPZp9QvT8PquPYrg";

    public static String path = "/Users/noah/Desktop/";

    public static void main(String[] args){
        //整理基础参数
        buildMap();
        //获取拼接文件名
        getTargetIdAndFileTitle();
        //下载保存
        Set<Map.Entry<String, String>> entries = idAndLocation.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String result = HttpUtil.downloadPic(String.format(downloadUrl,key), authorization);
            JSONObject jsonObject = JSONObject.parseObject(result);

            if (jsonObject.get("code") != null && "200".equals(jsonObject.get("code").toString())) {
                if (jsonObject.get("obj") != null) {
                    String base64 = jsonObject.get("obj").toString().split(",")[1];
                    String value = entry.getValue();
                    String dirPath = value.substring(0, value.lastIndexOf("/"));
                    File file = new File(path + dirPath);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    PicUtil.GenerateImage(base64,path + value + ".img");
                }
            }
        }
    }



    public static void getTargetIdAndFileTitle(){
        String[] nameArr = TargetDeptCon.DEPT_NAME.split(",");
        List<String> nameList = Arrays.asList(nameArr);
        for (String name : nameList) {
            String ids = deptNameAndDeptId.get(name);
            if (ids != null && ids.contains(",")) {
                //名称重复,拼接id
                String[] idArr = ids.split(",");
                for (String id : idArr) {
                    String location = getLocation(id);
                    System.out.println(location);
                    idAndLocation.put(id,location);
                }
            }else{
                //名称不重复,单id
                String location = getLocation(ids);
                System.out.println(location);
                idAndLocation.put(ids,location);
            }
        }
    }

    public static String getLocation(String id){
        LinkedList<String> location = new LinkedList<>();
        String currentName = deptIdAndDeptName.get(id);
        location.addFirst(currentName);
        while (true){
            String parentId = deptIdAndParentDeptId.get(id);
            if (parentId != null) {
                id = parentId;
                String deptName = deptIdAndDeptName.get(id);
                location.addFirst(deptName);
            }else {
                break;
            }
        }
        //拼接文件名
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < location.size(); i++) {
            stringBuffer.append(location.get(i));
            if (i != location.size() -1){
                stringBuffer.append("/");
            }
        }
        return stringBuffer.toString();
    }

    public static void buildMap(){
        JSONObject jsonObject = JSON.parseObject(OriginDeptCon.deptJSON);
        Object children = jsonObject.get("children");
        String text = jsonObject.get("text").toString();
        String id = jsonObject.get("id").toString();
        deptIdAndDeptName.put(id,text);
        getChirden(JSONObject.parseArray(children.toString()));
        System.out.println("deptNameAndDeptId:" +deptNameAndDeptId.size());
        System.out.println("deptIdAndDeptName:" +deptIdAndDeptName.size());
        System.out.println("deptIdAndParentDeptId:" +deptIdAndParentDeptId.size());
    }

    public static void getChirden(JSONArray jsonArray){
        for (Object o : jsonArray) {
            JSONObject jsonObject = JSONObject.parseObject(o.toString());
            String text = jsonObject.get("text").toString();
            String id = jsonObject.get("id").toString();
            String parentId = jsonObject.get("parentId").toString();
            deptIdAndDeptName.put(id,text);
            deptIdAndParentDeptId.put(id,parentId);
            if (deptNameAndDeptId.get(text) != null) {
                id = deptNameAndDeptId.get(text) + "," + id;
            }
            deptNameAndDeptId.put(text,id);
            if (jsonObject.get("children") != null) {
                Object children = jsonObject.get("children");
                getChirden(JSONObject.parseArray(children.toString()));
            }
        }
    }
}
