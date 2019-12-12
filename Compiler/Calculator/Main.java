package Calculator;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> lines = Input.readTxtFileIntoStringArrList("/Users/wangbotao/Desktop/test.txt");
        for(String line : lines){
            ArrayList<String> RNP = RNPexp.turnToRNPexp(line);
            Output.CalculateAll(RNP);
            System.out.println();
        }
    }
}
