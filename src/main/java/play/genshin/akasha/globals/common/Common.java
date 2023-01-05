package play.genshin.akasha.globals.common;

public class Common {

    public static double useOption(String optionYn, double optionStatus){
        double result;
        if(optionYn.equals("Y")){
            result = optionStatus;
        }else if(optionYn.equals("M")){
            result = optionStatus * 0.73;
        }else {
            result = 0;
        }

        return result;
    }


}
