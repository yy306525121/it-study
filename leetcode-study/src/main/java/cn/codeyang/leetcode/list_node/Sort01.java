package cn.codeyang.leetcode.list_node;

/**
 * 奇数位升序, 偶数位降序,  求排序
 * 步骤1: 拆分链表
 * @author yangzhongyang
 */
public class Sort01 {

	/**
	 * 按奇数位和偶数位将链表拆分
	 * [奇数位,  偶数位]
	 *
	 * @param head
	 * @return
	 */
	public static ListNode[] splitListNode(ListNode head) {
		ListNode head1 = null;
		ListNode head2 = null;

		ListNode cur1 = null;
		ListNode cur2 = null;

		int index = 1;
		while (head != null) {
			if (index % 2 != 0) {
				if (head1 == null) {
					head1 = head;
					cur1 = head1;
				} else {
					cur1.next = head;
					cur1 = cur1.next;
				}
			} else {
				if (head2 == null) {
					head2 = head;
					cur2 = head2;
				} else {
					cur2.next = head;
					cur2 = cur2.next;
				}
			}
			index++;
			head = head.next;
		}
		cur1.next = null;
		cur2.next = null;

		return new ListNode[]
				{
						head1, head2
				};
	}


	/**
	 * 翻转链表
	 *
	 * @param head
	 * @return
	 */
	public static ListNode reversal(ListNode head) {
		ListNode node = null;

		ListNode pre = null;
		ListNode next = null;

		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}

		return pre;
	}

	/**
	 * 合并两个链表
	 *
	 * @param head1
	 * @param head2
	 * @return
	 */
	static ListNode merge(ListNode head1, ListNode head2) {
		if (head1 == null && head2 == null) {
			return null;
		}
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}

		ListNode head = null;
		ListNode pre = null;
		ListNode next = null;
		ListNode cur1 = null;
		ListNode cur2 = null;


		if (head1.val <= head2.val) {
			head = head1;
			cur1 = head1;
			cur2 = head2;
		} else {
			head = head2;
			cur1 = head2;
			cur2 = head1;
		}

		while (cur1 != null && cur1 != null) {
			if (cur1.val <= cur2.val) {
				pre = cur1;
				cur1 = cur1.next;
			} else {
				pre.next = cur2;
				next = cur2.next;
				cur2.next = cur1;
				pre = cur2;
				cur2 = next;
			}
		}

		if (cur1 == null) {
			pre.next = cur2;
		} else if (cur2 == null) {
			pre.next = cur1;
		}

		return head;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(10);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(8);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(4);
		ListNode node9 = new ListNode(9);
		ListNode node10 = new ListNode(2);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;

		ListNode[] listNodes = splitListNode(node1);
		System.out.println(listNodes);

		ListNode reversalNode = reversal(listNodes[1]);
		System.out.println(reversalNode);

		ListNode merge = merge(listNodes[0], reversalNode);
		System.out.println(merge);
	}
}
