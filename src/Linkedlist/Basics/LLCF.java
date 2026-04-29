package Basics;
import java.util.*;

public class LLCF {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        //for adding at last we can use simple add too but for adding at first we have to always
        //use the function addlast
        list.addFirst("Hello!");
        list.addLast("Coding");
        list.addLast("World");
        System.out.println(list);
        System.out.println(list.size());
//        list.removeFirst();
//        list.removeLast();
        list = list.reversed();

        System.out.println(list);
        //  list printing method
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i) + "->");
//        }
//        System.out.print("Null");
//        System.out.println();
        System.out.println(list.size());

    }
}

