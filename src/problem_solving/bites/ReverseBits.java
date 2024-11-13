package problem_solving.bites;
// https://leetcode.com/problems/reverse-bits/

public class ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            // Extract the least significant bit of n
            int bit = n % 2;//n & 1;
            // Shift result to the left to make room for the new bit
            // If result = 3 (0011), after result <<= 1, result = 6 (0110).
            result <<= 1;
            // Add the extracted bit to the result
            result += bit;//|= bit;
            // Shift n to the right to process the next bit
            n >>>= 1; // Use unsigned shift to handle negative numbers correctly
        }

        return result;
    }
}

/**
 * Detailed Explanation of Bit Reversal:
 *
 * Problem: Given a 32-bit integer `n`, reverse its bits and return the resulting integer.
 *
 * Example:
 * Let's start with n = 5. Its binary representation (32-bit) is:
 *
 * n = 00000000000000000000000000000101
 *
 * Our goal is to reverse the bits to get:
 *
 * reversed = 10100000000000000000000000000000
 *
 * Step-by-step Explanation:
 *
 * 1. **Initialize result to 0**:
 *    The variable `result` will store the reversed bits.
 *    Initially, it's all zeros:
 *    result = 00000000000000000000000000000000
 *
 * 2. **Iterate through all 32 bits of n**:
 *    We use a loop that runs exactly 32 times, once for each bit in the 32-bit integer.
 *
 * 3. **Extract the Least Significant Bit (LSB) of n**:
 *    In each iteration, we extract the LSB of `n` using:
 *
 *    - `n % 2` (returns 0 or 1).
 *    - Alternatively, `n & 1` can be used (bitwise AND operation).
 *
 *    Example (Iteration 1, n = 5):
 *    n = 00000000000000000000000000000101
 *    bit = n % 2 = 1
 *
 * 4. **Shift result to the left**:
 *    We left-shift `result` by 1 to make space for the new bit.
 *
 *    Example:
 *    If `result = 00000000000000000000000000000000`,
 *    after `result <<= 1`, it remains the same as we are shifting zeros.
 *
 * 5. **Add the extracted bit to result**:
 *    We add the extracted `bit` to `result`:
 *    - `result += bit` (or alternatively, `result |= bit`).
 *
 *    Example:
 *    result = 00000000000000000000000000000000
 *    After adding `bit` = 1:
 *    result = 00000000000000000000000000000001
 *
 * 6. **Shift n to the right**:
 *    We now discard the LSB of `n` by right-shifting it:
 *    - `n >>>= 1` (unsigned right shift).
 *
 *    Example:
 *    n = 00000000000000000000000000000101
 *    After `n >>>= 1`:
 *    n = 00000000000000000000000000000010
 *
 * 7. **Repeat Steps 3-6 for All 32 Bits**:
 *    This process is repeated for all 32 bits of `n`.
 *    The next bit is extracted, `result` is shifted left, and the extracted bit is added to `result`.
 *
 * **Final Result**:
 * After 32 iterations, `result` contains the reversed binary representation of `n`.
 *
 * **Key Points**:
 * - Left-shifting `result` ensures that each new bit is added in its correct position.
 * - Right-shifting `n` ensures we process all bits, starting from the least significant bit (LSB).
 *
 * Example Walkthrough for n = 5:
 *
 * Iteration 1:
 *   bit = 1 (from n % 2)
 *   result = 00000000000000000000000000000001
 *   n = 00000000000000000000000000000010
 *
 * Iteration 2:
 *   bit = 0
 *   result = 00000000000000000000000000000010
 *   n = 00000000000000000000000000000001
 *
 * Iteration 3:
 *   bit = 1
 *   result = 00000000000000000000000000000101
 *   n = 00000000000000000000000000000000
 *
 * The loop continues until all 32 bits are processed.
 */
