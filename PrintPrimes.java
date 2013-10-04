public class printPrimes {
  int numberOfPrimes;
  int rows;
  int columns;
  int maxOrder;
  int listOfPrimes[];

  public printPrimes(int numberOfPrimes, int rows, int columns, int maxOrder) {
    this.numberOfPrimes = numberOfPrimes;
    this.rows  = rows;
    this.column  = columns;
    this.maxOrder = maxOrder;
    this.listOfPrimes = new int[numberOfPrimes + 1];
  }


  public static void main(String[] args) {
      printPrimes example = new printPrimes(300, 50, 4, 10, 30);
      example.calculatePrimes();
      example.printPages();
  }

  public void calculatePrimes() {
      /* Two is the only even prime. All other prime numbers are odd.
       * To simplify the code, we simply add 2 as a prime number, and
       * delegate the task of finding all odd prime numbers to a helper
       * function.
       */
      listOfPrimes[1] = 2;
      calculateOddPrimes();
  }

  private void calculateOddPrimes() {
      boolean isPrime;
      int n;
      int primeMultiples[] = new int[maxOrder + 1];

      int number = 1;
      int order = 2;
      int squaredPrime = 9;

      for(int primesFoundSoFar = 2; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) {
        do {
          number = number + 2;
          if (number == squaredPrime) {
            order = order + 1;
            squaredPrime = listOfPrimes[order] * listOfPrimes[order];
            primeMultiples[order - 1] = number;
          }
          n = 2;
          isPrime = true;
          while (n < order && isPrime) {
            while (primeMultiples[n] < number)
              primeMultiples[n] = primeMultiples[n] + listOfPrimes[n] + listOfPrimes[n];
            if (primeMultiples[n] == number)
              isPrime = false;
            n = n + 1;
          }
        } while (!isPrime);
        listOfPrimes[primesFoundSoFar] = number;
      }
    }

    public void printPages() {
        int PAGENUMBER = 1;
        int PAGEOFFSET = 1;
        while (PAGEOFFSET <= numberOfPrimes) {
          System.out.println("The First " + numberOfPrimes +
                               " Prime Numbers --- Page " + PAGENUMBER);
          System.out.println("");
          for (int ROWOFFSET = PAGEOFFSET; ROWOFFSET < PAGEOFFSET + rows; ROWOFFSET++){
            for (int C = 0; C < columns;C++)
              if (ROWOFFSET + columns * rows <= numberOfPrimes)
                System.out.format("%10d", listOfPrimes[ROWOFFSET + columns * rows]);
            System.out.println("");
          }
          System.out.println("\f");
          PAGENUMBER = PAGENUMBER + 1;
          PAGEOFFSET = PAGEOFFSET + rows * columns;
        }
    }
}

      
