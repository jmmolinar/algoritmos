import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.Arrays;

import com.example.arraysstringhashtables.TwoSum;

/*
 * Clase que contiene test relacionados a la clase TwoSum.java
 */
public class TwoSumTest {
    /**
     * Test que retorna los indices de dos numero que sumen el valor de un target esperado
     */
    @Test
    public void twoSumTest() {
        int[] array = new int[] { 9, 2, 5, 6 };
        int targetUno = 7;
        int targetDos = 50;
        TwoSum twoSum = new TwoSum();

        System.out.println("\nOBTENCION DE INDICES DEL ARRAY " + Arrays.toString(array) + " QUE SUMEN " + targetUno);
        int[] result = twoSum.twoSum(array, targetUno);
        assertTrue((result[0] == 1 && result[1] == 2) || (result[0] == 2 && result[1] == 1));
        System.out.println("\nOBTENCION DE INDICES DEL ARRAY " + Arrays.toString(array) + " QUE SUMEN " + targetDos);
        assertEquals(null, twoSum.twoSum(array, targetDos));
    }
}
