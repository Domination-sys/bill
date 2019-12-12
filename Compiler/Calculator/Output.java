package Calculator;

import java.util.ArrayList;
import java.util.Stack;

public class Output {
    private static Stack<Integer> resultStack = new Stack<>();
    public static void CalculateAll(ArrayList<String> RNPexpList){
        for(String element:RNPexpList){
            if (element.matches("[0-9]+"))
                resultStack.push(Integer.parseInt(element));
            else
                CalculateOneStep(element);
        }
    }
    private static void CalculateOneStep(String operator){
        char c = operator.charAt(0);
        int d1,d2;
        d2 = resultStack.pop();
        d1 = resultStack.pop();
        switch (c){
            case '+':
                resultStack.push(d1+d2);
                break;
            case '-':
                resultStack.push(d1-d2);
                break;
            case '*':
                resultStack.push(d1*d2);
                break;
            case '/':
                resultStack.push(d1/d2);
                break;
        }
            if(d1!=0||c!='-')
            System.out.println(String.valueOf(d1)+String.valueOf(c)+String.valueOf(d2)+"="+resultStack.peek());
    }

}
