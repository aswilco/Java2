import java.util.ArrayList;

public class Sequence {

private static int results;
private static int i;
private static int result;
private static int runningResult;
private static int callsToRecursive;
private ArrayList<Integer> results = new ArrayList<Integer>();


  public static int computeIterative(int n) {
	  for (i = 0; i < n; i++) {
		  if (i == 0) {
			  results.add(0)
		  }
		  if (i == 1) {
			  results.add(1)
		  }
		  else {
			  results.add(2 * results.get(results.size()-1) + results.get(results.size()-2));
		  }
		  result = results.get(n);
	  }
	  
}

   public static int computeRecursive(int n) {
 
     callsToRecursive++;
    if ( n >= 0) {
      int i = 1;
      if (n == 0) {
        return 0;
      }
      else if (n == 1) {
        return 1;
      }

          else {
        result = 2 * computeRecursive(n-1) + computeRecursive(n-2);
	}
}
return result;
}

   /*public static int getEfficiency() {
     if (Compute.iterative.isSelected()) {
       return i;
     }
     if (Compute.recursive.isSelected()) {
       return callsToRecursive;
     }
   }
*/
  }



