Public class Sequence {
  
  private int n = Gui.getText(n);
  
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
    
    
