// CPU commands
public class Instruction {

    private String opcode;
    private String operand1;
    private String operand2;

    public Instruction(String opcode, String operand1, String operand2) {
        this.opcode = opcode;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public String getOpcode() {
        return opcode;
    }

    public String getOperand1() {
        return operand1;
    }

    public String getOperand2() {
        return operand2;
    }
}
