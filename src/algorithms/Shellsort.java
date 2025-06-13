package algorithms;

import java.util.Arrays;
import java.util.Random;

public class Shellsort extends AlgorithmImpl {

    public int[] order(int[] nums) {
        int h = 1;
        int n = nums.length;
        while (h < n) {
            h = h * 3 + 1;
        }
        h = h / 3;
        int c, j;
        while (h > 0) {
            for (int i = h; i < n; i++) {
                c = nums[i];
                j = i;
                while (j >= h && nums[j - h] > c) {
                    nums[j] = nums[j - h];
                    j = j - h;
                }
                nums[j] = c;
            }
            setMemoryUsed();
            h = h / 2;
        }
        return nums;
    }


    @Override
    public int[][] worstCase(Integer qtt) {
        int[][] nums = new int[1][qtt];
        for (int i=qtt; i > 0; i--)
            nums[0][qtt-i] = i;
        return nums;
    }

    @Override
    protected int[][] bestCase(Integer qtt) {
        int[][] nums = new int[1][qtt];
        for (int i = 0; i < qtt; i++) {
            nums[0][i] = i;
        }
        return nums;
    }


}