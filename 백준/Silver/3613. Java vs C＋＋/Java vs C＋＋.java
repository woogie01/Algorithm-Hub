import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        int code = getCode(str); // 0: Error, 1: Cpp, 2: Java
        if (code == 0) {
            System.out.println("Error!");
        } else if (code == 1) {
            toJava(str);
        } else {
            toCpp(str);
        }
    }
    
    public static int getCode(String str) {
        // 에러 검사
        if (str.charAt(0) == '_' || str.charAt(str.length() - 1) == '_') {
            return 0;
        }
        if (Character.isUpperCase(str.charAt(0))) {
            return 0;
        }

        boolean isUnderscore = false;
        boolean isUpperCase = false;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '_') {
                if (str.charAt(i - 1) == '_') return 0;
                isUnderscore = true;
            }
            if (Character.isUpperCase(c)) isUpperCase = true;
        }
        if (isUnderscore && isUpperCase) return 0;
        else if (isUnderscore) return 1;
        return 2;
    }

    public static void toJava(String str) {
        StringBuilder result = new StringBuilder();
        boolean isNextUpper = false;
        for (char c : str.toCharArray()) {
            if (c == '_') {
                isNextUpper = true;
                continue;
            }
            if (isNextUpper) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(c);
            }
            isNextUpper = false;
        }
        System.out.println(result);
    }

    public static void toCpp(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append('_');
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        System.out.println(result);
    }
}