import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.*;

public class Historian_Hysteria_Test {
    @Test
    public void initialize_test() throws FileNotFoundException {
        Historian_Hysteria hh = new Historian_Hysteria("./input_testcase.txt");
        Assert.assertEquals(Arrays.asList(3,4,2,1,3,3), hh.getOne());
        Assert.assertEquals(Arrays.asList(4,3,5,3,9,3), hh.getTwo());
    }

    @Test
    public void size_test() throws FileNotFoundException {
        Historian_Hysteria hh = new Historian_Hysteria("./input_testcase.txt");
        Assert.assertEquals(true, hh.equalSize());
        Assert.assertEquals(6, hh.getSize());
    }

    @Test
    public void distance_test() throws FileNotFoundException {
        Historian_Hysteria hh = new Historian_Hysteria("./input_testcase.txt");
        Assert.assertEquals(11, hh.getDistance());
    }

    @Test
    public void similarity_score_test() throws FileNotFoundException {
        Historian_Hysteria hh = new Historian_Hysteria("./input_testcase.txt");
        Assert.assertEquals(31, hh.getSimilarityScore());
    }
}
