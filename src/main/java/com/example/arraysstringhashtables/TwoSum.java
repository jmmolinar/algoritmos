package com.example.arraysstringhashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Dado un array de números enteros y un target, retorna los índices de dos
 * números para los que la suma de ambos sea igual al target.
 *
 * Asumir que hay solamente una solución.
 *
 * Ejemplo 1:
 *  Input: nums = [9,2,5,6], target = 7
 *  Output: [1,2]
 *  Explicación: nums[1] + nums[2] == 7, devolvemos [1, 2].
 *
 * Ejemplo 2:
 *  Input: nums = [9,2,5,6], target = 100
 *  Output: null
 */
public class TwoSum {

  //public int[] twoSum(int[] nums, int target) {
  //  throw new UnsupportedOperationException("Not implemented yet");
  //}

  public int[] twoSum(int[] nums, int target) {
    System.out.println("Arreglo recibido: " + Arrays.toString(nums));
    System.out.println("Target recibido: " + target);

    if (nums == null || nums.length < 2){
        System.out.println("El arreglo no tiene las caracteristicas necesarias para ser evaluado.");
        return null;
    } 

    //Solucion con complejidad cuadratica
    /*int [] resultado = new int[2];
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                resultado[0] = i;
                resultado[1] = j;
                System.out.println("Output: " + Arrays.toString(resultado));
                return resultado;
            }
        }
    }
    System.out.println("Output: null");
    return null;*/

    //Solucion con complejidad lineal (una sola pasada por el arreglo)

    //Se trabaja con un mapa que almacene el complemento necesario que sumado al elemento obtenga el valor del target

    Map<Integer, Integer> complementsMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        System.out.println("Iteracion " + i);
        if (complementsMap.containsKey(nums[i])) {
            int[] output = new int[]{i, complementsMap.get(nums[i])};
            System.out.println("Mapa de complementos: ");
            complementsMap.forEach((key, value) -> System.out.println("[Key] : " + key + " [Value] : " + value));
            System.out.println("Los siguientes indices del arreglo suman el target: ");
            System.out.println("Output: " + Arrays.toString(output));
            return output;
        }
        int complement = target - nums[i]; // target = complement + nums[i]
        System.out.println("Iteracion " + i + " -> complement: " + complement);
        complementsMap.put(complement, i);
    }

    System.out.println("Mapa de complementos: ");
    complementsMap.forEach((key, value) -> System.out.println("[Key] : " + key + " [Value] : " + value));
    System.out.println("No se tienen 2 valores del arreglo que sumados sean iguales al target");
    System.out.println("Output: " + null);
    return null;
  }
}