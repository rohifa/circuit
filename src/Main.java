import java.nio.ByteBuffer;
import java.util.BitSet;

public class Main {

    private final static int BITS = 8;

    public static void main(String[] args) {


        String x = args[0];
        String y = args[1];

        System.out.println("summing "+x+" + "+y);
        Connector[] input1 = convertInt(Integer.parseInt(x));
        Connector[] input2 = convertInt(Integer.parseInt(y));

        MultiBitFullAdder fullAdderCircuit = new MultiBitFullAdder(input1, input2);
        System.out.println("multi full adder valid: " + fullAdderCircuit.isValid());

        String output = fullAdderCircuit.outputToString();
        System.out.println("outputs: " + output);

        System.out.println("integer value of output: "+Integer.parseInt(output.replaceAll(" ",""), 2));



    }

    private static Connector[] convertInt(int value) {
        if (value>255 || value<0) throw new RuntimeException("value out of bounds");

        Connector[] connectors = new Connector[BITS];
        String binaryStr = Integer.toBinaryString(value);
        char[] bitArray = String.format("%8s", binaryStr).replace(' ', '0').toCharArray();

        int i = BITS-1;
        for (char bit: bitArray) {
            Connector c = new Connector(convertCharToBool(bit));
            connectors[i] = c;
            i--;
        }

        return connectors;
    }

    private static boolean convertCharToBool (char c) {
        return c == '1';
    }

}
