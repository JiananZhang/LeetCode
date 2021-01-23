/*
给定一个数组，求本身数值与其出现次数相等的那些数里最大的那个。用哈希表即可。代码如下：
 */
public class Solution{
    public int findX(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr){
            map.put(x, map.getOrDeFault(x, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey(), value = entry.getValue();
            if(key == value) {
                res = Math.max(res, key);
            }
        }
        return res;
    }
}