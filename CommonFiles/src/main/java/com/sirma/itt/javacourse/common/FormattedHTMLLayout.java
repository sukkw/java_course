package com.sirma.itt.javacourse.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.HTMLLayout;
import org.apache.log4j.spi.LoggingEvent;

public class FormattedHTMLLayout extends HTMLLayout {

	private String rxTimestamp = "\\s*<\\s*tr\\s*>\\s*<\\s*td\\s*>\\s*(\\d*)\\s*<\\s*/td\\s*>";
	private String timestampFormat = "yyyy-MM-dd HH:mm:ss";
	private SimpleDateFormat sdf = new SimpleDateFormat(timestampFormat);

	public FormattedHTMLLayout() {
		super();
	}

	/**
	 * Override HTMLLayout's format() method.
	 */
	public String format(LoggingEvent event) {
		String record = super.format(event);

		Pattern pattern = Pattern.compile(rxTimestamp);
		Matcher matcher = pattern.matcher(record);

		if (!matcher.find()) {
			return record;
		}

		StringBuffer buffer = new StringBuffer(record);

		buffer.replace(matcher.start(1), matcher.end(1),
				sdf.format(new Date(event.timeStamp)));

		return buffer.toString();
	}
}