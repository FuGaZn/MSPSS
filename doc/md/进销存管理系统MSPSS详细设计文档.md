
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E6%96%87%E6%A1%A3%E5%B0%81%E9%9D%A2/Y%5DUGHQX%7DPCX0Y%5DPPJMKEJ@6.png)
## 更新历史

| 修改人员 | 日期         | 变更原因               | 版本号    |
| ---- | ---------- | ------------------ | ------ |
| FX全组 | 2017-10-28 | 最初草稿               | V1.0   |
| 徐光耀  | 2017-10-30 | 添加逻辑层分解            | v1.1.1 |
| 伏家兴  | 2017-10-30 | 添加stockseller逻辑层分解 | V1.1.2 |
| 刘雅歆  | 2017-11-02 | 添加总经理模块的逻辑层分解      | v1.1.3 |
| 韩新虎  | 2017-11-02 | 添加库存管理人员的逻辑层分解     | V1.1.4 |
| 伏家兴  | 2017-11-04 | 添加进货销售人员展示层分解      | V1.2.1 |
| 刘雅歆  | 2017-11-05 | 添加总经理展示层分解         | V1.2.2 |
| 徐光耀  | 2017-11-06 | 添加财务人员展示层分解        | v1.2.3 |
| 伏家兴  | 2017-11-08 | 添加admin模块的展示层分解    | V1.2.4 |
| FX全组 | 2017-11-10 | 重构业务逻辑层            | V1.3   |
| FX全组 | 2017-12-29 | 根据实际项目调整文档         | V1.4   |

## 目录

[TOC]





## 1. 引言

### **1.1编制目的**

本报告详细完成对MSPSS进销存管理系统概要设计，达到指导详细设计和开放的目的，同时实现和测试人员及用户的沟通

 

### 1.2词汇表

| 词汇名称  | 词汇含义                              | 备注   |
| ----- | --------------------------------- | ---- |
| MSPSS | Manage System Purchase Stock Sell |      |
| _ui   | 表示某展示层                            |      |
| _bl   | 表示某逻辑层                            |      |
| _data | 表示某数据层                            |      |



### 1.3参考资料

1. IEEE Std 1016-1998 《IEEE Recommended Practice for Software Design Descriptions》
2. FX小组，《进销存管理系统MSPSS需求规格说明书V1.2》
3. 丁二玉，刘钦.计算与软件工程（卷二）[M]机械工业出版社，2012：134—182

## 2. 产品概述

参考进销存管理系统MSPSS用例文档和规格需求说明对产品概述的描述

## 3. 体系结构设计概述

参考进销存管理系统MSPSS体系结构设计文档对体系结构的描述

## 4. 结构视角

### 4.1 展示层的分解

#### 4.1.1 stockmanger模块 

##### （1）整体结构

展示层的控制器为树状委托结构，StockManagerMainViewController负责对客户界面的整体跳转，AddClassificationViewController,AddCommodityViewController,AlertCreateViewController,BillCreateViewController,BillDetailsShowViewController,BillStatusCheckViewController,BreakageCreateViewController,CommodityAddViewController,CommodityClassifyViewCotroller,CommodityDelViewCotroller,CommodityInfoModityViewCotroller,CommodityInfoShowViewCotroller,CommodityManageViewCotroller,CommodityModifyFirstViewController,CommodityModitySecondViewCotroller,CommoditySearchShowViewController,CommoditySearchViewController,OverflowCreateViewController,PresentationCreateViewController,SelectClassOrCommodityViewController,StockCheckShowViewCotroller,StockInventoryViewCotroller。分别负责商品分类、商品管理、处理单据、库存盘点和库存查看里的各个功能。stockmanager界面各个类的职责如下：

| 模块                                   | 职责               |
| ------------------------------------ | ---------------- |
| StockManagerMainViewController       | 负责实现对库存管理人员界面的调整 |
| AddClassificationViewController      | 负责实现增加分类弹出界面     |
| AddCommodityViewController           | 负责实现增加商品弹出界面     |
| CommodityManageViewCotroller         | 负责实现商品管理主界面      |
| ClassificationAllViewController      | 负责实现所有商品分类界面     |
| CommodityAddViewController           | 负责添加商品界面         |
| CommodityDelViewController           | 负责删除商品界面         |
| CommodityModifyFirstViewController   | 负责输入需要修改的商品编号界面  |
| CommodityModifySecondViewController  | 负责实现修改商品属性界面     |
| CommodityInfoShowViewController      | 负责实现商品信息展示界面     |
| CommodityInfoModifyViewController    | 负责实现修改商品属性界面     |
| CommoditySearchViewController        | 负责实现查找商品界面       |
| CommoditySearchShowViewController    | 负责实现查找商品结果列表显示界面 |
| CommodityClassifyViewCotroller       | 负责实现商品分类管理界面     |
| StockCheckShowViewController         | 负责实现库存查看界面       |
| StockInventoryViewController         | 负责实现库存盘点界面       |
| OverflowCreateViewController         | 负责实现制定库存报溢单界面    |
| BreakageCreateViewController         | 负责实现制定库存报损单界面    |
| PresentationCreateViewController     | 负责实现制定库存赠送单界面    |
| BillCreateViewController             | 负责实现处理单据主界面      |
| BillStatusCheckViewController        | 负责实现查看已制定单据列表界面  |
| BillDetailsShowViewController        | 负责实现查看单据详情的界面    |
| AlertCreateViewController            | 负责查看产生的库存报警单界面   |
| SelectClassOrCommodityViewController | 负责实现选择分类或商品的弹出界面 |

##### （2）模块内部的的接口规范

StockManagerMainViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| StockManagerViewController.commodityManageButtonAction | 语法   | public void commodityManageButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击商品管理按钮                                 |
|                                          | 后置条件 | 跳转商品管理主界面                                |
| StockManagerViewController.commodityClassifyButtonAction | 语法   | public void commodityClassifyButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击商品分类按钮                                 |
|                                          | 后置条件 | 跳转商品分类界面                                 |
| StockManagerViewController.billCreateButtonAction | 语法   | public void billCreateButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击处理单据按钮                                 |
|                                          | 后置条件 | 跳转处理单据主界面                                |
| StockManagerViewController.stockCheckButtonAction | 语法   | public void stockCheckButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击库存查看按钮                                 |
|                                          | 后置条件 | 显示库存查看界面                                 |
| StockManagerViewController.stockInventoryButtonAction | 语法   | public void stockInventoryButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击库存盘点按钮                                 |
|                                          | 后置条件 | 显示库存盘点界面                                 |
| StockManagerViewController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击登出按钮                                   |
|                                          | 前置条件 | 跳转登陆界面                                   |

需要的服务(需接口)



BillCreateViewController的接口规范

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| BillCreateViewController.billCheckButtonAction | 语法   | public void billCheckButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击查看单据详情按钮                               |
|                                          | 后置条件 | 跳转显已制定单据列表的界面                            |
| BillCreateViewController.overflowCreateButtonAction | 语法   | public void overflowCreateButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击制定库存报溢单按钮                              |
|                                          | 后置条件 | 跳转制定库存报溢单界面                              |
| BillCreateViewController.breakageCreateButtonAction | 语法   | public void breakageCreateButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击制定库存报损单按钮                              |
|                                          | 后置条件 | 跳转到制定库存报损单界面                             |
| BillCreateViewController.presentationCreateButtonAction | 语法   | public void presentationCreateButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击查看库存赠送单按钮                              |
|                                          | 后置条件 | 跳转到更新商品信息界面                              |
| BillCreateViewController.alertCreateButtonAction | 语法   | public void alertCreateButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击处理库存报警单按钮                              |
|                                          | 后置条件 | 跳转处理库存报警单界面                              |
| BillCreateViewController.commodityManageButtonAction | 语法   | public void commodityManageButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击商品管理按钮                                 |
|                                          | 后置条件 | 跳转商品管理主界面                                |
| BillCreateViewController.commodityClassifyButtonAction | 语法   | public void commodityClassifyButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击商品分类按钮                                 |
|                                          | 后置条件 | 跳转商品分类界面                                 |
| BillCreateViewController.stockCheckButtonAction | 语法   | public void stockCheckButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击库存查看按钮                                 |
|                                          | 后置条件 | 显示库存查看界面                                 |
| BillCreateViewController.stockInventoryButtonAction | 语法   | public void stockInventoryButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击库存盘点按钮                                 |
|                                          | 后置条件 | 显示库存盘点界面                                 |
|                                          |      |                                          |
|                                          |      |                                          |

需要的服务(需接口)

CommodifyClassifyViewController的接口规范 

提供的服务 供接口 

| 服务名                                      | 服务   |                             |
| ---------------------------------------- | ---- | --------------------------- |
| CommodifyClassifyViewController.showTableView | 语法   | public void showTableView() |
|                                          | 前置条件 | 无                           |
|                                          | 后置条件 | 展示分类树                       |

需要的服务(需接口)

| 服务名                                      | 服务            |
| ---------------------------------------- | ------------- |
| CommodityBLService.getChildrenClassification(ClassificationVO vo) | 得到一个分类下所有的子分类 |
| CommodityBLService.getChildrenCommodity(ClassificationVO vo) | 得到一个分类下所有的商品  |
| CommodityBLService.updateClassification(ClassificationVO vo) | 更新分类信息        |
| CommodityBLService.deleteClassification(String id) | 删除分类          |
| CommodityInfoService.getCommodity(String id) | 得到商品          |
| CommodityBLService.deleteCommodity(String id) | 删除商品          |
|                                          |               |

CommodityManageViewController的接口规范

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CommodityManageViewController.commodityDelButtonAction | 语法   | public void commodityDelButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击删除商品按钮                                 |
|                                          | 后置条件 | 跳转删除商品界面                                 |
| CommodityManageViewController.commodityAddButtonAction | 语法   | public void commodityAddButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击增加商品按钮                                 |
|                                          | 后置条件 | 跳转增加商品界面                                 |
| CommodityManageViewController.commodityModlButtonAction |      | public void commodityModButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击修改商品按钮                                 |
|                                          | 后置条件 | 跳转输入需要修改的商品编号界面                          |
| CommodityManageViewController.commoditySearchButtonAction |      | public void commoditySearchButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击查找商品按钮                                 |
|                                          | 后置条件 | 跳转显示查找结果显示界面                             |
|                                          |      |                                          |

需要的服务(需接口)



CommodityAddViewController 的接口规范 

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CommodityAddViewController.sureButtonAction | 语法   | public void sureButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击确定按钮                                   |
|                                          | 后置条件 | 增加商品                                     |
| CommodityAddViewController.returnButtonAction | 语法   | public void returnButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击取消按钮                                   |
|                                          | 后置条件 | 返回商品管理界面                                 |
|                                          |      |                                          |

需要的服务(需接口)

| 服务名                             | 服务   |
| ------------------------------- | ---- |
| CommodityBLService.addCommodity | 增加商品 |
|                                 |      |



CommodityDelViewController 的接口规范 

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CommodityDelViewController.delButtonAction | 语法   | public void delButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击确定删除按钮                                 |
|                                          | 后置条件 | 删除商品                                     |
| CommodityDelViewController.returnButtonAction | 语法   | public void returnButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击取消按钮                                   |
|                                          | 后置条件 | 返回商品管理界面                                 |
|                                          |      |                                          |

需要的服务(需接口)

| 服务名                                | 服务   |
| ---------------------------------- | ---- |
| CommodityBLService.deleteCommodity | 删除商品 |
|                                    |      |



CommoditySearchViewController 的接口规范 

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CommoditySearchViewController.commoditySearchButtonAction | 语法   | public void commoditySearchButtonAction(Action Event e) |
|                                          | 前置条件 | 点击确定按钮                                   |
|                                          | 后置条件 | 查找商品                                     |
| CommoditySearchViewController.returnButtonAction | 语法   | public void returnButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击取消按钮                                   |
|                                          | 后置条件 | 返回商品管理界面                                 |
|                                          |      |                                          |

需要的服务(需接口)

CommoditySearchShowViewController 的接口规范 

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CommoditySearchShowViewController.showTableView | 语法   | public void showTableView()              |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 |                                          |
| CommoditySearchShowViewController.backButtonAction | 语法   | public void backButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回查找商品界面                                 |
| CommoditySearchShowViewController.refreshButtonAction | 语法   | public void refreshButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击刷新按钮                                   |
|                                          | 后置条件 |                                          |

需要的服务(需接口)

| 服务名                                      | 服务   |
| ---------------------------------------- | ---- |
| CommodityInfoService.search(FilterFlagVO vo) | 查找商品 |
|                                          |      |



CommodityModifySecondViewController 的接口规范 

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CommodityModifySecondViewController.sureButtonAction | 语法   | public void sureButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击确定按钮                                   |
|                                          | 后置条件 | 修改商品属性                                   |
| CommodityModifySecondViewController.returnButtonAction | 语法   | public void returnButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击取消按钮                                   |
|                                          | 后置条件 | 返回商品管理界面                                 |
|                                          |      |                                          |

需要的服务(需接口)

| 服务名                                 | 服务     |
| ----------------------------------- | ------ |
| CommodityBLService.updatedCommodity | 更新商品属性 |
|                                     |        |



StockCheckShowViewController的接口规范

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| StockCheckShowViewController.sureButtonAction | 语法   | public void sureButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击查看按钮                                   |
|                                          | 后置条件 | 显示库存查看结果                                 |
| StockViewController.showTableView        | 语法   | public void showTableView()              |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 显示库存查看的初始界面                              |

需要的服务(需接口)

| 服务名                      | 服务   |
| ------------------------ | ---- |
| StockBLService.viewStock | 库存查看 |
|                          |      |
|                          |      |



StockInventoryViewController  的接口规范

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| InventoryViewController.exportToExcelButtonAction | 语法   | public void exportToExcelButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击导出按钮                                   |
|                                          | 后置条件 | 导出Excel                                  |
| InventoryViewController.showTableView    | 语法   | public void showTableView()              |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 展示库存盘点界面                                 |
|                                          |      |                                          |
|                                          |      |                                          |
|                                          |      |                                          |

需要的服务(需接口)

| 服务名                            | 服务     |
| ------------------------------ | ------ |
| StockBillService.viewInventory | 库存盘点界面 |
|                                |        |
|                                |        |



BillStatusCheckViewController

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| BillStatusCheckViewController.showTableView | 语法   | public void showTableView()              |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 展示已制定单据的初始界面                             |
| BillStatusCheckViewController.statusScreen | 语法   | public void statusScreen()               |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 单据状态筛选                                   |
| BillStatusCheckViewController.typeScreen | 语法   | public void typeScreen()                 |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 单据类型筛选                                   |
| BillStatusCheckViewController.screenBoxAction | 语法   | public void screenBoxAction(ActionEvent e) |
|                                          | 前置条件 | 选择筛选条件                                   |
|                                          | 后置条件 | 通过筛选条件来筛选单据                              |

需要的服务(需接口)

| 服务名                                      | 服务           |
| ---------------------------------------- | ------------ |
| StockManagerBillBLService.getMyStockBill | 得到当前业务员制定的单据 |
|                                          |              |

BillDetailsShowViewController

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| BillDetailsShowViewController.showTableView | 语法   | public void showTableView()              |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 展示单据详情                                   |
| BillDetailsShowViewController.returnButtonAction | 语法   | public void returnButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回处理单据的主界面                               |

需要的服务(需接口)



OverflowCreateViewController  的接口规范

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| OverflowCreateViewController.saveButtonAction | 语法   | public void saveButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击保存按钮                                   |
|                                          | 后置条件 | 保存单据                                     |
| OverflowCreateViewController.sureButtonAction | 语法   | public void sureButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击提交按钮                                   |
|                                          | 后置条件 | 展示制定库存报溢单的界面                             |
| OverflowCreateViewController.chooseCommodityButtonAction | 语法   | public void chooseCommodityButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击选择商品按钮                                 |
|                                          | 后置条件 | 弹出选择商品的界面                                |
| OverflowCreateViewController.cancelButtonAction | 语法   | public void cancelButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击取消按钮                                   |
|                                          | 后置条件 | 返回处理单据主界面                                |
| OverflowCreateViewController.addRowButtonAction | 语法   | public void addRowButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击增加按钮                                   |
|                                          | 后置条件 | 向商品列表添加一列商品                              |
| OverflowCreateViewController.dealSelectedButtonAction | 语法   | public void dealSelectedButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击删除按钮                                   |
|                                          | 后置条件 | 删除选中行商品                                  |

需要的服务(需接口)

| 服务名                                      | 服务     |
| ---------------------------------------- | ------ |
| StockManagerBillBLService.saveStockBill  | 保存单据   |
| StockManagerBillBLService.commitStockBill | 提交单据   |
| CommodityInfoService.getCommodity        | 获得商品属性 |
|                                          |        |

BreakageCreateViewController  的接口规范

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| BreakageCreateViewController.saveButtonAction | 语法   | public void saveButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击保存按钮                                   |
|                                          | 后置条件 | 保存单据                                     |
| BreakageCreateViewController.sureButtonAction | 语法   | public void sureButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击提交按钮                                   |
|                                          | 后置条件 | 展示制定库存报损单的界面                             |
| BreakageCreateViewController.chooseCommodityButtonAction | 语法   | public void chooseCommodityButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击选择商品按钮                                 |
|                                          | 后置条件 | 弹出选择商品的界面                                |
| BreakageCreateViewController.cancelButtonAction | 语法   | public void cancelButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击取消按钮                                   |
|                                          | 后置条件 | 返回处理单据主界面                                |
| BreakageCreateViewController.addRowButtonAction | 语法   | public void addRowButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击增加按钮                                   |
|                                          | 后置条件 | 向商品列表添加一列商品                              |
| BreakageCreateViewController.dealSelectedButtonAction | 语法   | public void dealSelectedButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击删除按钮                                   |
|                                          | 后置条件 | 删除选中行商品                                  |

需要的服务(需接口)

| 服务名                                      | 服务     |
| ---------------------------------------- | ------ |
| StockManagerBillBLService.saveStockBill  | 保存单据   |
| StockManagerBillBLService.commitStockBill | 提交单据   |
| CommodityInfoService.getCommodity        | 获得商品属性 |
|                                          |        |



表17  AlertCreateViewController  的接口规范

提供的服务 供接口 



| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| AlertCreatelViewController.showTableView | 语法   | public void showTableView()              |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 展示报警单的初始界面                               |
| AlertCreateViewController.cancelButtonAction | 语法   | public void cancelButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击取消按钮                                   |
|                                          | 后置条件 | 返回上一界面                                   |
| AlertCreateViewController.dealAllButtonAction | 语法   | public void dealAllButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击全部处理按钮                                 |
|                                          | 后置条件 | 处理所有的报警单                                 |
| AlertCreateViewController.dealSelectedButtonAction | 语法   | public void dealSelectedButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击处理按钮                                   |
|                                          | 后置条件 | 处理选中的报警单                                 |

需要的服务(需接口)

| 服务名                               | 服务      |
| --------------------------------- | ------- |
| BillBLService.getAllAlarmBill     | 得到库存报警单 |
| CommodityInfoService.getCommodity | 获得商品属性  |

AddClassificationViewController

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| AddClassificationViewController.sureButton | 语法   | public void sureButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击确定按钮                                   |
|                                          | 后置条件 | 增加分类                                     |
| AddClassificationViewController.returnButtonAction | 语法   | public void returnButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 关闭增加分类界面                                 |

需要的服务(需接口)

| 服务名                                  | 服务   |
| ------------------------------------ | ---- |
| CommodityBLService.addClassification | 增加分类 |



AddCommodityViewController

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| AddCommodityViewController.sureButton    | 语法   | public void sureButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击确定按钮                                   |
|                                          | 后置条件 | 增加商品                                     |
| AddCommodityViewController.returnButtonAction | 语法   | public void returnButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 关闭增加商品界面                                 |

需要的服务(需接口)

| 服务名                             | 服务   |
| ------------------------------- | ---- |
| CommodityBLService.addCommodity | 增加商品 |



#### 4.1.2 stockseller模块

##### （1）整体结构

展示层的控制器为树状委托式结构，StockSellerMainViewController负责对进货销售人员界面的整体跳转，StockSellerNavBarController负责实现导航栏界面，CustomerManagerViewController、BillCreateViewController分别实现进货销售人员导航栏的客户管理和制定单据的跳转

StockSeller界面各类的职责如表4.1.2(1)-1所示

表4.1.2(1)-1 StockSeller界面各类的职责

| 模块                                 | 职责                 |
| ---------------------------------- | ------------------ |
| StockSellerMainViewController      | 负责实现对进货销售人员界面的整体跳转 |
| CustomerManageViewController       | 负责客户管理界面           |
| BillCreateViewController           | 负责制定单据理界面          |
| BillStatusCheckViewController      | 负责实现查看已制定单据状态界面    |
| BillDetailsShowViewController      | 负责实现查看单据详情界面       |
| CustomerAddViewController          | 负责增加客户界面           |
| CustomerDelViewController          | 负责删除客户界面           |
| CustomerModifyFirstViewController  | 负责实现输入需要修改的客户编号界面  |
| CustomerModifySecondViewController | 负责修改客户属性界面         |
| CustomerSearchViewController       | 负责查找客户界面           |
| CustomerSearchShowViewController   | 负责实现查找客户结果列表显示界面   |
| CustomerInfoShowViewController     | 负责展示客户属性界面         |
| CustomerInfoModifyViewController   | 负责实现修改客户属性界面       |
| PurchaseCreateViewController       | 负责制定进货单界面          |
| SalesCreateViewController          | 负责制定进货退货单界面        |
| PurcRetCreateViewController        | 负责制定销售单界面          |
| SalesRetCreateViewController       | 负责制定销售退货单界面        |
| SalesBillDetailsShowViewController | 负责实现查看销售类单据详情界面    |
| SelectPromotionViewController      | 负责实现选择促销策略界面       |

