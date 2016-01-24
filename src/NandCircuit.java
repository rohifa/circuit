/**
 * Created by rohi on 1/23/16.
 */
public class NandCircuit extends Circuit {

    public NandCircuit(Connector x, Connector y) {
        inputs.add(x);
        inputs.add(y);
        AndGate and = new AndGate();
        NotGate not = new NotGate();
        ConnectorService.connectToDual(x, y, and);
        ConnectorService.connectToSingle(and.getOutput(), not);
        outputs.add(not.getOutput());

    }

    public Connector getOutput() {
        return outputs.get(0);
    }
}
