package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Playground {
    public static void main(String[] args) {
        HashSet<List<Integer>> set = new HashSet<>();
        var list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
//        var list1 = Arrays.asList(1,2,3);
        var list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        set.add(list1);
        System.out.println(set.contains(list2));
    }
}
