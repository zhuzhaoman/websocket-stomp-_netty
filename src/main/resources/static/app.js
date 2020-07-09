let stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);

    if (connected) {
        $("#conversation").show();
        $("#chat").show();
    } else {
        $("#conversation").hide();
        $("#chat").hide();
    }

    $("#greetings").html("");
}

/**
 * connect 方法表示建立一个 WebSocket 连接，在建立 WebSocket 连接时，用户必须先输入用户
 名， 然后才能建立连接
 */
function connect() {
    if (!$("#name").val()) {
        return ;
    }

    /**
     * SockJS 建立连接
     * 然后创建一个 STOMP 实例发起连接请求
     */
    let socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        // 调用 setConnected(true)方法进行页面的设直
        setConnected(true);
        // STOMP 中的subscribe 方法订阅服务端发送回来的消息,
        // 并将服务端发送来的消息展示出来（使用showGreeting 方法）
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body))
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }

    setConnected(false);
}

function sendName() {
    stompClient.send("/app/hello", {},
        JSON.stringify({'name': $("#name").val(), 'content': $("#content").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<div>" + message.name + ":" + message.content + "</div>");
}

$(function () {
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendName();
    });
});