package jiandan;

import java.util.LinkedList;
import java.util.Stack;

public class YouXiaoKuoHaoXuLie {
    public boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<Character>();

        for(int i=0;i<s.length();i++){
            Character character = s.charAt(i);
            switch(character){
                case '(':
                case '[':
                case '{':
                    stack.push(character);
                    break;
                case ')':
                    if(stack.isEmpty()){
                        return false;
                    }
                    Character c = stack.pop();
                    if(c != '('){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty()){
                        return false;
                    }
                    Character c2 = stack.pop();
                    if(c2 != '['){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty()){
                        return false;
                    }
                    Character c3 = stack.pop();
                    if(c3 != '{'){
                        return false;
                    }
                    break;
            }
        }

        if(!stack.isEmpty()){
            return false;
        }

        return true;
    }
}
