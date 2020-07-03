import  re
def a():
    temp = re.sub(r'\W+', 'q', "A man, a plan, a canal: Panama")
    print(temp)
    if temp.lower() == temp[::-1].lower():
        return True
    else:
        return False
if __name__ == "__main__":
    print(a())
