$(document).ready(function() {
    var maxHeight = -1;

    maxHeight = $(document).height()-120;
    height = maxHeight+"px";
    $(".mainBody").css("height", height);
    console.log("Adjusted height is "+height);
  });
