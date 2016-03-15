package com.sun.converter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class DateTypeConverter extends DefaultTypeConverter {

	@Override
	public Object convertValue(Map<String, Object> context, Object value, @SuppressWarnings("rawtypes") Class toType) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
		if (toType == Date.class) { //浏览器向服务器提交时，进行String to Date的转换
			String[] params = (String[])value;
			try {
				return simple.parse(params[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//遍历日期支持格式，进行转换}		
		}else if (toType == String.class) { //服务器向浏览器输出时，进行Date to String的类型转换
			Date date = (Date)value;
			return new SimpleDateFormat("yyyy-MM-dd").format(date);//输出的格式是yyyy-MM-dd}return null;}}
		}
		return null;
	}	
}
