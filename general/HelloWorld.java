package general;

import java.util.*;

class HelloWorld {
    
    static void nextGreaterElement(HashMap<Integer, Integer> map, int a[]) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.addLast(a[0]);
        for (int i = 1; i < a.length; i++) {
            while (!stack.isEmpty() && stack.getLast() > a[i]) {
                map.put(stack.removeLast(), a[i]);
            }
            stack.addLast(a[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.removeLast(), -1);
        }
    }
    public static void main(String[] args) {
        // int k = 5;
        int a[] = new int[]{1, 2, 2, 3, 5}; 
        HashMap<Integer, Integer> map = new HashMap<>();
        nextGreaterElement(map, a);
        
        for (int i = 0; i < a.length; i++) {
            System.out.print(map.get(a[i]) + " ");
        }
    }
}