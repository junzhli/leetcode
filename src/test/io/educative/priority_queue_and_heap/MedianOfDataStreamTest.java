package io.educative.priority_queue_and_heap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfDataStreamTest {
    //Driver code
    public static void main(String[] arg){
        String[] inputs = {"6"};
        String[][] inputs1 ={{"1", "2", "3" ,"get","4","get"}};
        for(int i = 0; i < inputs.length; i++) {
            int numInputs = Integer.parseInt(inputs[i]);
            MedianOfDataStream medianOfStream = new MedianOfDataStream();
            List<Double> res  = new ArrayList<Double>();
            for (int j = 0; j < numInputs; ++j) {
                String input = inputs1[i][j];
                if (input.equals("get")) {
                    res.add(medianOfStream.getMedian());
                } else {
                    medianOfStream.addNum(Integer.parseInt(input));
                }
            }
            System.out.println("Median of data stream :"+res.toString());
        }
    }
}