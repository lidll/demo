layui.define(function(exports){
    var obj = {
        hello: function(str){
            alert('Hello '+ (str||'layDemo'));
        }
    };
    //输出test接口
    exports('layDemo', obj);
})