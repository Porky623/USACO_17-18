import java.util.*;
import java.io.*;
public class milkorder1 {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("milkorder.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] rel = new int[N][N];
		main:
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(f.readLine());
			int x = Integer.parseInt(st.nextToken());
			int[] in = new int[x];
			for(int j = 0; j < x; j++) {
				in[j]=Integer.parseInt(st.nextToken())-1;
			}
			for(int j = 1; j < x; j++) {
				for(int k = 0; k < j; k++) {
					if(in[j]<in[k]&&rel[in[j]][in[k]]<0||in[j]>in[k]&&rel[in[k]][in[j]]>0) {
						break main;
					}
				}
			}
			for(int j = 1; j < x; j++) {
				for(int k = 0; k < j; k++) {
					if(in[k]<in[j]) {
						rel[in[k]][in[j]]=-1;
						for(int a = in[j]; a < N; a++) {
							if(rel[in[j]][a]<0)
								rel[in[k]][a]=-1;
						}
						for(int a = in[k]; a < in[j]; a++) {
							rel[a][in[j]]=-1;
						}
						for(int a = in[j]+1; a < N; a++) {
							if(rel[in[k]][a]>0)
								rel[in[j]][a]=1;
						}
					}
					else if(in[k]>in[j]) {
						rel[in[j]][in[k]]=1;
						for(int a = in[j]; a < in[k]; a++) {
							if(rel[in[j]][a]<0)
								rel[a][in[k]]=1;
						}
						for(int a = in[k]+1; a < N; a++) {
							if(rel[in[j]][a]<0)
								rel[in[k]][a]=-1;
						}
						for(int a = in[k]; a < N; a++) {
							if(rel[in[k]][a]>0)
								rel[in[j]][a]=-1;
						}
					}
				}
			}
		}
		LinkedList<Integer> order = new LinkedList<Integer>();
		ListIterator<Integer> it;
		int x = 0;
		for(int i = 0; i < N; i++) {
			it = order.listIterator();
			while(it.hasNext()) {
				x=it.next()-1;
				if(rel[x][i]<=0) {
					it.previous();
					break;
				}
			}
			it.add(i+1);
		}
		for(int i = N-1; i >0; i--) {
			out.print(order.get(i)+" ");
		}
		out.println(order.get(0));
		out.close();
	}
}