/**
 * Created by rohi on 1/19/16.
 */
public interface Gate {

    public Connector getOutput();
    public void calculateOutput();
    public boolean isConnected();

}
