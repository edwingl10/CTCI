package BitManipulation;

public class BinaryToString {
    /**
     * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double,
     * print the binary representation. If the number cannot be represented accurately in
     * binary with at most 32 characters, print"ERROR:'
     */
    String printBinary(double num){
        if(num >=1 || num <= 0)
            return "ERROR";

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while(num > 0){
            // setting a limit on length: 32 characters
            if(binary.length() >= 32)
                return "ERROR";
            double r = num *2;
            if(r >= 1){
                binary.append(1);
                num = r-1;
            }else{
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }

    public static void main(String[] args){
        BinaryToString b = new BinaryToString();
        String result = b.printBinary(0.101);
        System.out.println(result);
    }

}
