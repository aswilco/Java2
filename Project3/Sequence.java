
public class Sequence {

private static int i;
private static long result;
private static long runningResult;
private static int callsToRecursive;
protected static int efficiency;
private static int totalEfficiency;


  public static long computeIterative(int n) {
	  long secPrevious = 0, previous = 1, current = 0;
	  if (n == 0) {
		  current = 0;
	  }
	  else if (n == 1) {
		  current = 1;
	  }
	  else {
	  for (i = 0; i < n - 1; i++) {
		  GetEfficiency();
		  current = 2 * previous + secPrevious;
		  secPrevious = previous;
		  previous = current;
	  }
	  }
	  return current;
}

   public static long computeRecursive(int n) {
	GetEfficiency();
      if (n == 0) {
        result = 0;
      }
      else if (n == 1) {
        result = 1;
      }
      else if (n >= 2) {
        result = 2 * computeRecursive(n-1) + computeRecursive(n-2);
	  }
return result;
}

   public static int GetEfficiency() {
	efficiency++;
	totalEfficiency = efficiency;
	   return totalEfficiency;
   }
  }



