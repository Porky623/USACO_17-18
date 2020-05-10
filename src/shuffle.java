import java.io.*;
import java.util.*;
public class shuffle {
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
		boolean[] visited = new boolean[N];
		boolean[] cycled = new boolean[N];
		int[] pos = new int[N];
		for(int i = 0; i < N; i++) {
			visited[i]=false;
			cycled[i]=false;
			pos[i]=i+1;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i])
				checkCycle(i,cycled,visited,moves,pos);
		}
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(cycled[i])
				count++;
		}
		out.println(count);
		out.close();
	}
	private static void checkCycle(int i, boolean[] cycled, boolean[] visited,int[] moves, int[] pos) {
		int curPos = pos[i];
		HashMap<Integer,Integer> hit = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> tih = new HashMap<Integer,Integer>();
		int k = 0;
		while(!hit.containsValue(curPos)) {
			if(visited[curPos-1])
				return;
			hit.put(k,curPos);
			tih.put(curPos,k);
			visited[curPos-1]=true;
			curPos=moves[pos[curPos-1]-1];
			k++;
		}
		k=tih.get(curPos);
		for(int j = k; j<hit.size(); j++) {
			cycled[hit.get(j)-1]=true;
		}
	}
}