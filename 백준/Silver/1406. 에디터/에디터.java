import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());

        // 연결리스트 초기화
        LinkedList<Character> list = new LinkedList<>();
        for (char ch : input.toCharArray()) {
            list.add(ch);
        }

        // Iterator 선언 후 커서는 꼬리쪽에 위치
        ListIterator<Character> iter = list.listIterator(list.size());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            if (operation.equals("L") && iter.hasPrevious()) {
                iter.previous();
            } else if (operation.equals("D") && iter.hasNext()) {
                iter.next();
            } else if (operation.equals("B") && iter.hasPrevious()) {
                iter.previous();
                iter.remove();
            } else if (operation.equals("P")) {
                iter.add(st.nextToken().charAt(0));
            }
        }

        // 출력
        for (Character character : list) {
            bw.write(character);
        }

        br.close();
        bw.flush();
    }
}
