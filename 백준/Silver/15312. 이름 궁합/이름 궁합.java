import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        // 주어진 힌트
        int[] alphabet = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String boyName = br.readLine();
        String girlName = br.readLine();

        int length = boyName.length() + girlName.length();
        int[] plus = new int[length];
        for (int i = 0, j = 0; i < boyName.length(); i++, j += 2) {
            plus[j] = alphabet[boyName.charAt(i) - 'A'];
            plus[j + 1] = alphabet[girlName.charAt(i) - 'A'];
        }

        // 숫자를 두 자리까지 계산
        while (length > 2) {
            for (int i = 0; i < length - 1; i++) {
                plus[i] = (plus[i] + plus[i + 1]) % 10;
            }
            length--;
        }

        // 최종 결과 출력
        System.out.println(plus[0] + "" + plus[1]);
    }
}
