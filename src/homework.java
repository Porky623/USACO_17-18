import java.util.*;
import java.io.*;
import java.math.BigDecimal;
public class homework {
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
		BigDecimal[] sums = new BigDecimal[N];
		sums[N-1]=new BigDecimal(score[N-1]);
		for(int i = N-2; i >= 0; i--) {
			sums[i]=sums[i+1].add(new BigDecimal(score[i]));
		}
		int[] mins = new int[N];
		mins[N-1]=score[N-1];
		for(int i = N-2; i >=0; i--) {
			if(mins[i+1]>score[i])
				mins[i]=score[i];
			else
				mins[i]=mins[i+1];
		}
		BigDecimal[] maxScore = findScore(1,score,sums,mins);
		ArrayList<Integer> maxes = new ArrayList<Integer>();
		maxes.add(1);
		for(int i = 2; i < N-1; i++) {
			BigDecimal[] x = findScore(i,score,sums,mins);
			if(x[0].compareTo(maxScore[0])==0&&x[1].compareTo(maxScore[1])==0) {
				maxes.add(i);
			}
			else if(x[0].compareTo(maxScore[0])>0||(x[0].compareTo(maxScore[0])==0&&x[1].compareTo(maxScore[1])>0)) {
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
	private static BigDecimal[] findScore(int num,int[] score,BigDecimal[] sums,int[] mins) {
		BigDecimal sum = sums[num];
		sum=sum.subtract(new BigDecimal(mins[num]));
		return sum.divideAndRemainder(new BigDecimal(score.length-num));
	}
}