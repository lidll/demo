package com.notNullTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName ForDemo
 * @Description 部门排重,保留唯一父级,去除父级下的所有子集
 * @Author noah
 * @Date 3/1/21 10:34 AM
 * @Version 1.0
 **/
public class ForDemo {

    public static void main(String[] args) {
        ArrayList<String> deptList = new ArrayList<>();
        deptList.add("-1-2-");
        deptList.add("-2-3-");
        deptList.add("-2-3-4");
        deptList.add("-2-3-3");
        deptList.add("-1-3-5");
        deptList.add("-1-3-");
        deptList.add("-1-");
        deptList.add("-1-5-");
        deptList.add("-1-5-6-");
        deptList.add("-1-6-");


        HashSet<String> finalDeptList = new HashSet<>();

        List<String> depts = deptList.stream().sorted(Comparator.comparing(String::toString)).collect(Collectors.toList());
        System.out.println(depts);

        ArrayList<String> deptCopy = new ArrayList<>();
        deptCopy.addAll(depts);
        for (int i = 0; i < depts.size(); i++) {
            String out = depts.get(i);
            for (int i1 = 0; i1 < depts.size(); i1++) {
                String in = depts.get(i1);
                if (!in.equals(out) && in.startsWith(out)) {
                    deptCopy.remove(in);
                }
            }
        }

        System.out.println(deptCopy);

    }

    public void filterDept(ArrayList<String> deptList){
        ArrayList<String> deptList2 = new ArrayList<>();
        deptList2.addAll(deptList);
        for (String dept : deptList) {
            if (deptList2.contains(dept)) {

            }

        }
    }
}
