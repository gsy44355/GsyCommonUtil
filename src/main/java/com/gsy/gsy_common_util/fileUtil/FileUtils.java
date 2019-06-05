package com.gsy.gsy_common_util.fileUtil;

import com.gsy.gsy_common_util.crawler.WebCrawlerUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;

public class FileUtils {

    public static void main(String[] args) {
        try {
            String s = WebCrawlerUtil.getWebHtml("http://localhost:8080/",new HashMap<>(),"utf8");
            System.out.println(s);
            stringToFile(s,"","aa.html","utf-8");
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

    /**
     * 将字符串转换到文件
     * @param string
     * @param path
     * @param fileName
     * @param encoding
     * @throws IOException
     */
    public static void stringToFile(String string,String path,String fileName,String encoding) throws IOException {
        FileWriter fileWriter =null;
        try {
            if (StringUtils.isEmpty(string)){
                return;
            }
            File file = createFile(path,fileName);
            fileWriter = new FileWriter(file,Charset.forName(encoding));
            fileWriter.write(string);
        }catch (Exception e){
            throw e;
        }finally {
            safeClose(fileWriter);
        }
    }

    /**
     * 根据文件目录和文件名创建文件对象，
     * 如果文件夹不存在则会创建文件夹，
     * path为空则默认当前工程文件夹下
     * @param path
     * @param fileName
     * @return
     * @throws IOException
     */
    public static File createFile(String path,String fileName)throws IOException{
        if(StringUtils.isEmpty(path)){
            return new File(fileName);
        }
        File dir = new File(path);
        if(dir.exists() || !dir.isDirectory()){
            dir.mkdirs();
        }
        File file = new File(dir,fileName);
        return file;
    }
}
