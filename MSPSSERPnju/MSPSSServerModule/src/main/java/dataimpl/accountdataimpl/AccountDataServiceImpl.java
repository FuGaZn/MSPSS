package dataimpl.accountdataimpl;

import datahelper.DataHelper;
import dataservice.AccountDataService;
import po.AccountPO;
import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/8.
 */
public class AccountDataServiceImpl  implements AccountDataService{
    private DataHelper<AccountPO> accountHelper;

    protected AccountDataServiceImpl(DataHelper<AccountPO> accountHelper){
        this.accountHelper = accountHelper;
    }

    /**
     * 增加账户
     * @param account
     * @return 增加成功与否
     */
    public ResultMessage addAccount(AccountPO account){
        //目前没有考虑重名与其他情况的exception，同意返回success与failed
        try {
            accountHelper.save(account);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            return ResultMessage.FAILED;
        }

    }
    /**
     * 删除账户
     *
     * @param name
     * @return 删除成功与否
     */
    public ResultMessage deleteAccount(String name){
        try{
            accountHelper.delete("name",name);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            return ResultMessage.FAILED;
        }
    }
    /**
     * 修改账户
     *
     * @param oldName,newName
     * @return 修改成功与否
     */
    public ResultMessage modifyAccount(String oldName,String newName){
        try{
            AccountPO oldaccount = accountHelper.exactlyQuery("name",oldName);

            oldaccount.setName(newName);

            accountHelper.update(oldaccount);
            return ResultMessage.SUCCESS;
        }catch(Exception e){
            return ResultMessage.FAILED;
        }
    }
    /**
     * 查找账户
     *
     * @param name
     * @return 符合条件的List
     */
    public AccountPO checkAccount(String name){

        return accountHelper.exactlyQuery("name",name);

    }
    /**
     * 账户收款
     *
     * @param name,money
     * @return void
     */
    public void income(String name,double money){
        AccountPO account = accountHelper.exactlyQuery("name",name);
        double sum = account.getMoney();
        sum = sum+money;
        account.setMoney(sum);
        accountHelper.update(account);
    }
    /**
     * 账户付款
     *
     * @param name,money
     * @return void
     */
    public void pay(String name,double money){
        AccountPO account = accountHelper.exactlyQuery("name",name);
        double sum = account.getMoney();
        sum = sum-money;
        account.setMoney(sum);
        accountHelper.update(account);
    }



}
