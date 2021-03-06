public class PrintPrimes {
  int numberOfPrimes;
  int rows;
  int columns;
  int maxOrder;
  int listOfPrimes[];

  public PrintPrimes(int numberOfPrimes, int rows, int columns, int maxOrder) {
    this.numberOfPrimes = numberOfPrimes;
    this.rows  = rows;
    this.columns  = columns;
    this.maxOrder = maxOrder;
    this.listOfPrimes = new int[numberOfPrimes + 1];
  }


  public static void main(String[] args) {
      PrintPrimes example = new PrintPrimes(300, 50, 4, 30);
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
      int i;
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
          
          i = 2;          
          isPrime = true;
          
          while (i < order && isPrime) {
            while (primeMultiples[i] < x)
              primeMultiples[i] = primeMultiples[i] + listOfPrimes[i] + listOfPrimes[i];
            
            if (primeMultiples[i] == x)
              isPrime = false;
           
            i = i + 1;
          }
        } 
        
        while (!isPrime);        
        listOfPrimes[primesFoundSoFar] = x;
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
            for (int n = 0; n < columns; n++)
              if (rowOffset + n * rows <= numberOfPrimes)
                System.out.format("%10d", listOfPrimes[rowOffset + n * rows]);
            System.out.println("");
          }
          
          System.out.println("\f");
          pageNumber = pageNumber + 1;
          pageOffset = pageOffset + rows * columns;
        }
    }
}

      
