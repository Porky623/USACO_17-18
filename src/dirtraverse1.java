import java.util.*;
import java.io.*;
public class dirtraverse1 {
	private static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("dirtraverse.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dirtraverse.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		N=Integer.parseInt(st.nextToken());
		int[] parent = new int[N+1];
		Node[] nodes = new Node[N+1];
		long[] len = new long[N+1];
		HashSet<Node> fil = new HashSet<Node>();
		for(int i = 1; i <= N; i++) {
			st=new StringTokenizer(f.readLine());
			String k = st.nextToken();
			int x = Integer.parseInt(st.nextToken());
			Node n;
			if(nodes[i]==null)
				n = new Node(i,k,new ArrayList<Edge>());
			else {
				n=nodes[i];
				n.name=k;
			}
			if(x==0) {
				len[i]=Long.MAX_VALUE;
				fil.add(n);
			}
			else {
				while(st.hasMoreTokens()) {
					x=Integer.parseInt(st.nextToken());
					parent[x]=i;
					if(nodes[x]==null) {
						Node n2 = new Node(x,"",new ArrayList<Edge>());
						n2.edges.add(new Edge(true,n));
						nodes[x]=n2;
					}
					else {
						nodes[x].edges.add(new Edge(true,n));
					}
					n.edges.add(new Edge(false,nodes[x]));
				}
			}
			nodes[i]=n;
		}
		for(Node fi : fil) {
			HashSet<Node> visited = new HashSet<Node>();
			run(fi, visited,len,0,fil);
		}
		long min = Long.MAX_VALUE;
		for(int i = 1; i <=N; i++) {
			if(len[i]<min)
				min=len[i];
		}
		out.println(min-fil.size());
		f.close();
		out.close();
	}
	private static void run(Node f, HashSet<Node> v, long[] len, long cur,HashSet<Node> fil) {
		v.add(f);
		for(Edge e : f.edges) {
			if(!v.contains(e.end)&&!fil.contains(e.end)) {
				int val;
				if(!e.up)
					val=3;
				else
					val=f.name.length()+1;
				len[e.end.id]+=cur+val;
				run(e.end,v,len,cur+val,fil);
			}
		}
	}
}
/*class Edge{
	boolean up;
	Node end;
	public Edge(boolean w, Node _end) {
		up=w;
		end=_end;
	}
}
class Node{
	String name;
	int id;
	ArrayList<Edge> edges;
	public Node(int i, String n, ArrayList<Edge> e) {
		id=i;
		name=n;
		edges=e;
	}
}*/