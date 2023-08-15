package home.test;

public class Ex1 {

    public FuncResult mainFunc(int[] inputArray) {
        int max = 0;
        int min = 0;
        int minValue = inputArray[0];
        int maxValue = inputArray[0];
        int[] ar = new int[4];
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > max) {
                max = inputArray[i];
            }
            if (inputArray[i] < min) {
                min = inputArray[i];
            }
            if (inputArray[i] == min) {
                ar[1] = i;
            }
            if (inputArray[i] == max) {
                ar[3] = i;
            }
            if (i != 0 && inputArray[i] < minValue) {
                minValue = inputArray[i];
                ar[0] = i;
            }
            if (i != 0 && inputArray[i] > maxValue) {
                maxValue = inputArray[i];
                ar[2] = i;
            }
        }
        int theBiggestSum = 0;
        int first = 0;
        int last = 0;
        int firstIndex = 0;
        int lastIndex = 0;
        for (int i = 0; i < 2; i++) {
            int a = ar[i];
            int b = ar[i + 2];
            int c = ar[3 - i];

            if (Math.abs(a - b) >= theBiggestSum) {
                theBiggestSum = a + b;
                if (a < b) {
                    firstIndex = a;
                    lastIndex = b;
                } else if (a > b) {
                    firstIndex = b;
                    lastIndex = a;
                }
                first = a;
                last = b;
            }
            if (Math.abs(a - c) >= theBiggestSum) {
                theBiggestSum = a + c;
                if (a < c) {
                    firstIndex = a;
                    lastIndex = c;
                } else if (a > c) {
                    firstIndex = c;
                    lastIndex = a;
                }
                first = a;
                last = c;
            }
        }
        int total = 0;
        for (int i = firstIndex + 1; i < lastIndex; i++) {
            total += inputArray[i];
        }
        return new FuncResult(total, first, last);
    }
}