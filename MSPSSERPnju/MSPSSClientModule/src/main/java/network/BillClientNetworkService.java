package network;

import po.*;
import util.*;

import java.rmi.Remote;
import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 14:06 2017/11/30/030
 */
public interface BillClientNetworkService extends Remote {
    /**
     * 添加库存类单据 用于点击保存时
     * @param stockBillPO
     * @return
     */
    public ResultMessage addStockBill(StockBillPO  stockBillPO);

    /**
     * 更新库存类单据 用于点击提交时
     * @param stockBillPO
     * @return
     */
    public ResultMessage updateStockBill(StockBillPO stockBillPO);

    /**
     * 删除某单据 未提交状态
     *
     * @param id
     * @return
     */
    public ResultMessage deleteStockBill(String id);

    /**
     *用于查找某一数据
     */
    public ArrayList<StockBillPO> fullSearchStockBill(String field, Object value);


    public ArrayList<StockBillPO> multiSearchStockBill(ArrayList<CriteriaClause> criteriaClauses);

    /**
     * 范围查找库存类单据
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<StockBillPO> rangeSearchStockBill(String field,Object min,Object max);
    /**
     * 返回形如 KDZSD-20101010-00001
     *
     * @param type
     * @return
     */
    public String getStockBillID(StockBillType type);

    /**
     * 在数据层增加 现金费用单
     *
     * @param po
     * @return
     */
    public ResultMessage addCashCostBill(CashCostBillPO po);

    /**
     * 在数据层更新 现金费用单
     *
     * @param po
     * @return
     */
    public ResultMessage updateCashCostBill(CashCostBillPO po);

    public ResultMessage deleteCashCostBill(String id);

    /**
     * 得到应有的现金费用单ID
     *
     * @return
     */
    public String getCashCostBillID();

    public ArrayList<CashCostBillPO> multiSearchCashCostBill(ArrayList<CriteriaClause> criteriaClauses);

    public ArrayList<CashCostBillPO> fullSearchCashCostBill(String field, Object val);

    /**
     * 范围搜索现金费用单
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<CashCostBillPO> rangeSearchCashCostBill(String field,Object min,Object max);

    public ResultMessage addFinanceBill(FinanceBillPO po);

    public ResultMessage updateFinanceBill(FinanceBillPO po);

    public ResultMessage deleteFinanceBill(String id);

    public ArrayList<FinanceBillPO> fullSearchFinanceBill(String field, Object val);

    public ArrayList<FinanceBillPO> multiSearchFinanceBill(ArrayList<CriteriaClause> criteriaClauses);

    /**
     * 范围搜索财务类单据
     * @param field
     * @param max
     * @param min
     * @return
     */
    public ArrayList<FinanceBillPO> rangeSearchFinanceBill(String field,Object max,Object min);
    /**
     * 根据财务类单据类型返回应有的单据
     *
     * @param type
     * @return
     */
    public String getFinanceBillID(FinanceBillType type);

    public ResultMessage addSalesInBill(SalesInBillPO salesInBillPO);

    public ResultMessage updateSalesInBill(SalesInBillPO salesInBillPO);

    public ResultMessage deleteSalesInBill(String id);

    public ArrayList<SalesInBillPO> fullSearchSalesInBill(String field, Object val);

    public ArrayList<SalesInBillPO> mutilSearchSalesInBill(ArrayList<CriteriaClause> criteriaClauses);

    /**
     * 范围搜索进货/退货单据
     * @param field
     * @param max
     * @param min
     * @return
     */
    public ArrayList<SalesInBillPO> rangeSearchSalesInBill(String field,Object max,Object min);
    /**
     * 根据进货单 进货退货单来返回应有的ID
     *
     * @param type
     * @return
     */
    public String getSalesInBillID(SalesInBillType type);

    public ResultMessage addSalesOutBill(SalesOutBillPO salesOutBillPO);

    public ResultMessage updateSalesOutBill(SalesOutBillPO salesOutBillPO);

    public ResultMessage deleteSalesOutBill(String id);

    public ArrayList<SalesOutBillPO> fullSearchSalesOutBill(String field, Object val);

    public ArrayList<SalesOutBillPO> mutilSearchSalesOutBill(ArrayList<CriteriaClause> criteriaClauses);

    /**
     * 范围查找
     * @param field
     * @param max
     * @param min
     * @return
     */
    public ArrayList<SalesOutBillPO> rangeSearchSalesOutBill(String field,Object max,Object min);
    public String getSalesOutBillID(SalesOutBillType type);

    public ResultMessage addAlarmBill(AlarmBillPO po);

    /**
     * 用来根据前缀来得到某天的产生的库存报警单
     *
     * @param field
     * @param val
     * @return
     */
    public ArrayList<AlarmBillPO> prefixSearchAlarmBill(String field, String val);

    /**
     * 得到库存报警单应有的数据
     *
     * @return
     */
    public String getAlarmID();
}
