package org.mthree.c130.ieuan.dvdLibrary.dao;

import org.mthree.c130.ieuan.dvdLibrary.dto.Dvd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

public interface DvdLibraryDao {
   void addDvd(Dvd dvd) throws FileNotFoundException, IOException;

   Collection<Dvd> getAllDvds();

   boolean removeDvd(String selectedDvdTitle);

   Dvd getDvd(String selectedDvdTitle);
}
