package com.caselist;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Map;
import com.spasvo.kcbp.*;


public class NewTest {
  @Test//����1����ί������
  public void testcase1() throws Exception {
	  	Map<String, String> paramMap = ReadExc.Readcase("d:\\sanyer1.xls","testcase1",0);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap);
		if(KCBPBusiness.Checkpoint(paramMap)){
			AssertJUnit.fail("����ί����������ִ��ʧ��");
		}
  }

  @Test//����2�������
  public void testcase2() throws Exception {
	  	Map<String, String> paramMap = ReadExc.Readcase("d:\\sanyer1.xls","testcase2",0);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap);
		if(KCBPBusiness.Checkpoint(paramMap)){
			AssertJUnit.fail("�����������ִ��ʧ��");}
  }
  @Test//����3�û��������
  public void testcase3() throws Exception {
	  	Map<String, String> paramMap = ReadExc.Readcase("d:\\sanyer1.xls","testcase3",0);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap);
		if(KCBPBusiness.Checkpoint(paramMap)){
			AssertJUnit.fail("�û������������ִ��ʧ��");}
  }
  @Test//����4��ͣ��ί������
  public void testcase4() throws Exception {
	  	Map<String, String> paramMap = ReadExc.Readcase("d:\\sanyer1.xls","testcase4",0);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap);
		if(KCBPBusiness.Checkpoint(paramMap)){
			AssertJUnit.fail("��ͣ��ί����������ִ��ʧ��");}
  }
  @Test//����5��ͣ��ί������
  public void testcase5() throws Exception {
	  	Map<String, String> paramMap = ReadExc.Readcase("d:\\sanyer1.xls","testcase5",0);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap);
		if(KCBPBusiness.Checkpoint(paramMap)){
			AssertJUnit.fail("��ͣ��ί����������ִ��ʧ��");}
  }
  @Test//����6����ͣ��ί������
  public void testcase6() throws Exception {
	  	Map<String, String> paramMap = ReadExc.Readcase("d:\\sanyer1.xls","testcase6",0);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap);
		if(KCBPBusiness.Checkpoint(paramMap)){
			AssertJUnit.fail("����ͣ��ί����������ִ��ʧ��");}
  }
  @Test//����7�͵�ͣ��ί������
  public void testcase7() throws Exception {
	  	Map<String, String> paramMap = ReadExc.Readcase("d:\\sanyer1.xls","testcase7",0);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap);
		if(KCBPBusiness.Checkpoint(paramMap)){
			AssertJUnit.fail("�͵�ͣ��ί����������ִ��ʧ��");}
  }
  
  
  
  
  @Test//����8�ʽ��ѯУ������
  public void testcase8() throws Exception {
	  	Map<String, String> paramMap = ReadExc.Readcase("d:\\sanyer1.xls","testcase1",1);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
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

}
