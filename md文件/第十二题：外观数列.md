# 第十二题： 外观数列

## 题目：

- 外观数列为整数序列

- 序列中的每一项都是对前一项的描述
- $\left. \begin{array} { l l } { 1 . } & { 1 } \\ { 2 . } & { 11 } \\ { 3 . } & { 21 } \\ { 4 . } & { 1211 } \\ { 5 . } & { 111221 } \end{array} \right.$
- $\text { 1 被读作 " one 1" （"一个一”）,即 11 }$

- $\text { 11 被读作 "two 1s"（"两个一"）, 即 21。 }$

- $\left. \begin{array} { l } { 21 \text { 被读作 one } 2 ^ { n } , \text { one } 1 ^ { n } } \\ { \text { 即 } 1211 } \end{array} \right.$

- 给定一个整数$n ( 1 \leq n \leq 30 )$输出外观数列第n项

## 思路：

- 生成外观数列`as`前三十项
  - as[0]==1;
  - 拆分上一项数字每一位
    - 如果等于某一数字
      - 查找这一数字个数输出n{数字}
      - 当这一个不等于前一个时重新计数
- 根据整数输出外观数列第n项

## 解析：

就java来讲，可以借助StringBuilder来实现对前一项的描述。可以得到如下描述步骤：

- 使用指针 i 和 指针 j 来对需要描述的字符 str 进行遍历，指针 i 指向 指针 j 的下一个位置，即 i = j + 1
- 若 str.charAt(i) == str.charAt(j)时，指针 i 继续移动
- 若 str.charAt(i) != str.charAt(j), 则把描述添加到StringBuilder中，stringBuilder.append(i -j).append(str.charAt(j))，其中 i - j 表示str.charAt(j) 元素的个数，并且指针 j 进行跳转，j = i
- 推出循环后，还需要对末尾字符进行描述
- 当前项的描述完成后，str = stringBuilder.toString()，将 j 回退为 0 以便对新的字符串进行描述 ，并且StringBuilder清空
  因为只需要知道前一个就可以进行描述 — 要得到n项, 只需要知道n-1项，所以也可以使用递归来进行求解。结束条件为 n = 1时，返回 "1"。代码也附在了后面。

## 代码：

```java
class Solution {
    public  String countAndSay(int n) {
        // 只需要知道前一个就可以进行描述 - 要得到n项, 只需要知道n-1项
        String str = "1"; // 存储前一项所描述的信息
        StringBuilder stringBuilder = new StringBuilder();
        int i, j = 0;
        for(int k = 1; k < n; k++){
            for(i = j + 1; i < str.length(); i++){
                if (str.charAt(i) != str.charAt(j)){
                    // 进行添加
                    stringBuilder.append(i - j).append(str.charAt(j));
                    j = i;
                }
            }
            // 处理只有一个元素和最后一个元素
            stringBuilder.append(i - j).append(str.charAt(j));
            j = 0;
            str = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
        }
        System.out.println(str);
        return str;
    }
}
```

- 迭代

- ```java
  private static StringBuilder stringBuilder = new StringBuilder(); // 用来存储描述信息
  public static String countAndSay(int n) {
      int i, j = 0;
      // 结束条件
      if (n == 1)
          return "1";
      String str = countAndSay(n - 1);
      for(i = j + 1; i < str.length(); i++){
          if (str.charAt(i) != str.charAt(j)){
              // 进行添加
              stringBuilder.append(i - j).append(str.charAt(j));
              j = i;
          }
      }
      // 处理只有一个元素和最后一个元素
      stringBuilder.append(i - j).append(str.charAt(j));
      str = stringBuilder.toString();
      stringBuilder.delete(0, stringBuilder.length());
      return str;
  }
  ```

````java
class Solution {
    public String countAndSay(int n) {
        String[] dp = new String[n] ;
        dp[0] = "1" ;
        StringBuilder sb = new StringBuilder() ;
        for(int i = 1 ; i < n ; i++){
            int count = 1 ;
            sb = new StringBuilder() ;
            char[] ss = dp[i-1].toCharArray() ;
            int len = ss.length ;
            for(int j = 0 ; j < len - 1 ; j++){
                if(ss[j] == ss[j+1]){
                    count++ ;
                    continue ;
                }
                sb.append(String.valueOf(count)).append(ss[j]) ;
                count = 1 ;   
            }
            sb.append(String.valueOf(count)).append(ss[len-1]) ;
            dp[i] = sb.toString() ;
        }
        return dp[n-1] ;
    }
}
````



##  复杂度分析：

- 时间复杂度：$O(n)$
- 空间复杂度：O(n)

## stringBuilder类

- String类是不可变类，即一旦一个String对象被创建以后，包含在这个对象中的字符序列是不可改变的，直至这个对象被销毁。

- StringBuffer对象则代表一个字符序列可变的字符串，当一个StringBuffer被创建以后，通过StringBuffer提供的append()、insert()、reverse()、setCharAt()、setLength()等方法可以改变这个字符串对象的字符序列。一旦通过StringBuffer生成了最终想要的字符串，就可以调用它的toString()方法将其转换为一个String对象。
- StringBuilder类也代表可变字符串对象。实际上，StringBuilder和StringBuffer基本相似，两个类的构造器和方法也基本相同。不同的是：**StringBuffer是线程安全的，而StringBuilder则没有实现线程安全功能，所以性能略高。**
- Java9改进了字符串（包括String、StringBuffer、StringBuilder）的实现。在Java9以前字符串采用char[]数组来保存字符，因此字符串的每个字符占2字节；而Java9的字符串采用byte[]数组再加一个encoding-flag字段来保存字符，因此字符串的每个字符只占1字节。所以Java9的字符串更加节省空间，字符串的功能方法也没有受到影响。
- [原文链接](<https://blog.csdn.net/csxypr/article/details/92378336>)       [菜鸟教程链接](<<https://www.runoob.com/java/java-stringbuffer.html>>)

