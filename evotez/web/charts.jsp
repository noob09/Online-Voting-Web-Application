<!doctype html>
<html>
<head>
  <script src="//cdn.anychart.com/js/7.8.0/anychart-bundle.min.js"></script>
  <style>
    html, body, #container {
      width: 100%;
      height: 100%;
      margin: 0;
      padding: 0;
    }
  </style>
</head>
<body>
    <div id="container"></div>
    <script type="text/javascript">

anychart.onDocumentReady(function() {
  // create pie chart with passed data
  chart = anychart.pie3d([
    ['DEM', 600],
    ['REP', 360],
 
    ['UNA', 40]
  ]);

  // set container id for the chart
  chart.container('container');
   // set chart title text settings
  chart.title('prediction details');

  // set chart labels position to outside
  chart.labels().position('outside');

  // set legend title text settings
  chart.legend(true);
  chart.legend().title('Party Details');

  // set legend position and items layout
  chart.legend().position('bottom');
  chart.legend().itemsLayout('horizontal');
  chart.legend().align('center');

  // initiate chart drawing
  chart.draw();
});
    </script>
</body>
</html>