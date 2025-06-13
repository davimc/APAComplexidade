package algorithms;

public class InPlaceMergeSort extends AlgorithmImpl {

    @Override
    public int[] order(int[] nums) {
        int len = nums.length;
        return mergeSort(nums, 0, len-1);
    }

    public int[] merge(int[] nums, int start, int mid, int end) {
        setMemoryUsed();
        int start2 = mid + 1;

        // Se os elementos já estiverem em ordem, não faz nada
        if (nums[mid] <= nums[start2]) {
            return nums;
        }

        while (start <= mid && start2 <= end) {
            if (nums[start] <= nums[start2]) {
                start++;
            } else {
                int value = nums[start2];
                int index = start2;

                // Desloca todos os elementos entre start e start2 para a direita
                while (index != start) {
                    nums[index] = nums[index - 1];
                    index--;
                }

                nums[start] = value;

                // Atualiza os ponteiros
                start++;
                mid++;
                start2++;
            }
        }
        return nums;
    }

    public int[] mergeSort(int[] arr, int l, int r) {

        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            this.merge(arr, l, m, r);
            setMemoryUsed();
        }
        return arr;
    }

    @Override
    public int[][] worstCase(Integer qtt) {
        int[][] nums = new int[1][qtt];
        for (int i = 0; i < qtt; i++) {
            nums[0][i] = qtt - i;
        }
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