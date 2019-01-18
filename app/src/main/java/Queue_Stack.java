import java.util.Stack;

public class Queue_Stack extends Stack<Integer>{
    public static Queue_Stack stack;
    public static Queue_Stack temp;

    public static void main(String[] args) {

        stack = new Queue_Stack();
        temp = new Queue_Stack();
        stack.enQueue(0);
        stack.enQueue(1);
        stack.enQueue(2);
        stack.enQueue(3);
        stack.enQueue(4);
        stack.enQueue(5);

        stack.printStack();



    }

    public static void enQueue(int data) {
        Integer IntData = (Integer) data;
        //Check for empty
        if (stack.empty()) {
            //if empty push data on to stack
            stack.push(data);
            return;
        }//if stack is not empty
        while (!stack.empty()) {
            //pop all data into them
            temp.push(stack.pop());
        }
        //push the new data
        stack.push(data);
        //push back what was stored in temp
        while (!temp.empty()) {
            stack.push(temp.pop());
        }
        return;
    }

    public Integer deQueue() {
        return stack.pop();
    }

    public void printStack() {
        if (!stack.empty()) {
            while (!stack.empty()) {
                System.out.println(stack.pop().toString());
            }
        }else {
            System.out.println("Stack is empty.");
        }
    }
}
