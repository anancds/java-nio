package com.cds.learn.passbyvalue;

/**
 * 现在根据上面的分析和测试可以知道：

 Java中字符串拼接不要直接使用 + 拼接。

 使用StringBuilder或者StringBuffer时，尽可能准确地估算capacity，并在构造时指定，避免内存浪费和频繁的扩容及复制。

 在没有线程安全问题时使用 StringBuilder ， 否则使用 StringBuffer 。

 两个字符串拼接直接调用 String.concat 性能最好。

 关于 String 的其他最佳实践：

 用 equals 时总是把能确定不为空的变量写在左边，如使用 "".equals(str) 判断空串，避免空指针异常。

 第二点是用来排挤第一点的.. 使用 str != null && str.length() != 0 来判断空串，效率比第一点高。

 在需要把其他对象转换为字符串对象时，使用 String.valueOf(obj) 而不是直接调用 obj.toString() 方法，因为前者已经对空值进行检测了，不会抛出空指针异常。

 使用 String.format() 方法对字符串进行格式化输出。

 在JDK 7及以上版本，可以在 switch 结构中使用字符串了，所以对于较多的比较，使用 switch 代替 if-else 。
 */
public class StringTest {
    public static void test() {
        String str = "";
        for (int i = 0; i < 100000; i++) {
            str += "asjdkla";
        }
    }

    public static void test1() {
        StringBuilder sb = new StringBuilder("asjdkla".length() * 100000);
        for (int i = 0; i < 100000; i++) {
            sb.append("asjdkla");
        }
        String str = sb.toString();
    }

    public static void test2() {
        String str = "";
        for (int i = 0; i < 100000; i++) {
            str.concat("asjdkla");
        }
    }

    public static void test3() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("asjdkla");
        }
        String str = sb.toString();
    }

    public static void main(String[] args) {

        long t1 = System.currentTimeMillis();
        test();
        long t2 = System.currentTimeMillis();
        System.out.println("test: " + (t2 - t1));
        test1();
        long t3 = System.currentTimeMillis();
        System.out.println("test1: " + (t3 - t2));
        test2();
        long t4 = System.currentTimeMillis();
        System.out.println("test2: " + (t4 - t3));
        test3();
        long t5 = System.currentTimeMillis();
        System.out.println("test2: " + (t5 - t4));


    }
}
