package Sanctuary;

/**
 * Isolation class to house a single monkey
 */
public class Isolation implements Housing {
  private int number;
  private Monkey occupant;

  public Isolation(int number) {
    this.number = number;
    this.occupant = null;
  }

  /**
   * getters
   *
   * @return
   */
  public Monkey getOccupant() {
    return occupant;
  }

  public int getNumber() {
    return number;
  }

  @Override
  public void moveIn(Monkey monkey) {
    if (occupant == null) {
      occupant = monkey;
    } else {
      System.out.println("Isolation " + number + " is already occupied.");
    }
  }

  /**
   * move out a monkey and set its needsMedical and newArrival status to false
   *
   * @param monkey
   */
  @Override
  public void moveOut(Monkey monkey) {
    if (occupant == monkey) {
      occupant = null;
      if (monkey != null) {
        monkey.setNeedsMedical(false);
        monkey.setIsNewArrival(false);
      }
    }
  }

  /**
   * methods to update the information of a monkey
   */
  public void giveName(String name) {
    if (occupant != null) {
      occupant.setName(name);
    }
  }

  public void updateSpec(Species species) {
    if (occupant != null) {
      occupant.setSpecies(species);
    }
  }

  public void updateSex(Sex sex) {
    if (occupant != null) {
      occupant.setSex(sex);
    }
  }

  public void updateSize(Size size) {
    if (occupant != null) {
      occupant.setSize(size);
    }
  }

  public void updateWeight(double weight) {
    if (occupant != null) {
      occupant.setWeight(weight);
    }
  }

  public void updateAge(int age) {
    if (occupant != null) {
      occupant.setAge(age);
    }
  }

  public void updateFood(Food food) {
    if (occupant != null) {
      occupant.setFavFood(food);
    }
  }
}
