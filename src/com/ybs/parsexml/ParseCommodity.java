package com.ybs.parsexml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseCommodity {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//1.创建DocumentBuilderFactory对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//2.创建documentBuilder对象
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			// 3.引入文件
			Document document = builder.parse("File/commodity.xml");
			//遍历MeteData
			NodeList tableName = document.getElementsByTagName("MeteData");
			NamedNodeMap tableAttrs = tableName.item(0).getAttributes();
			for (int i = 0; i < tableAttrs.getLength(); i++) {
				 Node tableAttr = tableAttrs.item(i);
				 String tableNodeName = tableAttr.getNodeName();
				 String tableNodeValue = tableAttr.getNodeValue();
				 System.out.println(tableNodeName+":"+tableNodeValue);
			}
			System.out.println();
			//遍历子节点
			NodeList fList = document.getElementsByTagName("FirstClass");
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
								System.out.println(cAttrName+":"+cAttrValue);
								NodeList gList = citem.getChildNodes();
								for (int m = 0; m < gList.getLength(); m++) {
									if (gList.item(m).getNodeType()==Node.ELEMENT_NODE) {
										Node gNode = gList.item(m);
										String NodeName = gNode.getNodeName();
										String NodeValue = gNode.getFirstChild().getNodeValue();
										System.out.println(NodeName+":"+NodeValue);
									}
								}
							}
						}
					}
				}
			}
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
		
	}

}
