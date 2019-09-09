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
	 * @param head
	 * @return
	 */
	public static ListNode sort(ListNode head){
		if (head == null || head.next == null) {
			return head;
		}

		ListNode middleNode = getMiddle(head);
		ListNode right = middleNode.next;
		middleNode.next = null;

		ListNode mergedNode = merge(sort(head), sort(right));
		return mergedNode;

	}


	public static void main(String[] args) {
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(3);


		node1.next = node2;
		node2.next = node3;
		node3.next = node4;


		ListNode middle = sort(node1);
		System.out.println(middle.val);
	}

}
