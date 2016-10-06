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

public class ParseScrap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建DocumentBuilderFactory对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			//创建一个DocumentBuilder
			DocumentBuilder builder = factory.newDocumentBuilder();
			//引入文件
			Document document = builder.parse("File/scrap.xml");
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
			
			//遍历废料
			NodeList WasteList = document.getElementsByTagName("废料");
			Node waste = WasteList.item(0);
			System.out.println(waste.getNodeName());
			NodeList wasteChild = waste.getChildNodes();
			for (int i = 0; i < wasteChild.getLength(); i++) {
				 if (wasteChild.item(i).getNodeType() == Node.ELEMENT_NODE) {
				 String wasteValue = wasteChild.item(i).getFirstChild().getNodeValue();
				 System.out.println("  |--"+wasteValue);
				}
			}
			System.out.println();
			
			//遍历余料
			NodeList ResiduesList = document.getElementsByTagName("余料");
			Node residues = ResiduesList.item(0);
			System.out.println(residues.getNodeName());
			NodeList residuesChild = residues.getChildNodes();
			for (int i = 0; i < residuesChild.getLength(); i++) {
				//attributes
				//获取一个FirstClass
				if (residuesChild.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Node FirstClass = residuesChild.item(i);
					NamedNodeMap residuesChildAttrs = FirstClass.getAttributes();
					//遍历FirstClass属性值ID
				for (int j = 0; j < residuesChildAttrs.getLength(); j++) {
					Node residuesChildAttr = residuesChildAttrs.item(j);
					String residuesChildAttrName = residuesChildAttr.getNodeName();
					String residuesChildAttrValue = residuesChildAttr.getNodeValue();
					System.out.println("  |--"+residuesChildAttrName+":"+residuesChildAttrValue);
					NodeList fNodeList = FirstClass.getChildNodes();
					for (int k = 0; k < fNodeList.getLength(); k++) {
						if (fNodeList.item(k).getNodeType() == Node.ELEMENT_NODE) {
							Node Item = fNodeList.item(k);
							NamedNodeMap ItemAttrs = Item.getAttributes();
							for (int l = 0; l < ItemAttrs.getLength(); l++) {
								Node ItemAttr = ItemAttrs.item(j);
								String ItemAttrName = ItemAttr.getNodeName();
								String ItemAttrValue = ItemAttr.getNodeValue();
								System.out.println("    |--"+ItemAttrName+":"+ItemAttrValue);
								NodeList ItemChild = Item.getChildNodes();
								for (int m = 0; m < ItemChild.getLength(); m++) {
									if (ItemChild.item(m).getNodeType() == Node.ELEMENT_NODE) {
										Node cItem = ItemChild.item(m);
										String cItemName = cItem.getNodeName();
										String cItemValue = cItem.getFirstChild().getNodeValue();
										System.out.println("      |--"+cItemName+":"+cItemValue);
									}
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
		}catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
