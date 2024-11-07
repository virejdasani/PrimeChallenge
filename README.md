Name: Virej Dasani

Email: dasanivirej@gmail.com

## Assumptions made

- EACH processed result of prime numbers will have to be written to file (not just unique prime numbers found)
- The cache will only hold unique prime numbers (no duplicates, for better space usage)
- Only purely numeric inputs are accepted
- File persistence appends new primes to a file (in a human readable manner - similar to what is printed to console)

## Usage instructions

Compile the program:

```
javac PrimeChecker.java
```

Run the program:

```

java PrimeChecker
```

Example interaction:

```
Enter username: user1
Enter a numeric sequence: 12345
Prime Numbers in sequence: 2, 3, 5, 23
```

Output:

The program will print the list of primes found.
The program will save every NEW prime found in cache memory (in a set so it's unique)
The file prime_numbers.txt will contain an appended line with the new results after each run.
The file will look like this after the first run:

```
Prime Numbers in sequence: [2, 3, 5, 23]
```

Tests are under tests/PrimeCheckerTest.java
