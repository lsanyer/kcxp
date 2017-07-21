package com.demo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Map;
import com.spasvo.kcbp.*;

public class Wtywl {
	
	KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
	String exclpath = "f:\\demo.xls";
	@Test//用例1股票正常委托买入业务流	
	public void testcase1() throws Exception {
		Printname.printname("Wtywl_testcase1");
		//委托前查询可用资金
		Map<String, String> paramMap_1 = ReadExc.Readcase(exclpath,"testcase1",1);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap_1);
		//委托买入
		Map<String, String> paramMap_2 = ReadExc.Readcase(exclpath,"testcase1",0);
		kcbpBusiness.fundQueryBusiness(paramMap_2);
		//计算委托成交金额
		double price = Double.parseDouble(KCBPBusiness.getStr(paramMap_2,"price"));
		double qty = Double.parseDouble(KCBPBusiness.getStr(paramMap_2,"qty"));
		double yq_cjje = price * qty;
		//委托后查询可用资金
		Map<String, String> paramMap_3 = ReadExc.Readcase(exclpath,"testcase1",1);
		kcbpBusiness.fundQueryBusiness(paramMap_3);
		//委托后查询委托状态
		Map<String, String> paramMap_4 = ReadExc.Readcase(exclpath,"testcase1",3);
		paramMap_4.put("ordersno",KCBPBusiness.getStr(paramMap_2,"ordersno"));
		kcbpBusiness.fundQueryBusiness(paramMap_4);
		//对比前后资金差与预期成交金额
		double pre_fundavl = Double.parseDouble(KCBPBusiness.getStr(paramMap_1,"fundavl"));
		double last_fundavl = Double.parseDouble(KCBPBusiness.getStr(paramMap_3,"fundavl"));
		double freez_amount = pre_fundavl - last_fundavl;
		if(!((freez_amount * 0.9995<=yq_cjje||yq_cjje<=freez_amount * 1.0005)||(freez_amount-5<=yq_cjje||yq_cjje<=freez_amount+5))){
			AssertJUnit.fail("委托买入业务流用例执行失败");
		}
		//校验委托状态
		String orderstatus = KCBPBusiness.getStr(paramMap_4,"orderstatus");
		if(!(orderstatus.equals("2")||orderstatus.equals("7")||orderstatus.equals("8"))){
			AssertJUnit.fail("委托买入业务流用例执行失败");
		}			
	}
	
	
	@Test//用例2股票正常委托卖出业务流	
	public void testcase2() throws Exception {
		Printname.printname("Wtywl_testcase2");
		//委托前查询可用股份
		Map<String, String> paramMap_1 = ReadExc.Readcase(exclpath,"testcase1",2);
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap_1);
		//委托卖出
		Map<String, String> paramMap_2 = ReadExc.Readcase(exclpath,"testcase7",0);
		kcbpBusiness.fundQueryBusiness(paramMap_2);
		//委托后查询可用股份
		Map<String, String> paramMap_3 = ReadExc.Readcase(exclpath,"testcase1",2);
		kcbpBusiness.fundQueryBusiness(paramMap_3);
		//委托后查询委托状态
		Map<String, String> paramMap_4 = ReadExc.Readcase(exclpath,"testcase1",3);
		paramMap_4.put("ordersno",KCBPBusiness.getStr(paramMap_2,"ordersno"));
		kcbpBusiness.fundQueryBusiness(paramMap_4);
		//对比前后股份差
		int pre_stkavl = Integer.parseInt(KCBPBusiness.getStr(paramMap_1,"stkavl"));
		int last_stkavl = Integer.parseInt(KCBPBusiness.getStr(paramMap_3,"stkavl"));
		int qty = Integer.parseInt(KCBPBusiness.getStr(paramMap_2,"qty"));
		int freez_amount = pre_stkavl - last_stkavl;
		if(!(qty == freez_amount)){
			AssertJUnit.fail("股票委托卖出业务流用例执行失败");
		}
		//校验委托状态
		String orderstatus = KCBPBusiness.getStr(paramMap_4,"orderstatus");
		if(!(orderstatus.equals("2")||orderstatus.equals("7")||orderstatus.equals("8"))){
			AssertJUnit.fail("委托买入业务流用例执行失败");
		}			
	}
	
	
	
	
}
