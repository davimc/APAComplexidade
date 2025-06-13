import algorithms.enums.AlgorithmTypes;
import algorithms.enums.CaseEnum;
import java.time.LocalDateTime;

public class Result {
    private LocalDateTime date;
    private AlgorithmTypes algorithmTypes = null;
    private String algorithmName;
    private int n;
    private CaseEnum caseType;
    private Long timeUsed;
    private Long memoryUsed;

    public Result() {
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public AlgorithmTypes getAlgorithmTypes() {
        return algorithmTypes;
    }

    public void setAlgorithmTypes(AlgorithmTypes algorithmTypes) {
        this.algorithmTypes = algorithmTypes;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public CaseEnum getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseEnum caseType) {
        this.caseType = caseType;
    }

    public Long getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(Long timeUsed) {
        this.timeUsed = timeUsed;
    }

    public Long getMemoryUsed() {
        return memoryUsed;
    }

    public void setMemoryUsed(Long memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    public void build(int n, AlgorithmTypes algorithmType, CaseEnum caseType, Long memoryUsed, Long timeUsed) {
        this.setDate(LocalDateTime.now());
        this.setN(n);
        this.setAlgorithmTypes(algorithmType);
        this.setCaseType(caseType);
        this.setMemoryUsed(memoryUsed);
        this.setTimeUsed(timeUsed);
    }
    public void build(int n, String algorithmType, CaseEnum caseType, Long memoryUsed, Long timeUsed) {
        this.setDate(LocalDateTime.now());
        this.setN(n);
        this.setAlgorithmName(algorithmType);
        this.setCaseType(caseType);
        this.setMemoryUsed(memoryUsed);
        this.setTimeUsed(timeUsed);
    }
    @Override
    public String toString() {
        return date +
                "," + algorithmName +
                "," + n +
                "," + caseType.toString() +
                "," + memoryUsed +
                "," + timeUsed;

    }
}
