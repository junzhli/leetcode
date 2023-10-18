package self.playground;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task implements Runnable {
    @Override
    public void run() {

        int[] aaa = new int[]{1,2,4};

        Integer[] _aaa = Arrays.stream(aaa).boxed().toArray(Integer[]::new);
        List<Integer> _aaa2 = Arrays.stream(aaa).boxed().collect(Collectors.toList());

        int[] _aaaUnboxed = new int[_aaa.length];


        System.out.println("goood");
    }
}
