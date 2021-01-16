<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/11
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Echarts</title>
    <meta charset="utf-8">
    <script src="js/echarts.min.js"></script>
    <script src="js/jquery.js"></script>
    <script src="js/theme/vintage.js"></script>
  </head>
  <body>
    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 1200px;height:900px;margin: auto"></div>
    <script type="text/javascript">
      // 基于准备好的dom，初始化echarts实例

      var myChart = echarts.init(document.getElementById('main'), 'vintage');
      // myChart.init(document.getElementById('main'), 'dark');

      $(document).ready(function () {
          // alert("加载完毕！")
      })

      $.get("Servlet", function (data) {

        // 指定图表的配置项和数据
        var option = {
          title: {
            text: '某站点用户访问来源',
            subtext: '纯属虚构',
            left: 'center'
          },
          tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
          },
          legend: {
            orient: 'vertical',
            left: 'left',
            data: data
          },
          series: [
            {
              name: '访问来源',
              type: 'pie',
              radius: '55%',
              center: ['50%', '60%'],
              data: data,
              emphasis: {
                itemStyle: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              }
            }
          ]
        };


        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
      }, 'json')

    </script>

  </body>
</html>
