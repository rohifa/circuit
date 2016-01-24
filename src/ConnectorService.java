/**
 * Created by rohi on 1/20/16.
 */
public class ConnectorService {

    public static void connectToSingle(Connector connector, SingleInputGate gate) {
        Connector prevX = gate.getX();
        prevX = null;
        connector.addNextGate(gate);
        gate.setX(connector);
        gate.getOutput().setPreviousGate(gate);
    }

    public static void connectToDual(Connector x, Connector y, DualInputGate gate) {
        Connector prevX = gate.getX();
        prevX = null;
        Connector prevY = gate.getY();
        prevY = null;
        x.addNextGate(gate);
        y.addNextGate(gate);
        gate.setX(x);
        gate.setY(y);
        gate.getOutput().setPreviousGate(gate);
    }
}
