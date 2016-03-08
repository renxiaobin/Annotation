package beans;

/**
 * 交易实体
 * Created by rxb14 on 2016/3/8.
 */
public class Trading {
    private int tradingId;
    private int tradingGoodsId;
    private int tradingUserId;
    private double tradingNum;

    public int getTradingId() {
        return tradingId;
    }

    public void setTradingId(int tradingId) {
        this.tradingId = tradingId;
    }

    public int getTradingGoodsId() {
        return tradingGoodsId;
    }

    public void setTradingGoodsId(int tradingGoodsId) {
        this.tradingGoodsId = tradingGoodsId;
    }

    public int getTradingUserId() {
        return tradingUserId;
    }

    public void setTradingUserId(int tradingUserId) {
        this.tradingUserId = tradingUserId;
    }

    public double getTradingNum() {
        return tradingNum;
    }

    public void setTradingNum(double tradingNum) {
        this.tradingNum = tradingNum;
    }
}
