package paging;

import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class SQL {
	public static int N = 0;
	public static Map<String,Vector<Integer> > mp = new HashMap<String,Vector<Integer> >(); 
	public static int[][] arr ;
	public static int Count = 0;
	public static String find_name = "";
	public static void init(int MAX) {
		N = MAX;
		arr = new int[N][N];
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < N; j++)
				arr[i][j] = 0;
		Count = N * N;
	}
	
	private static Vector<Integer> get(int size){
		Vector<Integer> tmp = new Vector<Integer>();
		int num = 0;
		for(int i = 0; i < N;i++) {
			for(int j = 0;j<N;j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					tmp.add(i*N + j);
					num ++;
					Count--;
				}
				if(num == size) break;
			}
			if(num == size)break;
		}
		return tmp;
	}
	public static boolean add(String name,int size) {
		if(size > Count) return false;
		Vector<Integer> tmp = get(size);
		mp.put(name,tmp);
		find_name = name;
		return true;
	}

	public static boolean delet(String name) {
		Vector<Integer> tmp = mp.get(name);
		if(tmp.size() == 0) return false;
		for(int i = 0; i< tmp.size() ;i++) {
			arr[tmp.get(i)/N][tmp.get(i)%N] = 0;
			Count ++;
		}
		mp.remove(name);
		return true;
	}
	public static void display() {
		for(String t: mp.keySet()) {
			System.out.println(t+" : " + mp.get(t).size());
		}
	}
	public static boolean find(String name) {
		if(mp.get(name) == null) return false;
		find_name = name;
		return true;
	}
}
