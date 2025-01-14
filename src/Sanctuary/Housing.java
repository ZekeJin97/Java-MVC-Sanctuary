package Sanctuary;

/**
 * Housing interface for different types of housings to implement
 */

interface Housing {
  /**
   * move a monkey into ot out of a housing space
   *
   * @param monkey a monkey
   */

  void moveIn(Monkey monkey);

  void moveOut(Monkey monkey);
}