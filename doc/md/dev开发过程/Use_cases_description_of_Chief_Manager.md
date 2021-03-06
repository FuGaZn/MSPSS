###                   进销存系统用例文档

| **ID**   | 14                                       | **名称**      | 查看导出销售明细表 |
| -------- | ---------------------------------------- | ----------- | --------- |
| **创建者**  | 刘雅歆                                      | **最后一次更新者** | 刘雅歆       |
| **创建日期** | 2017.9.14                                | **最后更新日期**  | 2017.9.30 |
| **参与者**  | 总经理或财务人员，目标是方便地阅读销售明细表以便制定合理的销售策略        |             |           |
| **触发条件** | 参与者（总经理或财务人员）决定查看销售明细表                   |             |           |
| **前置条件** | 用户必须已经登录系统                               |             |           |
| **后置条件** | 系统中的销售数据不会发生改变，但系统记录日志会增加一条记录描述本次查看的相关信息 |             |           |
| **优先级**  | 高                                        |             |           |
| **正常流程** | 1.用户申请查看销售明细表2.系统检查用户权限，有查看权限提示用户选择**时间区间，商品名，客户，业务员，仓库**中的一个或多个条件作为筛选条件，否则提示用户没有查看权限，退出查询销售明细表功能3.用户输入一个或多个条件要求系统查询4.系统以列表形式输出符合筛选条件的**时间（精确到天），商品名，型号，数量，单价，总额**共六种数据信息5.用户要求系统导出报表6.系统将报表以excel形式导出到本地7.用户要求退出查看销售明细表，系统退出8.系统日志根据用户查询的信息增加一条记录 |             |           |
| **扩展流程** | 4a、当前筛选条件下没有符合要求的数据系统提示没有满足条件的销售明细表5a、用户不导出销售明细表而是继续查看其他销售明细表         1.系统执行正常流程第2步5b、用户退出查看销售明细表        1.系统退出查看销售明细表功能7a、用户要求继续查看其他销售明细表        1.系统执行正常流程第2步 |             |           |
| **特殊需求** | 1.如果未来对销售明细表要求输出更多数据应予以支持                |             |           |

| **ID**   | 15                                       | **名称**      | 查看导出经营情况表 |
| -------- | ---------------------------------------- | ----------- | --------- |
| **创建者**  | 刘雅歆                                      | **最后一次更新者** | 刘雅歆       |
| **创建日期** | 2017.9.14                                | **最后更新日期**  | 2017.9.30 |
| **参与者**  | 总经理或财务人员，目标是方便地阅读经营情况表以便制定合理的销售策略        |             |           |
| **触发条件** | 参与者（总经理或财务人员）决定查看经营情况表                   |             |           |
| **前置条件** | 用户必须已经登录系统                               |             |           |
| **后置条件** | 系统中的销售数据不会发生改变，但系统记录日志会增加一条记录描述本次查看的相关信息 |             |           |
| **优先级**  | 高                                        |             |           |
| **正常流程** | 1.用户申请查看经营情况表2.系统检查用户权限，有查看权限提示用户选择**时间区间**作为筛选条件，否则提示用户没有查看权限，要求用户退出查询经营情况表功能3.用户输入起始时间要求系统查询4.系统以列表形式输出符合筛选条件的（1）收入类（折让后总收入、折让了多少）（2）支出类（总支出）（3）利润（折让后总收入-总支出）5.用户要求系统导出报表6.系统将报表以excel形式导出到本地7.用户要求退出查看经营情况表，系统退出8.系统日志根据用户查询的信息增加一条记录 |             |           |
| **扩展流程** | 4a、当前筛选条件下没有符合要求的数据系统提示没有满足条件的经营情况表5a、用户不导出经营情况表表而是继续查看其他经营情况表         1.系统执行正常流程第2步5b、用户退出查看经营情况表        1.系统退出查看经营情况表功能7a、用户要求继续查看其他经营情况表        1.系统执行正常流程第2步 |             |           |
| **特殊需求** | 1.如果未来对经营情况表有要求输出更多数据应予以支持               |             |           |

