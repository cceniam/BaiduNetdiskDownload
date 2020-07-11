package day2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Lucifer
 */
public class LearnList {
    public static void main(String[] args) {
//        创建ArrayList集合
        List<String> list = new ArrayList<String>();
//        添加元素
        list.add("yahoo");
        list.add("eras");
//        遍历
        for(String s : list){
            System.out.println(s);
            System.out.println(list.indexOf(s));

        }
        Collections.sort(list);
        list.remove(1);
        System.out.println(list.toString());
    }
}
