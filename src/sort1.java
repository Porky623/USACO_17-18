import java.util.*;
import java.io.*;
public class sort1 {
	private static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("sort.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
		N = Integer.parseInt(f.readLine());
		int count = 0;
		int last = Integer.parseInt(f.readLine());
		for(int i = 1; i < N; i++) {
			int x = Integer.parseInt(f.readLine());
			if(x<=last)
				count++;
			last=x;
		}
		f.close();
		out.println((int)(((double)count+1)/2));
		out.close();
	}
}
