package home.test;

public class Ex1 {

    //написать функцию которая должна принимать на вход массив,
    // результатом выполнения функции должна быть сумма всех чисел между максимальным и минимальным числом
    // (наиболее удаленными друг от друга значениями)
    //так же результом должен быть четкий указатель индексов, которым
    // принадлежат минимум и максимум в формате: maxIndex, minIndex, sum

    public FuncResult mainFunc(int[] inputArray) {
        int max = inputArray[0];
        int min = inputArray[0];
        for (int i : inputArray) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }

        int maxValue = inputArray[0];
        int minIndexOfMaxValue = 0;
        int minValue = inputArray[0];
        int minIndexOfMinValue = 0;
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] < minValue) {
                minValue = inputArray[i];
                minIndexOfMinValue = i;
            }
            if (inputArray[i] > maxValue) {
                maxValue = inputArray[i];
                minIndexOfMaxValue = i;
            }
        }

        int maxIndexOfMinValue = 0;
        int maxIndexOfMaxValue = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == min) {
                maxIndexOfMinValue = i;
            }
            if (inputArray[i] == max) {
                maxIndexOfMaxValue = i;
            }
        }

        int firstIndex = 0;
        int lastIndex = 0;
        if (minIndexOfMinValue < maxIndexOfMaxValue) {
            firstIndex = minIndexOfMinValue;
            lastIndex = maxIndexOfMaxValue;
        } else if (minIndexOfMinValue > maxIndexOfMaxValue) {
            firstIndex = maxIndexOfMaxValue;
            lastIndex = minIndexOfMinValue;
        }

        int total = 0;
        for (int i = firstIndex + 1; i < lastIndex; i++) {
            total += inputArray[i];
        }

        FuncResult funcResult = new FuncResult();
        funcResult.setMinIndex(firstIndex);
        funcResult.setMaxIndex(lastIndex);
        funcResult.setSumResult(total);
        return funcResult;
    }

    public static class FuncResult {

        private int sumResult;
        private int minIndex;
        private int maxIndex;


        public int getSumResult() {
            return sumResult;
        }

        public void setSumResult(int sumResult) {
            this.sumResult = sumResult;
        }

        public int getMinIndex() {
            return minIndex;
        }

        public void setMinIndex(int minIndex) {
            this.minIndex = minIndex;
        }

        public int getMaxIndex() {
            return maxIndex;
        }

        public void setMaxIndex(int maxIndex) {
            this.maxIndex = maxIndex;
        }
    }
}