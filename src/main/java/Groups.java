import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ellioe03 on 07/04/2017.
 */
public class Groups{

    private static ArrayList<String> CLOSED_GROUPS= new ArrayList<String>(Arrays.asList("()","{}","[]"));


    public static boolean groupCheck(String s){
        if (doAllSymbolsPair(s)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean doAllSymbolsPair(String s) {

        String[] symbols = s.split("");

        ArrayList<String> openBrackets= new ArrayList<>();
        ArrayList<String> closeBrackets= new ArrayList<>();
        ArrayList<String> lastOpenItem = new ArrayList<>();

        for(int i=0;i<CLOSED_GROUPS.size();i++) {
            String[] pair = CLOSED_GROUPS.get(i).split("");
            openBrackets.add(pair[0]);
            closeBrackets.add(pair[1]);
        }

        for(String item : symbols) {
            boolean close = closeBrackets.contains(item);
            if(close) {
                if(isLastOpenItemNotMatchingPair(item,lastOpenItem)) {
                    return false;
                }
                lastOpenItem.remove(lastOpenItem.size()-1);
            }
            if(!close) {
                lastOpenItem.add(item);
            }
        }

        if(lastOpenItem.size()>0) {
            return false;
        }

        return true;

    }

    private static boolean isLastOpenItemNotMatchingPair(String item, ArrayList<String> lastOpenIten) {
        return !CLOSED_GROUPS.contains(lastOpenIten.get(lastOpenIten.size()-1)+item);
    }


}