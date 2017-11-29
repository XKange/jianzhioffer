/**
 * Created by kangkang on 2017/11/28
 * 1.将数字转为二进制字符串函数Integer.toBinaryString(n)
 * 2.读取字符串第i个字符函数StringObject.charAt(i)
 */
public class problem_11 {
    public int NumberOf1(int n) {
        String numberBinaryString = new String(Integer.toBinaryString(n));
        int count = 0;
        for (int i = 0; i < numberBinaryString.length(); ++i) {
            System.out.println(numberBinaryString.charAt(i));
            if (numberBinaryString.charAt(i) == '1')
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(7));
        String digitBinaryString = new String(Integer.toBinaryString(7));
        int count = 0;
        for (int i = 0; i < digitBinaryString.length(); ++i) {
            System.out.println(digitBinaryString.charAt(i));
            if (digitBinaryString.charAt(i) == '1')
                count++;
        }
        System.out.println(count);
    }
}
