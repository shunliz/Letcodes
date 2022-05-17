from unittest import TestCase
from jiandan.classtest import *

if __name__ == '__main__':
    def S1(L_in):
        l1 = sorted(L_in)
        l2 = [i for i in l1 if i<0.5]
        return [i*i for i in l2]


    def S2(L_in):
        l1 = [i for i in L_in if i<0.5]
        l2 = sorted(l1)
        return [i*i for i in l2]

    def S3(L_in):
        l1 = [i*i for i in L_in]
        l2 = sorted(l1)
        return [i for i in l2 if i<(0.5*0.5)]

    import random
    import cProfile
    L_in = [random.random() for i in range(1000000)]
    cProfile.run('S1(L_in)')
    cProfile.run('S2(L_in)')
    cProfile.run('S3(L_in)')


class TestManager(TestCase):
    def test_stmethod(self):
        em = Employee('zhou', 'shunli', 35)
        m = Manager(em, 'manager')
        Manager.classcall()
        Manager.stmethod(Employee)
        print(m)
        print(m.email)
        m.fullname = 'zhang san'

    def test_re(self):
        import re

        str = '<div class="nam">中国</div>'
        res = re.findall(r'<div class=".*">(.*?)</div>',str)
        print(res)

        match = re.compile('www\....?').match("www.baidu.com")
        if match:
            print(match.group())
        else:
            print("NO MATCH")

        example = "<div>test1</div><div>test2</div>"
        Result = re.compile("<div>.*").search(example)
        print("Result = %s" % Result.group())

    def test_list(self):
        a =  [[ 1, 2 ], [ 3, 4 ], [ 5, 6 ]]
        a2 = [1,2,3,4,5,6]
        a3 = [y for x in a for y in x]
        self.assertEqual(a2, a3)

        def testFun():
            temp = [lambda x : i*x for i in range(5)]
            return temp
        for everyLambda in testFun():
            print (everyLambda(3))

    def test_goldtower(self):
        n=30
        for i in range(n):
            j = n-i-1
            line = j*' '+i*'*'+'*'+i*'*'+j*' '
            print(line)

    def test_pivot(self):
        def FindPivot(li):
            mid = len(li)/2
            for l in li:
                count = 0
                i = 0
                mark = 0
                while True:
                    if l == li[i]:
                        count += 1
                        temp = i
                        i += 1
                if count > mid:
                    mark = temp
                    return (mark, li[mark])
                if i > len(li) - 1:
                    break

    def test_cprofile(self):
        pass


    def test_matrix_reshape(self):
        def reshape(matrix, m, n):
            flat = [y for x in matrix for y in x]
            res = []
            for i in range(m):
                row = []
                for j in range(n):
                    row.append(flat[i*n+j])
                res.append(row)
            return res
        matrix = [[1,2,3,4,5],[6,7,8,9,10]]
        rmat = reshape(matrix, 5, 2)
        print(rmat)
