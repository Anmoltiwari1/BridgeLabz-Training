import java.util.Random;

public class MatrixUtils {

    public static double[][] generateRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10);
        return matrix;
    }

    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        double[][] result = new double[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[j][i] = matrix[i][j];
        return result;
    }

    public static double determinant2x2(double[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    public static double determinant3x3(double[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
             - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
             + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (det == 0) return null;
        double[][] inv = new double[2][2];
        inv[0][0] = m[1][1] / det;
        inv[0][1] = -m[0][1] / det;
        inv[1][0] = -m[1][0] / det;
        inv[1][1] = m[0][0] / det;
        return inv;
    }

    public static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);
        if (det == 0) return null;
        double[][] inv = new double[3][3];

        inv[0][0] = (m[1][1]*m[2][2] - m[1][2]*m[2][1]) / det;
        inv[0][1] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]) / det;
        inv[0][2] = (m[0][1]*m[1][2] - m[0][2]*m[1][1]) / det;

        inv[1][0] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]) / det;
        inv[1][1] = (m[0][0]*m[2][2] - m[0][2]*m[2][0]) / det;
        inv[1][2] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]) / det;

        inv[2][0] = (m[1][0]*m[2][1] - m[1][1]*m[2][0]) / det;
        inv[2][1] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]) / det;
        inv[2][2] = (m[0][0]*m[1][1] - m[0][1]*m[1][0]) / det;

        return inv;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row)
                System.out.printf("%6.2f ", val);
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        double[][] matrix2x2 = generateRandomMatrix(2, 2);
        double[][] matrix3x3 = generateRandomMatrix(3, 3);

        System.out.println("2x2 Matrix:");
        printMatrix(matrix2x2);

        System.out.println("Transpose:");
        printMatrix(transpose(matrix2x2));

        System.out.println("Determinant: " + determinant2x2(matrix2x2));

        double[][] inv2 = inverse2x2(matrix2x2);
        System.out.println("Inverse:");
        if (inv2 != null) printMatrix(inv2); else System.out.println("Matrix not invertible\n");

        System.out.println("3x3 Matrix:");
        printMatrix(matrix3x3);

        System.out.println("Transpose:");
        printMatrix(transpose(matrix3x3));

        System.out.println("Determinant: " + determinant3x3(matrix3x3));

        double[][] inv3 = inverse3x3(matrix3x3);
        System.out.println("Inverse:");
        if (inv3 != null) printMatrix(inv3); else System.out.println("Matrix not invertible\n");
    }
}

