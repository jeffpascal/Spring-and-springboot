package com.spring.xml;

public class XmlPersonDAO {
	
	XmlJdbcConnection xmljdbcConnection;

	public XmlJdbcConnection getXmlJdbcConnection() {
		return xmljdbcConnection;
	}

	public void setXmlJdbcConnection(XmlJdbcConnection jdbcConnection) {
		this.xmljdbcConnection = jdbcConnection;
	}
}
