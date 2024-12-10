import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // eachCalibration_test();
        calibration_res_real();
        // eachCalibration_concat_test();
        calibration_res_concat_real();
    }

    public static void eachCalibration_test() {
        BridgeRepair br = new BridgeRepair();
        System.out.println(br.eachCalibration(190l, new ArrayList<>(Arrays.asList(10l, 19l)), new ArrayList<String>()));
        System.out.println(br.eachCalibration(3267l, new ArrayList<>(Arrays.asList(81l, 40l, 27l)), new ArrayList<String>()));
        System.out.println(br.eachCalibration(83l, new ArrayList<>(Arrays.asList(17l, 5l)), new ArrayList<String>()));
        System.out.println(br.eachCalibration(156l, new ArrayList<>(Arrays.asList(15l, 6l)), new ArrayList<String>()));
        System.out.println(br.eachCalibration(7290l, new ArrayList<>(Arrays.asList(6l, 8l, 6l, 15l)), new ArrayList<String>()));
        System.out.println(br.eachCalibration(161011l, new ArrayList<>(Arrays.asList(16l, 10l, 13l)), new ArrayList<String>()));
        System.out.println(br.eachCalibration(192l, new ArrayList<>(Arrays.asList(17l, 8l, 14l)), new ArrayList<String>()));
        System.out.println(br.eachCalibration(21037l, new ArrayList<>(Arrays.asList(9l, 7l, 18l, 13l)), new ArrayList<String>()));
        System.out.println(br.eachCalibration(292l, new ArrayList<>(Arrays.asList(11l, 6l, 16l, 20l)), new ArrayList<String>()));
    }

    public static void calibration_res_real() throws FileNotFoundException {
        BridgeRepair br = new BridgeRepair("./input.txt");
        System.out.println(br.calibrationResult());
    }

    public static void eachCalibration_concat_test() {
            BridgeRepair br = new BridgeRepair();

            System.out.println(br.eachCalibration_concat(BigInteger.valueOf(190l), new ArrayList<>(Arrays.asList(10l, 19l)), new ArrayList<String>()));
            System.out.println(br.eachCalibration_concat(BigInteger.valueOf(3267l), new ArrayList<>(Arrays.asList(81l, 40l, 27l)), new ArrayList<String>()));
            System.out.println(br.eachCalibration_concat(BigInteger.valueOf(83l), new ArrayList<>(Arrays.asList(17l, 5l)), new ArrayList<String>()));
            System.out.println(br.eachCalibration_concat(BigInteger.valueOf(156l), new ArrayList<>(Arrays.asList(15l, 6l)), new ArrayList<String>()));
            System.out.println(br.eachCalibration_concat(BigInteger.valueOf(7290l), new ArrayList<>(Arrays.asList(6l, 8l, 6l, 15l)), new ArrayList<String>()));
            System.out.println(br.eachCalibration_concat(BigInteger.valueOf(161011l), new ArrayList<>(Arrays.asList(16l, 10l, 13l)), new ArrayList<String>()));
            System.out.println(br.eachCalibration_concat(BigInteger.valueOf(192l), new ArrayList<>(Arrays.asList(17l, 8l, 14l)), new ArrayList<String>()));
            System.out.println(br.eachCalibration_concat(BigInteger.valueOf(21037l), new ArrayList<>(Arrays.asList(9l, 7l, 18l, 13l)), new ArrayList<String>()));
            System.out.println(br.eachCalibration_concat(BigInteger.valueOf(292l), new ArrayList<>(Arrays.asList(11l, 6l, 16l, 20l)), new ArrayList<String>()));
    }

    public static void calibration_res_concat_real() throws FileNotFoundException {
        BridgeRepair br = new BridgeRepair("./input.txt");
        System.out.println(br.calibrationResult_concat());
    }
}

