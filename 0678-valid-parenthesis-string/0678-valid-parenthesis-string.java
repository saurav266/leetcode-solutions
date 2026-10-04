class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left.push(i);
            }
            else if (s.charAt(i) == '*') {
                star.push(i);
            }
            else if (s.charAt(i) == ')') {
                if (!left.isEmpty()) {
                    left.pop();
                }
                else if (!star.isEmpty()) {
                    star.pop();
                }
                else {
                    return false;
                }
            }
        }

        while (!left.isEmpty() && !star.isEmpty() &&
               left.peek() < star.peek()) {
            left.pop();
            star.pop();
        }

        if (!left.isEmpty()) {
            return false;
        }

        return true;
    }
}