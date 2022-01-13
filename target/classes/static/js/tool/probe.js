/**
 * 应用管理
 */
var pageCurr;
var form;
$(function () {
    layui.use('table', function () {
        var table = layui.table;
        form = layui.form;

        tableIns = table.render({
            elem: '#probeList',
            url: '/tool/getProbeList',
            method: 'post', //默认：get请求
            cellMinWidth: 80,
            page: true,
            request: {
                pageName: 'pageNum', //页码的参数名称，默认：pageNum
                limitName: 'pageSize' //每页数据量的参数名，默认：pageSize
            },
            response: {
                statusName: 'code', //数据状态的字段名称，默认：code
                statusCode: 200, //成功的状态码，默认：0
                countName: 'totals', //数据总数的字段名称，默认：count
                dataName: 'list' //数据列表的字段名称，默认：data
            },
            cols: [[
                {type: 'numbers'}
                , {field: 'code', title: '状态码', align: 'center'}
                , {field: 'source_ip', title: '源IP', align: 'center'}
                , {field: 'source_port', title: '源端口', align: 'center'}
                , {field: 'target_ip', title: '目标IP', align: 'center'}
                , {field: 'target_port', title: '目标端口', align: 'center'}
                , {field: 'create_time', title: '开始时间', align: 'center'}
                , {field: 'update_time', title: '结束时间', align: 'center'}
                , {field: 'probe_results', title: '通信状态', align: 'center', templet: setState}
                , {field: 'detection_mode', title: '探测方式', align: 'center'}
                /*,{field: 'results_msg', title: '探测返回信息',align: 'center'}*/
                , {field: 'help_msg', title: '引导帮助', align: 'center'}
            ]],
            done: function (res, curr, count) {
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                //console.log(res);
                //得到当前页码
                console.log(curr);
                //得到数据总量
                //console.log(count);
                pageCurr = curr;
            }
        });

        //设置通信状态
        function setState(tableIns) {
            var probe_results = tableIns.probe_results;
            if (probe_results == "通信正常") {
                return "<span style='color:#009688;'>通信正常</span>";
            } else {
                return "<span style='color:#FF5722;'>通信异常</span>";
            }
        }

        //监听提交
        form.on('submit(probeSubmit)', function (data) {
            // TODO 校验
            formSubmit(data);
            return false;
        });
    });

    //搜索框
    layui.use(['form', 'laydate'], function () {
        var form = layui.form, layer = layui.layer
            , laydate = layui.laydate;
        //日期区间查询
        laydate.render({
            elem: '#create_time'
            , type: 'datetime'
        });
        laydate.render({
            elem: '#update_time'
            , type: 'datetime'
        });
        //TODO 数据校验
        //监听搜索框
        form.on('submit(searchSubmit)', function (data) {
            //重新加载table
            load(data);
            return false;
        });
    });
});

//提交表单
function formSubmit(obj) {
    $.ajax({
        type: "POST",
        data: $("#appForm").serialize(),
        url: "/app/setApp",
        success: function (data) {
            if (data.code == 1) {
                layer.alert(data.msg, function () {
                    layer.closeAll();
                    reload();
                });
            } else {
                layer.alert(data.msg);
            }
        },
        error: function () {
            layer.alert("操作请求错误，请您稍后再试", function () {
                layer.closeAll();
                //加载load方法
                reload();//自定义
            });
        }
    });
}

//添加探测
function addProbe() {
    openApp(null, "添加探测");
}

//打开编译框
function openApp(data, title) {
    if (data == null || data == "") {
        $("#id").val("");
    } else {
        //回显数据
        $("#id").val(data.id);
        $("#appName").val(data.appName);
        $("#appUrl").val(data.appUrl);
        $("#imgUrl").val(data.imgUrl);
        $("#appIntroduce").val(data.appIntroduce);
    }

    layer.open({
        type: 1,
        title: title,
        fixed: false,
        resize: false,
        shadeClose: true,
        area: ['550px'],
        content: $('#setProbe'),
        end: function () {
            cleanApp();
        }
    });
}


//重载table
function load(obj) {
    tableIns.reload({
        where: obj.field
        , page: {
            curr: pageCurr //从当前页码开始
        }
    });
}

function reload() {
    tableIns.reload({
        page: {
            curr: pageCurr //从当前页码开始
        }
    });
}


function cleanApp() {
    $("#appName").val("");
    $("#appUrl").val("");
    $("#appIntroduce").val("");
}
