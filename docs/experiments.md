# Milestones

| Date | Feature | Status
| July 8 | Instruction parser | v |
| July 8 | LOAD instruction | v |
| July 8 | ADD instruction + ALU | v |
| July 8 | SUB instruction + ALU | v |
| July 8 | STORE instruction + Memory subsystem | v | 


-----------------------------------------------------------

# Experiment 1: Program Loading

## Goal
Test whether the CPU can load an external program file.

## Input
add-two-numbers.txt

## Program
LOAD R1, 5
LOAD R2, 3
ADD R1, R2
STORE R1, 0

## Result
The CPU successfully loaded and displayed each instruction.

-----------------------------------------------------------

# Experiment 2: Instruction Parsing

## Objective
Test whether the CPU simulator can convert raw text instructions into structured instruction objects.

## Input
Program file:
'add-two-numbers.txt'

Program:

LOAD R1, 5
LOAD R2, 3
ADD R1, R2
STORE R1, 0

## Method
The CPU reads each instruction from the program file and passes it through the instruction parser. The parser separates each command into:
- opcode
- operand 1
- operand 2

The resulting data is stored as an Instruction object.

## Result
The CPU successfully parsed all instructions.

Output:

Opcode: LOAD, Operand 1: R1, Operand 2: 5
Opcode: LOAD, Operand 1: R2, Operand 2: 3
Opcode: ADD, Operand 1: R1, Operand 2: R2
Opcode: STORE, Operand 1: R1, Operand 2: 0

## Conclusion
The instruction parsing subsystem is functional. The CPU can now interpret program text and represent instructions internally, enabling future execution logic.

-----------------------------------------------------------

# Experiment 3: LOAD Instruction Execution

## Goal
Verify that the CPU can decode a LOAD instruction and modify register values.

## Input

LOAD R1, 5
LOAD R2, 3

## Expected Behavior

The CPU should store:
- R1 = 5
- R2 = 3

## Result

The CPU successfully executed LOAD instructions and updated register state.

## Conclusion

The CPU can now perform its first state-changing operation.
-----------------------------------------------------------

# Experiment 4: ADD Instruction Execution

## Goal
Verify that the CPU can perform arithmetic addition using the ALU and update register values.

## Input

LOAD R1, 5
LOAD R2, 3
ADD R1, R2

## Expected Behavior

1. Load 5 into R1.
2. Load 3 into R2.
3. Pass both register values into the ALU.
4. Store the result back into R1.

Expected result:

R1 = 8

## Result

The CPU successfully executed the ADD instruction.

Output:

Executed: LOAD R1 5
R1 = 5 | R2 = 0

Executed: LOAD R2 3
R1 = 5 | R2 = 3

Executed: ADD R1 R2
R1 = 8 | R2 = 3

## Conclusion

The CPU successfully transferred values from registers into the ALU, performed an arithmetic operation, and stored the result back into a register.

The register-to-ALU-to-register datapath is now functional.

-----------------------------------------------------------

# Experiment 5: SUB Instruction Execution

## Goal
Verify that the CPU can perform subtraction using the ALU and update register state.

## Input

LOAD R1, 10
LOAD R2, 4
SUB R1, R2

## Expected Behavior

1. Load 10 into R1.
2. Load 4 into R2.
3. Send both values to the ALU.
4. Store the subtraction result back into R1.

Expected result:

R1 = 6

## Result

The CPU successfully executed the SUB instruction.

Output:

R1 = 10 | R2 = 4

Executed: SUB R1 R2

R1 = 6 | R2 = 4

## Conclusion

The CPU now supports arithmetic operations through the ALU, including addition and subtraction. The register-to-ALU-to-register data path is functional.

-----------------------------------------------------------

# Experiment 6: STORE Instruction Execution

## Goal
Test whether the CPU can transfer data from registers into memory.

## Input

LOAD R1, 42
STORE R1, 0

## Expected Behavior

The value 42 should be written into memory address 0.

## Result

The CPU successfully executed STORE.

Register state:
R1 = 42

Memory state:
Memory[0] = 42

## Conclusion

The CPU now supports persistent data storage using a memory subsystem.

-----------------------------------------------------------
-----------------------------------------------------------

# Future Experiment 2: Fibonacci

- Cycles:
- Instructions:
- Observations: