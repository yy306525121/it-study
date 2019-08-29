package cn.codeyang.leetcode;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c。
 * <p>
 * 示例1:
 * <p>
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *  
 * <p>
 * 示例2:
 * <p>
 * 输入: 3
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class JudgeSquareSum {
	public static boolean judgeSquareSum(int c) {
		int min = 0;
		int max = (int) Math.sqrt(c);

		while (min <= max) {
			int result = min * min + max * max;
			if (result < c) {
				min++;
			} else if (result > c){
				max--;
			} else {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(judgeSquareSum(2));
	}
}
