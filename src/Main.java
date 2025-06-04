import algorithms.*;
import algorithms.enums.AlgorithmTypes;
import algorithms.enums.CaseEnum;
import utils.CSVFile;
import utils.Result;

import java.io.IOException;
import java.util.Arrays;

//Main utilizado para execução de todos
//TODO fazer o main que será enviado no arquivo executável
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        AlgorithmInterface algorithm;
        for (int n = 10; n <= 10000000; n *= 10) {
            CSVFile file = new CSVFile();
            for (AlgorithmTypes t : AlgorithmTypes.values()) {
                for (CaseEnum c : CaseEnum.values()) {

                    Result result = new Result();
                    algorithm = new InPlaceMergeSort();
                    int[][] caseType = algorithm.assembleCase(n, c.getCod());
                    Long[] memoryUsed = new Long[caseType.length];
                    Long[] timeUsed = new Long[caseType.length];
                    for(int i = 0; i<caseType.length; i++) {
                        System.gc();
                        Thread.sleep(100);
                        long startTime = System.nanoTime();
                        algorithm.order(caseType[i]);
                        long endTime = System.nanoTime();

                        memoryUsed[i] = algorithm.getHigherMemory();
                        timeUsed[i] = endTime - startTime;
                    }
                    Long highMemoryUsed = calculatesAverage(memoryUsed);
                    Long highTimeUsed = calculatesAverage(timeUsed);
                    result.build(n, t, c, highMemoryUsed, highTimeUsed);
                    System.out.println("Gravando " + " Algoritmo " + t.toString() + " no " + c.toString() + " caso " + " com " + n + " elementos " + highMemoryUsed);
                    System.out.println(result.toString());
                    file.saveCsv(result.toString());
                }
            }
            file.saveCsv("\n\n");
        }
    }

    private static Long calculatesAverage(Long[] array) {
        Long sum = 0L;
        for(int i = 0; i<array.length; i++) {
            sum += array[i];
        }
        return sum/array.length;
    }
}
/*
        int[][] caseType = new Shellsort().assembleCase(100, "m");


        for(int i =0; i<caseType.length;i++) {
            System.out.println("caso " + i);
            for (int j = 0; j < caseType[i].length; j++)
                System.out.println(caseType[i][j]);

*/

//        AlgorithmImpl obj = new Shellsort();
//        int[] worst = obj.assembleCase(100, "w");
//        long startTime = System.nanoTime();
//        worst = obj.order(worst);
//        long endTime = System.nanoTime();
//        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
//        long memoryUsed = memoryAfter - memoryBefore;

