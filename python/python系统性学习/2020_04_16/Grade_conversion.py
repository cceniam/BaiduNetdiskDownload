""""
练习二： 百分制成绩与等级制成绩转换
练习内容： 分支结构
要求： 如果输入的成绩在90分以上（含90分）输出A；80分-90分（不含90分）输出B；
70分-80分（不含80分）输出C；60分-70分（不含70分）输出D；60分以下输出E。
"""

score = float(input("please input the score"))
grade = None
if score >= 90:
    grade='A'
elif score >= 80:
    grade = 'B'
elif score >=70:
    grade = 'C'
elif score >= 60:
    grade = 'D'
else:
    grade = 'E'

print('成绩转换后为'+str(grade))
