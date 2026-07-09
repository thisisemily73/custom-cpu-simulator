// stores instructions and data
public class Memory {
    private int[] memory;

    public Memory(int size) {
        memory = new int[size];
    }

    public void write(int address, int value) {
        if (address >= 0 && address < memory.length) {
            memory[address] = value & 0xFF; // Assuming 8-bit memory
        } else {
            throw new IndexOutOfBoundsException("Invalid memory address: " + address);
        }
    }

    public int read(int address) {
        if (address >= 0 && address < memory.length) {
            return memory[address];
        } else {
            throw new IndexOutOfBoundsException("Invalid memory address: " + address);
        }
    }
}
