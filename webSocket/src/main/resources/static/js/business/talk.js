
window.onload = function(){
    var Words = document.getElementById("words");
    var Who = document.getElementById("who");
    var TalkWords = document.getElementById("talkwords");
    var TalkSub = document.getElementById("talksub");


    TalkSub.onclick = function(){
        //定义空字符串
        var str = "";
        if(TalkWords.value == ""){
            // 消息为空时弹窗
            alert("消息不能为空");
            return;
        }
        if(Who.value == 1){
            socket.send('[{"toUserId":"' + $("#toUserId").val() + '","contentText":"' + TalkWords.value + '"}]');
            str = '<div class="btalk"><span>我说 :' + TalkWords.value +'</span></div>' ;
        }else{
            alert("未登录");
        }
        Words.innerHTML = Words.innerHTML + str;
    }

}

//webSocket
var socket;
var fromUserId;
var toUserId;

function openSocket() {
    if(typeof(WebSocket) == "undefined") {
        console.log("您的浏览器不支持WebSocket");
    }else{
        console.log("您的浏览器支持WebSocket,准备创建聊天窗口...");
        //实现化WebSocket对象，指定要连接的服务器地址与端口  建立连接
        if ($("#userId").val() === fromUserId) {
            alert("请勿重复填此id");
            return false;
        }
        fromUserId = $("#userId").val();
        toUserId = $("#toUserId").val();
        var socketUrl="ws://lifeidll.free.idcfengye.com/websocket/"+$("#userId").val();
        console.log(socketUrl)
        socket = new WebSocket(socketUrl);
        //打开事件
        socket.onopen = function() {
            console.log("websocket已打开");
            //socket.send("这是来自客户端的消息" + location.href + new Date());
        };
        /*
        获得消息事件
         */
        socket.onmessage = function(msg) {
            console.log(msg.data);
            var talkDTO = JSON.parse(msg.data);
            if (talkDTO.code == 200) {  //建立连接成功
                $("#status").html("连接成功!let's talk!");
                //更新当前用户显示
                $("#who").html("当前用户:"+fromUserId);
                $("#who").val("1");
            }else if(talkDTO.code == 302){ //接收消息
                var Words = document.getElementById("words");
                var str = '<div class="atalk"><span>'+talkDTO.fromUserId +'说 :' + talkDTO.contentText +'</span></div>';
                Words.innerHTML = Words.innerHTML + str;
            }else if(talkDTO.code == 500){//发生错误时
                alert(talkDTO.status);
            }
        };
        //关闭事件
        socket.onclose = function() {
            console.log("websocket已关闭");
        };
        //发生了错误事件
        socket.onerror = function() {
            console.log("websocket发生了错误");
        }
    }
}
function sendMessage() {
    if (typeof (WebSocket) == "undefined") {
        console.log("您的浏览器不支持WebSocket");
    } else {
        //建立聊天
        console.log("发送消息");
        console.log('[{"toUserId":"' + $("#toUserId").val() + '","contentText":"' + $("#contentText").val() + '"}]');
        socket.send('[{"toUserId":"' + $("#toUserId").val() + '","contentText":"' + $("#contentText").val() + '"}]');
    }
}
