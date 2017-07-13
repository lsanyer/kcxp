package com.caselist;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Map;
import com.spasvo.kcbp.*;


public class NewTest {
  @Test//用例1正常委托买入
  public void testcase1() throws Exception {
	  	Map<String, String> paramMap = ReadExc.Readcase("d:\\sanyer1.xls","testcase1",0);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap);
		if(KCBPBusiness.Checkpoint(paramMap)){
			AssertJUnit.fail("正常委托买入用例执行失败");
		}
  }

  @Test//用例2零股买入
  public void testcase2() throws Exception {
	  	Map<String, String> paramMap = ReadExc.Readcase("d:\\sanyer1.xls","testcase2",0);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap);
		if(KCBPBusiness.Checkpoint(paramMap)){
			AssertJUnit.fail("零股买入用例执行失败");}
  }
  @Test//用例3用户密码错误
  public void testcase3() throws Exception {
	  	Map<String, String> paramMap = ReadExc.Readcase("d:\\sanyer1.xls","testcase3",0);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap);
		if(KCBPBusiness.Checkpoint(paramMap)){
			AssertJUnit.fail("用户密码错误用例执行失败");}
  }
  @Test//用例4涨停价委托买入
  public void testcase4() throws Exception {
	  	Map<String, String> paramMap = ReadExc.Readcase("d:\\sanyer1.xls","testcase4",0);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap);
		if(KCBPBusiness.Checkpoint(paramMap)){
			AssertJUnit.fail("涨停价委托买入用例执行失败");}
  }
  @Test//用例5跌停价委托买入
  public void testcase5() throws Exception {
	  	Map<String, String> paramMap = ReadExc.Readcase("d:\\sanyer1.xls","testcase5",0);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap);
		if(KCBPBusiness.Checkpoint(paramMap)){
			AssertJUnit.fail("跌停价委托买入用例执行失败");}
  }
  @Test//用例6超涨停价委托买入
  public void testcase6() throws Exception {
	  	Map<String, String> paramMap = ReadExc.Readcase("d:\\sanyer1.xls","testcase6",0);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap);
		if(KCBPBusiness.Checkpoint(paramMap)){
			AssertJUnit.fail("超涨停价委托买入用例执行失败");}
  }
  @Test//用例7低跌停价委托买入
  public void testcase7() throws Exception {
	  	Map<String, String> paramMap = ReadExc.Readcase("d:\\sanyer1.xls","testcase7",0);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap);
		if(KCBPBusiness.Checkpoint(paramMap)){
			AssertJUnit.fail("低跌停价委托买入用例执行失败");}
  }
  
  
  
  
  @Test//用例8资金查询校验数据
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
			AssertJUnit.fail("资金查询校验数据用例执行失败");}
  }

}
