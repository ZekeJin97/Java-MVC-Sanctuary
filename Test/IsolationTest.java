

import org.junit.Test;

import Sanctuary.Food;
import Sanctuary.Isolation;
import Sanctuary.Monkey;
import Sanctuary.Sex;
import Sanctuary.Size;
import Sanctuary.Species;

import static org.junit.Assert.*;


import org.junit.Before;


public class IsolationTest {

  private Monkey milo;

  @Before
  public void setUp() {
    milo = new Monkey("Milo", Species.HOWLER, Sex.MALE, Size.LARGE, 15.5, 8, Food.FRUITS);
  }

  @Test
  public void testMoveIn() {
    Isolation isolation = new Isolation(1);
    isolation.moveIn(milo);
    assertEquals(milo, isolation.getOccupant());
  }

  @Test
  public void testMoveOut() {
    Isolation isolation = new Isolation(1);
    isolation.moveIn(milo);
    isolation.moveOut(milo);
    assertNull(isolation.getOccupant());
    assertFalse(milo.isNewArrival());
    assertFalse(milo.needsMedical());
  }

  @Test
  public void testGiveName() {
    Isolation isolation = new Isolation(1);
    isolation.moveIn(milo);
    isolation.giveName("Max");
    assertEquals("Max", milo.getName());
  }

  @Test
  public void testUpdateSpecies() {
    Isolation isolation = new Isolation(1);
    isolation.moveIn(milo);
    isolation.updateSpec(Species.SAKI);
    assertEquals(Species.SAKI, milo.getSpecies());
  }

  @Test
  public void testUpdateSex() {
    Isolation isolation = new Isolation(1);
    isolation.moveIn(milo);
    isolation.updateSex(Sex.FEMALE);
    assertEquals(Sex.FEMALE, milo.getSex());
  }

  @Test
  public void testUpdateSize() {
    Isolation isolation = new Isolation(1);
    isolation.moveIn(milo);
    isolation.updateSize(Size.MEDIUM);
    assertEquals(Size.MEDIUM, milo.getSize());
  }

  @Test
  public void testUpdateWeight() {
    Isolation isolation = new Isolation(1);
    isolation.moveIn(milo);
    isolation.updateWeight(16.0);
    assertEquals(16.0, milo.getWeight(), 0.001);
  }

  @Test
  public void testUpdateAge() {
    Isolation isolation = new Isolation(1);
    isolation.moveIn(milo);
    isolation.updateAge(9);
    assertEquals(9, milo.getAge());
  }

  @Test
  public void testUpdateFood() {
    Isolation isolation = new Isolation(1);
    isolation.moveIn(milo);
    isolation.updateFood(Food.NUTS);
    assertEquals(Food.NUTS, milo.getFavFood());
  }
}