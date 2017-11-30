package blimpl.commodityblimpl;

import network.CommodityClientNetworkService;
import po.CommodityPO;
import util.ResultMessage;
import vo.CommodityVO;
import vo.FilterFlagVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 23:13 2017/11/15/015
 */
public class Commodity {
    CommodityClientNetworkService netService;

    /**
     * 添加商品
     * @param commodityVO
     * @return
     */
    public ResultMessage addCommodity(CommodityVO commodityVO){
        CommodityPO po = new CommodityPO(commodityVO.name,commodityVO.classificationVO.getID(),commodityVO.type,commodityVO.ID,commodityVO.importCost,commodityVO.exportCost,commodityVO.numberInStock);
        //此时的ID为空
        return netService.addCommodity(po);
    }

    /**
     * 更新商品信息
     * @param commodityVO
     * @return
     */
    public ResultMessage updateCommodity(CommodityVO commodityVO){
        CommodityPO po = new CommodityPO(commodityVO.name,commodityVO.classificationVO.getID(),commodityVO.type,commodityVO.ID,commodityVO.importCost,commodityVO.exportCost,commodityVO.numberInStock);

        return netService.modifyCommodity(po);
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    public ResultMessage deleteCommodity(String id){
        CommodityPO po = netService.exactlySearchCommodity(id);
        //该商品已经有了使用记录
        if (po.isUsed())
            return ResultMessage.FAILED;

        return netService.deleteCommodity(po);
    }

    /**
     * 通过商品ID得到商品信息
     * @param id
     * @return
     */
    public CommodityVO getCommodity(String id){

        CommodityPO po = netService.exactlySearchCommodity(id);
        CommodityVO vo = new CommodityVO(po.getName(),po.getID(),po.getType(),po.getImportCost(),po.getExportCost(),
                        po.getNumberInStock());
        return vo;
    }

    /**
     * 搜索商品
     * @param flag
     * @return
     */
    public ArrayList<CommodityVO> searchCommodity(FilterFlagVO flag){
        return null;}


    /**
     * 按照进价升序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> BuyPriceAscendingSort(ArrayList< CommodityVO> vos){
         vos.sort(new BuyPriceAscendingComparator());
         return vos;
    }

    /**
     * 按照进价降序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> BuyPriceDescendingSort(ArrayList< CommodityVO> vos){
        vos.sort(new BuyPriceDescendingComparator());
        return vos;
    }

    /**
     * 按照售价升序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> sellPriceAscendingSort(ArrayList< CommodityVO> vos){
        vos.sort(new SellPriceAscendingComparator());
        return vos;
    }

    /**
     * 按照售价降序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> sellPriceDescendingSort(ArrayList< CommodityVO> vos)
    {   vos.sort(new SellPriceDescendingComparator());
        return vos;
    }

    /**
     * 按照库存数量降序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> StockDescendingSort(ArrayList< CommodityVO> vos){
        vos.sort(new StockAscendingComparator());
        return vos;
    }

    /**
     * 按照库存数量升序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> StockAscendingSort(ArrayList< CommodityVO> vos){
        vos.sort(new StockDescendingComparator());
        return vos;
    }

}
