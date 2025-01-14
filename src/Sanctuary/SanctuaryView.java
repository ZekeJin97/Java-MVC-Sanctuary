package Sanctuary;

import javax.swing.*;
import java.awt.*;
import java.util.List;
/**
 * View class for the sanctuary management system.
 */
public class SanctuaryView extends JFrame {
  private SanctuaryController controller;
  private JTextArea textArea;
  private JComboBox<Integer> isolationIdBox;
  private JComboBox<String> enclosureIdBox;
  private JTextField nameField, ageField, weightField;
  private JComboBox<Species> speciesBox;
  private JComboBox<Sex> sexBox;
  private JComboBox<Size> sizeBox;
  private JComboBox<Food> foodBox;

  /**
   * Constructs a new SanctuaryView with given controller.
   *
   * @param controller the controller associated with this view
   */
  public SanctuaryView(SanctuaryController controller) {
    this.controller = controller;
    initializeGUI();
  }

  /**
   * GUI, buttons and combobox selections
   */
  private void initializeGUI() {
    setTitle("Primate Sanctuary Management System");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new GridLayout(0, 2, 10, 10));

    inputPanel.add(new JLabel("Name:"));
    nameField = new JTextField();
    inputPanel.add(nameField);

    inputPanel.add(new JLabel("Species:"));
    speciesBox = new JComboBox<>(Species.values());
    inputPanel.add(speciesBox);

    inputPanel.add(new JLabel("Sex:"));
    sexBox = new JComboBox<>(Sex.values());
    inputPanel.add(sexBox);

    inputPanel.add(new JLabel("Size:"));
    sizeBox = new JComboBox<>(Size.values());
    inputPanel.add(sizeBox);

    inputPanel.add(new JLabel("Weight:"));
    weightField = new JTextField();
    inputPanel.add(weightField);

    inputPanel.add(new JLabel("Age:"));
    ageField = new JTextField();
    inputPanel.add(ageField);

    inputPanel.add(new JLabel("Favorite Food:"));
    foodBox = new JComboBox<>(Food.values());
    inputPanel.add(foodBox);

    JButton registerButton = new JButton("Register Monkey");
    registerButton.addActionListener(e -> registerMonkey());
    inputPanel.add(registerButton);

    JButton enclosureListButton = new JButton("List Monkeys in Enclosures");
    enclosureListButton.addActionListener(e -> {
      List<Enclosure> enclosures = controller.getEnclosures();
      displayEnclosureLists(enclosures);
    });
    inputPanel.add(enclosureListButton);

    JButton alphabeticalListButton = new JButton("List All Monkeys Alphabetically");
    alphabeticalListButton.addActionListener(e -> controller.displayAlphabeticalList());
    inputPanel.add(alphabeticalListButton);

    isolationIdBox = new JComboBox<>();
    enclosureIdBox = new JComboBox<>();
    setupComboBoxes();
    JButton moveButton = new JButton("Move Monkey");
    moveButton.addActionListener(e -> moveMonkey());
    JPanel movePanel = new JPanel(new GridLayout(2, 2, 10, 10));
    movePanel.add(new JLabel("Isolation ID:"));
    movePanel.add(isolationIdBox);
    movePanel.add(new JLabel("Enclosure ID:"));
    movePanel.add(enclosureIdBox);
    inputPanel.add(movePanel);
    inputPanel.add(moveButton);

    textArea = new JTextArea(10, 50);
    textArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(textArea);

    add(inputPanel, BorderLayout.NORTH);
    add(scrollPane, BorderLayout.CENTER);

    pack();
    setVisible(true);
  }

  /**
   * Sets up the combo boxes for isolation and enclosure selection.
   */
  public void setupComboBoxes() {
    isolationIdBox.removeAllItems();
    enclosureIdBox.removeAllItems();

    for (int i = 0; i < controller.getIsolations().size(); i++) {
      isolationIdBox.addItem(i);
    }

    for (Species species : Species.values()) {
      enclosureIdBox.addItem(species.toString());
    }
  }

  /**
   *  register new monkeys with input fields.
   */
  private void registerMonkey() {
    try {
      String name = nameField.getText();
      Species species = (Species) speciesBox.getSelectedItem();
      Sex sex = (Sex) sexBox.getSelectedItem();
      Size size = (Size) sizeBox.getSelectedItem();
      double weight = Double.parseDouble(weightField.getText());
      int age = Integer.parseInt(ageField.getText());
      Food favFood = (Food) foodBox.getSelectedItem();
      Monkey monkey = new Monkey(name, species, sex, size, weight, age, favFood);
      controller.registerNewMonkey(monkey);
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(this, "Please enter valid numbers for weight and age.", "Input Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  /**
   * Moves a monkey from isolation to an enclosure based on the selected IDs.
   */
  private void moveMonkey() {
    int isolationIndex = (int) isolationIdBox.getSelectedItem();
    String enclosureIndex = (String) enclosureIdBox.getSelectedItem();
    controller.moveMonkeyFromIsolationToEnclosure(isolationIndex, enclosureIndex);
  }

  /**
   * Displays a success message.
   *
   * @param message the message to display
   */
  public void showSuccessMessage(String message) {
    JOptionPane.showMessageDialog(this, message);
  }

  /**
   * Displays an error message.
   *
   * @param message the error message to display
   */
  public void showErrorMessage(String message) {
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
  }


  /**
   * Displays a list of monkeys in enclosures.
   *
   * @param enclosures the list of enclosures
   */
  public void displayEnclosureLists(List<Enclosure> enclosures) {
    StringBuilder sb = new StringBuilder();
    for (Enclosure enclosure : enclosures) {
      sb.append("Enclosure for ").append(enclosure.getTroop()).append(":\n");
      enclosure.getOccupants().forEach(monkey -> {
        sb.append("\tName: ").append(monkey.getName())
                .append(", Sex: ").append(monkey.getSex())
                .append(", Favorite Food: ").append(monkey.getFavFood())
                .append("\n");
      });
      sb.append("\n");
    }
    textArea.setText(sb.toString());
  }

  /**
   * Displays an alphabetical list of all monkeys.
   *
   * @param monkeys the list of monkeys
   */
  public void displayAlphabeticalList(List<Monkey> monkeys) {
    StringBuilder sb = new StringBuilder("Alphabetical List of Monkeys:\n");
    monkeys.forEach(monkey -> {
      Enclosure enclosure = monkey.getCurrentEnclosure(controller.getEnclosures());
      Isolation isolation = monkey.getCurrentIsolation(controller.getIsolations());
      String location = enclosure != null ? "Enclosure for " + enclosure.getTroop() :
              (isolation != null ? "Isolation unit" : "Unknown location");
      sb.append("\tName: ").append(monkey.getName())
              .append(", Species: ").append(monkey.getSpecies())
              .append(", Location: ").append(location)
              .append("\n");
    });
    textArea.setText(sb.toString());
  }

  /**
   * Updates the isolation IDs in the isolation combo box.
   *
   * @param isolations the updated list of isolations
   */
  public void updateIsolations(List<Isolation> isolations) {
    isolationIdBox.removeAllItems();
    for (int i = 0; i < isolations.size(); i++) {
      isolationIdBox.addItem(i);
    }
  }

  /**
   * Updates the enclosure IDs in the enclosure combo box.
   *
   * @param enclosures the updated list of enclosures
   */
  public void updateEnclosures(List<Enclosure> enclosures) {
    enclosureIdBox.removeAllItems();
    for (Species species : Species.values()) {
      enclosureIdBox.addItem(species.toString());
    }
  }

}
