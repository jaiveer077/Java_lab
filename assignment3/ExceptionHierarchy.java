public class ExceptionHierarchy {

    public static void main(String[] args) {

        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }

        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }

        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        }

        System.out.println("\nException Hierarchy:");

        System.out.println("ArithmeticException -> " +
                ArithmeticException.class.getSuperclass().getSimpleName());

        System.out.println("NullPointerException -> " +
                NullPointerException.class.getSuperclass().getSimpleName());

        System.out.println("ArrayIndexOutOfBoundsException -> " +
                ArrayIndexOutOfBoundsException.class.getSuperclass().getSimpleName());

        System.out.println("NumberFormatException -> " +
                NumberFormatException.class.getSuperclass().getSimpleName());
    }
}