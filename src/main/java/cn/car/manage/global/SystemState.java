package cn.car.manage.global;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * @Description: 系统状态统计
 *
 * @Date: 2018年3月2日 下午7:42:20
 */
public class SystemState {
	
	/**
	 * 当前在线用户ID
	 */
	public static final CopyOnWriteArraySet<Integer> onLineUseIDs = new CopyOnWriteArraySet<Integer>();
	
	
	/**
	 * 日访问量
	 */
	public static final AtomicLong pv = new AtomicLong(0);
	
	
	
}