##### （2）模块内部类的接口规范

StockSellerMainViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| StockSellerViewController.customerManageButtonAction | 语法   | public void customerManageButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击客户管理                                   |
|                                          | 后置条件 | 显示客户管理界面                                 |
| StockSellerViewController.billCreateButtonAction | 语法   | public void billCreateButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击制定单据                                   |
|                                          | 后置条件 | 显示制定单据界面                                 |
|                                          |      |                                          |

需要的服务（需接口）



CustomerManageViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CustomerManageViewController.customerAddButtonAction | 语法   | public void customerAddButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击增加客户按钮                                 |
|                                          | 后置条件 | 显示增加客户界面                                 |
| CustomerManageViewController.customerDelButtonAction | 语法   | public void customerDelButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击删除客户按钮                                 |
|                                          | 后置条件 | 显示删除客户界面                                 |
| CustomerManageViewController.customerModifyButtonAction | 语法   | public void customerModifyButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击修改客户属性按钮                               |
|                                          | 后置条件 | 显示修改客户属性界面                               |
| CustomerManageViewController.customerSearchShowButtonAction | 语法   | public void customerSearchShowButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击查找按钮                                   |
|                                          | 后置条件 | 显示查找客户界面                                 |
| CustomerManageViewController.billCreateButtonAction | 语法   | public void billCreateButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 跳转制定单据界面                                 |
| CustomerManageViewController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击登出按钮                                   |
|                                          | 后置条件 | 跳转登陆界面                                   |

需要的服务（需接口）



BillCreateViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| BillCreateViewController.salesCreateButtonAction | 语法   | public void salesCreateButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击制定销售单按钮                                |
|                                          | 后置条件 | 显示制定销售单界面                                |
| BillCreateViewController.salesRetCreateButtonAction | 语法   | public void salesRetCreateButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击制定销售退货单按钮                              |
|                                          | 后置条件 | 显示制定销售退货单界面                              |
| BillCreateViewController.purchaseCreateButtonAction | 语法   | public void purchaseCreateButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击制定进货单按钮                                |
|                                          | 后置条件 | 显示制定进货单界面                                |
| BillCreateViewController.purcRetCreateButtonAction | 语法   | public void purcRetCreateButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击制定进货退货单按钮                              |
|                                          | 后置条件 | 显示制定进货退货单界面                              |
| BillCreateViewController.billCheckButtonAction | 语法   | public void billCheckButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击查看单据详情按钮                               |
|                                          | 后置条件 | 显示已制定单据列表界面                              |

需要的服务（需接口）



CustomerAddViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CustomerAddViewController.cancelButtonAction | 语法   | public void cancelButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回上一界面                                   |
| CustomerAddViewController.sureButtonAction | 语法   | public void sureButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击确定按钮                                   |
|                                          | 后置条件 | 增加客户                                     |

需要的服务（需接口）

| 服务名                           | 服务   |
| ----------------------------- | ---- |
| CustomerBLService.addCustomer | 增加客户 |
|                               |      |



CustomerDelViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CustomerDelViewController.cancelButtonAction | 语法   | public void cancelButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回上一界面                                   |
| CustomerDelViewController.sureButtonAction | 语法   | public void sureButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击确定按钮                                   |
|                                          | 后置条件 | 删除客户                                     |



需要的服务（需接口）

| 服务名                           | 服务   |
| ----------------------------- | ---- |
| CustomerBLService.delCustomer | 服务   |

表4.1.2(2)-7 CustomerModifySecondViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CustomerModifySecondViewController.cancelButtonAction | 语法   | public void cancelButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回上一界面                                   |
| CustomerModifySecondViewController.sureButtonAction | 语法   | public void sureButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击确定按钮                                   |
|                                          | 后置条件 | 修改客户属性                                   |

需要的服务（需接口）

| 服务名                              | 服务     |
| -------------------------------- | ------ |
| CustomerBLService.modifyCustomer | 修改客户属性 |



CustomerSearchShowViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CustomerSearchShowViewController.backButtonAction | 语法   | public boolean backButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回上一界面                                   |
| CustomerSearchShowViewController.showTableView | 语法   | public void showTableView()              |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 查找列表的初始界面                                |
| CustomerSearchShowViewController.refresh | 语法   | public void refresh()                    |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 刷新列表                                     |
| CustomerSearchShowViewController.refreshButtonAction | 语法   | public void refreshButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击刷新按钮                                   |
|                                          | 后置条件 | 刷新列表                                     |

需要的服务（需接口）

| 服务名                               | 服务   |
| --------------------------------- | ---- |
| CustomerBLService.searchCustomer  | 查找客户 |
| CustomerBLService.getCustomerInfo | 获取客户 |

表4.1.2(2)-9 CustomerInfoShowViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CustomerInfoShowViewController.delButtonAction | 语法   | public void delButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击删除按钮                                   |
|                                          | 后置条件 | 删除当前显示的客户                                |
| CustomerInfoShowViewController.modButtonAction | 语法   | public void modButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击修改按钮                                   |
|                                          | 后置条件 | 跳转修改属性界面                                 |
| CustomerInfoShowViewController.backButtonAction | 语法   | public void backButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回上一界面                                   |

需要的服务（需接口）

| 服务名                               | 服务   |
| --------------------------------- | ---- |
| CustomerBLService.delCustomer     | 删除客户 |
| CustomerBLService.getCustomerInfo | 获取客户 |
|                                   |      |



PurchaseCreateViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| PurchaseCreateViewController.showTableView | 语法   | public void showTableView                |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 显示制定进货单初始界面                              |
| PurchaseCreateViewController.cancelButtonAction | 语法   | public void cancelButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回上一界面                                   |
| PurchaseCreateViewController.saveBill    | 语法   | public void saveBill                     |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 保存单据                                     |
| PurchaseCreateViewController.saveButtonAction | 语法   | public void saveButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击保存按钮                                   |
|                                          | 后置条件 | 保存单据至系统                                  |
| PurchaseCreateViewController.sureButtonAction | 语法   | public void sureButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击提交按钮                                   |
|                                          | 后置条件 | 提交单据至系统                                  |
| PurchaseCreateViewController.chooseButtonAction | 语法   | public void chooseButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击选择商品按钮                                 |
|                                          | 后置条件 | 选择商品                                     |
| PurchaseCreateViewController.addRowButtonAction | 语法   | public void addRowButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击增加按钮                                   |
|                                          | 后置条件 | 增加一列商品到列表                                |
| PurchaseCreateViewController.delRowButtonAction | 语法   | public void delRowButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击删除按钮                                   |
|                                          | 后置条件 | 列表中删除选中的商品                               |

需要的服务（需接口）

| 服务名                                     | 服务    |
| --------------------------------------- | ----- |
| SalesmanBillBLService.saveSalesInBill   | 保存进货单 |
| SalesmanBillBLService.commitSalesInBill | 提交进货单 |
| CommodityInfoService.getCommodity       | 获取商品  |
| CustomerBLInfo.getCustomerByID          | 获取客户  |

PurcRetCreateViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| PurcRetCreateViewController.showTableView | 语法   | public void showTableView                |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 显示制定进货退货单初始界面                            |
| PurcRetCreateViewController.cancelButtonAction | 语法   | public void cancelButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回上一界面                                   |
| PurcRetCreateViewController.saveBill     | 语法   | public void saveBill                     |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 保存单据                                     |
| PurcRetCreateViewController.saveButtonAction | 语法   | public void saveButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击保存按钮                                   |
|                                          | 后置条件 | 保存进货退货单至系统                               |
| PurcRetCreateViewController.sureButtonAction | 语法   | public void sureButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击提交按钮                                   |
|                                          | 后置条件 | 提交进货退货单至系统                               |
| PurcRetCreateViewController.chooseButtonAction | 语法   | public void chooseButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击选择商品按钮                                 |
|                                          | 后置条件 | 选择商品                                     |
| PurcRetCreateViewController.addRowButtonAction | 语法   | public void addRowButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击增加按钮                                   |
|                                          | 后置条件 | 增加一列商品到列表                                |
| PurcRetCreateViewController.delRowButtonAction | 语法   | public void delRowButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击删除按钮                                   |
|                                          | 后置条件 | 列表中删除选中的商品                               |

需要的服务（需接口）

| 服务名                                     | 服务      |
| --------------------------------------- | ------- |
| SalesmanBillBLService.saveSalesInBill   | 保存进货退货单 |
| SalesmanBillBLService.commitSalesInBill | 提交进货退货单 |
| CommodityInfoService.getCommodity       | 获取商品    |
| CustomerBLInfo.getCustomerByID          | 获取客户    |



SalesCreateViewController的接口规范

提供的服务（供接口）

需要的服务（需接口）



SalesRetCreateViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| SalesRetCreateViewController.showTableView | 语法   | public void showTableView                |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 显示制定销售退货单初始界面                            |
| SalesRetCreateViewController.cancelButtonAction | 语法   | public void cancelButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回上一界面                                   |
| SalesRetCreateViewController.saveBill    | 语法   | public void saveBill                     |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 保存单据                                     |
| SalesRetCreateViewController.saveButtonAction | 语法   | public void saveButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击保存按钮                                   |
|                                          | 后置条件 | 保存单据至系统                                  |
| SalesRetCreateViewController.sureButtonAction | 语法   | public void sureButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击提交按钮                                   |
|                                          | 后置条件 | 提交销售退货单至系统                               |
| SalesRetCreateViewController.chooseButtonAction | 语法   | public void chooseButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击选择商品按钮                                 |
|                                          | 后置条件 | 选择商品                                     |
| SalesRetCreateViewController.addRowButtonAction | 语法   | public void addRowButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击增加按钮                                   |
|                                          | 后置条件 | 增加一列商品到列表                                |
| SalesRetCreateViewController.delRowButtonAction | 语法   | public void delRowButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击删除按钮                                   |
|                                          | 后置条件 | 列表中删除选中的商品                               |

需要的服务（需接口）

| 服务名                                      | 服务      |
| ---------------------------------------- | ------- |
| SalesmanBillBLService.saveSalesOutBill   | 保存销售退货单 |
| SalesmanBillBLService.commitSalesOutBill | 提交销售退货单 |
| CommodityInfoService.getCommodity        | 获取商品    |
| CustomerBLInfo.getCustomerByID           | 获取客户    |



SelectPromotionViewController接口规范

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| SelectPromotionViewController.showCustomerPromotion | 语法   | public void showCustomerPromotion()      |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 显示客户等级折让内容                               |
| SelectPromotionViewController.returnButtonAction | 语法   | public void ButtonAction(ActionEvent e)  |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回上一界面                                   |
| SelectPromotionViewController.showGrossPromotion | 语法   | public void showGrossPromotion()         |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 显示总额折让内容                                 |
| SelectPromotionViewController.showGroupPromotion | 语法   | public void showGroupPromotion()         |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 显示特价包内容                                  |
| SelectPromotionViewController.sureButtonAction | 语法   | public void sureButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击确定按钮                                   |
|                                          | 后置条件 | 选择促销策略                                   |

需要的服务（需接口）

| 服务名                                      | 服务            |
| ---------------------------------------- | ------------- |
| PromotionBLInfo.getAvailableCustomerPromotion | 获取可用的客户等级折让策略 |
| PromotionBLInfo.getAvailableGrossPromotion | 获取可用的总额折让策略   |
| PromotionBLInfo.getAvailableGroupPromotion | 获取可用的特价包折让策略  |
| SalesmanBillBLService.setCustomerPromotion | 选择客户等级折让      |
| SalesmanBillBLService.setGroupPromotion  | 选择特价包折让       |
| SalesmanBillBLService.setGrossPromotion  | 选择总额折让        |

BillDetailsShowViewController接口规范

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| BillDetailsShowViewController.showTableView | 语法   | public void showTableView()              |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 展示单据详情                                   |
| BillDetailsShowViewController.returnButtonAction | 语法   | public void returnButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回处理单据的主界面                               |



#### 4.1.3 financerManager模块

##### （1）整体结构

展示层的控制器为树状委托式结构，

FinanceManagerMainViewController负责对财务人员功能界面的整体跳转，FinanceManagerAddCashCostBillController,FinanceManagerAddPayBillController,FinanceManagerAddReceiveBillController,FinanceManagerCreateGeneralAccountController,FinanceManagerMakeBillMainController,FinanceManagerSearchListController,FinanceManagerSearchManageListController,FinanceManagerSearchProcessListController,FinanceManagerSearchSalesListController,FinanceManagerShowCashCostBillDetailController,FinanceManagerShowFinanceBillDetailController,FinanceManagerShowSalesInBillDetailController,FinanceManagerShowSalesOutBillDetailController,FinanceManagerShowStockBillDetailController,FinanceManagerSuperviseAccountController分别是实现制定现金费用单，制定付款单，制定收款单，期初建账，制定单据主界面，查看报表主界面，查看经营情况表，查看经营历程表，查看销售明细表，查看现金费用单详情，查看财务类单据详情，查看进货类单据详情，查看销售类单据详情，查看库存类单据详情，账户管理显示界面的跳转。<br>

finance各个类的职责如表4.1.3(1)-1所示<br>

表4.1.1.3(1)-1各个类的职责

| 模块                                       | 职责                    |
| ---------------------------------------- | --------------------- |
| FinanceManagerMainViewController         | 负责实现对财务人员界面的整体跳转      |
| FinanceManagerSuperviseAccountController | 负责实现账户搜索及显示账户列表的账户主界面 |
| FinanceManagerSearchManageListController | 负责实现查看经营情况表界面         |
| FinanceManagerSearchSalesListController  | 负责实现查看销售明细表界面         |
| FinanceManagerSearchProcessListController | 负责实现查看经营历程表界面         |
| FinanceManagerMakeBillMainController     | 负责实现制定单据类型选择界面        |
| FinanceManagerAddCashCostBillController  | 负责实现制定现金费用单界面         |
| FinanceManagerAddPayBillController       | 负责实现制定付款单界面           |
| FinanceManagerAddReceiveBillController   | 负责实现制度收款单界面           |
| FinanceManagerSearchListController       | 负责实现查看报表界面            |
| FinanceManagerCreateGeneralAccountController | 负责实现期初建账界面            |
| FinanceManagerShowCashCostBillDetailController | 负责实现查看现金费用单界面         |
| FinanceManagerShowFinanceBillDetailController | 负责实现查看财务类单据界面         |
| FinanceManagerShowSalesInBillDetailController | 负责实现查看进货类单据界面         |
| FinanceManagerShowSalesOutBillDetailController | 负责实现查看销售类单据界面         |
| FinanceManagerShowStockBillDetailController | 负责实现查看库存类单据界面         |

##### （2）模块内部类的接口规范

表4.1.3(2)-1 FinanceManagerMainViewController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceManagerMainViewController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| FinanceManagerMainViewController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| FinanceManagerMainViewController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| FinanceManagerMainViewController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| FinanceManagerMainViewController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| FinanceManagerMainViewController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| FinanceManagerMainViewController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |


| 需要的服务(需接口) |      |
| ---------- | ---- |
| 模块         | 服务   |
| 无          |      |

表4.1.3(2)-2 FinanceManagerSuperviseAccountController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceManagerSuperviseAccountController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| FinanceManagerSuperviseAccountController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| FinanceManagerSuperviseAccountController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| FinanceManagerSuperviseAccountController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| FinanceManagerSuperviseAccountController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| FinanceManagerSuperviseAccountController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| FinanceManagerSuperviseAccountController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| FinanceManagerSuperviseAccountController.initTable | 语法   | public void initTable();                 |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 给表格中的相应列添加按钮                             |
| FinanceManagerSuperviseAccountController.handleSearchAccountButtonAction | 语法   | public void handleSearchAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查找账户按钮                                 |
|                                          | 后置条件 | 显示符合条件的账户                                |
| FinanceManagerSuperviseAccountController.handleAddAccountButtonAction | 语法   | public void handleAddAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击添加账户按钮                                 |
|                                          | 后置条件 | 增加用户要求的账户                                |
| FinanceManagerSuperviseAccountController.handleUpdateAccountButtonAction | 语法   | public void handleUpdateAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击修改账户按钮                                 |
|                                          | 后置条件 | 修改账户名称                                   |

| 需要的服务(需接口)                               |             |
| ---------------------------------------- | ----------- |
| 服务名                                      | 服务          |
| AccountBLService.searchAccount           | 搜索符合条件的账户   |
| loginController.getCurrentUser           | 获取当前登录用户    |
| AccountBLService.deleteAccount           | 删除账户        |
| AccountBLService.fuzzSearchAccountByName | 根据账户名模糊搜索账户 |
| AccountBLService.addAccount              | 增加账户        |
| AccountBLService.modifyAccount           | 修改账户        |


表4.1.3(2)-3 FinanceManagerSearchManageListController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceManagerSearchManageListController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| FinanceManagerSearchManageListController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| FinanceManagerSearchManageListController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| FinanceManagerSearchManageListController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| FinanceManagerSearchManageListController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| FinanceManagerSearchManageListController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| FinanceManagerSearchManageListController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| FinanceManagerSearchManageListController.showManageTable | 语法   | public void showManageTable(BusinessTableVO vo); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示经营情况表界面                                |
| FinanceManagerSearchManageListController.handleExportManageListButtonAction | 语法   | public void handleExportManageListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击导出报表按钮                                 |
|                                          | 后置条件 | 导出经营情况表                                  |
| FinanceManagerSearchManageListController.handleBackToSearchListButtonAction | 语法   | public void handleBackToSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击返回查看报表按钮                               |
|                                          | 后置条件 | 显示查看报表主界面                                |



| 需要的服务(需接口)                         |          |
| ---------------------------------- | -------- |
| 服务名                                | 服务       |
| loginController.getCurrentUser     | 获取当前登录用户 |
| tableBLService.exportBusinessTable | 导出经营情况表  |


表4.1.3(2)-4 FinanceManagerSearchSalesListController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceManagerSearchSalesListController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| FinanceManagerSearchSalesListController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| FinanceManagerSearchSalesListController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| FinanceManagerSearchSalesListController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| FinanceManagerSearchSalesListController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| FinanceManagerSearchSalesListController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| FinanceManagerSearchSalesListController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| FinanceManagerSearchSalesListController.ShowSalesList | 语法   | public void ShowSalesList(SaleTableVO vo); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示销售明细表界面                                |
| FinanceManagerSearchSalesListController.handleExportSalesListButtonAction | 语法   | public void handleExportSalesListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击导出报表按钮                                 |
|                                          | 后置条件 | 导出销售明细表                                  |
| FinanceManagerSearchSalesListController.handleBackToSearchListButtonAction | 语法   | public void handleBackToSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击返回查看报表按钮                               |
|                                          | 后置条件 | 显示查看报表主界面                                |



| 需要的服务(需接口)                     |          |
| ------------------------------ | -------- |
| 服务名                            | 服务       |
| loginController.getCurrentUser | 获取当前登录用户 |
| tableBLService.exportSaleTable | 导出销售明细表  |


表4.1.3(2)-5 FinanceManagerSearchProcessListController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceManagerSearchProcessListController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| FinanceManagerSearchProcessListController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| FinanceManagerSearchProcessListController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| FinanceManagerSearchProcessListController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| FinanceManagerSearchProcessListController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| FinanceManagerSearchProcessListController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| FinanceManagerSearchProcessListController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| FinanceManagerSearchProcessListController.initTable | 语法   | public void initTable();                 |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 给表格中的相应列添加按钮                             |
| FinanceManagerSearchProcessListController.showProcessTable | 语法   | public void showProcessTable(ProcessTableVO vo); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示经营历程表界面                                |
| FinanceManagerSearchProcessListController.handleExportProcessListButtonAction | 语法   | public void handleExportProcessListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击导出报表按钮                                 |
|                                          | 后置条件 | 导出经营历程表                                  |
| FinanceManagerSearchProcessListController.handleBackToSearchListButtonAction | 语法   | public void handleBackToSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击返回查看报表按钮                               |
|                                          | 后置条件 | 显示查看报表主界面                                |



| 需要的服务(需接口)                        |          |
| --------------------------------- | -------- |
| 服务名                               | 服务       |
| loginController.getCurrentUser    | 获取当前登录用户 |
| tableBLService.exportProcessTable | 导出经营历程表  |

表4.1.3(2)-6 FinanceManagerMakeBillMainController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceManagerMakeBillMainController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| FinanceManagerMakeBillMainController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| FinanceManagerMakeBillMainController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| FinanceManagerMakeBillMainController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| FinanceManagerMakeBillMainController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| FinanceManagerMakeBillMainController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| FinanceManagerMakeBillMainController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| FinanceManagerMakeBillMainController.handleAddReceiveBillButtonAction | 语法   | public void handleAddReceiveBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击增加收款单按钮                                |
|                                          | 后置条件 | 显示增加收款单界面                                |
| FinanceManagerMakeBillMainController.handleAddPayBillButtonAction | 语法   | public void handleAddPayBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击增加付款单按钮                                |
|                                          | 后置条件 | 显示增加付款单界面                                |
| FinanceManagerMakeBillMainController.handleAddCashCostBillButtonAction | 语法   | public void handleAddCashCostBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击增加现金费用单单按钮                             |
|                                          | 后置条件 | 显示增加现金费用单界面                              |





| 需要的服务(需接口) |      |
| ---------- | ---- |
| 模块         | 服务   |
| 无          |      |

