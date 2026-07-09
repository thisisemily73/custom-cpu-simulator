# Development Log

## July 7, 2026

### Goal
Set up Java development environment and successfully run the first CPU program.

### Problem Encountered
Java commands were not recognized in Git Bash:
bash: javac: command not found
bash: java: command not found

### Investigation
Verified that Oracle JDK 23 was installed at:
C:\Program Files\Java\Oracle_JDK-23

Confirmed that the 'bin' folder contained:
- java.exe
- javac.exe

### Solution
Added Java's bin directory to PATH:
C:\Program Files\Java\Oracle_JDK-23\bin

Restarted terminal and verified:
java -version
javac -version

### Result
Java development environment successfully configured.

## July 7, 2026 — First CPU Program Execution

### Goal
Create the initial CPU program structure and verify that the Java environment works.

### Implementation
Created the first CPU class:

- Initialized CPU project structure
- Created main execution method
- Verified Java compilation and execution

### Output
Custom CPU running...


### Next Goal
Design CPU architecture:
- Registers
- Memory model
- Instruction set
- Execution cycle

-----------------------------------------------------------

## July 8 — Instruction Parser Completed

Milestone:
The CPU can now transform assembly-like text commands into structured Instruction objects.

Key design decision:
Changed from fixed instruction fields (register + value) to a flexible operand-based model because different instructions require different operand types.

Example:
LOAD R1, 5
→ opcode = LOAD
→ operand1 = R1
→ operand2 = 5

ADD R1, R2
→ opcode = ADD
→ operand1 = R1
→ operand2 = R2

## Program Counter Added

The CPU now includes a program counter (PC) to track the current instruction being executed.

Previously, Java controlled program execution using a loop. The next update will transfer instruction sequencing responsibility to the CPU itself through a fetch-decode-execute cycle.