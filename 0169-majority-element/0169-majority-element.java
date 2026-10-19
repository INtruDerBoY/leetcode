class Solution {
    public int majorityElement(int[] nums) {
        int cont=0;
        int candidates=0;
        for(int num:nums){
            if(cont==0){
                candidates=num;
            }
            if(num==candidates)
                cont++;
                else cont -=1;
            
        }
        return candidates;
    }
}