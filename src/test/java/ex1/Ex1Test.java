package ex1;

import home.test.Ex1;
import home.test.FuncResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

public class Ex1Test {
    private final Ex1 ex1 = new Ex1();

    @ParameterizedTest
    @MethodSource("testCases")
    public void test1(int[] inputValue, int sumResult, int minIndex, int maxIndex) {
        long start = System.nanoTime();
        FuncResult funcResult = ex1.mainFunc(inputValue);
        long l = System.nanoTime() - start;
        System.out.println(l);
        assertArrayEquals(inputValue.clone(), inputValue, "Массивы не совпадают");
        assertEquals(sumResult, funcResult.getSumResult(), "Неверная сумма");
        assertEquals(minIndex, funcResult.getMinIndex(), "Неверный минимальный индекс");
        assertEquals(maxIndex, funcResult.getMaxIndex(), "Неверный максимальный индекс");

        assertTrue(l < 5000, "Время выполнения слишком долгое");
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                of(new int[]{0}, 0, 0, 0),
                of(new int[]{3, 1, 0, 2, 0, 7, 5}, 2, 2, 5),
                of(new int[]{1, 3, 5, 9, 1, 9}, 18, 0, 5),
                of(new int[]{9, 0, 8, 6, 0, 0, 9, 9}, 23, 1, 7),
                of(new int[]{0, 5, 3, 5, 6, 7, 3, 9}, 29, 0, 7),
                of(new int[]{9, 0, 8, 6, 0, 0, 9, 9}, 23, 1, 7)
                );
    }
}
//написать функцию которая должна принимать на вход массив,
// результатом выполнения функции должна быть сумма всех чисел между максимальным и минимальным числом
// (наиболее удаленными друг от друга значениями)
//так же результом должен быть четкий указатель индексов, которым
// принадлежат минимум и максимум в формате: maxIndex, minIndex, sum