package SimpleStartup;
public class SimpleStartupTestDrive {
    public static void main(String[] args) {
        SimpleStartup dot = new SimpleStartup();
        int[] locations = {2,3,4,5};
        dot.setLocationCells(locations);
        int userGuess = 5;
        String result = dot.checkYourself(userGuess);
        String testResult = "failed";
        if(result.equals("hit")){
                testResult="passes";
                };
        System.out.println(testResult);
    }
}
class SimpleStartup {
   private int[] locationCells;
   private int numberOfHits = 0;

   public void setLocationCells(int[] locs){
       locationCells = locs;
   }
   public String checkYourself (int guess){
       String result = "miss";
       for(int cell : locationCells){
           if(guess == cell){
               result = "hit";
               numberOfHits++;
               break;

           }
       }
       if(numberOfHits == locationCells.length){
           result = "kill";
       }
       System.out.println(result);
       return result;
   }
}