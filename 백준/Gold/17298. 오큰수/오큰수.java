import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 값을 저장하는 배열
        int[] valueArr = new int[N];
        for (int i = 0; i < N; i++) {
            valueArr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) { 
            while (!stack.isEmpty() && valueArr[stack.peek()] < valueArr[i]) {
                valueArr[stack.pop()] = valueArr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            valueArr[stack.pop()] = -1;
        }

        for(int val : valueArr) {
            bw.write(val + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}