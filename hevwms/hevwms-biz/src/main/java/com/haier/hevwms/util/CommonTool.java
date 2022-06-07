package com.haier.hevwms.util;

/**
 * <p>Title: Function</p>
 * <p>Description: 常用函数</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * @author
 * @version 1.0
 */

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;


public final class CommonTool {

    /**
     * 判断字符串是否为空
     * @param strIn
     * @return
     */
    public static boolean isNull(String strIn) {
        if (strIn == null || strIn.trim().equals("") || strIn.toUpperCase().equals("NULL")) {
            return true;
        }

        return false;
    }


    /**
     * 获取字符串strIn中，介于字符串strBegin和字符串strEnd中的的字符串,下次把函数名改下
     * @param strIn
     * @param strBegin
     * @param strEnd
     * @return
     */
    public static String getId(String strIn, String strBegin, String strEnd) {

        String strRs;
        int nBegin = strIn.indexOf(strBegin) + strBegin.length();
        int nEnd = strIn.indexOf(strEnd);
        strRs = strIn.substring(nBegin, nEnd);
        return strRs;

    }

    /**
     * 判断参数是否为空，为空则返回""，否则返回其值
     *
     * @param sSource 源字符串
     *
     * @return 字符串
     */
    public static String getString(String sSource) {
        String sReturn = "";
        if (sSource != null && !sSource.toUpperCase().equals("NULL")) {
            sReturn = sSource.trim();
        }
        return sReturn;
    }

    /**
     * 判断参数是否为0，为0则返回""，否则返回其值
     *
     * @param iSource 源字符串
     *
     * @return 字符串
     */
    public static String getString(int iSource) {
        if (iSource == 0) {
            return "";
        } else {
            return "" + iSource;
        }
    }

    /**
     * 删除字符串中字符，将 source 中的 subString 删除
     *
     * @param source 源字符串
     * @param subString 要删除的字符
     * @return 替换后的字符串
     */
    public String delete(String source, String subString) {
        StringBuffer output = new StringBuffer();
        // 源字符串长度
        int lengthOfSource = source.length();
        // 开始搜索位置
        int posStart = 0;
        // 搜索到老字符串的位置
        int pos;

        while ((pos = source.indexOf(subString, posStart)) >= 0) {
            output.append(source.substring(posStart, pos));

            posStart = pos + 1;
        }

        if (posStart < lengthOfSource) {
            output.append(source.substring(posStart));
        }

        return output.toString();
    }

    /**
     * 字符串替换，将 source 中的 oldString 全部换成 newString
     *
     * @param source 源字符串
     * @param oldString 老的字符串
     * @param newString 新的字符串
     * @return 替换后的字符串
     */
    public static String replace(String source, String oldString,
                                 String newString) {
        StringBuffer output = new StringBuffer();
        // 源字符串长度
        int lengthOfSource = source.length();
        // 老字符串长度
        int lengthOfOld = oldString.length();
        // 开始搜索位置
        int posStart = 0;
        // 搜索到老字符串的位置
        int pos;

        while ((pos = source.indexOf(oldString, posStart)) >= 0) {
            output.append(source.substring(posStart, pos));

            output.append(newString);
            posStart = pos + lengthOfOld;
        }

        if (posStart < lengthOfSource) {
            output.append(source.substring(posStart));
        }

        return output.toString();
    }

    /**
     * 根据树形结构数据，生成每个记录的顺序编号（1.1.1格式）
     * @param cTreeResult 要求其第一条记录为0000000
     * @return String[]
     * @throws Exception
    public String[] getBianHao(TreeResult cTreeResult) throws Exception
    {
    if(cTreeResult == null)
    {
    return new String[0];
    }
    String[] strBianHao = new String[cTreeResult.size()];
    //前一结点的编号
    String bianHao = "0";
    //前一结点的级别
    int level = 2;
    //当前结点的级别
    int curLevel = -1;
    for(int i = 1;i< cTreeResult.size();i++)
    {
    curLevel = cTreeResult.getNowLevel(i);
    //如果当前结点级别比上一结点的高，编号=前一结点的编号+".1"
    if(curLevel > level)
    {
    bianHao += ".1";
    }
    //如果当前结点的级别与上一结点的一样高，编号=前一结点的编号的最后一个'.'前的部分+'.'+
    //(int(前一结点的编号的最后一个'.'后的流水号)+1)
    else if(curLevel == level)
    {
    int pos = bianHao.lastIndexOf('.');
    int liuShuiNo = Integer.parseInt(bianHao.substring(pos+1)) + 1;
    bianHao = bianHao.substring(0,pos+1) + liuShuiNo;
    }
    //如果当前结点的级别比上一结点的级别低
    else if(curLevel < level)
    {
    StringTokenizer ster = new StringTokenizer(bianHao,".");
    //如果当前结点的级别为2，编号=String(int(前一结点的编号的第一个'.'前的部分)+1)
    if(curLevel == 2)
    {
    bianHao = "" + (Integer.parseInt(ster.nextToken()) + 1);
    }
    //如果当前结点的级别大于2
    else
    {
    int pos = 0;
    for(int j = 0;j < curLevel - 2;j++)
    {
    ster.nextToken();
    pos = bianHao.indexOf('.',pos + 1);
    }
    //流水号=前一结点的级别的流水号+1
    int liuShuiNo = Integer.parseInt(ster.nextToken()) + 1;
    //编号=前一编号中，pos位置前的部分+流水号
    bianHao = bianHao.substring(0,pos + 1) + liuShuiNo;
    }
    }
    level = curLevel;
    strBianHao[i] = bianHao;
    }
    return strBianHao;
    }*/

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
     * 自动生成编码。 <BR>
     * @return 自动生成编码。
     */
    public static String getCode(int len, int val, String add, String head) {
        // 实际值长度
        int valLen = String.valueOf(val).length();
        // 需要补值的长度
        int addLen = len - valLen;

        StringBuffer value = new StringBuffer();
        for (int i = 0; i < addLen; i++) {
            value.append(add);
        }

        return value.append(val).toString();
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
