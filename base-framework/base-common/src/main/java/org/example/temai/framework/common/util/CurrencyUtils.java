package org.example.temai.framework.common.util;

/**
 * @author: hanchaowei
 * @date 2023/11/26
 * @description: 货币工具类
 */

public class CurrencyUtils {

	/**
	 * 元转换为分
	 * @param yuan
	 * @return
	 */
	public static Long yuanToFen(Double yuan) {
		return Math.round(yuan * 100);
	}

	/**
	 * 分转换为元
	 * @param fen
	 * @return
	 */
	public static Double fenToYuan(Long fen) {
		return fen / 100.0;
	}

	/**
	 * 计算总金额(以分为单位)
	 * @param price
	 * @param total
	 * @return
	 */
	public static Long calculateTotalPrice(Long price, Integer total) {
		return price * total;
	}

	/**
	 * 格式化金额(以元为单位,保留两位小数
	 * @param amount
	 * @return
	 */
	public static String formatAmount(Long amount) {
		return String.format("%.2f", fenToYuan(amount));
	}

}
