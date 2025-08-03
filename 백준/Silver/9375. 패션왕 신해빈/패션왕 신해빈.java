import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            Map<String, Integer> items = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                String category = input[1];
                items.put(category, items.getOrDefault(category, 0) + 1);
            }

            int result = 1;
            for (int item : items.values()) {
                result *= (item + 1); // 해당 종류를 입지 않는 경우 포함
            }

            bw.write(String.valueOf(result - 1)); // 아무것도 입지 않는 경우 제외
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}