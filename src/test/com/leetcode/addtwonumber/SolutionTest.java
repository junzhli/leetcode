package com.leetcode.addtwonumber;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void addTwoNumbers() {
        Solution sol = new Solution();
        ListNode ans1 = sol.intToReverseOrderLinkedList(sol.new ExtendedNumber(9));
        ListNode ans2 = sol.longIntToReverseOrderLinkedList(new ArrayList<Integer>() {{
            add(1);
            add(9);
            add(9);
            add(9);
            add(9);
            add(9);
            add(8);
            add(9);
            add(9);
            add(9);
        }});
//        assertTrue(ans1.val == 0);
//        assertNull(ans1.next);
        assertTrue(ans2.val == 1);
        assertTrue(ans2.next.val == 9);
        assertTrue(ans2.next.next.val == 9);

        ListNode res = new Solution().addTwoNumbers(ans1, ans2);

//        List<Integer> ans1Val = sol.linkedListToArrayList(ans1);
//        List<Integer> ans2Val = sol.linkedListToArrayList(ans2);
//        assertTrue(ans1Val.get(0) == 2);
//        assertTrue(ans1Val.get(1) == 4);
//        assertTrue(ans1Val.get(2) == 3);
//        assertTrue(ans2Val.get(0) == 5);
//        assertTrue(ans2Val.get(1) == 6);
//        assertTrue(ans2Val.get(2) == 4);
//
//        ListNode result = sol.intToReverseOrderLinkedList(sol.linkedListToExtendedNumber(ans1Val).add(sol.linkedListToExtendedNumber(ans2Val)));
//        assertTrue(result.val == 7);
//        assertTrue(result.next.val == 0);
//        assertTrue(result.next.next.val == 8);

    }
}