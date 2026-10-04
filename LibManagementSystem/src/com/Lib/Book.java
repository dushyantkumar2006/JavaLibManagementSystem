package com.Lib;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isIssued;
    private String issuedTo;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isIssued = false;
        this.issuedTo = null;
    }

    public void markIssued(String memberName) {
        this.isIssued = true;
        this.issuedTo = memberName;
    }

    public void markReturned() {
        this.isIssued = false;
        this.issuedTo = null;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public String getIssuedTo() {
        return issuedTo;
    }

    @Override
    public String toString() {
        String status = isIssued ? "Issued to " + issuedTo : "Available";
        return String.format("[%s] \"%s\" by %s - %s", isbn, title, author, status);
    }
}
