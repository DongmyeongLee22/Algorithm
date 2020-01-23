package test;



import java.util.List;
import java.util.Stack;

class Parent {

public Stack<Parent> pushAll(List<Parent> parentList){
    Stack<Parent> stack = new Stack<>();
    parentList.forEach(stack::push);
    return stack;
}
}

class Child extends Parent{ }


