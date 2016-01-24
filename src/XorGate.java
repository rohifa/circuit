/**
 * Created by rohi on 1/20/16.
 */
public class XorGate extends DualInputGate {

    @Override
    public void calculateOutput() {
        NandGate nand1 = new NandGate();
        NandGate nand2 = new NandGate();
        NandGate nand3 = new NandGate();
        NandGate nand4 = new NandGate();

        ConnectorService.connectToDual(x, y, nand1);
        ConnectorService.connectToDual(x, nand1.getOutput(), nand2);
        ConnectorService.connectToDual(nand1.getOutput(), y, nand3);
        ConnectorService.connectToDual(nand2.getOutput(), nand3.getOutput(), nand4);

        output = nand4.getOutput();

    }

}
