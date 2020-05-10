import java.util.*;
import java.io.*;
public class spainting {
	private static int N,M,K;
	private static final int MOD = 1000000007;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("spainting.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("spainting.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		N=Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		long x = M;
		for(int i = 0; i < N-1; i++) {
			x*=M;
			x%=MOD;
		}
		if(K==2) {
			x+=MOD-M;
			x%=MOD;
			out.println(x);
			out.close();
			System.exit(0);
		}
		long a = 1;
		long b = 1;
		long k = M;
		for(int i = 2; i < K; i++) {
			k*=M;
			k%=MOD;
		}
		k=(k+MOD-M)%MOD;
		long ta,tb;
		for(int i = K; i <= N; i++) {
			ta=(M-1)*b;
			tb=(M-1)*b+a;
			a=ta%MOD;
			b=tb%MOD;
		}
		long sum = a*M;
		sum%=MOD;
		long time = 0;
		long num = 0;
		sum+=b*k;
		sum%=MOD;
		/*while(time<k&&num<MOD) {
			num+=b;
			time++;
		}
		if(time==k) {
			sum+=num;
			sum%=MOD;
			out.print((x-sum+MOD)%MOD);
			out.close();
			System.exit(0);
		}
		k%=time;
		sum+=k*b;
		sum%=MOD;*/
		out.print((x-sum+MOD)%MOD);
		out.close();
		/*ArrayList<Long> been = new ArrayList<Long>();
		HashSet<Long> seen = new HashSet<Long>();
		for(long i = 0; i < k; i++) {
			sum+=b;
			sum%=MOD;
			if(seen.contains(sum)) {
				sum=been.get((int)(k%i));
				break;
			}
			seen.add(sum);
			been.add(sum);
		}
		out.println((x-sum+MOD)%MOD);
		out.close();*/
	}
}
