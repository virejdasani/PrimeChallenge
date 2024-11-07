import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

class PrimeCheckerTest {
    
    @Test
    void testIsValidInput() {
        assertTrue(PrimeChecker.isValidInput("12345"));
        assertFalse(PrimeChecker.isValidInput("123 45"));
        assertFalse(PrimeChecker.isValidInput("abc123"));
    }

    @Test
    void testIsPrime() {
        assertTrue(PrimeChecker.isPrime(2));
        assertTrue(PrimeChecker.isPrime(3));
        assertFalse(PrimeChecker.isPrime(4));
        assertTrue(PrimeChecker.isPrime(11));
    }

    @Test
    void testFindPrimesInSequence() {
        List<Integer> primes = PrimeChecker.findPrimesInSequence("12345");
        assertTrue(primes.contains(2));
        assertTrue(primes.contains(3));
        assertTrue(primes.contains(5));
        assertTrue(primes.contains(23));
        assertFalse(primes.contains(4));
    }
}
