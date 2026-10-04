package com.Lib;

public class Library {
    private String libraryName;
    private Book[] catalog;
    private int catalogCount;

    private Member[] members;
    private int memberCount;

    private static final int MAX_BOOKS = 100;
    private static final int MAX_MEMBERS = 100;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.catalog = new Book[MAX_BOOKS];
        this.catalogCount = 0;
        this.members = new Member[MAX_MEMBERS];
        this.memberCount = 0;
    }

    public void addBook(Book book) {
        if (catalogCount < catalog.length) {
            catalog[catalogCount] = book;
            catalogCount++;
            System.out.println("Added book: " + book.getTitle());
        } else {
            System.out.println("Catalog full, cannot add: " + book.getTitle());
        }
    }

    public void registerMember(Member member) {
        if (memberCount < members.length) {
            members[memberCount] = member;
            memberCount++;
            System.out.println("Registered member: " + member.getName());
        } else {
            System.out.println("Member limit reached, cannot register: " + member.getName());
        }
    }

    public void issueBook(String isbn, Member member) {
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Book with ISBN " + isbn + " not found.");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Cannot issue \"" + book.getTitle() + "\" - already issued to " + book.getIssuedTo());
            return;
        }
        if (!member.canBorrowMore()) {
            System.out.println(member.getName() + " has reached the borrowing limit.");
            return;
        }
        book.markIssued(member.getName());
        member.addBorrowedBook(book);
        System.out.println(member.getName() + " borrowed \"" + book.getTitle() + "\"");
    }

    public void returnBook(String isbn, Member member) {
        Book book = findBookByIsbn(isbn);
        if (book == null || !member.hasBorrowed(book)) {
            System.out.println(member.getName() + " does not have this book to return.");
            return;
        }
        book.markReturned();
        member.removeBorrowedBook(book);
        System.out.println(member.getName() + " returned \"" + book.getTitle() + "\"");
    }

    private Book findBookByIsbn(String isbn) {
        for (int i = 0; i < catalogCount; i++) {
            if (catalog[i].getIsbn().equals(isbn)) {
                return catalog[i];
            }
        }
        return null;
    }

    public void printCatalog() {
        System.out.println("\n--- " + libraryName + " Catalog ---");
        for (int i = 0; i < catalogCount; i++) {
            System.out.println("  " + catalog[i]);
        }
    }

    public void printMembers() {
        System.out.println("\n--- " + libraryName + " Members ---");
        for (int i = 0; i < memberCount; i++) {
            System.out.println("  " + members[i]);
        }
    }
}