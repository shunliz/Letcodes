from typing import List


class FindGreatestSumOfSubArray:
    def findGreatestSumOfSubArray(self , array: List[int]) -> int:
        # write code here
        sum = 0
        max = -1001
        for e in array:
            if sum<0:
                sum = e
            else:
                sum = sum + e
            if sum>max:
                max = sum
        return max

    def strrmdupandsort(self, s):
        s = list(set(s))
        s.sort(reverse=False)
        return "".join(s)

    """
    字符串同构是指字符串s中的所有字符都可以替换为t中的所有字符。
    在保留字符顺序的同时，必须用另一个字符替换所有出现的字符。
    不能将s中的两个字符映射到t中同一个字符，但字符可以映射到自身。
    试判定给定的字符串s和t是否同构。 
    例如： s = “add” t = “apple” 输出 False s = “paper” t = “title” 输出 True 
    """
    def strtonggou(self, s, t):
        return len(set(s)) == len(set(t)) == len(set(zip(s, t)))

    def ip2int(self, s):
        f = lambda s:sum([256**j*int(i) for j,i in enumerate(s.split('.')[::-1])])
        return f(s)