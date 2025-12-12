package labFive.example;

public class repeatTwo {
  private static long stratTime, endTime;
  private static long elapse;


  public static String repeat2 (char c, int n) {
    StringBuilder result = new StringBuilder();
    for (int j=0; j < n; j++) // loop from 0 to n-1
      result.append(c);
    return result.toString();
  }

  public static void timerun(char r, int p) {
    stratTime = System.currentTimeMillis();
    repeat2(r, p);
    endTime = System.currentTimeMillis();
    elapse = endTime - stratTime;
    System.out.print("Repeat numbers = " + p + "\n");
    System.out.println("Time taken for repeat1: " + elapse + " milliseconds");
  }

   public static void main(String[] args) {     
    int[] nums = {50000,100000, 200000, 400000, 800000, 1600000, 3200000, 6400000, 12800000};
    for (int i = 0; i < nums.length; i++) 
    // if(elapse < 1000 )
     timerun('*', nums[i]);
    }
}
