package Sanctuary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * test run
 */

public class Sanctuary {
  public static void main(String[] args) {
    Enclosure enclosure1 = new Enclosure(Species.DRILL);
    Enclosure enclosure2 = new Enclosure(Species.GUEREZA);
    Enclosure enclosure3 = new Enclosure(Species.HOWLER);
    Enclosure enclosure4 = new Enclosure(Species.MANGABEY);
    Enclosure enclosure5 = new Enclosure(Species.SAKI);
    Enclosure enclosure6 = new Enclosure(Species.SPIDER);
    Enclosure enclosure7 = new Enclosure(Species.SQUIRREL);
    Enclosure enclosure8 = new Enclosure(Species.TAMARIN);

    List<Isolation> isolations = new ArrayList<>();
    for (int i = 1; i <= 20; i++) {
      isolations.add(new Isolation(i));
    }

    Monkey monkey1 = new Monkey("Milo", Species.HOWLER, Sex.MALE, Size.LARGE, 15.5, 8, Food.FRUITS);
    Monkey monkey2 = new Monkey("Luna", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 5.2, 4, Food.NUTS);
    Monkey monkey3 = new Monkey("Charlie", Species.HOWLER, Sex.MALE, Size.MEDIUM, 10.0, 6, Food.FRUITS);
    Monkey monkey4 = new Monkey("Max", Species.HOWLER, Sex.MALE, Size.MEDIUM, 11.2, 5, Food.INSECTS);
    Monkey monkey5 = new Monkey("Bella", Species.MANGABEY, Sex.FEMALE, Size.MEDIUM, 8.7, 7, Food.EGGS);
    Monkey monkey6 = new Monkey("Leo", Species.SAKI, Sex.MALE, Size.SMALL, 4.5, 3, Food.TREE_SAP);
    Monkey monkey7 = new Monkey("Sophie", Species.SPIDER, Sex.FEMALE, Size.LARGE, 14.3, 9, Food.LEAVES);
    Monkey monkey8 = new Monkey("Rocky", Species.TAMARIN, Sex.MALE, Size.SMALL, 3.8, 2, Food.SEEDS);
    Monkey monkey9 = new Monkey("Zoe", Species.GUEREZA, Sex.FEMALE, Size.MEDIUM, 9.1, 6, Food.NUTS);
    Monkey monkey10 = new Monkey("Sam", Species.DRILL, Sex.MALE, Size.LARGE, 16.8, 10, Food.FRUITS);
    Monkey monkey11 = new Monkey("Lucy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 5.0, 4, Food.SEEDS);
    Monkey monkey12 = new Monkey("Jack", Species.TAMARIN, Sex.MALE, Size.SMALL, 3.2, 2, Food.INSECTS);
    Monkey monkey13 = new Monkey("Daisy", Species.GUEREZA, Sex.FEMALE, Size.MEDIUM, 8.5, 7, Food.LEAVES);

    enclosure1.moveIn(monkey10);
    enclosure2.moveIn(monkey9);
    enclosure2.moveIn(monkey13);
    enclosure3.moveIn(monkey1);
    enclosure3.moveIn(monkey4);
    enclosure3.moveIn(monkey3);
    enclosure4.moveIn(monkey5);
    enclosure5.moveIn(monkey6);
    enclosure6.moveIn(monkey7);
    enclosure7.moveIn(monkey2);
    enclosure7.moveIn(monkey11);
    enclosure8.moveIn(monkey8);
    enclosure8.moveIn(monkey12);


    Monkey monkey14 = new Monkey("Maxine", Species.GUEREZA, Sex.FEMALE, Size.MEDIUM, 8.9, 5, Food.LEAVES);
    Monkey monkey15 = new Monkey("Oscar", Species.SAKI, Sex.MALE, Size.SMALL, 4.1, 3, Food.TREE_SAP);
    Monkey monkey16 = new Monkey("Ann", Species.MANGABEY, Sex.FEMALE, Size.MEDIUM, 7.3, 6, Food.EGGS);
    Monkey monkey17 = new Monkey();


    isolations.get(0).moveIn(monkey14);
    isolations.get(1).moveIn(monkey15);
    isolations.get(2).moveIn(monkey16);

    isolations.get(3).moveIn(monkey17);
    isolations.get(3).updateAge(5);
    isolations.get(3).giveName("Matt");
    isolations.get(3).updateSex(Sex.MALE);
    isolations.get(3).updateSize(Size.MEDIUM);
    isolations.get(3).updateSpec(Species.SAKI);
    isolations.get(3).updateFood(Food.EGGS);
    isolations.get(3).updateWeight(4.2);


    displayAll(Arrays.asList(enclosure1, enclosure2, enclosure3, enclosure4, enclosure5, enclosure6, enclosure7, enclosure8), isolations);
    System.out.println();

    /**
     * Produce a list for every enclosure with their name, sex, and favorite food.
     */

    for (Enclosure enclosure : Arrays.asList(enclosure1, enclosure2, enclosure3, enclosure4, enclosure5, enclosure6, enclosure7, enclosure8)) {
      System.out.println("Monkeys in " + enclosure.getTroop() + " Enclosure:");
      List<String> monkeyDetails = enclosure.getList();
      for (String details : monkeyDetails) {
        System.out.println(details);
      }
      System.out.println();
    }
  }

  /**
   * Produce an alphabetical list (by name) of all the monkeys housed in the Sanctuary.
   */

  public static void displayAll(List<Enclosure> enclosures, List<Isolation> isolations) {
    List<Monkey> allMonkeys = new ArrayList<>();
    for (Enclosure enclosure : enclosures) {
      allMonkeys.addAll(enclosure.getOccupants());
    }
    for (Isolation isolation : isolations) {
      Monkey monkey = isolation.getOccupant();
      if (monkey != null) {
        allMonkeys.add(monkey);
      }
    }
    Collections.sort(allMonkeys, (m1, m2) -> m1.getName().compareTo(m2.getName()));
    for (Monkey monkey : allMonkeys) {
      String location = "";
      for (Enclosure enclosure : enclosures) {
        if (enclosure.getOccupants().contains(monkey)) {
          location = "Enclosure " + (enclosures.indexOf(enclosure) + 1);
          break;
        }
      }
      if (location.isEmpty()) {
        for (Isolation isolation : isolations) {
          if (isolation.getOccupant() == monkey) {
            location = "Isolation " + isolation.getNumber();
            break;
          }
        }
      }
      System.out.println("Name: " + monkey.getName() + ", Housed in: " + location);
    }
  }
}