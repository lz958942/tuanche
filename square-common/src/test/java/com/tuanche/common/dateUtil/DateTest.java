package com.tuanche.common.dateUtil;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import com.tuanche.common.dateUtil.DateTranslateUtil;
import com.tuanche.common.dateUtil.DateCommonUtil.IntervalUnit;

/**
 * Unit test for simple App.
 */
public class DateTest {
	
	
	@Test
	public void dateFormatYYYYMMDDD() {
		String date = DateCommonUtil.dateFormatYYYYMMDDD(new Date());
		Assert.assertEquals("2016-03-01", date);
		
	}
	
	@Test
	public void timestampFormatYYYYMMDDHHMMSS() {
		String date = DateCommonUtil.timestampFormatYYYYMMDDHHMMSS(new Date());
		Assert.assertEquals("2016-03-01 17:43:23", date);
		
	}
	
	@Test
	public void timestampFormatYYYYMMDDHHMMSSLong() {
		String date = DateCommonUtil.timestampFormatYYYYMMDDHHMMSS(new Date().getTime());
		Assert.assertEquals("2016-03-01 17:43:23", date);
		
	}
	
	@Test
	public void dateFormatYYYYMMDDDLong() {
		String date = DateCommonUtil.dateFormatYYYYMMDDD(new Date().getTime());
		Assert.assertEquals("2016-03-01", date);
		
	}
	
	@Test
	public void formatTimestampToDateYYYYMMDDHHMMSS() {
		Date date = DateCommonUtil.formatTimestampToDateYYYYMMDDHHMMSS("2016-03-01 17:49:57");
		Assert.assertEquals(new Date(), date);
		
	}
	
	@Test
	public void formatTimestampToDateYYYYMMDD() {
		Date date = DateCommonUtil.formatTimestampToDateYYYYMMDD("2016-03-01");
		Assert.assertEquals(new Date(), date);
		
	}
	
	@Test
	public void formatDateToLongYYYYMMDDD() {
		long date = DateCommonUtil.formatDateToLongYYYYMMDDD("2016-03-01");
		Assert.assertEquals(new Date().getTime(), date);
		
	}
	
	@Test
	public void formatTimestampToLongYYYYMMDDHHMMSS() {
		long date = DateCommonUtil.formatTimestampToLongYYYYMMDDHHMMSS("2016-03-01 17:53:57");
		Assert.assertEquals(new Date().getTime(), date);

	}
	
	
	
	/************         20160303           *********/
	@Test
	public void getDateFormatYYYYMMDD(){
		SimpleDateFormat sd = DateSimpleFormUtil.getDateFormatYYYYMMDD();
		Assert.assertEquals(new SimpleDateFormat("yyyy-MM-dd"), sd);
	}
	
	
	@Test
	public void getStrFormatYYYYMMDDChinese(){
		SimpleDateFormat sd =  DateSimpleFormUtil.getStrFormatYYYYMMDDChinese();
		Assert.assertEquals(new SimpleDateFormat("yyyy年 MM月 dd日"), sd);
	}
	