表4.1.3(2)-7 FinanceManagerAddCashCostBillController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceManagerAddCashCostBillController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| FinanceManagerAddCashCostBillController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| FinanceManagerAddCashCostBillController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| FinanceManagerAddCashCostBillController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| FinanceManagerAddCashCostBillController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| FinanceManagerAddCashCostBillController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| FinanceManagerAddCashCostBillController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| FinanceManagerAddCashCostBillController.handleAddCashCostItemButtonAction | 语法   | public void handleAddCashCostItemButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击增加条目按钮                                 |
|                                          | 后置条件 | 在条目列表中增加一条条目                             |
| FinanceManagerAddCashCostBillController.handleClearConditionButtonAction | 语法   | public void handleClearConditionButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击清空条件按钮                                 |
|                                          | 后置条件 | 清空条目列表                                   |
| FinanceManagerAddCashCostBillController.handleBackToMakeBillMainButtonAction | 语法   | public void handleBackToMakeBillMainButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回制定单据主界面                                |
| FinanceManagerAddCashCostBillController.handleSaveCashCostBillButtonAction | 语法   | public void handleSaveCashCostBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击保存按钮                                   |
|                                          | 后置条件 | 保存当前制定的单据                                |
| FinanceManagerAddCashCostBillController.handleCommitCashCostBillButtonAction | 语法   | public void handleCommitCashCostBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击提交按钮                                   |
|                                          | 后置条件 | 提交当前制定的单据                                |





| 需要的服务(需接口)                       |          |
| -------------------------------- | -------- |
| 服务名                              | 服务       |
| loginController.getCurrentUser   | 获取当前登录用户 |
| accountBLService.searchAccount   | 搜索所有账户   |
| billBLService.saveCashCostBill   | 保存现金费用单  |
| billBLService.commitCashCostBill | 提交现金费用单  |



表4.1.3(2)-8 FinanceManagerAddPayBillController 的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceManagerAddPayBillController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| FinanceManagerAddPayBillController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| FinanceManagerAddPayBillController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| FinanceManagerAddPayBillController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| FinanceManagerAddPayBillController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| FinanceManagerAddPayBillController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| FinanceManagerAddPayBillController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| FinanceManagerAddPayBillController.handleAddFinanceItemButtonAction | 语法   | public void handleAddFinanceItemItemButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击增加条目按钮                                 |
|                                          | 后置条件 | 在条目列表中增加一条条目                             |
| FinanceManagerAddPayBillController.handleClearConditionButtonAction | 语法   | public void handleClearConditionButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击清空条件按钮                                 |
|                                          | 后置条件 | 清空条目列表                                   |
| FinanceManagerAddPayBillController.handleBackToMakeBillMainButtonAction | 语法   | public void handleBackToMakeBillMainButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回制定单据主界面                                |
| FinanceManagerAddPayBillController.handleSavePayBillButtonAction | 语法   | public void handleSavePayBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击保存按钮                                   |
|                                          | 后置条件 | 保存当前制定的单据                                |
| FinanceManagerAddPayBillController.handleCommitPayBillButtonAction | 语法   | public void handleCommitPayBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击提交按钮                                   |
|                                          | 后置条件 | 提交当前制定的单据                                |





| 需要的服务(需接口)                       |          |
| -------------------------------- | -------- |
| 服务名                              | 服务       |
| loginController.getCurrentUser   | 获取当前登录用户 |
| accountBLService.searchAccount   | 搜索所有账户   |
| customerBLService.searchCustomer | 搜索所有客户   |
| billBLService.saveFinanceBill    | 保存财务类单据  |
| billBLService.commitFinanceBill  | 提交财务类单据  |

表4.1.3(2)-9 FinanceManagerAddReceiveBillController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceManagerAddReceiveBillController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| FinanceManagerAddReceiveBillController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| FinanceManagerAddReceiveBillController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| FinanceManagerAddReceiveBillController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| FinanceManagerAddReceiveBillController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| FinanceManagerAddReceiveBillController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| FinanceManagerAddReceiveBillController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| FinanceManagerAddReceiveBillController.handleAddFinanceItemButtonAction | 语法   | public void handleAddFinanceItemItemButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击增加条目按钮                                 |
|                                          | 后置条件 | 在条目列表中增加一条条目                             |
| FinanceManagerAddReceiveBillController.handleClearConditionButtonAction | 语法   | public void handleClearConditionButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击清空条件按钮                                 |
|                                          | 后置条件 | 清空条目列表                                   |
| FinanceManagerAddReceiveBillController.handleBackToMakeBillMainButtonAction | 语法   | public void handleBackToMakeBillMainButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回制定单据主界面                                |
| FinanceManagerAddReceiveBillController.handleSaveReceiveBillButtonAction | 语法   | public void handleSaveReceiveBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击保存按钮                                   |
|                                          | 后置条件 | 保存当前制定的单据                                |
| FinanceManagerAddReceiveBillController.handleCommitReceiveBillButtonAction | 语法   | public void handleCommitReceiveBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击提交按钮                                   |
|                                          | 后置条件 | 提交当前制定的单据                                |





| 需要的服务(需接口)                       |          |
| -------------------------------- | -------- |
| 服务名                              | 服务       |
| loginController.getCurrentUser   | 获取当前登录用户 |
| accountBLService.searchAccount   | 搜索所有账户   |
| customerBLService.searchCustomer | 搜索所有客户   |
| billBLService.saveFinanceBill    | 保存财务类单据  |
| billBLService.commitFinanceBill  | 提交财务类单据  |

表4.1.3(2)-10 FinanceManagerSearchListController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceManagerSearchListController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| FinanceManagerSearchListController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| FinanceManagerSearchListController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| FinanceManagerSearchListController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| FinanceManagerSearchListController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| FinanceManagerSearchListController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| FinanceManagerSearchListController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| FinanceManagerAddReceiveBillController.ChooseTableType | 语法   | public void ChooseTableType(ActionEvent e); |
|                                          | 前置条件 | 选择一个报表类型                                 |
|                                          | 后置条件 | 设置界面组件是否可以填写                             |
| FinanceManagerAddReceiveBillController.handleClearButtonAction | 语法   | public void handleClearButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击清空条件按钮                                 |
|                                          | 后置条件 | 清空当前界面的筛选条件                              |
| FinanceManagerAddReceiveBillController.handleSearchButtonAction | 语法   | public void handleSearchButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击搜索报表按钮                                 |
|                                          | 后置条件 | 跳转到报表界面显示报表                              |
| FinanceManagerAddReceiveBillController.handleSearchButtonAction | 语法   | public void handleSearchButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击搜索报表按钮                                 |
|                                          | 后置条件 | 跳转到报表界面显示报表                              |



| 需要的服务(需接口)                        |          |
| --------------------------------- | -------- |
| 服务名                               | 服务       |
| loginController.getCurrentUser    | 获取当前登录用户 |
| tableBLService.checkSaleTable     | 查看销售明细表  |
| tableBLService.checkBusinessTable | 查看经营情况表  |
| tableBLService.checkProcessTable  | 查看经营历程表  |



表4.1.3(2)-11 FinanceManagerCreateGeneralAccountController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceManagerCreateGeneralAccountController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| FinanceManagerCreateGeneralAccountController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| FinanceManagerCreateGeneralAccountController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| FinanceManagerCreateGeneralAccountController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| FinanceManagerCreateGeneralAccountController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| FinanceManagerCreateGeneralAccountController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| FinanceManagerCreateGeneralAccountController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| FinanceManagerAddReceiveBillController.handleClearInfomationButtonAction | 语法   | public void handleClearInfomationButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击清空条件按钮                                 |
|                                          | 后置条件 | 清空当前用户填写的信息                              |
| FinanceManagerAddReceiveBillController.handleAddCommodityButtonAction | 语法   | public void handleAddCommodityButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击增加商品按钮                                 |
|                                          | 后置条件 | 商品列表中增加一个商品                              |
| FinanceManagerAddReceiveBillController.handleAddCustomerButtonAction | 语法   | public void handleAddCustomerButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击增加客户按钮                                 |
|                                          | 后置条件 | 客户列表中增加一个客户                              |
| FinanceManagerAddReceiveBillController.handleAddAccountButtonAction | 语法   | public void handleAddAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击增加账户按钮                                 |
|                                          | 后置条件 | 账户列表中增加一个账户                              |
| FinanceManagerAddReceiveBillController.handleCommitGeneralAccountButtonAction | 语法   | public void handleCommitGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击提交账目按钮                                 |
|                                          | 后置条件 | 期初建账数据中增加一条记录                            |



| 需要的服务(需接口)                               |          |
| ---------------------------------------- | -------- |
| 服务名                                      | 服务       |
| loginController.getCurrentUser           | 获取当前登录用户 |
| generalAccountBLService.searchCommodity  | 搜索商品     |
| generalAccountBLService.searchCusotmer   | 搜索对应的客户  |
| generalAccountBLService.searchAccount    | 搜索对应的账户  |
| generalAccountBLService.addGeneralAcocunt | 添加期初账户   |


表4.1.3(2)-12 FinanceManagerShowCashCostBillDetailController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceManagerShowCashCostBillDetailController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| FinanceManagerShowCashCostBillDetailController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| FinanceManagerShowCashCostBillDetailController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| FinanceManagerShowCashCostBillDetailController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| FinanceManagerShowCashCostBillDetailController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| FinanceManagerShowCashCostBillDetailController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| FinanceManagerShowCashCostBillDetailController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| FinanceManagerShowCashCostBillDetailController.ShowCashCostBillDetail | 语法   | public void ShowCashCostBillDetail(CashCostBillVO vo); |
|                                          | 前置条件 | 点击现金费用单详情按钮                              |
|                                          | 后置条件 | 显示当前现金费用单详情                              |
| FinanceManagerShowCashCostBillDetailController.HongChongAndCopy | 语法   | public void HongChongAndCopy(CashCostBillVO vo); |
|                                          | 前置条件 | 点击红冲并复制按钮                                |
|                                          | 后置条件 | 提示用户红冲操作完成                               |




| 需要的服务(需接口)                            |            |
| ------------------------------------- | ---------- |
| 服务名                                   | 服务         |
| loginController.getCurrentUser        | 获取当前登录用户   |
| financeBillBLService.HongChongAndCopy | 对当前单据红冲并复制 |



表4.1.3(2)-13 FinanceManagerShowFinanceBillDetailController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceManagerShowFinanceBillDetailController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| FinanceManagerShowFinanceBillDetailController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| FinanceManagerShowFinanceBillDetailController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| FinanceManagerShowFinanceBillDetailController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| FinanceManagerShowFinanceBillDetailController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| FinanceManagerShowFinanceBillDetailController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| FinanceManagerShowFinanceBillDetailController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| FinanceManagerShowFinanceBillDetailController.ShowFinanceBillDetail | 语法   | public void ShowFinanceBillDetail(FinanceBill vo); |
|                                          | 前置条件 | 点击财务类单据详情按钮                              |
|                                          | 后置条件 | 显示当前财务类单据详情                              |
| FinanceManagerShowFinanceBillDetailController.HongChongAndCopy | 语法   | public void HongChongAndCopy(FinanceBillVO vo); |
|                                          | 前置条件 | 点击红冲并复制按钮                                |
|                                          | 后置条件 | 提示用户红冲操作完成                               |




| 需要的服务(需接口)                            |            |
| ------------------------------------- | ---------- |
| 服务名                                   | 服务         |
| loginController.getCurrentUser        | 获取当前登录用户   |
| financeBillBLService.HongChongAndCopy | 对当前单据红冲并复制 |

表4.1.3(2)-14 FinanceManagerShowSalesInBillDetailController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceManagerShowSalesInBillDetailController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| FinanceManagerShowSalesInBillDetailController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| FinanceManagerShowSalesInBillDetailController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| FinanceManagerShowSalesInBillDetailController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| FinanceManagerShowSalesInBillDetailController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| FinanceManagerShowSalesInBillDetailController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| FinanceManagerShowSalesInBillDetailController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| FinanceManagerShowSalesInBillDetailController.ShowSalesInBillDetail | 语法   | public void ShowSalesInBillDetail(SalesInBill vo); |
|                                          | 前置条件 | 点击进货单单据详情按钮                              |
|                                          | 后置条件 | 显示当前进货单据详情                               |
| FinanceManagerShowSalesInBillDetailController.HongChongAndCopy | 语法   | public void HongChongAndCopy(SalesInBillVO vo); |
|                                          | 前置条件 | 点击红冲并复制按钮                                |
|                                          | 后置条件 | 提示用户红冲操作完成                               |




| 需要的服务(需接口)                            |            |
| ------------------------------------- | ---------- |
| 服务名                                   | 服务         |
| loginController.getCurrentUser        | 获取当前登录用户   |
| financeBillBLService.HongChongAndCopy | 对当前单据红冲并复制 |

表4.1.3(2)-15 FinanceManagerShowSalesOutBillDetailController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceManagerShowSalesOutBillDetailController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| FinanceManagerShowSalesOutBillDetailController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| FinanceManagerShowSalesOutBillDetailController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| FinanceManagerShowSalesOutBillDetailController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| FinanceManagerShowSalesOutBillDetailController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| FinanceManagerShowSalesOutBillDetailController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| FinanceManagerShowSalesOutBillDetailController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| FinanceManagerShowSalesOutBillDetailController.ShowSalesOutBillDetail | 语法   | public void ShowSalesOutBillDetail(SalesOutBill vo); |
|                                          | 前置条件 | 点击进货单单据详情按钮                              |
|                                          | 后置条件 | 显示当前进货单据详情                               |
| FinanceManagerShowSalesIOutBillDetailController.HongChongAndCopy | 语法   | public void HongChongAndCopy(SalesOutBillVO vo); |
|                                          | 前置条件 | 点击红冲并复制按钮                                |
|                                          | 后置条件 | 提示用户红冲操作完成                               |




| 需要的服务(需接口)                            |            |
| ------------------------------------- | ---------- |
| 服务名                                   | 服务         |
| loginController.getCurrentUser        | 获取当前登录用户   |
| financeBillBLService.HongChongAndCopy | 对当前单据红冲并复制 |

表4.1.3(2)-16 FinanceManagerShowStockBillDetailController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceManagerShowStockBillDetailController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| FinanceManagerShowStockBillDetailController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| FinanceManagerShowStockBillDetailController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| FinanceManagerShowStockBillDetailController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| FinanceManagerShowStockBillDetailController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| FinanceManagerShowStockBillDetailController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| FinanceManagerShowStockBillDetailController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| FinanceManagerShowStockBillDetailController.ShowStockBillDetail | 语法   | public void ShowStockBillDetail(StockBillVO vo); |
|                                          | 前置条件 | 点击进货单单据详情按钮                              |
|                                          | 后置条件 | 显示当前进货单据详情                               |
| FinanceManagerShowStockBillDetailController.HongChongAndCopy | 语法   | public void HongChongAndCopy(StockBillVO vo); |
|                                          | 前置条件 | 点击红冲并复制按钮                                |
|                                          | 后置条件 | 提示用户红冲操作完成                               |




| 需要的服务(需接口)                            |            |
| ------------------------------------- | ---------- |
| 服务名                                   | 服务         |
| loginController.getCurrentUser        | 获取当前登录用户   |
| financeBillBLService.HongChongAndCopy | 对当前单据红冲并复制 |

#### 4.1.4 chiefmanger模块

##### （1）整体结构

展示层的控制器为树状委托式结构，ChiefManagerMainViewController负责总经理界面的整体跳转，ChiefManagerSearchListController负责实现查看报表界面，ChiefManagerSearchSalesListController负责实现查看销售明细表界面，ChiefManagerSearchManageListController负责实现查看经营情况表界面，ChiefManagerSearchProcessListController负责实现查看经营情况表界面,ChiefManagerExamineBillController负责实现审批单据界面,ChiefManagerReadLogController负责实现查询日志界面，ChiefManagerSetPromotionController负责实现制定销售策略界面，ChiefManagerSearchPromotionListController负责实现查询促销策略界面,ChiefManagerShowCashCostBillDetail负责实现查看现金费用单详情界面，ChiefManagerShowFinanceBillDetail负责实现查看财务单详情界面，ChiefManagerShowSalesInBillDetail负责实现查看进货单详情界面，ChiefManagerShowSalesOutBillDetail负责实现查看销售单详情界面，ChiefManagerShowStockBillDetail负责实现查看库存类单据详情界面，

chiefManager界面各个类的职责如下表所示

| 模块                                       | 职责              |
| ---------------------------------------- | --------------- |
| ChiefManagerMainViewController           | 负责实现总经理界面的整体跳转  |
| ChiefManagerSearchListController         | 负责实现查看报表界面      |
| ChiefManagerSearchSalesListController    | 负责实现查看销售明细表界面   |
| ChiefManagerSearchManageListController   | 负责实现查看经营情况表界面   |
| ChiefManagerSearchProcessListController  | 负责实现查看经营历程表界面   |
| ChiefManagerExamineBillController        | 负责实现审批单据界面      |
| ChiefManagerReadLogController            | 负责实现查询日志界面      |
| ChiefManagerSetPromotionController       | 负责实现制定销售策略界面    |
| ChiefManagerSearchPromotionListController | 负责实现查询促销策略界面    |
| ChiefManagerShowCashCostBillDetail       | 负责实现查看现金费用单详情界面 |
| ChiefManagerShowFinanceBillDetail        | 负责实现查看财务单详情界面   |
| ChiefManagerShowSalesInBillDetail        | 负责实现查看进货单详情界面   |
| ChiefManagerShowSalesOutBillDetail       | 负责实现查看销售单详情界面   |
| ChiefManagerShowStockBillDetail          | 负责实现查看库存类单据详情界面 |


##### （2）模块内部类的接口规范

4.1.4(2)-1 ChiefManagerMainViewController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| ChiefManagerMainViewController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| ChiefManagerMainViewController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| ChiefManagerMainViewController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| ChiefManagerMainViewController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| ChiefManagerMainViewController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| ChiefManagerMainViewController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| ChiefManagerMainViewController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |


| 需要的服务（需接口）                               |           |                                 |
| 无                                        |           |                                 |



4.1.4(2)-2 ChiefManagerSearchListController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| ChiefManagerSearchListController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| ChiefManagerSearchListController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| ChiefManagerSearchListController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| ChiefManagerSearchListController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| ChiefManagerSearchListController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| ChiefManagerSearchListController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| ChiefManagerSearchListController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| ChiefManagerSearchListController.ChooseTableType | 语法   | public void ChooseTableType(ActionEvent e); |
|                                          | 前置条件 | 点击报表类型选择框                                |
|                                          | 后置条件 | 设置当前报表类型                                 |
| ChiefManagerSearchListController.handleClearButtonAction | 语法   | public void handleClearButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击清空条件按钮                                 |
|                                          | 后置条件 | 清空用户填写的条件                                |
| ChiefManagerSearchListController.handleSearchButtonAction | 语法   | public void handleSearchButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示报表内容                                   |






| 需要的服务(需接口)                        |          |
| --------------------------------- | -------- |
| 服务名                               | 服务       |
| loginController.getCurrentUser    | 获取当前登录用户 |
| tableBLService.checkSaleTable     | 查看销售明细表  |
| tableBLService.checkBusinessTable | 查看经营情况表  |
| tableBLService.checkProcessTable  | 查看经营历程表  |

4.1.4(2)-3 ChiefManagerSearchSalesListController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| ChiefManagerSearchSalesListController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| ChiefManagerSearchSalesListController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| ChiefManagerSearchSalesListController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| ChiefManagerSearchSalesListController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| ChiefManagerSearchSalesListController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| ChiefManagerSearchSalesListController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| ChiefManagerSearchSalesListController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| ChiefManagerSearchSalesListController.ShowSalesList | 语法   | public void ShowSalesList(SaleTableVO vo); |
|                                          | 前置条件 | 查找销售明细表                                  |
|                                          | 后置条件 | 显示符合条件的销售明细表                             |
| ChiefManagerSearchSalesListController.handleExportSalesListButtonAction | 语法   | public void handleExportSalesListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击导出报表按钮                                 |
|                                          | 后置条件 | 导出符合条件的销售明细表                             |
| ChiefManagerSearchSalesListController.handleBackToSearchListButtonAction(ActionEvent e) | 语法   | public void handleBackToSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击返回查看报表按钮                               |
|                                          | 后置条件 | 返回查看报表界面                                 |



| 需要的服务(需接口)                     |          |
| ------------------------------ | -------- |
| 服务名                            | 服务       |
| loginController.getCurrentUser | 获取当前登录用户 |
| tableBLService.exportSaleTable | 导出销售明细表  |

 4.1.4(2)-4 ChiefManagerSearchManageListController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| ChiefManagerSearchManageListController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| ChiefManagerSearchManageListController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| ChiefManagerSearchManageListController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| ChiefManagerSearchManageListController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| ChiefManagerSearchManageListController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| ChiefManagerSearchManageListController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| ChiefManagerSearchManageListController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| ChiefManagerSearchManageListController.ShowManageTable | 语法   | public void ShowManageTable(BusinessTableVO vo); |
|                                          | 前置条件 | 查找经营情况表                                  |
|                                          | 后置条件 | 显示符合条件的经营情况表                             |
| ChiefManagerSearchManageListController.handleExportManageListButtonAction | 语法   | public void handleExportManageListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击导出报表按钮                                 |
|                                          | 后置条件 | 导出符合条件的经营情况表                             |
| ChiefManagerSearchManageListController.handleBackToSearchListButtonAction(ActionEvent e) | 语法   | public void handleBackToSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击返回查看报表按钮                               |
|                                          | 后置条件 | 返回查看报表界面                                 |



| 需要的服务(需接口)                         |          |
| ---------------------------------- | -------- |
| 服务名                                | 服务       |
| loginController.getCurrentUser     | 获取当前登录用户 |
| tableBLService.exportBusinessTable | 导出经营情况表  |

