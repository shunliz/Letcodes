package newcode.jiandan;

import java.util.Stack;

public class myStack {

    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();
    int min = -1;

    public void push(int node) {
        s1.push(node);
        if(s2.isEmpty() || s2.peek() > node){
            s2.push(node);
        }else{
            s2.push(s2.peek());
        }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
}
