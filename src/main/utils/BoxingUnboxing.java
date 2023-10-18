package utils;

import java.util.Arrays;

public class BoxingUnboxing {
    public static void main(String[] args) {
        // boxing from primitives
        // int
        int[] intArray = new int[]{1,2,3};
        Integer[] intBoxedArray = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
        // double
        double[] doubleArray = new double[]{1,2,3};
        Double[] doubleBoxedArray = Arrays.stream(doubleArray).boxed().toArray(Double[]::new);
        // Long
        long[] longArray = new long[]{1,2,3};
        Long[] longBoxedArray = Arrays.stream(longArray).boxed().toArray(Long[]::new);


        // unboxing from boxed
        int[] reIntArray = Arrays.stream(intBoxedArray).mapToInt(Integer::intValue).toArray();
        double[] reDoubleArray = Arrays.stream(doubleBoxedArray).mapToDouble(Double::doubleValue).toArray();
        long[] reLongArray = Arrays.stream(longBoxedArray).mapToLong(Long::longValue).toArray();
    }
}
