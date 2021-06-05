package general;

public class CompareStrings {
    
    static void compareStringBufferAndStringBuilder() {

        StringBuffer stringBuffer = new StringBuffer("Java ");
        long startTime = System.currentTimeMillis();

        for (int i = 0 ; i < 100000 ; i++) {
            stringBuffer.append("Hello ");
        }

        System.out.println("Time taken by StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms.");

        StringBuilder stringBuilder = new StringBuilder("Java ");
        startTime = System.currentTimeMillis();

        for (int i = 0 ; i < 100000 ; i++) {
            stringBuilder.append("Hello ");
        }

        System.out.println("Time taken by StringBuilder: " + (System.currentTimeMillis() - startTime) + "ms.");

        String string = "Java ";
        startTime = System.currentTimeMillis();

        for (int i = 0 ; i < 100000 ; i++) {
            string = string + "Hello ";
        }

        System.out.println("Time taken by String: " + (System.currentTimeMillis() - startTime) + "ms.");
    }

    public static void main(String[] args) {
        compareStringBufferAndStringBuilder();
    }
}
