from unittest import TestCase

from jiandan.FindGreatestSumOfSubArray import FindGreatestSumOfSubArray

if __name__ == '__main__':
    None


class TestFindGreatestSumOfSubArray(TestCase):
    def test_find_greatest_sum_of_sub_array1(self):
        arr = [1, -2, 3, 10, -4, 7, 2, -5]
        ret = FindGreatestSumOfSubArray().FindGreatestSumOfSubArray(arr);
        self.assertEqual(18, ret)

    def test_find_greatest_sum_of_sub_array2(self):
        arr = [2]
        ret = FindGreatestSumOfSubArray().FindGreatestSumOfSubArray(arr);
        self.assertEqual(2, ret)

    def test_find_greatest_sum_of_sub_array3(self):
        arr = [-10]
        ret = FindGreatestSumOfSubArray().FindGreatestSumOfSubArray(arr);
        self.assertEqual(-10, ret)