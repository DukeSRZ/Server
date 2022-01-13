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
            elem: '#appList',
            url: '/app/getAppList',
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
                , {field: 'appName', title: '应用名称', align: 'center'}
                , {field: 'appUrl', title: '应用地址', align: 'center'}
                , {field: 'createTime', title: '注册时间', align: 'center'}
                , {field: 'appIntroduce', title: '应用介绍', align: 'center'}
                , {field: 'imgUrl', title: '图片地址', align: 'center', hide: true}
                , {title: '操作', align: 'center', toolbar: '#optBar'}
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

        //监听工具条
        table.on('tool(appTable)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del') {
                //删除
                delApp(data, data.id);
            } else if (obj.event === 'edit') {
                //编辑
                openApp(data, "编辑");
            }
        });

        //监听提交
        form.on('submit(appSubmit)', function (data) {
            // TODO 校验
            formSubmit(data);
            return false;
        });
    });

    //图片上传
    layui.use('upload', function () {
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#uploadImg' //绑定元素
            , url: '/app/uploadImg' //上传接口
            , done: function (data) {
                //上传完毕回调
                $("#imgUrl").val(data[0]);
            }
            , error: function () {
                //请求异常回调
            }
        });
    });

    //搜索框
    layui.use(['form', 'laydate'], function () {
        var form = layui.form, layer = layui.layer
            , laydate = layui.laydate;
        //日期区间查询
        laydate.render({
            elem: '#startTime'
        });
        laydate.render({
            elem: '#endTime'
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

//注册应用
function addApp() {
    openApp(null, "注册应用");
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
        content: $('#setApp'),
        end: function () {
            cleanApp();
        }
    });
}

//删除
function delApp(obj, id) {
    if (null != id) {
        if (null != id) {
            layer.confirm('您确定要删除吗？', {
                btn: ['确认', '返回'] //按钮
            }, function () {
                $.post("/app/del", {"id": id}, function (data) {
                    if (data.code == 1) {
                        layer.alert(data.msg, function () {
                            layer.closeAll();
                            load(obj);
                        });
                    } else {
                        layer.alert(data.msg);
                    }
                });
            }, function () {
                layer.closeAll();
            });
        }
    }
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
