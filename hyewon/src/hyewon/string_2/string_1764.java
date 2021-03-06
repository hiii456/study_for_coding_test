package hyewon.string_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class string_1764 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		HashSet<String> notHear = new HashSet<>();
		ArrayList<String> notHearAndSee = new ArrayList<>();
		
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			notHear.add(st.nextToken());
		}
		
		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(notHear.contains(str)){
				cnt++;
				notHearAndSee.add(str);
			}
		}
		
		Collections.sort(notHearAndSee);
		
		System.out.println(cnt);
		
		Iterator iter = notHearAndSee.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}

	}

}
