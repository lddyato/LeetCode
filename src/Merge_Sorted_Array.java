/**
 * Created by xjwhhh on 2017/7/14.
 */

import java.util.ArrayList;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class Merge_Sorted_Array {
    //先变成一个有序的list，再填入nums1
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> newnums=new ArrayList<>();
        int i=0;
        int j=0;
        for(;i<m&&j<n;){
            if(nums1[i]<=nums2[j]){
                newnums.add(nums1[i]);
                i++;
            }
            else{
                newnums.add(nums2[j]);
                j++;
            }
        }
        if(i==m){
            for(;j<n;j++){
                newnums.add(nums2[j]);
            }
        }
        else{
            for(;i<m;i++) {
                newnums.add(nums1[i]);
            }
        }
        for(int a=0;a<m+n;a++){
            nums1[a]=newnums.get(a);
        }
    }


    public void merge1(int A[], int m, int B[], int n) {
        int i=m-1;
        int j=n-1;
        int k = m+n-1;
        while(i >=0 && j>=0)
        {
            if(A[i] > B[j])
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }
        while(j>=0)
            A[k--] = B[j--];
    }



    public static void main(String[] args){
        Merge_Sorted_Array merge_sorted_array=new Merge_Sorted_Array();
        int []nums1={1};
        int []nums2={};
        int x1=1;
        int x2=0;
        merge_sorted_array.merge(nums1,x1,nums2,x2);
    }

}
