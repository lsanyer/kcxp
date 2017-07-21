package com.demo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Map;
import com.spasvo.kcbp.*;

public class Wtywl {
	
	KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
	String exclpath = "f:\\demo.xls";
	
	@Test//����1��Ʊ����ί������ҵ����	
	public void testcase001() throws Exception {
		Printname.printname("Wtywl_testcase001");
		//ί��ǰ��ѯ�����ʽ�
		Map<String, String> paramMap_1 = ReadExc.Readcase(exclpath,"testcase1",1);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap_1);
		//ί������
		Map<String, String> paramMap_2 = ReadExc.Readcase(exclpath,"testcase1",0);
		kcbpBusiness.fundQueryBusiness(paramMap_2);
		//����ί�гɽ����
		double price = Double.parseDouble(KCBPBusiness.getStr(paramMap_2,"price"));
		double qty = Double.parseDouble(KCBPBusiness.getStr(paramMap_2,"qty"));
		double yq_cjje = price * qty;
		//ί�к��ѯ�����ʽ�
		Map<String, String> paramMap_3 = ReadExc.Readcase(exclpath,"testcase1",1);
		kcbpBusiness.fundQueryBusiness(paramMap_3);
		//ί�к��ѯί��״̬
		Map<String, String> paramMap_4 = ReadExc.Readcase(exclpath,"testcase1",3);
		paramMap_4.put("ordersno",KCBPBusiness.getStr(paramMap_2,"ordersno"));
		kcbpBusiness.fundQueryBusiness(paramMap_4);
		//�Ա�ǰ���ʽ����Ԥ�ڳɽ����
		double pre_fundavl = Double.parseDouble(KCBPBusiness.getStr(paramMap_1,"fundavl"));
		double last_fundavl = Double.parseDouble(KCBPBusiness.getStr(paramMap_3,"fundavl"));
		double freez_amount = pre_fundavl - last_fundavl;
		if(!((freez_amount * 0.9995<=yq_cjje||yq_cjje<=freez_amount * 1.0005)||(freez_amount-5<=yq_cjje||yq_cjje<=freez_amount+5))){
			AssertJUnit.fail("��Ʊί������ҵ����ǰ���ʽ��У��ʧ��");
		}
		//У��ί��״̬
		String orderstatus = KCBPBusiness.getStr(paramMap_4,"orderstatus");
		if(!(orderstatus.equals("2")||orderstatus.equals("7")||orderstatus.equals("8"))){
			AssertJUnit.fail("��Ʊί������ҵ����ί��״̬У��ʧ��");
		}			
	}
	
	
	@Test//����2��Ʊ����ί������ҵ����	
	public void testcase002() throws Exception {
		Printname.printname("Wtywl_testcase002");
		//ί��ǰ��ѯ���ùɷ�
		Map<String, String> paramMap_1 = ReadExc.Readcase(exclpath,"testcase1",2);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap_1);
		//ί������
		Map<String, String> paramMap_2 = ReadExc.Readcase(exclpath,"testcase7",0);
		kcbpBusiness.fundQueryBusiness(paramMap_2);
		//ί�к��ѯ���ùɷ�
		Map<String, String> paramMap_3 = ReadExc.Readcase(exclpath,"testcase1",2);
		kcbpBusiness.fundQueryBusiness(paramMap_3);
		//ί�к��ѯί��״̬
		Map<String, String> paramMap_4 = ReadExc.Readcase(exclpath,"testcase1",3);
		paramMap_4.put("ordersno",KCBPBusiness.getStr(paramMap_2,"ordersno"));
		kcbpBusiness.fundQueryBusiness(paramMap_4);
		//�Ա�ǰ��ɷݲ�
		int pre_stkavl = Integer.parseInt(KCBPBusiness.getStr(paramMap_1,"stkavl"));
		int last_stkavl = Integer.parseInt(KCBPBusiness.getStr(paramMap_3,"stkavl"));
		int qty = Integer.parseInt(KCBPBusiness.getStr(paramMap_2,"qty"));
		int freez_amount = pre_stkavl - last_stkavl;
		if(!(qty == freez_amount)){
			AssertJUnit.fail("��Ʊί������ҵ����ǰ��ɷݲ�ʧ��");
		}
		//У��ί��״̬
		String orderstatus = KCBPBusiness.getStr(paramMap_4,"orderstatus");
		if(!(orderstatus.equals("2")||orderstatus.equals("7")||orderstatus.equals("8"))){
			AssertJUnit.fail("��Ʊί������ҵ����ί��״̬ʧ��");
		}			
	}
	
	@Test//����3ծȯ����ί������ҵ����	
	public void testcase003() throws Exception {
		Printname.printname("Wtywl_testcase003");
		//ί��ǰ��ѯ�����ʽ�
		Map<String, String> paramMap_1 = ReadExc.Readcase(exclpath,"testcase1",1);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap_1);
		//ί������
		Map<String, String> paramMap_2 = ReadExc.Readcase(exclpath,"testcase1",4);
		kcbpBusiness.fundQueryBusiness(paramMap_2);
		//����ί�гɽ����
		double price = Double.parseDouble(KCBPBusiness.getStr(paramMap_2,"price"));
		double qty = Double.parseDouble(KCBPBusiness.getStr(paramMap_2,"qty"));
		double yq_cjje = price * qty;
		//ί�к��ѯ�����ʽ�
		Map<String, String> paramMap_3 = ReadExc.Readcase(exclpath,"testcase1",1);
		kcbpBusiness.fundQueryBusiness(paramMap_3);
		//ί�к��ѯί��״̬
		Map<String, String> paramMap_4 = ReadExc.Readcase(exclpath,"testcase1",3);
		paramMap_4.put("ordersno",KCBPBusiness.getStr(paramMap_2,"ordersno"));
		kcbpBusiness.fundQueryBusiness(paramMap_4);
		//�Ա�ǰ���ʽ����Ԥ�ڳɽ����
		double pre_fundavl = Double.parseDouble(KCBPBusiness.getStr(paramMap_1,"fundavl"));
		double last_fundavl = Double.parseDouble(KCBPBusiness.getStr(paramMap_3,"fundavl"));
		double freez_amount = pre_fundavl - last_fundavl;
		if(!((freez_amount * 0.9995<=yq_cjje||yq_cjje<=freez_amount * 1.0005)||(freez_amount-5<=yq_cjje||yq_cjje<=freez_amount+5))){
			AssertJUnit.fail("ծȯί������ҵ����ǰ���ʽ��У��ʧ��");
		}
		//У��ί��״̬
		String orderstatus = KCBPBusiness.getStr(paramMap_4,"orderstatus");
		if(!(orderstatus.equals("2")||orderstatus.equals("7")||orderstatus.equals("8"))){
			AssertJUnit.fail("ծȯί������ҵ����ί��״̬У��ʧ��");
		}			
	}
	
	
	@Test//����4ծȯ����ί������ҵ����	
	public void testcase004() throws Exception {
		Printname.printname("Wtywl_testcase004");
		//ί��ǰ��ѯ���ùɷ�
		Map<String, String> paramMap_1 = ReadExc.Readcase(exclpath,"testcase2",2);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap_1);
		//ί������
		Map<String, String> paramMap_2 = ReadExc.Readcase(exclpath,"testcase3",4);
		kcbpBusiness.fundQueryBusiness(paramMap_2);
		//ί�к��ѯ���ùɷ�
		Map<String, String> paramMap_3 = ReadExc.Readcase(exclpath,"testcase2",2);
		kcbpBusiness.fundQueryBusiness(paramMap_3);
		//ί�к��ѯί��״̬
		Map<String, String> paramMap_4 = ReadExc.Readcase(exclpath,"testcase1",3);
		paramMap_4.put("ordersno",KCBPBusiness.getStr(paramMap_2,"ordersno"));
		kcbpBusiness.fundQueryBusiness(paramMap_4);
		//�Ա�ǰ��ɷݲ�
		int pre_stkavl = Integer.parseInt(KCBPBusiness.getStr(paramMap_1,"stkavl"));
		int last_stkavl = Integer.parseInt(KCBPBusiness.getStr(paramMap_3,"stkavl"));
		int qty = Integer.parseInt(KCBPBusiness.getStr(paramMap_2,"qty"));
		int freez_amount = pre_stkavl - last_stkavl;
		if(!(qty == freez_amount)){
			AssertJUnit.fail("ծȯί������ҵ����ǰ��ɷݲ�У��ʧ��");
		}
		//У��ί��״̬
		String orderstatus = KCBPBusiness.getStr(paramMap_4,"orderstatus");
		if(!(orderstatus.equals("2")||orderstatus.equals("7")||orderstatus.equals("8"))){
			AssertJUnit.fail("ծȯί������ҵ����ί��״̬У��ʧ��");
		}			
	}
	
	
	@Test//����5��������ί������ҵ����	
	public void testcase005() throws Exception {
		Printname.printname("Wtywl_testcase005");
		//ί��ǰ��ѯ�����ʽ�
		Map<String, String> paramMap_1 = ReadExc.Readcase(exclpath,"testcase1",1);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap_1);
		//ί������
		Map<String, String> paramMap_2 = ReadExc.Readcase(exclpath,"testcase1",5);
		kcbpBusiness.fundQueryBusiness(paramMap_2);
		//����ί�гɽ����
		double price = Double.parseDouble(KCBPBusiness.getStr(paramMap_2,"price"));
		double qty = Double.parseDouble(KCBPBusiness.getStr(paramMap_2,"qty"));
		double yq_cjje = price * qty;
		//ί�к��ѯ�����ʽ�
		Map<String, String> paramMap_3 = ReadExc.Readcase(exclpath,"testcase1",1);
		kcbpBusiness.fundQueryBusiness(paramMap_3);
		//ί�к��ѯί��״̬
		Map<String, String> paramMap_4 = ReadExc.Readcase(exclpath,"testcase1",3);
		paramMap_4.put("ordersno",KCBPBusiness.getStr(paramMap_2,"ordersno"));
		kcbpBusiness.fundQueryBusiness(paramMap_4);
		//�Ա�ǰ���ʽ����Ԥ�ڳɽ����
		double pre_fundavl = Double.parseDouble(KCBPBusiness.getStr(paramMap_1,"fundavl"));
		double last_fundavl = Double.parseDouble(KCBPBusiness.getStr(paramMap_3,"fundavl"));
		double freez_amount = pre_fundavl - last_fundavl;
		if(!((freez_amount * 0.9995<=yq_cjje||yq_cjje<=freez_amount * 1.0005)||(freez_amount-5<=yq_cjje||yq_cjje<=freez_amount+5))){
			AssertJUnit.fail("����ί������ҵ����ǰ���ʽ��У��ʧ��");
		}
		//У��ί��״̬
		String orderstatus = KCBPBusiness.getStr(paramMap_4,"orderstatus");
		if(!(orderstatus.equals("2")||orderstatus.equals("7")||orderstatus.equals("8"))){
			AssertJUnit.fail("����ί������ҵ����ί��״̬��У��ʧ��");
		}			
	}
	
	
	@Test//����6��������ί������ҵ����	
	public void testcase006() throws Exception {
		Printname.printname("Wtywl_testcase006");
		//ί��ǰ��ѯ���ùɷ�
		Map<String, String> paramMap_1 = ReadExc.Readcase(exclpath,"testcase3",2);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap_1);
		//ί������
		Map<String, String> paramMap_2 = ReadExc.Readcase(exclpath,"testcase7",5);
		kcbpBusiness.fundQueryBusiness(paramMap_2);
		//ί�к��ѯ���ùɷ�
		Map<String, String> paramMap_3 = ReadExc.Readcase(exclpath,"testcase3",2);
		kcbpBusiness.fundQueryBusiness(paramMap_3);
		//ί�к��ѯί��״̬
		Map<String, String> paramMap_4 = ReadExc.Readcase(exclpath,"testcase1",3);
		paramMap_4.put("ordersno",KCBPBusiness.getStr(paramMap_2,"ordersno"));
		kcbpBusiness.fundQueryBusiness(paramMap_4);
		//�Ա�ǰ��ɷݲ�
		int pre_stkavl = Integer.parseInt(KCBPBusiness.getStr(paramMap_1,"stkavl"));
		int last_stkavl = Integer.parseInt(KCBPBusiness.getStr(paramMap_3,"stkavl"));
		int qty = Integer.parseInt(KCBPBusiness.getStr(paramMap_2,"qty"));
		int freez_amount = pre_stkavl - last_stkavl;
		if(!(qty == freez_amount)){
			AssertJUnit.fail("����ί������ҵ����ǰ��ɷݲ�У��ʧ��");
		}
		//У��ί��״̬
		String orderstatus = KCBPBusiness.getStr(paramMap_4,"orderstatus");
		if(!(orderstatus.equals("2")||orderstatus.equals("7")||orderstatus.equals("8"))){
			AssertJUnit.fail("����ί������ҵ����ί��״̬У��ʧ��");
		}			
	}
	
	
	
}
