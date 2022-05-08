package newcode.jiandan;

/**
 * 描述
 * 给定一个长度为 n 的非降序数组和一个非负数整数 k ，要求统计 k 在数组中出现的次数
 *
 * 数据范围：0≤n≤1000,0≤k≤100，数组中每个元素的值满足 0≤val≤100
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(logn)O(logn)
 *
 * https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=117&tqId=37772&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
 */


public class NumberOfRepeatK {
    public int GetNumberOfK(int [] array , int k) {
        int n=array.length;
        int l=0;
        int r=n;
        int ans=0;
        // 找到升序序列中的下界
        while(l<r){
            int mid=(l+r)/2;
            if(array[mid]<k) {
                l=mid+1;
            } else {
                r=mid;
            }
        }
        int left=l;
        // 找到升序序列中的上界
        l=0;
        r=n;
        while(l<r){
            int mid=(l+r)/2;
            if(array[mid]<=k) {
                l=mid+1;
            } else {
                r=mid;
            }
        }
        int right=l;
        //上界减去下界为数字在升序数组出现的次数
        return right-left;
    }
}
