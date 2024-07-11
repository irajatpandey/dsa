package oops.generic.inheritance.nongenericsubclass;

public class Main {
    public static void main(String[] args) {
        ColorPrint obj = new ColorPrint();
        obj.setPrintValues("Red");
        System.out.println(obj.getPrintValues());
        obj.print();
    }
}
