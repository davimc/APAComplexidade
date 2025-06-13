package algorithms;

import java.util.Arrays;

public class Librarysort extends AlgorithmImpl {

    public int[] order(int[] nums) {
        if (nums.length <= 1) return nums;

        double epsilon = 0.5; // define quanto espaço extra é reservado
        int n = nums.length;
        int size = (int) ((1 + epsilon) * n);
        Integer[] gaps = new Integer[size];
        Arrays.fill(gaps, null);

        // Insere o primeiro elemento no meio
        int mid = size / 2;
        gaps[mid] = nums[0];

        int count = 1; // número de elementos inseridos

        for (int i = 1; i < n; i++) {
            int val = nums[i];

            // Busca binária para posição
            int pos = binarySearch(gaps, val);

            // Move para abrir espaço se necessário
            pos = findGap(gaps, pos);

            // Insere
            gaps[pos] = val;
            setMemoryUsed();
            count++;

            // Se muitos elementos inseridos, reespalha
            if (count > gaps.length * (1.0 / (1.0 + epsilon))) {
                gaps = rebalance(gaps, epsilon);
                setMemoryUsed();
            }
        }

        // Copia os elementos de volta
        int index = 0;
        for (Integer val : gaps) {
            if (val != null) {
                nums[index++] = val;
            }
        }
        return nums;
    }
    private static int binarySearch(Integer[] gaps, int val) {
        int low = 0, high = gaps.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (gaps[mid] == null || gaps[mid] > val) {
                high = mid - 1;
            } else if (gaps[mid] < val) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    private static int findGap(Integer[] gaps, int pos) {
        // Busca posição disponível à direita
        while (pos < gaps.length && gaps[pos] != null) {
            pos++;
        }
        if (pos >= gaps.length) {
            // Se não encontrou à direita, procura à esquerda
            pos = pos - 1;
            while (pos >= 0 && gaps[pos] != null) {
                pos--;
            }
        }
        return pos;
    }

    private static Integer[] rebalance(Integer[] gaps, double epsilon) {
        int n = (int) Arrays.stream(gaps).filter(x -> x != null).count();
        int newSize = (int) ((1 + epsilon) * n);
        Integer[] newGaps = new Integer[newSize];
        Arrays.fill(newGaps, null);

        int idx = 0;
        int step = newSize / n;
        for (Integer val : gaps) {
            if (val != null) {
                newGaps[idx] = val;
                idx += step;
            }
        }
        return newGaps;
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