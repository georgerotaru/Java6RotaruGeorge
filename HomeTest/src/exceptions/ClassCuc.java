package exceptions;

public class ClassCuc {

    public static void main(String[] args) {
        try {
            int m = ageInMonths(Integer.parseInt(args[0]));
            System.out.println(m);
        } finally {
            System.out.println("first program argument needs to be an int");
        //} catch (IllegalArgumentException e) {
        //    System.out.println(e.getMessage());
        }
}

static int ageInMonths(int age) {
    if (age < 0) {
        throw new IllegalArgumentException("age should be >= 0");
    }
    return age * 12; 
}

}
