package org.example.temai.framework.common.util;

/**
 * @author: hanchaowei
 * @date 2023/10/7
 * @description: 雪花算法工具类
 */

public class SnowflakeIdUtils {

	/**
	 * 开始时间戳 (2015-01-01)
	 */
	private static final long twepoch = 1420041600000L;

	/**
	 * 机器id所占的位数
	 */
	private static final long workerIdBits = 5L;

	/**
	 * 数据标识id所占的位数
	 */
	private static final long datacenterIdBits = 5L;

	/**
	 * 支持的最大机器id，结果是31
	 */
	private static final long maxWorkerId = -1L ^ (-1L << workerIdBits);

	/**
	 * 支持的最大数据标识id，结果是31
	 */
	private static final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

	/**
	 * 序列在id中占的位数
	 */
	private static final long sequenceBits = 12L;

	/**
	 * 机器ID向左移12位
	 */
	private static final long workerIdShift = sequenceBits;

	/**
	 * 数据标识id向左移17位(12+5)
	 */
	private static final long datacenterIdShift = sequenceBits + workerIdBits;

	/**
	 * 时间截向左移22位(5+5+12)
	 */
	private static final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

	/**
	 * 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095)
	 */
	private static final long sequenceMask = -1L ^ (-1L << sequenceBits);

	/**
	 * 工作机器ID(0~31)
	 */
	private static long workerId;

	/**
	 * 数据中心ID(0~31)
	 */
	private static long datacenterId;

	/**
	 * 毫秒内序列(0~4095)
	 */
	private static long sequence = 0L;

	/**
	 * 上次生成ID的时间截
	 */
	private static long lastTimestamp = -1L;

	static {
		// 这里可以从配置文件或环境变量获取到workerId和datacenterId
		workerId = 0L;
		datacenterId = 0L;
		if (workerId > maxWorkerId || workerId < 0) {
			throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
		}
		if (datacenterId > maxDatacenterId || datacenterId < 0) {
			throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
		}
	}

	/**
	 * 获取新的ID
	 * @return
	 */
	public synchronized static long nextId() {
		long timestamp = timeGen();

		if (timestamp < lastTimestamp) {
			throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
		}

		if (lastTimestamp == timestamp) {
			sequence = (sequence + 1) & sequenceMask;
			if (sequence == 0) {
				timestamp = tilNextMillis(lastTimestamp);
			}
		} else {
			sequence = 0L;
		}

		lastTimestamp = timestamp;

		return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence;
	}

	private static long tilNextMillis(long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	private static long timeGen() {
		return System.currentTimeMillis();
	}

	public static void main(String[] args) {

		for (int i = 0; i < 1000; i++) {
			long id = SnowflakeIdUtils.nextId();
			System.out.println(id);
		}
	}
}
