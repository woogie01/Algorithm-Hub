import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static class ListNode {

        /** 인덱스를 "해당 역의 고유번호"로 설정 */
        public int[] preNodes;
        public int[] postNodes;

        ListNode() {
            preNodes = new int[1000001];
            postNodes = new int[1000001];
        }

        // 해당 노드 뒤에 추가
        public void add(int curr, int newNode) {
            if (curr == -1) {
                preNodes[newNode] = postNodes[newNode] = newNode;
                return;
            }
            preNodes[newNode] = curr;
            postNodes[newNode] = postNodes[curr];
            preNodes[postNodes[curr]] = newNode;
            postNodes[curr] = newNode;
        }

        // 해당 노드 삭제
        public void delete(int targetNode) {
            postNodes[preNodes[targetNode]] = postNodes[targetNode];
            preNodes[postNodes[targetNode]] = preNodes[targetNode];
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ListNode listNode = new ListNode();
        st = new StringTokenizer(br.readLine());
        int curr = -1;
        for(int i = 0; i < N; i ++) {
            int node = Integer.parseInt(st.nextToken());
            listNode.add(curr, node);
            curr = node;
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            curr = Integer.parseInt(st.nextToken());
            int newNode = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

            switch (op) {
                case "BN":
                    result.append(listNode.postNodes[curr]).append("\n");
                    listNode.add(curr, newNode);
                    break;
                case "BP":
                    result.append(listNode.preNodes[curr]).append("\n");
                    listNode.add(listNode.preNodes[curr], newNode);
                    break;
                case "CN":
                    result.append(listNode.postNodes[curr]).append("\n");
                    listNode.delete(listNode.postNodes[curr]);
                    break;
                case "CP":
                    result.append(listNode.preNodes[curr]).append("\n");
                    listNode.delete(listNode.preNodes[curr]);
                    break;
            }
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}