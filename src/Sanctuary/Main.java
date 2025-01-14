package Sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    List<Enclosure> enclosures = new ArrayList<>();
    enclosures.add(new Enclosure(Species.DRILL));
    enclosures.add(new Enclosure(Species.GUEREZA));
    enclosures.add(new Enclosure(Species.HOWLER));
    enclosures.add(new Enclosure(Species.MANGABEY));
    enclosures.add(new Enclosure(Species.SAKI));
    enclosures.add(new Enclosure(Species.SPIDER));
    enclosures.add(new Enclosure(Species.SQUIRREL));
    enclosures.add(new Enclosure(Species.TAMARIN));

    List<Isolation> isolations = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      isolations.add(new Isolation(i + 1));
    }


    SanctuaryController controller = new SanctuaryController(enclosures, isolations, null);
    SanctuaryView view = new SanctuaryView(controller);


    controller.setView(view);

    view.setupComboBoxes();
  }
}
