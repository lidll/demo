package com.notNullTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName BuildLocationDemo
 * @Description TODO
 * @Author noah
 * @Date 3/4/21 5:00 PM
 * @Version 1.0
 **/
public class BuildLocationDemo {

    public static List<DemoDO> getList(){
        ArrayList<DemoDO> demoDOS = new ArrayList<>();
        demoDOS.add(new DemoDO(2,0,null));
        demoDOS.add(new DemoDO(3,1,null));
        demoDOS.add(new DemoDO(1,0,null));
        demoDOS.add(new DemoDO(4,1,null));
        demoDOS.add(new DemoDO(5,3,null));
        demoDOS.add(new DemoDO(6,2,null));
        return demoDOS;
    }

    public static void main(String[] args) {
        List<DemoDO> list = BuildLocationDemo.getList();
        ArrayList<DemoDO> demoDOS = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (DemoDO demoDO : list) {
            map.put(demoDO.getId(),demoDO.getParentId());
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer id = entry.getKey();
            Integer parentId = map.get(id);
            StringBuilder sb = new StringBuilder();
            sb.append("-" + id+  "-");
            while (parentId != null){
                sb.insert(0,"-" + parentId);
                parentId = map.get(parentId);
            }
            DemoDO demoDO = list.stream().filter(x -> x.getId().equals(id)).collect(Collectors.toList()).get(0);
            demoDO.setLocation(sb.toString());
            demoDOS.add(demoDO);
        }
        System.out.println(demoDOS.toString());
    }
}
