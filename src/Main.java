import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

public class Main {
    public static int[] createRandomArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(101); // Generate random integers between 0 and 100
        }
        return array;
    }

    public static void writeArrayToFile(int[] array, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int value : array) {
                writer.println(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] readFileToArray(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            int arrayLength = (int) new BufferedReader(new FileReader(filename)).lines().count();
            int[] array = new int[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                if (scanner.hasNextInt()) {
                    array[i] = scanner.nextInt();
                }
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
            return new int[0];
        }
    }

    public static void bubbleSort(int[] array, Comparator<Integer> comparator) {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (comparator.compare(array[i - 1], array[i]) > 0) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int arrayLength = scanner.nextInt();

        int[] randomArray = createRandomArray(arrayLength);
        writeArrayToFile(randomArray, "random_array.txt");
        System.out.println("Random array has been generated and saved in 'random_array.txt'");

        int[] unsortedArray = readFileToArray("random_array.txt");

        // Example usage of BubbleSort with integers
        bubbleSort(unsortedArray, Comparator.naturalOrder());
        writeArrayToFile(unsortedArray, "sorted_array.txt");
        System.out.println("Array has been sorted and saved in 'sorted_array.txt'");

        scanner.close();
    }
}
