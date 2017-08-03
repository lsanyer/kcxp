package com.spasvo.kcbp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExc {
	public static Map<String, String> Readcase(String exclpath,String casename,int sheetnum) throws BiffException, IOException, SQLException{
		Map<String, String> paramMap = new HashMap<String, String>();
    	//配置连接信息
		paramMap.put("serverName","Cails");
    	paramMap.put("protocol","0");
    	paramMap.put("port","21000");
    	paramMap.put("ip","10.102.0.57");
    	paramMap.put("sendQName","req_jd1");
    	paramMap.put("receiveQName","ans_jd1");
    	paramMap.put("usename","KCXP00");
    	paramMap.put("passwd","888888");
    	paramMap.put("tc_allowerror","1");
		File file = new File(exclpath);  
		InputStream in = new FileInputStream(file);  
		Workbook workbook = Workbook.getWorkbook(in);
		//获取指定的sheet表
		Sheet sheet = workbook.getSheet(sheetnum);
		int i,j,k;
		
		//确定用例数据在第几列
		for(i=0;;i++){
			if(sheet.getCell(i,0).getContents().equals(casename)){
				break;
			}
		}
		//确定用例数据的行数
		for(j=1;;j++){
			if(sheet.getCell(0,j).getContents().equals("END")){
				break;
			}
		}
		//读取Excel表格中的用例数据
		for(k=1;k<j;k++){
				if(sheet.getCell(0, k).getContents().equals("END")){
					break;
				}
				else{					
					paramMap.put(sheet.getCell(0, k).getContents(),sheet.getCell(i, k).getContents());
				}
			}	
		
		//根据不同的价格要求查询数据库并赋值给price
		if(paramMap.containsKey("stkcode")&&paramMap.containsKey("price")){
			String stkcode = paramMap.get("stkcode").toString();
			String Sql = "select maxrisevalue,maxdownvalue from run..stktrd where stkcode = \'"+stkcode+"\'";
			String[][] str = SqlHelper.getDatebases(Sql);
			double maxrisevalue = Double.parseDouble(str[0][0]);
			double maxdownvalue = Double.parseDouble(str[0][1]);
			//正常价格，取涨停价的平均值
			if(paramMap.get("price").toString().equals("price")){				
				String price = String.format("%.2f",(maxrisevalue + maxdownvalue)/2);
				paramMap.put("price",price);
			}
			//取涨停价
			else if(paramMap.get("price").toString().equals("maxriseprice")){
				String price = 	String.valueOf(maxrisevalue);
				paramMap.put("price",price);
			}
			//取跌停价
			else if(paramMap.get("price").toString().equals("maxdownprice")){
				String price = 	String.valueOf(maxdownvalue);
				paramMap.put("price",price);
			}
			//取超涨停价格
			else if(paramMap.get("price").toString().equals("overriseprice")){
				String price = 	String.valueOf(maxrisevalue+1.00);
				paramMap.put("price",price);
			}
			//取低跌停价格
			else if(paramMap.get("price").toString().equals("overdownprice")){
				String price = 	String.valueOf(maxdownvalue-0.1);
				paramMap.put("price",price);
			}
		}
		String acctype = paramMap.get("acctype").toString();
		if(acctype.length()>0){
			String sql = "select * from customer_info where remark = \'"+acctype+"\'";
			String[] str = GetCustInfo.cust_info(sql);
			paramMap.put("custid",str[1]);
			paramMap.put("orgid",str[5]);
			paramMap.put("custorgid",str[5]);
			if(paramMap.containsKey("fundid")){
				paramMap.put("fundid",str[2]);
			}
			if(paramMap.containsKey("secuid")){
				paramMap.put("secuid",str[3]);
			}
		}
		return paramMap;
	}
/*	public static void main(String[] args) throws BiffException, IOException, SQLException{
		Map<String, String> paramMap = ReadExc.Readcase("f:\\demo.xls","testcase1",0);
		System.out.println(paramMap.toString());
	}
*/
}
