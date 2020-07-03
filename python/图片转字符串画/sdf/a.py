from logging import root

import requests  # 导入requests包
import json
import tkinter

from tkinter import *


def get_translate_date(word=None):

    url = 'http://fanyi.youdao.com/translate?smartresult=dict&smartresult=rule'
    From_data = {'i': word, 'from': 'AUTO', 'to': 'AUTO', 'smartresult': 'dict', 'client': 'fanyideskweb',
                 'salt': '15864054964608', 'sign': 'daaa12a65b41da0711183c39007690df', 'ts': '1586405496460',
                 'bv': '22064a11854578c27ac33ab21fbb1527', 'doctype': 'json', 'version': '2.1', 'keyfrom': 'fanyi.web',
                 'action': 'FY_BY_REALTIME'}
    # 请求表单数据
    response = requests.post(url, data=From_data)
    # 将Json格式字符串转字典
    content = json.loads(response.text)
    return content
    # 打印翻译后的数据
    # print(content['translateResult'][0][0]['tgt'])

def _init_(self):
    self.root = tkinter.Tk()
    self.root.title("有道翻译在线版")
    list = tkinter.Listbox()
    #创建一个输入框
    self.text_inout=tkinter.Entry(self.root,width=30)
    #创建一个回显列表
    tkinter.Listbox(self.root,width=50)
    self.result_button = tkinter.Button(self.root, command=self.tran, text="翻译")





if __name__ == '__main__':
    print(get_translate_date("asdfafadafsd"))