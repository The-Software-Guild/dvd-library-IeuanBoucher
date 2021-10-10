package org.mthree.c130.ieuan.dvdLibrary.dto;

public class Dvd {
   private String title;
   private String releaseDate;
   private String MpaaRating;
   private String directorName;
   private String studio;

   public Dvd(String title) {
      this.title = title;
   }

   public String getReleaseDate() {
      return releaseDate;
   }

   public void setReleaseDate(String releaseDate) {
      this.releaseDate = releaseDate;
   }

   public String getMpaaRating() {
      return MpaaRating;
   }

   public void setMpaaRating(String mpaaRating) {
      MpaaRating = mpaaRating;
   }

   public String getDirectorName() {
      return directorName;
   }

   public void setDirectorName(String directorName) {
      this.directorName = directorName;
   }

   public String getStudio() {
      return studio;
   }

   public void setStudio(String studio) {
      this.studio = studio;
   }

   public String getUserComment() {
      return userComment;
   }

   public void setUserComment(String userComment) {
      this.userComment = userComment;
   }

   private String userComment;

   public String getTitle() {
      return title;
   }
}
