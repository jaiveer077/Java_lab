package library.model;

public abstract class LibraryResource {

    private int resourceId;
    private String title;
    private String author;

    public static String libraryName = "Central Library";

    protected static int resourceCount = 0;

    public LibraryResource(int resourceId,
                           String title,
                           String author) {

        this.resourceId = resourceId;
        this.title = title;
        this.author = author;

        resourceCount++;
    }

    // Getters
    public int getResourceId() {
        return resourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Setters
    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Abstract method
    public abstract double calculateFine(int overdueDays);

    // Static method
    public static void displayTotalResources() {
        System.out.println(
            "Total Resources Created: " + resourceCount
        );
    }

    // Protected method
    protected void displayBasicDetails() {
        System.out.println("Resource ID : " + resourceId);
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
    }
}