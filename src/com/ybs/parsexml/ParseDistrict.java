package com.ybs.parsexml;

import org.w3c.dom.Document;

import com.ybs.dom.DomParse;

public class ParseDistrict {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����xml�ļ�
		Document document = DomParse.getDocument("File/district.xml");
		// ����parseTableName��������ȡ�����Բ���
		DomParse.parseTableName(document, "MeteData");
		// ����parseNode�����������ӽڵ���Ϣ
		DomParse.parseNode(document, "province", null, true);
	}

}
