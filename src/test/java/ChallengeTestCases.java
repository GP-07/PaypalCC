import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ChallengeTestCases {

    @Test
    public void testCase1() {
        int[] testArray = new int[]{7, 6, 4, -1, 1, 2};
        int targetSum = 16;
        Integer[] expectedComb1 = new Integer[]{7, 6, 4, -1};
        Integer[] expectedComb2 = new Integer[]{7, 6, 1, 2};
        List<Integer[]> expectedResults = new ArrayList<>();
        expectedResults.add(expectedComb1);
        expectedResults.add(expectedComb2);
        executeTestCase(testArray, targetSum, expectedResults);
    }

    @Test
    public void testCase2() {
        int[] testArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        int targetSum = 10;
        Integer[] expectedComb1 = new Integer[]{1, 2, 3, 4};
        List<Integer[]> expectedResults = new ArrayList<>();
        expectedResults.add(expectedComb1);
        executeTestCase(testArray, targetSum, expectedResults);
    }

    @Test
    public void testCase3() {
        int[] testArray = new int[]{5, -5, -2, 2, 3, -3};
        int targetSum = 0;
        Integer[] expectedComb1 = new Integer[]{5, -5, -2, 2};
        Integer[] expectedComb2 = new Integer[]{5, -5, 3, -3};
        Integer[] expectedComb3 = new Integer[]{-2, 2, 3, -3};
        List<Integer[]> expectedResults = new ArrayList<>();
        expectedResults.add(expectedComb1);
        expectedResults.add(expectedComb2);
        expectedResults.add(expectedComb3);
        executeTestCase(testArray, targetSum, expectedResults);
    }

    @Test
    public void testCase4() {
        int[] testArray = new int[]{-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int targetSum = 4;
        Integer[] expectedComb1 = new Integer[]{-2, -1, 1, 6};
        Integer[] expectedComb2 = new Integer[]{-2, 1, 2, 3};
        Integer[] expectedComb3 = new Integer[]{-2, -1, 2, 5};
        Integer[] expectedComb4 = new Integer[]{-2, -1, 3, 4};
        List<Integer[]> expectedResults = new ArrayList<>();
        expectedResults.add(expectedComb1);
        expectedResults.add(expectedComb2);
        expectedResults.add(expectedComb3);
        expectedResults.add(expectedComb4);
        executeTestCase(testArray, targetSum, expectedResults);
    }

    @Test
    public void testCase5() {
        int[] testArray = new int[]{-1, 22, 18, 4, 7, 11, 2, -5, -3};
        int targetSum = 30;
        Integer[] expectedComb1 = new Integer[]{-1, 22, 7, 2};
        Integer[] expectedComb2 = new Integer[]{22, 4, 7, -3};
        Integer[] expectedComb3 = new Integer[]{-1, 18, 11, 2};
        Integer[] expectedComb4 = new Integer[]{18, 4, 11, -3};
        Integer[] expectedComb5 = new Integer[]{22, 11, 2, -5};
        List<Integer[]> expectedResults = new ArrayList<>();
        expectedResults.add(expectedComb1);
        expectedResults.add(expectedComb2);
        expectedResults.add(expectedComb3);
        expectedResults.add(expectedComb4);
        expectedResults.add(expectedComb5);
        executeTestCase(testArray, targetSum, expectedResults);
    }

    @Test
    public void testCase6() {
        int[] testArray = new int[]{-10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5};
        int targetSum = 20;
        Integer[] expectedComb1 = new Integer[]{-5, 2, 15, 8};
        Integer[] expectedComb2 = new Integer[]{-3, 2, -7, 28};
        Integer[] expectedComb3 = new Integer[]{-10, -3, 28, 5};
        Integer[] expectedComb4 = new Integer[]{-10, 28, -6, 8};
        Integer[] expectedComb5 = new Integer[]{-7, 28, -6, 5};
        Integer[] expectedComb6 = new Integer[]{-5, 2, 12, 11};
        Integer[] expectedComb7 = new Integer[]{-5, 12, 8, 5};
        List<Integer[]> expectedResults = new ArrayList<>();
        expectedResults.add(expectedComb1);
        expectedResults.add(expectedComb2);
        expectedResults.add(expectedComb3);
        expectedResults.add(expectedComb4);
        expectedResults.add(expectedComb5);
        expectedResults.add(expectedComb6);
        expectedResults.add(expectedComb7);
        executeTestCase(testArray, targetSum, expectedResults);
    }

    @Test
    public void testCase7() {
        int[] testArray = new int[]{1, 2, 3, 4, 5};
        int targetSum = 100;
        List<Integer[]> expectedResults = new ArrayList<>();
        executeTestCase(testArray, targetSum, expectedResults);
    }

    @Test
    public void testCase8() {
        int[] testArray = new int[]{1, 2, 3, 4, 5, -5, 6, -6};
        int targetSum = 5;
        Integer[] expectedComb1 = new Integer[]{2, 3, 5, -5};
        Integer[] expectedComb2 = new Integer[]{1, 4, 5, -5};
        Integer[] expectedComb3 = new Integer[]{2, 4, 5, -6};
        Integer[] expectedComb4 = new Integer[]{1, 3, -5, 6};
        Integer[] expectedComb5 = new Integer[]{2, 3, 6, -6};
        Integer[] expectedComb6 = new Integer[]{1, 4, 6, -6};
        List<Integer[]> expectedResults = new ArrayList<>();
        expectedResults.add(expectedComb1);
        expectedResults.add(expectedComb2);
        expectedResults.add(expectedComb3);
        expectedResults.add(expectedComb4);
        expectedResults.add(expectedComb5);
        expectedResults.add(expectedComb6);
        executeTestCase(testArray, targetSum, expectedResults);
    }

    private void executeTestCase(int[] array, int targetSum, List<Integer[]> expectedResults) {
        List<Integer[]> actualResults = JavaChallenge.fourNumberSum(array, targetSum);
        int sameCombinations = 0;
        Assertions.assertEquals(expectedResults.size(), actualResults.size());
        for(Integer[] actualResult: actualResults) {
            for (Integer[] expectedResult: expectedResults) {
                if (sameCombination(expectedResult, actualResult)) {
                    sameCombinations += 1;
                }
            }
        }
        Assertions.assertEquals(expectedResults.size(), sameCombinations);
    }

    private boolean sameCombination(Integer[] expectedResult, Integer[] actualResult) {
        List<Integer> sortedExpectedResult = Arrays.stream(expectedResult).sorted().collect(Collectors.toList());
        List<Integer> sortedActualResult = Arrays.stream(actualResult).sorted().collect(Collectors.toList());
        return Objects.equals(sortedExpectedResult.get(0), sortedActualResult.get(0)) &&
                Objects.equals(sortedExpectedResult.get(1), sortedActualResult.get(1)) &&
                Objects.equals(sortedExpectedResult.get(2), sortedActualResult.get(2)) &&
                Objects.equals(sortedExpectedResult.get(3), sortedActualResult.get(3));
    }
}
