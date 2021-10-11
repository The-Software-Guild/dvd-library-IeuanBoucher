package org.mthree.c130.ieuan.dvdLibrary;

import org.mthree.c130.ieuan.dvdLibrary.controller.DvdLibraryController;
import org.mthree.c130.ieuan.dvdLibrary.dao.DvdLibraryDao;
import org.mthree.c130.ieuan.dvdLibrary.dao.DvdLibraryDaoFileImplementation;
import org.mthree.c130.ieuan.dvdLibrary.ui.DvdLibraryView;
import org.mthree.c130.ieuan.dvdLibrary.ui.UserIO;
import org.mthree.c130.ieuan.dvdLibrary.ui.UserIOConsoleImplementation;

public class App {
   public static void main(String[] args) {
      UserIO io = new UserIOConsoleImplementation();
      DvdLibraryView view = new DvdLibraryView(io);
      DvdLibraryDao dao = new DvdLibraryDaoFileImplementation();

      DvdLibraryController controller = new DvdLibraryController(view, dao);
      controller.runProgram();
   }
}
