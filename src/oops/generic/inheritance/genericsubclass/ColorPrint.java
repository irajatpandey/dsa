package oops.generic.inheritance.genericsubclass;

import oops.generic.inheritance.nongenericsubclass.Print;

public class ColorPrint<T> extends Print<T> {
    public void print(){
        System.out.println("Print");
    }
}



