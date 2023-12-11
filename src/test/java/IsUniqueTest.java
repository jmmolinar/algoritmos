import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.example.arraysstringhashtables.IsUnique;

public class IsUniqueTest {

  @Test
  public void isUniqueTest() {
    IsUnique isUnique = new IsUnique();
    System.out.println("\nVERIFICACION CARACTERES UNICOS PARA STRING abcde");
    assertTrue(isUnique.isUnique("abcde"));
    System.out.println("\nVERIFICACION CARACTERES UNICOS PARA STRING aAbBcCdDeE");
    assertTrue(isUnique.isUnique("aAbBcCdDeE"));
    System.out.println("\nVERIFICACION CARACTERES UNICOS PARA STRING abcded");
    assertFalse(isUnique.isUnique("abcded"));
  }
}