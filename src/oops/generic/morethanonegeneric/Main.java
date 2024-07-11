package oops.generic.morethanonegeneric;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>();
        pair.put("a", 1);
        pair.printPair();
    }
}


