package avrmc.tests;

import static avrmc.core.AbstractMemory.Byte;
import static org.junit.Assert.assertEquals;

import avrmc.core.AbstractAvr;
import avrmc.core.AbstractMemory;
import avrmc.core.AbstractMemory.Word;
import avrmc.core.AvrModelChecker;
import javr.core.AVR;
import javr.core.AVR.HaltedException;
import javr.core.AvrInstruction;
import javr.io.HexFile;
import org.junit.jupiter.api.Test;

/**
 * Test cases for Part 1 of the assignment.
 *
 * @author David J. Pearce
 *
 */
public class Part2 {

  @Test
  public void test_01() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(2),
        new AvrInstruction.NOP(),
        new AvrInstruction.NOP(),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(0, computeStackUsage(instructions));
  }

  @Test
  public void test_02() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(3),
        new AvrInstruction.NOP(),
        new AvrInstruction.NOP(),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_03() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(3),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_04() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against zero
        new AvrInstruction.CP(16, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(3),
        new AvrInstruction.NOP(),
        new AvrInstruction.NOP(),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_05() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against zero
        new AvrInstruction.CP(16, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(3),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_06() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        new AvrInstruction.NEG(16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(3),
        new AvrInstruction.NOP(),
        new AvrInstruction.NOP(),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_07() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        new AvrInstruction.NEG(16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(3),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_08() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        new AvrInstruction.COM(16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(3),
        new AvrInstruction.NOP(),
        new AvrInstruction.NOP(),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_09() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        new AvrInstruction.COM(16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(3),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_10() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        new AvrInstruction.ADD(16, 16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(3),
        new AvrInstruction.NOP(),
        new AvrInstruction.NOP(),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_11() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        new AvrInstruction.ADD(16, 16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(3),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_12() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(28, 0x16),
        new AvrInstruction.ADIW(28, 1),
        // Compare against zero
        new AvrInstruction.CPI(28, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(3),
        new AvrInstruction.NOP(),
        new AvrInstruction.NOP(),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_13() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(28, 0x16),
        new AvrInstruction.ADIW(28, 1),
        // Compare against zero
        new AvrInstruction.CPI(28, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(3),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_14() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(28, 0x16),
        new AvrInstruction.SBIW(28, 1),
        // Compare against zero
        new AvrInstruction.CPI(28, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(3),
        new AvrInstruction.NOP(),
        new AvrInstruction.NOP(),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_15() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(28, 0x16),
        new AvrInstruction.SBIW(28, 1),
        // Compare against zero
        new AvrInstruction.CPI(28, 1),
        // Conditional Branch
        new AvrInstruction.BREQ(3),
        new AvrInstruction.NOP(),
        new AvrInstruction.NOP(),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_16() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(28, 0x16),
        new AvrInstruction.SUB(28, 29),
        // Compare against zero
        new AvrInstruction.CPI(28, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(3),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_17() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(29, 0x16),
        new AvrInstruction.AND(29, 28),
        // Compare against zero
        new AvrInstruction.CPI(29, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(3),
        new AvrInstruction.NOP(),
        new AvrInstruction.NOP(),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_18() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(29, 0x16),
        new AvrInstruction.ANDI(29, 0xFF),
        // Compare against zero
        new AvrInstruction.CPI(29, 0),
        // Conditional Branch
        new AvrInstruction.BRLT(3),
        new AvrInstruction.NOP(),
        new AvrInstruction.NOP(),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_19() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(29, 0x16),
        new AvrInstruction.AND(29, 28),
        // Compare against zero
        new AvrInstruction.CPI(29, 0),
        // Conditional Branch
        new AvrInstruction.BREQ(3),
        new AvrInstruction.PUSH(0x16),
        new AvrInstruction.POP(0x16),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_20() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        new AvrInstruction.LSR(16),
        // Compare against zero
        new AvrInstruction.CPI(16, 1),
        // Conditional Branch
        new AvrInstruction.BRLO(4),
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(2, computeStackUsage(instructions));
  }

  @Test
  public void test_21() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        new AvrInstruction.SBRC(16, 1),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BREQ(1),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(2, computeStackUsage(instructions));
  }

  @Test
  public void test_22() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        new AvrInstruction.BST(16, 1),
        // Conditional Branch
        new AvrInstruction.BRTS(1),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(2, computeStackUsage(instructions));
  }

  @Test
  public void test_23() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        new AvrInstruction.BST(16, 1),
        // Conditional Branch
        new AvrInstruction.BRTC(1),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(2, computeStackUsage(instructions));
  }

  @Test
  public void test_24() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        new AvrInstruction.BST(16, 1),
        new AvrInstruction.BLD(16, 1),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BRNE(1),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(2, computeStackUsage(instructions));
  }

  @Test
  public void test_25() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare two registers and skip
        new AvrInstruction.CPSE(16, 29),
        // Conditional Branch
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(2, computeStackUsage(instructions));
  }

  @Test
  public void test_26() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BRHC(3),
        new AvrInstruction.PUSH(16),
        new AvrInstruction.POP(16),
        new AvrInstruction.RJMP(1),
        new AvrInstruction.RCALL(1),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.PUSH(18),
        new AvrInstruction.PUSH(19),
        new AvrInstruction.LDI(16, 1),
        new AvrInstruction.LDI(17, 2),
        new AvrInstruction.ADD(17, 18),
        new AvrInstruction.POP(19),
        new AvrInstruction.POP(18),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        new AvrInstruction.RET(), };
    // Check computation
    assertEquals(6, computeStackUsage(instructions));
  }

  @Test
  public void test_27() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BRHC(1),
        new AvrInstruction.RCALL(1),
        new AvrInstruction.RJMP(-1),
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.PUSH(18),
        new AvrInstruction.PUSH(19),
        new AvrInstruction.LDI(16, 1),
        new AvrInstruction.LDI(17, 2),
        new AvrInstruction.ADD(17, 18),
        new AvrInstruction.POP(19),
        new AvrInstruction.POP(18),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        new AvrInstruction.RET(), };
    // Check computation
    assertEquals(6, computeStackUsage(instructions));
  }

  @Test
  public void test_28() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against one
        new AvrInstruction.CPI(16, 0xff),
        // Conditional Branch
        new AvrInstruction.BRGE(5),
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        new AvrInstruction.RJMP(2),
        new AvrInstruction.PUSH(16),
        new AvrInstruction.POP(16),
        new AvrInstruction.RJMP(-1), };
    // Check computation
    assertEquals(2, computeStackUsage(instructions));
  }

  @Test
  public void test_29() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BRGE(3),
        new AvrInstruction.PUSH(16),
        new AvrInstruction.POP(16),
        new AvrInstruction.RJMP(4),
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        new AvrInstruction.RJMP(-1), };
    // Check computation
    assertEquals(2, computeStackUsage(instructions));
  }

  @Test
  public void test_30() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Clear zero flag
        new AvrInstruction.CLZ(),
        // Conditional Branch
        new AvrInstruction.BRBC(1, 4),
        // Dead code
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        // Live code
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(0, computeStackUsage(instructions));
  }

  @Test
  public void test_31() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Clear zero flag
        new AvrInstruction.SEZ(),
        // Conditional Branch
        new AvrInstruction.BRBC(1, 4),
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(2, computeStackUsage(instructions));
  }

  @Test
  public void test_32() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Clear zero flag
        new AvrInstruction.CLZ(),
        // Conditional Branch
        new AvrInstruction.BRBS(1, 4),
        // Dead code
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        // Live code
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(2, computeStackUsage(instructions));
  }

  @Test
  public void test_33() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Clear zero flag
        new AvrInstruction.CLC(),
        // Conditional Branch
        new AvrInstruction.BRBC(1, 4),
        // Dead code
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        // Live code
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(2, computeStackUsage(instructions));
  }

  @Test
  public void test_34() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BREQ(5),
        new AvrInstruction.BRNE(4),
        // Dead code
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        // Live code
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(0, computeStackUsage(instructions));
  }

  @Test
  public void test_35() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BREQ(6),
        new AvrInstruction.BREQ(1),
        new AvrInstruction.RJMP(-1),
        // Dead code
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        // Live code
        new AvrInstruction.PUSH(16),
        new AvrInstruction.POP(16),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  @Test
  public void test_36() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BRNE(1),
        new AvrInstruction.RJMP(5),
        new AvrInstruction.BRNE(4),
        // Dead code
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        // Live code
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(0, computeStackUsage(instructions));
  }

  @Test
  public void test_37() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f),
        new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29),
        new AvrInstruction.OUT(0x3d, 28),
        // Read (Unknown) Input
        new AvrInstruction.IN(16, 0x16),
        // Compare against zero
        new AvrInstruction.CPI(16, 0),
        // Conditional Branch
        new AvrInstruction.BRNE(6),
        new AvrInstruction.BRNE(1),
        new AvrInstruction.RJMP(-1),
        // Dead code
        new AvrInstruction.PUSH(16),
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.POP(16),
        // Live code
        new AvrInstruction.PUSH(17),
        new AvrInstruction.POP(17),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, computeStackUsage(instructions));
  }

  /**
   * Symbolically execute a given sequence of instructions, whilst determining the
   * maximum stack height encountered. This will fork the AVR state as necessary
   * when choice points are encountered (i.e. conditional branches on unknown
   * values).
   *
   * @param instructions The sequence of instructions to be executed.
   * @return Calculated maximum stack height.
   * @throws HaltedException This should be impossible.
   */
  public static int computeStackUsage(AvrInstruction... instructions) throws HaltedException {
    // Assemble instructions into hexfile
    HexFile firmware = assemble(instructions);
    return computeStackUsage(firmware);
  }

  /**
   * Symbolically execute a given sequence of instructions, whilst determining the
   * maximum stack height encountered. This will fork the AVR state as necessary
   * when choice points are encountered (i.e. conditional branches on unknown
   * values).
   *
   * @param firmware The AVR program to be checked.
   * @return Calculated maximum stack height.
   * @throws HaltedException This should be impossible.
   */
  public static int computeStackUsage(HexFile firmware) throws HaltedException {
    // Construct initial (abstract) machine
    AbstractAvr avr = new AbstractAvr(8192, 32 + 64 + 512);
    // Upload the firmware
    firmware.uploadTo(avr.getCode());
    // Clock AVR to ensure SP initialised before running the model checker
    // (otherwise, we get strange results since SP has an initial value of zero).
    clockInitialStack(avr);
    // Apply the model check to exhaustively explore all reachable states.
    return new AvrModelChecker<>(new StackHeightProperty(607)).apply(avr);
  }

  /**
   * This clocks the given state until the stack has been properly initialised.
   * For the ATtiny85 the stack is properly initialised once it is given the value
   * <code>607</code>. If we don't do this, then our static analysis will get a
   * bunch of jumbled results leading to invalid readings.
   *
   * @param avr The state to be clocked.
   * @throws HaltedException In the very unlikely event that the machine
   *                         terminates before the stack is actually initialised.
   */
  private static void clockInitialStack(AbstractAvr avr) throws HaltedException {
    int sp = 0;
    while (sp != 607) {
      avr.clock();
      sp = readStackPointer(avr);
    }
  }

  /**
   * Responsible for turning a given sequence of instructions into a hexfile, so
   * that it can in turn be uploaded to the stack analysis.
   *
   * @param instructions The sequence of instructions to be assembled into a
   *                     firmware.
   * @return The firmware constructed for the given sequence.
   */
  private static HexFile assemble(AvrInstruction... instructions) {
    byte[][] chunks = new byte[instructions.length][];
    int total = 0;
    // Encode each instruction into a byte sequence
    for (int i = 0; i != instructions.length; ++i) {
      byte[] bytes = instructions[i].getBytes();
      chunks[i] = bytes;
      total = total + bytes.length;
    }
    // Flatten the chunks into a sequence
    byte[] sequence = new byte[total];
    //
    for (int i = 0, j = 0; i != chunks.length; ++i) {
      byte[] chunk = chunks[i];
      System.arraycopy(chunk, 0, sequence, j, chunk.length);
      j = j + chunk.length;
    }
    // Finally, create the hex file!
    HexFile h = HexFile.toHexFile(sequence, 16);
    assert h != null;
    return h;
  }

  /**
   * A model checking property which extracts the maximum stack height from a
   * given AVR state.
   *
   * @author David J. Pearce
   *
   */
  private static class StackHeightProperty implements AvrModelChecker.Property<Integer> {
    /**
     * Identifies the maximum possible value for the stack pointer. Since the stack
     * grows downwards, this identifies when the stack has zero height.
     */
    private final int maxMemory;

    public StackHeightProperty(int max) {
      this.maxMemory = max;
    }

    @Override
    public Integer map(AbstractAvr state) {
      // Read value of Stack Pointer in the given AVR state.
      return maxMemory - readStackPointer(state);
    }

    @Override
    public Integer join(Integer left, Integer right) {
      return (left > right) ? left : right;
    }
  }

  /**
   * Read the value of the SP register from a given AVR state.
   *
   * @param state The abstract machine state to read the stack pointer from.
   * @return The value read.
   */
  private static int readStackPointer(AbstractAvr state) {
    // Read value of Stack Pointer in the given AVR state.
    AbstractMemory data = state.getData();
    int address = AVR.SPL_ADDRESS;
    Byte msb = data.read(address + 1);
    Byte lsb = data.read(address);
    Word w = Word.from(msb, lsb);
    // NOTE: In principle, this height could be unknown but its highly unlikely this
    // would ever make sense.
    return w.toInt();
  }
}
