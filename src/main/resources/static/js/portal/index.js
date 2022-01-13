$(function () {
    $.ajax({
        type: "GET",
        url: '/app/getApp',
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                $("#apps").append("<div class=\"layui-col-sm6 layui-col-md3\">\n" +
                    "          <div class=\"content\">\n" +
                    "            <div id=\"apps\">\n" +
                    "              <a id=\"appUrl\" href='" + data[i].appUrl + "' target=\"_blank\">\n" +
                    "               <img src=" + data[i].imgUrl + " style=\"width: 100%;height: 110px;\">\n" +
                    "              </a>\n" +
                    "              <p id=\"appName\" style=\"font-weight: bold;\n" +
                    "    color: darkcyan;\">" + data[i].appName + "</p>\n" +
                    "              <p id=\"appIntroduce\" style=\"overflow: hidden;text-align: left;\n" +
                    "    text-overflow: ellipsis;\n" +
                    "    display: -webkit-box;\n" +
                    "    -webkit-line-clamp: 2;\n" +
                    "    -webkit-box-orient: vertical;\n" +
                    "    text-indent: 10px;\n" +
                    "    height: 50px;\">" + data[i].appIntroduce + "</p>\n" +
                    "              <a id=\"appUrl\" href='" + data[i].appUrl + "' style='color: lightseagreen'>快速访问 ></a>\n" +
                    "            </div>\n" +
                    "          </div>\n" +
                    "        </div>");
            }
        }
    })
})