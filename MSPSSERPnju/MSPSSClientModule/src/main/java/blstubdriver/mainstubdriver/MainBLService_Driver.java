package blstubdriver.mainstubdriver;

import blservice.mainblservice.MainBLService;
import util.ResultMessage;
/**
 * Created by thinkpad on 2017/10/24.
 */
public class MainBLService_Driver {
    ResultMessage result ;
    MainBLService main = new MainBLService_Stub();
    public void drive(){
        result = ResultMessage.SUCCESS;
        main.login("161250164", "161250164");
        if(result==ResultMessage.SUCCESS){
            System.out.println("Log in successfully");
        }
        else{
            System.out.println("Fail to Log in");
        }

        main.logout("");
        if(result==ResultMessage.SUCCESS){
            System.out.println("Log out successfully");
        }
        else{
            System.out.println("Fail to Log out");
        }
    }
}
