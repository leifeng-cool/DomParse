package com.ybs.parsexml;

import org.w3c.dom.Document;

import com.ybs.dom.DomParse;

public class ParseResidues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����xml�ļ�
		Document document = DomParse.getDocument("File/residues.xml");
		// ����parseTableName��������ȡ�����Բ���
		DomParse.parseTableName(document, "MeteData");
		// ����parseNode�����������ӽڵ���Ϣ
		DomParse.parseNode2(document, "FirstClass");
	}

}
