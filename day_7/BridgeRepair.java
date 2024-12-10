import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BridgeRepair {
    File inputFile;
    HashMap<Long, List<Long>> bridgeData;

    public BridgeRepair() {}

    public BridgeRepair(String path) throws FileNotFoundException {
        inputFile = new File(path);
        bridgeData = new HashMap<>();

        Scanner sc = new Scanner(inputFile);
        while(sc.hasNextLine()) {
            String[] l_split = sc.nextLine().split(":");
            bridgeData.put(
                Long.parseLong(l_split[0]),
                new ArrayList<>( 
                    Arrays.stream(l_split[1].trim().split(" "))
                    .map(Long::parseLong)
                    .collect(Collectors.toList())
                )
            );
        }
        sc.close();
    }

    public boolean eachCalibration(Long k, List<Long> v, List<String> op) {

        if (op.size() == v.size()-1) {
            return evaluateExpression(v, op) == k;
        }

        op.add("+");
        if (eachCalibration(k, v, op)) {
            return true;
        }

        op.remove(op.size() - 1);
        op.add("*");

        if (eachCalibration(k, v, op)) {
            return true; 
        }

        op.remove(op.size() - 1); 
        return false;
    }

    private long evaluateExpression(List<Long> v, List<String> op) {
        long sum = v.get(0);
        for (int i=1; i<v.size(); i++) {
            if (op.get(i-1).equals("+")) {
                sum += v.get(i);
            }

            else if (op.get(i-1).equals("*")) {
                sum *= v.get(i);
            }
        }

        return sum;
    }

    public long calibrationResult() {
        Iterator<Entry<Long, List<Long>>> iter = bridgeData.entrySet().iterator();
        long calSum = 0;
        while (iter.hasNext()) {
            Map.Entry<Long, List<Long>> entry = iter.next();
            Long key = entry.getKey();
            List<Long> value = entry.getValue();

            if (eachCalibration(key, value, new ArrayList<String>())) {
                calSum += key;
            }
        }

        return calSum;
    }

    // BigInteger zone

    public boolean eachCalibration_concat(BigInteger k, List<Long> v, List<String> op) {

        if (op.size() == v.size()-1) {
            return evaluateExpression_concat(v, op).equals(k);
        }

        op.add("+");
        if (eachCalibration_concat(k, v, op)) {
            return true;
        }

        op.remove(op.size() - 1);
        op.add("*");

        if (eachCalibration_concat(k, v, op)) {
            return true; 
        }

        op.remove(op.size() - 1); 
        op.add("||");

        if (eachCalibration_concat(k, v, op)) {
            return true; 
        }

        op.remove(op.size() - 1);
        return false;
    }

    private BigInteger evaluateExpression_concat(List<Long> v, List<String> op) {
        BigInteger sum = BigInteger.valueOf(v.get(0));
        for (int i=1; i<v.size(); i++) {
            // sum = op.get(i-1).equals("+") ? sum + v.get(i) : sum * v.get(i);
            if (op.get(i-1).equals("+")) {
                sum = sum.add(BigInteger.valueOf(v.get(i)));
            }

            else if (op.get(i-1).equals("*")) {
                sum = sum.multiply(BigInteger.valueOf(v.get(i)));
            }

            else if (op.get(i-1).equals("||")) {
                String res_sum = sum.toString().concat(BigInteger.valueOf(v.get(i)).toString());
                sum = new BigInteger(res_sum);
            }
        }

        return sum;
    }

    public BigInteger calibrationResult_concat() {
        Iterator<Entry<Long, List<Long>>> iter = bridgeData.entrySet().iterator();
        BigInteger calSum = new BigInteger("0");
        while (iter.hasNext()) {
            Map.Entry<Long, List<Long>> entry = iter.next();
            BigInteger key = BigInteger.valueOf(entry.getKey());
            List<Long> value = entry.getValue();

            if (eachCalibration_concat(key, value, new ArrayList<String>())) {
                calSum = calSum.add(key);
            }
        }

        return calSum;
    }

}