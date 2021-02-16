class Solution {
    public int[] myhashmap = new int[10007];
    public int myhash(int x){
        for(int i = 0; i < 10; i++)
            x = x * 59 + 103;
        x = ((x % 10007) + 10007) % 10007;
        return x;
    }
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        for(int i = 0; i < nums.length; i++){
            int a = myhash(nums[i]);
            myhashmap[a] = i + 1;
        }
        for(int i = 0; i < nums.length; i++){
            int a = myhash(target - nums[i]);
            if(myhashmap[a] != 0 && i != myhashmap[a] - 1){
                ret[0] = i;
                ret[1] = myhashmap[a] - 1;
                return ret;
            }
            
        }
        return ret;
    }
}
