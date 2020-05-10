import java.util.*;
import java.io.*;
public class sort2 {
	private static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("sort.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
		N = Integer.parseInt(f.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(f.readLine());
			arr[i]=x;
		}
		int count = calc(arr,0,N-1,true);
		out.println((count+1)/2);
		f.close();
		out.close();
	}
	private static int calc(int[] a, int start, int stop,boolean state) {
		if(start>=stop) {
			return 0;
		}
		if(state) {
			int max = start;
			for(int i = start+1; i <= stop; i++) {
				if(a[max]<a[i])
					max=i;
			}
			return Math.max(calc(a,start,max-1,true), 1+calc(a,max+1,stop,false));
		}
		else {
			int min = start;
			for(int i = start+1; i <= stop; i++) {
				if(a[min]>a[i])
					min=i;
			}
			return Math.max(1+calc(a,start,min-1,true), calc(a,min+1,stop,false));
		}
	}
}