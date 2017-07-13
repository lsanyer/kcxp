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
		return paramMap;
	}
/*		public static void main(String[] args) throws BiffException, IOException{
		Map paramMap =  ReadExc.Readcase("d:\\sanyer.xls","testcase1",0);
		System.out.println(paramMap.get("custid").toString());
	}
	public static void main(String[] args) throws BiffException, IOException{
	File file = new File("d:\\sanyer.xls");  
	InputStream in = new FileInputStream(file);  
	Workbook workbook = Workbook.getWorkbook(in);  
	ReadWrite("d:\\sanyer.xls","testcase1",0);
	//获取第一张Sheet表  
	Sheet sheet = workbook.getSheet(0);  
	//我们既可能通过Sheet的名称来访问它，也可以通过下标来访问它。如果通过下标来访问的话，要注意的一点是下标从0开始，就像数组一样。  
	//获取第一列，第一行的值   
	Cell c00 = sheet.getCell(0, 0);   
	String strc00 = c00.getContents();  
	//获取第一列，第二行的值   
	Cell c10 = sheet.getCell(0, 1);   
	String strc10 = c10.getContents();
	System.out.println(strc00);
	System.out.println(strc10);

/*	String[][] str = new String[100][100];
	int i=0,j=0;
	Cell c = null;
	for(;;){
		for(i = 0;i < 2;i++){
			c = sheet.getCell(i, j); 
			str[j][i] = c.getContents();
			if(c.getContents().equals("END")){
				break;
			}
		}
		if(c.getContents().equals("END")){
			break;
		}
		j++;
	}
	for(int k = 0;k<str.length;k++){
		for(int n = 0;n < 2;n++){
			System.out.println(str[k][n]);
			}
		}

	}
*/	
}
