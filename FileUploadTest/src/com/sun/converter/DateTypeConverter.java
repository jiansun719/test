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
		if (toType == Date.class) { //�������������ύʱ������String to Date��ת��
			String[] params = (String[])value;
			try {
				return simple.parse(params[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//��������֧�ָ�ʽ������ת��}		
		}else if (toType == String.class) { //����������������ʱ������Date to String������ת��
			Date date = (Date)value;
			return new SimpleDateFormat("yyyy-MM-dd").format(date);//����ĸ�ʽ��yyyy-MM-dd}return null;}}
		}
		return null;
	}	
}
