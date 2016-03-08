<%@page import="beans.Profit"%>
<%@ page language="java" import="java.util.*,servlet.*" contentType="text/html; charset=utf-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>javaweb-报表</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <!--
  <link rel="stylesheet" type="text/css" href="styles.css">
  -->

  <style type="text/css">
    table.hovertable{
      font-family: "微软雅黑";
      font-size: 13px;
      color:#333333;
      border-width: 1px;
      border-color: #999999;
      border-collapse: collapse;
    }

    table.hovertable th{
      background-color: #c3dde0;
      border-width: 1px;
      padding: 8px;
      border-style: solid;
      border-color: #a9c6c9;
    }

    table.hovertable tr{
      background-color: #d4e3e8;
    }

    table.hovertable td{
      border-width: 1px;
      padding: 8px;
      border-style: solid;
      border-color: #a9c6c9;
    }
  </style>
</head>

<body>
<form action="chart" method="post">
  <input type="submit" value="生成报表">
</form>
<table class="hovertable">
  <tr>
    <th colspan="5">利润表</th>
  </tr>
  <tr>
    <th>序号</th>
    <th>商品名称</th>
    <th>卖出数量</th>
    <th>交易笔数</th>
    <th>盈利额</th>
  </tr>
  <%
    List list =null;
    if(session.getAttribute("PROFIT")!=null){
      list =(List) session.getAttribute("PROFIT");

      if(list.size()>0){
        int temp=0;
        double  temp1=0;
        double  temp2=0;
        double 	temp3=0;
        Profit pf;
        for(int i=0;i<list.size();i++){
          pf= new Profit();
          pf=(Profit)list.get(i);
          temp1+=pf.getTradingNum();
          temp2+=pf.getTimes();
          temp3+=pf.getProfit();
  %>
  <tr onmouseover="this.style.backgroundColor='#ffff66';"
      onmouseout="this.style.backgroundColor='#d4e3e5'">
    <td><%=temp+=1 %></td>
    <td><%=pf.getGoodsName() %></td>
    <td><%=pf.getTradingNum() %></td>
    <td><%=pf.getTimes() %></td>
    <td><%=pf.getProfit() %></td>
  </tr>
  <%
    }%>

  <tr onmouseover="this.style.backgroundColor='#ffff66';"
      onmouseout="this.style.backgroundColor='#d4e3e5'">
    <td colspan="2">合计</td>
    <td><%=temp1%></td>
    <td><%=temp2 %></td>
    <td><%=temp3 %></td>
  </tr>

  <%
      }
    }
  %>

</table>
</body>
</html>
