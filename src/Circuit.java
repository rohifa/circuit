import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Circuit {

    protected List<Gate> gates = new LinkedList<>();
    protected List<Connector> inputs = new LinkedList<>();
    protected List<Connector> outputs = new LinkedList<>();

    public Circuit() {

    }

    public List<Connector> getInputs() {
        return inputs;
    }

    public List<Connector> getOutputs() {
        return outputs;
    }

    public void addInput(Connector input) {
        inputs.add(input);
    }

    public void addOutput(Connector output) {
        outputs.add(output);
    }

    public void addGate(Gate gate) {
        gates.add(gate);
    }

    public boolean isValid() {
        return checkAllInputsConnected()
                && checkAllOutputsConnected()
                && checkAllGatesConnected()
                && checkShortCircuit();
    }

    public boolean checkAllInputsConnected() {

        for (Connector input : inputs) {
            if (input.getNextGates() == null) return false;
        }

        return true;
    }

    public boolean checkAllOutputsConnected() {
        for (Connector output : outputs) {
                if (output.getPreviousGate() == null) return false;
        }

        return true;
    }

    public boolean checkAllGatesConnected() {
        for (Gate gate : gates) {
            if (!gate.isConnected()) return false;
        }
        return true;
    }

    public boolean checkShortCircuit() {

        //take an input connector
        //get all next gates
        //for each gate, go to next until reach output
        //each gate visited, put in our set
        //each gate I visit, check if it's in our set
        //if yes, circuit invalid

        for (Connector input : inputs) {
            Set<Gate> visitedGates = new HashSet<>();
            if (!recursiveNextGateUntilOutput(input, visitedGates)){
                return false;
            }
        }

        return true;
    }

    //recursiveNextGateUntilOutput
    //base:
    //if Connector . is in outputs
    //return;
    //if Connector. nextGate is in visitedGates
    //return false
    //Connector.inputGate put in Set
    //recursiveNext(Connector.inputGate.getOutput

    private boolean recursiveNextGateUntilOutput(Connector connector, Set<Gate> visited) {

        if (outputs.contains(connector)) {
            return true;
        }
        for (Gate nextGate : connector.getNextGates()) {
            if (visited.contains(nextGate)) {
                return false;
            }

            else {
                visited.add(nextGate);
                return recursiveNextGateUntilOutput(nextGate.getOutput(), visited);
            }


        }
        return false;

    }

    public String inputToString() {
        StringBuilder input = new StringBuilder();
        for (Connector conn : inputs) {
            int value = conn.getValue() ? 1 : 0;
            input.append(value).append(" ");
        }
        return input.reverse().toString();
    }
    public String outputToString() {
        StringBuilder output = new StringBuilder();
        for (Connector conn : outputs) {
            int value = conn.getValue() ? 1 : 0;
            output.append(value).append(" ");
        }
        return output.reverse().toString();
    }

}
