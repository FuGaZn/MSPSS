package ui.stocksellerui;

import blimpl.blfactory.BLFactoryImpl;
import blservice.mainblservice.MainBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import status.Log_In_Out_Status;
import ui.adminui.LoginController;
import ui.common.Dialog;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/13
 */
public class CustomerModifyFirstViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
    Dialog dialog = new Dialog();
    @FXML
    Button CustomerAddButton;

    @FXML
    Button CustomerDelButton;

    @FXML
    Button NextOperationButton;
    @FXML
    Button CustomerSearchButton;
    @FXML
    Button cancelButtonl;
    @FXML
    Button BackToLogin;
    @FXML
    TextField id_to_modify_field;

    /**
     * 返回登录界面
     *
     * @param e
     * @throws IOException
     */
    public void handleBackToLoginButtonAction(ActionEvent e) throws IOException {
        try {
            MainBLService mainBLService = new BLFactoryImpl().getMainBLService();
            boolean b = dialog.confirmDialog("Do you want to logout?");
            if (b == true) {
                LoginController controller = (LoginController) replaceSceneContent("/view/admin/Login.fxml");
                Log_In_Out_Status log_in_out_status = mainBLService.logout(idOfCurrentUser.getText());
                if (Log_In_Out_Status.Logout_Sucess == log_in_out_status) {
                    dialog.infoDialog("Logout successfully");
                }
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 返回上一界面
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void cancelButtonAction(ActionEvent e) throws IOException {
        try {
            CustomerManageViewController controller = (CustomerManageViewController) replaceSceneContent(
                    "/view/stockseller/CustomerManage.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 增加客户
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void customerAddButtonAction(ActionEvent e) throws IOException {
        try {
            CustomerAddViewController controller = (CustomerAddViewController) replaceSceneContent(
                    "/view/stockseller/CustomerAdd.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 删除客户
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void customerDelButtonAction(ActionEvent e) throws IOException {
        try {
            CustomerDelViewController controller = (CustomerDelViewController) replaceSceneContent(
                    "/view/stockseller/CustomerDel.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 下一步
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void nextOperationButtonAction(ActionEvent e) throws IOException {
        try {
            if (id_to_modify_field.getText() != null && !id_to_modify_field.getText().trim().equals("")) {
                CustomerModifySecondViewController.id_to_modify = id_to_modify_field.getText().trim();
            }
            CustomerModifySecondViewController controller = (CustomerModifySecondViewController) replaceSceneContent(
                    "/view/stockseller/CustomerModifySecond.fxml");

        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 查找客户
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void customerSearchButtonAction(ActionEvent e) throws IOException {

        try {
            CustomerSearchViewController controller = (CustomerSearchViewController) replaceSceneContent(
                    "/view/stockseller/CustomerSearch.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }


    /**
     * 用来打开fxml文件
     *
     * @param fxml
     * @return
     * @throws Exception
     */
    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        // InputStream in =
        // Thread.currentThread().getContextClassLoader().getResourceAsStream(fxml);
        InputStream in = MainApp.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainApp.class.getResource(fxml));
        Pane page;
        try {
            page = (Pane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 900, 560);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        return (Initializable) loader.getController();
    }


    @FXML
    Label idOfCurrentUser, nameOfCurrentUser, categoryOfCurrentUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idOfCurrentUser.setText("编号：" + LoginController.getCurrentUser().getID());
        nameOfCurrentUser.setText("姓名：" + LoginController.getCurrentUser().getName());
        categoryOfCurrentUser.setText("身份：" + LoginController.getCategory());
    }

}
