package com.gsy.gsy_common_util.scannerUtil;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * Created By Gsy on 2019/6/5
 */
public class ScannerUtils {

    public static String scanner(String tip) throws ScannerException {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new ScannerException("请输入正确的" + tip + "！");
    }

    public static int scannerInt(String tip) throws ScannerException {
        return Integer.parseInt(scanner(tip));
    }
}
