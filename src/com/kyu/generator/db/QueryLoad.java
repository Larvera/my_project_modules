package com.kyu.generator.db;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * @FileName : XMLLoad.java
 * @Project : sample_project
 * @Date : 2012. 7. 10.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class QueryLoad {

	/**
	 * <pre>
	 * getQuery
	 * 쿼리 추출
	 * <pre>
	 * @param queryId
	 * @return
	 */
	public String getQuery(String queryId) {
		String query = null;
		try {
			String uri = getXmlPath();

			DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = domFactory.newDocumentBuilder();
			Document doc = builder.parse(uri);

			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();

			String expression = getXpathExpression(queryId);
			XPathExpression expr = xpath.compile(expression);

			NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			query = nodes.item(0).getNodeValue().trim();

		} catch (Exception ex) {
			System.out.println("##getQuery## (exception failed)");
			ex.printStackTrace();
		}
		return query;
	}

	/**
	 * <pre>
	 * getXpathExpression
	 * Xpath 표현식 생성
	 * <pre>
	 * @param queryId
	 */
	private String getXpathExpression(String queryId) {
		StringBuilder expressionBuf = new StringBuilder();
		expressionBuf.append("//sql[@id='");
		expressionBuf.append(queryId);
		expressionBuf.append("']/text()");
		return expressionBuf.toString();
	}

	/**
	 * <pre>
	 * getXmlPath
	 * 쿼리 파일 path
	 * <pre>
	 * @return
	 */
	private String getXmlPath() {
		String xmlPath = "com/kyu/generator/db/sql.xml";
		URL url = this.getClass().getClassLoader().getResource(xmlPath);
		return url.toString();
	}

	/**
	 * <pre>
	 * main
	 *
	 * <pre>
	 * @param args
	 */
	public static void main(String[] args) {
		QueryLoad queryLoad = new QueryLoad();
		queryLoad.getQuery("mysqlQuery");
	}
}
