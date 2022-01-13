layui.use('upload', function () {
    var $ = layui.jquery
        , upload = layui.upload;

    //选完文件后不自动上传
    upload.render({
        elem: '#test10'
        , url: '/app/uploadAppList'
        , accept: 'file'  //普通文件
        , exts: 'xlsx|xls' //设置文件格式
        , done: function (res) {
            layer.msg('上传成功');
            console.log(res)
        }
    });
});