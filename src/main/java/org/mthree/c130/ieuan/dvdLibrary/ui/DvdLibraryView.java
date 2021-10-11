package org.mthree.c130.ieuan.dvdLibrary.ui;

import org.mthree.c130.ieuan.dvdLibrary.dto.Dvd;

import java.util.Collection;

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

   public void displayCreateDvdBanner() {
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

   public void displayCreateDvdSuccessBanner() {
      userIO.printMessage("Successfully created new DVD!");
   }

   public void printViewDvdsBanner() {
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

   public void displayRemoveDvdBanner() {
      System.out.println("## Remove DVD menu ##");
   }

   public String getSelectedDvdTitle() {
      return userIO.readString("Enter title of DVD");
   }

   public void displayViewDvdMenu() {
      System.out.println("## View DVD menu ##");
   }

   public void displayEditDvdBanner() {
      System.out.println("## Edit DVD menu ##");
   }
}
