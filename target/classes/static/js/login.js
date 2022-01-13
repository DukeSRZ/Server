/**
 * 登录
 */
$(function () {
    layui.use(['carousel', 'form', 'layer'], function () {
        var carousel = layui.carousel;
        var form = layui.form;
        var layer = layui.layer;
        form.on("submit(login)", function () {
            login();
            return false;
        });
        var path = window.location.href;
        if (path.indexOf("kickout") > 0) {
            layer.alert("您的账号已在别处登录；若不是您本人操作，请立即修改密码！", function () {
                window.location.href = "/login";
            });
        }

        //设置轮播主体高度
        var zyl_login_height = $(window).height() / 1.3;
        var zyl_car_height = $(".zyl_login_height").css("cssText", "height:" + zyl_login_height + "px!important");


        //Login轮播主体
        carousel.render({
            elem: '#zyllogin'//指向容器选择器
            , width: '100%' //设置容器宽度
            , height: zyl_car_height
            , autoplay: true //是否自动切换false true
            , indicator: 'none' //指示器位置||外部：outside||内部：inside||不显示：none
            , interval: '5000' //自动切换时间:单位：ms（毫秒）
        });

        //粒子线条
        $(".zyl_login_cont").jParticle({
            background: "rgba(0,0,0,0)",//背景颜色
            color: "#fff",//粒子和连线的颜色
            particlesNumber: 100,//粒子数量
            //disableLinks:true,//禁止粒子间连线
            //disableMouse:true,//禁止粒子间连线(鼠标)
            particle: {
                minSize: 1,//最小粒子
                maxSize: 3,//最大粒子
                speed: 30,//粒子的动画速度
            }
        });
    })
})

function login() {
    var username = $("#username").val();
    var password = $("#password").val();
    $.post("/user/login", $("#useLogin").serialize(), function (data) {
        if (data.code == 1) {
            window.location.href = data.url;
        } else {
            layer.alert(data.message, function () {
                layer.closeAll();//关闭所有弹框
            });
        }
    });
}