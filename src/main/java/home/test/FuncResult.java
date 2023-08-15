package home.test;

public class FuncResult {
    private final int sumResult;
    private final int minIndex;
    private final int maxIndex;

    public FuncResult(int sumResult, int minIndex, int maxIndex) {
        this.sumResult = sumResult;
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
    }

    public int getSumResult() {
        return sumResult;
    }

    public int getMinIndex() {
        return minIndex;
    }

    public int getMaxIndex() {
        return maxIndex;
    }
}
