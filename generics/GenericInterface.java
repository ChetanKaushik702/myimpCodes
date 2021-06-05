package generics;

interface MinMax<T extends Comparable<T>> {
    T min();    // computes minimum
    T max();    // computes maximum
}

class MyClass<T extends Comparable<T>> implements MinMax<T> {
    T[] nums;

    MyClass(T[] nums) {
        this.nums = nums;
    }

    public T min() {
        T val = nums[0];
        
        for (int i = 1; i < nums.length; i++) 
            if (nums[i].compareTo(val) < 0) val = nums[i];

        return val;
    }

    public T max() {
        T val = nums[0];
        
        for (int i = 1; i < nums.length; i++) 
            if (nums[i].compareTo(val) > 0) val = nums[i];

        return val;
    }

    public static void main(String[] args) {
        Integer nums[] = {1,2,3,4,5};
        MyClass<Integer> ints = new MyClass<>(nums);
        System.out.println("Minimum: " + ints.min());
        System.out.println("Maximum: " + ints.max());
    }
}