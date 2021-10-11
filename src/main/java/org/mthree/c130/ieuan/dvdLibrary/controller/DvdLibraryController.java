package org.mthree.c130.ieuan.dvdLibrary.controller;

import org.mthree.c130.ieuan.dvdLibrary.dao.DvdLibraryDao;
import org.mthree.c130.ieuan.dvdLibrary.dto.Dvd;
import org.mthree.c130.ieuan.dvdLibrary.ui.DvdLibraryView;

import java.io.IOException;
import java.util.Collection;

public class DvdLibraryController {

   private final DvdLibraryView view;
   private final DvdLibraryDao dao;

   public DvdLibraryController(DvdLibraryView view, DvdLibraryDao dao) {
      this.view = view;
      this.dao = dao;
   }

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
               editDvd();
               break;
            case 4:
               viewAllDvds();
               break;
            case 5:
               viewDvd();
               break;
            case 6:
               continueLoop = false;
               break;
            default:
               unknownOption();
               break;
         }
      }
      programExitMessage();
   }

   private void unknownOption() {
      view.displayUnkownCommandMessage();
   }

   private void programExitMessage() {
      view.displayProgramExitTitle();
   }

   private void editDvd() {
      view.displayEditDvdTitle();
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
      view.displayCreateDvdTitle();
      Dvd newDvd = view.createNewDvdFromUser();

      try {
         dao.addDvd(newDvd);
         view.displayCreateDvdSuccessTitle();
      } catch (IOException e) {
         System.out.println("Could not create new DVD.");
      }
   }

   private void removeDvd() {
      view.displayRemoveDvdTitle();
      String selectedDvdTitle = view.getSelectedDvdTitle();
      boolean success = dao.removeDvd(selectedDvdTitle);
      System.out.println(success ? "Successfully removed the DVD!" : "Could not remove the DVD");
   }

   private void viewAllDvds() {
      view.printViewDvdsTitle();
      Collection<Dvd> dvds = dao.getAllDvds();
      view.displayAllDvds(dvds);
   }
}
