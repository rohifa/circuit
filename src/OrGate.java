/**
 * Created by rohi on 1/19/16.
 */
public class OrGate extends DualInputGate {

    public OrGate (){
        super();
    }

    @Override
    public void calculateOutput() {
        output.setValue(x.getValue() || y.getValue());
    }
}
