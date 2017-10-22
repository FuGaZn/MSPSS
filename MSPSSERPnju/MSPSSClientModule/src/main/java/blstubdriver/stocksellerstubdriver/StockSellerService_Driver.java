package blstubdriver.stocksellerstubdriver;

import util.Kind_Of_Customers;
import vo.*;
import org.junit.*;

import java.util.ArrayList;

public class StockSellerService_Driver {

    StockSellerService_Stub stockSellerServiceStub = new StockSellerService_Stub();
    //进货商
    public static CustomerVO Intel = new CustomerVO("00000001", Kind_Of_Customers.SALER, 5, "Intel", "88484399", "Nanjing", "222243", "intel@intel.com", 50000, 43200, 0, "002");
    //销售商
    public static CustomerVO Xiaomi = new CustomerVO("00000002", Kind_Of_Customers.SALER, 4, "Xiaomi", "86868686", "Shanghai", "222231", "xiaomi@xiaomi.com", 50000, 0, 12000, "001");

    @Test
    public void drive() {
        //test addCustomer
        boolean isAdded1 = stockSellerServiceStub.addCustomer(Intel);
        if (isAdded1 == true) {
            System.out.println("Add customer successfully.");
        } else {
            System.out.println("Fail to add customer.");
        }

        boolean isAdded2 = stockSellerServiceStub.addCustomer("00000003", Kind_Of_Customers.SUPPLIER, 5, "Sansung", "36363636", "Korea", "123456", "sansung@sansung.com", 50000, 30000, 0, "004");
        if (isAdded2 == true) {
            System.out.println("Add customer successfully.");
        } else {
            System.out.println("Fail to add customer.");
        }

        //test getCustomer
        CustomerVO customerget = stockSellerServiceStub.getCustomer("00000003");
        if (customerget != null) {
            System.out.println(customerget.name);
            System.out.println("Get customer successfully.");
        } else {
            System.out.println("Fail to get customer.");
        }

        //test searchCustomer
        stockSellerServiceStub.addCustomer(Xiaomi);
        ArrayList<CustomerVO> list = stockSellerServiceStub.searchCustomer("level", "5");
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).name + " ");
            }
            System.out.println();
            System.out.println("Search customers successfully.");
        } else {
            System.out.println("Fail to search customer.");
        }


        //test delCustomer
        boolean isDel = stockSellerServiceStub.delCustomer("00000003");
        if (isDel == true) {
            System.out.println("Delete customer successfully.");
        } else {
            System.out.println("Fail to delete customer.");
        }

        //test ModifyCustomer
        boolean isMod = stockSellerServiceStub.ModifyCustomer("00000001", Kind_Of_Customers.SALER, 3, "Intel", "1529860", "nanjing", "222243", "intel@intel.com", 36000);
        if (isMod) {
            System.out.println("Modify customer successfully.");
        } else {
            System.out.println("Fail to modify customer.");
        }

        //test createPurchaseList
        ArrayList<CommodityVO> purlist = new ArrayList<>();
        boolean iscreateP = stockSellerServiceStub.createPurchaseList(Intel, "024", "004", purlist, 43200, "购入电脑芯片");
        if (iscreateP == true) {
            System.out.println("Create purchase list successfully.");
        } else {
            System.out.println("Fail to create purchase list.");
        }

        //test createSalesList
        ArrayList<CommodityVO> saleslist = new ArrayList<>();
        boolean iscreateS = stockSellerServiceStub.createSalesList(Xiaomi, "001", "004", "024", saleslist, 12000, 0.8, 0, 9600, "出库手机芯片");
        if (iscreateS == true) {
            System.out.println("Create sales list successfully.");
        } else {
            System.out.println("Fail to create sales list.");
        }

        //test createPurchaseReturnList
        ArrayList<CommodityVO> purchrtlist = new ArrayList<>();
        boolean iscreatePR = stockSellerServiceStub.createPurchaseReturnList(Intel, "024", "002", purchrtlist, 35000, "太贵了进不起");
        if (iscreatePR == true) {
            System.out.println("Create purchase-return list successfully.");
        } else {
            System.out.println("Fail to create purchase-return list.");
        }

        //test createSalesReturnList
        ArrayList<CommodityVO> salesrtlist = new ArrayList<>();
        boolean iscreateSR = stockSellerServiceStub.createSalesReturnList(Xiaomi, "001", "002", "024", salesrtlist, 9600, 1, 0, 9600, "小米自研芯片了");
        if (iscreateSR == true) {
            System.out.println("Create sales-return list successfully.");
        } else {
            System.out.println("Fail to create sales-return list.");
        }
    }
}
