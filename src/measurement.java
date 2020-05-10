import java.io.*;
import java.util.*;
public class measurement {
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
      HashMap<Integer,Integer> toCow = new HashMap<Integer,Integer>();
      //which cow we're on
      int index = 0;
      int[][] changes = new int[N][3];
      for(int i = 0; i < N; i++) {
         StringTokenizer st = new StringTokenizer(f.readLine());
         //day
         changes[i][0]=Integer.parseInt(st.nextToken());
         int k = Integer.parseInt(st.nextToken());
         //if there hasn't been a cow with that name yet, add it to the map and list
         if(!toCow.containsKey(k)) {
            toCow.put(k, index);
            //initial milk G
            milk.add((long)G);
            index++;
         }
         changes[i][1]=toCow.get(k);
         String j = st.nextToken();
         //parses change
         changes[i][2]=Integer.parseInt(j.substring(1, j.length()));
         if(j.charAt(0)=='-')
            changes[i][2]*=-1;
      }
      //sort by date
      Arrays.sort(changes,Comparator.comparing((int[] arr) -> arr[0]));
      int count = 0;
      if(milk.size()<N)
    	  milk.add((long)G);
      long curMax = G;
      int numMax = milk.size();
      for(int i = 0; i < N; i++) {
    	  int in = changes[i][1];
    	  boolean isMax = (milk.get(in)==curMax);
    	  //changes amount of milk for that cow
         milk.set(in, milk.get(in)+changes[i][2]);
         if(milk.get(in)>curMax) {
        	 curMax=milk.get(in);
        	 //only changes if wasn't only max in the first place
        	 if(!isMax||numMax>1) {
        		 count++;
        	 }
             //if the amount of milk produced is bigger than current max, obviously only one cow has that
    		 numMax=1;
         }
         else if(milk.get(in)==curMax) {
        	 //only changes anything if it wasn't max milk in the first place
        	 if(!isMax) {
	        	 count++;
	        	 numMax++;
        	 }
         }
         //if current milk strictly less than current max: only changes if it was max to begin with
         else if(isMax) {
        	 count++;
        	 numMax--;
         }
         //in case only max dropped, then need to redo nummax and curmax
         if(numMax==0) {
        	 curMax=findMax(milk);
        	 for(int j = 0; j < milk.size(); j++) {
        		 if(milk.get(j)==curMax)
        			 numMax++;
        	 }
         }
      }
      out.println(count);
      out.close();
   }
   private static long findMax(ArrayList<Long> milk) {
	   long max = milk.get(0);
	   for(int i = 0; i < milk.size(); i++) {
		   if(milk.get(i)>max)
			   max=milk.get(i);
	   }
	   return max;
   }
}
