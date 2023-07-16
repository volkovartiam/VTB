package examples.collections_five_5;

import java.util.*;

public class Collections_Set_Ex2 {

    public static void main(String args[]) {

        System.out.println("HashSet: ");
        Set<String> set = new HashSet<>();
        set.add("Aльфa");
        set.add("Бета");
        set.add("Aльфa");
        set.add("Этa");
        set.add("Гaммa");
        set.add("Эпсилон");
        set.add("Oмeгa");
        set.add("Гaммa");
        System.out.println(set);

        System.out.println("LinkedHashSet: ");
        Set<String> set_2 = new LinkedHashSet<>();
        set_2.add("Aльфa");
        set_2.add("Бета");
        set_2.add("Aльфa");
        set_2.add("Этa");
        set_2.add("Гaммa");
        set_2.add("Эпсилон");
        set_2.add("Oмeгa");
        set_2.add("Гaммa");
        System.out.println(set_2);

        Set<String> set_3 = new TreeSet<>();
        set_3.add("C");
        set_3.add("A");
        set_3.add("B");
        set_3.add("E");
        set_3.add("F");
        set_3.add("D");
        System.out.println(set_3);

    }

}
