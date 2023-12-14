import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import com.example.arraysstringhashtables.GroupAnagrams;

/*
 * Clase que contiene test relacionados a la clase GroupAnagrams.java
 */
public class GroupAnagramsTest {
    /**
     * Test en donde dado un array de strings, devuelve los anagramas agrupados
     */
    @Test
    public void groupAnagramsTest() {
        GroupAnagrams groupAnagrams = new GroupAnagrams();

        System.out.println("\n************************************************************");
        System.out.println("VERIFICACION DE LISTA VACIA:");
        System.out.println("************************************************************");
        List<List<String>> empty = groupAnagrams.groupAnagrams(new String[] {});
        assertTrue(empty.isEmpty());

        System.out.println("\n************************************************************");
        System.out.println("CREACION DE LISTAS CON ANAGRAMAS:");
        System.out.println("************************************************************");

        String[] words = new String[] { "saco", "arresto", "programa", "rastreo", "caso" };
        System.out.println("Arreglo orignal de palabras: " + Arrays.toString(words));

        List<List<String>> anagrams = groupAnagrams.groupAnagrams(words);
        assertTrue(anagrams.size() == 3);

        List<String> listOne = new ArrayList<String>();
        listOne.add("programa");
        List<String> listTwo = new ArrayList<String>();
        listTwo.add("saco");
        listTwo.add("caso");
        List<String> listThree = new ArrayList<String>();
        listThree.add("arresto");
        listThree.add("rastreo");

        System.out.println("\n***********************************************************************************");
        System.out.println("VALIDAR SI UNA LISTA DE PALABRAS SE ENCUENTRA EN EL LISTADO DE LISTAS DE ANAGRAMAS:");
        System.out.println("***********************************************************************************");
        System.out.println("  \nListado de listas de anagramas: " + anagrams);
        System.out.println("  Lista a verificar: " + listOne);
        assertTrue(containsAll(anagrams, listOne));
        System.out.println("  \nLista a verificar: " + listTwo);
        assertTrue(containsAll(anagrams, listTwo));
        System.out.println("  \nLista a verificar: " + listThree);
        assertTrue(containsAll(anagrams, listThree));
    }

    /**
     * Metodo que valida si el listado de listas de anagramas contiene una listaespecifica de palabras
     * @param anagrams listado de listas con anagramas agrupados
     * @param group    lista de palabras agrupadas
     * @return true o false al validar que la lista de palabras se encuentre en el listado de listas de anagramas
     */
    private boolean containsAll(List<List<String>> anagrams, List<String> group) {
        for (List<String> g : anagrams) {
            if (g.containsAll(group)) {
                System.out.println("    Lista de palabras se encuentra dentro de Listado de lista de anagramas");
                return true;
            }
        }
        System.out.println("    Lista de palabras NO se encuentra dentro de Listado de lista de anagramas");
        return false;
    }
}
