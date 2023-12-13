import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.Test;

import com.example.arraysstringhashtables.ZeroMatrix;

/*
 * Clase que contiene test relacionados a la clase ZeroMatrix.java
 */
public class ZeroMatrixTest {
    /**
     * Test en donde dada una matriz establece ceros en la fila F y columna C si existe un Cero en la celda F:C
     */
    @Test
    public void zeroMatrixTest() {
        ZeroMatrix zeroMatrix = new ZeroMatrix();
        int[][] matrix = {
                { 2, 1, 3, 0, 2 },
                { 7, 4, 1, 3, 8 },
                { 4, 0, 1, 2, 1 },
                { 9, 3, 4, 1, 9 }
        };
        int[][] zeroedMatrix = {
                { 0, 0, 0, 0, 0 },
                { 7, 0, 1, 0, 8 },
                { 0, 0, 0, 0, 0 },
                { 9, 0, 4, 0, 9 }
        };

        System.out.println("\n************************************************************");
        System.out.println(" PRIMERA MATRIZ ORIGINAL -> matrix:");
        System.out.println("************************************************************");
        for (int row[] : matrix) {
            System.out.println(Arrays.toString(row));
        }
        zeroMatrix.zeroMatrix(matrix);
        assertTrue(Arrays.deepEquals(zeroedMatrix, matrix));
        System.out.println("\nRESULTADO PRIMERA MATRIZ ACTUALIZADA CON CEROS -> matrix:");
        for (int row[] : matrix) {
            System.out.println(Arrays.toString(row));
        }

        int[][] matrix2 = {
                { 2, 0, 2 },
                { 0, 2, 1 },
                { 9, 3, 4 }
        };
        int[][] zeroedMatrix2 = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 4 }
        };

        System.out.println("\n************************************************************");
        System.out.println("SEGUNDA MATRIZ ORIGINAL -> matrix2:");
        System.out.println("************************************************************");
        for (int row[] : matrix2) {
            System.out.println(Arrays.toString(row));
        }
        zeroMatrix.zeroMatrix(matrix2);
        assertTrue(Arrays.deepEquals(zeroedMatrix2, matrix2));
        System.out.println("\nRESULTADO SEGUNDA MATRIZ ACTUALIZADA CON CEROS -> matrix2:");
        for (int row[] : matrix2) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * Metodo simple para analizar dimensiones de una matriz
     */
    /*private void checkMatrix() {
        int[][] matrix = {
                { 2, 1, 3, 0, 2 },
                { 7, 4, 1, 3, 8 },
                { 4, 0, 1, 2, 1 },
                { 9, 3, 4, 1, 9 }
        };

        System.out.println("\nmatrix cantidad de filas en una columna: " + matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("[Columna 0][FILA " + i + "] Valor: " + matrix[i][0]);
        }
        System.out.println("\nmatrix cantidad de columnas en una fila: " + matrix[0].length);
    }*/
}
