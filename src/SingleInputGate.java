/**
 * Created by rohi on 1/20/16.
 */
public abstract class SingleInputGate implements Gate {

    protected Connector x;
    protected Connector output = new Connector(false);

    public SingleInputGate() {
    }

    public Connector getX() {
        return x;
    }

    public void setX(Connector x) {
        this.x = x;
    }

    @Override
    public abstract void calculateOutput();

    public Connector getOutput() {
        calculateOutput();
        return output;
    }

    public void setOutput(Connector output) {
        this.output = output;
    }

    @Override
    public boolean isConnected() {
        return (x!=null && output!=null);
    }
}
