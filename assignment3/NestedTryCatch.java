public class NestedTryCatch {

    public static void main(String[] args) {

        try {
            System.out.println("Outer try block");

            try {
                System.out.println("Inner try block");
                int a = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: " + e);
            }

            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch: " + e);
        }

        System.out.println("Program continues after exception handling.");
    }
}