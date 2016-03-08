package service;

import beans.Profit;
import dao.JdbcConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rxb14 on 2016/3/8.
 */
public class Service {
    private Connection conn;
    private Statement st1,st2,st3;
    private ResultSet rs1,rs2,rs3;
    private String sql;
    private List list;
    private Profit pf;

    public List getProfit() throws SQLException {
        list = new ArrayList();
        conn = JdbcConn.getConn();
        st1 = conn.createStatement();
        st2 = conn.createStatement();
        st3 = conn.createStatement();
        sql = "select g.goods_name goodsName,g.selling sellingprice,g.cost_price costPrice,g.goods_id goodsId from goodsinfo g,tradinginfo t where t.trading_goods_id=g.goods_id GROUP BY g.goods_name";
        rs1 = st1.executeQuery(sql);
        double temp;
        while (rs1.next()){
            pf = new Profit();
            pf.setGoodsName(rs1.getNString("goodsName"));
            pf.setSellingPrice(rs1.getDouble("sellingPrice"));
            pf.setCostPrice(rs1.getDouble("costPrice"));
            pf.setGoodsId(rs1.getInt("goodsId"));
            temp = 0.0;
            //交易一笔的利润
            temp = pf.getSellingPrice() - pf.getCostPrice();

            sql="select SUM(t.trading_number) sumNum from tradinginfo t WHERE t.trading_goods_id= '"+pf.getGoodsId()+"'";
            rs2 = st2.executeQuery(sql);
            while(rs2.next()){
                //交易数量
                pf.setTradingNum(rs2.getInt("sumNum"));
            }
            //总利润
            pf.setProfit(temp*pf.getTradingNum());

            sql = "SELECT SUM(t.trading_goods_id) times from tradinginfo t where t.trading_goods_id= '"+pf.getGoodsId()+"'";
            rs3 = st3.executeQuery(sql);
            while(rs3.next()){
                //设置交易次数
                pf.setTimes(rs3.getInt("times"));
            }
            list.add(pf);
        }
        return list;
    }
}
