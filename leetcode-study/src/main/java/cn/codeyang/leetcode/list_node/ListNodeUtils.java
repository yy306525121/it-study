package cn.codeyang.leetcode.list_node;

/**
 * @Description
 * @Author yangzhongyang
 * @Date 2019/9/10 15:26
 * @Version 1.0
 **/
public class ListNodeUtils {
	public static void print(ListNode head){
		while (head != null) {
			System.out.print(head.val + " > ");
			head = head.next;
		}
		System.out.println();
	}
}
