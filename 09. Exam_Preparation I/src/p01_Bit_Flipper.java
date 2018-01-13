import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class p01_Bit_Flipper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputNumber = reader.readLine();
        BigInteger inputNumberBigInt = new BigInteger(inputNumber);

       // String binaryInputNum = inputNumberBigInt.toString(2);



        String binaryInputNum = String.format("%64s",inputNumberBigInt.toString(2))
                .replaceAll(" ", "0");

        System.out.println(binaryInputNum);
        System.out.println();

        int countEqualBits = 1;
        for (int i = 0; i < binaryInputNum.length()-1; i++) {
            if(binaryInputNum.charAt(i) == binaryInputNum.charAt(i+1)){
                countEqualBits++;
                if(countEqualBits == 3){
                    //System.out.println(Integer.toBinaryString(numbers[i]));
//                        System.out.println(Integer.toBinaryString((1 << position)));
                    for (int j = i -2; j <= i+1 ; j++) {
                        //inputNumberBigInt = inputNumberBigInt.xor(1 << j);
                        inputNumberBigInt = inputNumberBigInt.setBit(j);
                    }
                    countEqualBits = 1;
//                        System.out.println("------------------");
//                        System.out.println(Integer.toBinaryString(numbers[i]));
                }
            }else{
                countEqualBits = 1;
            }
        }

        System.out.println(inputNumberBigInt);
    }
}
