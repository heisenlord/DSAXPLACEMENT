class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        if (top >= arr.length - 1) {
            System.out.println("Stack Overflow");
        } else {
            top++;
            arr[top] = x;
        }
    }

    public int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return -1; // Return a sentinel value to indicate an empty stack
        } else {
            return arr[top--];
        }
    }

    public int peek() {
        if (top < 0) {
            System.out.println("Stack is Empty");
            return -1;
        } else {
            return arr[top];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
