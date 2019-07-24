package cloud.university;

public class NumberSearch {
	public static int countLessThan(int[] nums, int x) {
		int n = nums.length;
		int left = 0;
		int right = n;

		int mid = 0;
		while (left < right) {
			mid = (right + left) >> 1;

			// Check if x is present in array
			if (nums[mid] == x) {

				// If duplicates are present it returns
				// the position of last element
				while (mid + 1 < n && nums[mid + 1] == x)
					mid++;
				break;
			}

			// If x is smaller, ignore right half
			else if (nums[mid] > x)
				right = mid;

			// If x is greater, ignore left half
			else
				left = mid + 1;
		}

		// If x is not found in array then it will be
		// before mid
		while (mid > -1 && nums[mid] > x)
			mid--;

		// Return mid + 1 because of 0-based indexing
		// of array
		return mid + 1;
	}

	public static void main(String[] args) {
		System.out.println(countLessThan(new int[] { 1, 3, 3, 4, 8 }, 5));
	}

}
