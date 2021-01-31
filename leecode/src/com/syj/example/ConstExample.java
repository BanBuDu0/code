package com.syj.example;

public class ConstExample {

    static class A {
        public static final String aa = "123";// 定义一个常量aa

        public static String bb = "321";// 定义一个静态变量bb

        public String cc = "666";// 定义一个变量cc

    }

    public static void main(String[] args) {
        A a = new A();
        A b = new A();

        System.out.println("a.aa.value =" + a.aa);
        System.out.println("b.aa.value =" + b.aa);

        System.out.println("========================");
        System.out.println("a.bb.value =" + a.bb);
        System.out.println("b.bb.value =" + b.bb);

        System.out.println("#########################");
        a.bb = "654321";
        System.out.println("a.bb.value =" + a.bb);
        System.out.println("b.bb.value =" + b.bb);

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%");
        b.bb = "123456";
        b.cc = "12312321";
        System.out.println("a.bb.value =" + a.bb);
        System.out.println("b.bb.value =" + b.bb);
        System.out.println("a.cc.value =" + a.cc);
        System.out.println("b.cc.value =" + b.cc);
    }


}
