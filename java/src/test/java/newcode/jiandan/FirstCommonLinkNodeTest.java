package newcode.jiandan;

import newcode.jiandan.FirstCommonLinkNode;
import newcode.ListNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstCommonLinkNodeTest {

    private static FirstCommonLinkNode test;

    @BeforeAll
    public static void init(){
        test = new FirstCommonLinkNode();
    }

    @Test
    void findFirstCommonNode() {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{4,5};
        int[] nums3 = new int[]{6,7};

        TestUtil testUtil = new TestUtil(nums1, nums2, nums3).invoke();
        ListNode pHead1 = testUtil.getpHead1();
        ListNode pHead2 = testUtil.getpHead2();
        ListNode pHead3 = testUtil.getpHead3();

        assertEquals(pHead3, test.FindFirstCommonNode(pHead1,pHead2));

    }

    @Test
    void findFirstCommonNode2() {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{2,3};
        int[] nums3 = new int[]{};

        TestUtil testUtil = new TestUtil(nums1, nums2, nums3).invoke();
        ListNode pHead1 = testUtil.getpHead1();
        ListNode pHead2 = testUtil.getpHead2();
        ListNode pHead3 = testUtil.getpHead3();

        assertEquals(null, test.FindFirstCommonNode(pHead1,pHead2));
    }

    private class TestUtil {
        private int[] nums1;
        private int[] nums2;
        private int[] nums3;
        private ListNode pHead1;
        private ListNode pHead2;
        private ListNode pHead3;

        public TestUtil(int[] nums1, int[] nums2, int... nums3) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            this.nums3 = nums3;
        }

        public ListNode getpHead1() {
            return pHead1;
        }

        public ListNode getpHead2() {
            return pHead2;
        }

        public ListNode getpHead3() {
            return pHead3;
        }

        public TestUtil invoke() {
            pHead1 = null;
            ListNode p =  null;
            pHead2 = null;
            ListNode q = null;
            pHead3 = null;
            ListNode n = null;
            for(int num : nums1){
                ListNode node = new ListNode(num);
                if(pHead1 == null){
                    pHead1 = node;
                    p = node;
                }else{
                    p.next = node;
                    p = p.next;
                }

            }

            for(int num : nums2){
                ListNode node = new ListNode(num);
                if(pHead2 == null){
                    pHead2 = node;
                    q = node;
                }else{
                    q.next = node;
                    q = q.next;
                }
            }

            for(int num : nums3){
                ListNode node = new ListNode(num);
                if(pHead3 == null){
                    pHead3 = node;
                    n = node;
                }else{
                    n.next = node;
                    n = n.next;
                }
            }

            p.next = pHead3;
            q.next = pHead3;
            return this;
        }
    }
}