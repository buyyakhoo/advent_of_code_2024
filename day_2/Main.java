import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // test_case();
        // try_real();
        // test_fam_case();
        try_real_fam();
    }

    public static void test_case() throws FileNotFoundException {
        RedNosed rn = new RedNosed("./input_testcase.txt");
        boolean fam = false;
        System.out.println(rn.isSafe(new ArrayList<>(Arrays.asList(7, 6, 4, 2, 1)), fam));
        System.out.println(rn.isSafe(new ArrayList<>(Arrays.asList(1, 2, 7, 8, 9)), fam));
        System.out.println(rn.isSafe(new ArrayList<>(Arrays.asList(9, 7, 6, 2, 1)), fam));
        System.out.println(rn.isSafe(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5)), fam));
        System.out.println(rn.isSafe(new ArrayList<>(Arrays.asList(8, 6, 4, 4, 1)), fam));
        System.out.println(rn.isSafe(new ArrayList<>(Arrays.asList(1, 3, 6, 7, 9)), fam));
        System.out.println(rn.countSafe(fam));
    } 

    public static void try_real() throws FileNotFoundException {
        RedNosed rn = new RedNosed("./input.txt");
        boolean fam = false;
        System.out.println(rn.countSafe(fam));
    } 

    public static void test_fam_case() throws FileNotFoundException {
        RedNosed rn = new RedNosed("./input_testcase.txt");
        boolean fam = true;
        System.out.println(rn.isSafe(new ArrayList<>(Arrays.asList(7, 6, 4, 2, 1)), fam));
        System.out.println(rn.isSafe(new ArrayList<>(Arrays.asList(1, 2, 7, 8, 9)), fam));
        System.out.println(rn.isSafe(new ArrayList<>(Arrays.asList(9, 7, 6, 2, 1)), fam));
        System.out.println(rn.isSafe(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5)), fam));
        System.out.println(rn.isSafe(new ArrayList<>(Arrays.asList(8, 6, 4, 4, 1)), fam));
        System.out.println(rn.isSafe(new ArrayList<>(Arrays.asList(1, 3, 6, 7, 9)), fam));
        System.out.println(rn.countSafe(fam));
    } 

    public static void try_real_fam() throws FileNotFoundException {
        RedNosed rn = new RedNosed("./input.txt");
        boolean fam = true;
        System.out.println(rn.countSafe(fam));
    } 
    
}
