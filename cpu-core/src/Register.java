// stores values
public class Register {
    private int value;

    public Register () {
        value = 0;
    }

    public void setValue(int value) {
        this.value = value & 0xFF; // Assuming 8-bit register
    }

    public int getValue() {
        return value;
    }
}
