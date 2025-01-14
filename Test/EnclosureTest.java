

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

import Sanctuary.Enclosure;
import Sanctuary.Food;
import Sanctuary.Monkey;
import Sanctuary.Sex;
import Sanctuary.Size;
import Sanctuary.Species;

public class EnclosureTest {

  private Enclosure enclosure;
  private Monkey milo;
  private Monkey lucy;
  private Monkey max;

  @Before
  public void setUp() {
    enclosure = new Enclosure(Species.HOWLER);
    milo = new Monkey("Milo", Species.HOWLER, Sex.MALE, Size.LARGE, 15.5, 8, Food.FRUITS);
    lucy = new Monkey("Lucy", Species.HOWLER, Sex.FEMALE, Size.MEDIUM, 9.1, 6, Food.NUTS);
    max = new Monkey("Max", Species.HOWLER, Sex.MALE, Size.MEDIUM, 11.2, 5, Food.INSECTS);
  }

  @Test
  public void testGetTroop() {
    assertEquals(Species.HOWLER, enclosure.getTroop());
  }

  @Test
  public void testMoveIn() {
    enclosure.moveIn(milo);
    List<Monkey> occupants = enclosure.getOccupants();
    assertTrue(occupants.contains(milo));
  }

  @Test
  public void testMoveOut() {
    enclosure.moveIn(milo);
    enclosure.moveOut(milo);
    List<Monkey> occupants = enclosure.getOccupants();
    assertFalse(occupants.contains(milo));
  }

  @Test
  public void testMoveInDifferentSpecies() {
    Monkey bella = new Monkey("Bella", Species.MANGABEY, Sex.FEMALE, Size.MEDIUM, 8.7, 7, Food.EGGS);
    enclosure.moveIn(bella);
    List<Monkey> occupants = enclosure.getOccupants();
    assertFalse(occupants.contains(bella));
  }

  @Test
  public void testMoveInNewArrival() {
    milo.setIsNewArrival(true);
    enclosure.moveIn(milo);
    List<Monkey> occupants = enclosure.getOccupants();
    assertFalse(occupants.contains(milo));
  }

  @Test
  public void testMoveInNeedsMedical() {
    milo.setNeedsMedical(true);
    enclosure.moveIn(milo);
    List<Monkey> occupants = enclosure.getOccupants();
    assertFalse(occupants.contains(milo));
  }

  @Test
  public void testGetList() {
    enclosure.moveIn(milo);
    enclosure.moveIn(lucy);
    enclosure.moveIn(max);
    List<String> monkeyList = enclosure.getList();
    assertTrue(monkeyList.contains("Name: Milo, Sex: MALE, Favorite Food: FRUITS"));
    assertTrue(monkeyList.contains("Name: Lucy, Sex: FEMALE, Favorite Food: NUTS"));
    assertTrue(monkeyList.contains("Name: Max, Sex: MALE, Favorite Food: INSECTS"));
  }
}
