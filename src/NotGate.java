/**
 * Created by rohi on 1/19/16.
 */
public class NotGate extends SingleInputGate {

    public NotGate () {
        super();
    }

    @Override
    public void calculateOutput() {
        output.setValue(!x.getValue());
    }

}
