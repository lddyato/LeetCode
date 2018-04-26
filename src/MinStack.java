import java.util.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
//    private List<Integer> list;
//
//    public MinStack() {
//        list=new ArrayList<>();
//
//    }
//
//    public void push(int x) {
//        list.add(x);
//    }
//
//    public void pop() {
//        list.remove(list.size()-1);
//    }
//
//    public int top() {
//        return list.get(list.size()-1);
//    }
//
//    public int getMin() {
//        if(list.size()>0){
//            int min=list.get(0);
//            for(int i=0;i<list.size();i++){
//                if(min>list.get(i)){
//                    min=list.get(i);
//                }
//            }
//            return min;
//        }
//        return 0;
//    }

    long min;
    Stack<Long> stack;

    //store the gap between the min value and the current value;很奇怪的思路

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);//Could be negative if min value needs to change
            if (x < min) min = x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop = stack.pop();

        if (pop < 0) min = min - pop;//If negative, increase the min value

    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int) (top + min);
        } else {
            return (int) (min);
        }
    }

    public int getMin() {
        return (int) min;
    }

}


