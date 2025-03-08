import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] nums = new int[10];
        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            if (num == 9) {
                num = 6; 
            } 
            nums[num]++;
        }
        nums[6] = nums[6] / 2 + nums[6] % 2;
        Arrays.sort(nums);
        System.out.println(nums[9]);
    }
}