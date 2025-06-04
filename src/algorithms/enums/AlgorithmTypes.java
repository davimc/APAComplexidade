package algorithms.enums;

import algorithms.AlgorithmInterface;
import algorithms.InPlaceMergeSort;
import algorithms.Librarysort;
import algorithms.Shellsort;

public enum AlgorithmTypes {

    INMERGE("In-Merge Sort", new InPlaceMergeSort());//,, SHELL("Shellsort", new Shellsort()),LIBRARY("Library", new Librarysort());

    private final String desc;
    private AlgorithmInterface algorithm;

    AlgorithmTypes(String desc, AlgorithmInterface algorithm) {
        this.desc = desc;
        this.algorithm = algorithm;
    }

    public String getDesc() {
        return desc;
    }
    public AlgorithmInterface getAlgorithm() {
        return algorithm;
    }

    public AlgorithmInterface toEnum() {
        if(desc == null) return null;

        for(AlgorithmTypes a: AlgorithmTypes.values())
            if(a.getDesc().equals(desc))
                return a.getAlgorithm();
        throw new IllegalArgumentException(desc + "does not exists");
    }

    @Override
    public String toString() {
        return  desc;
    }
}
