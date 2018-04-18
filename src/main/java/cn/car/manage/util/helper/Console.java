package cn.car.manage.util.helper;

import cn.car.manage.global.Configuration;

/**
 * 
 * @Description: 控制台打印
 * @User: 
 * @Date: 2016年3月22日 下午3:41:57
 */
public class Console {
	
	enum LogLevel{
		INFO(0),
		WARN(1),
		ERROR(2),
		DEBUG(3);
		
		private int level;
		private LogLevel(int level){
			this.level = level;
		}
		
		public int getLevel(){
			return level;
		}
	}
	
	private static final Object lock = new Object();
	private static final StringBuilder builder = new StringBuilder();
	private static final char DEFAULT_SEPARATOR = ',';
	private static final LogLevel LOG_LEVEL = LogLevel.valueOf(Configuration.getOrDefault("LOG", "INFO").toString().toUpperCase());

	
	
	public static void info(Object... objs) {
		if (LOG_LEVEL.getLevel() >= LogLevel.INFO.getLevel()) {
			synchronized (lock) {
				info(DEFAULT_SEPARATOR, objs);
			}
		}
	}

	public static void info(char separator, Object... objs) {
		if (LOG_LEVEL.getLevel() >= LogLevel.INFO.getLevel()) {
			for (Object obj : objs) {
				if (obj == null) {
					builder.append("null");
				} else {
					builder.append(obj.toString());
				}
				builder.append(separator);
			}

			if (builder.length() >= 2) {
				builder.setLength(builder.length() - 1);
			}
			System.out.println(builder.toString());
			builder.setLength(0);
		}
	}
	
	
	public static void warn(Object... objs) {
		if (LOG_LEVEL.getLevel() >= LogLevel.WARN.getLevel()) {
			synchronized (lock) {
				warn(DEFAULT_SEPARATOR, objs);
			}
		}
	}

	public static void warn(char separator, Object... objs) {
		if (LOG_LEVEL.getLevel() >= LogLevel.WARN.getLevel()) {
			for (Object obj : objs) {
				if (obj == null) {
					builder.append("null");
				} else {
					builder.append(obj.toString());
				}
				builder.append(separator);
			}

			if (builder.length() >= 2) {
				builder.setLength(builder.length() - 1);
			}
			System.out.println(builder.toString());
			builder.setLength(0);
		}
	}
	

	public static void error(Object... objs) {
		if (LOG_LEVEL.getLevel() >= LogLevel.ERROR.getLevel()) {
			synchronized (lock) {
				error(DEFAULT_SEPARATOR, objs);
			}
		}
	}

	public static void error(char separator, Object... objs) {
		if (LOG_LEVEL.getLevel() >= LogLevel.ERROR.getLevel()) {
			for (Object obj : objs) {
				if (obj == null) {
					builder.append("null");
				} else {
					builder.append(obj.toString());
				}
				builder.append(separator);
			}

			if (builder.length() >= 2) {
				builder.setLength(builder.length() - 1);
			}

			System.err.println(builder.toString());

			builder.setLength(0);
		}
	}
	
	
	public static void debug(Object... objs) {
		if (LOG_LEVEL.getLevel() >= LogLevel.DEBUG.getLevel()) {
			synchronized (lock) {
				debug(DEFAULT_SEPARATOR, objs);
			}
		}
	}

	public static void debug(char separator, Object... objs) {
		if (LOG_LEVEL.getLevel() >= LogLevel.DEBUG.getLevel()) {
			for (Object obj : objs) {
				if (obj == null) {
					builder.append("null");
				} else {
					builder.append(obj.toString());
				}
				builder.append(separator);
			}

			if (builder.length() >= 2) {
				builder.setLength(builder.length() - 1);
			}

			System.out.println(builder.toString());

			builder.setLength(0);
		}
	}
	

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			Console.info(i, i, i);
			Console.error(i, i, i);
		}

	}
}
