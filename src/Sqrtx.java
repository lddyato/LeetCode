/**
 * Created by xjwhhh on 2017/7/14.
 */

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */
public class Sqrtx {
    //失败
//    public int mySqrt(int x) {
//        for(int i=0;i<=x;i++){
//            if(i*i<=x&&(i+1)*(1+i)>x){
//                return i;
//            }
//        }
//        return 0;
//    }

    public int mySqrt1(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }

    //binary search
    public int sqrt2(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

//    public static void main(String[] args){
//        Sqrtx sqrtx=new Sqrtx();
//        int x=sqrtx.mySqrt(2147395600);
//        System.out.print(x);
//    }
}
