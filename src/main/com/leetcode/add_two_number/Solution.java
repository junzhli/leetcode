package com.leetcode.add_two_number;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

//    public class ExtendedNumber {
//        int val;
//        int digits;
//
//        ExtendedNumber(int value){
//            this.val = value;
//            this.digits = (this.val == 0) ? 1: (int)(Math.log10(this.val)+1);
//    }
//
//        ExtendedNumber add(ExtendedNumber numB) {
//            this.val = this.val + numB.val;
//            this.digits = (int)(Math.log10(this.val)+1);
//            return this;
//        }
//    }

    // 2ms, 58% faster than others' submissions
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode _l1 = l1;
        ListNode _l2 = l2;
        ListNode res = null;
        ListNode next = null;
        int carry = 0;

        while (_l1 != null || _l2 != null) {
            //
            int x = 0;
            if (_l1 != null) {
                x = _l1.val;
                _l1 = _l1.next;
            }
            int y = 0;
            if (_l2 != null) {
                y = _l2.val;
                _l2 = _l2.next;
            }

            int r = x + y + carry;
            carry = r / 10;
            r = r % 10;

            ListNode nxt = new ListNode(r);
            if (next != null) {
                next.next = nxt;
            } else {
                res = nxt;
            }
            next = nxt;
        }

        if (carry > 0) {
            ListNode nxt = new ListNode(carry);
            // if program stops here, indicating next must not be null
            next.next = nxt;
            // no need to assign next = nxt;
        }


        return res;
    }



//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode res = new ListNode(0);
//        int carry = 0;
//
//        ListNode tmpL1 = l1;
//        ListNode tmpL2 = l2;
//        ListNode tmpRes = res;
//        while (true) {
//            int tmp = tmpL1.val + tmpL2.val + carry;
//            if (tmp >= 10) {
//                carry = tmp / 10;
//            }
//            else
//                carry = 0;
//            tmpRes.val = tmp % 10;
//
//            if (tmpL1.next == null && tmpL2.next != null) {
//                tmpRes.next = tmpL2.next;
//                tmpRes = tmpRes.next;
//                break;
//            }
//            else if (tmpL2.next == null && tmpL1.next != null) {
//                tmpRes.next = tmpL1.next;
//                tmpRes = tmpRes.next;
//                break;
//            }
//            else if (tmpL1.next == null && tmpL2.next == null) {
//                if (carry != 0)
//                    tmpRes.next = new ListNode(0);
//                tmpRes = tmpRes.next;
//                break;
//            }
//            else {
//                tmpL1 = tmpL1.next;
//                tmpL2 = tmpL2.next;
//                tmpRes.next = new ListNode(0);
//                tmpRes = tmpRes.next;
//            }
//
//
//        }
//
//        if (carry != 0) {
//            tmpRes.val += carry;
//
//            if (tmpRes.val >= 10) {
//                carry = 0;
//                while (true) {
//                    int tmp = tmpRes.val + carry;
//                    if (tmp >= 10) {
//                        tmpRes.val = tmp % 10;
//                        carry = tmp / 10;
//                    }
//                    else {
//                        carry = 0;
//                        tmpRes.val = tmp % 10;
//                    }
//
//
//                    if (tmpRes.next != null)
//                        tmpRes = tmpRes.next;
//                    else {
//                        if (carry != 0)
//                            tmpRes.next = new ListNode(carry);
//                        break;
//                    }
//
//                }
//            }
//
//        }
//
//
//
//
//        return res;
//    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        List<Integer> A = linkedListToArrayList(l1);
//        List<Integer> B = linkedListToArrayList(l2);
//        ExtendedNumber totalA = linkedListToExtendedNumber(A);
//        ExtendedNumber totalB = linkedListToExtendedNumber(B);
//        return intToReverseOrderLinkedList(totalA.add(totalB));
//    }

//    public List<Integer> linkedListToArrayList(ListNode currentNode) {
//        List<Integer> res = new ArrayList<Integer>();
//        while(true) {
//            int currentVal = currentNode.val;
//            res.add(currentVal);
//
//            if(currentNode.next != null)
//                currentNode = currentNode.next;
//            else
//                break;
//        }
//        return res;
//    }
//
//    public ExtendedNumber linkedListToExtendedNumber(List<Integer> linkedListNumber) {
//        final int[] POWERS_OF_10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
//        int max = linkedListNumber.size() - 1;
//        int res = 0;
//        for (int x = max; x >= 0; x--) {
//            res += linkedListNumber.get(x) * POWERS_OF_10[x];
//        }
//        return new ExtendedNumber(res);
//    }
//
//    public ListNode intToReverseOrderLinkedList(ExtendedNumber num) {
//        if (num.digits == 1)
//            return new ListNode(num.val);
//        else if (num.digits == 2) {
//            ListNode res = new ListNode(num.val % 10);
//            res.next = new ListNode(num.val / 10);
//            return res;
//        }
//        else {
//            ListNode res = new ListNode(num.val % 10);
//            res.next = intToReverseOrderLinkedList(new ExtendedNumber(num.val / 10));
//            return res;
//        }
//    }
//
//    public ListNode longIntToReverseOrderLinkedList(ArrayList<Integer> num) {
//        ListNode res = new ListNode(0);
//        ListNode rmpRes = res;
//        for (int x = 0; x < num.size(); x++) {
//            rmpRes.val = num.get(x);
//            if (x != (num.size() - 1))
//                rmpRes.next = new ListNode(0);
//            rmpRes = rmpRes.next;
//        }
//        return res;
//    }

}


