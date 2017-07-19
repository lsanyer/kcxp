package com.demo;

import java.util.Map;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.spasvo.kcbp.*;

public class NewDemo {
	KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
	String Excpath = "f:\\demo.xls";

  @Test//用例001资金查询校验数据
  public void testcase001() throws Exception {
	  Printname.printname("NewDemo_testcase001");
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
  
  @Test//用例002股份查询校验数据
  public void testcase002() throws Exception {
	  Printname.printname("NewDemo_testcase002");
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
  
	
	 @Test//用例003股票正常委托买入
	  public void testcase003() throws Exception {
		  	Printname.printname("NewDemo_testcase003");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase1",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("正常委托买入用例执行失败");
			}
	  }

	  @Test//用例004股票零股买入
	  public void testcase004() throws Exception {
		  	Printname.printname("NewDemo_testcase004");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase2",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("零股买入用例执行失败");}
	  }

	  @Test//用例005股票涨停价委托买入
	  public void testcase005() throws Exception {
		  	Printname.printname("NewDemo_testcase005");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase3",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("涨停价委托买入用例执行失败");}
	  }
	  @Test//用例006股票跌停价委托买入
	  public void testcase006() throws Exception {
		  	Printname.printname("NewDemo_testcase006");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase4",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("跌停价委托买入用例执行失败");}
	  }
	  @Test//用例007股票超涨停价委托买入
	  public void testcase007() throws Exception {
		  	Printname.printname("NewDemo_testcase007");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase5",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("超涨停价委托买入用例执行失败");}
	  }
	  @Test//用例008股票低跌停价委托买入
	  public void testcase008() throws Exception {
		  	Printname.printname("NewDemo_testcase008");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase6",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("低跌停价委托买入用例执行失败");}
	  }
	
	
	@Test//用例009股票正常委托卖出
	  public void testcase009() throws Exception {
		  	Printname.printname("NewDemo_testcase009");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase7",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("正常委托卖出用例执行失败");
			}
	  }

	  @Test//用例010股票涨停价委托卖出
	  public void testcase010() throws Exception {
		  	Printname.printname("NewDemo_testcase010");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase8",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("涨停价委托卖出用例执行失败");}
	  }
	  @Test//用例011股票跌停价委托卖出
	  public void testcase011() throws Exception {
		  	Printname.printname("NewDemo_testcase011");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase9",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("跌停价委托卖出用例执行失败");}
	  }
	  @Test//用例012股票超涨停价委托卖出
	  public void testcase012() throws Exception {
		  	Printname.printname("NewDemo_testcase012");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase10",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("超涨停价委托卖出用例执行失败");}
	  }
	  @Test//用例013股票低跌停价委托卖出
	  public void testcase013() throws Exception {
		  	Printname.printname("NewDemo_testcase013");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase11",0);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("低跌停价委托卖出用例执行失败");}
	  }
 
