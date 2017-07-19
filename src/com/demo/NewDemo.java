package com.demo;

import java.util.Map;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.spasvo.kcbp.*;

public class NewDemo {
	KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
	String Excpath = "f:\\demo.xls";
	/*
  @Test//����1�ʽ��ѯУ������
  public void testcase1() throws Exception {
	  Printname.printname("NewDemo_testcase1");
	  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase1",1);
		kcbpBusiness.fundQueryBusiness(paramMap);
		String custid = KCBPBusiness.getStr(paramMap,"custid");
		String n_fundavl = KCBPBusiness.getStr(paramMap,"fundavl");
		String Sql = "select fundavl from run..fundasset where custid = \'"+custid+"\'";
		String[][] str = SqlHelper.getDatebases(Sql);
		double yq_fundavl = Double.parseDouble(str[0][0]);
		double fundavl = Double.parseDouble(n_fundavl);
		if(!(yq_fundavl==fundavl)){
			AssertJUnit.fail("�ʽ��ѯУ����������ִ��ʧ��");}
  }
  
  @Test//����2�ɷݲ�ѯУ������
  public void testcase2() throws Exception {
	  Printname.printname("NewDemo_testcase2");
	  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase1",2);
	  	String stkcode = KCBPBusiness.getStr(paramMap,"stkcode");
		kcbpBusiness.fundQueryBusiness(paramMap);
		String custid = KCBPBusiness.getStr(paramMap,"custid");
		String n_stkavl = KCBPBusiness.getStr(paramMap,"stkavl");		
		String Sql = "select stkavl from run..stkasset where custid = \'"+custid+"\' and stkcode = \'"+stkcode+"\'";
		String[][] str = SqlHelper.getDatebases(Sql);
		int yq_stkavl = Integer.parseInt(str[0][0]);
		int stkavl = Integer.parseInt(n_stkavl);
		if(!(yq_stkavl==stkavl)){
			AssertJUnit.fail("�ɷݲ�ѯУ����������ִ��ʧ��");}
  }
  
	
	 @Test//����3��Ʊ����ί������
	  public void testcase3() throws Exception {
		  	Printname.printname("NewDemo_testcase3");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase1",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("����ί����������ִ��ʧ��");
			}
	  }

	  @Test//����4��Ʊ�������
	  public void testcase4() throws Exception {
		  	Printname.printname("NewDemo_testcase4");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase2",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("�����������ִ��ʧ��");}
	  }

	  @Test//����5��Ʊ��ͣ��ί������
	  public void testcase5() throws Exception {
		  	Printname.printname("NewDemo_testcase5");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase3",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("��ͣ��ί����������ִ��ʧ��");}
	  }
	  @Test//����6��Ʊ��ͣ��ί������
	  public void testcase6() throws Exception {
		  	Printname.printname("NewDemo_testcase6");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase4",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("��ͣ��ί����������ִ��ʧ��");}
	  }
	  @Test//����7��Ʊ����ͣ��ί������
	  public void testcase7() throws Exception {
		  	Printname.printname("NewDemo_testcase7");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase5",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("����ͣ��ί����������ִ��ʧ��");}
	  }
	  @Test//����8��Ʊ�͵�ͣ��ί������
	  public void testcase8() throws Exception {
		  	Printname.printname("NewDemo_testcase8");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase6",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("�͵�ͣ��ί����������ִ��ʧ��");}
	  }
	
	
	@Test//����9��Ʊ����ί������
	  public void testcase9() throws Exception {
		  	Printname.printname("NewDemo_testcase9");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase7",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("����ί����������ִ��ʧ��");
			}
	  }

	  @Test//����10��Ʊ��ͣ��ί������
	  public void testcase10() throws Exception {
		  	Printname.printname("NewDemo_testcase10");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase8",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("��ͣ��ί����������ִ��ʧ��");}
	  }
	  @Test//����11��Ʊ��ͣ��ί������
	  public void testcase11() throws Exception {
		  	Printname.printname("NewDemo_testcase11");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase9",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("��ͣ��ί����������ִ��ʧ��");}
	  }
	  @Test//����12��Ʊ����ͣ��ί������
	  public void testcase12() throws Exception {
		  	Printname.printname("NewDemo_testcase12");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase10",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("����ͣ��ί����������ִ��ʧ��");}
	  }
	  @Test//����13��Ʊ�͵�ͣ��ί������
	  public void testcase13() throws Exception {
		  	Printname.printname("NewDemo_testcase13");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase11",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("�͵�ͣ��ί����������ִ��ʧ��");}
	  }
	*/  
	@Test//����14��Ʊ�������-������㣨50-50��
	  public void testcase14() throws Exception {
		  	Printname.printname("NewDemo_testcase14");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase12",0);
			String custid = KCBPBusiness.getStr(paramMap,"custid");
		  	String stkcode = KCBPBusiness.getStr(paramMap,"stkcode");
		  	String Sql = "update run..stkasset set stklastbal = '10000050',stkbal = '10000050',stkavl = '10000050' where custid = \'"+custid+"\' and stkcode = \'"+stkcode+"\'";
		  	SqlHelper.executeUpdate(Sql);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("��Ʊ�����������ִ��ʧ��");}
	  }
	@Test//����15��Ʊ�������-������㣨50-25��
	  public void testcase15() throws Exception {
		  	Printname.printname("NewDemo_testcase15");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase13",0);
		  	String custid = KCBPBusiness.getStr(paramMap,"custid");
		  	String stkcode = KCBPBusiness.getStr(paramMap,"stkcode");
		  	String Sql = "update run..stkasset set stklastbal = '10000050',stkbal = '10000050',stkavl = '10000050' where custid = \'"+custid+"\' and stkcode = \'"+stkcode+"\'";
		  	SqlHelper.executeUpdate(Sql);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("��Ʊ�����������ִ��ʧ��");}
	  }
	@Test//����16��Ʊ�������-������㣨50-25��
	  public void testcase16() throws Exception {
		  	Printname.printname("NewDemo_testcase16");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase14",0);
		  	String custid = KCBPBusiness.getStr(paramMap,"custid");
		  	String stkcode = KCBPBusiness.getStr(paramMap,"stkcode");
		  	String Sql = "update run..stkasset set stklastbal = '10000000',stkbal = '10000000',stkavl = '10000000' where custid = \'"+custid+"\' and stkcode = \'"+stkcode+"\'";
		  	SqlHelper.executeUpdate(Sql);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("��Ʊ�����������ִ��ʧ��");}
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	
  @Test//����3ί�в�ѯУ������
  public void testcase3() throws Exception {
	  Printname.printname("NewDemo_testcase3");
	  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase1",3);
		kcbpBusiness.fundQueryBusiness(paramMap);
		if(!paramMap.containsKey("ordersno")){
			if(!paramMap.get("tc_reslut").toString().contains("0")){
				AssertJUnit.fail("ί�в�ѯ����ִ��ʧ��");
			}
		}else if(paramMap.containsKey("ordersno")){
			String custid = KCBPBusiness.getStr(paramMap,"custid");
			String ordersno = KCBPBusiness.getStr(paramMap,"ordersno");
			String orderid = KCBPBusiness.getStr(paramMap,"orderid");
			String Sql = "select orderid from run..orderrec where custid = \'"+custid+"\' and ordersno = \'"+ordersno+"\'";
			String[][] str = SqlHelper.getDatebases(Sql);
			if(!orderid.equals(str[0][0])){
				AssertJUnit.fail("ί�в�ѯ����ִ��ʧ��");
			}
		}
  }*/
}
