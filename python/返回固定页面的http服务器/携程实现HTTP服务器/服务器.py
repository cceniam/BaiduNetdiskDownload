import socket
import re
import gevent
from gevent import monkey
monkey.patch_all()


def client_sever(new_socket):
    """为客户端返回数据"""
    # 1.接受请求
    request = new_socket.recv(1024)
    request = request.decode("utf-8")
    # print(request)
    request_lines = request.splitlines()
    print(request_lines[0])
    # 分析请求
    ret = re.match(r"[^/]+(/[^ ]*)", request_lines[0])
    if ret:
        filename = ret.group(1)
        print("*" * 40 + filename)
    #  2.返回数据
    # 2.1 准备发送给浏览器的数据 - header
    response = "HTTP/1.1 200 ok\r\n"
    response += "\r\n"
    filea = open("./2.htm", "rb")
    content = filea.read()
    filea.close()
    # 2.2 准备发送给浏览器的数据 - body
    response += "<h1>dsafasf<h1>"
    new_socket.send(response.encode("utf-8"))
    new_socket.send(content)
    # 关闭套接字
    new_socket.close()


def main():
    """创建套接字"""
    tcp_sever = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    """绑定套接字"""
    tcp_sever.bind(('', 7890))
    '''变为监听套接字'''
    tcp_sever.listen(128)

    """为客户服务"""
    while True:
        """等待新客户链接"""
        new_socket, client_addr = tcp_sever.accept()
        """为这个客户服务"""

        p = gevent.spawn(client_sever,new_socket)

        # new_socket.close()
   # client_sever(new_socket)

    tcp_sever.close()


if __name__ == "__main__":
    main()
