class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans= new int[n];
        int p=0,q=1;
        for(int num : nums){
            if(num>0){
                ans[p]=num;
                p+=2;
            
            }else{
                ans[q]=num;
                q+=2;
            }
        }
        
        
        return ans;
    }
}