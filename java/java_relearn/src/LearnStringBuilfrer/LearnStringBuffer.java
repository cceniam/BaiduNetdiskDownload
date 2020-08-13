package LearnStringBuilfrer;

public class LearnStringBuffer {
    /**   创建StringBuffer，StringBuffer线程安全
     *     除此之外与StringBuffer相似
     */
    public static void main(String[] args) {
        StringBuffer testBuffers = new StringBuffer();
        testBuffers.append("shijie").append("heping");
        System.out.println(testBuffers.toString());
    }
}
