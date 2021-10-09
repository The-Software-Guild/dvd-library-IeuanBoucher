package org.mthree.c130.ieuan.dvdLibrary.controller;

import org.mthree.c130.ieuan.dvdLibrary.ui.DvdLibraryView;
import org.mthree.c130.ieuan.dvdLibrary.ui.UserIO;
import org.mthree.c130.ieuan.dvdLibrary.ui.UserIOConsoleImplementation;

public class DvdLibraryController {

   private DvdLibraryView view = new DvdLibraryView();
   private UserIO io = new UserIOConsoleImplementation();

   public void runProgram() {
      int chosenOption;
      boolean continueLoop = true;
      while (continueLoop) {
         chosenOption = view.printMenuAndGetChoice();

         switch (chosenOption) {
            case 1:
               io.printMessage("Add DVD");
               break;
            case 2:
               io.printMessage("Remove DVD");
               break;
            case 3:
               io.printMessage("Edit DVD");
               break;
            case 4:
               io.printMessage("List all DVDs");
               break;
            case 5:
               io.printMessage("view a DVD");
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
}
