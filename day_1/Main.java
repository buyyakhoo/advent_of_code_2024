import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Historian_Hysteria hh = new Historian_Hysteria("./input.txt");
        System.out.println(hh.getDistance());
        System.out.println(hh.getSimilarityScore());
    }
}
