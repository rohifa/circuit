/**
 * Created by rohi on 1/19/16.
 */
public class AndGate extends DualInputGate {

    public AndGate () {
        super();
    }

    public void calculateOutput() {
        output.setValue(x.getValue() && y.getValue());
    }
}
