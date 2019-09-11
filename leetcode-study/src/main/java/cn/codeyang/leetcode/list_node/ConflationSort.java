package cn.codeyang.leetcode.list_node;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * 第一步:
 */
public class ConflationSort {

	/**
	 * 获取链表的中间节点
	 *
	 * @param head
	 * @return
	 */
	static ListNode getMiddle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	/**
	 * 合并两个链表
	 *
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static ListNode merge(ListNode head1, ListNode head2) {
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
		ListNode cur1 = null;
		ListNode cur2 = null;
		ListNode pre = null;
		ListNode next = null;
		if (head1.val <= head2.val) {
			head = head1;
			cur1 = head1;
			cur2 = head2;
		} else {
			head = head2;
			cur1 = head2;
			cur2 = head1;
		}

		while (cur1 != null && cur2 != null) {
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
		} else {
			pre.next = cur1;
		}

		return head;
	}

	/**
	 * 时间复杂度 nLogn
	 *
	 * @param head
	 * @return
	 */
	public static ListNode sort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode middleNode = getMiddle(head);
		ListNode right = middleNode.next;
		middleNode.next = null;

		ListNode mergedNode = merge(sort(head), sort(right));
		return mergedNode;
	}


	public static int getLength(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}

		return len;
	}

	public static ListNode getStep(ListNode head, int step) {
		while (step > 0) {
			if (head == null) {
				return head;
			}
			head = head.next;
			step--;
		}

		return head;
	}

	/**
	 * 获取链表的尾结点
	 * @param head
	 * @return
	 */
	public static ListNode getTail(ListNode head){
		while (head.next != null) {
			head = head.next;
		}

		return head;
	}

	public static ListNode sort2(ListNode head) {

		/**
		 * 1: 获取链表长度
		 */
		int len = getLength(head);
		int intv = 1;
		ListNode res = new ListNode(0);
		res.next = head;

		while (intv < len) {
			ListNode preTail = res;
			ListNode h1 = preTail.next;
			ListNode h2 = getStep(preTail.next, intv);
			ListNode tail = null;
			while (h1 != null) {
				ListNode tailH1 = getStep(h1, intv-1);
				ListNode tailH2 = getStep(h2, intv - 1);

				ListNode nextH1 = getStep(h2, intv);
				ListNode nextH2 = getStep(nextH1, intv);

				// 截断h1和h2
				if (tailH1 != null) {
					tailH1.next = null;
				}
				if (tailH2 != null) {
					tailH2.next = null;
				}


				ListNode mergedNode = merge(h1, h2);
				preTail.next = mergedNode;
				tail = getTail(mergedNode);
				tail.next = nextH1;
				preTail = tail;

				h1 = nextH1;
				h2 = nextH2;

			}

			intv = intv * 2;
		}


		return res.next;
	}


	public static void main(String[] args) {
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(8);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(4);
		ListNode node9 = new ListNode(9);
		ListNode node10 = new ListNode(2);
		ListNode node11 = new ListNode(-1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;

		ListNodeUtils.print(node1);
		ListNode listNode = sort2(node1);
		ListNodeUtils.print(listNode);
	}

}
