package com.ybs.parsexml;

import org.w3c.dom.Document;

import com.ybs.dom.DomParse;

public class ParseWaste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����xml�ļ�
		Document document = DomParse.getDocument("File/waste.xml");
		// ����parseTableName��������ȡ�������Բ���
		DomParse.parseTableName(document, "MeteData");
		// ����parseNode�����������ӽڵ���Ϣ
		DomParse.parseNode(document, "FirstClass", null, true);
	}

}