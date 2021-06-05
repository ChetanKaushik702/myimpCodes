package generics;

class Average<T extends Number> {
    T[] array;

    Average(T[] array) {
        this.array = array;
    }

    double computeAvg() {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i].doubleValue();
        }
        return sum / array.length;
    }

    /**
     * Wildcard arguments allows to compare the averages of two different instance types,
     * i.e., Integer and Double, Float and Integer, etc.
     * @param nums
     * @return true if the averages for the two instances are same
     */
    boolean isAvgSame(Average<?> nums) {
        return (this.computeAvg() == nums.computeAvg()) ? true : false;
    }
}

public class ComputeAverage {
    public static void main(String[] args) {

        Average<Integer> ints = new Average<Integer>(new Integer[]{1, 2, 3, 4});
        Average<Double> doubles = new Average<Double>(new Double[]{1.0, 2.0, 3.0, 4.0});

        System.out.println(ints.computeAvg() + "\t" + doubles.computeAvg());
        System.out.println(ints.isAvgSame(doubles));
    }
}