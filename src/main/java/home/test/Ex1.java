package home.test;

public class Ex1 {

    public FuncResult mainFunc(int[] inputArray) {   int max = 0;
        int maxIndexOfMaxValue = 0;
        int minIndexOfMinValue = 0;
        int total = 0;
        int minValue = inputArray[0];
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > max) {
                max = inputArray[i];
            }
            if (inputArray[i] == max) {
                maxIndexOfMaxValue = i;
            }
            if (i != 0 && inputArray[i] < minValue) {
                minValue = inputArray[i];
                minIndexOfMinValue = i;
            }
        }
        for (int j = minIndexOfMinValue + 1; j < maxIndexOfMaxValue; j++) {
            total += inputArray[j];
        }
        return new FuncResult(total, minIndexOfMinValue, maxIndexOfMaxValue);
    }
}