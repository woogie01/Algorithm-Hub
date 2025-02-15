class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for (String log : logs) {
            if(Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitList.add(log);
            } else {
                letterList.add(log);
            }

            letterList.sort((o1, o2) -> {
                String[] o1Arr = o1.split(" ", 2);
                String[] o2Arr = o2.split(" ", 2);

                int compared = o1Arr[1].compareTo(o2Arr[1]);
                if (compared == 0) { // 0(동일), 1(앞 순서), -1(뒤 순서)
                    return o1Arr[0].compareTo(o2Arr[0]);
                } else {
                    return compared;
                }
            });
        }
        letterList.addAll(digitList);
        return letterList.toArray(new String[0]);
    }
}