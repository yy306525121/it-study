package cn.codeyang.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * ID:350
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainAnotherArray2 {
	public static int[] intersection(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> numsMap1 = new HashMap<>();
		for (int i : nums1) {
			int v = 0;
			if (numsMap1.containsKey(i)) {
				v = numsMap1.get(i);
			}
			numsMap1.put(i, v + 1);
		}

		int[] resultArray = new int[nums1.length];
		int idx = 0;
		for (int i : nums2) {
			if (numsMap1.containsKey(i)) {
				Integer v = numsMap1.get(i);

				if (v > 0) {
					resultArray[idx++] = i;
					numsMap1.put(i, v - 1);
				}
			}
		}

		return Arrays.copyOf(resultArray, idx);
	}

	public static int[] intersect2(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return null;
		}

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int l1 = nums1.length;
		int l2 = nums2.length;

		int[] array = new int[l1 < l2 ? l1 : l2];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < l1 && j < l2){
			if (nums1[i] < nums2[j]){
				i++;
			} else if (nums1[i] > nums2[j]){
				j++;
			} else {
				array[k] = nums1[i];
				k++;
				i++;
				j++;
			}
		}

		int[] tmp = new int[k];
		for (int i1 = 0; i1 < k; i1++) {
			tmp[i1] = array[i1];
		}

		return tmp;
	}


	public static void main(String[] args) {
		int[] nums1 = new int[]{4, 9, 5};
		int[] nums2 = new int[]{9, 4, 9, 8, 4};

		int[] intersection = intersect2(nums1, nums2);
		for (int i : intersection) {
			System.out.println(i);
		}
	}
}
