import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class mergeSorter<T> {

    public List<T> mergeSort(List<T> inputList, Comparator<T> comparator) {
        if (inputList.size() <= 1) {
            return inputList; // Base case: An empty list or a list with one element is already sorted.
        }

        int middle = inputList.size() / 2;
        List<T> left = inputList.subList(0, middle);
        List<T> right = inputList.subList(middle, inputList.size());

        left = mergeSort(left, comparator);
        right = mergeSort(right, comparator);

        return merge(left, right, comparator);
    }

    private List<T> merge(List<T> left, List<T> right, Comparator<T> comparator) {
        List<T> result = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (comparator.compare(left.get(leftIndex), right.get(rightIndex)) < 0) {
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
