package com.elangzhi.sjy.beans;

import java.util.List;

/**
 * TradeList 实体
 * Created by Administrator on 2016/12/21.
 */

public class TradeList {

    /**
     * 是否还有下一页
     */
    Boolean hasNextPage;

    /**
     * 列表
     */
    List<Trade> tradeList;

    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public List<Trade> getTradeList() {
        return tradeList;
    }

    public void setTradeList(List<Trade> tradeList) {
        this.tradeList = tradeList;
    }

}
