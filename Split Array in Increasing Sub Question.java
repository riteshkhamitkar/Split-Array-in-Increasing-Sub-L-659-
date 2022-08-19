class Solution{
    public boolean isPossible(int[] nums){
        int prevL1 = 0;
        int prevL2 = 0;
        int prevL3 =0;
        int currentL1 = 0;
        int currentL2 =0;
        int currentL3 =0;
        int num = Integer.MIN_VALUE;
        int prevNum = Integer.MIN_VALUE;
        
        int i =0;
        while(i < nums.length){
            num = nums[i];
            
            int duplicateCount =0;
            while(i<nums.length && nums[i]== num){
                i++;
                duplicateCount++;
            }
            if(num!= prevNum +1){
                if(prevL1 != 0 || prevL2 !=0){
                    return false;
                    
                }
                currentL1= duplicateCount;
            }else{
                if(duplicateCount < prevL1+prevL2){
                    return false;
                }
                currentL2 = prevL1;
                currentL3 = prevL2;
                duplicateCount -= (prevL1+prevL2);
                int addToL3 = Math.min(prevL3, duplicateCount);
                currentL3 += addToL3;
                duplicateCount -= addToL3;
                currentL1 = Math.max(0, duplicateCount);
            }
            prevL1 = currentL1;
            prevL2 = currentL2;
            prevL3 = currentL3;
            prevNum = num;
        }
        return prevL1 ==0 && prevL2 ==0;
    }
}