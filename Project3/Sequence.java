Public class Sequence {
  
  private int n = Gui.getText(n);
  
  public static int computeIterative() {
    int[] results = new int[n];
    for (i=1, i < n, i++) {
      results[i] = (2(results[i-1]) + results[1-2]);
      return results[n];   
}
    
    
