package com.library;

import java.util.*;

public class LibraryManagement {
    private Library library = new Library();
    private Map<String, Member> members = new HashMap<>();

    public Book addBooksToLibrary(Book book) {
        library.addBook(book);
        return book;
    }

    public Book borrowBookFromLibrary(String userId, String ISBN) {
        return library.borrowBook(userId, ISBN, members);
    }

    public Book returnBookFromLibrary(String userId, String ISBN) {
        return library.returnBook(userId, ISBN, members);
    }

    public void displayMemberBorrowedBooks(String memberId) {
        Member member = members.get(memberId);
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        System.out.println("Books borrowed by " + member.getName() + ":");
        for (Book book : member.getBorrowedBooks()) {
            System.out.println(book);
        }
    }

    public void displayAvailableBooks() {
        List<Book> books = library.displayAvailableBooks();
        System.out.println("Available books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Member addMember(Member member) {
        members.put(member.getId(), member);
        return  member;
    }
    public void displayBorrowedBooks() {
        List<Book> books = library.displayBorrowedBooks();
        System.out.println("Borrowed books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        LibraryManagement libraryManagement = new LibraryManagement();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book to Library");
            System.out.println("2. Borrow Book from Library");
            System.out.println("3. Return Book to Library");
            System.out.println("4. Display Available Books");
            System.out.println("5. Display Borrowed Books by Member");
            System.out.println("6. Add Member");
            System.out.println("7.Display all borrowedBooks");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Authors: ");
                    String authors = scanner.nextLine();
                    System.out.print("Enter Publication Year: ");
                    int year = scanner.nextInt();
                    Book book = new Book( title, authors, year);
                    libraryManagement.addBooksToLibrary(book);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter Member ID: ");
                    String memberIdBorrow = scanner.nextLine();
                    System.out.print("Enter Book ISBN: ");
                    String isbnBorrow = scanner.nextLine();
                    libraryManagement.borrowBookFromLibrary(memberIdBorrow, isbnBorrow);
                    break;
                case 3:
                    System.out.print("Enter Member ID: ");
                    String memberIdReturn = scanner.nextLine();
                    System.out.print("Enter Book ISBN: ");
                    String isbnReturn = scanner.nextLine();
                    libraryManagement.returnBookFromLibrary(memberIdReturn, isbnReturn);
                    break;
                case 4:
                    libraryManagement.displayAvailableBooks();
                    break;
                case 5:
                    System.out.print("Enter Member ID: ");
                    String memberIdDisplay = scanner.nextLine();
                    libraryManagement.displayMemberBorrowedBooks(memberIdDisplay);
                    break;
                case 6:

                    System.out.print("Enter Member Name: ");
                    String memberName = scanner.nextLine();
                    Member member = new Member(memberName);
                    Member addedMember=libraryManagement.addMember(member);

                    System.out.println("Member added successfully. copy your ID you can use it when you want to borrow the book:" + addedMember.getId());


                    break;
                case 7:
                    libraryManagement.displayBorrowedBooks();
                    break;

                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
