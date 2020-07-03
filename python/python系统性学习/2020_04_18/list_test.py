def max1(list1):
    """
    求列表中最大两项
    :param list1: 列表
    :return: 列表最大的两项
    """
    m1, m2 = (list1[0], list1[0]) if list1[0] > list1[1] else (list1[1], list1[0])
    for index in range(2,len(list1)):
        if list1[index] > m1:
            m2 = m1
            m1 = list1[index]
        elif list1[index] > m2:
            m2 = list1[index]
    return m1, m2


if __name__ == '__main__':
    list1 = [x for x in range(1, 100, 2)]
    print(max1(list1))
