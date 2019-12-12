package Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class RNPexp {
    private static String exp;
    private static ArrayList<String> RNPexpList = new ArrayList<>();//後綴表達式
    private static Stack<String> operatorStack = new Stack<>();//操作符堆疊
    public static ArrayList<String> turnToRNPexp(String expresion){
        RNPexpList.clear();
        System.out.println(expresion);
        exp = expresion+"!";
        if(exp.charAt(0)=='-')
            exp = "0"+exp;
        exp = exp.replaceAll("\\(-","(0-");
        while(!exp.equals("")){
            cutNumber();
            cutOperator();
        }
        return RNPexpList;
    }
    private static void cutNumber(){//如果是數字就直接輸出到後綴表達式中，並把願表達式的相對應部分截掉
        char[] expChar = exp.toCharArray();
        int index = 0;
        for(char c:expChar){
            if(c>='0'&&c<='9')
                index++;
            else break;
        }
        if(index>0)
            RNPexpList.add(exp.substring(0,index));
        exp = exp.substring(index);
    }

    private static void cutOperator(){
        char operator = exp.charAt(0);
        exp = exp.substring(1);
        switch (operator){
            case '!':
                Pop_all_ToRNP();
                return;
            case ')':
                RightBraket();
                return;
            case '+':
                lowOperator();
                break;
            case '-':
                lowOperator();
                break;
            case '*':
                highOperator();
                break;
            case '/':
                highOperator();
                break;
        }
        operatorStack.push(String.valueOf(operator));
    }
    private static void Pop_all_ToRNP(){
        while(!operatorStack.empty())
            RNPexpList.add(operatorStack.pop());
    }
    private static void RightBraket(){
        while(!operatorStack.empty()
                &&!operatorStack.peek().equals("("))
            RNPexpList.add(operatorStack.pop());
        operatorStack.pop();
    }
    private static void lowOperator(){
        while(!operatorStack.empty()&&
                ( operatorStack.peek().equals("+")
                ||operatorStack.peek().equals("-")
                ||operatorStack.peek().equals("*")
                ||operatorStack.peek().equals("/")
                )
            )
            RNPexpList.add(operatorStack.pop());
    }
    private static void highOperator(){
        while(!operatorStack.empty()&&
                ( operatorStack.peek().equals("*")
                ||operatorStack.peek().equals("/")
                )
            )
            RNPexpList.add(operatorStack.pop());
    }
}
