/* Reverse bits of a given 32 bits unsigned integer.
 *
 * Example:
 *
 * Input: 43261596
 * Output: 964176192
 * Explanation: 43261596 represented in binary as 00000010100101000001111010011100, 
 *             return 964176192 represented in binary as 00111001011110000010100101000000.
 * 
 */

uint32_t reverseBits(uint32_t n) 
{
    
    uint32_t result = 0;
    int count = 32;
    
    while (count--) 
    {
        
        result <<= 1;
        result = result | n & 1;
        n >>= 1;
        
    }
    
    return result;
    
}