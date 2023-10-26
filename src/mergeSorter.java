import java.util.ArrayList;
import java.util.List;

public class mergeSorter {
    public static List<Integer> mergesort(List<Integer> inputList) {
        if (inputList.size() <= 1) {
            return inputList; // Base case: An empty list or a list with one element is already sorted.
        }

        int middle = inputList.size() / 2;
        List<Integer> left = inputList.subList(0, middle);
        List<Integer> right = inputList.subList(middle, inputList.size());

        left = mergesort(left);
        right = mergesort(right);

        return merge(left, right);
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                result.add(left.get(leftIndex));
                leftIndex++;
            } else {
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));

        return result;
    }
}
