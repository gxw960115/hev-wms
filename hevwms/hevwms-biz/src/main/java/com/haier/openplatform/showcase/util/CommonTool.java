package com.haier.openplatform.showcase.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
* @ClassName: CommonTool
* @Description: 
*
*/
public final class CommonTool {
	private static final Log LOG = LogFactory.getLog(CommonTool.class);

	//判断字符串是否为空
	/**
	* @Title: isNull
	* @Description: 
	* @param @param strIn
	* @param @return
	* @return boolean
	* @throws
	*/
	public static boolean isNull(String strIn) {
		if (null == strIn || ("").equals(strIn.trim()) || ("NULL").equals(strIn.toUpperCase())) {
			return true;
		}

		return false;
	}

	/**
	 * 取得当前时间。 <BR>
	 * <UL>
	 * <LI>取得当前时间，并格式化。</LI>
	 * </UL>
	 * 
	 * @param format 要格式化的格式。
	 * @return 格式化后的时间。
	 */
	public static String getCurrentDate(String format) {
		// 日历类
		Calendar calendar = Calendar.getInstance();
		// 格式化
		String time = new SimpleDateFormat(format).format(calendar.getTime());

		return time;
	}

	/**
	 * 取得当前月最后一天。 <BR>
	 * <UL>
	 * <LI>取得当前时间，并格式化。</LI>
	 * </UL>
	 * 
	 * @param format 要格式化的格式。
	 * @return 格式化后的时间。
	 */
	public static String getCurrentMonthLastDate() {
		// 日历类
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 格式化
		String time = new SimpleDateFormat("yyyy-MM-" + day).format(calendar.getTime());
		return time;
	}

