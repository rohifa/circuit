/**
 * Created by rohi on 1/20/16.
 */
public abstract class DualInputGate implements Gate {

    protected Connector x;
    protected Connector y;
    protected Connector output = new Connector(false);

    public DualInputGate() {
    }

    public Connector getX() {
        return x;
    }

    public void setX(Connector x) {
        this.x = x;
    }

    public Connector getY() {
        return y;
    }

    public void setY(Connector y) {
        this.y = y;
    }

    @Override
    public abstract void calculateOutput();

    public Connector getOutput() {
        calculateOutput();
        return output;
    }

    public void setOutput(Connector output) {
        this.output = output;
        output.setPreviousGate(this);
    }

    @Override
    public boolean isConnected() {
        return (x!=null && y!=null && output!=null);
    }
}
