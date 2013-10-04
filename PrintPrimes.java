public class PrintPrimes {
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
      printPrimes example = new printPrimes(300, 50, 4, 30);
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

      int x = 1;
      int order = 2;
      int squaredPrime = 9;

      for(int primesFoundSoFar = 2; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) {
        do {
          x = x + 2;
          if (x == squaredPrime) {
            order = order + 1;
            squaredPrime = listOfPrimes[order] * listOfPrimes[order];
            primeMultiples[order - 1] = x;
          }
          n = 2;
          isPrime = true;
          while (n < order && isPrime) {
            while (primeMultiples[n] < x)
              primeMultiples[n] = primeMultiples[n] + listOfPrimes[n] + listOfPrimes[n];
            if (primeMultiples[n] == x)
              isPrime = false;
            n = n + 1;
          }
        } while (!isPrime);
        listOfPrimes[primesFoundSoFar] = number;
      }
    }

    public void printPages() {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= numberOfPrimes) {
          System.out.println("The First " + numberOfPrimes +
                               " Prime Numbers --- Page " + pageNumber);
          System.out.println("");
          for (int rowOffset = pageOffset; rowOffset < pageOffset + rows; rowOffset++){
            for (int i = 0; i < columns;i++)
              if (rowOffset + columns * rows <= numberOfPrimes)
                System.out.format("%10d", listOfPrimes[rowOffset + columns * rows]);
            System.out.println("");
          }
          System.out.println("\f");
          PAGENUMBER = PAGENUMBER + 1;
          PAGEOFFSET = PAGEOFFSET + rows * columns;
        }
    }
}

      