| **ID**   | 16                                       | **名称**      | 审批单据      |
| -------- | ---------------------------------------- | ----------- | --------- |
| **创建者**  | 刘雅歆                                      | **最后一次更新者** | 刘雅歆       |
| **创建日期** | 2017.9.14                                | **最后更新日期**  | 2017.9.30 |
| **参与者**  | 总经理，目标是及时准确地审批其他系统用户提交的报表以保证相关工作顺利进行     |             |           |
| **触发条件** | 参与者（总经理）决定审批单据                           |             |           |
| **前置条件** | 用户必须已经登录系统                               |             |           |
| **后置条件** | 修改系统中被审批单据的状态，从待审批变为已审批，并给单据提交用户发送信息表明单据当前状态，系统记录日志会增加一条记录描述单据被审批过程的信息 |             |           |
| **优先级**  | 高                                        |             |           |
| **正常流程** | 用户向系统要求审批单据系统检查用户审批单据权限，有审批权限则输出当前提交单据列表，否则提示用户没有审批权限，要求用户退出审批单据功能用户选择一个或多个单据并确认系统提示用户选择批准或不批准单据用户选择批准或不批准，提交当前单据审批结果系统修改被审批单据状态，从提交改为已审批系统修改被审批通过单据对应的相关数据：库存赠送单：根据单据修改商品对应的库存数量库存报溢单：根据单据增加该商品的库存数量库存报损单：根据单据减少该商品的库存数量进货单/进货退货单/销售单/销售退货单：根据单据修改库存数据和客户的应收应付数据收款单/付款单：根据单据修改客户的应付数据系统给单据提交者发送信息提示单据状态系统输出当前提交单据列表用户结束审批单据，退出审批单据功能系统日志中增加本次单据审核的相关记录 |             |           |
| **扩展流程** | 2a、提交单据列表为空        1.系统提示提交单据列表为空并拒绝继续进行之后的操作3a、用户要求查看一张单据的详细信息        1.系统输出该张单据的详细信息3b、用户要求退出审批单据        1.系统执行正常流程第7步3c、用户要求系统清空已选单据        1.系统清空当前已选单据9a、当前筛选条件下没有更多单据系统不显示提交单据为空 |             |           |
| **特殊需求** | 1.未来如果增加单据类型则系统应该支持新类型单据的审批              |             |           |

| **ID**   | 17                                       | **名称**      | 查询日志      |
| -------- | ---------------------------------------- | ----------- | --------- |
| **创建者**  | 刘雅歆                                      | **最后一次更新者** | 刘雅歆       |
| **创建日期** | 2017.9.14                                | **最后更新日期**  | 2017.9.30 |
| **参与者**  | 总经理，目标是观察其他用户的交易记录，监测系统运行状况              |             |           |
| **触发条件** | 参与者决定调取日志内容                              |             |           |
| **前置条件** | 用户必须已经登录系统                               |             |           |
| **后置条件** | 数据项不会发生变化，系统日志中增加一条记录，记录查询日志的用户和时间       |             |           |
| **优先级**  | 高                                        |             |           |
| **正常流程** | 用户向系统要求查询日志系统检查用户查询日志权限，有审批权限则输出日志列表列表，否则提示用户没有查询权限，要求用户退出查询日志功能系统输出日志列表用户选择一条日志要求查看其详细内容系统输出该条日志的详细内容用户阅读日志后返回日志列表系统输出日志列表用户退出查询日志功能，系统退出系统在日志中增加一条记录，记录查询日志的用户和时间 |             |           |
| **扩展流程** | 无                                        |             |           |
| **特殊需求** | 无                                        |             |           |

