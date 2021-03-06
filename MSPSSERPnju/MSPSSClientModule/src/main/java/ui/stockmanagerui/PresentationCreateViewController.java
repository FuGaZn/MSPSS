package ui.stockmanagerui;

import auxiliary.Breakage;
import auxiliary.Presentation;
import blimpl.blfactory.BLFactoryImpl;
import blservice.billblservice.StockManagerBillBLService;
import blservice.commodityblservice.CommodityInfoService;
import blservice.mainblservice.MainBLService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import status.Log_In_Out_Status;
import ui.adminui.LoginController;
import ui.common.Dialog;
import vo.StockBillItemVO;
import vo.StockBillVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/11
 */
public class PresentationCreateViewController implements Initializable {
    static boolean isSaved;
    static StockBillVO savedStockBillVO;
    Stage stage = StageSingleton.getStage();
    Stage newStage = new Stage();
    Dialog dialog = new Dialog();
    StockManagerBillBLService stockManagerBillBLService = new BLFactoryImpl().getStockManagerBillBLService();
    CommodityInfoService commodityInfoService = new BLFactoryImpl().getCommodityInfoService();

    @FXML
    Button overflowCreateButton;
    @FXML
    Button breakageCreateButton;
    @FXML
    Button alertCreateButton;
    @FXML
    Button BackToLogin;
    @FXML
    Button backButton, sureButton, saveButton;
    @FXML
    TableView<Presentation> presentationTable;
    @FXML
    TableColumn<Presentation, String> NameCol, IdCol, PriceCol, NumberCol, TotalCol, RemarkCol;
    @FXML
    TableColumn<Presentation, CheckBox> IsSelectCol;
    @FXML
    TextField nameField;// 商品名称
    @FXML
    Button chooseCommodityButton;// 选择商品的按钮
    @FXML
    Button addPresentationButton;// 添加一行的按钮
    @FXML
    Button delPresentationButton;// 删除一行的按钮
    @FXML
    TextField idField;// 商品编号
    @FXML
    Label priceLabel;// 单价
    @FXML
    TextField numberField;// 数量
    @FXML
    Label totalLabel;// 总价
    @FXML
    TextField remarkField;// 备注

    public void showTableView() {
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        NumberCol.setCellValueFactory(new PropertyValueFactory<>("Number"));
        TotalCol.setCellValueFactory(new PropertyValueFactory<>("Total"));
        RemarkCol.setCellValueFactory(new PropertyValueFactory<>("Remark"));
        IsSelectCol.setCellValueFactory(new PropertyValueFactory<>("IsSelected"));
        //TODO
    }


    /**
     * 返回上一界面（处理单据界面）
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void backButtonAction(ActionEvent e) throws IOException {
        try {
            BillCreateViewController controller = (BillCreateViewController) replaceSceneContent(
                    "/view/stockmanager/BillCreate.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 库存报溢单
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void overflowCreateButtonAction(ActionEvent e) throws IOException {
        try {
            OverflowCreateViewController controller = (OverflowCreateViewController) replaceSceneContent(
                    "/view/stockmanager/OverflowCreate.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    /**
     * 库存报损单
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void breakageCreateButtonAction(ActionEvent e) throws IOException {
        try {
            BreakageCreateViewController controller = (BreakageCreateViewController) replaceSceneContent(
                    "/view/stockmanager/BreakageCreate.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    /**
     * 库存报警单
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void alertCreateButtonAction(ActionEvent e) throws IOException {
        // System.out.println("SUSS");
        try {
            AlertCreateViewController controller = (AlertCreateViewController) replaceSceneContent(
                    "/view/stockmanager/AlertCreate.fxml");
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
        return (Initializable) loader.getController();
    }

    /**
     * @param fxml
     * @param width
     * @param height
     * @return
     * @throws Exception
     */
    private Initializable replaceAnotherSceneContent(String fxml, double width, double height) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MainApp.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainApp.class.getResource(fxml));
        Pane page;
        try {
            page = (Pane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, width, height);
        newStage.setTitle("打开");
        newStage.setScene(scene);
        newStage.sizeToScene();
        newStage.setResizable(false);
        newStage.show();
        return (Initializable) loader.getController();
    }

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

    public void init() {
        showTableView();
        if (isSaved == true) {
            ObservableList<Presentation> data = presentationTable.getItems();
            ArrayList<StockBillItemVO> vos = savedStockBillVO.itemVOS;
            for (int i = 0; i < vos.size(); i++) {
                StockBillItemVO s = vos.get(i);
                // Presentation breakage = new Presentation(dd);
                //data.add(breakage);
            }
        }
    }


    @FXML
    Label idOfCurrentUser, nameOfCurrentUser, categoryOfCurrentUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idOfCurrentUser.setText("编号：" + LoginController.getCurrentUser().getID());
        nameOfCurrentUser.setText("姓名：" + LoginController.getCurrentUser().getName());
        categoryOfCurrentUser.setText("身份：" + LoginController.getCategory());
        init();
    }

}
