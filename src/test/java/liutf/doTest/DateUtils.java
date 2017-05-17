package liutf.doTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils
{

	public static final String COMPACT_DATE_FORMAT = "yyyyMMdd";  
    public static final String YM = "yyyyMM";  
    public static final String NORMAL_DATE_FORMAT = "yyyy-MM-dd";  
    public static final String NORMAL_DATE_FORMAT_NEW = "yyyy-mm-dd hh24:mi:ss";  
    public static final String DATE_FORMAT = "yyyy-MM-dd";  
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";  
    public static final String DATE_ALL = "yyyyMMddHHmmssS";  
  
    public static Long strDateToNum(String paramString) throws Exception {  
        if (paramString == null)  
            return null;  
        String[] arrayOfString = null;  
        String str = "";  
        if (paramString.indexOf("-") >= 0) {  
            arrayOfString = paramString.split("-");  
            for (int i = 0; i < arrayOfString.length; ++i)  
                str = str + arrayOfString[i];  
            return Long.valueOf(Long.parseLong(str));  
        }  
        return Long.valueOf(Long.parseLong(paramString));  
    }  
  
    public static Long strDateToNum1(String paramString) throws Exception {  
        if (paramString == null)  
            return null;  
        String[] arrayOfString = null;  
        String str = "";  
        if (paramString.indexOf("-") >= 0) {  
            arrayOfString = paramString.split("-");  
            for (int i = 0; i < arrayOfString.length; ++i)  
                if (arrayOfString[i].length() == 1)  
                    str = str + "0" + arrayOfString[i];  
                else  
                    str = str + arrayOfString[i];  
            return Long.valueOf(Long.parseLong(str));  
        }  
        return Long.valueOf(Long.parseLong(paramString));  
    }  
  
    public static String numDateToStr(Long paramLong) {  
        if (paramLong == null)  
            return null;  
        String str = null;  
        str = paramLong.toString().substring(0, 4) + "-"  
                + paramLong.toString().substring(4, 6) + "-"  
                + paramLong.toString().substring(6, 8);  
        return str;  
    }  
  
    public static Date stringToDate(String paramString1,
            String paramString2) throws Exception {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(
                paramString2);
        localSimpleDateFormat.setLenient(false);
        try {
            return localSimpleDateFormat.parse(paramString1);
        } catch (ParseException localParseException) {
            throw new Exception("解析日期字符串时出错！");
        }
    }

    public static String dateToString(Date paramDate,
            String paramString) {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(
                paramString);
        localSimpleDateFormat.setLenient(false);
        return localSimpleDateFormat.format(paramDate);
    }

    public static Date compactStringToDate(String paramString)
            throws Exception {
        return stringToDate(paramString, "yyyyMMdd");
    }

    public static String dateToCompactString(Date paramDate) {
        return dateToString(paramDate, "yyyyMMdd");
    }

    public static String dateToNormalString(Date paramDate) {
        return dateToString(paramDate, "yyyy-MM-dd");
    }

    public static String compactStringDateToNormal(String paramString)
            throws Exception {
        return dateToNormalString(compactStringToDate(paramString));
    }

    public static int getDaysBetween(Date paramDate1,
            Date paramDate2) throws Exception {
        Calendar localCalendar1 = Calendar.getInstance();
        Calendar localCalendar2 = Calendar.getInstance();
        localCalendar1.setTime(paramDate1);
        localCalendar2.setTime(paramDate2);
        if (localCalendar1.after(localCalendar2))
            throw new Exception("起始日期小于终止日期!");
        int i = localCalendar2.get(6) - localCalendar1.get(6);
        int j = localCalendar2.get(1);
        if (localCalendar1.get(1) != j) {
            localCalendar1 = (Calendar) localCalendar1.clone();
            do {
                i += localCalendar1.getActualMaximum(6);
                localCalendar1.add(1, 1);
            } while (localCalendar1.get(1) != j);
        }
        return i;
    }

    public static Date addDays(Date paramDate, int paramInt)
            throws Exception {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(paramDate);
        int i = localCalendar.get(6);
        localCalendar.set(6, i + paramInt);
        return localCalendar.getTime();
    }

    public static Date addDays(String paramString1,
            String paramString2, int paramInt) throws Exception {
        Calendar localCalendar = Calendar.getInstance();
        Date localDate = stringToDate(paramString1, paramString2);
        localCalendar.setTime(localDate);
        int i = localCalendar.get(6);
        localCalendar.set(6, i + paramInt);
        return localCalendar.getTime();
    }

    public static java.sql.Date getSqlDate(Date paramDate)
            throws Exception {
        java.sql.Date localDate = new java.sql.Date(paramDate.getTime());
        return localDate;
    }

    public static String formatDate(Date paramDate) {
        if (paramDate == null)
            return null;
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        localSimpleDateFormat.setLenient(false);
        return localSimpleDateFormat.format(paramDate);
    }

    public static String formatDateTime(Date paramDate) {
        if (paramDate == null)
            return null;
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        localSimpleDateFormat.setLenient(false);
        return localSimpleDateFormat.format(paramDate);
    }

    public static Date parseDate(String paramString)
            throws Exception {
        if ((paramString == null) || (paramString.trim().equals("")))
            return null;
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        localSimpleDateFormat.setLenient(false);
        try {
            return localSimpleDateFormat.parse(paramString);
        } catch (ParseException localParseException) {
            throw new Exception("日期解析出错！", localParseException);
        }
    }

    public static Date parseDateTime(String paramString)
            throws Exception {
        if ((paramString == null) || (paramString.trim().equals("")))
            return null;
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        localSimpleDateFormat.setLenient(false);
        try {
            return localSimpleDateFormat.parse(paramString);
        } catch (ParseException localParseException) {
            throw new Exception("时间解析异常！", localParseException);
        }
    }

    public static Integer getYM(String paramString) throws Exception {
        if (paramString == null)
            return null;
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        localSimpleDateFormat.setLenient(false);
        Date localDate;
        try {
            localDate = localSimpleDateFormat.parse(paramString);
        } catch (ParseException localParseException) {
            throw new Exception("时间解析异常！", localParseException);
        }
        return getYM(localDate);
    }

    public static Integer getYM(Date paramDate) {
        if (paramDate == null)
            return null;
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(paramDate);
        int i = localCalendar.get(1);
        int j = localCalendar.get(2) + 1;
        return new Integer(i * 100 + j);
    }

    public static int addMonths(int paramInt1, int paramInt2) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.set(1, paramInt1 / 100);
        localCalendar.set(2, paramInt1 % 100 - 1);
        localCalendar.set(5, 1);
        localCalendar.add(2, paramInt2);
        return getYM(localCalendar.getTime()).intValue();
    }

    public static Date addMonths(Date paramDate,
            int paramInt) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(paramDate);
        localCalendar.add(2, paramInt);
        return localCalendar.getTime();
    }

    public static int monthsBetween(int paramInt1, int paramInt2) {
        int i = paramInt2 / 100 * 12 + paramInt2 % 100
                - (paramInt1 / 100 * 12 + paramInt1 % 100);
        return i;
    }

    public static int monthsBetween(Date paramDate1,
            Date paramDate2) {
        return monthsBetween(getYM(paramDate1).intValue(), getYM(paramDate2).intValue());
    }

    public static String getChineseDate(Calendar paramCalendar) {
        int i = paramCalendar.get(1);
        int j = paramCalendar.get(2);
        int k = paramCalendar.get(5);
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(i);
        localStringBuffer.append("年");
        localStringBuffer.append(j + 1);
        localStringBuffer.append("月");
        localStringBuffer.append(k);
        localStringBuffer.append("日");
        return localStringBuffer.toString();
    }

    public static String getChineseWeekday(Calendar paramCalendar) {
        switch (paramCalendar.get(7)) {
        case 2:
            return "星期一";
        case 3:
            return "星期二";
        case 4:
            return "星期三";
        case 5:
            return "星期四";
        case 6:
            return "星期五";
        case 7:
            return "星期六";
        case 1:
            return "星期日";
        }
        return "未知";
    }

    public static String compareDateDiff(Date paramDate1, Date  paramDate2)
    {
    	long time1 = paramDate1.getTime();
    	long time2 = paramDate2.getTime();
    	long diff = time2-time1;
    	int day = (int)(diff/(24 * 60 * 60 * 1000));
    	int hour = (int)(diff%(24 * 60 * 60 * 1000)/(60 * 60 * 1000));
    	int min = (int)(diff%(24 * 60 * 60 * 1000)%(60 * 60 * 1000)/(60*1000));
    	return day+"天" + hour + "小时" + min + "分";
    }
    
    /**
     *  得到星期几
     *  
     * @author chenguoqi
     * 
     * @param Date
     * 
     * @return
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    
    
	
    /**
     * 判断某一时间是否在一个区间内
     * 
     * @author chenguoqi
     * 
     * @param sourceTime
     *            时间区间,半闭合,如[10:00-20:00)
     * @param curTime
     *            需要判断的时间 如10:00
     * @return 
     * @throws IllegalArgumentException
     */
    public static boolean isInTime(String sourceTime, String curTime) {
        if (sourceTime == null || !sourceTime.contains("-") || !sourceTime.contains(":")) {
            throw new IllegalArgumentException("参数错误:sourceTime" + sourceTime);
        }
        if (curTime == null || !curTime.contains(":")) {
            throw new IllegalArgumentException("参数错误:curTime:" + curTime);
        }
        String[] args = sourceTime.split("-");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            long now = sdf.parse(curTime).getTime();
            long start = sdf.parse(args[0]).getTime();
            long end = sdf.parse(args[1]).getTime();
            if (args[1].equals("00:00")) {
                args[1] = "24:00";
            }
            if (end < start) {
                if (now >= end && now < start) {
                    return false;
                } else {
                    return true;
                }
            } 
            else {
                if (now >= start && now < end) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
        }

    }
}
