package interview.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListReverser
{
	// 第①步：准确定义函数
	/**
	 * Reverses a linked list.
	 * 
	 * @param head
	 *            the linked list to reverse
	 * @return head of the reversed linked list
	 */
	public Node reverseLinkedList(Node head)
	{
		// 第②步处理特殊值(2个)

		// head.getNext()会出现的问题
		// 1.head可能是null
		// 特殊值(1)
		if (head == null)// 链表里什么都没有【size == 0】
		{
			return null;
		}
		// 2.head.getNext()可能是null：之前已经处理了

		// head.getNext().setNext(head)会出现的问题
		// 1.已经判断head不为null
		// 2.head.getNext()可能为null，没办法setNext
		// 特殊值(2)
		if (head.getNext() == null)// 链表只有1个结点：head本身【size == 1】
		{
			return head;// 返回head
		}
		// 3.setNext可以正确运行了
		// head.setNext(null)这个也可以正确运行

		// 首先把head.getNext()开头的链表反转掉
		// 假设函数能反转，返回newHead
		Node newHead = reverseLinkedList(head.getNext());

		// 要把第2个结点的next指向1(自己)
		head.getNext().setNext(head);

		// 把1(自己)的next指向null
		head.setNext(null);

		// 返回newHead
		// 本来head指向结点1，返回值指向结点5
		return newHead;
	}

	public static void main(String[] args)
	{
		LinkedListCreator creator = new LinkedListCreator();
		LinkedListReverser reverser = new LinkedListReverser();

		// 建一个空传
		Node.printLinkedList(reverser.reverseLinkedList(creator.creatLinkedList(new ArrayList<>())));
		// 建一个只有一个节点的传
		Node.printLinkedList(reverser.reverseLinkedList(creator.creatLinkedList(Arrays.asList(1))));
		// 建一个普通的
		Node.printLinkedList(reverser.reverseLinkedList(creator.creatLinkedList(Arrays.asList(1, 2, 3, 4, 5))));
		// 打印linked list，见Node.java
	}

}
