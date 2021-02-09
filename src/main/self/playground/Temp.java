package self.playground;

import java.util.*;

public class Temp {
    enum Test {
        INSTANCE;

        public void sayCheese() {
            System.out.println(1);
        }
    }

    class Pri {
        int key;
        int value;

        Pri(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class TestC {
        float abc;
        int cde;

        TestC(float abc, int cde) {
            this.abc = abc;
            this.cde = cde;
        }
    }

    public static void main(String[] args) {
        int i = 1;
        int j = 5;
        float ans = ((float) i - (float) j);
        System.out.println(Math.round(ans));

        PriorityQueue<TestC> q = new PriorityQueue<>(new Comparator<TestC>() {
            @Override
            public int compare(TestC o1, TestC o2) {
                if (o1.abc - o2.abc < 0) {
                    return 1;
                } else if (o1.abc - o2.abc > 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        q.offer(new TestC(1, 2));
        q.offer(new TestC(100, 2));
        q.offer(new TestC(-1, 2));
        q.offer(new TestC(-1, 2));
        q.offer(new TestC(-7, 2));
        q.offer(new TestC(3, 2));
        q.offer(new TestC(5, 2));
        q.offer(new TestC(-1, 2));
        q.offer(new TestC(3, 2));
        q.offer(new TestC(-1, 2));
        q.offer(new TestC(-7, 2));
        q.offer(new TestC(3, 2));
        while (!q.isEmpty()) {
            System.out.println(q.poll().abc);
        }
    }
}
