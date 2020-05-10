import java.io.*;
import java.util.*;
public class shuffle1 {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		StringTokenizer stn = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(stn.nextToken());
		int[] moves = new int[N];
		StringTokenizer st1 =new StringTokenizer(f.readLine());
		for(int i = 0; i < N; i++) {
			moves[i]=Integer.parseInt(st1.nextToken());
		}
		boolean[] contain = new boolean[N];
		for(int i = 0; i < N; i++) {
			contain[i]=true;
		}
		HashSet<int[]> seen = new HashSet<int[]>();
		int[] pos = new int[N];
		for(int i = 0; i < N; i++) {
			pos[i]=i+1;
		}
		while(!seen.contains(pos)) {
			seen.add(pos);
			boolean[] temp = new boolean[N];
			for(int i = 0; i < N; i++) {
				temp[i]=false;
			}
			for(int i = 0; i < N; i++) {
				pos[i]=moves[pos[i]-1];
				temp[pos[i]-1]=true;
			}
			for(int i = 0; i < N; i++) {
				if(!temp[i]) {
					contain[i]=false;
				}
			}
		}
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(contain[i]) {
				count++;
			}
		}
		out.println(count);
		out.close();
	}
}