	@Test
	public void  getTimestampFormatYYYYMMDDHHMMSS(){
		SimpleDateFormat sd = DateSimpleFormUtil.getTimestampFormatYYYYMMDDHHMMSS();
		Assert.assertEquals(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), sd);
	}
	
	@Test
	public void isDate() {
		Boolean flag =  DateTranslateUtil.isDate("2016-03-03");
		Assert.assertEquals(new Boolean(true), flag);
	}
	
	@Test
	public void intervalDate(){
		Date date = DateTranslateUtil.intervalDate(0, IntervalUnit.DAY);
		Assert.assertEquals(new Date(), date);
	}
	
	@Test
	public void replaceSeparator() {
		String date = DateTranslateUtil.replaceSeparator("2015-01-01", "-");
		Assert.assertEquals(new String("20150101"), date);
	}
	
	@Test
	public void replaceAllSeparator(){
		String date = DateTranslateUtil.replaceAllSeparator("2015-01-01");
		Assert.assertEquals(new String("20150101"), date);
	}
	
	@Test
	public void addTime() {
		Date date = DateTranslateUtil.addTime(new Date(), 0);
		Assert.assertEquals(new Date(), date);
	}
	
	@Test
	public void getTime(){
		Date date =  DateTranslateUtil.getTime(new Date(), 0);
		Assert.assertEquals(new Date(), date);
	}
	@Test
	public void getTimeByNow(){
		Date date =  DateTranslateUtil.getTime(0);
		Assert.assertEquals(new Date(), date);
	}
	
	@Test
	public void getLastSecondOfWeek(){
		Long date = DateTranslateUtil.getLastSecondOfWeek(new Date());
		Assert.assertEquals(new Long(1457279999999L), date);
	}
	
	@Test
	public void getSaturdayOfWeek(){
		Long date = DateTranslateUtil.getSaturdayOfWeek(new Date());
		Assert.assertEquals(new Long(1457107200000L), date);
	}
	
	@Test
	public void getFirstDayOfWeek(){
		Date date = DateTranslateUtil.getFirstDayOfWeek(new Date());
		Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void  getLastMillSecondOfNextMonth(){
		Long date =  DateTranslateUtil.getLastMillSecondOfNextMonth();
		Assert.assertEquals(new Long(1462031999000L), date);
	}
	
	@Test
	public void  getFirstMillSecondOfNextMonth(){
		Long date =  DateTranslateUtil.getFirstMillSecondOfNextMonth();
		Assert.assertEquals(new Long(1459440000000L), date);
	}
	
	@Test
	public void  getLastDayOfCurrentMonth(){
		Date date =  DateTranslateUtil.getLastDayOfCurrentMonth();
		Assert.assertEquals(4, date.getDay());
	}
	
	@Test
	public void  getLastDayOfMonth(){
		Date date = DateTranslateUtil.getLastDayOfMonth(0);
		Assert.assertEquals(4, date.getDay());
	}
	
	@Test
	public void  getLastDayOfMonthByDate(){
		Date date = DateTranslateUtil.getLastDayOfMonth(new Date());
		Assert.assertEquals(4, date.getDay());
	}
	
	@Test
	public void  getFirstDayOfCurrentMonth(){
		Date date = DateTranslateUtil.getFirstDayOfCurrentMonth();
		Assert.assertEquals(2, date.getDay());
	}
	
	@Test
	public void  getFirstDayOfMonth(){
		Date date = DateTranslateUtil.getFirstDayOfMonth(0);
		Assert.assertEquals(2, date.getDay());
	}
	
	@Test
	public void  getFirstDayOfMonthByDay(){
		String date = DateTranslateUtil.getFirstDayOfMonth(new Date());
		Assert.assertEquals("2016-03-01", date);
	}
	
	
	@Test
	public void  getNowTimestamp(){
		Timestamp date = DateTranslateUtil.getNowTimestamp();
		//System.out.println(date.getTime());
	}
	
	@Test
	public void  getNowDate(){
		Date date = DateTranslateUtil.getNowDate();
		//System.out.println(date.getTime());
	}
	
	@Test
	public void  getStringToLong(){
		Long date = DateTranslateUtil.getStringToLong(DateStringType.yyyyMMdd, "2016-03-03");
		Assert.assertEquals(new Long(1456934400000L), date);
	}
	
	@Test
	public void  getStringToDate(){
		Date date = DateTranslateUtil.getStringToDate(DateStringType.yyyyMMdd, "2016-03-03");
		Assert.assertEquals(new Date().getDate(), date.getDate());
	}
	
	
	@Test
	public void  getLongToDate(){
		String date = DateTranslateUtil.getLongToDate(DateStringType.yyyyMMdd, 1456934400000L);
		Assert.assertEquals(new String("2016-03-03"), date);
	}
	
	
	@Test
	public void  getDateToString(){
		 String date = DateTranslateUtil.getDateToString(DateStringType.yyyyMMdd, new Date());
		 Assert.assertEquals(new String("2016-03-03"), date);
	}
	
	
	@Test
	public void  getSimpleDateFormat(){
		SimpleDateFormat date = DateTranslateUtil.getSimpleDateFormat(DateFormatType.yyyyMMdd);
		Assert.assertEquals(new SimpleDateFormat("yyyy-MM-dd"), date);
	}
	
	
	
	
}