| **ID**   | 18                                       | **名称**      | 制定促销策略    |
| -------- | ---------------------------------------- | ----------- | --------- |
| **创建者**  | 刘雅歆                                      | **最后一次更新者** | 刘雅歆       |
| **创建日期** | 2017.9.14                                | **最后更新日期**  | 2017.9.15 |
| **参与者**  | 总经理，目标是提高销售总额，增加公司盈利                     |             |           |
| **触发条件** | 参与者根据当前经营情况决定制定促销策略                      |             |           |
| **前置条件** | 用户必须已经登录系统                               |             |           |
| **后置条件** | 促销策略针对的用户的价格折让数、可用代金券数量、可获得赠品参数被更新，策略针对的商品的价格被更新、不同总价对应的促销策略被更新 |             |           |
| **优先级**  | 高                                        |             |           |
| **正常流程** | 1.总经理申请制定促销策略2.系统审核用户制定促销策略权限，有制定促销策略权限则提示总经理输入活动的开始时间和结束时间，否则提示没有制定促销策略权限，要求用户退出制定促销策略功能3.总经理输入开始时间和结束时间4.系统提示总经理选择要制定的促销策略类型5.总经理选择一种促销策略类型6.1 系统读取总经理选择的促销类型是针对不同级别的用户赠送赠品：1.系统提示总经理选择针对的用户级别2.总经理输入针对的用户级别3.系统提示总经理选择赠品名称、数量4.总经理输入赠品名称、数量5.系统获取总经理的输入，记录赠品信息6.系统提示赠送赠品策略制定成功7.系统生成库存赠送单6.2 系统读取总经理选择的促销类型是针对不同级别的用户提供价格折让1.系统提示总经理选择针对的用户级别2.总经理输入针对的用户级别3.系统读取总经理选择的用户级别4.系统提示总经理输入价格折让额度5.总经理输入价格折让额度6.系统读取价格折让额度，记录价格折让信息7.系统提示价格折让策略制定成功6.3 系统读取总经理选择的是针对不同级别的用户提供代金券1.系统提示总经理选择针对的用户级别2.总经理输入针对的用户级别系统3.读取总经理选择的用户级别4.系统提示总经理输入代金券面额、张数5.总经理输入代金券面额、张数6.系统读取代金券面额、张数，记录代金券额度信息7.系统提示提供代金券策略制定成功6.4 系统读取总经理选择的是制定特价包（组合商品降价）1.系统提示总经理选择包内商品和特价包价格2.总经理输入包内商品和特价包价格3.系统读取包内商品及特价包价格，记录特价包信息4.系统提示特价包制定成功6.5 系统读取总经理选择的促销类型是针对不同总价赠送赠品：1.系统提示总经理选择针对的总价区间2.总经理输入针对的总价区间3.系统提示总经理选择赠品名称、数量4.总经理输入赠品名称、数量5.系统获取总经理的输入，记录赠品信息6.系统提示赠送赠品策略制定成功7.系统生成库存赠送单6.6 系统读取总经理选择的是针对不同总价提供代金券1.系统提示总经理选择针对的总价区间2.总经理输入针对的总价3.系统读取总经理选择的总价区间4.系统提示总经理输入代金券面额、张数5.总经理输入代金券面额、张数6.系统读取代金券面额、张数，记录代金券额度信息7.系统提示提供代金券促销策略制定成功7.重复第2步~第6步直到总经理完成所有策略制定8.用户要求系统退出制定促销策略，系统退出 |             |           |
| **扩展流程** | 5a、用户放弃制定促销策略        1.系统执行正常流程第8步6.x.5a、用户要求清空已输入信息        1.系统清空已输入信息6.x.5b、用户输入信息不完整        1.系统提示用户重新输入信息6.x.a、用户要求重新选择策略类型        1.系统执行正常流程第4步6.x.7a、用户制定的策略与已有策略重复        1.系统提示用户策略重复        2.系统返回正常流程6.x.1 |             |           |
| **特殊需求** | 1.未来如果增加新的策略类型应支持对新策略的制定                 |             |           |