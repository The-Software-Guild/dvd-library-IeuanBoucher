package org.mthree.c130.ieuan.dvdLibrary.ui;

import org.mthree.c130.ieuan.dvdLibrary.dto.Dvd;

import java.util.Collection;

public class DvdLibraryView {

   public DvdLibraryView(UserIO userIO) {
      this.userIO = userIO;
   }

   private final UserIO userIO;

   public int printMenuAndGetChoice() {
      userIO.printMessage("DVD Library main menu");
      userIO.printMessage("1. add a DVD to the collection");
      userIO.printMessage("2. remove a DVD from the collection");
      userIO.printMessage("3. edit an existing DVD in the collection");
      userIO.printMessage("4. list all DVDs in the collection");
      userIO.printMessage("5. view specific DVD");
      userIO.printMessage("6. exit program");

      return userIO.readInt("Choose an option from the menu.", 1, 7);
   }

   public void displayCreateDvdTitle() {
      userIO.printMessage("## Create student menu ##");
   }

   public Dvd createNewDvdFromUser() {
      Dvd newDvd;

      String temp = userIO.readString("Enter DVD title");
      newDvd = new Dvd(temp);

      temp = userIO.readString("Enter release date");
      newDvd.setReleaseDate(temp);

      temp = userIO.readString("Enter MPAA rating");
      newDvd.setMpaaRating(temp);

      temp = userIO.readString("Enter Director name");
      newDvd.setDirectorName(temp);

      temp = userIO.readString("Enter studio");
      newDvd.setStudio(temp);

      temp = userIO.readString("Enter rating / note");
      newDvd.setUserComment(temp);

      return newDvd;
   }

   public Dvd editDvd(String title) {
      Dvd updatedDvd = new Dvd(title);
      String temp;

      temp = userIO.readString("Enter release date");
      updatedDvd.setReleaseDate(temp);

      temp = userIO.readString("Enter MPAA rating");
      updatedDvd.setMpaaRating(temp);

      temp = userIO.readString("Enter Director name");
      updatedDvd.setDirectorName(temp);

      temp = userIO.readString("Enter studio");
      updatedDvd.setStudio(temp);

      temp = userIO.readString("Enter rating / note");
      updatedDvd.setUserComment(temp);

      return updatedDvd;
   }

   public void displayCreateDvdSuccessTitle() {
      userIO.printMessage("Successfully created new DVD!");
   }

   public void printViewDvdsTitle() {
      userIO.printMessage("## View all DVDs menu ##");
   }

   public void displayDvd(Dvd dvd) {
      String output =
              dvd.getTitle() + "\n" +
                      dvd.getReleaseDate() + "\n" +
                      dvd.getMpaaRating() + "\n" +
                      dvd.getDirectorName() + "\n" +
                      dvd.getStudio() + "\n" +
                      dvd.getUserComment() + "\n\n";
      System.out.println(output);
   }

   public void displayAllDvds(Collection<Dvd> dvds) {
      for (Dvd dvd : dvds) {
         displayDvd(dvd);
      }
   }

   public void displayRemoveDvdTitle() {
      System.out.println("## Remove DVD menu ##");
   }

   public String getSelectedDvdTitle() {
      return userIO.readString("Enter title of DVD");
   }

   public void displayViewDvdMenu() {
      System.out.println("## View DVD menu ##");
   }

   public void displayEditDvdTitle() {
      System.out.println("## Edit DVD menu ##");
   }

   public void displayProgramExitTitle() {
      System.out.println("Exiting program");
   }

   public void displayUnkownCommandMessage() {
      System.out.println("Unknown option");
   }
}
