import java.util.HashMap;
import java.util.Map;

class Solution {
      public String solution(String[] participants, String[] completion) {
        Map<String, Integer> freq = new HashMap<>();
        for (String participant : participants) {
            freq.put(participant, freq.getOrDefault(participant, 0) + 1);
        }
        for (String participant : completion) {
            int left = freq.get(participant);
            if (left == 1) {
                freq.remove(participant);
            } else {
                freq.put(participant, left - 1);
            }
        }
        return freq.entrySet().iterator().next().getKey();
    }
}