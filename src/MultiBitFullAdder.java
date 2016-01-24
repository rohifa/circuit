/**
 * Created by rohi on 1/21/16.
 */
public class MultiBitFullAdder extends Circuit{

    public MultiBitFullAdder(Connector[] input1, Connector[] input2) {

        Connector carryIn = new Connector(false);

        FullAdderCircuit[] fullAdderCircuits = new FullAdderCircuit[input1.length];
        for (int i=0; i<input1.length; i++) {
            Connector x = input1[i];
            Connector y = input2[i];
            inputs.add(x);
            inputs.add(y);

            fullAdderCircuits[i] = new FullAdderCircuit(x, y, carryIn);

            carryIn = fullAdderCircuits[i].getCarryOut();
            outputs.add(fullAdderCircuits[i].getSum());
        }

    }
}