	/**
	 * 取得传入最后一天。 <BR>
	 * <UL>
	 * <LI>取得当前时间，并格式化。</LI>
	 * </UL>
	 * 
	 * @param format 要格式化的格式。
	 * @return 格式化后的时间。
	 */
	public static String getMonthLastDate(String mon) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(df.parse(mon));
		} catch (ParseException e) {
			LOG.info(e.getMessage());
		}
		int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 获取间隔n天时间
		String time = new SimpleDateFormat("yyyy-MM-" + day).format(calendar.getTime());
		return time;
	}

	/**
	 * 取得当前时间。 <BR>
	 * <UL>
	 * <LI>取得当前时间，并格式化。</LI>
	 * </UL>
	 * 
	 * @param format 要格式化的格式。
	 * @return 格式化后的时间。
	 */
	public static String getCurrentLastDate(String format) {

		// 日历类
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(calendar.getTime());
		// 取得7天前日期
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		// 格式化
		String time = new SimpleDateFormat(format).format(calendar.getTime());

		return time;
	}

	/**
	 * 串转sql串。 <BR>
	 * <UL>
	 * <LI>replace</LI>
	 * </UL>
	 * 
	 */
	public static String replaceToSqlStr(String str) {
		if (isNull(str)) {
			return "";
		} else {
			StringBuffer bf = new StringBuffer();
			String strs[] = str.split(",");
			for (int i = 0; i < strs.length; i++) {
				bf.append("'" + strs[i] + "'");
				if (strs.length - 1 != i) {
					bf.append(",");
				}
			}
			return bf.toString();
		}
	}

	/**
	 * 格式化数字，千分位
	 * 11111.113 -->1,111.113
	 * 123213-->123,213
	 */
	public static String numberFormat(String num) {
		NumberFormat nf = NumberFormat.getInstance();
		return nf.format(Double.parseDouble(num));
	}

	/**
	 * 格式化数字，千分位
	 * 11111.113 -->1,111.113
	 * 123213-->123,213.00
	 */
	public static String decimalFormat(String num) {
		if ("0.0".equals(num)) {
			return "0.00";
		}
		double dou = Double.parseDouble(num);
		String format = "#,###.00";
		if (dou < 1) {
			format = "0.00";
		}
		NumberFormat nf = new DecimalFormat(format);
		return nf.format(dou);
	}

	/**
	 * 格式化数字，千分位
	 * 11111.113 -->1,111.1130
	 * 123213-->123,213.0000
	 */
	public static String decimalFourFormat(String num) {
		if ("0.0".equals(num)) {
			return "0.0000";
		}
		double dou = Double.parseDouble(num);
		String format = "#,###.0000";
		if (dou < 1) {
			format = "0.0000";
		}
		NumberFormat nf = new DecimalFormat(format);
		return nf.format(dou);
	}

	/**
	 * 格式化数字, 保留四位小数
	 */
	public static String decimalFour(String num) {
		if ("0.0".equals(num)) {
			return "0";
		}
		double dou = Double.parseDouble(num);
		String format = "#.0000";
		if (dou < 1) {
			format = "0.0000";
		}
		NumberFormat nf = new DecimalFormat(format);
		return nf.format(dou);
	}

	/**
	 * 根据传入时间获取间隔n天时间
	 */
	public static String getNewDate(String format, String date, int num) {
		DateFormat df = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(df.parse(date));
		} catch (ParseException e) {
			LOG.info(e.getMessage());
		}
		// 获取间隔n天时间
		calendar.add(Calendar.DAY_OF_MONTH, num);
		return df.format(calendar.getTime());
	}

	/**
	 * 将字符数组转化SQL条件串
	 */
	public static String replaceToSqlStr(String[] strs) {
		if (strs == null) {
			return "";
		} else {
			StringBuffer bf = new StringBuffer();
			int length = strs.length;
			for (int i = 0; i < length - 1; i++) {
				if (!"".equals(strs[i])) {
					bf.append("'" + strs[i] + "'");
					if (!"".equals(strs[length - 1])) {
						bf.append(",");
					}
				}
			}
			if (!"".equals(strs[length - 1])) {
				bf.append("'" + strs[length - 1] + "'");
			}
			return bf.toString();
		}
	}

	/**
	 * 自动生成编码。 <BR>
	 * @param int 。
	 * @return 自动生成编码。
	 */
	public static String getCode(int len, int val, String add, String head) {
		//实际值长度
		int valLen = String.valueOf(val).length();
		//需要补值的长度
		int addLen = len - valLen;

		StringBuffer value = new StringBuffer();
		for (int i = 0; i < addLen; i++) {
			value.append(add);
		}

		return value.append(val).toString();
	}

	/**
	 * <p>Discription:[将一个数随机拆分固定个数的数字]</p>
	 * @param amount
	 * @param size
	 * @return
	 * @author:[zh-fan]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public static List<Integer> getRandomNum(int amount, int size) {
		Random r = new Random();
		List<Integer> list = new ArrayList<Integer>();
		int miAmount = amount;
		if (amount < 0) {
			miAmount = -amount;
		}

		int average = miAmount / size;
		int remainder = miAmount % size;

		int rm = 0;
		int x = 0;
		int y = average;
		int sum = 0;
		for (int i = 0; i < size - 1; i++) {//对前size-1个数进行随机
			if (y != 0) {
				rm = r.nextInt(y);
			}
			if (i < remainder) {
				x = rm + 1;
			} else {
				x = rm;
			}
			sum = sum + x;
			if (amount > 0) {
				list.add(x);
			} else {
				list.add(-x);
			}
			if (y - rm > 0) {
				y = average + y - rm;
			}
		}
		//对第size个数进行计算
		if (amount > 0) {
			list.add(miAmount - sum);
		} else {
			list.add(-(miAmount - sum));
		}
		//用Collections的shuffle(List<?> list)方法将顺序打乱
		Collections.shuffle(list);
		return list;
	}

	public static String clearTab(String str) {
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(str);
		return m.replaceAll("");
	}

	/**
	*  查周转天数的日期，默认为 1点之前是返回前天 1点后返回昨天。 <BR>
	* <UL>
	* <LI>默认为 1点之前是返回前天 1点后返回昨天</LI>
	* </UL>
	* 
	* @param format 要格式化的格式。
	* @return 默认为 1点之前是返回前天 1点后返回昨天
	*/
	public static String getDateByStorageDaysAgo(String format) {
		// 日历类
		Calendar calendar = Calendar.getInstance();
		if (Integer.parseInt(getCurrentDate("HH")) >= 13) {
			calendar.add(Calendar.DAY_OF_MONTH, -1);
		} else {
			calendar.add(Calendar.DAY_OF_MONTH, -2);
		}
		// 格式化
		String time = new SimpleDateFormat(format).format(calendar.getTime());

		return time;
	}

	/**
	 * <p>Discription:[格式化日期]</p>
	 * @param date
	 * @return
	 */
	public static String getFormatDateToStr(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

}