4.1.4(2)-5 ChiefManagerSearchProcessListController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| ChiefManagerSearchProcessListController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| ChiefManagerSearchProcessListController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| ChiefManagerSearchProcessListController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| ChiefManagerSearchProcessListController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| ChiefManagerSearchProcessListController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| ChiefManagerSearchProcessListController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| ChiefManagerSearchProcessListController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| ChiefManagerSearchManageListController.showProcessTable | 语法   | public void showProcessTable(ProcessTableVO vo); |
|                                          | 前置条件 | 查找经营历程表                                  |
|                                          | 后置条件 | 显示符合条件的经营历程表                             |
| ChiefManagerSearchManageListController.handleExportProcessListButtonAction | 语法   | public void handleExportProcessListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击导出报表按钮                                 |
|                                          | 后置条件 | 导出符合条件的经营历程表                             |
| ChiefManagerSearchManageListController.handleBackToSearchListButtonAction(ActionEvent e) | 语法   | public void handleBackToSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击返回查看报表按钮                               |
|                                          | 后置条件 | 返回查看报表界面                                 |



| 需要的服务(需接口)                        |          |
| --------------------------------- | -------- |
| 服务名                               | 服务       |
| loginController.getCurrentUser    | 获取当前登录用户 |
| tableBLService.exportProcessTable | 导出经营历程表  |

4.1.4(2)-6 ChiefManagerExamineBillController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| ChiefManagerExamineBillController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| ChiefManagerExamineBillController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| ChiefManagerExamineBillController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| ChiefManagerExamineBillController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| ChiefManagerExamineBillController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| ChiefManagerExamineBillController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| ChiefManagerExamineBillController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| ChiefManagerSearchManageListController.ChooseBillType | 语法   | public void ChooseBillType(ActionEvent e); |
|                                          | 前置条件 | 选择单据类型                                   |
|                                          | 后置条件 | 确定审批单据类型                                 |




| 需要的服务(需接口)                               |             |
| ---------------------------------------- | ----------- |
| 服务名                                      | 服务          |
| loginController.getCurrentUser           | 获取当前登录用户    |
| managerBillService.getWaitingStockBill   | 获取待审批的库存单   |
| managerBillService.getWaitingSalesOutBill | 获取待审批的销售单   |
| managerBillService.getWaitingSalesInBill | 获取待审批的进货单   |
| managerBillService.getWaitingFinanceBill | 获取待审批的财务单   |
| managerBillService.getWaitingCashCostBill | 获取待审批的现金费用单 |
| managerBillService.approveStockBill      | 批准库存单       |
| managerBillService.approveSalesInBill    | 批准进货单       |
| managerBillService.approveSalesOutBill   | 批准销售单       |
| managerBillService.approveSalesFinanceBill | 批准财务单       |
| managerBillService.approveCashCostBill   | 批准现金费用单     |
| managerBillService.rejectStockBill       | 批准库存单       |
| managerBillService.rejectSalesInBill     | 批准进货单       |
| managerBillService.rejectSalesOutBill    | 批准销售单       |
| managerBillService.rejectSalesFinanceBill | 批准财务单       |
| managerBillService.rejectCashCostBill    | 批准现金费用单     |

4.1.4(2)-7 ChiefManagerReadLogController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| ChiefManagerReadLogController.initalize  | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| ChiefManagerReadLogController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| ChiefManagerReadLogController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| ChiefManagerReadLogController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| ChiefManagerReadLogController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| ChiefManagerReadLogController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| ChiefManagerReadLogController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| ChiefManagerReadLogController.handleSearchButtonAction | 语法   | public void handleSearchButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查询日志按钮                                 |
|                                          | 后置条件 | 显示选定日期内的日志                               |
| ChiefManagerReadLogController.handleClearButtonAction | 语法   | public void handleClearButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击清空按钮                                   |
|                                          | 后置条件 | 清空日志列表                                   |

| 需要的服务(需接口)                     |          |
| ------------------------------ | -------- |
| 服务名                            | 服务       |
| logBLService.timeSearchLog     | 根据日期搜索日志 |
| loginController.getCurrentUser | 获取当前登录用户 |




4.1.4(2)-8 ChiefManagerSetPromotionController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| ChiefManagerSetPromotionController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| ChiefManagerSetPromotionController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| ChiefManagerSetPromotionController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| ChiefManagerSetPromotionController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| ChiefManagerSetPromotionController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| ChiefManagerSetPromotionController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| ChiefManagerSetPromotionController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |
| ChiefManagerSetPromotionController.ChoosePromotionType | 语法   | public void ChoosePromotionType(ActionEvent e); |
|                                          | 前置条件 | 选择促销策略类型                                 |
|                                          | 后置条件 | 设定促销策略类型                                 |
| ChiefManagerSetPromotionController.handleConfirmPromotionButtonAction | 语法   | public void handleConfirmPromotionButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定策略按钮                                 |
|                                          | 后置条件 | 在数据库中加入制定的促销策略                           |
| ChiefManagerSetPromotionController.public void handleAddButtonButtonAction | 语法   | public void handleAddButtonButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击增加商品按钮                                 |
|                                          | 后置条件 | 在商品列表中加入商品                               |
| ChiefManagerSetPromotionController.public void handleClearConditionButtonAction | 语法   | public void handleClearConditionButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击清空条件按钮                                 |
|                                          | 后置条件 | 清空用户填写的条件                                |
| ChiefManagerSetPromotionController.public void handleSearchPromotionButtonAction | 语法   | public void handleSearchPromotionButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击促销策略按钮                                 |
|                                          | 后置条件 | 显示促销策略列表界面                               |


| 需要的服务(需接口)                              |           |
| --------------------------------------- | --------- |
| 服务名                                     | 服务        |
| loginController.getCurrentUser          | 获取当前登录用户  |
| promotionBLService.addCustomerPromotion | 增加分级促销策略  |
| promotionBLService.addGrossPromotion    | 增加总额促销策略  |
| promotionBLService.addGroupPromotion    | 增加特价包促销策略 |

4.1.4(2)-9 ChiefManagerSearchPromotionListController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| ChiefManagerSearchPromotionListController.initalize | 语法   | public void initialize(URL url, ResourceBundle rb); |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 初始化界面                                    |
| ChiefManagerSearchPromotionListController.handleSearchListButtonAction | 语法   | public void handleSearchListButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击查看报表按钮                                 |
|                                          | 后置条件 | 显示查看报表主界面                                |
| ChiefManagerSearchPromotionListController.handleMakeBillButtonAction | 语法   | public void handleMakeBillButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击制定单据按钮                                 |
|                                          | 后置条件 | 显示制定报表界面                                 |
| ChiefManagerSearchPromotionListController.handleSuperviseAccountButtonAction | 语法   | public void handleSuperviseAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击账户管理按钮                                 |
|                                          | 后置条件 | 显示账户管理界面                                 |
| ChiefManagerSearchPromotionListController.handleCreateGeneralAccountButtonAction | 语法   | public void handleCreateGeneralAccountButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击期初建账按钮                                 |
|                                          | 后置条件 | 显示期初建账界面                                 |
| ChiefManagerSearchPromotionListController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonActio(ActionEvent e); |
|                                          | 前置条件 | 点击返回登录界面按钮                               |
|                                          | 后置条件 | 显示登录界面                                   |
| ChiefManagerSearchPromotionListController.replaceSceneContent | 语法   | private Initializable replaceSceneContent(String fxml); |
|                                          | 前置条件 | 点击按钮                                     |
|                                          | 后置条件 | 显示跳转的界面                                  |

| ChiefManagerSetPromotionController.ChoosePromotionType| 语法   | public void ChoosePromotionType(ActionEvent e); |
|                                          | 前置条件 | 选择促销策略类型                                    |
|                                          | 后置条件 | 设定促销策略类型                                 |
| ChiefManagerSetPromotionController.handleBackToPromotionButtonAction| 语法   | public void handleBackToPromotionButtonAction(ActionEvent e) ; |
|                                          | 前置条件 | 点击返回制定促销策略按钮                                     |
|                                          | 后置条件 | 返回制定促销策略界面                                |


| 需要的服务(需接口)                               |             |
| ---------------------------------------- | ----------- |
| 服务名                                      | 服务          |
| loginController.getCurrentUser           | 获取当前登录用户    |
| promotionBLService.getAllCustomerPromotion(); | 获取所有分级促销策略  |
| promotionBLService.getALLGrossPromotion  | 获取所有总额促销策略  |
| promotionBLService.getAllGroupPromotion  | 获取所有特价包促销策略 |
| promotionBLService.deleteCustomerPromotion(); | 删除分级促销策略    |
| promotionBLService.deleteGrossPromotion  | 删除总额促销策略    |
| promotionBLService.deleteGroupPromotion  | 删除特价包促销策略   |

4.1.4(2)-10 ChiefManagerShowCashCostBillDetailController的接口规范
界面复用，见表4.1.3(2)-12 FinanceManagerShowCashCostBillDetailController的接口规范，不实现红冲和红冲和复制功能

4.1.4(2)-11 ChiefManagerShowFinanceBillDetailController的接口规范
界面复用，见表4.1.3(2)-13 FinanceManagerShowFinanceBillDetailController的接口规范

4.1.4(2)-12 ChiefManagerShowSalesInBillDetailController的接口规范
界面复用，见表4.1.3(2)-14 FinanceManagerShowSalesInBillDetailController的接口规范

4.1.4(2)-13 ChiefManagerShowSalesOutBillDetailController的接口规范
界面复用，见表4.1.3(2)-15 FinanceManagerShowSalesOutBillDetailController的接口规范

4.1.4(2)-14 ChiefManagerShowStockBillDetailController的接口规范
界面复用，见表4.1.3(2)-16 FinanceManagerShowStockBillDetailController的接口规范




#### 4.1.5 admin模块

##### （1）整体结构

展示层的控制器为树状委托式结构，AdminViewController负责对系统管理员界面的整体跳转，AdminNavBarController负责实现导航栏界面。

Admin界面各类的职责如表4.2.1(1)-1所示

表4.2.1(1)-1 Admin界面各类的职责

| 模块                            | 职责                   |
| ----------------------------- | -------------------- |
| AdminMainViewController       | 负责对系统管理员界面的整体跳转      |
| LoginController               | 负责实现登陆界面             |
| ModifyPasswordViewController  | 负责实现修改密码界面的跳转        |
| UserAddViewController         | 负责实现增加用户界面的跳转        |
| UserDelViewController         | 负责实现删除用户界面的跳转        |
| UserModifyViewController      | 负责实现修改用户界面的跳转        |
| UserModifyFirstViewController | 负责实现输入需要修改的用户编号界面的跳转 |
| UserSearchShowViewController  | 负责显示查找用户的结果显示界面      |
| UserSearchViewController      | 负责实现查找用户             |
| UserInfoModifyViewController  | 负责实现修改用户的弹出界面跳转      |
|                               |                      |
|                               |                      |

##### （2）模块内部类的接口规范

AdminMainViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| AdminMainViewController.addUserButtonAction | 语法   | public void addUserButtonAction(ActionEvent e); |
|                                          | 前置条件 | 点击导航栏增加用户                                |
|                                          | 后置条件 | 显示增加用户界面                                 |
| AdminmMainViewController.delUserButtonAction | 语法   | public void delUserButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击导航栏删除用户                                |
|                                          | 后置条件 | 显示删除用户界面                                 |
| AdminMainViewController.modUserButtonAction | 语法   | public void modUserButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击导航栏修改用户                                |
|                                          | 后置条件 | 显示修改用户界面                                 |
| AdminMainViewController.searchUserButtonAction | 语法   | public void searchUserButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击查找按钮                                   |
|                                          | 后置条件 | 显示查找用户结果界面                               |
| AdminMainViewController.handleBackToLoginButtonAction | 语法   | public void handleBackToLoginButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击登出按钮                                   |
|                                          | 后置条件 | 跳转登陆界面                                   |

需要的服务（需接口）

LoginController的接口规范

提供的服务（供接口）

| 服务名                                     | 服务   | 服务                                       |
| --------------------------------------- | ---- | ---------------------------------------- |
| LoginController.modPasswordButtonAction | 语法   | public void  modPasswordButtonAction(ActionEvent e) |
|                                         | 前置条件 | 点击修改密码按钮                                 |
|                                         | 后置条件 | 显示修改界面                                   |
| LoginController.getCurrentUser          | 语法   | public static UserVO getCurrentUser()    |
|                                         | 前置条件 | 无                                        |
|                                         | 后置条件 | 返回当前的登陆用户                                |
| LoginController.loginButtonAction       | 语法   | public void loginButtonAction(ActionEvent e) |
|                                         | 前置条件 | 点击登陆按钮                                   |
|                                         | 后置条件 | 登陆，跳转相应的主界面                              |
| LoginController.toStockSellerMain       | 语法   | public void toStockSellerMain()          |
|                                         | 前置条件 | 无                                        |
|                                         | 后置条件 | 跳转进货销售人员主界面                              |
| LoginController.toStockManagerMain      | 语法   | public void toStockManagerMain()         |
|                                         | 前置条件 | 无                                        |
|                                         | 后置条件 | 跳转库存管理人员主界面                              |
| LoginController.toFinanceManagerMain    | 语法   | public void ttoFinanceManagerMain()      |
|                                         | 前置条件 | 无                                        |
|                                         | 后置条件 | 跳转财务人员主界面                                |
| LoginController.toChiefManagerMain      | 语法   | public void toChiefManagerMain()         |
|                                         | 前置条件 | 无                                        |
|                                         | 后置条件 | 跳转总经理主界面                                 |
| LoginController.toAdminMain             | 语法   | public void toAdminMain()                |
|                                         | 前置条件 | 无                                        |
|                                         | 后置条件 | 跳转系统管理员主界面                               |



需要的服务（需接口）

| 服务名                          | 服务   |
| ---------------------------- | ---- |
| MainBLService.login          | 登陆   |
| UserBLService.searchUserByID | 获取用户 |
|                              |      |



UserAddViewController的接口规范

提供的服务（供接口）

| 服务名                                    | 服务   | 服务                                       |
| -------------------------------------- | ---- | ---------------------------------------- |
| UserAddViewController.cancelButton     | 语法   | public void cancelButttonAction(ActionEvent e) |
|                                        | 前置条件 | 点击取消按钮                                   |
|                                        | 后置条件 | 返回上一界面                                   |
| UserAddViewController.sureButtonAction | 语法   | public void sureButtonAction(ActionEvent e) |
|                                        | 前置条件 | 点击确定按钮                                   |
|                                        | 后置条件 | 增加用户                                     |

需要的服务（需接口）

| 服务名                   | 服务   |
| --------------------- | ---- |
| UserBLService.addUser | 增加用户 |
|                       |      |

UserDelViewController的接口规范

提供的服务（供接口）

| 服务名                                    | 服务   | 服务                                       |
| -------------------------------------- | ---- | ---------------------------------------- |
| UserDelViewController.cancelButton     | 语法   | public void cancelButttonAction(ActionEvent e) |
|                                        | 前置条件 | 点击取消按钮                                   |
|                                        | 后置条件 | 返回上一界面                                   |
| UserDelViewController.sureButtonAction | 语法   | public void sureButtonAction(ActionEvent e) |
|                                        | 前置条件 | 点击确定按钮                                   |
|                                        | 后置条件 | 删除用户                                     |

需要的服务（需接口）

| 服务名                   | 服务   |
| --------------------- | ---- |
| UserBLService.delUser | 删除用户 |
|                       |      |

表4.1.4(2)-5 UserSearchShowViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| UserSearchShowViewController.returnButtonAction | 语法   | public void ButttonAction(ActionEvent e) |
|                                          | 前置条件 | 点击取消按钮                                   |
|                                          | 后置条件 | 返回上一界面                                   |
| UserSearchShowViewController.sureButtonAction | 语法   | public void sureButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击确定按钮                                   |
|                                          | 后置条件 | 增加用户                                     |
| UserSearchShowViewController.refreshButtonAction | 语法   | public void refreshButtonAction(ActionEvent e) |
|                                          | 前置条件 | 点击刷新按钮                                   |
|                                          | 后置条件 | 刷新列表                                     |
| UserSearchShowViewController.showTableView | 语法   | public void showTableView()              |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 列表初始化                                    |

需要的服务（需接口）

| 服务名                            | 服务          |
| ------------------------------ | ----------- |
| UserBLService.searchUserByID   | 通过id查找用户    |
| UserBLService.searchUserByKind | 通过关键词类型查找用户 |

### 

### 4.2 业务逻辑层的分解

#### 4.2.1 UserBL模块

##### （1）模块描述

userbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

userbl模块的职责及接口参见软件体系结构设计文档

##### （2）整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加businesslogicservice.userblservice.UserBLService接口。业务逻辑层和数据层之间添加dataservice.UserDataService。为了隔离业务逻辑职责和逻辑控制职责，我们增加了UserBLServiceImpl，这样UserBLServiceImpl会将用户管理和登陆登出的业务逻辑委托给UserManage对象和UserLog对象。UserPO是作为用户的持久化对象被添加到设计模型中去的。UserVO是作为值对象被添加到设计模型中去的。

UserBL模块各个类的职责

| 模块                | 职责                             |
| ----------------- | ------------------------------ |
| UserBLServiceImpl | 管理 userbl 各个类的任务，负责与其他 bl 模块交互 |
| UserManage        | 负责对用户的增加、删除和修改操作               |
| UserLog           | 负责用户的登陆登出操作                    |

##### （3）模块内部类的接口规范

UserBLServiceImpl的接口规范如表4.2.1(3)-1所示

UserManage的接口规范如表4.2.1(3)-2所示

UserLog的接口规范如表4.2.1(3)-3所示

表4.2.1(3)-1 UserBLServiceImpl的接口规范

提供的服务（供接口）

| 服务名                          | 服务   | 服务                                       |
| ---------------------------- | ---- | ---------------------------------------- |
| UserBLServiceImpl.login      | 语法   | public Log_In_Out_Status login(String ID, String password) |
|                              | 前置条件 | 用户处于未登录状态                                |
|                              | 后置条件 | 用户登陆                                     |
| UserBLServiceImpl.logout     | 语法   | public Log_In_Out_Status logout(String ID) |
|                              | 前置条件 | 用户已登录                                    |
|                              | 后置条件 | 用户登出                                     |
| UserBLServiceImpl.addUser    | 语法   | public ResultMessage addUser(UserVO);    |
|                              | 前置条件 | 输入的信息符合规范                                |
|                              | 后置条件 | 增加用户                                     |
| UserBLServiceImpl.delUser    | 语法   | public ResultMessage delUser(String ID); |
|                              | 前置条件 | 输入的ID已存在                                 |
|                              | 后置条件 | 删除该用户                                    |
| UserBLServiceImpl.modifyUser | 语法   | public ResultMessage modifyUser(UserVO); |
|                              | 前置条件 | 输入的信息符合规范                                |
|                              | 后置条件 | 修改用户属性                                   |

需要的服务（需接口）

| 服务名                   | 服务   |
| --------------------- | ---- |
| UserManage.addUser    | 增加用户 |
| UserManage.delUser    | 删除用户 |
| UserManage.modifyUser | 修改用户 |
| UserLog.login         | 登陆   |
| UserLog.logout        | 登出   |

表4.2.1(3)-2 UserManage的接口规范

| 服务名                   | 服务   | 服务                                       |
| --------------------- | ---- | ---------------------------------------- |
| UserManage.addUser    | 语法   | public ResultMessage addUser(UserVO);    |
|                       | 前置条件 | 输入的信息符合规范                                |
|                       | 后置条件 | 增加用户                                     |
| UserManage.delUser    | 语法   | public ResultMessage delUser(String ID); |
|                       | 前置条件 | 输入的ID已存在                                 |
|                       | 后置条件 | 删除该用户                                    |
| UserManage.modifyUser | 语法   | public ResultMessage modifyUser(UserVO); |
|                       | 前置条件 | 输入的信息符合规范                                |
|                       | 后置条件 | 修改用户属性                                   |

需要的服务（需接口）

| 服务名                          | 服务   |
| ---------------------------- | ---- |
| UserBLServiceImpl.addUser    | 增加用户 |
| UserBLServiceImpl.delUser    | 删除用户 |
| UserBLServiceImpl.modifyUser | 修改用户 |

表4.2.1(3)-3 UserLog的接口规范

提供的服务（供接口）

| 服务名            | 服务   | 服务                                       |
| -------------- | ---- | ---------------------------------------- |
| UserLog.login  | 语法   | public Log_In_Out_Status login(String ID, String password) |
|                | 前置条件 | 用户处于未登录状态                                |
|                | 后置条件 | 用户登陆                                     |
| UserLog.logout | 语法   | public Log_In_Out_Status logout(String ID) |
|                | 前置条件 | 用户已登录                                    |
|                | 后置条件 | 用户登出                                     |

需要的服务（需接口）

| 服务名                      | 服务   |
| ------------------------ | ---- |
| UserBLServiceImpl.login  | 登陆   |
| UserBLServiceImpl.logout | 登出   |
|                          |      |

##### （4）业务逻辑层内部动态模型

增加用户顺序图

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%BF%9B%E8%B4%A7%E9%94%80%E5%94%AE%E4%BA%BA%E5%91%98/Admin-%E5%A2%9E%E5%8A%A0%E7%94%A8%E6%88%B7.png)

登陆顺序图

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%BF%9B%E8%B4%A7%E9%94%80%E5%94%AE%E4%BA%BA%E5%91%98/Admin_login.png)

# 详细设计模板

## BillBL

(1)模块描述

billbl模块承担的需求参见规格说明文档功能需求以及相关非功能需求

billbl模块的职责及接口参见软件系统结构描述文档

(2)整体结构

