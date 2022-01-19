package com.smi;

public class SortedDRotatedArray {

	public static void main(String args[]) {

		SortedDRotatedArray obj = new SortedDRotatedArray();
		int[] nums = { 5, 1, 3 };
		System.out.println(obj.search(nums, 5));
	}

	public int search(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		int mid = 0;
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[lo] <= nums[mid]) {
				if (target < nums[mid] && nums[lo] <= target) {
					hi = mid - 1;
				} else {
					lo = mid + 1;

				}

			} else {
				if (target > nums[mid] && target <= nums[hi]) {

					lo = mid + 1;
				} else {
					hi = mid - 1;
				}

			}

		}
		return -1;

	}
}
