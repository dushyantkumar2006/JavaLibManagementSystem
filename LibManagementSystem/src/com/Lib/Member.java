package com.Lib;

public class Member {
    private String memberId;
    private String name;
    private Book[] borrowedBooks;      // array instead of List<Book>
    private int borrowedCount;         // kitni books abhi borrowed hai

    private static final int MAX_BOOKS_ALLOWED = 3;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new Book[MAX_BOOKS_ALLOWED];
        this.borrowedCount = 0;
    }

    public boolean canBorrowMore() {
        return borrowedCount < MAX_BOOKS_ALLOWED;
    }

    public void addBorrowedBook(Book book) {
        if (borrowedCount < borrowedBooks.length) {
            borrowedBooks[borrowedCount] = book;
            borrowedCount++;
        }
    }

    public void removeBorrowedBook(Book book) {
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedBooks[i] == book) {
                // baaki sab ek position peeche shift karo
                for (int j = i; j < borrowedCount - 1; j++) {
                    borrowedBooks[j] = borrowedBooks[j + 1];
                }
                borrowedBooks[borrowedCount - 1] = null;
                borrowedCount--;
                break;
            }
        }
    }

    // ye check karta hai ki member ke paas ye particular book hai ya nahi
    public boolean hasBorrowed(Book book) {
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedBooks[i] == book) {
                return true;
            }
        }
        return false;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %d book(s) borrowed", memberId, name, borrowedCount);
    }
}
