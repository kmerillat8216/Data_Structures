// lab2.java
// Karissa.Merillat
// September 5, 2025
// calculates primes using Sieve of Eratosthenes
// demonstrates command line arguments and methods
// What is the maximum prime number you can find using
// your program? 999999937
// How does printing vs. not printing the numbers
// affect performance? Printing the numbers slows the 
// performance down significantly. If the primes weren't
// printed, the sieve itself is effective.
// What factors limit your program from finding larger
// prime numbers? The factors that limit the program are
// the time it takes to print all the primes and with
// larger numbers, the more memory is uses. 

class Lab2 {

	public static void main(String[] args) 
	{
		int N;
		
		//add code to get num from command line argument
		if (args.length > 0)
        {
            N = Integer.parseInt( args[0] );
            System.out.println( "N = " + N);
        }
        else
        {
			N = 1000;
            System.out.println("No argument provided, defaulting to N = 1000");
        }
        
		//call showPrimes
		showPrimes( N );
		
	}//main
	
	public static void showPrimes(int N)
	{
		boolean[] isPrime = new boolean[N + 1];

		for (int i = 2; i <= N; i++){
			isPrime[i] = true;
		}

		for (int i = 2; i * i <= N; i++){
			if (isPrime[i]) {
				for (int j = i * i; j <= N; j += i) {
					isPrime[j] = false;
				}
			}
		}
		//add code to display primes	
		System.out.println("Prime numbers up to " + N + ":");
		for (int i = 2; i <= N; i++) {
			if (isPrime[i]) {
				System.out.print(i + " ");
			}
		}	
		System.out.println();
	}//showPrimes
}//lab2