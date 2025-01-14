package Sanctuary;

import java.util.List;

/**
 * monkey class to store the information of each monkey
 */

public class Monkey {
  private String name;
  private Species species;
  private Sex sex;
  private Size size;
  private double weight;
  private int age;
  private Food favFood;
  private boolean newArrival;
  private boolean needsMedical;

  /**
   * Parameterized constructor for information of a monkey
   *
   * @param name
   * @param species
   * @param sex
   * @param size
   * @param weight
   * @param age
   * @param favFood
   */
  public Monkey(String name, Species species, Sex sex, Size size, double weight, int age, Food favFood) {
    this.name = name;
    this.species = species;
    this.sex = sex;
    this.size = size;
    this.weight = weight;
    this.age = age;
    this.favFood = favFood;
    this.newArrival = false;
    this.needsMedical = false;
  }

  /**
   * default constructor for a newly arrived monkey
   */
  public Monkey() {
    this.name = "None";
    this.species = Species.UNKNOWN;
    this.sex = Sex.UNKNOWN;
    this.size = Size.UNKNOWN;
    this.weight = 0.0;
    this.age = 0;
    this.favFood = Food.UNKNOWN;
    this.newArrival = true;
    this.needsMedical = true;
  }

  /**
   * getters and setters to get or modify the information of a monkey
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Species getSpecies() {
    return species;
  }

  public void setSpecies(Species species) {
    this.species = species;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public Size getSize() {
    return size;
  }

  public void setSize(Size size) {
    this.size = size;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Food getFavFood() {
    return favFood;
  }

  public void setFavFood(Food favFood) {
    this.favFood = favFood;
  }

  /**
   * boolean methods and setters to check or modify the status of a monkey
   *
   * @return boolean of whether the monkey is newArrival, needsMedical or needsIsolation
   */
  public boolean needsIsolation() {
    return isNewArrival() || needsMedical();
  }

  public boolean isNewArrival() {
    return newArrival;
  }

  public void setIsNewArrival(boolean isNewArrival) {
    this.newArrival = isNewArrival;
  }

  public boolean needsMedical() {
    return needsMedical;
  }

  public void setNeedsMedical(boolean needsMedical) {
    this.needsMedical = needsMedical;
  }
    public Enclosure getCurrentEnclosure(List<Enclosure> enclosures) {
      for (Enclosure enclosure : enclosures) {
        if (enclosure.getOccupants().contains(this)) {
          return enclosure;
        }
      }
      return null; // Monkey is not in any enclosure
    }

  public Isolation getCurrentIsolation(List<Isolation> isolations) {
    for (Isolation isolation : isolations) {
      if (isolation.getOccupant() == this) {
        return isolation;
      }
    }
    return null; // Monkey is not in any isolation unit
  }

}
