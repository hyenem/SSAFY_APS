package Stack구현_제네릭;

import java.util.ArrayList;
import java.util.List;

class Stack<T>{
    List<T> stack = new ArrayList<T>();
    int top =-1;
    
    void push(T i){
        stack.add(i);
        top++;
	}
    
    T pop(){
        T result = stack.get(top);
        stack.remove(top--);
   		return result;
    }
    
    T peek(){
        return stack.get(top);
    }
    
    boolean isEmpty(){
        return top==-1;
    }
}