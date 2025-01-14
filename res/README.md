Break your README into sections using titles:

About/Overview.
This software serves as a primates management system for the Jungle Friends Primate Sanctuary.
The software allows users to register and modify a monkey's information, moving them between different residences, and display a list of all monkeys living at the Sanctuary.

List of features. List all features that are present in your program.
Register a new monkey and modify an existing monkey's information.
Moving a monkey between isolation unit and appropriate enclosure space.
Display details of all monkeys in each enclosure.
Display an alphabetic list of all monkeys.

How To Run. Instructions to run the program should include the following:
IntelliJ IDEA, Press Ctrl Shift A , find and run the Edit Configurations action. and select JAR Application.
To register a new monkey and move it to isolation, fill in the required fields and select appropriate selections from the menu, once all fields are filled and selected, click register monkey.
To move a monkey from isolation to enclosure, input the isolation unit number of the monkey and select the designated enclosure for its troop, then click move monkey.
To view a list of all monkeys alphabetically or details of monkeys in each enclosure, simply click the respect button.

Design/Model Changes. It is important to document what changes that you have made from earlier designs. Why were those changes required? You can write these changes in terms of version if you wish.
Added methods to the monkey class to get its current residence in order to display in view.

Assumptions. List what assumptions you made during program development and implementation. Be sure that these do not conflict with the requirements of the project.
Monkeys can be moved to any isolation unit by choosing a number.
Enclosure ID would show the troop name but it was showing integers. Changing its type resulted in having to modify the move function in both view and controller.

Limitations. Limitations of your program if any. This should include any requirements that were not implemented or were not working correctly (including something that might work some of the time).
Cannot pick an isolation unit to move in. It will always be moved into the first isolation unit available (0),
Hard to track which isolation unit the monkey is living in because the display list button does not show the unit number of the isolation.

Citations. Be sure to include any citations that are required for your project. Citations should include references (paper, website, etc.) for any site that you used to research a solution. Proper APA format should be used. For websites this includes the name of the website, title of the article, the url, and the date of retrieval. If you have nothing to cite, you should indicate this.
Create your first java application: IntellijIDEA. IntelliJIDEA Help. (n.d.). https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#package 