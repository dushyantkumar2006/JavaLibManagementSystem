package com.Lib;

import com.Lib.Book;
import com.Lib.Library;
import com.Lib.Member;

public class Main {
    public static void main(String[] args) {
        // Creating a Library object
        Library library = new Library("City Public Library");

        // Creating Book objects
        Book b1 = new Book("ISBN001", "The Alchemist", "Paulo Coelho");
        Book b2 = new Book("ISBN002", "Clean Code", "Robert C. Martin");
        Book b3 = new Book("ISBN003", "Atomic Habits", "James Clear");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        // Creating Member objects
        Member m1 = new Member("MEM01", "Aarav Sharma");
        Member m2 = new Member("MEM02", "Priya Verma");

        library.registerMember(m1);
        library.registerMember(m2);

        System.out.println("\n===== Library Operations =====");
        library.issueBook("ISBN001", m1);   // success
        library.issueBook("ISBN002", m2);   // success
        library.issueBook("ISBN001", m2);   // fails: already issued
        library.returnBook("ISBN001", m1);  // success
        library.issueBook("ISBN001", m2);   // now succeeds

        library.printCatalog();
        library.printMembers();
    }
}