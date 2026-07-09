// math and logic
// ALU: Arithmetic Logic Unit
public class ALU {
    
    public int add(int a, int b) {
        return a + b & 0xFF; // Assuming 8-bit result
    }

    public int subtract(int a, int b) {
        return a - b & 0xFF; // Assuming 8-bit result
    }
}
