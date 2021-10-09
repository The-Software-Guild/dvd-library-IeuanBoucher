package org.mthree.c130.ieuan.dvdLibrary.ui;

public interface UserIO {
   void printMessage(String message);

   String readString(String prompt);

   int readInt(String prompt);

   int readInt(String prompt, int minValue, int maxValue);

}
