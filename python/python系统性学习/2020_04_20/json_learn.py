# 我们使用Python中的json模块就可以将字典或列表以JSON格式保存到文件中


import json

import json


def main():
    mydict = {
        'name': '骆昊',
        'age': 38,
        'qq': 957658,
        'friends': ['王大锤', '白元芳'],
        'cars': [
            {'brand': 'BYD', 'max_speed': 180},
            {'brand': 'Audi', 'max_speed': 280},
            {'brand': 'Benz', 'max_speed': 320}
        ]
    }
    try:
        with open('data.json', 'w', encoding='utf-8') as fs:
            # 将Python对象按照JSON格式序列化到文件中
            # json.dump(mydict, fs)
            # dumps - 将Python对象处理成JSON格式的字符串
            json.dumps(mydict, fs)
    except IOError as e:
        print(e)
    print('保存数据完成!')


if __name__ == '__main__':
    main()
