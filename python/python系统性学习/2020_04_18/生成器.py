def fib(n):
    a, b = 0, 1
    for _ in range(n):
        a, b = b, a + b
        yield a # 返回值为生成器对象地址


def main():
    for val in fib(20):
        print(val)


if __name__ == '__main__':
    print(fib(20))
    main()