import java.util.*;

public class Main {
    //-123456789
    //Fu yi Yi er Qian san Bai si Shi wu Wan liu Qian qi Bai ba Shi jiu
    public static String contrast(int digit) {
        switch (digit) {
            case 2:
                return "Shi";
            case 3:
                return "Bai";
            case 4:
                return "Qian";
            case 5:
                return "Wan";
            case 6:
                return "Shi";
            case 7:
                return "Bai";
            case 8:
                return "Qian";
            case 9:
                return "Yi";
            default:
                return "";
        }
    }


    public static String contrastNum(char digit) {
        switch (digit) {
            case '0':
                return "ling";
            case '1':
                return "yi";
            case '2':
                return "er";
            case '3':
                return "san";
            case '4':
                return "si";
            case '5':
                return "wu";
            case '6':
                return "liu";
            case '7':
                return "qi";
            case '8':
                return "ba";
            case '9':
                return "jiu";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nums = sc.next();

        int digit = nums.length();

        if (nums.charAt(0) == '-') {
            System.out.print("Fu ");
            digit -= 1;
            nums = nums.substring(1);
        }
        int d = digit;
        if (nums.length() == 1) {
            System.out.println(contrastNum(nums.charAt(0)));
            System.exit(0);
        }
        List<String> myout = new ArrayList<>();
        //从后面数如果是零，则前进一位
        int indexLength = nums.length();
        int tempToLoop = nums.length() - 1;
        while (nums.charAt(tempToLoop) == '0') {
            indexLength -= 1;
            tempToLoop--;
        }
        for (int i = 0; i < indexLength; i++) {//digit = 9
            char temp = nums.charAt(i);
            myout.add(contrastNum(nums.charAt(i)));
            if (temp != '0' || digit == 5 || digit == 9) {
                myout.add(contrast(digit));
            }
            digit--;
        }
        for (int i = 0; i < myout.size(); i++) {
            int resi = 0;
            while (myout.get(i).equals("ling")) {
                i++;
                resi++;
            }
            if(resi >= 1 &&  d >= 5 && d <= 8){
                System.out.print("ling ");
            }
            if(resi != 0 && myout.get(i - 2).equals("Wan")){
                System.out.print("ling ");
            }
            System.out.print(myout.get(i) + " ");
            d--;
        }

    }
}
//yi Shi ba Bai