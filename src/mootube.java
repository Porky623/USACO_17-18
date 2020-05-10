import java.util.*;
import java.io.*;
public class mootube {
	private static int N,Q;
	private static final int INF = 1000000001;
	private static PrintWriter out;
	private static HashSet<Integer> visited = new HashSet<Integer>();
	private static ArrayList<HashSet<Integer>> v=new ArrayList<HashSet<Integer>>();
	private static ArrayList<HashMap<Integer,Integer>> rel = new ArrayList<HashMap<Integer,Integer>>();
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("mootube.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		N=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		/*for(int i = 0; i < N; i++) {
			rel.add(new HashMap<Integer,Integer>());
			v.add(new HashSet<Integer>());
		}*/
		int[][] graph=new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				graph[i][j]=Integer.MAX_VALUE;
			}
		}
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(f.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			graph[x-1][y-1]=z;
			graph[y-1][x-1]=z;
			//rel.get(x-1).put(y-1,z);
			//rel.get(y-1).put(x-1, z);
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i!=j)
				for(int k = 0; k < N; k++) {
					graph[i][j]=Math.min(graph[i][j], Math.min(graph[i][k], graph[j][k]));
				}
			}
		}
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(f.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int count = 0;
			for(int j = 0; j < N; j++) {
				if(j!=y-1&&graph[y-1][j]>=x)
					count++;
			}
			out.println(count);
		}
		out.close();
		/*for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(f.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(!visited.contains(y)) {
				v.get(y-1).add(y-1);
				Set<Integer> keys = rel.get(y-1).keySet();
				int cur = Integer.MAX_VALUE;
				for(int j : keys) {
					if(!v.get(y-1).contains(j)) {
						v.get(y-1).add(j);
						cur=Math.min(dfs(j,y-1,y-1),cur);
					}
				}
				visited.add(y);
			}
			int count = 0;
 			for(int j = 0; j < N; j++) {
				if(j!=y-1&&rel.get(y-1).get(j)>=x)
					count++;
			}
			out.println(count);
		}
		out.close();
	}
	private static int dfs(int k,int start,int prev) {
		Set<Integer> keys = rel.get(k).keySet();
		int cur = rel.get(prev).get(k);
		for(int x : keys) {
			if(!v.get(start).contains(x)) {
				int y = dfs(x,start,k);
				v.get(start).add(x);
				v.get(x).add(start);
				rel.get(x).put(start, Math.min(y, rel.get(start).get(k)));
				rel.get(start).put(x, Math.min(y, rel.get(start).get(k)));
				cur=Math.min(y, cur);
			}
		}
		return cur;*/
	}
}