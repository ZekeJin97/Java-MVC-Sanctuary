package Sanctuary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * Controller class for managing the primate sanctuary.
 */
public class SanctuaryController {
  private List<Enclosure> enclosures;
  private List<Isolation> isolations;
  private SanctuaryView view;
  /**
   * Constructs a new SanctuaryController given enclosures, isolations, and view.
   *
   * @param enclosures the list of enclosures
   * @param isolations the list of isolations
   * @param view       the view associated with the controller
   */
  public SanctuaryController(List<Enclosure> enclosures, List<Isolation> isolations, SanctuaryView view) {
    this.enclosures = enclosures;
    this.isolations = isolations;
    this.view = view;
  }

  /**
   * Sets the view for the controller.
   *
   * @param view the view to set
   */
  public void setView(SanctuaryView view) {
    this.view = view;
  }

  /**
   * Gets the list of enclosures.
   *
   * @return the list of enclosures
   */
  public List<Enclosure> getEnclosures() {
    return enclosures;
  }

  /**
   * Gets the list of isolations.
   *
   * @return the list of isolations
   */
  public List<Isolation> getIsolations() {
    return isolations;
  }

  /**
   * Registers a new monkey to isolation.
   *
   * @param monkey the monkey to register
   */
  public void registerNewMonkey(Monkey monkey) {
    for (Isolation iso : isolations) {
      if (iso.getOccupant() == null) {
        iso.moveIn(monkey);
        view.showSuccessMessage("Monkey registered successfully and placed in isolation.");
        return;
      }
    }
    view.showErrorMessage("All isolation units are full.");
  }

  /**
   * Displays a list of monkeys in each enclosure.
   */
  public void displayEnclosureLists() {
    view.displayEnclosureLists(enclosures);
  }

  /**
   * Displays an alphabetical list of all monkeys in the sanctuary.
   */
  public void displayAlphabeticalList() {
    List<Monkey> allMonkeys = new ArrayList<>();
    enclosures.forEach(e -> allMonkeys.addAll(e.getOccupants()));
    isolations.stream().filter(i -> i.getOccupant() != null).forEach(i -> allMonkeys.add(i.getOccupant()));
    Collections.sort(allMonkeys, Comparator.comparing(Monkey::getName));
    view.displayAlphabeticalList(allMonkeys);
  }

  /**
   * Moves a monkey from isolation to an enclosure.
   *
   * @param isolationId  the ID of the isolation unit
   * @param enclosureId  the ID of the enclosure
   */
  public void moveMonkeyFromIsolationToEnclosure(int isolationId, String enclosureId) {
    if (isolationId < 0 || isolationId >= isolations.size()) {
      view.showErrorMessage("Invalid isolation ID.");
      return;
    }

    Isolation isolation = isolations.get(isolationId);
    Monkey monkey = isolation.getOccupant();

    if (monkey == null) {
      view.showErrorMessage("No monkey in the specified isolation unit.");
      return;
    }

    Enclosure targetEnclosure = null;
    for (Enclosure enclosure : enclosures) {
      if (enclosure.getTroop().name().equalsIgnoreCase(enclosureId)) {
        targetEnclosure = enclosure;
        break;
      }
    }

    if (targetEnclosure == null) {
      view.showErrorMessage("No enclosure found for the specified species.");
      return;
    }

    if (!monkey.getSpecies().equals(targetEnclosure.getTroop())) {
      view.showErrorMessage("Monkey species does not match enclosure species.");
      return;
    }

    if (monkey.needsMedical()) {
      view.showErrorMessage("Monkey still needs medical attention and cannot be moved.");
      return;
    }

    isolation.moveOut(monkey);
    targetEnclosure.moveIn(monkey);
    view.showSuccessMessage("Monkey moved successfully from isolation to enclosure.");
  }

}