根据体系结构的设计，我们将系统分成了展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，比如展示层和逻辑层之间我们添加billblservice接口。业务逻辑层和数据层之间添加billdataservice接口，为了隔离业务逻辑职责和业务控制职责，我们增加了billController，这样billController会将对单据信息的逻辑处理委托给stockbill,salesinbill,salesoutbill,financebill对象，stockbillpo是作为库存类单据的持久化对象被添加到设计模型中，salesInbillpo是作为进货类单据的持久化对象被添加到设计模型中，salesoutbillpo是作为销售类单据的持久化对象被添加到设计模型中，financebillpo是作为财务类单据的持久化对象被添加到设计模型中，cashcostbillpo是作为现金费用单据的持久化对象被添加到设计模型中

bill模块的设计如图所示

| 模块             | 职责                         |
| -------------- | -------------------------- |
| billController | 负责管理bill各个类的任务，负责与其他模块进行交互 |
| stockbill      | 完成对库存类报表的保存提交撤回审批查看        |
| salesinbill    | 完成对进货类报表的保存提交撤回审批查看        |
| salesoutbill   | 完成对销售类报表的保存提交撤回审批查看        |
| financebill    | 完成对财务类报表的保存提交撤回审批查看        |
| cashcostbill   | 完成对现金费用单的保存提交撤回审批查看        |

(3) 模块内部类的接口规范

表一billcontroller

提供的服务 供接口

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| BillController.savestockbill             | 语法   | public ResultMessage savestockbill(StockBillVO stockBillVO) |
|                                          | 前置条件 | 保存库存单                                    |
|                                          | 后置条件 | 返回添加是否成功                                 |
| BillController.commitstockbill           | 语法   | public ResultMessage commitstockbill(StockBillVO stockBillVO) |
|                                          | 前置条件 | 提交库存单                                    |
|                                          | 后置条件 | 返回更新是否成功                                 |
| BillController.getMyStockBill            | 语法   | public ArrayList< StockBillVO> getMyStockBill(String operatorID) |
|                                          | 前置条件 | 搜索某人创建的库存单                               |
|                                          | 后置条件 | 返回符合条件的库存单                               |
| BillController.getWaitingStockBill       | 语法   | public ArrayList< StockBillVO> getWaitingStockBill(String operatorID) |
|                                          | 前置条件 | 总经理想要查看待审批的单据                            |
|                                          | 后置条件 | 返回需要审批的库存类单据                             |
| BillController.approveStockBill          | 语法   | public ResultMessage approveStockBill(StockBillVO stockBillVO) |
|                                          | 前置条件 | 总经理要审批通过单据                               |
|                                          | 后置条件 | 返回是否成功通过并更新相关信息                          |
| BillController.rejectStockBill           | 语法   | public ResultMessage rejectStockBill(StockBillVO stockBillVO) |
|                                          | 前置条件 | 总经理要拒绝某单据的通过                             |
|                                          | 后置条件 | 返回是否通过                                   |
| BillController.savesalesinbill           | 语法   | public ResultMessage savesalesinbill(SalesInBillVO salesinbillVO) |
|                                          | 前置条件 | 保存进货单                                    |
|                                          | 后置条件 | 返回是否保存成功                                 |
| BillController.commitsalesinbill         | 语法   | public ResultMessage commitsalesinbill(SalesInBillVO salesinbillVO) |
|                                          | 前置条件 | 更新进货单                                    |
|                                          | 后置条件 | 返回是否更新成功                                 |
| BillController.getMysalesinbill          | 语法   | public ArrayList< SalesInBillVO> getMySalesInBill(String operatorID) |
|                                          | 前置条件 | 得到某人创建的单据                                |
|                                          | 后置条件 | 返回某人创建的单据                                |
| BillController.getWaitingSalesInbill     | 语法   | public ArrayList< SalesInBillVO> getWaitingSalesInBill() |
|                                          | 前置条件 | 得到等待审批的单据                                |
|                                          | 后置条件 | 返回所有待审批的单据                               |
| BillController.approveSalesInbill        | 语法   | public ResultMessage approveSalesInBill(SalesInBillVO vo) |
|                                          | 前置条件 | 审批通过进货类单据                                |
|                                          | 后置条件 | 返回审批通过是否成功                               |
| BillController.rejectSalesInbill         | 语法   | public ResultMessage rejectSalesInBill(SalesInBillVO vo) |
|                                          | 前置条件 | 审批拒绝进货类单据                                |
|                                          | 后置条件 | 拒绝通过是否成功                                 |
| finiancebill,cashcostbill,salesoutbill形如以上接口不一一列举 |      |                                          |


需要的服务 需接口

| 服务名                                 | 服务             |
| ----------------------------------- | -------------- |
| stockbill.savestockbill             | 添加库存类单据        |
| stockbill.commitstockbill           | 更新库存类单据        |
| stockbill.getMystockbill            | 得到某人创建的所有单据    |
| stockbill.getWaitingStockBill       | 得到等待审批的库存类单据   |
| stockbill.approveStockBill          | 审批通过库存类单据      |
| StockBill.rejectStockBill           | 审批拒绝库存类单据      |
| salesinbill.savesalesinbill         | 添加进货类类单据       |
| salesinbill.commitsalesinbill       | 更新进货类单据        |
| salesinbill.getMysalesinbill        | 得到某人创建的所有进货类单据 |
| salesinbill.getWaitingsalesinbill   | 得到等待审批的进货类单据   |
| salesinbill.approvesalesinbill      | 审批通过进货类单据      |
| salesinbill.rejectsalesinbill       | 审批拒绝进货类单据      |
| salesoutbill.savesalesoutbill       | 添加销售类单据        |
| salesoutbill.commitsalesoutbill     | 更新销售类单据        |
| salesoutbill.getMysalesoutbill      | 得到某人创建的所有单据    |
| salesoutbill.getWaitingsalesoutbill | 得到等待审批的销售类单据   |
| salesoutbill.approvesalesoutbill    | 审批通过销售类单据      |
| salesoutbill.rejectsalesoutbill     | 审批拒绝销售类单据      |
| financebill.savefinancebill         | 添加财务类单据        |
| financebill.commitfinancebill       | 更新财务类单据        |
| financebill.getMyfinancebill        | 得到某人创建的所有单据    |
| financebill.getWaitingfinancebilll  | 得到等待审批的财务类单据   |
| financebill.approvefinancebill      | 审批通过财务类单据      |
| financebill.rejectfinancebill       | 审批拒绝财务类单据      |
| cashcostbill.savecashcostbilll      | 添加现金费用单据       |
| cashcostbill.commitcashcostbilll    | 更新现金费用单据       |
| cashcostbill.getMycashcostbill      | 得到某人创建的所有单据    |
| cashcostbill.getWaitingcashcostbill | 得到等待审批的现金费用类单据 |
| cashcostbill.approvecashcostbill    | 审批通过现金费用类单据    |
| cashcostbill.rejectcashcostbill     | 审批拒绝现金费用类单据    |

表二stockbill

提供的服务 供接口

参见billcontroller stockbill部分需接口

需要的服务 需接口

| 服务名                              | 服务     |
| -------------------------------- | ------ |
| stockdataservice.addstockbill    | 添加库存单据 |
| stockdataservice.updatestockbill | 更新库存单据 |
| stockdataservice.searchstockbill | 搜索库存单据 |
| stockdataservice.deletestockbill | 删除库存单据 |

表三 salesinbill

提供的服务 供接口

参见billcontroller salesinbill需接口

需要的服务 需接口

| 服务名                                     | 服务    |
| --------------------------------------- | ----- |
| billdataservice.addsaleinbill           | 添加进货单 |
| billdataservice.updatesalesinbill       | 更新进货单 |
| billdataservice.searchsalesinbill       | 搜索进货单 |
| billdataservice.delelesearchsalesinbill | 删除进货单 |



表四 salesoutbill

提供的服务 供接口

参见billcontroller salesout需接口部分

需要的服务 需接口

| 服务名                                | 服务    |
| ---------------------------------- | ----- |
| billdataservice.addsaleoutbill     | 添加售货单 |
| billdataservice.updatesalesoutbill | 更新售货单 |
| billdataservice.searchsalesoutbill | 搜素售货单 |
| billdataservice.deletesalesoutbill | 删除售货单 |

表五 financebill

提供的服务 供接口

参见billcontroller financebill需接口

需要的服务 需接口

| 服务名                               | 服务      |
| --------------------------------- | ------- |
| billdataservice.addfinancebill    | 添加财务类单据 |
| billdataservice.updatefinancebill | 更新财务类单据 |
| billdataservice.searchfinancebill | 搜索财务类单据 |
| billdataservice.deletefinancebill | 删除财务类单据 |

表六 cashcostbill

参见billcontroller cashcostbill需接口

需要的服务 需接口

| 服务名                                | 服务        |
| ---------------------------------- | --------- |
| billdataservice.addcashcostbill    | 添加现金费用类单据 |
| billdataservice.updatecashcostbill | 更新现金费用类单据 |
| billdataservice.searchcashcostbill | 搜索现金费用类单据 |
| billdataservice.deletecashcostbill | 删除现金费用类单据 |





## StockBL

(1)模块描述

stockbl模块承担的需求参见需求规格说明文档功能需求以及相关非功能需求

stockbl模块的职责及接口参见软件系统结构描述文档

(2) 整体结构

根据体系结构的设计，我们将系统分成展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，比如展示层和逻辑层之间，我们添加stockblservice接口。业务逻辑层和数据层之间添加stockdataservice接口。为了隔离业务逻辑职责和逻辑控制职责，我们增加了StockController，这样StockController会将对库存信息的逻辑处理委托给Stock和Inventory对象，stockPO是作为进出库记录的持久化对象被添加到设计模型中，inventoryPO是作为商品库存记录的持久化对象被添加到设计模型中CommodityInfo是根据依赖到导致原则，为了消除循环依赖而产生的接口。ChangeInfoVO是为了保存因订单变化而要进行的库存信息的更改

stock模块的设计如图所示

| 模块              | 职责                          |
| --------------- | --------------------------- |
| stockController | 管理stockbl各个类的任务，负责和其他bl模块交互 |
| stock           | 完成对商品进出库信息的增查               |
| inventory       | 完成对商品库存相关信息的增改查             |
|                 |                             |

(3) 模块内部类的接口规范

表一stockController

提供的接口 供接口

| 服务名                                     | 服务   |                                          |
| --------------------------------------- | ---- | ---------------------------------------- |
| StockController.viewStock               | 语法   | public ArrayList< StockVO> viewStock(Date startTime, Date endTime); |
|                                         | 前置条件 | 想要查看进出库数据                                |
|                                         | 后置条件 | 返回进出库信息，若无则返回空                           |
| StockController.checkInventory          | 语法   | public ArrayList< InventoryVO> checkInventory() |
|                                         | 前置条件 | 要进行库存盘点                                  |
|                                         | 后置条件 | 返回商品库存信息列表若无则返回空                         |
| StockController.updateStockAndInventory | 语法   | public ResultMessage updateStock(ChangeInfoVO changeInvo) |
|                                         | 前置条件 | 更新库存信息                                   |
|                                         | 后置条件 | 返回更新是否成功                                 |
|                                         |      |                                          |

需要的接口 需接口

| 服务名                          | 服务       |
| ---------------------------- | -------- |
| Stock.addStock               | 增加进出库信息  |
| Stock.viewStock              | 查看出入库信息  |
| Inventory.updateInventory    | 更新商品库存信息 |
| CommodityInfo.updateComodity | 更新商品信息   |
|                              |          |
|                              |          |



表二stock的接口规范

提供的接口 供接口

| 服务名             | 服务   |                                          |
| --------------- | ---- | ---------------------------------------- |
| Stock.addStock  | 语法   | public ResultMessage addStock(ChangeInfoVO vo) |
|                 | 前置条件 | 想要添加进出库记录                                |
|                 | 后置条件 | 返回是否成功添加                                 |
| Stock.viewStock | 语法   | public ArrayList< StockVO> viewStock(Date start,Date end) |
|                 | 前置条件 | 想要查看库存                                   |
|                 | 后置条件 |                                          |
|                 |      |                                          |

需要的接口 需接口

| 服务名                          | 服务      |
| ---------------------------- | ------- |
| stockdataservice.addStock    | 添加出入库信息 |
| stockdataservice.searchStock | 搜索库存信息  |
|                              |         |
|                              |         |
|                              |         |

表三 inventory

提供的服务 供接口

| 服务名                       | 服务   |                                          |
| ------------------------- | ---- | ---------------------------------------- |
| inventory.updateInventory | 语法   | public ResultMessage updateInventory(ChangeInfoVO vo) |
|                           | 前置条件 |                                          |
|                           | 后置条件 |                                          |
| inventory.checkInventory  | 语法   | public ArrayList< InventoryVO> checkInventory() |
|                           | 前置条件 |                                          |
|                           | 后置条件 |                                          |

需要的服务 需接口

| 服务名                              | 服务       |
| -------------------------------- | -------- |
| stockdataservice.updateInventory | 更新库存信息   |
| stockdataservice.searchInventory | 搜索商品库存信息 |
|                                  |          |
|                                  |          |
|                                  |          |



(4) 业务逻辑层内部动态模型

## CommodityBL

(1)模块描述

commoditybl模块承担的需求参见需求规格说明文档功能需求以及相关非功能需求

stockbl模块的职责及接口参见软件系统结构描述文档

(2) 整体结构

根据体系结构的设计，我们将系统分成展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，比如展示层和逻辑层之间，我们添加commodityblservice接口。业务逻辑层和数据层之间添加commoditydatablservice接口。为了隔离业务逻辑职责和逻辑控制职责，我们增加了commodityController，这样commodityController会将对商品信息的逻辑处理委托给commodity和classification对象，commodityPO是作为商品信息的持久化对象被添加到设计模型中，classificationPO是作为商品分类的信息的持久化对象被添加到设计模型中的。ClassificationVO、commodityVO和FilterFlagsVO是作为携带商品信息的有价值对象被添加到设计模型中去的。

commodity模块的设计如图所示

| 模块                            | 职责                              |
| ----------------------------- | ------------------------------- |
| CommodityController           | 管理commoditybl各个类的任务，负责和其他bl模块交互 |
| Commodity                     | 完成对商品信息的增删改查等任务                 |
| Classification                | 完成对商品分类信息的增删改查等任务               |
| BuyPriceAscendingComparator   | 进价升序排序器                         |
| BuyPriceDescendingComparator  | 进价降序排序器                         |
| StockAscendingComparator      | 库存数量升序排序器                       |
| StockDescendingComparator     | 库存数量降序排序器                       |
| SellPriceAscendingComparator  | 售价升序排序器                         |
| SellPriceDescendingComparator | 售价降序排序器                         |
| ToolKit                       | 工具类                             |

(3) 模块内部类的接口规范

表1 CommodityComtroller

**提供的服务 （供接口）**

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CommodityController.searchCommodity      | 语法   | public ArrayList< CommodityVO > searchCommodity(FilterFlagsVO flags) |
|                                          | 前置条件 | 用户选择合法的筛选条件                              |
|                                          | 后置条件 | 返回符合筛选条件的商品列表，如果没有符合条件的酒店，则返回空列表         |
| CommodityController.getCommodity         | 语法   | public CommodityVO getCommodity(String id) |
|                                          | 前置条件 | 用户输入正确的商品编号                              |
|                                          | 后置条件 | 返回用户指定的商品信息                              |
| CommodityController.getClassification    | 语法   | public ClassificationVO getClassification(String id) |
|                                          | 前置条件 | 用户输入正确的商品分类编号                            |
|                                          | 后置条件 | 返回用户指定的商品分类信息                            |
| CommodityController.addCommodity         | 语法   | public ResultMessage addCommodity(CommodityVO commodity_vo) |
|                                          | 前置条件 | 库存管理人员添加商品信息                             |
|                                          | 后置条件 | 返回添加成功与否                                 |
| CommodityController.addClassification    | 语法   | public ResultMessage addClassification(ClassificationVO classification_vo) |
|                                          | 前置条件 | 库存管理人员添加商品分类信息                           |
|                                          | 后置条件 | 返回添加成功与否                                 |
| CommodityController.updateCommodity      | 语法   | public ResultMessage updateCommodity(CommodityVO commodity_vo ) |
|                                          | 前置条件 | 更新商品信息                                   |
|                                          | 后置条件 | 返回更新成功与否                                 |
| CommodityController.updateClassification | 语法   | public ResultMessage updateClassification(ClassificationVO classification_vo) |
|                                          | 前置条件 | 用户要更新商品分类                                |
|                                          | 后置条件 | 返回更新成功与否                                 |
| CommodityController.deleteCommodity      | 语法   | public ResultMessage deleteCommodity(String commodity_id) |
|                                          | 前置条件 | 库存管理人员输入商品编号合法                           |
|                                          | 后置条件 | 返回删除成功与否                                 |
| CommodityController.deleteClassification | 语法   | public ResultMessage deleteClassification(String id) |
|                                          | 前置条件 | 库存管理人员输入商品分类编号合法                         |
|                                          | 后置条件 | 返回删除成功与否                                 |
| CommodityController.BuyPriceAscendingSort | 语法   | public Iterator< CommodityVO > buyPriceAscendingSort(ArrayList< CommodityVO> commodityVOs) |
|                                          | 前置条件 | 搜索得到结果                                   |
|                                          | 后置条件 | 无                                        |
| CommodityController.BuyPriceDescendingSort | 语法   | public Iterator < CommodityVO > buyPriceDesendingSort(ArrayList< CommodityVO > commodityVOs) |
|                                          | 前置条件 | 搜索得到结果                                   |
|                                          | 后置条件 | 无                                        |
| CommodityController.StockAscendingSort   | 语法   | public Iterator< CommodityVO> stockAscendingSort(ArrayList< CommodityVO commodityVOs) |
|                                          | 前置条件 | 搜索得到结果                                   |
|                                          | 后置条件 | 无                                        |
| CommodityController.StockDescendingSort  | 语法   | public Iterator< CommodityVO> stockDescending(ArrayList< CommodityVO> commodityVOs) |
|                                          | 前置条件 | 搜索得到结果                                   |
|                                          | 后置条件 | 无                                        |
| CommodityController.SellAscendingSort    | 语法   | public Iterator< CommodityVO> sellAsendingSort(ArrayList< CommodityVO> commodityVOs) |
|                                          | 前置条件 | 搜索得到结果                                   |
|                                          | 后置条件 | 无                                        |
| CommodityController.SellDescendingSort   | 语法   | public Iterator< CommodityVO> sellDescendingSort(ArrayList< CommodityVO> commodityVOs) |
|                                          | 前置条件 | 搜索得到结果                                   |
|                                          | 后置条件 | 无                                        |
| CommodityController.getAllClassifications | 语法   | public ArrayList< ClassificationVO> getAllClassifications |
|                                          | 前置条件 | 搜索得到结果                                   |
|                                          | 后置条件 | 返回所有的商品分类信息                              |
| CommodityController.searchClassification | 语法   | public ArrayList< ClassificationVO> searchClassification(FilterFlags flags) |
|                                          | 前置条件 | 搜索得到结果                                   |
|                                          | 后置条件 | 返回符合条件的商品分类                              |

**需要的服务（需接口）**

| 服务名                                  | 服务           |
| ------------------------------------ | ------------ |
| Commodity.SearchCommodity            | 搜索符合条件的商品列表  |
| Commodity.getCommodity               | 通过ID得到商品信息   |
| Commodity.addCommodity               | 增加商品         |
| Commodity.updateCommodity            | 更新商品信息       |
| Commodity.deleteCommodity            | 删除商品         |
| Commodity.BuyPriceAscendingSort      | 根据商品进价升序排列商品 |
| Commodity.BuyPriceDescendingSort     | 根据商品进价降序排列商品 |
| Commodity.SellPriceAscendingSort     | 根据商品售价升序排列商品 |
| Commodity.SellPriceDescendingSort    | 根据商品售价降序排列商品 |
| Commodity.StockAscendingSort         | 根据商品库存升序排列商品 |
| Commodity.StockDescendingSort        | 根据商品库存降序排列商品 |
| Classification.addClassification     | 添加商品分类       |
| Classification.updateClassification  | 更新商品分类       |
| Classification.deleteClassification  | 删除商品分类       |
| Classification.getClassification     | 得到商品分类信息     |
| Classification.getAllClassifications | 得到所有的商品分类    |
| Classifiction.SearchClassificaions   | 搜索商品分类       |
|                                      |              |
|                                      |              |

表2classification的接口规范

**提供的服务（供接口）**

| 服务名                                 | 服务   |                                          |
| ----------------------------------- | ---- | ---------------------------------------- |
| Classification.addClassification    | 语法   | public ResultMessage addClassification(ClassificationVO classification_vo) |
|                                     | 前置条件 | 添加商品分类                                   |
|                                     | 后置条件 | 返回添加成功与否                                 |
| Classification.updateClassification | 语法   | public ResultMessage updateClassification(ClassificationVO classification_vo) |
|                                     | 前置条件 | 输入正确的商品分类信息                              |
|                                     | 后置条件 | 返回更新成功与否                                 |
| Classification.deleteClassification | 语法   | public ResultMessage deleteClassification(String id) |
|                                     | 前置条件 | 输入正确的商品分类信息                              |
|                                     | 后置条件 | 返回删除成功与否                                 |
| Classification.getClassification    | 语法   | public ClassificationVO getClassification(ClassificationVO classification_vo) |
|                                     | 前置条件 | 输入正确的商品分类编号信息                            |
|                                     | 后置条件 | 返回得到的商品信息                                |
| Classification.searchClassification | 语法   | public ArrayList< ClassificationVO> searchClassification(FilterFlags flagers) |
|                                     | 前置条件 | 输入正确的搜索标志                                |
|                                     | 后置条件 | 返回符合条件的商品分类信息                            |
| Classification.getAllClassification | 语法   | public ArrayList< ClassificationVO> getAllClassifications |
|                                     | 前置条件 | 无                                        |
|                                     | 后置条件 | 返回所有的商品分类信息                              |
|                                     |      |                                          |

