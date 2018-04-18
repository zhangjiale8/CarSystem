package cn.car.manage.util.helper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class BigDecimalUtil {

	private BigDecimalUtil(){}
	
	/**
	 * 加法
	 * @user 
	 * @data 2017年2月20日下午3:34:09
	 * @Description 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double add(double a,double b){
			BigDecimal bd_a = new BigDecimal(Double.toString(a));
			BigDecimal bd_b = new BigDecimal(Double.toString(b));
			return bd_a.add(bd_b).doubleValue();
	}
	
	/**
	 * 加法
	 * @user 
	 * @data 2017年2月20日下午2:40:18
	 * @Description 
	 * @param lists
	 * @return
	 */
	public static double add(List<Double> lists){
		if(lists.size() == 0){
			return 0;
		}else{
			BigDecimal bd_sum = new BigDecimal(Double.toString(lists.get(0)));
			for(int i=1;i<lists.size();i++){
				BigDecimal bd = new BigDecimal(Double.toString(lists.get(i)));
				bd_sum = bd_sum.add(bd);
				bd_sum = bd_sum.setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			return bd_sum.doubleValue();
		}
	}
	
	/**
	 * 减法
	 * @user 
	 * @data 2017年2月20日下午6:03:00
	 * @Description 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double subtract(double a,double b){
		BigDecimal bd_a = new BigDecimal(Double.toString(a));
		BigDecimal bd_b = new BigDecimal(Double.toString(b));
		return bd_a.subtract(bd_b).doubleValue();
	}
	/**
	 * 减法
	 * @user 
	 * @data 2017年2月20日下午2:48:54
	 * @Description 
	 * @param lists
	 * @return
	 */
	public static double subtract(List<Double> lists){
		if(lists.size() == 0){
			return 0;
		}else{
			BigDecimal bd_sum = new BigDecimal(Double.toString(lists.get(0)));
			for(int i=1;i<lists.size();i++){
				BigDecimal bd = new BigDecimal(Double.toString(lists.get(i)));
				bd_sum = bd_sum.subtract(bd);
			}
			return bd_sum.doubleValue();
		}
	}
	
	/**
	 * 乘法
	 * @user 
	 * @data 2017年2月21日下午3:53:49
	 * @Description 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double multiply(double a,double b){
		BigDecimal bd_a = new BigDecimal(Double.toString(a));
		BigDecimal bd_b = new BigDecimal(Double.toString(b));
		return bd_a.multiply(bd_b).doubleValue();
	}
	
	/**
	 * 乘法
	 * @user 
	 * @data 2017年2月20日下午2:52:12
	 * @Description 
	 * @param lists
	 * @return
	 */
	public static double multiply(List<Double> lists){
		if(lists.size() == 0){
			return 0;
		}else{
			BigDecimal bd_sum = new BigDecimal(Double.toString(lists.get(0)));
			for(int i=1;i<lists.size();i++){
				BigDecimal bd = new BigDecimal(Double.toString(lists.get(i)));
				bd_sum = bd_sum.multiply(bd);
			}
			return bd_sum.doubleValue();
		}
	}
	
	/**
	 * 除法
	 * @user 
	 * @data 2017年2月20日下午3:35:14
	 * @Description 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double divide(double a,double b){
		BigDecimal bd_a = new BigDecimal(Double.toString(a));
		BigDecimal bd_b = new BigDecimal(Double.toString(b));
		if(b == 0){
			System.err.println("被除数为0");
			return 0;
		}
		return bd_a.divide(bd_b, 2, RoundingMode.UP).doubleValue();
	}
	
	/**
	 * 除法
	 * @user 
	 * @data 2017年2月20日下午3:16:19
	 * @Description 
	 * @param lists
	 * @return
	 */
	public static double divide(List<Double> lists){
		if(lists.size() == 0){
			return 0;
		}else{
			BigDecimal bd_sum = new BigDecimal(Double.toString(lists.get(0)));
			for(int i=1;i<lists.size();i++){
				BigDecimal bd = new BigDecimal(Double.toString(lists.get(i)));
				bd_sum = bd_sum.divide(bd, 2, RoundingMode.UP);
			}
			return bd_sum.doubleValue();
		}
	}
	
	public static void main(String[] args) {
		List<Double> lists = new ArrayList<Double>();
		lists.add(9.3);
		lists.add(3d);
		lists.add(1d);
		
		System.err.println(BigDecimalUtil.add(lists));
		System.err.println(BigDecimalUtil.subtract(lists));
		System.err.println(BigDecimalUtil.multiply(lists));
		System.err.println(BigDecimalUtil.divide(lists));
		//System.err.println(0.42/0.1);
	}
}
