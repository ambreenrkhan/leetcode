package leetCode.arrayString;

import java.util.Arrays;

class RotateArray {
    public static void rotate(int[] nums, int k) {
        // loop through the array
        int numberOfMoves = k;
        if (k > nums.length) {
            numberOfMoves = k % nums.length;
        }

        if (numberOfMoves == 0) return;

        for (int i = 0; i < numberOfMoves; i++) {
            shift(nums);
        }
    }

    private static void shift(int num[]) {
        int temp = num[num.length - 1];

        for (int j = num.length - 1; j > 0; j--) {
            num[j] = num[j - 1];
        }

        num[0] = temp;
    }

    public static void rotate2(int[] nums, int k) {
        // loop through the array
        int numberOfMoves = k;
        if (k > nums.length) {
            numberOfMoves = k % nums.length;
        }

        if (numberOfMoves == 0) return;

        for (int i = 0; i < numberOfMoves; i++) {
            int temp = nums[nums.length - 1];

            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }

            nums[0] = temp;
        }
    }

    public static void main(String args[]) {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;

        rotate2(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}

