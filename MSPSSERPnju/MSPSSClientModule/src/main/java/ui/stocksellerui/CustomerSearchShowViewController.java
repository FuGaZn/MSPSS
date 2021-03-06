package ui.stocksellerui;

import auxiliary.Customer;
import blimpl.blfactory.BLFactoryImpl;
import blservice.customerblservice.CustomerBLService;
import blservice.mainblservice.MainBLService;
import filterflags.CustomerSearchFlag;
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
import util.Kind_Of_Customers;
import vo.CustomerVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/13
 */
public class CustomerSearchShowViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
    CustomerBLService customerBLService = new BLFactoryImpl().getCustomerBLService();
    ui.common.Dialog dialog = new Dialog();
    static String keyType, keyword;
    @FXML
    Button CustomerAddButton;
    @FXML
    Button CustomerDelButton;
    @FXML
    Button CustomerModButton;
    @FXML
    Button backButton, refreshButton;
    @FXML
    Button BackToLogin;

    @FXML
    TableView<Customer> customerTableView;
    @FXML
    TableColumn<Customer, String> NameCol, IdCol, CategoryCol, LevelCol, DAECol, ReceivableCol, OperationCol;
    // customer()顺序：id、name、category、level、DAE、receivable

    public void showTableView() {
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        CategoryCol.setCellValueFactory(new PropertyValueFactory<>("Category"));
        LevelCol.setCellValueFactory(new PropertyValueFactory<>("Level"));
        DAECol.setCellValueFactory(new PropertyValueFactory<>("DAE"));
        ReceivableCol.setCellValueFactory(new PropertyValueFactory<>("ReceivableLimit"));

        OperationCol.setCellFactory((col) -> {
            TableCell<Customer, String> cell = new TableCell<Customer, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        Button delBtn = new Button("选择");
                        delBtn.setPrefSize(100, 10);
                        delBtn.getStylesheets().add("/css/stockseller/buttonInTable.css");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                            try {
                                CustomerInfoShowViewController.id_to_show = this.getTableView().getItems().get(this.getIndex()).getId();
                                CustomerInfoShowViewController.customerVO = customerBLService.getCustomerInfo(this.getTableView().getItems().get(this.getIndex()).getId());
                                CustomerInfoShowViewController controller = (CustomerInfoShowViewController) replaceSceneContent(
                                        "/view/stockseller/CustomerInfoShow.fxml");

                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        });
                    }
                }
            };
            return cell;
        });
    }

    public void addRow() {
        ArrayList<CustomerVO> list = new ArrayList<>();
        ObservableList<Customer> data = customerTableView.getItems();
        data.clear();
        CustomerSearchFlag customerSearchFlag = CustomerSearchFlag.ID;
        if (keyType != null && keyword != null) {
            if (keyType.equals("姓名")) {
                customerSearchFlag = CustomerSearchFlag.NAME;
            } else if (keyType.equals("编号")) {
                customerSearchFlag = CustomerSearchFlag.ID;
            } else if (keyType.equals("等级")) {
                customerSearchFlag = CustomerSearchFlag.LEVEL;
            } else if (keyType.equals("分类")) {
                customerSearchFlag = CustomerSearchFlag.KIND;
            } else if (keyType.equals("业务员")) {
                customerSearchFlag = CustomerSearchFlag.DAE;
            } else if (keyType.equals("应收额度")) {
                customerSearchFlag = CustomerSearchFlag.INVALUE;
            }
            list = customerBLService.searchCustomer(customerSearchFlag, keyword);
        }
        if (list.size() == 0) {
            dialog.infoDialog("No customer matches conditions.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                CustomerVO customerVO = list.get(i);
                String str = customerVO.getCategory().toString();
                Customer customer = new Customer(customerVO.getID(), customerVO.getName(), str, String.valueOf(customerVO.getLevel()), String.valueOf(customerVO.getIncomemoney()), customerVO.getDAE());
                data.add(customer);
            }
        }
    }


    public void refresh() {
        addRow();
    }

    @FXML
    public void refreshButtonAction(ActionEvent e) {
        addRow();
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

    /**
     * 返回上一界面
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void backButtonAction(ActionEvent e) throws IOException {
        try {
            CustomerSearchViewController controller = (CustomerSearchViewController) replaceSceneContent(
                    "/view/stockseller/CustomerSearch.fxml");
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
     * 修改客户属性
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void customerModifyButtonAction(ActionEvent e) throws IOException {
        try {
            CustomerModifyFirstViewController controller = (CustomerModifyFirstViewController) replaceSceneContent(
                    "/view/stockseller/CustomerModifyFirst.fxml");
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
        showTableView();
        addRow();
        refresh();
    }

}
