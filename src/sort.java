import java.util.*;
import java.io.*;
public class sort {
	private static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("sort.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
		N = Integer.parseInt(f.readLine());
		TreeSet<Num> t = new TreeSet<Num>();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(f.readLine());
			arr[i]=x;
			t.add(new Num(x,i));
		}
		int low = 0;
		int high = N-1;
		int count = 0;
		while(!t.isEmpty()) {
			count++;
			while(!t.isEmpty()&&t.last().index==low) {
				t.remove(t.last());
				low++;
			}
			if(!t.isEmpty())
			t.remove(t.last());
			while(!t.isEmpty()&&t.first().index==high) {
				t.remove(t.first());
				high--;
			}
			if(!t.isEmpty())
			t.remove(t.first());
		}
		out.println(count);
		f.close();
		out.close();
	}
}
class Num implements Comparable<Num>{
	int val,index;
	public Num(int v, int i) {
		val=v;
		index=i;
	}
	public int compareTo(Num oth) {
		return val-oth.val;
	}
}