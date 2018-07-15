package String;

import java.util.Stack;

public class _20_ValidParentheses {
	/*
	 * Method 1. switch and stack
	 */
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
