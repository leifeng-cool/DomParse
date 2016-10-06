package com.ybs.test;

import org.w3c.dom.Document;

import com.ybs.dom.DomParse;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document document = DomParse.getDocument("File/district.xml");
//		Document document = DomParse.getDocument("File/commodity.xml");
//		DomParse.parseTableName(document, "TableName");
//		DomParse.parseNode(document, "Items", "name", false);
//		DomParse.parseNode(document, "book", null, true);
//		System.out.println(DomParse.getTablename());
		DomParse.parseNode2(document, "province");
//		DomParse.parseNode2(document, "book");
	}

}
