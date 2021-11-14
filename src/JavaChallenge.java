import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaChallenge {

    public static void main(String[] args) {
        int[] testArray = new int[]{-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer[]> combinations = fourNumberSum(testArray, 4);
        System.out.println("*** Final Result ***");
        combinations.forEach(combination -> {
            System.out.println("Combination :: " +
                    combination[0] + " - " +
                    combination[1] + " - " +
                    combination[2] + " - " +
                    combination[3]);
        });
    }

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<Integer[]>();
        for (int index = 0; index < array.length; index++) {
            if (index + 1 < array.length) {
                int firstNum = array[index];
                int secondNum = array[index + 1];
                int remaining = targetSum - firstNum - secondNum;
                List<int[]> twoRemainingNumbers = findTwoNumsForRemaining(array, firstNum, secondNum, remaining);
                checkAndAdd(firstNum, secondNum, twoRemainingNumbers, result);
            }
        }
        return result;
    }

    private static List<int[]> findTwoNumsForRemaining(int[] array, int firstNum, int secondNum, int remaining) {
        List<int[]> twoNums = new ArrayList<>();
        for (int i : array) {
            if (isSelectable(i, firstNum, secondNum)) {
                for (int k : array) {
                    // I assume the original array has no repeated numbers and therefore, there will be no repeated number in the combinations
                    if (isSelectable(k, firstNum, secondNum) && i != k && i + k == remaining) {
                        int[] combination = new int[2];
                        combination[0] = i;
                        combination[1] = k;
                        System.out.println("Adding combination for remaining: " + combination[0] + " - " + combination[1]);
                        twoNums.add(combination);
                    }
                }
            }
        }
        return twoNums;
    }

    private static boolean isSelectable(int candidate, int firstNum, int secondNum) {
        return candidate != firstNum && candidate != secondNum;
    }

    private static void checkAndAdd(int firstNum, int secondNum, List<int[]> twoRemainingNumbers, List<Integer[]> otherPosibilities) {
        for (int[] twoRemainingNumber : twoRemainingNumbers) {
            Integer[] aNewPosibility = new Integer[4];
            aNewPosibility[0] = firstNum;
            aNewPosibility[1] = secondNum;
            aNewPosibility[2] = twoRemainingNumber[0];
            aNewPosibility[3] = twoRemainingNumber[1];
            System.out.println("** Testing posibility: " +
                    aNewPosibility[0] + " - " +
                    aNewPosibility[1] + " - " +
                    aNewPosibility[2] + " - " +
                    aNewPosibility[3]
            );
            if (!sameToAnotherExistingPosibility(aNewPosibility, otherPosibilities)) {
                otherPosibilities.add(aNewPosibility);
            }
        }
    }

    private static boolean sameToAnotherExistingPosibility(Integer[] aNewPosibility, List<Integer[]> otherPosibilities) {
        boolean res = false;
        for (Integer[] otherPosibility : otherPosibilities) {
            if (!res && samePosibilities(aNewPosibility, otherPosibility)) {
                res = true;
            }
        }
        return res;
    }

    private static boolean samePosibilities(Integer[] aNewPosibility, Integer[] otherPosibility) {
        List<Integer> copyAPosibility = Arrays.asList(aNewPosibility);
        List<Integer> listOtherPosibility = Arrays.asList(otherPosibility);
        return listOtherPosibility.containsAll(copyAPosibility);
    }
}
