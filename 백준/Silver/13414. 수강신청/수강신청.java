import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < L; i++) {
            String s = br.readLine();
            map.put(s, i); // 같은 키가 있으면 최신 값으로 덮어씀
        }

        String[] queue = new String[L];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue[entry.getValue()] = entry.getKey();
        }

        int count = 0;
        for (int i = 0; i < L && count < K; i++) {
            if (queue[i] != null) {
                bw.write(queue[i]);
                bw.newLine();
                count++;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}