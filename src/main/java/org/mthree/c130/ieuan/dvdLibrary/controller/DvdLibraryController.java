package org.mthree.c130.ieuan.dvdLibrary.controller;

import org.mthree.c130.ieuan.dvdLibrary.dao.DvdLibraryDao;
import org.mthree.c130.ieuan.dvdLibrary.dao.DvdLibraryDaoFileImplementation;
import org.mthree.c130.ieuan.dvdLibrary.dto.Dvd;
import org.mthree.c130.ieuan.dvdLibrary.ui.DvdLibraryView;
import org.mthree.c130.ieuan.dvdLibrary.ui.UserIO;
import org.mthree.c130.ieuan.dvdLibrary.ui.UserIOConsoleImplementation;

import java.io.IOException;
import java.util.Collection;

public class DvdLibraryController {

   private DvdLibraryView view = new DvdLibraryView();
   private UserIO io = new UserIOConsoleImplementation();
   private DvdLibraryDao dao = new DvdLibraryDaoFileImplementation();

   public void runProgram() {
      int chosenOption;
      boolean continueLoop = true;
      while (continueLoop) {
         chosenOption = view.printMenuAndGetChoice();

         switch (chosenOption) {
            case 1:
               createDvd();
               break;
            case 2:
               removeDvd();
               break;
            case 3:
               io.printMessage("Edit DVD");
               editDvd();
               break;
            case 4:
               viewAllDvds();
               break;
            case 5:
               viewDvd();
               break;
            case 6:
               io.printMessage("Check for DVD");
               break;
            case 7:
               io.printMessage("Exit program");
               continueLoop = false;
               break;
            default:
               io.printMessage("unknown option");
               break;
         }
      }
   }

   private void editDvd() {
      view.displayEditDvdBanner();
      String selectedDvdTitle = view.getSelectedDvdTitle();
      Dvd selectedDvd = dao.getDvd(selectedDvdTitle);

      dao.editDvd(selectedDvd);
   }

   private void viewDvd() {
      view.displayViewDvdMenu();
      String selectedDvdTitle = view.getSelectedDvdTitle();
      Dvd selectedDvd = dao.getDvd(selectedDvdTitle);

      if (selectedDvd == null) {
         System.out.println("Could not view DVD with that title.");
      } else {
         view.displayDvd(selectedDvd);
      }
   }

   private void createDvd() {
      view.displayCreateDvdBanner();
      Dvd newDvd = view.createNewDvdFromUser();

      try {
         dao.addDvd(newDvd);
         view.displayCreateDvdSuccessBanner();
      } catch (IOException e) {
         System.out.println("Could not create new DVD.");
      }
   }

   private void removeDvd() {
      view.displayRemoveDvdBanner();
      String selectedDvdTitle = view.getSelectedDvdTitle();
      boolean success = dao.removeDvd(selectedDvdTitle);
      System.out.println(success ? "Successfully removed the DVD!" : "Could not remove the DVD");
   }

   private void viewAllDvds() {
      view.printViewDvdsBanner();
      Collection<Dvd> dvds = dao.getAllDvds();
      view.displayAllDvds(dvds);
   }
}
