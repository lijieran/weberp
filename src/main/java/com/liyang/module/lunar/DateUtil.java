package com.liyang.module.lunar;


import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.sql.Time;

/**
 * Created by IntelliJ IDEA.
 * User:chenYuan (mail:cayurain@21cn.com)
 * Date: 2004-3-31
 * Time: 18:03:15
 * 日期处理单元
 * com.jspx.utils.DateUtil
 */
final public class DateUtil {
    public static final int SECOND = 1000;
    public static final int MINUTE = SECOND * 60;
    public static final int HOUR = MINUTE * 60;
    public static final long DAY = HOUR * 24;
    public static final long WEEK = DAY * 7;
    public static final long YEAR = DAY * 365; // or 366 ???


    final static public String FULL_ST_FORMAT = "yyyy-MM-dd HH:mm:ss";
    final static public String FULL_J_FORMAT = "yyyy/MM/dd HH:mm:ss";
    final static public String CURRENCY_ST_FORMAT = "yyyy-MM-dd HH:mm";
    final static public String CURRENCY_J_FORMAT = "yyyy/MM/dd HH:mm";
    final static public String DATA_FORMAT = "yyyyMMddHHmmss";
    final static public String ST_FORMAT = "yyyy-MM-dd HH:mm";
    final static public String ST_CN_FORMAT = "yyyy年MM月dd日 HH:mm";
    final static public String CN_FORMAT = "yy年MM月dd日HH:mm";
    final static public String DAY_FORMAT = "yyyy-MM-dd";
    final static public String SHORT_DATE_FORMAT = "yy-MM-dd";
    final static public String YEAR_FORMAT = "yyyy";


    private DateUtil() {

    }


