package algorithms;

import algorithms.enums.CaseEnum;

import java.util.Random;

public abstract class AlgorithmImpl implements AlgorithmInterface{
    private CaseEnum caseType;
    private Long memoryUsed;

    public AlgorithmImpl() {
        this.memoryUsed = 0L;
    }

    @Override
    public int[][] assembleCase(Integer qtt, String type) {
        switch (type) {
            case "w":
                caseType = CaseEnum.WORST;
                return worstCase(qtt);
            case "m":
                caseType = CaseEnum.AVERAGE;
                return avarageCase(qtt);
            case "b":
                caseType = CaseEnum.BEST;
                return bestCase(qtt);
            default:
                throw new IllegalArgumentException("Tipo não encontrado, os tipos possíveis são: w, m, b");
        }
    }
    abstract int[][] worstCase(Integer qtt);
    abstract int[][] bestCase(Integer qtt);
    protected int[][] avarageCase(Integer qtt) {
        int[][] nums = new int[5][qtt];
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < qtt; j++) {
                nums[i][j] = r.nextInt(1_000_001);
            }
        }
        return nums;
    }

    protected void setMemoryUsed() {
        Long currentMemoryUsed = ((Runtime.getRuntime().totalMemory()) - Runtime.getRuntime().freeMemory());
        memoryUsed  = currentMemoryUsed > memoryUsed? currentMemoryUsed : memoryUsed;
    }

    @Override
    public long getHigherMemory() {
        return memoryUsed;
    }
}
