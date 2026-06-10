import java.util.Arrays;

/**
 * @author Kozlova
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Advanced Arrays Practice");
        System.out.println("Sorting matrix (left-to-right, top-to-bottom)\n");

        int[][] sourceMatrix = {
            {31, 7, 20},
            {0, 88, 43},
            {67, 12, 5}
        };

        System.out.println("Source Matrix:");
        printMatrix(sourceMatrix);

        int[][] resultMatrix = Exercise.Calculate(sourceMatrix);

        System.out.println("\nSorted Matrix:");
        printMatrix(resultMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix)
              .forEach(row -> System.out.println(Arrays.toString(row)));
    }
}