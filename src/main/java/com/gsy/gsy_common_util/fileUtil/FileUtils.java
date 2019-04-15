package com.gsy.gsy_common_util.fileUtil;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils {

	public static void main(String[] args) {
		try {
			String string = fileToString("a.txt");
			System.out.println(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 安全关闭流
	 * 
	 * @param closeable
	 */
	public static void safeClose(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 给出file，读出文件内字符串，以String返回。 默认文件编码为utf-8
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String fileToString(File file) throws IOException {
		return fileToString(file, "utf-8");
	}

	/**
	 * 给出file，读出文件件内字符串，以String返回，编码可以指定
	 * 
	 * @param file
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public static String fileToString(File file, String encoding) throws IOException {
		String result = null;
		InputStream in = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		StringBuffer stringBuffer = new StringBuffer();
		String s = null;
		try {
			in = new FileInputStream(file);
			inputStreamReader = new InputStreamReader(in, encoding);
			bufferedReader = new BufferedReader(inputStreamReader);
			while ((s = bufferedReader.readLine()) != null) {
				stringBuffer.append(s);
				stringBuffer.append(System.getProperty("line.separator"));
			}
			stringBuffer.delete(stringBuffer.length() - System.getProperty("line.separator").length(),
					stringBuffer.length());
			result = stringBuffer.toString();
		} catch (IOException e) {
			throw e;
		} finally {
			safeClose(bufferedReader);
			safeClose(inputStreamReader);
			safeClose(in);
		}
		return result;
	}

	/**
	 * 输入文件名，返回文件内字符串，默认编码utf-8
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String fileToString(String fileName) throws IOException {
		return fileToString(new File(fileName));
	}

	/**
	 * 输入文件名及编码，返回文件内字符串
	 * 
	 * @param fileName
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public static String fileToString(String fileName, String encoding) throws IOException {
		return fileToString(new File(fileName), encoding);
	}
}
