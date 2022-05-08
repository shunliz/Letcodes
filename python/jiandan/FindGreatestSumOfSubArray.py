from typing import List


class FindGreatestSumOfSubArray:
    def FindGreatestSumOfSubArray(self , array: List[int]) -> int:
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