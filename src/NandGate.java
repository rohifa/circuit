/**
 * Created by rohi on 1/20/16.
 */
public class NandGate extends DualInputGate {

    @Override
    public void calculateOutput() {
        AndGate and = new AndGate();
        NotGate not = new NotGate();
        ConnectorService.connectToDual(x, y, and);
        ConnectorService.connectToSingle(and.getOutput(), not);
        output = not.getOutput();
    }
}
