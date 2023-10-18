package io.educative.finding_intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntervalListIntersections {
    public static void main(String[] args) {
        var str = new int[][]{new int[]{1,2}, new int[]{2,4}};

        int[] a = new int[]{1,2};
        int[] b = new int[]{1,2};
        int[][] c = new int[][]{a,b};
        Integer[][] cR = new Integer[2][2];
        for (Integer[] i: cR) {

        }



        Integer[] boxed = Arrays.stream(a).boxed().toArray(Integer[]::new);
        Arrays.sort(c, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });
    }
}