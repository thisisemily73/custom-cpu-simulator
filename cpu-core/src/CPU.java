// main "brain"

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class CPU {

    static Register R1 = new Register();
    static Register R2 = new Register();
    static ALU ALU = new ALU();
    static Memory Memory = new Memory(256); // 256 bytes of memory

    private static int pc; // program counter
    private static boolean running;

    public CPU () {
        // Initialize CPU components if needed
        pc = 0;
        running = true;
    }

    public static void main(String[] args) {

        System.out.println("Custom CPU Simulator is running...");

        try {
            List<String> lines = Files.readAllLines(
                    Paths.get("../../programs/store-value.txt")
            );

            while (running) {
                String line = lines.get(pc);
                System.out.println("PC = " + pc + ": " + line);
                Instruction instruction = parseInstruction(line);
                executeInstruction(instruction, R1, R2);
                pc++; // Move to the next instruction

                if (pc >= lines.size()) {
                    System.out.println("End of program reached. ENDED WITHOUT HALT.");
                    running = false;
                }
            }

        } catch (IOException e) {
            System.out.println("Could not load program.");
            e.printStackTrace();
        }
    }

    public static Instruction parseInstruction(String line) {

        String[] parts = line.split(" ");

        String opcode = parts[0];

        String operand1 = parts[1].replace(",", "");

        String operand2 = parts[2];

        return new Instruction(opcode, operand1, operand2);
    }

    public static void executeInstruction(Instruction instruction,
            Register R1, Register R2
    ) {
        String opcode = instruction.getOpcode();
        String operand1 = instruction.getOperand1();
        String operand2 = instruction.getOperand2();

        switch (opcode) {
            case "LOAD":
                // Load value into register
                int value = Integer.parseInt(
                        instruction.getOperand2()
                );

                if (instruction.getOperand1().equals("R1")) {
                    R1.setValue(value);
                } else if (instruction.getOperand1().equals("R2")) {
                    R2.setValue(value);
                }

                break;
            case "ADD":

                if (operand1.equals("R1") && operand2.equals("R2")) {

                    int result = ALU.add(
                            R1.getValue(),
                            R2.getValue()
                    );

                    R1.setValue(result);
                }

                break;
            case "SUB":
                // Subtract values from registers
                if (operand1.equals("R1") && operand2.equals("R2")) {
                    int result = ALU.subtract(R1.getValue(), R2.getValue());
                    R1.setValue(result);
                } else if (operand1.equals("R2") && operand2.equals("R1")) {
                    int result = ALU.subtract(R2.getValue(), R1.getValue());
                    R2.setValue(result);
                }
                break;
            case "STORE":
                // Store value from register to memory (not implemented)
                int address = Integer.parseInt(operand2);

                if (operand1.equals("R1")) {

                    Memory.write(
                            address,
                            R1.getValue()
                    );

                } else if (operand1.equals("R2")) {

                    Memory.write(
                            address,
                            R2.getValue()
                    );
                }
                break;
            case "HALT":
                running = false;
                System.out.println("CPU halted.");
                break;
            default:
                System.out.println("Unknown opcode: " + opcode);
        }
    }
}
