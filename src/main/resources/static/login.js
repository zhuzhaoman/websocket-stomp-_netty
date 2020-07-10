let stompClient = null;

function connect () {
    let socket= new SockJS ('/chat');
    stompClient = Stomp.over(socket);

    stompClient.connect ({}, function (frame) {
        // 连接成功后，订阅的地址为"/user/queue/chat"
        // 该地址比服务端配直的地址多了"/user"前缀
        // SimpMessagingTemplate 类中自动添加了路径前缀
        stompClient.subscribe('/topic/all', function (res) {
            let data = JSON.parse(res.body)
            console.log("=========")
            console.log(data)
            console.log("=========")
        })
        stompClient.subscribe('/user/admin/appoint', function (res) {
            let data = JSON.parse(res.body)
            console.log("=========")
            console.log(data)
            console.log("=========")
        })
    });
}

function login() {
    stompClient.send('/app/login', {},
        JSON.stringify({'username': $("#username").val(), 'password': $("#password").val()}));
}

$(function () {
    connect()
    $("#login").click(function () {
        login();
    })
});