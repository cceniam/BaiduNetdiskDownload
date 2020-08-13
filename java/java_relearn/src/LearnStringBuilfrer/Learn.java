package LearnStringBuilfrer;

public class Learn {
    public static void main(String[] args) {
//        创建StringBuilder， 目的，提高拼接效率
        StringBuilder test = new StringBuilder();
//        append方法将参数拼接到内部的字符数组中，返回this
        test.append("世界");
//        因为返回this，所以可以拼接使用
        test.append("和平").append("这是我的").append("心愿");
        System.out.printf(test.toString());
    }
}
