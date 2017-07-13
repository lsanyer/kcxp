package com.caselist;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Map;
import com.spasvo.kcbp.*;


public class Transaction {
	String exclpath = "Q:\\��ͨί��\\ί������ҵ��.xls";
	@Test//����1����ί������ҵ����
	public void testcase1() throws Exception {
		//ί��ǰ��ѯ�����ʽ�
		Map<String, String> paramMap_1 = ReadExc.Readcase(exclpath,"testcase1",0);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap_1);
		//ί������
		Map<String, String> paramMap_2 = ReadExc.Readcase(exclpath,"testcase1",1);
		kcbpBusiness.fundQueryBusiness(paramMap_2);
		//����ί�гɽ����
		double price = Double.parseDouble(KCBPBusiness.getStr(paramMap_2,"price"));
		double qty = Double.parseDouble(KCBPBusiness.getStr(paramMap_2,"qty"));
		double yq_cjje = price * qty;
		//ί�к��ѯ�����ʽ�
		Map<String, String> paramMap_3 = ReadExc.Readcase(exclpath,"testcase1",0);
		kcbpBusiness.fundQueryBusiness(paramMap_3);
		//�Ա�ǰ���ʽ����Ԥ�ڳɽ����
		double pre_fundavl = Double.parseDouble(KCBPBusiness.getStr(paramMap_1,"fundavl"));
		double last_fundavl = Double.parseDouble(KCBPBusiness.getStr(paramMap_3,"fundavl"));
		double freez_amount = pre_fundavl - last_fundavl;
		if(!((freez_amount * 0.9995<=yq_cjje||yq_cjje<=freez_amount * 1.0005)||(freez_amount-5<=yq_cjje||yq_cjje<=freez_amount+5))){
			AssertJUnit.fail("ί������ҵ��������ִ��ʧ��");
		}
	}
	
	@Test//����2����ί������ҵ����
	public void testcase2() throws Exception {
		//ί��ǰ��ѯ���ùɷ�
		Map<String, String> paramMap_1 = ReadExc.Readcase(exclpath,"testcase1",2);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap_1);	
		//ί������
		Map<String, String> paramMap_2 = ReadExc.Readcase(exclpath,"testcase2",1);
		kcbpBusiness.fundQueryBusiness(paramMap_2);
		//ί�к��ѯ���ùɷ�
		Map<String, String> paramMap_3 = ReadExc.Readcase(exclpath,"testcase1",2);
		kcbpBusiness.fundQueryBusiness(paramMap_3);
		//У��ί��ǰ��ɷݲ���ί������
		int pre_stkavl = Integer.parseInt(KCBPBusiness.getStr(paramMap_1,"stkavl"));
		int last_stkavl = Integer.parseInt(KCBPBusiness.getStr(paramMap_3,"stkavl"));
		int qty = Integer.parseInt(KCBPBusiness.getStr(paramMap_2,"qty"));
		if(!((pre_stkavl-last_stkavl)==qty)){
			AssertJUnit.fail("ί������ҵ��������ִ��ʧ��");
		}
	}
}
