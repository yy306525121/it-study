package cn.codeyang.leetcode.queue;

/**
 * 循环队列
 *
 * @author yangzhongyang
 */
public class MyCircularQueue {
	private int[] queue;
	private int head;
	private int tail;

	public MyCircularQueue(int k) {
		queue = new int[k + 1];
		head = 0;
		tail = 0;
	}

	/**
	 * 入队
	 * 当(tail + 1) % queue.length == head 时,  少用一个存储空间
	 *
	 * @param value
	 * @return
	 */
	public boolean enQueue(int value) {
		if ((tail + 1) % queue.length == head) {
			return false;
		}

		queue[tail] = value;
		tail = (tail + 1) % queue.length;
		return true;
	}

	/**
	 * 出队
	 *
	 * @return
	 */
	public boolean deQueue() {
		if (head == tail) {
			return false;
		}

		head++;
		return true;
	}

	/**
	 * 获取队列的头结点
	 *
	 * @return
	 */
	public int Front() {
		if (head == tail) {
			return -1;
		}
		return queue[head];
	}

	/**
	 * 获取循环队列的尾结点
	 *
	 * @return
	 */
	public int Rear() {
		if (head == tail) {
			return -1;
		}

		if (tail == 0){
			return queue[queue.length - 1];
		}

		return queue[tail - 1];
	}

	/**
	 * 队列是否为空
	 *
	 * @return
	 */
	public boolean isEmpty() {
		return head == tail;
	}

	/**
	 * 队列是否已满
	 *
	 * @return
	 */
	public boolean isFull() {
		if ((tail + 1) % queue.length == head){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		MyCircularQueue queue = new MyCircularQueue(6);
		System.out.println(queue.enQueue(6));
		System.out.println(queue.Rear());
		System.out.println(queue.Rear());
		System.out.println(queue.deQueue());
		System.out.println(queue.enQueue(5));
		System.out.println(queue.Rear());
		System.out.println(queue.deQueue());
		System.out.println(queue.Front());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}
}
