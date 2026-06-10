import java.util.Arrays;

/**
 * @author Kozlova
 */
public class Exercise {

    /**
     * @param matrix 
     * @return 
     */
    public static int[][] Calculate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0][0];
        }

        int n = matrix.length;

        int[] flatArray = Arrays.stream(matrix)
                                .flatMapToInt(Arrays::stream)
                                .toArray();

        Arrays.sort(flatArray);

        int[][] sortedMatrix = new int[n][n];
        Arrays.setAll(sortedMatrix, i -> 
            Arrays.copyOfRange(flatArray, i * n, (i + 1) * n)
        );

        return sortedMatrix;
    }
}