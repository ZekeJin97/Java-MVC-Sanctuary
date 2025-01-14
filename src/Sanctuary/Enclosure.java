package Sanctuary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Enclosure class to house a troop
 */
public class Enclosure implements Housing {
  private Species troop;
  private List<Monkey> occupants;

  public Enclosure(Species species) {
    this.troop = species;
    this.occupants = new ArrayList<>();
  }

  /**
   * get the species type of the enclosure
   *
   * @return species
   */
  public Species getTroop() {
    return this.troop;
  }

  /**
   * get a list of monkeys housed in the enclosure
   *
   * @return the list of monkeys
   */
  public List<Monkey> getOccupants() {
    return Collections.unmodifiableList(occupants);
  }

  /**
   * move in a health monkey of the same species that is not a new arrival
   *
   * @param monkey a monkey
   */
  @Override
  public void moveIn(Monkey monkey) {
    if (monkey.getSpecies() != this.troop) {
      System.out.println("Monkey " + monkey.getName() + " cannot move into the enclosure because it is not of the same species.");
    } else if (monkey.isNewArrival()) {
      System.out.println("Monkey " + monkey.getName() + " cannot move into the enclosure because it is a new arrival.");
    } else if (monkey.needsMedical()) {
      System.out.println("Monkey " + monkey.getName() + " cannot move into the enclosure because it needs medical attention.");
    } else {
      occupants.add(monkey);
    }
  }

  @Override
  public void moveOut(Monkey monkey) {
    occupants.remove(monkey);
  }

  /** Method to produce a list of monkeys in the enclosure with their details
   *
   * @return a list of details
   */
  public List<String> getList() {
    List<String> monkeyList = new ArrayList<>();
    for (Monkey monkey : occupants) {
      String details = "Name: " + monkey.getName() + ", Sex: " + monkey.getSex() + ", Favorite Food: " + monkey.getFavFood();
      monkeyList.add(details);
    }
    return monkeyList;
  }

}