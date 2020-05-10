//import java.util.*;
//import java.io.*;
//public class reststops {
//	public static void main(String[] args) throws IOException{
//		BufferedReader f = new BufferedReader(new FileReader("reststops.in"));
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
//		StringTokenizer st = new StringTokenizer(f.readLine());
//		int L, N, F, B;
//		L=Integer.parseInt(st.nextToken());
//		N=Integer.parseInt(st.nextToken());
//		F=Integer.parseInt(st.nextToken());
//		B=Integer.parseInt(st.nextToken());
//		int curTile = 0;
//		int curTast = 0;
//		ArrayList<int[]> stops = new ArrayList<int[]>();
//		for(int i = 0; i < N; i++) {
//			st=new StringTokenizer(f.readLine());
//			int x=Integer.parseInt(st.nextToken());
//			int y=Integer.parseInt(st.nextToken());
//			if(stops.size()==0||stops.get(stops.size()-1)[1]<=y
//		}
//		Arrays.sort(stops, new Comparator<int[]>(){ 
//			public int compare(int[]a,int[]b){
//	                	if(a[1]==b[1])
//	                		return a[0]-b[0];
//	                    return b[1]-a[1];
//	                }
//	        });
//		for(int i = 0; i < N; i++) {
//			if(curTile>stops[i][0])
//				continue;
//			int t1 = stops[i][0]-curTile;
//			curTast+=t1*(F-B)*stops[i][1];
//			curTile=stops[i][0];
//		}
//		out.println(curTast);
//		f.close();
//		out.close();
//	}
//}
