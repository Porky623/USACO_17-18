import java.io.*;
import java.util.*;
public class measurement1 {
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
      StringTokenizer stn = new StringTokenizer(f.readLine());
      //reads N and G
      int N = Integer.parseInt(stn.nextToken());
      int G = Integer.parseInt(stn.nextToken());
      //the list of the cows' milk
      ArrayList<Long> milk = new ArrayList<Long>();
      //mapping from name to milk index
      HashMap<String,Integer> toCow = new HashMap<String,Integer>();
      //which cow we're on
      int index = 0;
      int[][] changes = new int[N][3];
      for(int i = 0; i < N; i++) {
         StringTokenizer st = new StringTokenizer(f.readLine());
         //day
         changes[i][0]=Integer.parseInt(st.nextToken());
         String k = st.nextToken();
         //if there hasn't been a cow with that name yet, add it to the map and list
         if(!toCow.containsKey(k)) {
            toCow.put(k, index);
            //initial milk G
            milk.add((long)G);
            index++;
         }
         changes[i][1]=toCow.get(k);
         k = st.nextToken();
         //parses change
         changes[i][2]=Integer.parseInt(k.substring(1, k.length()));
         if(k.charAt(0)=='-')
            changes[i][2]*=-1;
      }
      //sort by date
      Arrays.sort(changes,Comparator.comparing((int[] arr) -> arr[0]));
      int count = 0;
      if(milk.size()<N)
      milk.add((long)G);
      //whether each cow has the most milk or not: maybe change to hashset?
      boolean[] max = new boolean[milk.size()];
      //all cows start with the most milk
      for(int i = 0; i < milk.size(); i++) {
         max[i]=true;
      }
      //maybe too many for loops in here...
      long curMax = (long)G;
      for(int i = 0; i < N; i++) {
    	  boolean wasMax = (milk.get(changes[i][1])==curMax);
    	  //changes amount of milk for that cow
         milk.set(changes[i][1], milk.get(changes[i][1])+changes[i][2]);
         if(milk.get(changes[i][1])>curMax) {
        	 curMax=milk.get(changes[i][1]);
         }
         //what's the max milk any cow produces?
         else if(wasMax) {
	         curMax = milk.get(0);
	         for(int j = 1; j < milk.size(); j++) {
	            if(milk.get(j)>curMax)
	               curMax=milk.get(j);
	         }
         }
         //sees which cows have the max milk production
         boolean change = false;
         for(int j = 0; j < milk.size(); j++) {
            if((milk.get(j)==curMax)!=max[j])
            	change=true;
            max[j]=(milk.get(j)==curMax);
         }
         if(change)
        	 count++;
      }
      out.println(count);
      out.close();
   }
}
