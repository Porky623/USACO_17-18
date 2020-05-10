import java.io.*;
import java.util.*;
public class talent {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("talent.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("talent.out")));
		int N,W;
		StringTokenizer st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		PriorityQueue<Cow> q = new PriorityQueue<Cow>();
		for(int i = 0; i < N; i++) {
			st=new StringTokenizer(f.readLine());
			int x = Integer.parseInt(st.nextToken());
			if(x<=1000)
			q.offer(new Cow(x,Integer.parseInt(st.nextToken())));
		}
		f.close();
		int w = 0;
		int t = 0;
		while(w<W) {
			Cow c = q.poll();
			w+=c.w;
			t+=c.t;
		}
		out.println((int)((double)t/(double)w*1000));
		out.close();
	}
}
class Cow implements Comparable<Cow>{
	int w,t;
	double rat;
	public Cow(int weight, int talent) {
		w=weight;
		t=talent;
		rat = (double)t/(double)w;
	}
	public int compareTo(Cow oth) {
		if(rat>oth.rat)
			return -1;
		if(rat==oth.rat)
			return w-oth.w;
		return 1;
	}
}