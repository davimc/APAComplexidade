import algorithms.AlgorithmInterface;
import algorithms.enums.CaseEnum;
import utils.BuilderByFile;
import utils.CSVFile;
import utils.FileSelectorUI;
import utils.Result;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        BuilderByFile bg = new BuilderByFile(FileSelectorUI.selecionarArquivo());
        AlgorithmInterface alg = bg.buildAlg();
        int n = bg.buildN();
        Runtime runtime = Runtime.getRuntime();
        CSVFile file = new CSVFile();

        for (CaseEnum c : CaseEnum.values()) {

            Result result = new Result();
            int[][] caseType = alg.assembleCase(n, c.getCod());
            Long[] memoryUsed = new Long[caseType.length];
            Long[] timeUsed = new Long[caseType.length];
            for(int i = 0; i<caseType.length; i++) {
                System.gc();
                Thread.sleep(100);
                long startTime = System.nanoTime();
                alg.order(caseType[i]);
                long endTime = System.nanoTime();

                memoryUsed[i] = alg.getHigherMemory();
                timeUsed[i] = endTime - startTime;
            }
            Long highMemoryUsed = calculatesAverage(memoryUsed);
            Long highTimeUsed = calculatesAverage(timeUsed);
            result.build(n, alg.getClass().getSimpleName(), c, highMemoryUsed, highTimeUsed);
            System.out.println("Gravando " + " Algoritmo " + alg.getClass().getSimpleName() + " no " + c.toString() + " caso " + " com " + n + " elementos " + highMemoryUsed);
            System.out.println(result.toString());
            file.saveCsv(result.toString());
        }
        file.saveCsv("\n\n");
    }

    private static Long calculatesAverage(Long[] array) {
        Long sum = 0L;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

}
