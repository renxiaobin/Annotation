package beans;

/**
 * 利润实体
 * Created by rxb14 on 2016/3/7.
 */
public class Profit {
    private String goodsName;
    private int goodsId;
    private double costPrice;
    private double sellingPrice;
    private int tradingNum;
    private int times;
    private double profit;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getTradingNum() {
        return tradingNum;
    }

    public void setTradingNum(int tradingNum) {
        this.tradingNum = tradingNum;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
