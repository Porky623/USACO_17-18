import java.util.*;
import java.io.*;
public class snowboots1 {
	private static int N,B,max=0;
	private static int[] tiles;
	private static int[] min;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("snowboots.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		N=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(f.readLine());
		tiles=new int[N];
		min=new int[N];
		for(int i = 0; i < N; i++) {
			min[i]=-1;
			tiles[N-1-i]=Integer.parseInt(st.nextToken());
			if(tiles[N-1-i]>max)
				max=tiles[N-1-i];
		}
		for(int i = 0; i < B; i++) {
			st=new StringTokenizer(f.readLine());
			if(solve(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())))
				out.println(1);
			else
				out.println(0);
		}
		out.close();
		f.close();
	}
	private static boolean solve(int depth, int length) {
		if(depth>=max||min[length]<depth&&min[length]>=0)
			return true;
		int cur = 0;
		while(cur+length<N) {
			boolean cont = false;
			for(int i = cur+length; i>cur; i--) {
				if(tiles[i]<=depth) {
					cur=i;
					cont=true;
					break;
				}
			}
			if(!cont)
				return false;
		}
		/*for(int i = 1; i <N; i++) {
			if(tiles[i]>depth&&i-cur>=length)
				return false;
			if(tiles[i]<=depth)
				cur=i;
		}*/
		if(min[length]>depth||min[length]<0)
			min[length]=depth;
		return true;
	}
}
