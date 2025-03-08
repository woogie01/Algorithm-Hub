import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentNum = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());

        int[][] student = new int[2][7];
        int room = 0;

        for (int i = 1; i <= studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            student[gender][grade]++;
        }

        for (int i = 0; i < 2; i++) {
            for(int j = 1; j < 7; j++) {
                if (student[i][j] > 0) {
                    if (student[i][j] % capacity == 0) {
                        room += (student[i][j] / capacity);
                    } else {
                        room += (student[i][j] / capacity) + 1;
                    }
                }
            }
        }
        System.out.print(room);
    }
}