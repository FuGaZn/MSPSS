package blimpl.tableblimpl;

import blimpl.billblimpl.*;
import po.*;
import vo.*;

/**
 * Created by thinkpad on 2017/12/27.
 */
public class BillConverter {
  private FinanceBill financeBill = new FinanceBill();
  private CashCostBill cashCostBill = new CashCostBill();
  private SalesOutBill salesOutBill = new SalesOutBill();
  private SalesInBill salesInBill = new SalesInBill();
  private StockBill stockBill = new StockBill();
    public CashCostBillVO CashCostBill_PO_To_VO(CashCostBillPO cashCostBillPO){
          return cashCostBill.po_to_vo(cashCostBillPO);
    }



    public FinanceBillVO FinanceBill_PO_To_VO(FinanceBillPO po){
      System.out.println(po==null);
      return financeBill.po_to_vo(po);
    }



    public SalesInBillVO SalesInBill_PO_To_VO(SalesInBillPO salesInBillPO){
     return salesInBill.po_to_vo(salesInBillPO);
    }

    public SalesOutBillVO SalesOutBill_PO_To_VO(SalesOutBillPO salesOutBillPO){


     return salesOutBill.po_to_vo(salesOutBillPO);


    }

    public StockBillVO StockBill_PO_To_VO(StockBillPO stockBillPO){
      return stockBill.po_to_vo(stockBillPO);
    }



}
