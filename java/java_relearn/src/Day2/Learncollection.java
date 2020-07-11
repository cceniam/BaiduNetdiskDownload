package day2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Learncollection {
    public static void main(String[] args) {
//        创建hashset
        Collection<String> collection = new HashSet<String>();
//        检查是否非空
        System.out.println(collection.isEmpty());
//        添加元素
        collection.add("一号");
//        输出size
        System.out.println(collection.size());
//        toString
        System.out.println(collection.toString());
        System.out.println(collection.size());
//        创建迭代器
        Iterator<String> iterator = collection.iterator();
//        遍历并打印
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
