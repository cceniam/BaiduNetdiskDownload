import socket


def main():
    # 创建套接字
    udp_socket1 = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    udp_socket2 = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    # 本地数据
    local_add = ("", 1234)
    local_add1 = ("", 2345)
    # 绑定本地端口
    udp_socket1.bind(local_add)
    udp_socket2.bind(local_add1)
    while True:
        # a 要发送的数据
        a = input("请输入数据：\n")
        # 输入1结束通讯
        if a == "1":
            break
        # 发送数据
        udp_socket1.sendto(a.encode("utf-8"), ("localhost", 2345))
        a = udp_socket2.recvfrom(1024)
        udp_socket2.sendto(a[0], ("localhost", 1234))
        # 接收数据
        a = udp_socket1.recvfrom(1024)
        # 输出数据
        print("from%s:%s" % (str(a[1][::-1]), a[0].decode("utf-8")))
        # 关闭套接字
    udp_socket1.close()


if __name__ == "__main__":
    main()
