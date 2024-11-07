import java.io.*;
import java.util.*;

public class PrimeChecker {
    private static final Set<Integer> primeCache = new HashSet<>();
    private static final String OUTPUT_FILE = "prime_numbers.txt";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
          // Input: Username and numeric sequence
          System.out.print("Enter username: ");
          String username = scanner.nextLine();
          System.out.print("Enter a numeric sequence: ");
          String numberSequence = scanner.nextLine();

          // Validate input
          if (!isValidInput(numberSequence)) {
              System.out.println("Invalid input. Only non-space, non-letter numeric sequences are allowed.");
              return;
          }

          // Find prime numbers in sequence
          List<Integer> primes = findPrimesInSequence(numberSequence);

          // Output result with cleaned formatting (remove square array brackets)
          String cleanedOutput = primes.toString().replace("[", "").replace("]", "");
          System.out.println("Prime Numbers in sequence: " + cleanedOutput);

          // Save results to file and cache
          saveToCache(primes);
          saveToFile(primes);
        }
    }

    // Validate input to ensure only numeric characters are present
    private static boolean isValidInput(String input) {
        return input.matches("\\d+");
    }

    // Find all primes in all possible subsequences of the input string
    private static List<Integer> findPrimesInSequence(String numberSequence) {
        Set<Integer> primes = new LinkedHashSet<>();
        
        // Check all subsequences
        for (int length = 1; length <= numberSequence.length(); length++) {
            for (int start = 0; start <= numberSequence.length() - length; start++) {
                String subSequence = numberSequence.substring(start, start + length);
                int num = Integer.parseInt(subSequence);
                
                // Check if number is prime and add to set
                if (isPrime(num)) {
                    primes.add(num);
                }
            }
        }
        return new ArrayList<>(primes);
    }

    // Check if a number is prime, using cache to improve performance
    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (primeCache.contains(number)) return true;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }

        // Add to cache if prime
        primeCache.add(number);
        return true;
    }

    // Save prime numbers to cache (HashSet to avoid duplicates)
    private static void saveToCache(List<Integer> primes) {
        primeCache.addAll(primes);
    }

    // Save prime numbers to file, appending to existing data
    private static void saveToFile(List<Integer> primes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE, true))) {
            writer.write("Prime Numbers in sequence: " + primes + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
