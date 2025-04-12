import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        Deque<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String line = br.readLine();
            String[] command = line.split(" ");

            switch (command[0]) {
                case "push":
                    queue.add(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    result.append(queue.peek() != null ? queue.pop() : -1).append('\n');
                    break;
                case "size":
                    result.append(queue.size()).append('\n');
                    break;
                case "empty":
                    result.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    result.append(queue.peek() != null ? queue.peek() : -1).append('\n');
                    break;
                case "back":
                    result.append(queue.peekLast() != null ? queue.peekLast() : -1).append('\n');
                    break;
            }
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}