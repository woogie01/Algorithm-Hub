import java.util.HashSet;
import java.util.Set;

class Solution {
      public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Set<Character> freq = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            freq.add(jewel);
        }
        for (char stone : stones.toCharArray()) {
            if (freq.contains(stone)) count++;
        }
        return count;
    }
}