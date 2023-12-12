package com.example.arraysstringhashtables;

import java.util.HashSet;
import java.util.Set;

/*
 * Clase que a traves de un metodo que recibe una String, comprueba si todos los caracteres son unicos o no.
 *
 * isUnique("abcde") => true;
 * isUnique("abcded") => false;
 */
public class IsUnique {

  //public boolean isUnique(String s) {
  //  throw new UnsupportedOperationException("Not implemented yet");
  //}

  /** Constante con cantidad de caracteres maximo en codificacion ASCII*/
  private static int NUMBER_OF_CHARS = 128;

  /**
   * Metodo que realiza la verificacion de caracteres de una cadena recibida para saber si son unicos
   * @param cadenaIn cadena de caracteres a evaluar
   * @return true o false dependiendo si los caracteres son unicos o no
   */
  public boolean isUnique(String cadenaIn) {
    System.out.println("String recibido: " + cadenaIn);
    
    // Asumiendo que es ASCII. Dependiendo de la codificación serán más
    if (cadenaIn.length() > NUMBER_OF_CHARS) {
        System.out.println("La longitud del string recibido es mayor a " + NUMBER_OF_CHARS + ". Por lo tanto hay repetidos, se retorna False");
        return false;
    }

    //Uso de Hash set para verificar repeticiones.  Es mas eficiente que hacer dos for.
    Set<Character> set = new HashSet<Character>();
    for (char c : cadenaIn.toCharArray()) {
      if (set.contains(c)) {
        System.out.println("Caracter " + c + " ya se encuentra en String recibido, se retorna False");
        return false;
      }
      set.add(c);
    }

    System.out.println("Caracteres Unicos, se retorna True");
    return true;
  }

}