

import org.junit.Test;

import Sanctuary.Food;
import Sanctuary.Monkey;
import Sanctuary.Sex;
import Sanctuary.Size;
import Sanctuary.Species;

import static org.junit.Assert.*;

public class MonkeyTest {

  @Test
  public void testDefaultConstructor() {
    Monkey monkey = new Monkey();
    assertEquals("None", monkey.getName());
    assertEquals(Species.UNKNOWN, monkey.getSpecies());
    assertEquals(Sex.UNKNOWN, monkey.getSex());
    assertEquals(Size.UNKNOWN, monkey.getSize());
    assertEquals(0.0, monkey.getWeight(), 0.001);
    assertEquals(0, monkey.getAge());
    assertEquals(Food.UNKNOWN, monkey.getFavFood());
    assertTrue(monkey.isNewArrival());
    assertTrue(monkey.needsMedical());
  }

  @Test
  public void testParameterizedConstructor() {
    Monkey monkey = new Monkey("Milo", Species.HOWLER, Sex.MALE, Size.LARGE, 15.5, 8, Food.FRUITS);
    assertEquals("Milo", monkey.getName());
    assertEquals(Species.HOWLER, monkey.getSpecies());
    assertEquals(Sex.MALE, monkey.getSex());
    assertEquals(Size.LARGE, monkey.getSize());
    assertEquals(15.5, monkey.getWeight(), 0.001);
    assertEquals(8, monkey.getAge());
    assertEquals(Food.FRUITS, monkey.getFavFood());
    assertFalse(monkey.isNewArrival());
    assertFalse(monkey.needsMedical());
  }

  @Test
  public void testSettersAndGetters() {
    Monkey monkey = new Monkey();
    monkey.setName("Max");
    assertEquals("Max", monkey.getName());

    monkey.setSpecies(Species.GUEREZA);
    assertEquals(Species.GUEREZA, monkey.getSpecies());

    monkey.setSex(Sex.FEMALE);
    assertEquals(Sex.FEMALE, monkey.getSex());

    monkey.setSize(Size.SMALL);
    assertEquals(Size.SMALL, monkey.getSize());

    monkey.setWeight(5.7);
    assertEquals(5.7, monkey.getWeight(), 0.001);

    monkey.setAge(4);
    assertEquals(4, monkey.getAge());

    monkey.setFavFood(Food.NUTS);
    assertEquals(Food.NUTS, monkey.getFavFood());

    monkey.setIsNewArrival(true);
    assertTrue(monkey.isNewArrival());

    monkey.setNeedsMedical(true);
    assertTrue(monkey.needsMedical());
  }

  @Test
  public void testNeedsIsolation() {
    Monkey monkey = new Monkey("Lucy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 5.0, 4, Food.SEEDS);
    assertFalse(monkey.needsIsolation());

    monkey.setNeedsMedical(true);
    assertTrue(monkey.needsIsolation());
  }
}
