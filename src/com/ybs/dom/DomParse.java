package com.ybs.dom;

import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class DomParse {
	
	private static String tablename ;
	/**
	 * 创建document对象
	 * @param url
	 * @return
	 */
	public static Document getDocument(String url) {
		Document document = null;
		//创建DocumentBuilderFactory对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//DocumentBuilder对象
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(url);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
	}
	
	// 解析xml文档，将解析出的数据写入数据库
	 
	public static String getTablename() {
		return tablename;
	}

	public static void setTablename(String tablename) {
		DomParse.tablename = tablename;
	}

	//解析TableName,获取表名
	public static void parseTableName(Document document,String TableName){
		NodeList tableName = document.getElementsByTagName(TableName);
		NamedNodeMap tableAttrs = tableName.item(0).getAttributes();
		for (int i = 0; i < tableAttrs.getLength(); i++) {
			 Node tableAttr = tableAttrs.item(i);
			 String NodeName = tableAttr.getNodeName();
			 String NodeValue = tableAttr.getNodeValue();
			 System.out.println(NodeName+":"+NodeValue);
		}
		System.out.println();
	}
	
	//遍历获取表内Items，只有节点的属性值或者只有子节点值
	public static void parseNode(Document document,String pNode,String cAttr,Boolean cNode){
		NodeList node = document.getElementsByTagName(pNode);
		for (int i = 0; i < node.getLength(); i++) {
			//获取一个Node节点
			Node iNode = node.item(i);
			NamedNodeMap attrs = iNode.getAttributes();
			for (int j = 0; j < attrs.getLength(); j++) {
				Node attr = attrs.item(j);
				String NodeName = attr.getNodeName();
				String NodeValue = attr.getNodeValue();
				System.out.println(NodeName+":"+NodeValue);
				// 解析Items节点的子节点
				NodeList item = iNode.getChildNodes();
				for (int k = 0; k < item.getLength(); k++) {
					if (item.item(k).getNodeType() == Node.ELEMENT_NODE) {
						if (cAttr!=null) {
							NamedNodeMap itemAttrs = item.item(k).getAttributes();
						 	Node itemAttr = itemAttrs.getNamedItem(cAttr);
						 	String attrName = itemAttr.getNodeName();
						 	String attrValue = itemAttr.getNodeValue();
						 	System.out.println("    |--"+attrName+":"+attrValue);
						} 
						if(cNode) {
							String cNodeName = item.item(k).getNodeName();
						 	String cNodeValue = item.item(k).getFirstChild().getNodeValue();
						 	System.out.println("  |--"+cNodeName+":"+cNodeValue);
						}
					}
				}
			}
		}
	}
	//遍历节点下带有属性值和子节点值
	public static void parseNode2(Document document,String pNode){
		//遍历子节点
		NodeList fList = document.getElementsByTagName(pNode);
		for (int i = 0; i < fList.getLength(); i++) {
			//获取一个节点
			Node item = fList.item(i);
			//遍历属性值
			NamedNodeMap itemAttrs = item.getAttributes();
			for (int j = 0; j < itemAttrs.getLength(); j++) {
				Node itemAttr = itemAttrs.item(j);
				String AttrName = itemAttr.getNodeName();
				String AttrValue = itemAttr.getNodeValue();
				System.out.println(AttrName+":"+AttrValue);
				// 解析FirstClass节点的子节点
				NodeList cList = item.getChildNodes();
				for (int k = 0; k < cList.getLength(); k++) {
					if (cList.item(k).getNodeType()==Node.ELEMENT_NODE) {
						Node citem = cList.item(k);
						NamedNodeMap citemAttrs = citem.getAttributes();
						for (int l = 0; l < citemAttrs.getLength(); l++) {
							Node citemAttr = citemAttrs.item(l);
							String cAttrName = citemAttr.getNodeName();
							String cAttrValue = citemAttr.getNodeValue();
							System.out.println("  |--"+cAttrName+":"+cAttrValue);
							NodeList gList = citem.getChildNodes();
							for (int m = 0; m < gList.getLength(); m++) {
								if (gList.item(m).getNodeType()==Node.ELEMENT_NODE) {
									Node gNode = gList.item(m);
									String NodeName = gNode.getNodeName();
									String NodeValue = gNode.getFirstChild().getNodeValue();
									System.out.println("    |--"+NodeName+":"+NodeValue);
								}
							}
						}
					}
				}
			}
		}
	}
}
