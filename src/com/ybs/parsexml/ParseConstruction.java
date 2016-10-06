package com.ybs.parsexml;

import org.w3c.dom.Document;

import com.ybs.dom.DomParse;

public class ParseConstruction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 引入xml文件
		Document document = DomParse.getDocument("File/construction.xml");
		// 配置parseTableName参数，获取表单属性参数
		DomParse.parseTableName(document, "MeteData");
		// 配置parseNode参数，遍历子节点信息
		DomParse.parseNode(document, "FirstClass", "name", false);
	}	

}