**需要的服务（需接口）**

| 服务名                                      | 服务         |
| ---------------------------------------- | ---------- |
| CommodityDataService.getClassification   | 得到商品分类信息   |
| CommodityDataService.addClassification   | 添加商品分类信息   |
| CommodityDataService.updateClassification | 更新商品分类信息   |
| CommodityDataService.deleteClassification | 删除商品分类信息   |
| CommodityDataService.exactlySearchClassification | 精确搜索商品分类   |
| CommodityDataService.prefixSearchClassification | 前缀匹配搜索商品分类 |
| CommodityDataService.fullSearchClassification | 完全匹配搜索商品分类 |
| CommodityDataService.getAllClassifications | 得到所有的商品分类  |
|                                          |            |

表3 commodity的接口规范

| 服务名                               | 服务   | 服务                                       |
| --------------------------------- | ---- | ---------------------------------------- |
| Commodity.addCommodity            | 语法   | public ResultMessage addCommodity(CommodityVO commodity_vo) |
|                                   | 前置条件 | 输入了正确的商品信息                               |
|                                   | 后置条件 | 返回添加成功与否                                 |
| Commodity.deleteCommodity         | 语法   | public ResultMessage deleteCommodity(String id) |
|                                   | 前置条件 | 输入正确的商品编号                                |
|                                   | 后置条件 | 返回删除成功与否                                 |
| Commodity.updateCommodity         | 语法   | public ResultMessage updateCommodity(CommodityVO commodity_vo) |
|                                   | 前置条件 | 输入了正确的商品信息                               |
|                                   | 后置条件 | 返回更新成功与否                                 |
| Commodity.getCommodity            | 语法   | public CommodityVO getCommodity(String id) |
|                                   | 前置条件 | 输入正确的商品编号                                |
|                                   | 后置条件 | 返回商品信息                                   |
| Commodity.searchCommodity         | 语法   | public ArrayList< CommodityVO> searchCommodity(FilterFlag flags) |
|                                   | 前置条件 | 输入正确的搜索标志                                |
|                                   | 后置条件 | 返回满足条件的商品信息                              |
| Commodity.BuyPriceAscendingSort   | 语法   | public ArrayList< CommodityVO> BuyPriceAscendingSort(ArrayList< CommodityVO> vos) |
|                                   | 前置条件 | 搜索商品得到结果                                 |
|                                   | 后置条件 | 无                                        |
| Commodity.BuyPriceDescendingSort  | 语法   | public ArrayList< CommodityVO> BuyPriceDescendingSort(ArrayList< CommodityVO> vos) |
|                                   | 前置条件 | 搜索商品得到结果                                 |
|                                   | 后置条件 | 无                                        |
| Commodity.SellPriceAscendingSort  | 语法   | public ArrayList< CommodityVO> sellPriceAsendingSort(ArrayList< CommodityVO> vos) |
|                                   | 前置条件 | 搜索商品得到结果                                 |
|                                   | 后置条件 | 无                                        |
| Commodity.SellPriceDescendingSort | 语法   | public ArrayList< CommodityVO> sellPriceDesendingSort(ArrayList< CommodityVO> vos) |
|                                   | 前置条件 | 搜索商品得到结果                                 |
|                                   | 后置条件 | 无                                        |
| Commodity.StockAscendingSort      | 语法   | public ArrayList< CommodityVO> StockAscendingSort(ArrayList< CommodityVO> vos) |
|                                   | 前置条件 | 搜索商品得到结果                                 |
|                                   | 后置条件 | 无                                        |
| Commodity.StockDescendingSort     | 语法   | public ArrayList< CommodityVO> StockDescendingSort(ArrayList< CommodityVO> vos) |
|                                   | 前置条件 | 搜索商品得到结果                                 |
|                                   | 后置条件 | 无                                        |



**需要的服务（需接口）**

| 服务名                                      | 服务         |
| ---------------------------------------- | ---------- |
| CommodityDataService.exactlySearchCommodity | 精确搜索商品     |
| CommodityDataService.prefixSearchCommodity | 前缀匹配搜索商品   |
| CommodityDataService.fullSearchCommodity | 完全匹配搜索商品   |
| CommodityDataService.fuzzySearchCommodity | 模糊搜索匹配商品   |
| CommodityDataService.rangeSearchCommodity | 范围搜索商品     |
| CommodityDataService.mulitySearchCommodity | 多条件搜索商品    |
| CommodityDataService.getCommodity        | 通过商品id得到商品 |
| CommodityDataService.addCommodity        | 添加商品       |
| CommodityDataService.updateCommodity     | 更新商品信息     |
| CommodityDataService.delteCommodity      | 删除商品       |

表4 BuyPriceAscendingComparator的接口规范

**提供的服务（供接口）**

| 服务名                                 | 服务   |                                          |
| ----------------------------------- | ---- | ---------------------------------------- |
| BuyPriceAscendingComparator.compare | 语法   | public int compare(CommodityVO o1,CommodityVO o2); |
|                                     | 前置条件 | 通过搜索得到商品列表                               |
|                                     | 后置条件 | 无                                        |

**需要的服务（需接口）**

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |

表5 BuyPriceDescendingComparator的接口规范

**提供的服务（供接口）**

| 服务名                                  | 服务   |                                          |
| ------------------------------------ | ---- | ---------------------------------------- |
| BuyPriceDescendingComparator.compare | 语法   | public int compare(CommodityVO o1,CommodityVO o2); |
|                                      | 前置条件 | 通过搜索得到商品列表                               |
|                                      | 后置条件 | 无                                        |

**需要的服务（需接口）**

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |

表6 SellPriceAscendingComparator的接口规范

**提供的服务（供接口）**

| 服务名                                  | 服务   |                                          |
| ------------------------------------ | ---- | ---------------------------------------- |
| SellPriceAscendingComparator.compare | 语法   | public int compare(CommodityVO o1,CommodityVO o2); |
|                                      | 前置条件 | 通过搜索得到商品列表                               |
|                                      | 后置条件 | 无                                        |

**需要的服务（需接口)**

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |

表7 SellPriceDescendingComparator的接口规范

**提供的服务（供接口）**

| 服务名                                 | 服务   |                                          |
| ----------------------------------- | ---- | ---------------------------------------- |
| BuyPriceAscendingComparator.compare | 语法   | public int compare(CommodityVO o1,CommodityVO o2); |
|                                     | 前置条件 | 通过搜索得到商品列表                               |
|                                     | 后置条件 | 无                                        |



**需要的服务（需接口）**

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |

表8 StockAscendingComparator的接口规范

**提供的服务（供接口）**

| 服务名                              | 服务   |                                          |
| -------------------------------- | ---- | ---------------------------------------- |
| StockAscendingComparator.compare | 语法   | public int compare(CommodityVO o1,CommodityVO o2); |
|                                  | 前置条件 | 通过搜索得到商品列表                               |
|                                  | 后置条件 | 无                                        |



**需要的服务（需接口）**

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |

表9 StockDescendingComparator的接口规范

**提供的服务（供接口）**

| 服务名                               | 服务   |                                          |
| --------------------------------- | ---- | ---------------------------------------- |
| StockDescendingComparator.compare | 语法   | public int compare(CommodityVO o1,CommodityVO o2); |
|                                   | 前置条件 | 通过搜索得到商品列表                               |
|                                   | 后置条件 | 无                                        |



**需要的服务（需接口）**

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |



表10 ToolKit的接口规范

**提供的服务（供接口）**

| 服务名                | 服务   |                                          |
| ------------------ | ---- | ---------------------------------------- |
| ToolKit.generateID | 语法   | public static String generateID(String id, int number) |
|                    | 前置条件 | 无                                        |
|                    | 后置条件 | 无                                        |



**需要的服务（需接口）**

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |

(4) 业务逻辑层内部动态模型

#### 4.2.5 AccountBL模块

##### （1）模块描述

accountbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

accountbl模块的职责及接口参见软件体系结构设计文档

 ##### （2）整体结构

AccountBL模块主要负责账户管理功能需求的逻辑实现，其中Account为主模块，负责主要逻辑的生成以及对辅助类和功能类的调度，但为了降低耦合，Account不与DataService模块交互，而是AccountInfoFactory与DataService交互，来生成具体的VO并且向数据层传输数据，此外，还拥有AccountSorter类来负责AccountBL类的数据的排序

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/Account%E6%A8%A1%E5%9D%97.png)


AccountBL模块的类的功能如下表所示

| 模块                   | 职责                         |
| -------------------- | -------------------------- |
| AccountBLServiceImpl | 账户管理接口的具体实现                |
| Account              | AccountBL主要逻辑类，实现增删改查等主要功能 |
| AccountComparator    | 功能类，用来排序Account            |
| AccountInfoFactory   | 信息辅助类，完成PO与VO转换并且获得数据      |

##### （3）模块内部类的接口规范

Account的接口规范

| 提供的服务（供接口）                          |      |                                          |
| ----------------------------------- | ---- | ---------------------------------------- |
| AccountBLServiceImpl.addAccount     | 语法   | public ResultMessage addAccount（AccountVO account) |
|                                     | 前置条件 | account.name不能与之前的重复                     |
|                                     | 后置条件 | 无                                        |
| AccountBLServiceImpl.deleteAccount  | 语法   | public ResultMessage deleteAccount（string name) |
|                                     | 前置条件 | name必须已经存在的账户列表中                         |
|                                     | 后置条件 | 无                                        |
| AccountBLServiceImpl.modifyAccount  | 语法   | public ResultMessage modifyAccount（string oldname,string newname) |
|                                     | 前置条件 | oldname已经存在于账号列表中而newname不存在于账户列表中       |
|                                     | 后置条件 | 无                                        |
| AccountBLServiceImpl.checkAccount   | 语法   | public AccountVO checkAccount(String name) |
|                                     | 前置条件 | name已经存在于账户列表中                           |
|                                     | 后置条件 | 返回已经写入账户信息（具体参见Account类说明表）的Account      |
| AccountBLServiceImpl.income         | 语法   | public void income(String name, int income) |
|                                     | 前置条件 | 无                                        |
|                                     | 后置条件 | 无                                        |
| AccountBLServiceImpl.pay            | 语法   | public void pay(String name,int pay)     |
|                                     | 前置条件 | 无                                        |
|                                     | 后置条件 | 无                                        |
| AccountBLServiceImpl.compareByName  | 语法   | public ArrayList<AccountVO> compareByName(ArrayList<AccountVO> account) |
|                                     | 前置条件 | 无                                        |
|                                     | 后置条件 | 返回按姓名字典序排序的账户列表                          |
| AccountBLServiceImpl.compareByMoney | 语法   | public ArrayList<AccountVO> compareByMoney(ArrayList<AccountVO> account) |
|                                     | 前置条件 | 无                                        |
|                                     | 后置条件 | 返回按金额从小到大的排序的账户列表                        |

需要的服务(需接口)

| 服务名                                   | 服务                |
| ------------------------------------- | ----------------- |
| Account.pay                           | 账户付款，调整金额         |
| Account.income                        | 账户收款，调整金额         |
| Account.addAccount                    | 增加账户至数据库          |
| Account.deleteAccount                 | 删除数据库中的账户         |
| Account.modifyAccount                 | 修改数据库中的账户         |
| Account.checkAccount                  | 搜索数据库中的账户         |
| AccountComparator.NameAlphabetOrder   | 返回按姓名字典序排序的账户列表   |
| AccountComparator.MoneyFromBigToSmall | 返回按金额从小到大的排序的账户列表 |

提供的服务(供接口)

Account的接口规范

| 提供的服务（供接口）            |      |                                          |
| --------------------- | ---- | ---------------------------------------- |
| Account.addAccount    | 语法   | public ResultMessage addAccount（AccountVO account) |
|                       | 前置条件 | account.name不能与之前的重复                     |
|                       | 后置条件 | 无                                        |
| Account.deleteAccount | 语法   | public ResultMessage deleteAccount（string name) |
|                       | 前置条件 | name必须已经存在的账户列表中                         |
|                       | 后置条件 | 无                                        |
| Account.modifyAccount | 语法   | public ResultMessage modifyAccount（string oldname,string newname) |
|                       | 前置条件 | oldname已经存在于账号列表中而newname不存在于账户列表中       |
|                       | 后置条件 | 无                                        |
| Account.checkAccount  | 语法   | public AccountVO checkAccount(String name) |
|                       | 前置条件 | name已经存在于账户列表中                           |
|                       | 后置条件 | 返回已经写入账户信息（具体参见Account类说明表）的Account      |
| Account.income        | 语法   | public void income(String name, int income) |
|                       | 前置条件 | 无                                        |
|                       | 后置条件 | 无                                        |
| Account.pay           | 语法   | public void pay(String name,int pay)     |
|                       | 前置条件 | 无                                        |
|                       | 后置条件 | 无                                        |

需要的服务(需接口)

| 服务名                              | 服务        |
| -------------------------------- | --------- |
| AccountInfoFactory.pay           | 账户付款，调整金额 |
| AccountInfoFactory.income        | 账户收款，调整金额 |
| AccountInfoFactory.addAccount    | 增加账户至数据库  |
| AccountInfoFactory.deleteAccount | 删除数据库中的账户 |
| AccountInfoFactory.modifyAccount | 修改数据库中的账户 |
| AccountInfoFactory.checkAccount  | 搜索数据库中的账户 |

提供的服务(供接口)

| 服务名                                   |      | 服务                                       |
| ------------------------------------- | ---- | ---------------------------------------- |
| AccountComparator.NameAlphabetOrder   | 语法   | public ArrayList<AccountVO>  NameAlphabetOrder(ArrayList<AccountVO> list) |
|                                       | 前置条件 | 无                                        |
|                                       | 后置条件 | 返回排列好的列表，若参数列表为空，则返回空                    |
| AccountComparator.MoneyFromBigToSmall | 语法   | public ArrayList<AccountVO>  MoneyFromBigToSmall(ArrayList<AccountVO> account) |
|                                       | 前置条件 | 无                                        |
|                                       | 后置条件 | 返回排列好的列表，若参数列表为空，则返回空                    |
| AccountComparator.MoneyFromSmallToBig | 语法   | public ArrayList<AccountVO>  MoneyFromSmallToBig(ArrayList<AccountVO> account) |
|                                       | 前置条件 | 无                                        |
|                                       | 后置条件 | 返回排列好的列表，若参数列表为空，则返回空                    |

需要的服务(需接口)

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |

提供的服务(供接口)

| 提供的服务（供接口）                       |      |                                          |
| -------------------------------- | ---- | ---------------------------------------- |
| AccountInfoFactory.addAccount    | 语法   | public ResultMessage addAccount（string name,int money) |
|                                  | 前置条件 | name不能与之前的重复                             |
|                                  | 后置条件 | 无                                        |
| AccountInfoFactory.deleteAccount | 语法   | public ResultMessage deleteAccount（string name) |
|                                  | 前置条件 | name必须已经存在的账户列表中                         |
|                                  | 后置条件 | 无                                        |
| AccountInfoFactory.modifyAccount | 语法   | public ResultMessage modifyAccount（string oldname,string newname) |
|                                  | 前置条件 | oldname已经存在于账号列表中而newname不存在于账户列表中       |
|                                  | 后置条件 | 无                                        |
| AccountInfoFactory.checkAccount  | 语法   | public Account checkAccount(String name) |
|                                  | 前置条件 | name已经存在于账户列表中                           |
|                                  | 后置条件 | 返回已经写入账户信息（具体参见Account类说明表）的Account      |
| AccountInfoFactory.income        | 语法   | public void income(String name, int income) |
|                                  | 前置条件 | 无                                        |
|                                  | 后置条件 | 无                                        |
| AccountInfoFactory.pay           | 语法   | public void pay(String name,int pay)     |
|                                  | 前置条件 | 无                                        |
|                                  | 后置条件 | 无                                        |

需要的服务(需接口)

| 服务名                              | 服务        |
| -------------------------------- | --------- |
| AccountDataService.income        | 调整账户金额，收款 |
| AccountDataService.pay           | 调整账户金额，付款 |
| AccountDataService.addAccount    | 增加账户至数据库  |
| AccountDataService.deleteAccount | 删除数据库中的账户 |
| AccountDataService.modifyAccount | 修改数据库中的账户 |
| AccountDataService.checkAccount  | 搜索数据库中的账户 |

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/%E5%88%A0%E9%99%A4%E8%B4%A6%E6%88%B7%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/%E6%B7%BB%E5%8A%A0%E8%B4%A6%E6%88%B7%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/%E8%B4%A6%E6%88%B7%E6%8E%92%E5%BA%8F%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)

#### 4.2.6 PromotionBL模块

##### （1）模块概述

Promotionbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求

Promotionbl模块的职责及接口参见软件系统结构描述文档

##### （2）整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加promotionblservice接口。业务逻辑层和数据层之间添加promotiondataservice接口和。为了隔离业务逻辑职责和逻辑控制职责，我们增加了promotion对象，这样promotionblserviceimpl会将促销策略模块的操作委托给promotion对象。PromotionPO是作为持久化对象被添加到设计模型中去的。
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/Promotion模块类图.png)
PromotionBL模块各个类的职责如表所示

| 模块                     | 职责                        |
| ---------------------- | ------------------------- |
| PromotionBLServiceImpl | 促销策略模块接口的具体实现             |
| Promotion              | 促销策略模块的主要功能类，负责实现所有的功能    |
| PromotionBLInfo        | 负责PromotionBL模块与其他BL模块的交互 |

##### （3）模块内部类的接口规范

PromotionBLServiceImpl的接口规范

| 提供的服务（供接口）                               |                  |                                          |
| ---------------------------------------- | ---------------- | ---------------------------------------- |
| PromotionBLServiceImpl.add               | 语法               | public ResultMessage add(Promotion VO promotionVO); |
| 前置条件                                     | 无                |                                          |
| 后置条件                                     | 促销策略数据中增加一条促销策略  |                                          |
| PromotionBLServiceImpl.delete            | 语法               | public ResultMessage delete(String id);  |
| 前置条件                                     | 无                |                                          |
| 后置条件                                     | 删除一条促销策略         |                                          |
| PromotionBLServiceImpl.update            | 语法               | public ResultMessage update(String id,PromotionVO promotionVO); |
| 前置条件                                     | 无                |                                          |
| 后置条件                                     | 更新一条促销策略         |                                          |
| PromotionBLServiceImpl.search            | 语法               | public ArrayList<PromotionPO> search(Time date); |
| 前置条件                                     | 无                |                                          |
| 后置条件                                     | 返回所有有效的促销策略      |                                          |
| PromotionBLServiceImpl.showPromotionList | 语法               | public PromotionListVO showPromotionList(ArrayList<PromotionPO> promotionList); |
|                                          | 前置条件             | 无                                        |
|                                          | 后置条件             | 返回促销策略列表VO                               |
| PromotionBLServiceImpl.showPromotionDetail | 语法               | public PromotionVO showPromotionDetail(String id); |
|                                          | 前置条件             | 无                                        |
|                                          | 后置条件             | 返回促销策略VO                                 |
| 需要的服务（需接口）                               |                  |                                          |
| 服务名                                      | 服务               |                                          |
| Promotion.add                            | 给促销策略数据中增加一个促销策略 |                                          |
| Promotion.delete                         | 从促销策略数据中删除一个促销策略 |                                          |
| Promotion.update                         | 更新一个促销策略         |                                          |
| Promotion.search                         | 搜索所有有效的促销策略      |                                          |
| Promotion.showPromotionList              | 返回一个促销策略列表VO     |                                          |
| Promotion.showPromotionDetail            | 返回一个促销策略VO       |                                          |

Promotion的接口规范

| 提供的服务（供接口）                    |                  |                                          |
| ----------------------------- | ---------------- | ---------------------------------------- |
| Promotion.add                 | 语法               | public ResultMessage add(Promotion VO promotionVO); |
| 前置条件                          | 无                |                                          |
| 后置条件                          | 促销策略数据中增加一条促销策略  |                                          |
| Promotion.delete              | 语法               | public ResultMessage delete(String id);  |
| 前置条件                          | 无                |                                          |
| 后置条件                          | 删除一条促销策略         |                                          |
| Promotion.update              | 语法               | public ResultMessage update(String id,PromotionVO promotionVO); |
| 前置条件                          | 无                |                                          |
| 后置条件                          | 更新一条促销策略         |                                          |
| Promotion.search              | 语法               | public ArrayList<PromotionPO> search(Time date); |
| 前置条件                          | 无                |                                          |
| 后置条件                          | 返回所有有效的促销策略      |                                          |
| Promotion.showPromotionList   | 语法               | public PromotionListVO showPromotionList(ArrayList<PromotionPO> promotionList); |
|                               | 前置条件             | 无                                        |
|                               | 后置条件             | 返回促销策略列表VO                               |
| Promotion.showPromotionDetail | 语法               | public PromotionVO showPromotionDetail(String id); |
|                               | 前置条件             | 无                                        |
|                               | 后置条件             | 返回促销策略VO                                 |
| 需要的服务（需接口）                    |                  |                                          |
| 服务名                           | 服务               |                                          |
| PromotionDataService.add      | 给促销策略数据中增加一个促销策略 |                                          |
| PromotionDataService.delete   | 从促销策略数据中删除一个促销策略 |                                          |
| PromotionDataService.update   | 更新一个促销策略         |                                          |
| PromotionDataService.search   | 搜索所有有效的促销策略      |                                          |

PromotionBLInfo的接口规范

| 提供的服务（供接口）             |             |                                          |
| ---------------------- | ----------- | ---------------------------------------- |
| PromotionBLInfo.search | 语法          | public ArrayList<PromotionPO> search(Time date); |
| 前置条件                   | 无           |                                          |
| 后置条件                   | 返回符合条件的促销策略 |                                          |
| 需要的服务（需接口）             |             |                                          |
| 服务名                    | 服务          |                                          |
| Promotion.search       | 返回符合条件的促销策略 |                                          |

