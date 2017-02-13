Public class Sequence {
  
  
  public static int computeIterative(int n) {
    if (n == 1) {
      results = 1
    }
    else if (n == 0) {
      results = 0
    }
    else {
      int[] results = new int[n];
      for (i=1, i < n, i++) {
        results[0] = 0;
        results[1] = 1;
        results[i] = (2(results[i-1]) + results[i-2]);
        return results[n];   
      }
    }
  }
      
   public static int computeRecursive(int n) {
     int callsToRecursive;
     callsToRecursive++;
    if ( n >= 0) {
      int i = 1;
      n = this.n;
      if (n == 0) {
        return 0;
      }
      if (n == 1) {
        return 1;
      }
      else {
        return 2(computeRecursive(n-1)) + computeRecursive(n-2);
      }
    }        
  }    
}
    
    
