package library.model;

public class DigitalResource extends LibraryResource
        implements Printable {

    public DigitalResource(int resourceId,
                           String title,
                           String author) {

        super(resourceId, title, author);
    }

    @Override
    public double calculateFine(int overdueDays) {

        return overdueDays * 2;
    }

    @Override
    public void printDetails() {

        System.out.println("\n--- Digital Resource Details ---");

        displayBasicDetails();

        System.out.println("Type        : Digital Resource");
        System.out.println("Fine/Day    : Rs. 2");
    }
}