package leetcode;

public class FindPivotIndex724 {
    public static void main(String[] args) {
        int minValue = Integer.MIN_VALUE;
        int[] nums=new int[]{1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }

        public static int pivotIndex(int[] nums) {
            int n=nums.length;
            int[] prefixSum=new int[n];
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=nums[i];
                prefixSum[i]=sum;
            }
            int left=0, right=0,pivot=0;
            while(true){
                if(pivot!=0){
                    left=prefixSum[pivot-1];
                }
                right=prefixSum[n-1]-prefixSum[pivot];
                if(left==right) return pivot;
                pivot++;
            }

        }

}
