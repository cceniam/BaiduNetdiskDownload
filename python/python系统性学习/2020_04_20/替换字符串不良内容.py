import re


def main():
    sentence = '你丫是傻叉吗? 我操你大爷的. Fuck you，臭傻逼.'
    purified = re.sub('[操肏艹]|fuck|shit|傻[比屄逼叉缺吊屌]|臭|恶心煞笔',
                      '*', sentence, flags=re.IGNORECASE)
    print(purified)  # 你丫是*吗? 我*你大爷的. * you.


if __name__ == '__main__':
    main()