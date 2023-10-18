package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimitiveArrayConversion {
    public static void main(String[] args) {

        int[] intPrimitiveArray = new int[] {1,2,3,4};
        // to list class
        List<Integer> intListArray = Arrays.stream(intPrimitiveArray).boxed().collect(Collectors.toList());
        // to set it back
        int[] reIntPrimitiveArray = new int[intListArray.size()];
        Arrays.setAll(reIntPrimitiveArray, intListArray::get);

        double[] doublePrimitiveArray = new double[] {1,2,3,4};
        // to list class
        List<Double> doubleListArray = Arrays.stream(doublePrimitiveArray).boxed().collect(Collectors.toList());
        // to set it back
        double[] reDoublePrimitiveArray = new double[doubleListArray.size()];
        Arrays.setAll(reDoublePrimitiveArray, doubleListArray::get);

        long[] longPrimitiveArray = new long[] {1,2,3,4};
        // to list class
        List<Long> longListArray = Arrays.stream(longPrimitiveArray).boxed().collect(Collectors.toList());
        // to set it back
        long[] reLongPrimitiveArray = new long[longListArray.size()];
        Arrays.setAll(reLongPrimitiveArray, longListArray::get);

        // bonus parse string to int
        List<String> stringIntListArray = Arrays.asList("1","2","3","4");
        int[] reStringIntPrimitiveArray = new int[stringIntListArray.size()];
        Arrays.setAll(reStringIntPrimitiveArray, i -> Integer.parseInt(stringIntListArray.get(i)));
    }
}
