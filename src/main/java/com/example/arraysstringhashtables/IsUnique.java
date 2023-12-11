package com.example.arraysstringhashtables;

import java.util.HashSet;
import java.util.Set;

/*
 * Dado un método que recibe una String, comprobar si todos los caracteres son únicos o no.
 *
 * isUnique("abcde") => true;
 * isUnique("abcded") => false;
 */
public class IsUnique {

  //public boolean isUnique(String s) {
  //  throw new UnsupportedOperationException("Not implemented yet");
  //}

  // Asumiendo que es ASCII. Dependiendo de la codificación serán más
  private static int NUMBER_OF_CHARS = 128;

  public boolean isUnique(String s) {
    System.out.println("String recibido: " + s);
    if (s.length() > NUMBER_OF_CHARS) {
        System.out.println("La longitud del string recibido es mayor a " + NUMBER_OF_CHARS + ". Por lo tanto hay repetidos, se retorna False");
        return false;
    }

    Set<Character> set = new HashSet<Character>();
    for (char c : s.toCharArray()) {
      if (set.contains(c)) {
        System.out.println("Caracter " + c + " ya se encuentra en String recibido, se retorna False");
        return false;
      }
      //System.out.println("Caracter agregado al set para verificacion: " + c);
      set.add(c);
    }

    System.out.println("Caracteres Unicos, se retorna True");
    return true;
  }

}
