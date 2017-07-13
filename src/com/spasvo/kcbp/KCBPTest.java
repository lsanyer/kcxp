package com.spasvo.kcbp;

import java.util.HashMap;
import java.util.Map;

public class KCBPTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Map paramMap = getParamMap();
		KCBPBusiness kcbpBusiness = KCBPBusiness.getInstance();
		kcbpBusiness.fundQueryBusiness(paramMap);
//		System.out.println("tc_result:"+paramMap.get("tc_result"));
//		System.out.println(kcbpBusiness.KDEncode(6, "1","410916"));
	}
	public static Map getParamMap(){
    	Map paramMap = new HashMap();
    	paramMap.put("serverName","Cails");
    	paramMap.put("protocol","0");
    	paramMap.put("port","21000");
    	paramMap.put("ip","10.102.0.57");
    	paramMap.put("sendQName","req_jd1");
    	paramMap.put("receiveQName","ans_jd1");
    	paramMap.put("usename","KCXP00");
    	paramMap.put("passwd","888888");
    	
    	paramMap.put("funcid","410411");
    	paramMap.put("custid", "100190");
    	paramMap.put("custorgid","1101");
    	paramMap.put("trdpwd","321321");
    	paramMap.put("netaddr","001F1622FAFA");
    	paramMap.put("orgid","1101");
    	paramMap.put("operway","7");
    	paramMap.put("ext","0");
    	paramMap.put("market","1");
    	paramMap.put("secuid","A408630099");
    	paramMap.put("fundid","110100000190");
    	paramMap.put("stkcode","601288");
    	paramMap.put("bsflag","0B");
    	paramMap.put("price","3.5");
    	paramMap.put("qty","100");
    	paramMap.put("ordergroup","");
    	paramMap.put("bankcode","");
    	paramMap.put("remark","");
    	paramMap.put("tc_allowerror","");
    	paramMap.put("tc_result","");
    	
    	return paramMap;
    }
}
    
  