package com.yubin.analysis.idea_debug;

public class MainTest {

    private static boolean ready;

    public static void main(String[] args) {
        System.out.println("行断点");

        ready = true;
        System.out.println("ready 设置为true时进入字段断点, 程序停在修改字段值的那一行");
        if (ready) {
            System.out.println("字段断点在被访问时触发了断点");
        }
        print(2);
    }

    private static void print(int a) {
        int b = a + 2;
        System.out.println(b);
    }
}
