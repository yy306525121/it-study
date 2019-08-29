package cn.codeyang.leetcode;

/**
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 *
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * 示例 1:
 *
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *  
 *
 * 示例 2:
 *
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 *  
 *
 * 提示:
 *
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 99].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class DominantIndex {
	public static int dominantIndex(int[] nums) {
		int max = 0;
		int second = 0;

		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max){
				second = max;
				max = nums[i];
				index = i;
			} else if (nums[i] > second){
				second = nums[i];
			}
		}

		if (max >= second*2){
			return index;
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{0,0,3,2};
		int i = dominantIndex(arr);
		System.out.println(i);
	}
}
