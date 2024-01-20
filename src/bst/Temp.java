package bst;

import mylib.*;

public class Temp {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        MyLibrary<Integer> s = new MyLibrary<>();
        System.out.println(a + " " + b);
        s.swap(a, b);
        System.out.println(a + " " + b);
    }
}
