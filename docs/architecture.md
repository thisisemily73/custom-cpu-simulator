# CPU Architecture v1.0

## Overview
An 8-bit custom CPU simulator designed in Java.

## Registers

A:
B:
C:
D:

## Memory

The CPU uses a Von Neumann-style memory model where instructions and data share the same memory space.

This design simplifies the architecture and allows programs to be loaded and executed from the same memory subsystem.

Size: 256 bytes

## Instructions

LOAD:
STORE:
ADD:
SUB:
AND:
OR:
JMP:
HLT:

## Instruction Encoding

Each instruction is 8 bits:

- Upper 4 bits: Opcode
- Lower 4 bits: Operand

Example:
0001 0101 -> LOAD 5

## Design Reasoning
