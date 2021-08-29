package avrmc.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javr.core.AVR.HaltedException;
import javr.core.AvrInstruction;
import javr.io.HexFile;
import org.eclipse.jdt.annotation.Nullable;
import org.junit.jupiter.api.Test;

/**
 * Test cases for Part 2 of the assignment.
 *
 * @author David J. Pearce
 *
 */
public class Part3 {
  /**
   * Identifies the directory in which the test firmwares are located.
   */
  private static final @Nullable String TESTS_DIR = "tests/".replace("/", File.separator);

  @Test
  public void test_01() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f), new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29), new AvrInstruction.OUT(0x3d, 28),
        // Initialise loop for 8 iterations
        new AvrInstruction.LDI(29, 0x8),
        // Loop condition
        new AvrInstruction.CPI(29, 0), new AvrInstruction.BREQ(4), new AvrInstruction.PUSH(16),
        new AvrInstruction.DEC(29), new AvrInstruction.POP(16), new AvrInstruction.RJMP(-6),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(1, Part1.computeStackUsage(instructions));
  }

  @Test
  public void test_02() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f), new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29), new AvrInstruction.OUT(0x3d, 28),
        // Branch over method
        new AvrInstruction.RJMP(5),
        // Recursive method
        new AvrInstruction.CPI(29, 0), new AvrInstruction.BREQ(2), new AvrInstruction.DEC(29),
        new AvrInstruction.RCALL(-4), new AvrInstruction.RET(),
        // Initialise for 8 recursive calls
        new AvrInstruction.LDI(29, 0x8), new AvrInstruction.RCALL(-7),
        new AvrInstruction.RJMP(-1) };
    // Check computation
    assertEquals(18, Part1.computeStackUsage(instructions));
  }

  @Test
  public void test_03() throws HaltedException {
    AvrInstruction[] instructions = new AvrInstruction[] {
        // Initialize SP
        new AvrInstruction.LDI(28, 0x5f), new AvrInstruction.LDI(29, 0x2),
        new AvrInstruction.OUT(0x3e, 29), new AvrInstruction.OUT(0x3d, 28),
        // Branch over method
        new AvrInstruction.RJMP(4),
        // Non-recursive method
        new AvrInstruction.PUSH(29), new AvrInstruction.DEC(29), new AvrInstruction.POP(29),
        new AvrInstruction.RET(),
        // Infinite (e.g. game) loop
        new AvrInstruction.LDI(29, 0x8), new AvrInstruction.CPI(29, 0x8),
        new AvrInstruction.BREQ(1), new AvrInstruction.RJMP(-1), new AvrInstruction.RCALL(-9),
        new AvrInstruction.RJMP(-2) };
    // Check computation
    assertEquals(3, Part1.computeStackUsage(instructions));
  }

  @Test
  public void test_04() throws IOException, HaltedException {
    // Check computation
    assertEquals(4, computeStackUsage("fader.hex"));
  }

  @Test
  public void test_05() throws IOException, HaltedException {
    // Check computation
    assertEquals(10, computeStackUsage("blocks_1.hex"));
  }

  @Test
  public void test_06() throws IOException, HaltedException {
    // Check computation
    assertEquals(10, computeStackUsage("blocks_2.hex"));
  }

  @Test
  public void test_07() throws IOException, HaltedException {
    // Check computation
    assertEquals(10, computeStackUsage("blocks_3.hex"));
  }

  @Test
  public void test_08() throws IOException, HaltedException {
    // Check computation
    assertEquals(10, computeStackUsage("blocks_7.hex"));
  }

  @Test
  public void test_09() throws IOException, HaltedException {
    // Check computation
    assertEquals(10, computeStackUsage("blocks_4.hex"));
  }

  @Test
  public void test_10() throws IOException, HaltedException {
    // Check computation
    assertEquals(10, computeStackUsage("blocks_5.hex"));
  }

  @Test
  public void test_11() throws IOException, HaltedException {
    // Check computation
    assertEquals(10, computeStackUsage("blocks_6.hex"));
  }

  @Test
  public void test_12() throws IOException, HaltedException {
    // Check computation
    assertEquals(12, computeStackUsage("blocker_1.hex"));
  }

//  @Test
//  public void test_13() throws IOException, HaltedException {
//    // Check computation
//    assertEquals(12, computeStackUsage("blocker_2.hex"));
//  }
//
//  @Test
//  public void test_14() throws IOException, HaltedException {
//    // Check computation
//    assertEquals(33, computeStackUsage("numbers_1.hex"));
//  }
//
//  @Test
//  public void test_15() throws IOException, HaltedException {
//    // Check computation
//    assertEquals(63, computeStackUsage("snake.hex"));
//  }
//
//  @Test
//  public void test_16() throws IOException, HaltedException {
//    // Check computation
//    assertEquals(39, computeStackUsage("tetris.hex"));
//  }

  /**
   * For a given sequence of instructions compute the maximum stack usage.
   *
   * @param filename Filename of firmware to load from disk.
   * @return Calculated maximum stack height
   * @throws IOException     If something goes wrong loading the firmware (e.g.
   *                         <code>FileNotFound</code>).
   * @throws HaltedException This should be impossible.
   */
  private int computeStackUsage(String filename) throws IOException, HaltedException {
    // Read the firmware image
    HexFile.Reader hfr = new HexFile.Reader(new FileReader(TESTS_DIR + filename));
    HexFile hf = hfr.readAll();
    assert hf != null;
    return Part1.computeStackUsage(hf);
  }
}
