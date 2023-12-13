package com.example.arraysstringhashtables;

/*
 * Dada una matriz, escribe un algoritmo para establecer ceros en la fila F y columna C si existe un
 * 0 en la celda F:C
 *
 * Ejemplo:
 *  Input: 2 1 3 0 2 -> matrix[0] primera fila
 *         7 4 1 3 8 -> matrix[1] segunda fila
 *         4 0 1 2 1 -> matrix[2]
 *         9 3 4 1 9 -> matrix[3]
 *
 *  Output: 0 0 0 0 0
 *          7 0 1 0 8
 *          0 0 0 0 0
 *          9 0 4 0 9
 */
public class ZeroMatrix {

    // public void zeroMatrix(int[][] matrix) {
    // throw new UnsupportedOperationException("Not implemented yet");
    // }

    /**
     * Metodo que procesa los elementos de matriz para establecer ceros en la fila F y columna C si existe un 0 en la celda F:C
     * @param matrix matriz a evaluar
     */
    public void zeroMatrix(int[][] matrix) {
        //Primero se buscan ceros en la primera fila y en la primera columna
        boolean firstRowHasZero = hasFirstRowAnyZero(matrix);
        boolean firstColHasZero = hasFirstColAnyZero(matrix);

        //Ahora se procesa la matriz buscando los ceros en los demas elementos para establecer comienzo de una fila o comienzo de una columna en 0
        //lo que sera util para luego poner en cero el resto de los elementos necesarios con las funcione processRows y processCols
        checkForZeroes(matrix);

        //Se ponen en cero todos los elementos de las filas que lo requieran
        processRows(matrix);
        //Se ponen en cero todos los eleentos de las columnas que lo requieran
        processCols(matrix);

        //Finalmente es llevan a cero todos los elementos de la primera fila y de la primera columna, que no fueron procesadas con checkForZeroes, processRows ni procssCols
        if (firstRowHasZero) {
            System.out.println("La primera fila tiene elemento con valor Cero");
            setRowToZero(matrix, 0);
        }
        if (firstColHasZero) {
            System.out.println("La primera columna tiene elemento con valor Cero");
            setColToZero(matrix, 0);
        }
    }

    /**
     * Metodo que evalua si la primera fila de una matriz tiene ceros
     * @param matrix matriz que sera evaluada
     * @return true o false indicando si la primera fila tiene algun Cero
     */
    private boolean hasFirstRowAnyZero(int[][] matrix) {
        System.out.println("Se evalua si la primera fila de la matriz tiene ceros");
        //Se recorre la primera fila comprobando si tiene algun cero
        for (int i = 0; i < matrix[0].length; i++) {
            //System.out.println("[FILA 0][Columna " + i + "] Valor: " + matrix[0][i]);
            if (matrix[0][i] == 0) { //Si un elemento de la primera fila en la posicion fila 0 columna i es igual a cero
                System.out.println("  Cero encontrado en primera fila, se detiene iteracion sobre sus elementos");
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que evalua si la primera columna de una matriz tiene ceros
     * @param matrix matriz que sera evaluado
     * @return true o false indicando si la primera fila tiene algun Cero
     */
    private boolean hasFirstColAnyZero(int[][] matrix) {
        System.out.println("Se evalua si la primera columna de la matriz tiene ceros");
        //Se recorre la primera columna comprobando si tiene algun cero
        for (int i = 0; i < matrix.length; i++) {
            //System.out.println("[Columna 0][FILA " + i + "] Valor: " + matrix[i][0]);
            if (matrix[i][0] == 0) { //Si un elemento de la primera columna en la posicion fila i columna 0 es igual a cero
                System.out.println("  Cero encontrado en primera columna, se detiene iteracion sobre sus elementos");
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que busca ceros en el resto de la matriz, desde la segunda fila y la segunda columna.
     * Comprueba si un elemento es cero y establece en cero el elemento equivalente en la primera fila y en la primera columna
     * marcando que esa fila y esa columna se deben poner a ceros al final.
     * @param matrix matriz que sera evaluada
     */
    private void checkForZeroes(int[][] matrix) {
        System.out.println("Se buscan ceros desde la segunda fila y la segunda columna");
        //Se recorre toda la matriz desde la 2da fila y la 2da columna
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    //Se hace el cambio de los valores, no se cambia la referencia de matrix pero si su contenido 
                    //Por lo cual no es necesario retornar la matrix -> se modifica su contenido (investigar paso por valor y paso por referencia)
                    matrix[0][col] = 0; // si la celda [row][col] tiene un cero, ponemos el elemento de la 1era fila y esa columna en Cero
                    matrix[row][0] = 0; // si la celda [row][col] tiene un cero, ponemos el elemento de la 1era columna y esa fila en Cero
                }
            }
        } 

    }

    /**
     * Metodo que evalua si la primera celda de una fila tiene cero y coloca en cero el resto de elementos de esa fila por invocacion a setRowToZero
     * @param matrix
     */
    private void processRows(int[][] matrix) {
        System.out.println("Se procesan las filas de la matriz para establecer elementos en cero");
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) { //Si la celda [row][0] tiene un cero (previamente asignado con checkForZeroes), se pone en Cero toda la fila
                setRowToZero(matrix, row);
            }
        }
    }

    /**
     * Metodo que coloca en Cero todos los elementos de una fila
     * @param matrix matriz en evaluacion
     * @param row fila de la matriz en evaluacion
     */
    private void setRowToZero(int[][] matrix, int row) {
        System.out.println("  Se actualiza valor de elementos de la fila a cero");
        for (int col = 0; col < matrix[row].length; col++) { //puede ser matrix[0].length, ya que todas las filas de la matriz tienen igual longitud
            System.out.println("    Fila: " + row + " | Columna: " + col);
            matrix[row][col] = 0;
        }
    }

    /**
     * Metodo que evalua si la primera celda de una columna tiene cero y coloca en cero el resto de elementos de esa columna por invocacion a setColToZero
     * @param matrix
     */
    private void processCols(int[][] matrix) {
        System.out.println("Se procesan las columnas de la matriz para establecer elementos en cero");
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) { //Si la celda [0][col] tiene un cero (previamente asignado con checkForZeroes), se pone en Cero toda la columna
                setColToZero(matrix, col);
            }
        }
    }

    /**
     * Metodo que coloca en Cero todos los elementos de una columna
     * @param matrix matriz en evaluacion
     * @param col columna de la matriz en evaluacion
     */
    private void setColToZero(int[][] matrix, int col) {
        System.out.println("Se actualiza valor de elementos de la columna a cero");
        for (int row = 0; row < matrix.length; row++) { //matrix.length tiene la cantidad de filas de la matriz
            System.out.println("    Columna: " + col + " | Fila: " + row);
            matrix[row][col] = 0;
        }
    }

}
