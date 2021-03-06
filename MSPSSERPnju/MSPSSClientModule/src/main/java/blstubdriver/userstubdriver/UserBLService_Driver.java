package blstubdriver.userstubdriver;

import org.junit.Test;
import status.Log_In_Out_Status;
import util.Kind_Of_Users;
import util.ResultMessage;
import vo.UserVO;

public class UserBLService_Driver {
    UserBLService_Stub userBLService_stub = new UserBLService_Stub();

    @Test
    public void drive() {

        //test addUser
        UserVO user = new UserVO("SS001", "Chen", Kind_Of_Users.StockSeller, "000000","hanxinhu521@163.com");
        UserVO user2 = new UserVO("CM001", "July", Kind_Of_Users.ChiefManager, "000000","hanxinhu521@163.com");

        ResultMessage isAdd = userBLService_stub.addUser(user);
        userBLService_stub.addUser(user2);
        if (isAdd == ResultMessage.SUCCESS) {
            System.out.println("Add user successfully.");
        } else {
            System.out.println("Fail to add user.");
        }


        //test updateUser
        user.setPassword("010101");
        ResultMessage isMod = userBLService_stub.updateUser(user);
        if (isMod == ResultMessage.SUCCESS) {
            System.out.println("Modify user successfully.");
        } else {
            System.out.println("Fail to modify");
        }

        //test deleteUser
        ResultMessage isDel = userBLService_stub.deleteUser("SS001");
        if (isDel == ResultMessage.SUCCESS) {
            System.out.println("Delete user successfully.");
        } else {
            System.out.println("Fail to delete user.");
        }

        //test login
        Log_In_Out_Status isLogin = userBLService_stub.login("CM001", "000000");
        if (isLogin == Log_In_Out_Status.Login_Success) {
            System.out.println("Login successfully.");
        } else if (isLogin == Log_In_Out_Status.Login_IdNotExist) {
            System.out.println("Id not exist.");
        } else if (isLogin == Log_In_Out_Status.Login_islogin) {
            System.out.println("You have logged in.");
        } else if (isLogin == Log_In_Out_Status.Login_PasswordWrong) {
            System.out.println("Password wrong.");
        }

        //test logout
        Log_In_Out_Status isLogout = userBLService_stub.logout("CM001");
        if (isLogout == Log_In_Out_Status.Logout_NotLogin) {
            System.out.println("You haven't login.");
        } else if (isLogout == Log_In_Out_Status.Logout_Sucess) {
            System.out.println("Logout Successfully.");
        } else if (isLogout == Log_In_Out_Status.Login_IdNotExist) {
            System.out.println("Id not exist.");
        }
    }
}
