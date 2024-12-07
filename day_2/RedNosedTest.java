import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class RedNosedTest {
    @Test
    public void initialize_test() throws FileNotFoundException {
        RedNosed rn = new RedNosed("./input_testcase.txt");
        // Assert.assertArrayEquals([
        //         [7, 6, 4, 2, 1],
        //         [1, 2, 7, 8, 9],
        //         [9, 7, 6, 2, 1],
        //         [1, 3, 2, 4, 5],
        //         [8, 6, 4, 4, 1],
        //         [1, 3, 6, 7, 9]
        //     ], rn.getInputArray());
        Assert.assertEquals(
            Arrays.asList(
                Arrays.asList(7, 6, 4, 2, 1),
                Arrays.asList(1, 2, 7, 8, 9),
                Arrays.asList(9, 7, 6, 2, 1),
                Arrays.asList(1, 3, 2, 4, 5),
                Arrays.asList(8, 6, 4, 4, 1),
                Arrays.asList(1, 3, 6, 7, 9)
            )
        , rn.getInputArray());
    }

    @Test
    public void isSafe_test() {
        RedNosed rn = new RedNosed();
        boolean fam = false;
        Assert.assertEquals(true, rn.isSafe(new ArrayList<>(Arrays.asList(7, 6, 4, 2, 1)), fam));
        Assert.assertEquals(false, rn.isSafe(new ArrayList<>(Arrays.asList(1, 2, 7, 8, 9)), fam));
        Assert.assertEquals(false, rn.isSafe(new ArrayList<>(Arrays.asList(9, 7, 6, 2, 1)), fam));
        Assert.assertEquals(false, rn.isSafe(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5)), fam));
        Assert.assertEquals(false, rn.isSafe(new ArrayList<>(Arrays.asList(8, 6, 4, 4, 1)), fam));
        Assert.assertEquals(true, rn.isSafe(new ArrayList<>(Arrays.asList(1, 3, 6, 7, 9)), fam));
    }

    @Test
    public void countSafe_test() throws FileNotFoundException {
        RedNosed rn = new RedNosed("./input_testcase.txt");
        boolean fam = false;
        Assert.assertEquals(2, rn.countSafe(fam));
    }

    @Test
    public void isSafe_firstAttemptMode_test() {
        RedNosed rn = new RedNosed();
        boolean fam = true;
        Assert.assertEquals(true, rn.isSafe(new ArrayList<>(Arrays.asList(7, 6, 4, 2, 1)), fam));
        Assert.assertEquals(false, rn.isSafe(new ArrayList<>(Arrays.asList(1, 2, 7, 8, 9)), fam));
        Assert.assertEquals(false, rn.isSafe(new ArrayList<>(Arrays.asList(9, 7, 6, 2, 1)), fam));
        Assert.assertEquals(true, rn.isSafe(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5)), fam));
        Assert.assertEquals(true, rn.isSafe(new ArrayList<>(Arrays.asList(8, 6, 4, 4, 1)), fam));
        Assert.assertEquals(true, rn.isSafe(new ArrayList<>(Arrays.asList(1, 3, 6, 7, 9)), fam));
    }

    @Test
    public void countSafe_firstAttemptMode_test() throws FileNotFoundException {
        RedNosed rn = new RedNosed("./input_testcase.txt");
        boolean fam = true;
        Assert.assertEquals(4, rn.countSafe(fam));
    }
}
