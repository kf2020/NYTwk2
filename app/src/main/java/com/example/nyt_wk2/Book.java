package com.example.nyt_wk2;

public class Book {

    // unique identifier of a book
    private int bookID;

    // Title of the book
    private String title;
    // Name of the author
    private String author;
    // Short text to be displayed on main page
    private String summary;
    // Resource ID of associated image (e.g. R.drawable.my_image)
    private int imageDrawableId;


    public Book(int bookID, String title, String author, String summary) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.summary = summary;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int articleID) {
        this.bookID = bookID;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getImageDrawableId() {
        return imageDrawableId;
    }

    public void setImageDrawableId(int imageDrawableId) {
        this.imageDrawableId = imageDrawableId;
    }
}
