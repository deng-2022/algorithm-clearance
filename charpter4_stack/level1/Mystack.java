package com.yugutou.charpter4_stack.level1;

import java.util.Arrays;

class Mystack<T> {
    //实现栈的数组
    private Object[] stack;
    //栈顶元素
    private int top;

    Mystack() {
        //初始容量为10
        stack = new Object[10];
    }

    //判断是否为空
    public boolean isEmpty() {
        return top == 0;
    }

    //返回栈顶元素
    public T peek() {
        T t = null;
        if (top > 0)
            t = (T) stack[top - 1];
        return t;
    }

    public void push(T t) {
        expandCapacity(top + 1);
        stack[top] = t;
        top++;
    }

    //出栈
    public T pop() {
        T t = peek();
        if (top > 0) {
            stack[top - 1] = null;
            top--;
        }
        return t;
    }

    //扩大容量
    public void expandCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size = size * 3 / 2 + 1;//每次扩大50%
            stack = Arrays.copyOf(stack, size);
        }
    }

    public static void main(String[] args) {
        Mystack<String> stack = new Mystack<>();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.push("java");
        stack.push("is");
        stack.push("beautiful");
        stack.push("language");
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }
}

/**
 * 基于数组实现
 *
 * @param <T>
 */
class Mystack2<T> {
    // 内部数组
    private Object[] stack;
    // 栈顶
    private int top;

    // 初始化
    public Mystack2(int size) {
        stack = new Object[size];
    }

    // 入栈
    public void push(T t) {
        if (t == null) {
            throw new NullPointerException("参数不能为空");
        }
        // todo 检查数组是否已满，扩容
        this.expandCapacity(top + 1);
        this.stack[top] = t;
        top++;
    }

    // 弹出栈顶元素
    public T peek() {
        T t = null;
        if (!this.empty())
            t = (T) this.stack[top - 1];
        return t;
    }

    // 出栈
    public T pop() {
        T t = this.peek();

        this.stack[top - 1] = null;
        top--;

        return t;
    }

    // 判空
    public boolean empty() {
        return this.top <= 0;
    }

    // 校验数组大小，判断是否需要扩容
    public void expandCapacity(int size) {
        int capacity = this.stack.length;
        if (size > capacity) {
            // 扩容1.5倍
            capacity = capacity * 3 / 2 + 1;
            this.stack = Arrays.copyOf(stack, capacity);
        }
    }

    public static void main(String[] args) {
        Mystack2<String> stack = new Mystack2<>(10);
        System.out.println(stack.peek());
        System.out.println(stack.empty());
        stack.push("java");
        stack.push("is");
        stack.push("beautiful");
        stack.push("language");
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack.peek());
    }
}