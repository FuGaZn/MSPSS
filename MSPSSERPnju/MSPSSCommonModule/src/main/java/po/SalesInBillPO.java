package po;

import util.BillStatus;
import util.SalesInBillType;
import util.Time;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 22:58 2017/11/27/027
 */
public class SalesInBillPO {
    /**
     * 进货类单据的单据编号
     * 进货单格式为（格式为：JHD-yyyyMMdd-xxxxx，后五位每天从1开始编号，所以一天最多可以生成99999条单子）
     * 进货退货单格式为（格式为：JHDTH-yyyyMMdd-xxxxx）
     */
    private String ID;

    /**
     * 供应商
     */
    private String provider;
    /**
     *仓库
     */
    private String storage;

    /**
     * 进货类单据的类型（进货单还是进货退货单）SalesInBillType
     */
    private int type;
    /**
     * 操作员（即产生订单的人）
     */
    private String operatorID;
    /**
     * 备注
     */
    private String ps;

    /**
     * 总额共计
     */
    private double sumMoney;

    /**
     * 入库商品列表
     */
    private ArrayList<SalesItemPO> itemPOS;
    /**
     * 单据状态BillStatus
     */
    private int status;

    /**
     * 单据的创建时间
     */
    private String init_time;
    /**
     * 单据的提交时间
     */
    private String commit_time;
    /**
     * 单据的审批条件
     */
    private String approval_time;
    /**
     * 经理的审批评论
     */
    private String commentByManager;

    /**
     * 审批的经理的ID;
     */
    private String managerID;


    public SalesInBillPO(String ID, String provider, String storage, int type, String operatorID, String ps, double sumMoney, ArrayList<SalesItemPO> itemPOS, int status, String init_time, String commit_time, String approval_time, String commentByManager, String managerID) {
        this.ID = ID;
        this.provider = provider;
        this.storage = storage;
        this.type = type;
        this.operatorID = operatorID;
        this.ps = ps;
        this.sumMoney = sumMoney;
        this.itemPOS = itemPOS;
        this.status = status;
        this.init_time = init_time;
        this.commit_time = commit_time;
        this.approval_time = approval_time;
        this.commentByManager = commentByManager;
        this.managerID = managerID;
    }

    public void setSumMoney(double sumMoney) {
        this.sumMoney = sumMoney;
    }

    public double getSumMoney() {
        return sumMoney;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }



    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCommentByManager() {
        return commentByManager;
    }



    public ArrayList<SalesItemPO> getItemPOS() {
        return itemPOS;
    }

    public void setCommentByManager(String commentByManager) {
        this.commentByManager = commentByManager;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setItemPOS(ArrayList<SalesItemPO> itemPOS) {
        this.itemPOS = itemPOS;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public String getInit_time() {
        return init_time;
    }

    public void setInit_time(String init_time) {
        this.init_time = init_time;
    }

    public String getCommit_time() {
        return commit_time;
    }

    public void setCommit_time(String commit_time) {
        this.commit_time = commit_time;
    }

    public String getApproval_time() {
        return approval_time;
    }

    public void setApproval_time(String approval_time) {
        this.approval_time = approval_time;
    }
}