（4）业务逻辑层内部动态模型
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/Promotion顺序图.png)

#### 4.2.7 TableBL模块

##### （1）模块描述

tablebl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

tablebl模块的职责及接口参见软件体系结构设计文档

 ##### （2）整体结构

TableBL模块主要负责制定报表功能需求的逻辑实现，其中Table为主模块，负责主要逻辑的生成以及对辅助类和功能类的调度，但为了降低耦合，Table不与DataService模块交互，而是TableInfoFactory与BillDataService交互，来生成ArrayList<Bill>以及具体的VO，此外，还拥有TableSorter类来负责TableBL类的数据的排序<br>
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/Table%E6%A8%A1%E5%9D%97.png)

TableBL模块各个类的职责如表所示

| 模块                      | 职责                           |
| ----------------------- | ---------------------------- |
| TableBLServiceImpl      | 查看报表接口的具体实现                  |
| Table                   | TableBL模块的主要功能类，负责实现大部分的功能   |
| TableInfoFactory        | 信息的接口，负责与DataService交互的信息功能类 |
| BusinessTableComparator | 负责与经营情况报表有关的单据的排序功能类         |
| SaleTableComparator     | 负责与销售明细报表有关的单据的排序功能类         |
| ProcessTableComparator  | 负责与经营历程报表有关的单据的排序功能类         |
| ExportHelper            | 导出的实现的辅助类                    |

##### （3）模块内部类的接口

提供的服务(供接口)

| 服务名                                    | 服务   | 服务                                       |
| -------------------------------------- | ---- | ---------------------------------------- |
| TableBLServiceImpl.checkSaleTable      | 语法   | public SaleTableVO checkSaleTable(SaleTableFilterFlags flags) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 返回对应的SaleTableVO                         |
| TableBLServiceImpl.checkProcessTable   | 语法   | public ProcessTableVO checkProcessTable(ProcessTableFilterFlags flags) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 返回对应的ProcessTableVO                      |
| TableBLServiceImpl.checkBusinessTable  | 语法   | public BusinessTableVO checkBusinessTable(BusinessTableFilterFlags flags) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 返回对应的BusinessTableVO                     |
| TableBLServiceImpl.exportSaleTable     | 语法   | public void exportSaleTable(SaleTableVO saletable) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 无                                        |
| TableBLServiceImpl.exportProcessTable  | 语法   | public void exportProcessTable(ProcessTableVO  processtable) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 无                                        |
| TableBLServiceImpl.exportBusinessTable | 语法   | public void exportBusinessTable(BusinessTableVO businesstable) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 无                                        |
| TableBLServiceImpl.compareBTByTime     | 语法   | public BusinessTableVO compareBTByTime(BusinessTableVO businesstable) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 返回时间从早到晚排序的报表                            |
| TableBLServiceImpl.compareSTByMoney    | 语法   | public SaleTableVO compareSTByMoney(SaleTableVO saletable) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 按金额从小到大排序                                |
| TableBLServiceImpl.comparePTByMoney    | 语法   | public ProcessTableVO comparePTByMoney(ProcessTableVO processtable) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 按金额从少到大排序                                |
| TableBLServiceImpl.compareSTByTime     | 语法   | public SaleTable compareSTByTime(SaleTableVO saletable) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 按时间从早到晚排序                                |
| TableBLServiceImpl.comparePTByTime     | 语法   | public ProcessTableVO comparePTByTime(ProcessTableVO processtable) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 按时间从早到晚排序                                |

需要的服务(需接口)

| 服务名                                   | 服务               |
| ------------------------------------- | ---------------- |
| Table.exportBusinesTable              | 导出Business报表     |
| Table.exportSaleTable                 | 导出sale报表         |
| Table.exportProcessTable              | 导出Process报表      |
| Table.checkBusinessBill               | 查看Busine报表       |
| TableInfo.ProcessBill                 | 查看Proce报表        |
| TableInfo.checkSaleBill               | 查看Sale报表         |
| BusinessTablecomparator.compareByTime | 把Business报表按时间排序 |
| SaleTablecomparator.compareByTime     | 把Sale报表按时间排序     |
| ProcessTablecomparator.compareByTime  | 把Process报表按时间排序  |
| SaleTablecomparator.compareByMoney    | 把Sale报表按金额排序     |
| ProcessTablecomparator.compareByMoney | 把Process报表按金额排序  |



提供的服务(供接口)

| 服务名                       | 服务   | 服务                                       |
| ------------------------- | ---- | ---------------------------------------- |
| Table.checkSaleTable      | 语法   | public SaleTableVO checkSaleTable(SaleTableFilterFlags flags) |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 返回对应的SaleTableVO                         |
| Table.checkProcessTable   | 语法   | public ProcessTableVO checkProcessTable(ProcessTableFilterFlags flags) |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 返回对应的ProcessTableVO                      |
| Table.checkBusinessTable  | 语法   | public BusinessTableVO checkBusinessTable(BusinessTableFilterFlags flags) |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 返回对应的BusinessTableVO                     |
| Table.exportSaleTable     | 语法   | public void exportSaleTable(SaleTableVO saletable) |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 无                                        |
| Table.exportProcessTable  | 语法   | public void exportProcessTable(ProcessTableVO  processtable) |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 无                                        |
| Table.exportBusinessTable | 语法   | public void exportBusinessTable(BusinessTableVO businesstable) |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 无                                        |

需要的服务(需接口)

| 服务名                              | 服务   |
| -------------------------------- | ---- |
| ExportHelper.exportBusinesTable  |      |
| ExportHelper.exportSaleTable     |      |
| ExportHelper.exportProcessTable  |      |
| TableInfoFactory.getBusinessBill |      |
| TableInfoFactory.getProcessBill  |      |
| TableInfoFactory.getSaleBill     |      |

提供的服务(供接口)

| 服务名                               | 服务   | 服务                                       |
| --------------------------------- | ---- | ---------------------------------------- |
| TableInfoFactory.getSaleTable     | 语法   | public SaleTableVO checkSaleTable(SaleTableFilterFlags flags) |
|                                   | 前置条件 | 无                                        |
|                                   | 后置条件 | 返回对应的SaleTableVO                         |
| TableInfoFactory.getProcessTable  | 语法   | public ProcessTableVO checkProcessTable(ProcessTableFilterFlags flags) |
|                                   | 前置条件 | 无                                        |
|                                   | 后置条件 | 返回对应的ProcessTableVO                      |
| TableInfoFactory.getBusinessTable | 语法   | public BusinessTableVO checkBusinessTable(BusinessTableFilterFlags flags) |
|                                   | 前置条件 | 无                                        |
|                                   | 后置条件 | 返回对应的BusinessTableVO                     |

需要的服务(需接口)

| 服务   | 服务名  |
| ---- | ---- |
|      |      |
|      |      |
|      |      |
|      |      |
|      |      |
|      |      |

提供的服务(供接口)

| 服务名                              |      | 服务                                       |
| -------------------------------- | ---- | ---------------------------------------- |
| ExportHelper.exportBusinessTable | 语法   | public ResultMessage exportBusinessTable(BusinessTableVO table) |
|                                  | 前置条件 | 无                                        |
|                                  | 后置条件 | 返回导出结果                                   |
| ExportHelper.exportSaleTable     | 语法   | public ResultMessage exportSaleTable(SaleTable table) |
|                                  | 前置条件 | 无                                        |
|                                  | 后置条件 | 返回导出结果                                   |
| ExportHelper.exportProcessTable  | 语法   | public ResultMessage exportProcessTable(ProcessTable table) |
|                                  | 前置条件 | 无                                        |
|                                  | 后置条件 | 返回导出结果                                   |

需要的服务(需接口)

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |



提供的服务(供接口)

| 服务名                                   |      | 服务                                       |
| ------------------------------------- | ---- | ---------------------------------------- |
| BusinessTableComparator.compareByTime | 语法   | public BusinessTableVO compareByTime(BusinessTableVO businesstable) |
|                                       | 前置条件 | 无                                        |
|                                       | 后置条件 | 返回按时间先后排序的VO                             |

需要的服务(需接口)

| 服务名  | 服务   |
| ---- | ---- |
| 无    |      |

提供的服务(供接口)

| 服务名                                |      | 服务                                       |
| ---------------------------------- | ---- | ---------------------------------------- |
| SaleTableComparator.compareByTime  | 语法   | public SaleTableVO compareByTime(SaleTableVO saletable) |
|                                    | 前置条件 | 无                                        |
|                                    | 后置条件 | 返回按时间先后排序的VO                             |
| SaleTableComparator.compareByMoney | 语法   | public SaleTableVO compareByMoney(SaleTableVO saletable) |
|                                    |      | 无                                        |
|                                    |      | 返回按金额大小排序的VO                             |

需要的服务(需接口)

| 服务名  | 服务   |
| ---- | ---- |
| 无    |      |

提供的服务(供接口)

| 服务名                                   |      | 服务                                       |
| ------------------------------------- | ---- | ---------------------------------------- |
| ProcessTableComparator.compareByTime  | 语法   | public ProcessTableVO compareByTime(ProcessTableVO processtable) |
|                                       | 前置条件 | 无                                        |
|                                       | 后置条件 | 返回按时间先后排序的VO                             |
| ProcessTableComparator.compareByMoney | 语法   | public ProcessTableVO compareByMoney(ProcessTableVO processtable) |
|                                       |      | 无                                        |
|                                       |      | 返回按金额大小排序的VO                             |

需要的服务(需接口)

| 服务名  | 服务   |
| ---- | ---- |
| 无    |      |

##### （4）业务逻辑层内部动态模型

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/%E6%8A%A5%E8%A1%A8%E4%B8%AD%E5%8D%95%E6%8D%AE%E6%8E%92%E5%BA%8F%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/%E6%9F%A5%E7%9C%8B%E6%8A%A5%E8%A1%A8%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)


#### 4.2.8 CustomerBL模块

##### （1）模块描述

customerbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

customerbl模块的职责及接口参见软件体系结构设计文档

##### （2）整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加businesslogicservice.customerblservice.CustomerBLService接口。业务逻辑层和数据层之间添加dataservice.CustomerDataService、dataservice.CommodityDataService接口。为了隔离业务逻辑职责和逻辑控制职责，我们增加了CustomerBLServiceImpl，这样CustomerBLServiceImpl会将客户管理和制定单据的业务逻辑委托给Customer对象。CustomerPO是作为客户属性的持久化对象被添加到设计模型中去的，CommodityPO是作为商品属性的持久化对象被添加到设计模型中去的。CustomerVO、CommodityVO是作为值对象被添加到设计模型中去的。

| 模块                    | 职责                                 |
| --------------------- | ---------------------------------- |
| CustomerBLServiceImpl | 管理 customerbl 各个类的任务，负责与其他 bl 模块交互 |
| Customer              | 负责对客户的增删改查的操作                      |

##### （3）模块内部类的接口规范

表4.2.8（3）-1 CustomerBLServiceImpl类的接口规范

提供的服务（供接口）

| 服务名                                   | 服务   | 服务                                       |
| ------------------------------------- | ---- | ---------------------------------------- |
| CustomerBLServiceImpl.addCustomer     | 语法   | public boolean addCustomer(CustomerVO customer) |
|                                       | 前置条件 | 输入的信息符合规范                                |
|                                       | 后置条件 | 系统新建一个客户，并提示新建成功                         |
| CustomerBLServiceImpl.delCustomer     | 语法   | public boolean delCustomer(String ID);   |
|                                       | 前置条件 | 需要删除的用户存在于系统中                            |
|                                       | 后置条件 | 删除用户，返回true                              |
| CustomerBLServiceImpl.modifyCustomer  | 语法   | public boolean ModifyCustomer(CustomerVO modCustomer); |
|                                       | 前置条件 | 输入的信息符合规范                                |
|                                       | 后置条件 | 系统修改该客户的属性，并返回true                       |
| CustomerBLServiceImpl.getCustomerInfo | 语法   | public CustomerVO getCustomerInfo(String ID); |
|                                       | 前置条件 | 输入的客户编号符合规范                              |
|                                       | 后置条件 | 如果系统中有该客户，返回该客户的属性。否则返回null              |
| CustomerBLServiceImpl.searchCustomer  | 语法   | public ArrayList< CustomerVO > searchCustomer(String keytype, String keyword); |
|                                       | 前置条件 | 输入的关键词合法                                 |
|                                       | 后置条件 | 如果系统里有符合条件的客户，返回true，否则返回false           |
|                                       |      |                                          |
|                                       |      |                                          |

需要的服务（需接口）

| 服务名                      | 服务     |
| ------------------------ | ------ |
| Customer.addCustomer     | 增加用户   |
| Customer.delCustomer     | 删除用户   |
| Customer.modifyCustomer  | 修改用户   |
| Customer.getCustomerInfo | 获取用户属性 |
| Customer.searchCustomer  | 查找用户   |

表5.2.8（3）-2 Customer类的接口规范

| 服务名                      | 服务   | 服务                                       |
| ------------------------ | ---- | ---------------------------------------- |
| Customer.addCustomer     | 语法   | public boolean addCustomer(CustomerVO customer) |
|                          | 前置条件 | 输入的信息符合规范                                |
|                          | 后置条件 | 系统新建一个客户，并提示新建成功                         |
| Customer.delCustomer     | 语法   | public boolean delCustomer(String ID);   |
|                          | 前置条件 | 需要删除的用户存在于系统中                            |
|                          | 后置条件 | 删除用户，返回true                              |
| Customer.modifyCustomer  | 语法   | public boolean ModifyCustomer(CustomerVO modCustomer); |
|                          | 前置条件 | 输入的信息符合规范                                |
|                          | 后置条件 | 系统修改该客户的属性，并返回true                       |
| Customer.getCustomerInfo | 语法   | public CustomerVO getCustomerInfo(String ID); |
|                          | 前置条件 | 输入的客户编号符合规范                              |
|                          | 后置条件 | 如果系统中有该客户，返回该客户的属性。否则返回null              |
| Customer.searchCustomer  | 语法   | public ArrayList< CustomerVO > searchCustomer(String keytype, String keyword); |
|                          | 前置条件 | 输入的关键词合法                                 |
|                          | 后置条件 | 如果系统里有符合条件的客户，返回true，否则返回false           |
|                          |      |                                          |
|                          |      |                                          |

需要的服务（需接口）

| 服务名                             | 服务     |
| ------------------------------- | ------ |
| CommodityBLService.getCommodity | 获取商品属性 |
|                                 |        |

##### （4）业务逻辑层内部动态模型

图1 增加客户顺序图

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%BF%9B%E8%B4%A7%E9%94%80%E5%94%AE%E4%BA%BA%E5%91%98/%E5%A2%9E%E5%8A%A0%E5%AE%A2%E6%88%B7%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)

修改客户属性顺序图

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%BF%9B%E8%B4%A7%E9%94%80%E5%94%AE%E4%BA%BA%E5%91%98/%E4%BF%AE%E6%94%B9%E5%AE%A2%E6%88%B7%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)

#### 4.2.9 LogBL模块

##### （1）模块概述

logbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求

logbl模块的职责及接口参加软件系统结构描述文档

##### （2）整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加logblservice接口。业务逻辑层和数据层之间添加logdataservice接口和。为了隔离业务逻辑职责和逻辑控制职责，我们增加了log对象，这样logblserviceimpl会将日志模块的操作委托给log对象。LogPO是作为持久化对象被添加到设计模型中去的。
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/Log模块类图.png)
LogBL模块各个类的职责如表所示

| 模块               | 职责                   |
| ---------------- | -------------------- |
| LogBLServiceImpl | 日志模块接口的具体实现          |
| Log              | 日志模块的主要功能类，负责实现所有的功能 |
| LogBLInfo        | 负责LogBL模块与其他BL模块的交互  |

##### （3）模块内部类的接口规范

LogBLServiceImpl的接口规范

| 提供的服务（供接口）                     |              |                                          |
| ------------------------------ | ------------ | ---------------------------------------- |
| LogBLServiceImpl.search        | 语法           | public ArrayList<LogPO> search(Time date); |
| 前置条件                           | 无            |                                          |
| 后置条件                           | 返回存储LogPO的数组 |                                          |
| LogBLServiceImpl.showLogList   | 语法           | public LogListVO showLogList(ArrayList<LogPO> logList); |
| 前置条件                           | 无            |                                          |
| 后置条件                           | 返回日志列表VO     |                                          |
| LogBLServiceImpl.showLogDetail | 语法           | public LogVO showLogDetail(String Id);   |
| 前置条件                           | 无            |                                          |
| 后置条件                           | 返回日志VO       |                                          |
| 需要的服务（需接口）                     |              |                                          |
| 服务名                            | 服务           |                                          |
| Log.search                     | 搜索符合条件的日志    |                                          |
| Log.showLogList                | 显示日志列表       |                                          |
| Log.showLogDetail              | 显示日志详情       |                                          |

Log的接口规范

| 提供的服务（供接口）            |                 |                                          |
| --------------------- | --------------- | ---------------------------------------- |
| Log.add               | 语法              | public ResultMessage add(LogPO logPO);   |
| 前置条件                  | 无               |                                          |
| 后置条件                  | Log Data里增添一条记录 |                                          |
| Log.search            | 语法              | public ArrayList<LogPO> search(Time date); |
| 前置条件                  | 无               |                                          |
| 后置条件                  | 返回存储LogPO的数组    |                                          |
| Log.showLogList       | 语法              | public LogListVO showLogList(ArrayList<LogPO> logList); |
| 前置条件                  | 无               |                                          |
| 后置条件                  | 返回日志列表VO        |                                          |
| Log.showLogDetail     | 语法              | public LogVO showLogDetail(String id);   |
| 前置条件                  | 无               |                                          |
| 后置条件                  | 返回日志VO          |                                          |
| 需要的服务（需接口）            |                 |                                          |
| 服务名                   | 服务              |                                          |
| LogDataService.add    | 在日志数据中加入一个日志PO  |                                          |
| LogDataService.search | 搜索符合条件的日志PO     |                                          |

LogBLInfo的接口规范

| 提供的服务（供接口）         |                 |                                        |
| ------------------ | --------------- | -------------------------------------- |
| LogBLInfo.add      | 语法              | public ResultMessage add(LogPO logPO); |
| 前置条件               | 无               |                                        |
| 后置条件               | Log Data里增添一条记录 |                                        |
| 需要的服务（需接口）         |                 |                                        |
| 服务名                | 服务              |                                        |
| LogDataService.add | 在日志数据中加入一个日志PO  |                                        |
（4）业务逻辑层内部动态模型业务逻辑
![](http://101.37.19.32:10080/FX/MSPSS/blob/master/doc/img/Log顺序图.png)

#### 4.2.10 GeneralAccountBL模块

##### （1）模块描述

generalaccountbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

generalaccountbl模块的职责及接口参见软件体系结构设计文档

 ##### （2）整体结构

TableBL模块主要负责制定报表功能需求的逻辑实现，其中Table为主模块，负责主要逻辑的生成以及对辅助类和功能类的调度，但为了降低耦合，Table不与DataService模块交互，而是TableInfoFactory与BillDataService交互，来生成ArrayList<Bill>以及具体的VO，此外，还拥有TableSorter类来负责TableBL类的数据的排序
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/GeneralAccount%E6%A8%A1%E5%9D%97.png)



GeneralAccount模块的各个类的职责如表所示

| 模块                          | 职责                                  |
| --------------------------- | ----------------------------------- |
| GeneralAccountBLServiceImpl | 负责实现与期初建账有关的添加，查询，排序操作              |
| GeneralAccount              | 期初建账模块的主要功能类，负责实现功能及辅助类功能类之间的调度     |
| GeneralAccountInfoFactory   | GeneralAccountVO及PO的工厂模式，负责信息的转化和生成 |
| GeneralAccountComparator    | 排序功能类，负责实现各种排序方法                    |

##### （3）模块内部类的接口规范

GeneralAccountBLServiceImpl的接口规范

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| GeneralAccountBLServiceImpl.newGeneralAccount | 语法   | public ResultMessage newGeneralAccount(GeneralAccountVO generalaccount) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回期初建账的结果ResultMessa                     |
| GeneralAccountBLServiceImpl.checkGeneralAccount | 语法   | public ArrayList<GeneralAccountVO checkGenerlalAccount(Time begin,Time end) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回期初建账的信息，如果不存在，则返回空VO                   |
| GeneralAccountBLServiceImpl.ETLSort      | 语法   | public ArrayList<GeneralAccountVO> ETLSort(ArrayList<GeneralAccountVO> list) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回时间从早到晚排序的list                          |
| GeneralAccountBLServiceImpl.LTESort      | 语法   | public ArrayList<GeneralAccountVO> LTESort(ArrayList<GeneralAccountVO> list) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回时间从晚到早排序的list                          |

需要的接口(需接口)

| 服务名                                | 服务        |
| ---------------------------------- | --------- |
| GeneralAccount.newGeneralAccount   | 添加期初建账的信息 |
| GeneralAccount.checkGeneralAccount | 检查期初建账的信息 |
| GeneralAccount.Early_To_Late       | 从早到晚排序    |
| GeneralAccount.Late_To_Early       | 从晚到早排序    |

GeneralAccount的接口规范

提供的接口(供接口)

