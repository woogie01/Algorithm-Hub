import java.util.*;

class Solution {
     public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();
        for (String[] ticket : tickets) {
            fromToMap.putIfAbsent(ticket[0], new PriorityQueue<>());
            fromToMap.get(ticket[0]).add(ticket[1]);
        }

        List<String> answer = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push("ICN");
        while (!stack.isEmpty()) {
            while (fromToMap.containsKey(stack.getFirst()) && !fromToMap.get(stack.getFirst()).isEmpty()) {
                stack.push(fromToMap.get(stack.getFirst()).poll());
            }
            answer.add(0, stack.pop());
        }

        return answer.toArray(new String[0]);
    }
}