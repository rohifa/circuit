/**
 * Created by rohi on 1/21/16.
 */
public class AdderCircuit extends Circuit {

    private Connector inputX;
    private Connector inputY;
    private Connector sum;
    private Connector carry;

    public AdderCircuit(Connector inputX, Connector inputY, Connector carry) {
        if (carry==null) {
            carry = new Connector(false);
        }
        inputs.add(inputX);
        inputs.add(inputY);
        XorGate xor = new XorGate();
        AndGate and = new AndGate();
        ConnectorService.connectToDual(inputX, inputY, xor);
        ConnectorService.connectToDual(inputX, inputY, and);
        carry = and.getOutput();
        sum = xor.getOutput();
        outputs.add(carry);
        outputs.add(sum);
    }

    public Connector getSum(){
        return sum;
    }

    public Connector getCarry() {
        return carry;
    }


}
