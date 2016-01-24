import java.util.LinkedList;
import java.util.List;

/**
 * Created by rohi on 1/19/16.
 */
public class Connector {

    private Boolean value;
    private List<Gate> nextGates = new LinkedList<>();
    private Gate previousGate;


    public Connector(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public List<Gate> getNextGates() {
        return nextGates;
    }

    public void addNextGate(Gate nextGate) {
        nextGates.add(nextGate);
    }

    public boolean removeNextGate(Gate nextGate) {
        return nextGates.remove(nextGate);
    }

    public Gate getPreviousGate() {
        return previousGate;
    }

    public void setPreviousGate(Gate previousGate) {
        this.previousGate = previousGate;
    }
}
