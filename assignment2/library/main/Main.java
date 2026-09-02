package library.main;

import library.model.*;
import library.service.LibraryService;
import library.util.InputValidator;

public class Main {

    public static void main(String[] args) {

        LibraryResource[] resources = new LibraryResource[5];

        resources[0] =
                new Book(101, "Java Programming", "James Gosling");

        resources[1] =
                new DigitalResource(102, "Clean Code", "Robert Martin");

        resources[2] =
                new Book(103, "Data Structures", "Mark Allen");

        resources[3] =
                new DigitalResource(104, "Operating Systems", "Galvin");

        resources[4] =
                new Book(105, "Computer Networks", "Andrew Tanenbaum");


        // Display details
        for (LibraryResource resource : resources) {

            if (resource instanceof Printable) {

                Printable printable =
                        (Printable) resource;

                printable.printDetails();
            }
        }


        // Overdue days for each resource
        int[] overdueDays = {
            5,   // Book
            10,  // Digital
            3,   // Book
            7,   // Digital
            4    // Book
        };


        // Validate overdue days
        for (int days : overdueDays) {

            if (!InputValidator.validateFineDays(days)) {

                System.out.println(
                    "Invalid overdue days: " + days
                );

                return;
            }
        }


        // Calculate total fine
        double totalFine =
                LibraryResource.calculateTotalFine(
                        resources,
                        overdueDays
                );

        System.out.println(
                "\nTotal Fine: Rs. " + totalFine
        );


        // Display total resources
        LibraryResource.displayTotalResources();
    }
}