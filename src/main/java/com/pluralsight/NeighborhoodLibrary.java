package com.pluralsight;
import java.util.Scanner;
import java.util.Arrays;
public class NeighborhoodLibrary {
    public static void main(String[] args) {
        int homeScreen = 0;

        // 20 Books
        String[] books = {
               "Zen and Art of Motorcycles", "\nRider's Handbook", "\nMotorcycles Basics", "\nRoad Trips", "\nBiker's Bible",
               "\nTwo Wheels", "Riding Skills", "\nCafe Racers", "\nFreedom ride", "\nBike Dreams",
                "\nRider's Life", "\nCycle Touring", "\nBiker Wisdom", "\nTwist of Wrist", "\nCustom Bikes",
                "\nTouring Tips", "\nOpen Road", "\nBiker's Guide", "\nRider's Joy", "\nStreet Riding"
        };

        Book[] bookArray = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            bookArray[i] = new Book(i, "isbn" + i, books[i], false, "");
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Show available books");
            System.out.println("2. Show checked out books");
            System.out.println("3. Check out a book");
            System.out.println("4. Check in a book");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Available books: ");
                    for (Book book : bookArray) {
                        if (!book.getIsCheckedOut()) {
                            System.out.println(book.getTitle());
                        }
                    }
                    break;

                case 2:
                    System.out.println("Checked out books: ");
                    for (Book book : bookArray) {
                        if (book.getIsCheckedOut()) {
                            System.out.println(book.getTitle());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter the title of the book you want to check out: ");
                    String titleName = scanner.next();

                    for (Book book : bookArray) {
                        if (book.getTitle().toLowerCase().equals(titleName)) {
                            book.setCheckedOut(true);
                            System.out.println("You've checked out: " + book.getTitle());
                            break;
                        }
                    }
                    break;

                case 4:
                    for (Book book : bookArray) {
                        if (book.getIsCheckedOut()) {
                            System.out.println("What book do you want to check in?: ");
                            String checkingIn = scanner.next();
                            if (checkingIn.equals(book.getTitle())){
                                book.checkIn();
                                System.out.println("Your book is checked in!");
                            }
                        }
                    }
                    break;
                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

    }
}
