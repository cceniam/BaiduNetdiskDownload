"""
文件的读写操作
"""


def main():
    try:
        f = open('test.txt', 'r', encoding='utf-8')
        print(f.read())
    except FileNotFoundError:
        print("file not exist")
    except LookupError:
        print("unknown encoding")
    except UnicodeDecodeError:
        print("encoding error")
    finally:
        f.close()


if __name__ == '__main__':
    main()
