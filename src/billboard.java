import java.util.*;
import java.io.*;
public class billboard {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		HashMap<Integer,HashSet<Integer>> board = new HashMap<Integer,HashSet<Integer>>();
		for(int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			for(int k = a; k < c; k++) {
				HashSet<Integer> temp = new HashSet<Integer>();
				board.put(k, temp);
				for(int j = b; j < d; j++) {
					temp.add(j);
				}
			}
		}
		StringTokenizer st = new StringTokenizer(f.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		for(int k = a; k < c; k++) {
			if(board.containsKey(k)) {
				HashSet<Integer> temp = board.get(k);
				for(int j = b; j < d; j++) {
						if(temp.contains(j)) {
							temp.remove(j);
						}
				}
			}
		}
		int size = 0;
		for(HashSet<Integer> value : board.values()) {
			size+=value.size();
		}
		out.println(size);
		out.close();
	}
}