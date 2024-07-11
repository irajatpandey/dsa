package oops.generic.inheritance.genericsubclass;

import oops.generic.inheritance.nongenericsubclass.ColorPrint;

public class Main {
    public static void main(String[] args) {
        ColorPrint obj = new ColorPrint();
        obj.setPrintValues("Orange");
        System.out.println(obj.getPrintValues());
        obj.print();
    }
}
