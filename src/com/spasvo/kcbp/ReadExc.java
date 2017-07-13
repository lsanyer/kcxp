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
    	//����������Ϣ
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
		//��ȡָ����sheet��
		Sheet sheet = workbook.getSheet(sheetnum);
		int i,j,k;
		
		//ȷ�����������ڵڼ���
		for(i=0;;i++){
			if(sheet.getCell(i,0).getContents().equals(casename)){
				break;
			}
		}
		//ȷ���������ݵ�����
		for(j=1;;j++){
			if(sheet.getCell(0,j).getContents().equals("END")){
				break;
			}
		}
		//��ȡExcel����е���������
		for(k=1;k<j;k++){
				if(sheet.getCell(0, k).getContents().equals("END")){
					break;
				}
				else{					
					paramMap.put(sheet.getCell(0, k).getContents(),sheet.getCell(i, k).getContents());
				}
			}	
		
		//���ݲ�ͬ�ļ۸�Ҫ���ѯ���ݿⲢ��ֵ��price
		if(paramMap.containsKey("stkcode")&&paramMap.containsKey("price")){
			String stkcode = paramMap.get("stkcode").toString();
			String Sql = "select maxrisevalue,maxdownvalue from run..stktrd where stkcode = \'"+stkcode+"\'";
			String[][] str = SqlHelper.getDatebases(Sql);
			double maxrisevalue = Double.parseDouble(str[0][0]);
			double maxdownvalue = Double.parseDouble(str[0][1]);
			//�����۸�ȡ��ͣ�۵�ƽ��ֵ
			if(paramMap.get("price").toString().equals("price")){				
				String price = String.format("%.2f",(maxrisevalue + maxdownvalue)/2);
				paramMap.put("price",price);
			}
			//ȡ��ͣ��
			else if(paramMap.get("price").toString().equals("maxriseprice")){
				String price = 	String.valueOf(maxrisevalue);
				paramMap.put("price",price);
			}
			//ȡ��ͣ��
			else if(paramMap.get("price").toString().equals("maxdownprice")){
				String price = 	String.valueOf(maxdownvalue);
				paramMap.put("price",price);
			}
			//ȡ����ͣ�۸�
			else if(paramMap.get("price").toString().equals("overriseprice")){
				String price = 	String.valueOf(maxrisevalue+1.00);
				paramMap.put("price",price);
			}
			//ȡ�͵�ͣ�۸�
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
	//��ȡ��һ��Sheet��  
	Sheet sheet = workbook.getSheet(0);  
	//���Ǽȿ���ͨ��Sheet����������������Ҳ����ͨ���±��������������ͨ���±������ʵĻ���Ҫע���һ�����±��0��ʼ����������һ����  
	//��ȡ��һ�У���һ�е�ֵ   
	Cell c00 = sheet.getCell(0, 0);   
	String strc00 = c00.getContents();  
	//��ȡ��һ�У��ڶ��е�ֵ   
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