| 服务名                                | 服务   | 服务                                       |
| ---------------------------------- | ---- | ---------------------------------------- |
| GeneralAccount.newGeneralAccount   | 语法   | public ResultMessage newGeneralAccount(GeneralAccountVO generalaccount) |
|                                    | 前置条件 | 无                                        |
|                                    | 后置条件 | 返回期初建账的结果ResultMessa                     |
| GeneralAccount.checkGeneralAccount | 语法   | public ArrayList<GeneralAccountVO checkGenerlalAccount(Time begin,Time end) |
|                                    | 前置条件 | 无                                        |
|                                    | 后置条件 | 返回期初建账的信息，如果不存在，则返回空VO                   |
| GeneralAccount.ETLSort             | 语法   | public ArrayList<GeneralAccountVO> ETLSort(ArrayList<GeneralAccountVO> list) |
|                                    | 前置条件 | 无                                        |
|                                    | 后置条件 | 返回时间从早到晚排序的list                          |
| GeneralAccount.LTESort             | 语法   | public ArrayList<GeneralAccountVO> LTESort(ArrayList<GeneralAccountVO> list) |
|                                    | 前置条件 | 无                                        |
|                                    | 后置条件 | 返回时间从晚到早排序的list                          |

需要的服务(需接口)

| 服务名                                      | 服务        |
| ---------------------------------------- | --------- |
| GeneralAccountInfoFactory.newGeneralAccount | 添加期初建账的信息 |
| GeneralAccountInfoFactory.checkGeneralAccount | 检查期初建账的信息 |
| GeneralAccountSorter.Early_To_Late       | 从早到晚排序    |
| GeneralAccountSorter.Late_To_Early       | 从晚到早排序    |

提供的服务(供接口)

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| GeneralAccountInfoFactory.newGeneralAccount | 语法   | public ResultMessage newGeneralAccount(GeneralAccountVO generalaccount) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回期初建账的结果ResultMessa                     |
| GeneralAccountInfoFacto.checkGeneralAccount | 语法   | public ArrayList<GeneralAccountVO checkGenerlalAccount(Time begin,Time end) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回期初建账的信息，如果不存在，则返回空VO                   |

需要的服务(需接口)

| 服务名                                      | 服务        |
| ---------------------------------------- | --------- |
| GeneralAccountDataService.newGeneralAccount | 添加期初建账的信息 |
| GeneralAccountDataService.checkGeneralAccount | 检查期初建账的信息 |
| AccountDataService.addAccount            | 从早到晚排序    |
| CommodityDataService.addCommodity        | 从晚到早排序    |
| CustomerDataService.addCustomer          |           |

提供的接口(供接口)

| 提供的接口(供接口)                             |      |                                          |
| -------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                    |      | 服务                                       |
| GeneralAccountComparator.Early_To_Late | 语法   | public ArrayList<GeneralAccountVO> Early_To_Late(ArrayList<GeneralAccount> list) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 返回时间从早到晚的总账                              |
| GeneralAccountComparator.Late_To_Early | 语法   | public ArrayList<GeneralAccountVO> Late_To_Early(ArrayList<GeneralAccount> list) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 返回时间从晚到早的总账                              |

需要的服务(需接口)

| 服务名  | 服务   |
| ---- | ---- |
| 无    |      |


![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/%E6%9C%9F%E5%88%9D%E5%BB%BA%E8%B4%A6%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/%E6%9F%A5%E7%9C%8B%E6%9C%9F%E5%88%9D%E8%B4%A6%E6%88%B7%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)

##### （4）业务逻辑层内部动态模型













### 4.3 数据层的分解

#### 4.3.1 User模块

提供的服务（供接口）

| 服务名                                | 服务   | 服务                                       |
| ---------------------------------- | ---- | ---------------------------------------- |
| UserDataServiceImpl.SearchUserByID | 语法   | public UserPO SearchUserByID(String ID)  |
|                                    | 前置条件 | 用户处于未登录状态                                |
|                                    | 后置条件 | 用户登陆                                     |
| UserDataServiceImpl.FullSearchUser | 语法   | public ArrayList<UserPO>fullSearchUser(String filed, Object val) |
|                                    | 前置条件 | field要与val对应                             |
|                                    | 后置条件 | 返回list                                   |
| UserDataServiceImpl.addUser        | 语法   | public ResultMessage addUser(UserPO);    |
|                                    | 前置条件 | 输入的信息符合规范                                |
|                                    | 后置条件 | 增加用户                                     |
| UserDataServiceImpl.deleteUser     | 语法   | public ResultMessage deleteUser(String ID); |
|                                    | 前置条件 | 输入的ID已存在                                 |
|                                    | 后置条件 | 删除该用户                                    |
| UserDataServiceImpl.updateUser     | 语法   | public ResultMessage updateUser(UserPO); |
|                                    | 前置条件 | 输入的信息符合规范                                |
| 输入的信息符合规范                          | 后置条件 | 修改用户属性                                   |

需要的服务（需接口）

| 服务名  | 服务   |
| ---- | ---- |
|      |      |
|      |      |



#### 4.3.2 Stock模块

提供的服务（供接口）

| 服务名                                   |      | 服务                                       |
| ------------------------------------- | ---- | ---------------------------------------- |
| StockDataServiceImpl.rangeSearchStock | 语法   | public ArrayList<StockPO> rangeSearchStock(String filed, Object min, Object max) |
|                                       | 前置条件 | field要与min,max类型匹配                       |
|                                       | 后置条件 | 返回list                                   |
| StockDataServiceImpl.addStock         | 语法   | public ResultMessage addStock(StockPO stockPO) |
|                                       | 前置条件 | 无                                        |
|                                       | 后置条件 | 无                                        |



#### 4.3.3 Commodity模块

| 服务名                                      |      | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CommodityDataServiceImpl.addCommodity    | 语法   | public ResultMessage addCommodity(CommodityPO commodityPO) |
|                                          | 前置条件 | commodityPO需要初始化                         |
|                                          | 后置条件 | 无                                        |
| CommodityDataServiceImpl.deleteCommodity | 语法   | public ResultMessage modifyCommodity(CommodityPO commodityPO) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| CommodityDataServiceImpl.modifyCommodity | 语法   | public ResultMessage deleteCommodity(String key,String name) |
|                                          | 前置条件 | key与name必须为String                        |
|                                          | 后置条件 | 无                                        |
| CommodityDataServiceImpl.exactlySearchCommodity | 语法   | public CommodityPO exactlySearchCommodity(String field,String value) |
|                                          | 前置条件 | field与value的类型要匹配                        |
|                                          | 后置条件 | 无                                        |
| CommodityDataServiceImpl.prefixSearchCommodity | 语法   | public ArrayList<CommodityPO> prefixSearchCommodity(String field, String value) |
|                                          | 前置条件 | field与value的类型要匹配                        |
|                                          | 后置条件 | 无                                        |
| CommodityDataServiceImpl.fuzzySearchCommodity | 语法   | public ArrayList<CommodityPO> fuzzySearchCommodity(String field,String value) |
|                                          | 前置条件 | field与value的类型要匹配                        |
|                                          | 后置条件 | 无                                        |
| CommodityDataServiceImpl.fullSearchCommodity | 语法   | public ArrayList<CommodityPO> fullSearchCommodity(String field, Object value) |
|                                          | 前置条件 | field与value类型匹配                          |
|                                          | 后置条件 | 无                                        |
| CommodityDataServiceImpl.rangeSearchCommodity | 语法   | public ArrayList<CommodityPO> rangeSearchCommodity(String field,Object min,Object max) |
|                                          | 前置条件 | field与民，max类型匹配                          |
|                                          | 后置条件 | 无                                        |
| CommodityDataServiceImpl.addClassification | 语法   | public ResultMessage addClassification(ClassificationPO classificationPO) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| CommodityDataServiceImpl.modifyClassification | 语法   | public ResultMessage modifyClassification(ClassificationPO classificationPO) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| CommodityDataServiceImpl.deleteClassification | 语法   | public ResultMessage deleteClassification(String id) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| CommodityDataServiceImpl.getAllClassification | 语法   | public ArrayList<ClassificationPO> getAllClassification() |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| CommodityDataServiceImpl.getClassification | 语法   | public ClassificationPO getClassification(String id) |
|                                          | 前置条件 | w无                                       |
|                                          | 后置条件 | 无                                        |
| CommodityDataServiceImpl.updateClassification | 语法   | public ResultMessage updateClassification(ClassificationPO classificationPO) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| CommodityDataServiceImpl.getChildrenClassification | 语法   | public ArrayList<ClassificationPO> getChildrenClassification(String id) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| CommodityDataServiceImpl.fullSearchClassificationPO | 语法   | public ArrayList<ClassificationPO> fullSearchClassificationPO(String field,String val) |
|                                          | 前置条件 | field与val的类型需要匹配                         |
|                                          | 后置条件 | 无                                        |



#### 4.3.4 Bill模块

| 提供的服务                                    |      | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| BillDataServiceImpl.addStockBill         | 语法   | public ResultMessage addStockBill(StockBillPO stockBillPO) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.updateStockBill      | 语法   | public ResultMessage updateStockBill(StockBillPO stockBillPO) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.deleteStockBill      | 语法   | public ResultMessage deleteStockBill(String id) |
|                                          | 前置条件 | id必须是String                              |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.fullSearchStockBill  | 语法   | public ArrayList<StockBillPO> fullSearchStockBill(String field, Object value) |
|                                          | 前置条件 | field与value类型相符                          |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.multiSearchStockBill | 语法   | public ArrayList<StockBillPO> multiSearchStockBill(ArrayList<CriteriaClause> criteriaClauses) |
|                                          | 前置条件 | criteriaClauses符合符合条件查找规范                |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.rangeSearchStockBill | 语法   | public ArrayList<StockBillPO> rangeSearchStockBill(String field,Object max,Object min) |
|                                          | 前置条件 | field与min,max类型相符                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.getStockBillID       | 语法   | public String getStockBillID(StockBillType type) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.addCashCostBill      | 语法   | public ResultMessage addCashCostBill(CashCostBillPO po) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.updateCashCostBill   | 语法   | public ResultMessage updateCashCostBill(CashCostBillPO po) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.deleteCashCostBill   | 语法   | public ResultMessage deleteCashCostBill(String id) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.multiSearchCashCostBill | 语法   | public ArrayList<CashCostBillPO> multiSearchCashCostBill(ArrayList<CriteriaClause> criteriaClauses) |
|                                          | 前置条件 | criteriaClauses符合符合条件查找规范                |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.fullSearchCashCostBill | 语法   | public ArrayList<CashCostBillPO> fullSearchCashCostBill(String field, Object val) |
|                                          | 前置条件 | field与val类型相符                            |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.rangeSearchCashCostBill | 语法   | public ArrayList<CashCostBillPO> rangeSearchCashCostBill(String field,Object max,Object min) |
|                                          | 前置条件 | field与min,max类型相符                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.getCashCostBillID    | 语法   | public String getCashCostBillID()        |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.addFinanceBill       | 语法   | public ResultMessage addFinanceBill(FinanceBillPO po) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.updateFinanceBill    | 语法   | public ResultMessage updateFinanceBill(FinanceBillPO po) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.deleteFinanceBill    | 语法   | public ResultMessage deleteFinanceBill(String id) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.fullSearchFinanceBill | 语法   | public ArrayList<FinanceBillPO> fullSearchFinanceBill(String field, Object val) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.multiSearchFinanceBill | 语法   | public ArrayList<FinanceBillPO> multiSearchFinanceBill(ArrayList<CriteriaClause> criteriaClauses) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.rangeSearchFinanceBill | 语法   | public ArrayList<FinanceBillPO> rangeSearchFinanceBill(String field,Object max,Object min) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.getFinanceBillID     | 语法   | public String getFinanceBillID(FinanceBillType type) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.addSalesInBill       | 语法   | public ResultMessage addSalesInBill(SalesInBillPO salesInBillPO) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.updateSalesInBill    | 语法   | public ResultMessage updateSalesInBill(SalesInBillPO salesInBillPO) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.deleteSalesInBill    | 语法   | public ResultMessage deleteSalesInBill(String id) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.fullSearchSalesInBill | 语法   | public ArrayList<SalesInBillPO> fullSearchSalesInBill(String field, Object val) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.mutilSearchSalesInBill | 语法   | public ArrayList<SalesInBillPO> mutilSearchSalesInBill(ArrayList<CriteriaClause> criteriaClauses) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.rangeSearchSalesInBill | 语法   | public ArrayList<SalesInBillPO> rangeSearchSalesInBill(String field,Object max,Object min) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.getSalesInBillID     | 语法   | public String getSalesInBillID(SalesInBillType type) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.addSalesOutBill      | 语法   | public ResultMessage addSalesOutBill(SalesOutBillPO salesOutBillPO) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.updateSalesOutBill   | 语法   | public ResultMessage updateSalesOutBill(SalesOutBillPO salesOutBillPO) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.deleteSalesOutBill   | 语法   | public ResultMessage deleteSalesOutBill(String id) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.fullSearchSalesOutBill | 语法   | public ArrayList<SalesOutBillPO> fullSearchSalesOutBill(String field, Object val) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.mutilSearchSalesOutBill | 语法   | public ArrayList<SalesOutBillPO> mutilSearchSalesOutBill(ArrayList<CriteriaClause> criteriaClauses) |
|                                          | 前置条件 | 无                                        |

|                                          | 后置条件 | 无                                        |
| ---------------------------------------- | ---- | ---------------------------------------- |
| BillDataServiceImpl.rangeSearchSalesOutBill | 语法   | public ArrayList<SalesOutBillPO> rangeSearchSalesOutBill(String field,Object max,Object min) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.getSalesOutBillID    | 语法   | public String getSalesOutBillID(SalesOutBillType type) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.addAlarmBill         | 语法   | public ResultMessage addAlarmBill(AlarmBillPO po) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.prefixSearchAlarmBill | 语法   | public ArrayList<AlarmBillPO> prefixSearchAlarmBill(String field, String val) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| BillDataServiceImpl.getAlarmID           | 语法   | public String getAlarmID()               |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |



#### 4.3.5 Account模块

模块内部的接口规范

| 提供的服务（供接口）                           |      |                                          |
| ------------------------------------ | ---- | ---------------------------------------- |
| AccountDataServiceImpl.addAccount    | 语法   | public ResultMessage addAccount（AccountVO account) |
|                                      | 前置条件 | account.name不能与之前的重复                     |
|                                      | 后置条件 | 无                                        |
| AccountDataServiceImpl.deleteAccount | 语法   | public ResultMessage deleteAccount（string name) |
|                                      | 前置条件 | name必须已经存在的账户列表中                         |
|                                      | 后置条件 | 无                                        |
| AccountDataServiceImpl.modifyAccount | 语法   | public ResultMessage modifyAccount（string oldname,string newname) |
|                                      | 前置条件 | oldname已经存在于账号列表中而newname不存在于账户列表中       |
|                                      | 后置条件 | 无                                        |
| AccountDataServiceImpl.checkAccount  | 语法   | public AccountVO checkAccount(String name) |
|                                      | 前置条件 | name已经存在于账户列表中                           |
|                                      | 后置条件 | 返回已经写入账户信息（具体参见Account类说明表）的Account      |
| AccountDataServiceImpl.income        | 语法   | public void income(String name, int income) |
|                                      | 前置条件 | 无                                        |
|                                      | 后置条件 | 无                                        |
| AccountDataServiceImpl.pay           | 语法   | public void pay(String name,int pay)     |
|                                      | 前置条件 | 无                                        |
|                                      | 后置条件 | 无                                        |

#### 4.3.6 Customer模块

提供的服务（供接口）

| 服务名                                     | 服务   | 服务                                       |
| --------------------------------------- | ---- | ---------------------------------------- |
| CustomerDataServiceImpl.addCustomer     | 语法   | public boolean addCustomer(CustomerPO customer) |
|                                         | 前置条件 | 输入的信息符合规范                                |
|                                         | 后置条件 | 系统新建一个客户，并提示新建成功                         |
| CustomerDataServiceImpl.delCustomer     | 语法   | public boolean delCustomer(String ID);   |
|                                         | 前置条件 | 需要删除的用户存在于系统中                            |
|                                         | 后置条件 | 删除用户，返回true                              |
| CustomerDataServiceImpl.modifyCustomer  | 语法   | public boolean ModifyCustomer(CustomerPO modCustomer); |
|                                         | 前置条件 | 输入的信息符合规范                                |
|                                         | 后置条件 | 系统修改该客户的属性，并返回true                       |
| CustomerDataServiceImpl.getCustomerInfo | 语法   | public CustomerPO getCustomerInfo(String ID); |
|                                         | 前置条件 | 输入的客户编号符合规范                              |
|                                         | 后置条件 | 如果系统中有该客户，返回该客户的属性。否则返回null              |
| CustomerDataServiceImpl.searchCustomer  | 语法   | public ArrayList< CustomerPO > searchCustomer(String keytype, String keyword); |
|                                         | 前置条件 | 输入的关键词合法                                 |
|                                         | 后置条件 | 如果系统里有符合条件的客户，返回true，否则返回false           |
|                                         |      |                                          |
|                                         |      |                                          |

需要的服务（需接口）

| 服务名  | 服务   |
| ---- | ---- |
|      |      |
|      |      |



#### 4.3.7 Log模块

模块内部的接口规范

| 提供的服务（供接口）                           |      |                                          |
| ------------------------------------ | ---- | ---------------------------------------- |
| AccountDataServiceImpl.addAccount    | 语法   | public ResultMessage addAccount（AccountVO account) |
|                                      | 前置条件 | account.name不能与之前的重复                     |
|                                      | 后置条件 | 无                                        |
| AccountDataServiceImpl.deleteAccount | 语法   | public ResultMessage deleteAccount（string name) |
|                                      | 前置条件 | name必须已经存在的账户列表中                         |
|                                      | 后置条件 | 无                                        |
| AccountDataServiceImpl.modifyAccount | 语法   | public ResultMessage modifyAccount（string oldname,string newname) |
|                                      | 前置条件 | oldname已经存在于账号列表中而newname不存在于账户列表中       |
|                                      | 后置条件 | 无                                        |
| AccountDataServiceImpl.checkAccount  | 语法   | public AccountVO checkAccount(String name) |
|                                      | 前置条件 | name已经存在于账户列表中                           |
|                                      | 后置条件 | 返回已经写入账户信息（具体参见Account类说明表）的Account      |
| AccountDataServiceImpl.income        | 语法   | public void income(String name, int income) |
|                                      | 前置条件 | 无                                        |
|                                      | 后置条件 | 无                                        |
| AccountDataServiceImpl.pay           | 语法   | public void pay(String name,int pay)     |
|                                      | 前置条件 | 无                                        |
|                                      | 后置条件 | 无                                        |

#### 

#### 4.3.8 GeneralAccount模块

模块内部的接口规范

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| GeneralAccountDataServiceImpl.newGeneralAccount | 语法   | public ResultMessage newGeneralAccount(GeneralAccountVO generalaccount) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回期初建账的结果ResultMessa                     |
| GeneralAccountDataServiceImpl.checkGeneralAccount | 语法   | public ArrayList<GeneralAccountVO checkGenerlalAccount(Time begin,Time end) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回期初建账的信息，如果不存在，则返回空VO                   |

#### 4.3.9 Promotion模块

| 提供的服务                                    |      | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| PromotionDataServiceImpl.addCustomerPromotion | 语法   | public ResultMessage addCustomerPromotion(CustomerPromotionPO po) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| PromotionDataServiceImpl.updateCustomerPromotion | 语法   | public ResultMessage updateCustomerPromotion(CustomerPromotionPO po) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| PromotionDataServiceImpl.deleteCustomerPromotion | 语法   | public ResultMessage deleteCustomerPromotion(String id) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| PromotionDataServiceImpl.multiSearchCustomerPromotion | 语法   | public ArrayList<CustomerPromotionPO> multiSearchCustomerPromotion(ArrayList<CriteriaClause> criteriaClauses) |
|                                          | 前置条件 | criteriaClauses必须按规范初始化                  |
|                                          | 后置条件 | 无                                        |
| PromotionDataServiceImpl.addGroupPromotion | 语法   | public ResultMessage addGroupPromotion(GroupPromotionPO po) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| PromotionDataServiceImpl.updateGroupPromotion | 语法   | public ResultMessage updateGroupPromotion(GroupPromotionPO po) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| PromotionDataServiceImpl.deleteGroupPromotion | 语法   | public ResultMessage deleteGroupPromotion(String id) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| PromotionDataServiceImpl.multiSearchGroupPromotion | 语法   | public ArrayList<GroupPromotionPO> multiSearchGroupPromotion(ArrayList<CriteriaClause> criteriaClauses) |
|                                          | 前置条件 | criteriaClauses必须按规范初始化                  |
|                                          | 后置条件 | 无                                        |
| PromotionDataServiceImpl.addGrossPromotion | 语法   | public ResultMessage addGrossPromotion(GrossPromotionPO po) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| PromotionDataServiceImpl.updateGrossPromotion | 语法   | public ResultMessage updateGrossPromotion(GrossPromotionPO po) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| PromotionDataServiceImpl.deleteGrossPromotion | 语法   | public ResultMessage deleteGrossPromotion(String id) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| PromotionDataServiceImpl.multiSearchGrossPromotion | 语法   | public ArrayList<GrossPromotionPO> multiSearchGrossPromotion(ArrayList<CriteriaClause> criteriaClauses) |
|                                          | 前置条件 | criteriaClauses必须按规范初始化                  |
|                                          | 后置条件 | 无                                        |



### 5 依赖视角

进销存管理系统MSPSS客户端开发包图如图5-1所示，服务器端开发包图如图5-2所示。

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%BF%9B%E8%B4%A7%E9%94%80%E5%94%AE%E7%B3%BB%E7%BB%9FMSPSS%E5%AE%A2%E6%88%B7%E7%AB%AF%E5%BC%80%E5%8F%91%E5%8C%85%E5%9B%BE.png)

图5-1进销存管理系统MSPSS客户端开发包图

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%BF%9B%E9%94%80%E5%AD%98%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9FMSPSS%E6%9C%8D%E5%8A%A1%E5%99%A8%E7%AB%AF%E9%80%BB%E8%BE%91%E5%8C%85%E5%9B%BE.png)

图5-2进销存管理系统MSPSS服务器端开发包图

### 6 内聚和耦合的度量

