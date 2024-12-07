import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class RedNosed {
    File inputFile;
    List<List<Integer>> inputArray = new ArrayList<List<Integer>>();
    String statusNote = "";
    boolean firstAttemptMode = false;
    boolean firstAttemptCanUse = true;
    boolean secondAttemptCanUse = true;
    boolean firstAttemptSave;

    public RedNosed() {}

    public RedNosed(String path) throws FileNotFoundException {
        inputFile = new File(path);
        Scanner sc = new Scanner(inputFile);

        while(sc.hasNextLine()) {
            String[] l = sc.nextLine().split(" ");
            List<Integer> l_al = new ArrayList<>();

            for (String chr : l) {
                l_al.add(Integer.parseInt(chr));
            }
            inputArray.add(l_al);
            
        }
        sc.close();
    }

    public List<List<Integer>> getInputArray() {
        return inputArray;
    }

    public boolean isSafe(List<Integer> chkArray, boolean fam) {
        setStatus("");
        int chkASize = chkArray.size();
        secondAttemptCanUse = true; // testcase
        for (int i=1; i<chkASize; i++) {
            int numDiffer = chkArray.get(i) - chkArray.get(i-1);
            if (numDiffer <= 3 && numDiffer >= 1 && numDiffer != 0 && 
                        (statusNoteEqualsAndNotInitial("increase", i) || initialChk(i))) {
                setStatus("increase");
            }
            else if (numDiffer <= -1 && numDiffer >= -3 && numDiffer != 0 && 
                        (statusNoteEqualsAndNotInitial("decrease", i) || initialChk(i))) {
                setStatus("decrease");
            }
            else if (fam) {
                for (int j=0; j<chkASize; j++) {
                    List<Integer> chkArray2 = new ArrayList<>(chkArray);
                    chkArray2.remove(j);
                    if (isSafe(chkArray2, false)) {
                        return true;
                    }
                }
                return false;
            }
            else {
                return false;
            }    
        }

        return true;
    }

    private boolean statusNoteEqualsAndNotInitial(String s, int i) {
        return statusNote.equals(s) && i > 1;
    }

    private boolean initialChk(int i) {
        return i == 1;
    }

    private void setStatus(String s) {
        statusNote = s;
    }

    public int countSafe(boolean fam) {
        int count = 0;
        Iterator<List<Integer>> iter = inputArray.iterator();
        
        while (iter.hasNext()) {
            secondAttemptCanUse = true;
            List<Integer> eachArr = iter.next();
            if (isSafe(eachArr, fam))
                count++;
        }

        return count;
    }
}