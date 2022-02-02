package com.yubin.analysis.idea_debug;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        List<Integer> collect = list.stream().skip(1).limit(8).filter(x -> x.intValue() > 3).collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void print(int a) {
        int b = a + 2;
        System.out.println(b);
    }

    @Test
    public void testExceptionBreakpoint() {
        try {
            Integer a = null;
            if (true) {
                throw new NullPointerException();
            }
            System.out.println(a.intValue());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
