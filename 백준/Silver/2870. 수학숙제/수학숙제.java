import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 1. int(32bit) : 10자리
        // 2. long(64bit) : 19자리
        int M = Integer.parseInt(br.readLine());
        List<BigInteger> answers = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            boolean isContinue = false; // 연속된 숫자 확인
            for (int j = 0; j < str.length(); j++) {

                // 문자 종류 검사
                char ch = str.charAt(j);
                if (Character.isDigit(ch)) {
                    sb.append(ch);
                    isContinue = true;
                } else if (Character.isLetter(ch)) {
                    isContinue = false;
                }

                // 숫자가 끝났는지 검사하고 리스트에 투입
                if (!isContinue && !sb.toString().isEmpty()) {
                    answers.add(new BigInteger(sb.toString()));
                    sb = new StringBuilder();
                }
            }

            // 마지막 자리 검사
            if (!sb.toString().isEmpty()) {
                answers.add(new BigInteger(sb.toString()));
                sb = new StringBuilder();
            }
        }

        // 정렬 및 출력
        Collections.sort(answers);
        for (BigInteger answer : answers) {
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}
