import java.util.*;
import java.io.*;
public class homework1 {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("homework.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
		StringTokenizer n = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(n.nextToken());
		StringTokenizer st = new StringTokenizer(f.readLine());
		int[] score = new int[N];
		for(int i = 0; i < N; i++) {
			score[i]=Integer.parseInt(st.nextToken());
		}
		double[] sums = new double[N];
		sums[N-1]=score[N-1];
		for(int i = N-2; i >= 0; i--) {
			sums[i]=sums[i+1]+score[i];
		}
		int[] mins = new int[N];
		mins[N-1]=score[N-1];
		for(int i = N-2; i >=0; i--) {
			if(mins[i+1]>=score[i])
				mins[i]=score[i];
			else
				mins[i]=mins[i+1];
		}
		double maxScore = findScore(1,score,sums,mins);
		ArrayList<Integer> maxes = new ArrayList<Integer>();
		maxes.add(1);
		for(int i = 2; i < N-1; i++) {
			double x = findScore(i,score,sums,mins);
			if(x==maxScore) {
				maxes.add(i);
			}
			else if(x>maxScore) {
				maxes.clear();
				maxes.add(i);
				maxScore=x;
			}
		}
		for(int i = 0; i < maxes.size(); i++) {
			out.println(maxes.get(i));
		}
		out.close();
	}
	private static double findScore(int num,int[] score,double[] sums,int[] mins) {
		double sum = sums[num];
		sum-=mins[num];
		return sum/(double)(score.length-num-1);
	}
}