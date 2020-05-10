import java.util.*;
import java.io.*;
public class taming {
	private static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("taming.in"));
		PrintWriter out = new PrintWriter(new FileWriter("taming.out"));
		N=Integer.parseInt(f.readLine());
		int[] num = new int[N+1];
		StringTokenizer st = new StringTokenizer(f.readLine());
		for(int i = 1; i <= N; i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N+1][N+1];
		if(num[1]!=0)
		dp[1][1]=1;
		int num0 = 0;
		for(int i = 2; i <= N; i++) {
			if(num[i]==0)
				num0++;
			if(num[i]==i-1) {
				dp[i][1]=dp[i-1][1];
			}
			else
				dp[i][1]=dp[i-1][1]+1;
			dp[i][i]=i-num0;
			if(num[i]==0) {
				for(int j = 2; j < i; j++) {
					dp[i][j]=dp[i-1][j-1];
				}
			}
			else if(num[i]==num[i-1]+1){
				for(int j = 2; j < i; j++) {
					dp[i][j]=dp[i-1][j];
				}
			}
			else {
				for(int j = 2; j < i; j++) {
					dp[i][j]=dp[i-1][j]+1;
				}
				if(num[i]<i) {
					int[][] t1 = solve(Arrays.copyOfRange(num,i-num[i],i));
					int[][] t2 = solve(Arrays.copyOfRange(num, 1, i-num[i]-1));
					for(int j = 1; j < i; j++) {
						for(int k = 1; k<= j; k++) {
							dp[i][j]=Math.min(dp[i][j], t1[t1.length-1][k]+t2[t2.length-1][j-k]);
						}
					}
				}
			}
		}
		for(int i = 1; i <=N; i++) {
			out.println(dp[N][i]);
		}
		out.close();
		f.close();
	}
	private static int[][] solve(int[] num){
		int[][] dp = new int[num.length+1][num.length+1];
		if(num[0]!=0)
		dp[1][1]=1;
		int num0 = 0;
		for(int i = 2; i <= num.length-1; i++) {
			if(num[i-1]==0)
				num0++;
			if(num[i-1]==i-1) {
				dp[i][1]=dp[i-1][1];
			}
			else
				dp[i][1]=dp[i-1][1]+1;
			dp[i][i]=i-num0;
			if(num[i-1]==0) {
				for(int j = 2; j < i; j++) {
					dp[i][j]=dp[i-1][j-1];
				}
			}
			else if(num[i-1]==num[i-2]+1){
				for(int j = 2; j < i; j++) {
					dp[i][j]=dp[i-1][j];
				}
			}
			else {
				if(num[i-1]>i) {
					for(int j = 2; j < i; j++) {
						dp[i][j]=dp[i-1][j]+1;
					}
				}
			}
		}
		return dp;
	}
}
