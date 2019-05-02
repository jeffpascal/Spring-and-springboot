package com.spring.xml;

public class XMLPersonDAO {
	
	XMLJdbcConnection xmljdbcConnection;

	public XMLJdbcConnection getXMLJdbcConnection() {
		return xmljdbcConnection;
	}

	public void setJdbcConnection(XMLJdbcConnection jdbcConnection) {
		this.xmljdbcConnection = jdbcConnection;
	}
}
