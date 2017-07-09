import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjwhhh on 2017/7/9.
 */
public class Reverse_Integer {
    //需要判断是否溢出
    public int reverse(int x) {
        int save=x;
        int result=0;
        int newresult=0;
        int flag=0;
        if(x<0){
            flag=-1;
        }
        else{
            flag=1;
        }
        x=Math.abs(x);
        while(x>0){
            int a=x%10;
            newresult=newresult*10+a;
            if((newresult-a)/10!=result){
                return 0;
            }
            result=newresult;
            x=(x-a)/10;
        }
        if(flag==-1){
            result=-result;
        }
        return result;
    }

    public int reverse1(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args){
        Reverse_Integer reverse_integer=new Reverse_Integer();
        int a=reverse_integer.reverse(10);
        System.out.println(a);
    }
}