    /**
     * @param date 日期
     * @param time 时间
     * @return Calendar  合并日期和时间
     */
    public static Calendar mergeDateTime(Date date, Time time) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        if (time != null) {
            Calendar temp = Calendar.getInstance();
            temp.setTime(time);
            cal.set(Calendar.HOUR_OF_DAY, temp.get(Calendar.HOUR_OF_DAY));
            cal.set(Calendar.MINUTE, temp.get(Calendar.MINUTE));
            cal.set(Calendar.SECOND, temp.get(Calendar.SECOND));
            cal.set(Calendar.MILLISECOND, temp.get(Calendar.MILLISECOND));
        }
        return cal;
    }

    /**
     * 得到标准的日期
     *
     * @return String
     */
    public static String getDateST() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        return dateFormat.format(new Date());
    }

    /**
     * 得到标准的日期 时间
     *
     * @return String
     */
    public static String getDateTimeST() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FULL_ST_FORMAT);
        return dateFormat.format(new Date());
    }

    public static int getYear() {
        return getYear(null);
    }

    /**
     * 得到年
     *
     * @return int
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) calendar.setTime(new Date());
        else calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 得到月
     *
     * @return int
     */
    public static int getMonth() {
        return getMonth(new Date());
    }

    /**
     * 得到月
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null)
            date = new Date();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 得到号数
     *
     * @return int
     */
    public static int getDate() {
        Calendar calendar = Calendar.getInstance();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        return calendar.get(Calendar.DATE);
    }

    public static int getHour() {
        return StringUtil.toInt(toString(new Date(),"HH"));
    }

    public static int getMinute() {
        Calendar calendar = Calendar.getInstance();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        return calendar.get(Calendar.MINUTE);
    }

    public static int getSecond() {
        Calendar calendar = Calendar.getInstance();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 得到今天是月中的第几天
     *
     * @return int
     */
    public static int getDAY_OF_MONTH() {
        return getDAY_OF_MONTH(new Date());
    }

    /**
     * @param trialTime 日期
     * @return 得到月中的第几天
     */
    public static int getDAY_OF_MONTH(Date trialTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(trialTime);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * @return int 得到今天周中的第几天
     */
    public static int getDAY_OF_WEEK() {
        return getDAY_OF_WEEK(new Date());
    }

    /**
     * @param trialTime 日期
     * @return 得到周中的第几天 7 为星期天
     */
    public static int getDAY_OF_WEEK(Date trialTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(trialTime);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * @return int  得到今天早上下午
     */
    public static int getAM_PM() {
        return getAM_PM(new Date());
    }

    /**
     * AM = 0
     * PM = 1;
     *
     * @param trialTime 日期
     * @return int 得到早上下午
     */
    public static int getAM_PM(Date trialTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(trialTime);
        return calendar.get(Calendar.AM_PM);
    }

    /**
     * @param trialTime 日期
     * @return 得到月分的最大天数
     */
    public static int getCountMonthDay(Date trialTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(trialTime); //放入你的日期
        return calendar.getMaximum(Calendar.DATE);
    }

    /**
     * @param date 日期
     * @return 取得当前日期所在周的第一天
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * @param date 日期
     * @return 取得当前日期所在周的最后一天
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        c.add(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    /**
     * 取得当前日期是多少周
     *
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);
        if (c.get(Calendar.DAY_OF_WEEK) != 0)
            return c.get(Calendar.WEEK_OF_YEAR) + 1;
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 得到某一年周的总数
     *
     * @param year
     * @return
     */
    public static int getMaxWeekNumOfYear(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long begin = calendar.getTime().getTime();
        calendar.set(Calendar.YEAR, year + 1);
        begin = calendar.getTime().getTime() - begin;
        return (int) NumberUtil.getRound(begin / WEEK, 0);
    }

    /**
     * @param trialTime 日期
     * @return 得到一个月开始的时间日期
     */
    public static Date getStartMonthDate(Date trialTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(trialTime); //放入你的日期
        calendar.set(Calendar.DATE, 1);
      return getStartDateTime(calendar.getTime());
    }

    /**
     * @param trialTime 日期
     * @return 得到一个月结束的时间日期
     */
    public static Date getEndMonthDate(Date trialTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(trialTime); //放入你的日期
        calendar.set(Calendar.AM_PM, Calendar.PM);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        return getEndDateTime(calendar.getTime());
    }

    /**
     * @param trialTime 日期
     * @return 得到一个年开始的时间日期
     */
    public static Date getStartYearDate(Date trialTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(trialTime); //放入你的日期
        calendar.set(Calendar.MONTH, 0);
        return getStartMonthDate(calendar.getTime());
    }


    /**
     * @param trialTime 日期
     * @return 得到一年结束的时间日期
     */
    public static Date getEndYearDate(Date trialTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(trialTime); //放入你的日期
        calendar.set(Calendar.MONTH, 11);
        return getEndMonthDate(calendar.getTime());
    }

    /**
     * 中国习惯开始为星期一,结束为星期天
     *
     * @param year 年
     * @param week 第几周
     * @return　指定周开始和结束的日期时间
     */
    public static Date[] getWeekStartAndEnd(int year, int week) {
        Date[] result = new Date[2];
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, week);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        while (cal.get(Calendar.YEAR) < year) {
            cal.setTimeInMillis(cal.getTimeInMillis() + DAY);
        }
        result[0] = getStartDateTime(cal.getTime());

        //结束日期
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, week);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        while (cal.get(Calendar.YEAR) > year) {
            cal.setTimeInMillis((cal.getTimeInMillis() - DAY));
        }
        result[1] = getEndDateTime(cal.getTime());
        return result;
    }

    public static Date[] getSeasonStartAndEnd(Date date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int startMonth = 0;

        if (month <= 3) startMonth = 1;
        else if (month > 3 && month <= 6) startMonth = 4;
        else if (month > 6 && month <= 9) startMonth = 7;
        else if (month > 9) startMonth = 10;

        //7月-9月;
        Date[] result = new Date[2];
        int endMonth = startMonth + 2;
        Date start = DateUtil.getStartMonthDate(StringUtil.toDate((new StringBuilder().append(year).append("-").append(startMonth).append("-01")).toString()));
        Date end = DateUtil.getEndMonthDate(StringUtil.toDate((new StringBuilder().append(year).append("-").append(endMonth).append("-25")).toString()));
        result[0] = start;
        result[1] = end;
        return result;
    }


    /**
     * 得到变化年的日期
     *
     * @param move 偏移量
     * @return Date  需要偏移的日期
     */
    public static Date addYear(int move) {
        return addYear(move, new Date());
    }

    /**
     * 得到变化年的日期
     *
     * @param move 偏移量
     * @return Date  需要偏移的日期
     */
    public static Date addYear(int move, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, move);
        return calendar.getTime();
    }

    /**
     * @param move 偏移量
     * @param date 需要偏移的日期
     * @return 得到变化年的月
     */
    public static Date addMonth(int move, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, move);
        return calendar.getTime();
    }

    /**
     * @param itmp 偏移量
     * @return Date 得到变化号数的日期
     */
    public static Date addDate(int itmp) {
        return addDate(itmp, new Date());
    }

    /**
     * @param itmp
     * @param theDate
     * @return
     */
    public static Date addDate(int itmp, Date theDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(theDate);
        calendar.add(Calendar.DATE, itmp);
        return calendar.getTime();
    }

    /**
     * @param yeas  年
     * @param month 月
     * @param date  日
     * @return 日期时间，得到偏移时间
     */
    public static Date createDate(int yeas, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, yeas);
        calendar.add(Calendar.MONTH, month);
        calendar.add(Calendar.DATE, date);
        return calendar.getTime();
    }

    /**
     * @param date 日期
     * @return 得到这天开始的时间
     */
    public static Date getStartDateTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.AM_PM, 0);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * @param date 日期
     * @return 得到这天最后结束的时间
     */
    public static Date getEndDateTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getStartDateTime(date));
        calendar.set(Calendar.AM_PM, Calendar.PM);
        calendar.add(Calendar.HOUR, calendar.getActualMaximum(Calendar.HOUR));
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }


    /**
     * 比较较两个日期,返回天数差
     *
     * @param beginDate 开始日期时间
     * @param endDate   结束日期时间
     * @return int
     */
    public static long compareDay(Date beginDate, Date endDate) {
        Calendar endDateYears = new GregorianCalendar();
        endDateYears.setTime(endDate);
        Calendar beginYears = new GregorianCalendar();
        beginYears.setTime(beginDate);
        long diffMillis = endDateYears.getTimeInMillis() - beginYears.getTimeInMillis();
        return diffMillis / (24 * 60 * 60 * 1000);
    }

    /**
     * 比较较两个日期,返回天数差
     *
     * @param beginDate 开始日期时间
     * @return int
     */
    public static long compareDay(Date beginDate) {
        return compareDay(beginDate, new Date());
    }

    /**
     *
     * @param beginDate 开始时间
     * @param endDate 结束时间
     * @return 返回分 
     */
    public static long compareMinute(Date beginDate, Date endDate) {
        Calendar beginYears = new GregorianCalendar();
        beginYears.setTime(beginDate);
        long diffMillis = endDate.getTime() - beginYears.getTimeInMillis();
        return diffMillis / (60 * 1000);
    }

    /**
     * 
     * @param beginDate 开始时间
     * @param endDate 结束时间
     * @return 返回小时 
     */
    public static long compareHour(Date beginDate, Date endDate) {
        Calendar beginYears = new GregorianCalendar();
        beginYears.setTime(beginDate);
        long diffMillis = endDate.getTime() - beginYears.getTimeInMillis();
        return diffMillis / (60 * 60 * 1000);
    }

    /**
     * 判断是否属于这个日期范围,txweb 标题中判断是否 是新的
     *
     * @param date 创建日期
     * @param iday 天数
     * @return boolean
     */
    static public boolean inDate(Date date, int iday) {
        return compareDay(date) < iday;
    }

    /**
     * <OPTION value="o">保密</OPTION>
     * <OPTION value="z1">白羊座(3月21--4月19日)</OPTION>
     * <OPTION value="z2">金牛座(4月20--5月20日)</OPTION>
     * <OPTION value="z3">双子座(5月21--6月21日)</OPTION>
     * <OPTION value="z4">巨蟹座(6月22--7月22日)</OPTION>
     * <OPTION value="z5">狮子座(7月23--8月22日)</OPTION>
     * <OPTION value="z6">处女座(8月23--9月22日)</OPTION>
     * <OPTION value="z7">天秤座(9月23--10月23日)</OPTION>
     * <OPTION value="z8">天蝎座(10月24--11月21日)</OPTION>
     * <OPTION value="z9">射手座(11月22--12月21日)</OPTION>
     * <OPTION value="z10">魔羯座(12月22--1月19日)</OPTION>
     * <OPTION value="z11">水瓶座(1月20--2月18日)</OPTION>
     * <OPTION value="z12">双鱼座(2月19--3月20日)</OPTION>
     *
     * @param date 生日日期
     * @return int 更具上边得到星座
     */
    static public int getBirthStar(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        if (dateFormat.format(date).equals("1970-01-01")) return 0;

        dateFormat = new SimpleDateFormat("MM");
        int mm = StringUtil.toInt(dateFormat.format(date));
        dateFormat = new SimpleDateFormat("dd");
        int dd = StringUtil.toInt(dateFormat.format(date));
        if ((mm == 3 && dd >= 21) || (mm == 4 && dd <= 19)) return 1;
        if ((mm == 4 && dd >= 20) || (mm == 5 && dd <= 20)) return 2;
        if ((mm == 5 && dd >= 21) || (mm == 6 && dd <= 21)) return 3;
        if ((mm == 6 && dd >= 22) || (mm == 7 && dd <= 22)) return 4;
        if ((mm == 7 && dd >= 23) || (mm == 8 && dd <= 22)) return 5;
        if ((mm == 8 && dd >= 23) || (mm == 9 && dd <= 22)) return 6;
        if ((mm == 9 && dd >= 23) || (mm == 10 && dd <= 23)) return 7;
        if ((mm == 10 && dd >= 24) || (mm == 11 && dd <= 21)) return 8;
        if ((mm == 11 && dd >= 22) || (mm == 12 && dd <= 21)) return 9;
        if ((mm == 12 && dd >= 22) || (mm == 1 && dd <= 19)) return 10;
        if ((mm == 1 && dd >= 20) || (mm == 2 && dd <= 18)) return 11;
        if ((mm == 2 && dd >= 19) || (mm == 3 && dd <= 20)) return 12;
        return 0;
    }

    /**
     * 转换为日期
     *
     * @param gmt "GMT+08:00"
     * @return Date
     */
    public static Date getGmtDate(String gmt) {
        if (StringUtil.isNULL(gmt)) return new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtil.FULL_ST_FORMAT);
        TimeZone timezone = TimeZone.getTimeZone(gmt);
        dateFormat.setTimeZone(timezone);
        try {
            String fullDate = dateFormat.format(new Date());
            dateFormat.setTimeZone(TimeZone.getDefault());
            return dateFormat.parse(fullDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static java.sql.Date toSqlDate(Date date) {
        if (date == null) return null;
        return new java.sql.Date(date.getTime());
    }

    public static Date toJavaDate(java.sql.Date date) {
        if (date == null) return null;
        return new Date(date.getTime());
    }

    /**
     * 返回一个String类型的他们之间的时间差 只到小时 例如:38:15:00(三十八小时15分) 如果获取的当前日期在后面 则返回0
     *
     * @param date 比较的实际
     * @return 字符串
     */
    public static String minus(Date date) {
        Date now = new Date();
        if (now.after(date)) {
            return "0";
        } else {
            long time = date.getTime() - now.getTime();
            int hour = (int) (time / (60 * 60 * 1000));
            int minute = (int) ((time % (60 * 60 * 1000)) / (60 * 1000));
            int second = (int) (((time % (60 * 60 * 1000)) % (60 * 1000)) / 1000 + 1);
            if (second == 60) {
                second = 0;
                minute += 1;
            }
            if (minute == 60) {
                minute = 0;
                hour += 1;
            }
            return "" + (hour < 10 ? ("0" + hour) : hour) + ":" + (minute < 10 ? ("0" + minute) : minute) + ":" + (second < 10 ? ("0" + second) : second);
        }
    }

    public String toString() {
        return toString(new Date(), null);
    }


    /**
     * @param format 格式
     * @return String 格式化日期时间
     */
    public static String toString(String format)
    {
        return toString(new Date(), format);
    }

    /**
     * @param format 格式
     * @param date   日期
     * @return String  格式化日期时间
     */
    public static String toString(Date date, String format)
    {
        if (format == null) format = FULL_ST_FORMAT;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }
    
    /**
     * @param format 格式
     * @param String   格式化日期时间
     * @return String   日期
     * @throws ParseException 
     */
    public static Date toDate(String format, String source) throws ParseException
    {
        if (format == null) format = FULL_ST_FORMAT;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(source);
    }

}
