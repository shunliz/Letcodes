package data_structures;

import java.util.BitSet;

public class BloomFilter{
    // 二进制向量（数组）的位数，相当于能存储1000万条url左右，误报率为千万分之一
    private static final int BIT_SIZE = 2 << 28 ;
    // 二进制数组（2^28 byte）
    private BitSet bits = new BitSet(BIT_SIZE);

    // 用于生成信息指纹的8个随机数，最好选取质数（使同一算法产生8个不同hash函数）
    private static final int[] seeds = new int[]{3, 5, 7, 11, 13, 31, 37, 61};
    // 用于存储具体的8个哈希对象（每个里面包含了不同结果的hash函数）
    private Hash[] func = new Hash[seeds.length];

    public BloomFilter(){
        // 构造BloomFilter时生成这8个随机哈希对象
        for(int i = 0; i < seeds.length; i++){
            func[i] = new Hash(BIT_SIZE, seeds[i]);
        }
    }

    /**
     * 操作一：向过滤器中添加字符串
     */
    public void addValue(String value)
    {

        if(value != null){
            // 将字符串value哈希为8个或多个整数
            for(Hash f : func)
                //然后在这些整数的bit上变为1
            {
                bits.set(f.hash(value), true);
            }
        }

    }

    /**
     * 操作二：判断字符串是否包含在布隆过滤器中
     */
    public boolean contains(String value)
    {
        if(value == null) {
            return false;
        }

        boolean ret = true;

        // 将要比较的字符串重新以上述方法计算hash值，再与布隆过滤器比对
        for(Hash f : func)
            // 注：这里 && ret 很关键，若有false了则能保证结果一定是false
        {
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }

    /**
     * 随机哈希值对象（静态内部类）
     */
    public static class Hash{
        private int size; // 二进制向量数组大小
        private int seed; // 随机数种子

        public Hash(int cap, int seed){
            this.size = cap;
            this.seed = seed;
        }

        /**
         * 计算哈希值(也可以选用别的恰当的哈希函数)
         */
        public int hash(String value){
            int result = 0;
            int len = value.length();
            // 具体Hash算法：加权求和！！！
            for(int i = 0; i < len; i++){
                result = seed * result + value.charAt(i);
            }
            // 注：取模，得到具体二进制数组下标（result%（size-1））
            return (size - 1) & result;
        }
    }
}

