package Stack;

import java.util.Stack;

public class _20_ValidParentheses {

	/*
	 * Method 1. Using stack
	 */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '(') {
                stack.push(')');
            } else if(c == '[') {
                stack.push(']');
            } else if(c == '{') {
                stack.push('}');
            } else if(stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
    
    /*
     * Method 2. Just implement a simple stack using a char array and check that,
     * for each closing bracket, there is its counterpart in the top of the stack.
     */
    public boolean isValid1(String s) {
        char[] stack = new char[s.length()];
        int head = 0;
        for(char c: s.toCharArray()) {
            switch(c) {
                case '{':
                case '[':
                case '(':
                    stack[head++] = c;
                    break;
                case '}':
                    if(head == 0 || stack[--head] != '{') return false;
                    break;
                case ']':
                    if(head == 0 || stack[--head] != '[') return false;
                    break;
                case ')':
                    if(head == 0 || stack[--head] != '(') return false;
                    break;
            }
        }
        return head == 0;
    }
}
