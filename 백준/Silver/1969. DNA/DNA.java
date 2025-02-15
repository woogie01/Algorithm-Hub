import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // DNA 배열 생성 및 입력
        String[] dnaArray = new String[N];
        for (int i = 0; i < N; i++) {
            dnaArray[i] = br.readLine();
        }

        // 결과 계산
        String[] result = findMostCommonDNA(dnaArray, N, M);

        // 출력
        System.out.println(result[0]); // 가장 많이 나온 DNA 문자열
        System.out.println(result[1]); // 다른 문자의 개수 합
    }

    private static String[] findMostCommonDNA(String[] dnaArray, int N, int M) {
        StringBuilder mostCommonDNA = new StringBuilder(M);
        int totalDifference = 0;
        int[][] dnaCount = new int[M][4]; // [문자열 위치][A, T, G, C 개수]

        // 문자 개수 한 번에 카운팅
        for (String dna : dnaArray) {
            for (int i = 0; i < M; i++) {
                dnaCount[i][getDnaIndex(dna.charAt(i))]++;
            }
        }

        // 가장 많이 나온 DNA 문자 찾기
        for (int i = 0; i < M; i++) {
            int maxIdx = 0, maxCount = dnaCount[i][0];
            for (int j = 1; j < 4; j++) {
                if (dnaCount[i][j] > maxCount || (dnaCount[i][j] == maxCount && j < maxIdx)) {
                    maxCount = dnaCount[i][j];
                    maxIdx = j;
                }
            }
            mostCommonDNA.append("ACGT".charAt(maxIdx));
            totalDifference += (N - maxCount);
        }

        return new String[]{mostCommonDNA.toString(), String.valueOf(totalDifference)};
    }

    private static int getDnaIndex(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                return -1;
        }
    }
}
