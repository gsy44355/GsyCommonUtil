package com.gsy.gsy_common_util.regex;
/**
 * 正则表达式实例类，实现文本内匹配，已有匹配字符长度限制
 * 向前向后断言例子<br/>
 * regexMoblie:手机号码<br/>
 * regexIDnum:中国身份证<br/>
 * @author gsy
 *
 */
public class RegExStr {
	/**
	 * 手机号码，有前后断言
	 */
	public static final String regexMoblie = "(?<!\\d+)1\\d{10}(?!\\d+)";
	public static final String regexIDnum = "(?<!\\d+)(\\d{15}|\\d{17}[xX]|\\d{18})(?!\\d+)";
	public static final String string  = "<[hH]([1-6])>.*?</[hH]\\1>";
}
