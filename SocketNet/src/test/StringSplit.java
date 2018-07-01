package test;

public class StringSplit {
    public static void main(String[] args) {
        String sourceStr = "1,2,3,4,5";
        String[] sourceStrArray = sourceStr.split(",");
        for (int i = 0; i < sourceStrArray.length; i++) {
            System.out.println(sourceStrArray[i]);
        }
    }
}