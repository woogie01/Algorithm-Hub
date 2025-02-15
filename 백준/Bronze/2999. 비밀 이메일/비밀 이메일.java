import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = input.length();

        // R, C 값 도출하기
        int R = 0, C = 0;
        for (int i = 1; i <= N / i; i++) {
            if (N % i == 0) {
                R = i;
                C = N / i;
            }
        }

        // 순서 변환
        StringBuilder result = new StringBuilder(N);
        for (int r = 0; r < R; r++) {
            for (int c = r; c < N; c += R) {
                result.append(input.charAt(c));
            }
        }

        // 최종 결과 출력
        System.out.println(result);
    }
}