	@Test//用例014股票零股卖出-零股卖零（50-50）
	  public void testcase014() throws Exception {
		  	Printname.printname("NewDemo_testcase014");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase12",0);
			String custid = KCBPBusiness.getStr(paramMap,"custid");
		  	String stkcode = KCBPBusiness.getStr(paramMap,"stkcode");
		  	String Sql = "update run..stkasset set stklastbal = '10000050',stkbal = '10000050',stkavl = '10000050' where custid = \'"+custid+"\' and stkcode = \'"+stkcode+"\'";
		  	SqlHelper.executeUpdate(Sql);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("股票零股卖出用例执行失败");}
	  }
	@Test//用例015股票零股卖出-零股卖零（50-25）
	  public void testcase015() throws Exception {
		  	Printname.printname("NewDemo_testcase015");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase13",0);
		  	String custid = KCBPBusiness.getStr(paramMap,"custid");
		  	String stkcode = KCBPBusiness.getStr(paramMap,"stkcode");
		  	String Sql = "update run..stkasset set stklastbal = '10000050',stkbal = '10000050',stkavl = '10000050' where custid = \'"+custid+"\' and stkcode = \'"+stkcode+"\'";
		  	SqlHelper.executeUpdate(Sql);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("股票零股卖出用例执行失败");}
	  }
	@Test//用例016股票零股卖出-零股卖零（50-25）
	  public void testcase016() throws Exception {
		  	Printname.printname("NewDemo_testcase016");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase14",0);
		  	String custid = KCBPBusiness.getStr(paramMap,"custid");
		  	String stkcode = KCBPBusiness.getStr(paramMap,"stkcode");
		  	String Sql = "update run..stkasset set stklastbal = '10000000',stkbal = '10000000',stkavl = '10000000' where custid = \'"+custid+"\' and stkcode = \'"+stkcode+"\'";
		  	SqlHelper.executeUpdate(Sql);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("股票零股卖出用例执行失败");}
	  }
	
	

	 @Test//用例017国债正常委托买入
	  public void testcase017() throws Exception {
		  	Printname.printname("NewDemo_testcase017");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase1",4);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("国债委托买入用例执行失败");
			}
	  }
	
	 @Test//用例018国债零股委托买入
	  public void testcase018() throws Exception {
		  	Printname.printname("NewDemo_testcase018");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase2",4);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("国债零股买入用例执行失败");
			}
	  }
	
	 @Test//用例019国债正常委托卖出
	  public void testcase019() throws Exception {
		  	Printname.printname("NewDemo_testcase019");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase3",4);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("国债委托卖出用例执行失败");
			}
	  }
	
	 @Test//用例020国债零股卖出-零股卖零（5-5）
	  public void testcase020() throws Exception {
		  	Printname.printname("NewDemo_testcase020");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase4",4);
		  	String custid = KCBPBusiness.getStr(paramMap,"custid");
		  	String stkcode = KCBPBusiness.getStr(paramMap,"stkcode");
		  	String Sql = "update run..stkasset set stklastbal = '10000005',stkbal = '10000005',stkavl = '10000005' where custid = \'"+custid+"\' and stkcode = \'"+stkcode+"\'";
		  	SqlHelper.executeUpdate(Sql);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("国债零股卖出-零股卖零（5-5）用例执行失败");
			}
	  }
	
	 @Test//用例021国债零股卖出-零股卖零（5-4）
	  public void testcase021() throws Exception {
		  	Printname.printname("NewDemo_testcase021");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase5",4);
		  	String custid = KCBPBusiness.getStr(paramMap,"custid");
		  	String stkcode = KCBPBusiness.getStr(paramMap,"stkcode");
		  	String Sql = "update run..stkasset set stklastbal = '10000005',stkbal = '10000005',stkavl = '10000005' where custid = \'"+custid+"\' and stkcode = \'"+stkcode+"\'";
		  	SqlHelper.executeUpdate(Sql);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("国债零股卖出-零股卖零（5-4）用例执行失败");
			}
	  }
	
	 @Test//用例022国债零股卖出-整股卖零
	  public void testcase022() throws Exception {
		  	Printname.printname("NewDemo_testcase022");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase6",4);
		  	String custid = KCBPBusiness.getStr(paramMap,"custid");
		  	String stkcode = KCBPBusiness.getStr(paramMap,"stkcode");
		  	String Sql = "update run..stkasset set stklastbal = '10000010',stkbal = '10000010',stkavl = '10000010' where custid = \'"+custid+"\' and stkcode = \'"+stkcode+"\'";
		  	SqlHelper.executeUpdate(Sql);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("国债零股卖出-整股卖零用例执行失败");
			}
	  }

	 @Test//用例023基金正常委托买入
	  public void testcase023() throws Exception {
		  	Printname.printname("NewDemo_testcase023");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase1",5);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("基金正常委托买入用例执行失败");
			}
	  }

	  @Test//用例024基金零股买入
	  public void testcase024() throws Exception {
		  	Printname.printname("NewDemo_testcase024");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase2",5);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("基金零股买入用例执行失败");}
	  }

	  @Test//用例025基金涨停价委托买入
	  public void testcase025() throws Exception {
		  	Printname.printname("NewDemo_testcase025");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase3",5);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("基金涨停价委托买入用例执行失败");}
	  }
	  @Test//用例026基金跌停价委托买入
	  public void testcase026() throws Exception {
		  	Printname.printname("NewDemo_testcase026");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase4",5);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("基金跌停价委托买入用例执行失败");}
	  }
	  @Test//用例027基金超涨停价委托买入
	  public void testcase027() throws Exception {
		  	Printname.printname("NewDemo_testcase027");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase5",5);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("基金超涨停价委托买入入用例执行失败");}
	  }
	  @Test//用例028基金低跌停价委托买入
	  public void testcase028() throws Exception {
		  	Printname.printname("NewDemo_testcase028");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase6",5);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("基金低跌停价委托买入用例执行失败");}
	  }
	
	
	@Test//用例029基金正常委托卖出
	  public void testcase029() throws Exception {
		  	Printname.printname("NewDemo_testcase029");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase7",5);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("基金正常委托卖出用例执行失败");
			}
	  }

	  @Test//用例030基金涨停价委托卖出
	  public void testcase030() throws Exception {
		  	Printname.printname("NewDemo_testcase030");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase8",5);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("基金涨停价委托卖出用例执行失败");}
	  }
	  @Test//用例031基金跌停价委托卖出
	  public void testcase031() throws Exception {
		  	Printname.printname("NewDemo_testcase031");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase9",5);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("基金跌停价委托卖出用例执行失败");}
	  }
	  @Test//用例032基金超涨停价委托卖出
	  public void testcase032() throws Exception {
		  	Printname.printname("NewDemo_testcase032");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase10",5);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("基金超涨停价委托卖出用例执行失败");}
	  }
	  @Test//用例033基金低跌停价委托卖出
	  public void testcase033() throws Exception {
		  	Printname.printname("NewDemo_testcase033");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase11",5);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("基金低跌停价委托卖出用例执行失败");}
	  }

	@Test//用例034基金零股卖出-零股卖零（50-50）
	  public void testcase034() throws Exception {
		  	Printname.printname("NewDemo_testcase034");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase12",5);
			String custid = KCBPBusiness.getStr(paramMap,"custid");
		  	String stkcode = KCBPBusiness.getStr(paramMap,"stkcode");
		  	String Sql = "update run..stkasset set stklastbal = '10000050',stkbal = '10000050',stkavl = '10000050' where custid = \'"+custid+"\' and stkcode = \'"+stkcode+"\'";
		  	SqlHelper.executeUpdate(Sql);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("用例34基金零股卖出-零股卖零（50-50）用例执行失败");}
	  }
	@Test//用例035基金零股卖出-零股卖零（50-25）
	  public void testcase035() throws Exception {
		  	Printname.printname("NewDemo_testcase035");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase13",5);
		  	String custid = KCBPBusiness.getStr(paramMap,"custid");
		  	String stkcode = KCBPBusiness.getStr(paramMap,"stkcode");
		  	String Sql = "update run..stkasset set stklastbal = '10000050',stkbal = '10000050',stkavl = '10000050' where custid = \'"+custid+"\' and stkcode = \'"+stkcode+"\'";
		  	SqlHelper.executeUpdate(Sql);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("基金零股卖出-零股卖零（50-25）用例执行失败");}
	  }
	@Test//用例036基金零股卖出-零股卖零（50-25）
	  public void testcase036() throws Exception {
		  	Printname.printname("NewDemo_testcase036");
		  	Map<String, String> paramMap = ReadExc.Readcase(Excpath,"testcase14",5);
		  	String custid = KCBPBusiness.getStr(paramMap,"custid");
		  	String stkcode = KCBPBusiness.getStr(paramMap,"stkcode");
		  	String Sql = "update run..stkasset set stklastbal = '10000000',stkbal = '10000000',stkavl = '10000000' where custid = \'"+custid+"\' and stkcode = \'"+stkcode+"\'";
		  	SqlHelper.executeUpdate(Sql);
			kcbpBusiness.fundQueryBusiness(paramMap);
			if(KCBPBusiness.Checkpoint(paramMap)){
				AssertJUnit.fail("基金零股卖出-零股卖零（50-25）用例执行失败");}
	  }
	
  @Test//用例037委托查询校验数据
  public void testcase037() throws Exception {
	  Printname.printname("NewDemo_testcase037");
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
  }
}
