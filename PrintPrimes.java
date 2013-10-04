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
      boolean JPRIME;
      int N;
      int MULT[] = new int[maxOrder + 1];

      int J = 1;
      int ORD = 2;
      int SQUARE = 9;

      for(int primesFoundSoFar = 2; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) {
        do {
          J = J + 2;
          if (J == SQUARE) {
            ORD = ORD + 1;
            SQUARE = listOfPrimes[ORD] * listOfPrimes[ORD];
            MULT[ORD - 1] = J;
          }
          N = 2;
          JPRIME = true;
          while (N < ORD && JPRIME) {
            while (MULT[N] < J)
              MULT[N] = MULT[N] + listOfPrimes[N] + listOfPrimes[N];
            if (MULT[N] == J)
              JPRIME = false;
            N = N + 1;
          }
        } while (!JPRIME);
        listOfPrimes[primesFoundSoFar] = J;
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

      
