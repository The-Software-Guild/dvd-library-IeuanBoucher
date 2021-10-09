package org.mthree.c130.ieuan.dvdLibrary.ui;

public class DvdLibraryView {

   private UserIO userIO = new UserIOConsoleImplementation();

   public int printMenuAndGetChoice() {
      userIO.printMessage("DVD Library main menu");
      userIO.printMessage("1. add a DVD to the collection");
      userIO.printMessage("2. remove a DVD from the collection");
      userIO.printMessage("3. edit an existing DVD in the collection");
      userIO.printMessage("4. list all DVDs in the collection");
      userIO.printMessage("5. view specific DVD");
      userIO.printMessage("6. check for a DVD in the collection");
      userIO.printMessage("7. exit program");

      return userIO.readInt("Choose an option from the menu.", 1, 7);
   }
}
