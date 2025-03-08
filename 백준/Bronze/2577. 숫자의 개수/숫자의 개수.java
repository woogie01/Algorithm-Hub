import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[10];
		int mul = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
 
		String result = String.valueOf(mul);
		for (int i = 0; i < result.length(); i++) {
			nums[(result.charAt(i) - 48)]++;
		}
 
		for (int num : nums) {
			System.out.println(num);
		}
	}
}