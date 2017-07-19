package com.demo;

import java.util.Map;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.spasvo.kcbp.*;

public class NewDemo {
	KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
	String Excpath = "f:\\demo.xls";
	/*
  @Test//用例1资金查询校验数据
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
			AssertJUnit.fail("资金查询校验数据用例执行失败");}
  }
  
  @Test//用例2股份查询校验数据
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
			AssertJUnit.fail("股份查询校验数据用例执行失败");}
  }
  
	
	 @Test//用例3股票正常委托买入
	  public void testcase3() throws Exception {
		  	Printname.printname("NewDemo_testcase3");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase1",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("正常委托买入用例执行失败");
			}
	  }

	  @Test//用例4股票零股买入
	  public void testcase4() throws Exception {
		  	Printname.printname("NewDemo_testcase4");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase2",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("零股买入用例执行失败");}
	  }

	  @Test//用例5股票涨停价委托买入
	  public void testcase5() throws Exception {
		  	Printname.printname("NewDemo_testcase5");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase3",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("涨停价委托买入用例执行失败");}
	  }
	  @Test//用例6股票跌停价委托买入
	  public void testcase6() throws Exception {
		  	Printname.printname("NewDemo_testcase6");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase4",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("跌停价委托买入用例执行失败");}
	  }
	  @Test//用例7股票超涨停价委托买入
	  public void testcase7() throws Exception {
		  	Printname.printname("NewDemo_testcase7");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase5",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("超涨停价委托买入用例执行失败");}
	  }
	  @Test//用例8股票低跌停价委托买入
	  public void testcase8() throws Exception {
		  	Printname.printname("NewDemo_testcase8");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase6",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("低跌停价委托买入用例执行失败");}
	  }
	
	
	@Test//用例9股票正常委托卖出
	  public void testcase9() throws Exception {
		  	Printname.printname("NewDemo_testcase9");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase7",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("正常委托卖出用例执行失败");
			}
	  }

	  @Test//用例10股票涨停价委托卖出
	  public void testcase10() throws Exception {
		  	Printname.printname("NewDemo_testcase10");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase8",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("涨停价委托卖出用例执行失败");}
	  }
	  @Test//用例11股票跌停价委托卖出
	  public void testcase11() throws Exception {
		  	Printname.printname("NewDemo_testcase11");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase9",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("跌停价委托卖出用例执行失败");}
	  }
	  @Test//用例12股票超涨停价委托卖出
	  public void testcase12() throws Exception {
		  	Printname.printname("NewDemo_testcase12");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase10",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("超涨停价委托卖出用例执行失败");}
	  }
	  @Test//用例13股票低跌停价委托卖出
	  public void testcase13() throws Exception {
		  	Printname.printname("NewDemo_testcase13");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase11",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("低跌停价委托卖出用例执行失败");}
	  }
	*/  
	@Test//用例14股票零股卖出-零股卖零（50-50）
	  public void testcase14() throws Exception {
		  	Printname.printname("NewDemo_testcase14");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase12",0);
			String custid = KCBPBusiness.getStr(paramMap,"custid");
		  	String stkcode = KCBPBusiness.getStr(paramMap,"stkcode");
		  	String Sql = "update run..stkasset set stklastbal = '10000050',stkbal = '10000050',stkavl = '10000050' where custid = \'"+custid+"\' and stkcode = \'"+stkcode+"\'";
		  	SqlHelper.executeUpdate(Sql);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("股票零股卖出用例执行失败");}
	  }
	@Test//用例15股票零股卖出-零股卖零（50-25）
	  public void testcase15() throws Exception {
		  	Printname.printname("NewDemo_testcase15");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase13",0);
		  	String custid = KCBPBusiness.getStr(paramMap,"custid");
		  	String stkcode = KCBPBusiness.getStr(paramMap,"stkcode");
		  	String Sql = "update run..stkasset set stklastbal = '10000050',stkbal = '10000050',stkavl = '10000050' where custid = \'"+custid+"\' and stkcode = \'"+stkcode+"\'";
		  	SqlHelper.executeUpdate(Sql);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("股票零股卖出用例执行失败");}
	  }
	@Test//用例16股票零股卖出-零股卖零（50-25）
	  public void testcase16() throws Exception {
		  	Printname.printname("NewDemo_testcase16");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase14",0);
		  	String custid = KCBPBusiness.getStr(paramMap,"custid");
		  	String stkcode = KCBPBusiness.getStr(paramMap,"stkcode");
		  	String Sql = "update run..stkasset set stklastbal = '10000000',stkbal = '10000000',stkavl = '10000000' where custid = \'"+custid+"\' and stkcode = \'"+stkcode+"\'";
		  	SqlHelper.executeUpdate(Sql);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("股票零股卖出用例执行失败");}
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	
  @Test//用例3委托查询校验数据
  public void testcase3() throws Exception {
	  Printname.printname("NewDemo_testcase3");
	  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase1",3);
		kcbpBusiness.fundQueryBusiness(paramMap);
		if(!paramMap.containsKey("ordersno")){
			if(!paramMap.get("tc_reslut").toString().contains("0")){
				AssertJUnit.fail("委托查询用例执行失败");
			}
		}else if(paramMap.containsKey("ordersno")){
			String custid = KCBPBusiness.getStr(paramMap,"custid");
			String ordersno = KCBPBusiness.getStr(paramMap,"ordersno");
			String orderid = KCBPBusiness.getStr(paramMap,"orderid");
			String Sql = "select orderid from run..orderrec where custid = \'"+custid+"\' and ordersno = \'"+ordersno+"\'";
			String[][] str = SqlHelper.getDatebases(Sql);
			if(!orderid.equals(str[0][0])){
				AssertJUnit.fail("委托查询用例执行失败");
			}
		}
  }*/
}
