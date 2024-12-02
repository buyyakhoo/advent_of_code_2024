import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Historian_Hysteria {
    File inputFile;
    ArrayList<Integer> one = new ArrayList<>();
    ArrayList<Integer> two = new ArrayList<>();
    public Historian_Hysteria(String path) throws FileNotFoundException {
        inputFile = new File(path);

        Scanner sc = new Scanner(inputFile);

        while(sc.hasNextLine()) {
            // System.out.println(Arrays.toString());
            String[] l = sc.nextLine().split("   ");
            one.add(Integer.parseInt(l[0]));
            two.add(Integer.parseInt(l[1]));
        }

        sc.close();
    }

    public ArrayList<Integer> getOne() {
        return one;
    }

    public ArrayList<Integer> getTwo() {
        return two;
    }

    public int getSize() {
        return equalSize() ? getOne().size() : -1;
    }

    public boolean equalSize() {
        return getOne().size() == getTwo().size();
    }

    public long getDistance() {
        long sum = 0;
        int size_save = getSize();
        ArrayList<Integer> one_cp = new ArrayList<>(one);
        ArrayList<Integer> two_cp = new ArrayList<>(two);
        for (int i=0; i<size_save; i++) {
            sum += getEachDistance(one_cp, two_cp);
        }

        return sum;
    }

    private int getEachDistance(ArrayList<Integer> one_cp, ArrayList<Integer> two_cp) {
        int min1 = Collections.min(one_cp);
        int min2 = Collections.min(two_cp);
        removeBothInArrayList(min1, min2, one_cp, two_cp);
        return Math.abs(min2 - min1);
    }

    private void removeBothInArrayList(int m1, int m2, ArrayList<Integer> one_cp, ArrayList<Integer> two_cp) {
        int size_now = getSize();
        removeEachInArrayList(one_cp, m1, size_now);
        removeEachInArrayList(two_cp, m2, size_now);
    }

    private void removeEachInArrayList(ArrayList<Integer> arrL, int m, int size) {
        Iterator<Integer> iter = arrL.iterator();
        while (iter.hasNext()) {
            if (iter.next().equals(m)) {
                iter.remove();
                break;
            }
        }
    }

    public long getSimilarityScore() {
        long sum = 0;
        Iterator<Integer> iter = one.iterator();

        while (iter.hasNext()) {
            int left_num = iter.next();
            sum += left_num * getDuplicateNumber(left_num);
        }

        return sum;
    }

    public int getDuplicateNumber(int ln) {
        int count=0;
        Iterator<Integer> iter = two.iterator();
        
        while (iter.hasNext()) {
            if (isLeftARightNumber(ln, iter.next())) {
                count++;
            }
        }
        return count;
    }

    private boolean isLeftARightNumber(int a, int b) {
        return a == b;
    }
}