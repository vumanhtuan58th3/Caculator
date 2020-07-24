package IdeaProjects.UnitTestExample.src.main.java.com.petehouston.maven.unittestexample;

import java.util.Scanner;
import java.util.Stack;
//Sai nhập ký tự và nhập operator đằng trước., kiểm tra đủ ngoặc, 1( <- sửa lỗi này, () > stack rỗng
public class InfixToPostfix {
    private String[] iS;
    private Stack S;
    static boolean success = true;
    public InfixToPostfix() {

    }
    public String[] process(String sMath){
        String outputString = "";
        String element[] = null;
        InfixToPostfix IFP = new InfixToPostfix();
        sMath = sMath.trim();
        sMath = sMath.replaceAll("\\s+"," ");
        for (int i=0; i<sMath.length(); i++){
            char c = sMath.charAt(i);//sMath.substring(i,1);
            if (!IFP.isOperator(c))
                outputString = outputString + c;
            else outputString = outputString + " " + c + " ";
        }
        outputString = outputString.trim();
        outputString = outputString.replaceAll("\\s+"," "); //  chuan hoa s1
        element = outputString.split(" "); //tach s1 thanh cac phan tu
        //System.out.println(s1);
        return element;
    }
    public String[] InfixToPostfix(String[] iString) {
        String E[];
        iS = iString;
        S = new Stack();
        String outputString = "";
        boolean fi = false;
        for (int i = 0; i < iString.length; i++) {
            char curChar = iString[i].charAt(0);
//            System.out.println("Ký tự đầu vào: " + curChar);
            if (!isOperator(curChar)) {
                outputString += " " + iS[i];
                if (i == iString.length - 1) {
                    while (!S.empty()) {
                        outputString += " " + S.pop();
                    }
                }
            }
            else {
                if (fi) {
                    if (pMin(curChar) || mDiv(curChar)){
                        if (S.isEmpty()){
                            S.push(curChar);
                        }
                        else if(pMin(curChar) && pMin((Character) S.peek())){
                            outputString += " " + S.pop();
                            S.push(curChar);
                            if (i == iString.length - 1) {
                                while (!S.empty()) {
                                    outputString +=  " " + S.pop();
                                }
                            }
                        }
                        else if ((pMin(curChar) && mDiv((Character) S.peek()))) {
                            outputString += " " + S.pop() ;
                            S.push(curChar);
                            if (i == iString.length - 1) {
                                while (!S.empty() && (mDiv(curChar) && (mDiv((Character) S.peek()))||(pMin(curChar) && pMin((Character) S.peek())))) {
                                    outputString +=  " " + S.pop();
                                }
                            }
                        }
                        else if ((mDiv(curChar) && mDiv((Character) S.peek()))) {
                            outputString += " " + S.pop();
                            S.push(curChar);
                            if (i == iString.length - 1) {
                                while (!S.empty()) {
                                    outputString +=  " " + S.pop();
                                }
                            }
                        }
                        else if ((pMin(curChar) && mDiv((Character) S.peek()))) {
                            outputString += " " + S.pop() ;
                            S.push(curChar);
                            if(pMin(curChar) && pMin((Character) S.peek())){
                                outputString += " " + S.pop();
                                if (i == iString.length - 1) {
                                    while (!S.empty()) {
                                        outputString +=  " " + S.pop();
                                    }
                                }
                            }
                            if (i == iString.length - 1) {
                                while (!S.empty() && (mDiv(curChar) && (mDiv((Character) S.peek()))||(pMin(curChar) && pMin((Character) S.peek())))) {
                                    outputString +=  " " + S.pop();
                                }
                            }
                        }
                        else if((mDiv(curChar) && pMin((Character) S.peek()))){
                            S.push(curChar);
                            if (i == iString.length - 1) {
                                while (!S.empty()) {
                                    outputString += " " + S.pop();
                                }
                            }
                        }
                        else {
                            S.push(curChar);
                            if (i == iString.length - 1) {
                                while (!S.empty()) {
                                    outputString += " " + S.pop();
                                }
                            }
                        }

                    }
//                    else if ((pMin(curChar) && pMin((Character) S.peek()))||(mDiv(curChar) && mDiv((Character) S.peek()))) {
//                        outputString += " " + S.pop();
//                        S.push(curChar);
//                        if (i == iString.length - 1) {
//                            while (!S.empty()) {
//                                outputString +=  " " + S.pop();
//                            }
//                        }
//                    }
//                      else if ((pMin(curChar) && mDiv((Character) S.peek()))) {
//                        outputString += " " + S.pop() ;
//                        S.push(curChar);
//                        if(pMin(curChar) && pMin((Character) S.peek())){
//                            outputString += " " + S.pop();
//                            if (i == iString.length - 1) {
//                                while (!S.empty()) {
//                                    outputString +=  " " + S.pop();
//                                }
//                            }
//                        }
//                         if (i == iString.length - 1) {
//                            while (!S.empty() && (mDiv(curChar) && (mDiv((Character) S.peek()))||(pMin(curChar) && pMin((Character) S.peek())))) {
//                                outputString +=  " " + S.pop();
//                            }
//                        }
//                    }
//                    else if ((mDiv(curChar) && mDiv((Character) S.peek()))){
//                        outputString += " " + S.pop() ;
//                        S.push(curChar);
//                          if (i == iString.length - 1) {
//                              while (!S.empty() && (mDiv(curChar) && (mDiv((Character) S.peek()))||(pMin(curChar) && pMin((Character) S.peek())))) {
//                                  outputString +=  " " + S.pop();
//                              }
//                          }
//                    }
//                    else if (pMin(curChar) && pMin((Character) S.peek())) {
//                        outputString += " " + S.pop();
//                        S.push(curChar);
//                        if (i == iString.length - 1) {
//                            while (!S.empty()) {
//                                outputString +=  " " + S.pop();
//                            }
//                        }
//                    }
//                    else if (pMin(curChar) && pMin((Character) S.peek())) {
//                        outputString += " " + S.pop();
//                        S.push(curChar);
//                        if (i == iString.length - 1) {
//                            while (!S.empty()) {
//                                outputString +=  " " + S.pop();
//                            }
//                        }
//                    }
//                    else if(pMin(curChar)){
//                        S.push(curChar);
//                        if (i == iString.length - 1) {
//                            while (!S.empty()) {
//                                outputString +=  " " + S.pop();
//                            }
//                        }
//                    }

//                    else if (mDiv(curChar) && mDiv((Character) S.peek())) {
//                        outputString += " " + S.pop();
//                        S.push(curChar);
//                        if (i == iString.length - 1) {
//                            while (!S.empty()) {
//                                outputString += " " + S.pop();
//                            }
//                        }
//                    }
//                    else if (mDiv(curChar) && pMin((Character) S.peek())) {
//                        S.push(curChar);
//                        if (i == iString.length - 1) {
//                            while (!S.empty()) {
//                                outputString +=  " " + S.pop();
//                            }
//                        }
//                    }
                    else if(isOperator(curChar)) {
                        if (curChar == '(' ) {//&& (pMin((Character) S.peek()) || mDiv((Character) S.peek()))
//                            System.out.println("tesst" + curChar);
                            S.push(curChar);

                        } else {
                            if (curChar == ')') {
//                                outputString +=  " " + S.pop() + " ";

                                char curChar1;
                                do {
                                    curChar1 = (Character) S.peek();
                                    if (curChar1 != '(') {
                                        outputString += " " + S.pop();
                                    }
//                                    S.pop();
                                }
                                while (curChar1 != '(');
                                S.pop();

                            } else {
                                while (!S.empty() && (mDiv((Character) S.peek()) || pMin((Character)S.peek()))) {
                                    outputString +=  S.pop() + " ";
                                }
//                                S.push(curChar);
                            }
                        }
//                        outputString += (Character)S.peek();
                    }
                    else {
                        outputString += Character.toString(curChar);//123*4*4*+5+
                        if (i == iString.length - 1) {
                            while (!S.empty()) {
                                outputString += S.pop() + " ";
                            }
                        }
                    }
                } else {
                    S.push(curChar);
                    fi = true;
                }
            }
//            System.out.println("Stack :" + S );
//            System.out.println("Đầu ra là : " + outputString);
        }
        while (!S.empty()){
            outputString += " " + S.pop() + " ";
        }
//        while (outputString.isEmpty()){
//            System.out.println("Chuỗi đầu ra không được rỗng");
////            Nhap();
//        }
        System.out.println("Stack :" + S );
        E = outputString.split(" ");
        System.out.println(E);
        return E;
//        System.out.println(outputString);
//        System.out.println("Stack :" + S );
//        System.out.println("Đầu ra là : " + outputString);

//        return new String[]{outputString};
    }
    public boolean isOperator(char op){
        switch (op){
            case '+':
                return true;
            case '-':
                return true;
            case '*':
                return true;
            case '/':
                return true;
            case '^':
                return true;
            case '(':
                return true;
            case ')':
                return true;
            default:
                return false;
        }
    }
    public boolean pMin(char op){
        switch (op){
            case '+':
                return true;
            case '-':
                return true;
            default:
                return false;
        }
    }
    public boolean mDiv(char op){
        switch (op){
            case '*':
                return true;
            case '/':
                return true;
            default:
                return false;
        }
    }
    public static Double Add( double num1, double num2){
        return num2+num1;
    }
    public static Double Devide(double num1, double num2) throws IdeaProjects.UnitTestExample.src.main.java.com.petehouston.maven.unittestexample.MyException {
        try {
            return num2/num1;
        }
        catch (Exception e){
            throw new IdeaProjects.UnitTestExample.src.main.java.com.petehouston.maven.unittestexample.MyException("Lỗi chia cho 0");
        }
    }
    public static Double Multiply( double num1, double num2){
        return num2*num1;
    }
    public static Double Substract( double num1, double num2){
        return num2-num1;
    }
    public String Caculator(String[] iString) {
//        int num = 0;
        iS=iString;
        Stack<String> S = new Stack<>();
        InfixToPostfix ITP = new InfixToPostfix();
//        int num = 0;
//        int num = 0;
        for (int i = 1; i < iS.length; i++) {
            System.out.println(iString[i]);
            char curChar = iString[i].charAt(0);
//            System.out.println("curchar" + curChar);
            if (!ITP.isOperator(curChar)) {
                S.push(iString[i]);
            } else {
                Double num =0.0;
                Double num1 = Double.parseDouble(S.pop());
                Double num2 = Double.parseDouble(S.pop());

//                String num1 = (String) S.pop();
//                int num3 = Integer.parseInt(num1);
////                System.out.println("chuyển đổi :" + Integer.parseInt(num1));
//                String num2 = (String) S.pop();
////                System.out.println("Chuyển đổi 2 : ");
//                int num4 = Integer.parseInt(num2);
//                double num1 = Float.parseFloat((String) S.pop());
//                double num2 = Float.parseFloat((String) S.pop());
                switch (curChar) {
                    case '+':
                        num = Add(num1, num2);
                        break;
                    case '-':
                        num = Substract(num1, num2);
                        break;
                    case '*':
                        num = Multiply(num1, num2);
                        break;
                    case '/':
                        try {
                            num = Devide(num1, num2);
//                           return String.valueOf(num);
                        }
                        catch (IdeaProjects.UnitTestExample.src.main.java.com.petehouston.maven.unittestexample.MyException e){
                            System.out.println(e.getError());
                        }
                        break;
                    default:
                        break;
                }
                S.push(Double.toString(num));

            }
        }
        return S.pop();
    }
    public static String Nhap() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        System.out.println("Nhập chuỗi cần tính toán:");
        input = scanner.nextLine();
        return input;
    }
    public static boolean Kiemtra(String input){
        Stack<String> S = new Stack<>();
        InfixToPostfix ITP = new InfixToPostfix();
        String outputString = "";
//        String digit = "\\d";
//        boolean flag = input.matches(digit);
        if(!input.isEmpty()) {
            int dem=0;
            int dem1=0;
            for(int i = 0; i < input.length(); i++) {
                char curChar = input.charAt(i);
                if (input.charAt(0) == '+' || input.charAt(0) == '-' || input.charAt(0) == '*' || input.charAt(0) == '/') {
                    System.out.println("Không được nhập operator đầu dòng :");
//                    Nhap();
                    return false;
                }
                else if ((input.charAt(i) == '+' && input.charAt(i + 1) == '+') || (input.charAt(i) == '-' && input.charAt(i + 1) == '-')) {
                    System.out.println("Chuỗi không hợp lệ(+-). Nhập lại chuỗi:");
//                    Nhap();
                    return false;
                } else if ((input.charAt(i) == '*' && input.charAt(i + 1) == '*') || (input.charAt(i) == '/' && input.charAt(i+1) == '/')) {
                    System.out.println("Chuỗi không hợp lệ về Operator(*/). Nhập lại chuỗi:");
//                    Nhap();
                    return false;
                } else if ((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') ||(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')) {
                    System.out.println("Không được nhập chữ");
//                    Nhap();
                    return false;
                } else if (input.charAt(input.length() - 1) == '+' || input.charAt(input.length() - 1) == '-' || input.charAt(input.length() - 1) == '*' || input.charAt(input.length() - 1) == '/' || input.charAt(input.length() - 1) == '(') {
                    System.out.println("Chuỗi không hợp lệ 3");
//                    Nhap();
                    return false;
                }
                else if (input.charAt(0) == ')' || input.charAt(input.length()-1) == '(' || ((input.charAt(0) == ')' && input.charAt(input.length()-1) == '('))){
                    System.out.println("Chuỗi không hợp lệ. Nhập lại");
//                    Nhap();
                    return false;
                }
                else if (!ITP.isOperator(curChar) && !(curChar >= '0' && curChar <= '9')){
                    System.out.println("Ký tự không hợp lệ");
//                    Nhap();
                    return false;
                }
                else if (((input.charAt(i) == '(') && (input.charAt(i+1)=='+' || input.charAt(i+1) == '-' || input.charAt(i+1)=='*' || input.charAt(i+1)=='/' || input.charAt(i+1)== ')') )){
                    System.out.println("Biểu thức không có giá trị");
//                    Nhap();
                    return false;
                }
                else if (((input.charAt(i)=='+' || input.charAt(i) == '-' || input.charAt(i)=='*' || input.charAt(i)=='/' || input.charAt(i)== '(') && (input.charAt(i+1) == ')') )){
                    System.out.println("Biểu thức không có giá trị 1");
//                    Nhap();
                    return false;
                }
//                else if (input.charAt(i)==')' && input.charAt(i+1) == '('){
//                    System.out.println("Phải cần operator");
//                    return false;
//                }
                else if (input.charAt(i)==')'){
                    dem = dem +1;
                    System.out.println(dem);
                }
                else if (input.charAt(i)=='('){
                    dem1 = dem1 +1;
                    System.out.println(dem1);
                }
//                if (dem != dem1){
//                    System.out.println("Nhập thiếu đóng mở ngoặc");
//                    Nhap();
//                }
//                int dem1 = 0;
//                if (input.charAt(i)==')'){
//                    dem1 = dem1 +1;
//                }
//                System.out.println(dem1);
//                else if ((input.charAt(i) >= '0' && input.charAt(i) <= '9') && (input.charAt(i+1)=='(')){
//                    System.out.println("Bạn nhập thiếu toán tử");
//                    Nhap();
//                }

//            String pattern = "^[0-9]";
//            if (Pattern.matches(pattern, input)){
//                System.out.println("Chuỗi hợp lệ");
//                return true;
//            }
//            else {
//                System.out.println("Chuỗi không hợp lệ");
//                return false;
//            }
            }
            if (dem !=dem1){
                System.out.println("Nhập thiếu đóng mở ngoặc");
                return false;
            }
        }
        else {
            System.out.println("Chuỗi không hợp lệ :");
//            Nhap();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "";
        String element[]=null;
        InfixToPostfix IFP = new InfixToPostfix();
//        Scanner scanner =new Scanner(System.in);
//        input = scanner.nextLine();
//        input = IFP.Nhap();
//        IFP.Kiemtra(input);
//        element = IFP.process(input);
//        element = IFP.InfixToPostfix(element);
//        System.out.println(element.length);
//        String cacul  = IFP.Caculator(element);



//        do{
//           input = Nhap();
////            System.out.println("");
//        }
//        while (!Kiemtra(input));
//        element = IFP.process(input);
//        element = IFP.InfixToPostfix(element);
//        String cacul  = IFP.Caculator(element);
//        System.out.println("KQ:" + cacul);
        input = Nhap();

          while (Kiemtra(input)==false){
              input = Nhap();
          }
            element = IFP.process(input);
        System.out.println("ttt" + element);
            element = IFP.InfixToPostfix(element);

            String cacul  = IFP.Caculator(element);
            System.out.println("KQ:" + cacul);
//        IFP.Caculator(element);
        for (int i=0; i<element.length; i++) //  xuat dang postfix
            System.out.print(element[i] + " ");
//        String Cacu = ITP.Caculator(InfixPostfix);
//        System.out.println("KQ : " + Cacu);
    }
}