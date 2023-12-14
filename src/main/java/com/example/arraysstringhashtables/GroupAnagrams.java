package com.example.arraysstringhashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Un anagrama es una palabra creada a partir de la reordenación de las letras de otra palabra. Ej: saco - caso
 * Dado un array de strings, devuelve los anagramas agrupados.
 *
 * Ejemplo:
 *  Input: words = ["saco", "arresto", "programa", "rastreo", "caso"]
 *  Output: [["saco", "caso"], ["arresto", "rastreo"], ["programa"]].
 * 
 * Se resuelve contando las apariciones de una letra en cada palabra de acuerdo a las letras del abecedario y almacenando el hash de cada palabra
 * La solucion obvia seria recorrer cada palabra del arreglo de entrada y comparar cada una de ellas con las otras, pero eso representaria una complejidad cuadratica.
 * Por esa razon se toma la alternativa de conteo de letras y almacenamiento de hash de cada palabra en Hash map.
 */
public class GroupAnagrams {

    /**
     * Metodo que agrupa las palabras en anagramas
     * @param words
     * @return listado con listas de anagramas agrupados
     */
    public List<List<String>> groupAnagrams(String[] words) {
        if (words == null || words.length == 0) {
            System.out.println("  Lista de palabras vacia");
            return Collections.emptyList();
        }

        //Agrupar las palabras en anagramas
        Map<String, List<String>> anagramMap = buildAnagramMap(words);
        System.out.println("  \nContenido de mapa con anagramas:");
        anagramMap.forEach((key, value) -> System.out.println("    [Key] : " + key + " [Value] : " + value));

        List<List<String>> output = new ArrayList<>(anagramMap.values());
        System.out.println("  \nListado de anagramas agrupados: " + output);

        return output;
    }

    /**
     * Metodo que almacena en mapa el hash de una palabra y su lista de anagramas (su palabra como tal en el value)
     * Como clave tendra el hash obtenido para una palabra desde getAnagramHash
     * Como valor tendra la lista de todas las palabras que sean anagramas
     * @param words lista de palabras a evaluar
     * @return mapa que contiene hash de una palabra o anagrama y su lista de anagramas
     */
    private Map<String, List<String>> buildAnagramMap(String[] words) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String word : words) {
            String hashWord = getAnagramHash(word); //para cada palabra se calcula su hash
            System.out.println("    AnagramHash para la palabra: " + word);
            System.out.println("    hashWord: " + hashWord);
            //Si hashWord no existe en el mapa, se debe inicializar una lista vacia 
            //en la que se introduciran los anagramas de esa palabra 'word'
            if (!anagramMap.containsKey(hashWord)) {
                anagramMap.put(hashWord, new ArrayList<>());
            } else {
                System.out.println("      Ya se tiene una clave con este hashWord en el mapa, solo se agregara la palabra '" + word + "' a su lista en value.");
            }
            //Se agrega la palabra contenida en 'word' a la lista de anagramas para ese hashWord
            //Si se crea un hashWord a otra palabra y resulta similar a otro hashWord que ya se encuentra en el mapa
            //simplemente se agrega la palabra a la lista de palabras de ese hashWord
            //Por ejemplo: el hashWord de caso y saco sera el mismo. Entonces se tendra una sola clave hashWord en el mapa para estas palabras
            //pero en su value tendra dos elementos en la lista, es decir, tendra 'caso' y 'saco'
            anagramMap.get(hashWord).add(word);
            System.out.println("      El value para este hashWword queda en: " + anagramMap.get(hashWord));
        }
        return anagramMap;
    }

    /**
     * Metodo para obtener el hash de un anagrama contando las veces que aparece un caracter de una palabra en relacion a las letras del abecedario
     * @param word palabra a evaluar
     * @return string del hash de una palabra
     */
    private String getAnagramHash(String word) {
        //Se necesita un array de enteros con longitud igual al total de las letras del abecedario.
        int[] letterCount = new int[26]; //26 caracteres descartando la ñ
        
        //Ahora se recorren todos los caracteres de la palabra, tomando cada caracter como entero.
        //Un char es equivalente a un entero ya que representa un valor entero en el charSet ASCII.
        //Ver: https://www.asciitable.com/
        //Por ejemplo: en ASCII el caracter 'a' es igual a 97, 'b' es 98, 'c' es 99. Estan ordenados.
        
        //Recorrido de caracteres de la palabra
        //Explicacion: 
        // Si lleter es a, entonces a - a = 97 - 97 = 0,
        // es decir, seria letterCount[0], siendo 0 el indice.  
        // Nota: Inicialmente, todos los elementos del array al declararse tienen valor 0
        // Entonces con el letterCount[0]++, incrementamos el valor de letterCount[0] en una unidad
        // quedando el elemento del indice letter[0] con valor 1
        // Si lleter es b, entonces b - a = 98 - 97 = 1,
        // es decir, seria letterCount[1], siendo 1 el indice.
        // Entonces con el letterCount[1]++, incrementamos el valor de letterCount[1] en una unidad
        // quedando el elemento del indice letterCount[1] con valor 1
        // De esta manera se cuentan las apariciones de una determinada letra y se va guardando el conteo en el arreglo
        // Ejemplo:
        //   Si la palabra es 'abc', el arreglo letterCount quedaría con los valores [1,1,1,....] 
        //   con ceros despues de la posicion 2 hasta la 25.
        
        for (int letter : word.toCharArray()) {
            letterCount[letter - 'a']++;
        }

        //Teniendo el hash de la palabra construido, se retorna como String
        return Arrays.toString(letterCount);
    }
}
