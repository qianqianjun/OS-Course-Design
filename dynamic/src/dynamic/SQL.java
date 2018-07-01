package dynamic;

public class SQL {
	private static int N = 0;
	public static int nousedCount;
	public static int usedCount;
	public static String[] used;
	public static int[] used_l,used_r;
	public static int[] noused_l,noused_r;//[,)
	public static int flag = 0;//使用哪种算法
	
	
	public static void init(int MAX){
		N = MAX;
		used = new String[N+1];used_l = new int[N+1];used_r = new int[N+1];
		noused_l = new int[N+1];noused_r = new int[N+1];
		usedCount = 1;
		used[0] = "OS";used_l[0] = 0;used_r[0] = 1000;
		nousedCount = 1;
		noused_l[0] = 1000;noused_r[0]=N;
	}
	private static int askId(int num){
		if(flag == 0){
			int ans = -1;
			for(int i = 0;i < nousedCount; i++){
				if(noused_r[i] - noused_l[i] >= num){
					ans = i;
					break;
				}
			}
			return ans;
		}else{
			int ans = -1,min = N;
			for(int i = 0;i < nousedCount; i++){
				if(noused_r[i] - noused_l[i] >= num){
					if(noused_r[i] - noused_l[i] - num < min){
						ans = i;
						min = noused_r[i] - noused_l[i] - num;
					}
				}
			}
			return ans;
		}
	}
	private static int insertAdd(int L){//插在谁后面
		int ans = 0;
		for(int i = usedCount - 1; i >= 0; i--){
			if(used_r[i] <= L){
				ans = i;
				break;
			}
		}
		return ans;
	}
	public static boolean add(String name,int num){
		int id = askId(num);
		if(id == -1) return false;
		int L = noused_l[id];
		int R = L + num;
		if(noused_r[id] - noused_l[id] != num){
			noused_l[id] = noused_l[id] + num;
		}else{
			for(int i = id; i < nousedCount; i++){
				noused_l[i] = noused_l[i+1];
				noused_r[i] = noused_r[i+1];
			}
			nousedCount--;
		}
		id = insertAdd(L);
		for(int i = usedCount ;i > id+1; i--){
			used[i] = used[i-1];
			used_l[i] = used_l[i-1];
			used_r[i] = used_r[i-1];
		}
		used[id+1] = name;
		used_l[id+1] = L;used_r[id+1] = R;
		usedCount ++;
		return true;
	}

	
	
	private static int askDeletId(String x){
		int ans = -1;
		for(int i = 1;i < usedCount; i++){
			if(used[i].equals(x)){
				ans = i;
				break;
			}
		}
		return ans;
	}
	private static int insertIdDelet(int L){
		int ans = -1;
		for(int i = nousedCount - 1;i >= 0; i--){
			if(noused_r[i] <= L){
				ans = i;
				break;
			}
		}
		return ans;
	}
	private static void union(){
		int[] tmp;
		tmp = new int[N+1];
		for(int i = 0; i <= N; i++) tmp[i] = i;
		for(int i = 1; i < N; i++){
			if(noused_l[i] == noused_r[i-1] && noused_l[i] != 0){
				tmp[i] = tmp[i-1];
			}
		}
		int id = 0;
		int R = noused_r[id],L = noused_l[id];
		for(int i = 1; i <= min(N,nousedCount);i ++){
			if(tmp[i] == tmp[i-1]){
				R = noused_r[i];
				nousedCount --;
			}else{
				noused_l[id] = L;
				noused_r[id] = R;
				id++;
				R = noused_r[i];
				L = noused_l[i];
			}
		}
		System.out.println(nousedCount);
	}
	private static int min(int a, int b) {
		// TODO Auto-generated method stub
		if(a >= b)return a;
		return b;
	}
	public static boolean delet(String x){
		
		int id = askDeletId(x);
		System.out.println(id+" " +x);
		if(id == -1) return false;
		int L = used_l[id],R = used_r[id];
		for(int i = id; i< usedCount; i++){
			used_l[i] = used_l[i+1];
			used_r[i] = used_r[i+1];
			used[i] = used[i+1];
		}
		usedCount --;
		id = insertIdDelet(L);
		for(int i = nousedCount ; i > id+1; i--){
			noused_l[i] = noused_l[i-1];
			noused_r[i] = noused_r[i-1];
		}
		noused_l[id+1] = L;noused_r[id+1] = R;
		nousedCount ++;
		union();
		return true;
	}

	public static void changeflag(int num){
		flag = num;
		init(N);
	}

	public static void display(){
		for(int i = 0;i < usedCount; i++){
			System.out.println("name: "+used[i]+"  L: "+used_l[i]+"  R: "+used_r[i]);
		}
		System.out.println("-------------------------");
		for(int i = 0;i < nousedCount; i++){
			System.out.println("L: "+noused_l[i]+"  R: "+noused_r[i]);
		}
	}
}
