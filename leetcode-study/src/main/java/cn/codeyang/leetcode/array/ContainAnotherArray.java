package cn.codeyang.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainAnotherArray {
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set[] sets = convertSet(nums1, nums2);

		Set<Integer> sortSet = sets[0];
		Set<Integer> longSet = sets[1];

		int[] resultArray = new int[sortSet.size()];

		int idx = 0;
		for (Integer integer : sortSet) {
			if (longSet.contains(integer)){
				resultArray[idx++] = integer;
			}
		}


		return Arrays.copyOf(resultArray, idx);
	}

	public static int[] intersection2(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<>();
		for (int i : nums1) {
			set1.add(i);
		}

		int len = nums1.length < nums2.length ? nums1.length : nums2.length;
		int[] resultArray = new int[len];
		int ids = 0;
		for (int i : nums2) {
			if (set1.contains(i)){
				resultArray[ids++] = i;
			}
		}

		return Arrays.copyOf(resultArray, ids);
	}

	public static Set[] convertSet(int[] nums1, int[] nums2){
		HashSet<Integer> set1 = new HashSet<>(nums1.length);
		for (int i : nums1) {
			set1.add(i);
		}

		HashSet<Object> set2 = new HashSet<>(nums2.length);
		for (int i : nums2) {
			set2.add(i);
		}

		if (set1.size() < set2.size()){
			return new Set[]{set1, set2};
		} else {
			return new Set[]{set2, set1};
		}
	}

	public static void main(String[] args) {
		int[] nums1 = new int[]{4, 9, 5};
		int[] nums2 = new int[]{9,4,9,8,4};

		int[] results = intersection2(nums1, nums2);

		for (int result : results) {
			System.out.println(result);
		}
	}
}
