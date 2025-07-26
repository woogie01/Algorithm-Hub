public class MyHashMap {

    static class Node {
        int key, val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    final Node[] nodes = new Node[1000000];

    public void put(int key, int value) {
        int index = key % nodes.length;

        /* 기존 노드가 존재하지 않아서 그냥 그대로 추가하는 경우 */
        if (nodes[index] == null) {
            nodes[index] = new Node(key, value);
            return;
        }

        /* 기존 노드가 존재해서 연결리스트로 추가해야 하는 경우 */
        Node node = nodes[index];
        while (node != null) {
            if (node.key == key) {
                node.val = value;
                return;
            }
            if (node.next == null) {
                node.next = new Node(key, value);
                return;
            }
            node = node.next;
        }
    }

    public int get(int key) {
        int index = key % nodes.length;

        /* 기존 노드가 존재하지 않아서 -1 반환 */
        if (nodes[index] == null) return -1;

        /* 기존 노드가 존재하는 경우, 순회하면서 일치하는 키를 가진 노드 값 반환 */
        Node node = nodes[index];
        while (node != null) {
            if (node.key == key) return node.val;
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % nodes.length;

        /* 기존 노드가 존재하지 않아서 종료 */
        if (nodes[index] == null) return;

        /* 기존 노드가 존재하는 경우 일치하는 키를 가지는 노드 제거(1) : 첫번째 노드인 경우 */
        Node node = nodes[index];
        if (node.key == key) {
            if (node.next == null) {
                nodes[index] = null;
            } else {
                nodes[index] = node.next;
            }
        }

        /* 기존 노드가 존재하는 경우 일치하는 키를 가지는 노드 제거(2) : 연결리스트 노드인 경우 */
        Node prev = node;
        while (node != null) {
            if (node.key == key) {
                prev.next = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */