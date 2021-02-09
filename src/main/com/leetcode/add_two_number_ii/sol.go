package main

import (
	"fmt"
	"container/heap"
)

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

type ListNode struct {
	 Val int
	 Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	l1r := reverseLinkedList(l1)
	l2r := reverseLinkedList(l2)

	carry := 0
	var head *ListNode
	var next *ListNode
	for {
		if l1r == nil && l2r == nil {
			break
		}

		var newNode ListNode

		if l1r != nil && l2r != nil {
			newNode.Val = l1r.Val + l2r.Val + carry
			l1r = l1r.Next
			l2r = l2r.Next
		} else if l1r != nil {
			newNode.Val = l1r.Val + carry
			l1r = l1r.Next
		} else {
			newNode.Val = l2r.Val + carry
			l2r = l2r.Next
		}

		if newNode.Val >= 10 {
			carry = newNode.Val / 10
			newNode.Val = newNode.Val % 10
		} else {
			carry = 0
		}

		if head == nil {
			head = &newNode
			next = &newNode
		} else {
			next.Next = &newNode
			next = next.Next
		}
	}

	if carry > 0 {
		next.Next = &ListNode{ Val: carry }
	}

	return reverseLinkedList(head)
}

func reverseLinkedList(l *ListNode) *ListNode {
	var prev *ListNode
	for l != nil {
		nextL := l.Next
		l.Next = prev
		prev = l
		l = nextL
	}
	return prev
}

func main() {
	// 7243
	r1 := &ListNode{Val: 7, Next: &ListNode{Val: 2, Next: &ListNode{Val: 4, Next: &ListNode{Val: 3}}}}
	// 564
	r2 := &ListNode{Val: 5, Next: &ListNode{Val: 6, Next: &ListNode{Val: 4}}}

	ret := addTwoNumbers(r1, r2)


	printNumber(ret)
}

func printNumber(n *ListNode) {
	for n != nil {
		fmt.Printf("%v", n.Val)
		n = n.Next
	}
	fmt.Printf("\n")
}
