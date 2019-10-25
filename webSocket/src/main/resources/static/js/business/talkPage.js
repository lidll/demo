// layui.use(['layer', 'form'], function(){
//     var layer = layui.layer
//         ,form = layui.form;
//
//     layer.msg('Hello World');
// });
layui.config({
    base:'/js/leyModels'//扩展模块的位置
}).extend({
    layDemo:'layDemo'
});
layui.use(['layDemo'],function(){
    var layDemo = layui.layDemo;


})