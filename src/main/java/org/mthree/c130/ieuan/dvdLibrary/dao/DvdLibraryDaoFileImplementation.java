package org.mthree.c130.ieuan.dvdLibrary.dao;

import org.mthree.c130.ieuan.dvdLibrary.dto.Dvd;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DvdLibraryDaoFileImplementation implements DvdLibraryDao {
   private final Map<String, Dvd> dvdMap = new HashMap<>();
   private final String DVD_LIBRARY_FILENAME = "src/dvdlibrary.txt";
   private final String DELIMITER = "//";

   @Override
   public void addDvd(Dvd dvd) throws IOException {
      loadDvdLibrary();
      dvdMap.put(dvd.getTitle(), dvd);
      writeDvdLibrary();
   }

   private void writeDvdLibrary() throws IOException {
      PrintWriter out;
      try {
         out = new PrintWriter(new FileWriter(DVD_LIBRARY_FILENAME));
      } catch (IOException e) {
         throw new IOException("Could not save DVD library.");
      }

      String marshalledDvd;
      for (Dvd dvd : dvdMap.values()) {
         marshalledDvd = marshallDvd(dvd);
         out.println(marshalledDvd);
         out.flush();
      }
      out.close();
   }

   private void loadDvdLibrary() throws FileNotFoundException {
      Scanner scanner;

      try {
         scanner = new Scanner(new BufferedReader(new FileReader(DVD_LIBRARY_FILENAME)));
      } catch (FileNotFoundException e) {
         throw new FileNotFoundException("Could not load DVD library.");
      }

      Dvd currentDvd;
      String currentFileLine;

      while (scanner.hasNext()) {
         currentFileLine = scanner.nextLine();

         currentDvd = unmarshallDvd(currentFileLine);

         if (currentDvd == null) {
            System.out.println("Found malformed DVD, skipping");
         } else {
            dvdMap.put(currentDvd.getTitle(), currentDvd);
         }

      }
   }

   private Dvd unmarshallDvd(String marshalledDvd) {
      String[] dataValue = marshalledDvd.split(DELIMITER);
      Dvd dvd;
      try {

         dvd = new Dvd(dataValue[0]);

         dvd.setReleaseDate(dataValue[1]);
         dvd.setMpaaRating(dataValue[2]);
         dvd.setDirectorName(dataValue[3]);
         dvd.setStudio(dataValue[4]);
         dvd.setUserComment(dataValue[5]);
      } catch (Exception e) {
         return null;
      }

      return dvd;
   }

   private String marshallDvd(Dvd dvd) {

      String marshalledDvd = dvd.getTitle() +
              DELIMITER +
              dvd.getReleaseDate() +
              DELIMITER +
              dvd.getMpaaRating() +
              DELIMITER +
              dvd.getDirectorName() +
              DELIMITER +
              dvd.getStudio()
              + DELIMITER +
              dvd.getUserComment();

      return marshalledDvd;

   }

   public Collection<Dvd> getAllDvds() {
      try {
         loadDvdLibrary();
      } catch (FileNotFoundException e) {
         System.out.println("Could not load library");
      }
      return dvdMap.values();
   }

   @Override
   public boolean removeDvd(String selectedDvdTitle) {
      Dvd removedDvd = dvdMap.remove(selectedDvdTitle);

      return removedDvd != null;
   }

   @Override
   public Dvd getDvd(String selectedDvdTitle) {
      return dvdMap.get(selectedDvdTitle);
   }

   @Override
   public void editDvd(Dvd selectedDvd) {

   }
}
