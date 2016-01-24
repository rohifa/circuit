/**
 * Created by rohi on 1/20/16.
 */
public class FullAdderCircuit extends Circuit {
    private Connector x;
    private Connector y;
    private Connector carryIn;
    private Connector sum;
    private Connector carryOut;

    public FullAdderCircuit(Connector x, Connector y, Connector carryIn) {
        this.carryIn = carryIn;
        this.x = x;
        this.y = y;
        inputs.add(x);
        inputs.add(y);
        inputs.add(carryIn);

        XorCircuit xor1 = new XorCircuit(x, y);
        XorCircuit xor2 = new XorCircuit(xor1.getOutput(),carryIn);
        AndGate and1 = new AndGate();
        AndGate and2 = new AndGate();
        OrGate or = new OrGate();

        ConnectorService.connectToDual(carryIn, xor1.getOutput(), and1);
        ConnectorService.connectToDual(x, y, and2);
        ConnectorService.connectToDual(and1.getOutput(), and2.getOutput(), or);

        outputs.add(xor2.getOutput());
        outputs.add(or.getOutput());
        sum = xor2.getOutput();
        carryOut = or.getOutput();
    }

    public Connector getSum() {
        return sum;
    }

    public Connector getCarryOut() {
        return carryOut;
    }


}
