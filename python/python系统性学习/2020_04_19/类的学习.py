# 定义类
# 在Python中可以使用class关键字定义类
# 然后在类中通过之前学习过的函数来定义方法
# 这样就可以将对象的动态特征描述出来。

class Student(object):
    __slots__ = ('_name', '_age', '_collage')

    # __init__是一个特殊方法用于在创建对象时进行初始化操作
    def __init__(self, name, age, college):
        self.name = name
        self.age = age
        self.college = college

    # Python还可以在类中定义类方法，类方法的第一个参数约定名为cls，
    # 它代表的是当前类相关的信息的对象（类本身也是一个对象，有的地方也称之为类的元数据对象）
    # 通过这个参数我们可以获取和类相关的信息并且可以创建出类的对象，代码如下所示
    @classmethod
    def iof(cls):
        return cls(name=1, age=1, college=None)

    # 静态方法
    @staticmethod
    def studentCollention(cnt):
        return cnt

    # 访问器-getter方法
    @property
    def name(self):
        return self.name

    @property
    def age(self):
        return self.age

    def student(self, course_name):
        print("%s is learning %s" % (self.name, course_name))

    def watch_movie(self):
        if self.age < 18:
            print('%s只能观看《熊出没》.' % self.name)
        else:
            print('%s正在观看岛国爱情大电影.' % self.name)


# 创建和使用对象
def main():
    stu1 = Student('lucifer', 19, 'xian')
    stu1.watch_movie()

# 继承

class we(Student):
    def __init__(self):
        super()



if __name__ == '__main__':
    main()
