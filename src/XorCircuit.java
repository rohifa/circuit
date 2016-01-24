/**
 * Created by rohi on 1/23/16.
 */
public class XorCircuit extends Circuit {

    public XorCircuit(Connector x, Connector y) {

        inputs.add(x);
        inputs.add(y);

        NandCircuit nand1 = new NandCircuit(x, y);
        NandCircuit nand2 = new NandCircuit(x, nand1.getOutput());
        NandCircuit nand3 = new NandCircuit(nand1.getOutput(), y);
        NandCircuit nand4 = new NandCircuit(nand2.getOutput(), nand3.getOutput());

        outputs.add(nand4.getOutput());
    }

    public Connector getOutput() {
        return outputs.get(0);
    }

}
