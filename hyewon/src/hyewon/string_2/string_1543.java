package hyewon.string_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class string_1543 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int result = 0;
	
		for(int i=0; i<a.length()-b.length()+1; i++){
			if(a.charAt(i)==b.charAt(0)){
				if(a.substring(i, i+b.length()).equals(b)){
					i=i+b.length()-1;
					result++;
				}
			}else{
				continue;
			}
		}
		
		System.out.println(result);

	}

}
