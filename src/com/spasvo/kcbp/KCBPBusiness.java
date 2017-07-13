package com.spasvo.kcbp;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;

import com.szkingdom.kcbpcli.KCBPClient;
import com.szkingdom.kcbpcli.KCBPInt;
import com.szkingdom.kcbpcli.tagKCBPConnectOption;
/**
 * 
 * @author Administrator
 *
 */

public class KCBPBusiness {
	private static KCBPBusiness instance = null;
	private static KCBPMain kcbp = null;
	private String serrorMsg = "";
	
	public KCBPBusiness(){
		kcbp = new KCBPMain();
	}
	
	public static KCBPBusiness getInstance(){
		if(instance == null){
			instance = new KCBPBusiness();
		}
		return instance;
	}	
	
	public void  fundQueryBusiness(Map paramMap) throws Exception{
		System.out.println("====传进公共业务类参数====Map.Size:"+paramMap.size());
		if(paramMap.containsKey("showParams")){
			Iterator iter =  paramMap.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry<String, String> entry = (Map.Entry<String, String>)iter.next();
				System.out.println("paramMap.put(\""+entry.getKey()+"\",\""+entry.getValue()+"\");");
			}
		}
		
		String serverName = paramMap.containsKey("serverName")?paramMap.get("serverName").toString():"";
		int protocol = paramMap.containsKey("protocol")?Integer.parseInt(paramMap.get("protocol").toString()):0;		
		int port = paramMap.containsKey("port")? Integer.parseInt(paramMap.get("port").toString()):0;
		String ip = paramMap.containsKey("ip")?paramMap.get("ip").toString():"";
		String sendQName = paramMap.containsKey("sendQName")?paramMap.get("sendQName").toString():"";
		String receiveQName = paramMap.containsKey("receiveQName")?paramMap.get("receiveQName").toString():"";
		System.out.println("连接服务器：kcbp.KCBPCLI_Init");
		
		tagKCBPConnectOption stKCBPConnection = new tagKCBPConnectOption();
	    stKCBPConnection.szServerName = serverName;
	    stKCBPConnection.nProtocal = protocol;
	    stKCBPConnection.szAddress = ip;
	    stKCBPConnection.nPort = port;
	    stKCBPConnection.szSendQName = sendQName;
	    stKCBPConnection.szReceiveQName = receiveQName;
		
		//连接服务器
		kcbp.KCBPCLI_Init(serverName, protocol, port, ip, sendQName, receiveQName);		
		//设置连接参数
		kcbp.KCBPCLI_SetOptions(0,0);		
		//设置超时
		kcbp.KCBPCLI_SetOptions(1,500);	
		//连接sql
		if (paramMap.containsKey("SPvalue")) {			
			kcbp.KCBPCLI_SetSystemParam(7,paramMap.get("SPvalue").toString());
		}
	    
		//l��sql		
		String usename=paramMap.containsKey("usename")?paramMap.get("usename").toString():"";
		String passwd=paramMap.containsKey("passwd")?paramMap.get("passwd").toString():"";
		System.out.println("连接KCBPCLI_SQLConnect");
		serrorMsg=kcbp.KCBPCLI_SQLConnect(usename, passwd);
		if(!("ok".equals(serrorMsg))){
			Exit(paramMap, serrorMsg);			
		}		
		//发请求前的准备
		kcbp.KCBPCLI_BeginWrite();
		System.out.println("发请求前的准备 :KCBPCLI_BeginWrite");
		String funcid = "";
		if(paramMap.containsKey("g_funcid")) {
			funcid = paramMap.get("g_funcid").toString();
		}else if(paramMap.containsKey("funcid")){
			funcid = paramMap.get("funcid").toString();
		}else if(paramMap.containsKey("FUNC_ID")){
			funcid = paramMap.get("FUNC_ID").toString();
		}
		if(funcid.equals("410301")) {
			String des = paramMap.containsKey("trdpwd")?paramMap.get("trdpwd").toString():"";
			String Mus = funcid;
			String trdpwd=kcbp.KDEncode(6,des,Mus);
//			String trdpwd=des;
			System.out.println(".................:KCBPCLI_SetValue");
			kcbp.KCBPCLI_SetValue("trdpwd",trdpwd);//交易密码，EncodeStr为密码函数，根据客户号和交易明码计算出的加密字符串，作为入参送到后台,其中123456为明码	
			if(paramMap.containsKey("fundpwd")) {
				String funddes = paramMap.containsKey("fundpwd")?paramMap.get("fundpwd").toString():"";
				String fundMus = funcid;
				String fundpwd = kcbp.KDEncode(6,funddes,fundMus);
//				String fundpwd = funddes;
				kcbp.KCBPCLI_SetValue("fundpwd",fundpwd);
			}
		}else {
			System.out.println(".########################:KCBPCLI_SetValue");
			String des = paramMap.containsKey("trdpwd")?paramMap.get("trdpwd").toString():"";
			String Mus = paramMap.containsKey("custid")?paramMap.get("custid").toString():"";
			String trdpwd=kcbp.KDEncode(6,des,Mus);
//			String trdpwd=des;
			System.out.println("trdpwd--->"+trdpwd);
			kcbp.KCBPCLI_SetValue("trdpwd",trdpwd);//交易密码，EncodeStr为密码函数，根据客户号和交易明码计算出的加密字符串，作为入参送到后台,其中123456为明码		
			if(paramMap.containsKey("fundpwd")) {
				String funddes = paramMap.containsKey("fundpwd")?paramMap.get("fundpwd").toString():"";
				String fundMus = paramMap.containsKey("fundid")?paramMap.get("fundid").toString():"";
//				String fundpwd = kcbp.KDEncode(6,funddes,fundMus);
				String fundpwd = funddes;
				kcbp.KCBPCLI_SetValue("fundpwd",fundpwd);
			}
		}
		//循环赋值
		Iterator iter1 =  paramMap.entrySet().iterator();
		while(iter1.hasNext()){
			Map.Entry<String, String> entry1 = (Map.Entry<String, String>)iter1.next();
			if(!(entry1.getKey().equals("trdpwd") || entry1.getKey().equals("fundpwd"))){
				String str =entry1.getValue();
				if(entry1.getValue()==null || entry1.getValue().length()==0){
					str = "1";
				}
				System.out.println("key:"+entry1.getKey()+",value:"+entry1.getValue());
				kcbp.KCBPCLI_SetValue(entry1.getKey(),entry1.getValue());
//				kcbp.KCBPCLI_SetValue(entry1.getKey(),str);
			}
		}		
		//发送请求
		System.out.println(".发送请求.:KCBPCLI_SQLExecute");
	
		if(paramMap.containsKey("g_funcid")) {
			serrorMsg=kcbp.KCBPCLI_SQLExecute(paramMap.get("g_funcid").toString());
		}else if(paramMap.containsKey("funcid")) {
			serrorMsg=kcbp.KCBPCLI_SQLExecute(paramMap.get("funcid").toString());
		}else if(paramMap.containsKey("F_FUNCTION")) {
			serrorMsg=kcbp.KCBPCLI_SQLExecute(paramMap.get("F_FUNCTION").toString());
		}else if(paramMap.containsKey("FUNC_ID")) {
			serrorMsg=kcbp.KCBPCLI_SQLExecute(paramMap.get("FUNC_ID").toString());
		}
		
		System.out.println(".发送请求.:serrorMsg："+serrorMsg);
		if(!("ok".equals(serrorMsg))){
			Exit(paramMap, serrorMsg);
		}		
		//打开结果集
		serrorMsg=kcbp.KCBPCLI_RsOpen();
		System.out.println(".打开结果集.:serrorMsg："+serrorMsg);
		if(!("ok".equals(serrorMsg))){
			Exit(paramMap, serrorMsg);
		}		
		//获取第一个结果集
		serrorMsg=kcbp.KCBPCLI_SQLFetch();
		System.out.println(".获取第一个结果集.:serrorMsg："+serrorMsg);
		if(!("ok".equals(serrorMsg))){
			Exit(paramMap, serrorMsg);
		}
		System.out.println(".打开结果集，封装数据.:KCBPCLI_SQLNumResultCols");
		//获取列数
		int colCount=kcbp.KCBPCLI_SQLNumResultCols();
		//获取列的值
		String colName=""; 
		String colValue="";
		String result = "";
		String code = "0";
		for(int i=1;i<=colCount;i++){
			colName = kcbp.KCBPCLI_SQLGetColName(i);
			colValue = kcbp.KCBPCLI_RsGetCol(i);
			System.out.println("第一结果集-----colName:"+colName+"------colValue:"+colValue);
			if("MSG".equals(colName)){
				result += ";"+colValue;
			}
			if("CODE".equals(colName)) {
				result += colValue;
				code = colValue;
			}
			
		}		
		paramMap.put("tc_result", result);
		if("0".equals(code)){
//			//获取其他结果集
			boolean flag = kcbp.KCBPCLI_SQLMoreResults();
			System.out.println("FLAG$$$$$$"+flag);
			
//			System.out.println("rowNUm:"+kcbp.KCBPCLI_SQLNumResultCols());
			char x =0;
			char y =1;
			int count=0;
			while(flag){
				int rowNum = 0;
				while(kcbp.KCBPCLI_SQLFetch().equals("ok")) {
					rowNum++;
					colCount=kcbp.KCBPCLI_SQLNumResultCols();
					if(colCount>0){
						result+=y;
						if(count==0){
							for(int i=1;i<=colCount;i++){
								colName = kcbp.KCBPCLI_SQLGetColName(i).trim();
								String colName1 = colName+"_out";
								colValue = kcbp.KCBPCLI_RsGetCol(i).trim();
								if(colValue.startsWith("_BLOB")){
									colValue = jsonRes(stKCBPConnection, paramMap, colName);
								}
//								String a = kcbp.KCBPCLI_RsGetColByName(colName);
								if(paramMap.containsKey(colName1)) {
									colName = colName1;
								}
								if(i==1){
									result+=colName;
								}else{
									result+=x+colName;
								}
							}
							result+=y;
						}
						count++;
					}
					
					for(int i=1;i<=colCount;i++){
						colName=kcbp.KCBPCLI_SQLGetColName(i).trim();
						String colName1=colName+"_out";
						
						colValue = kcbp.KCBPCLI_RsGetCol(i).trim();
						if(colValue.startsWith("_BLOB")){
							colValue = jsonRes(stKCBPConnection, paramMap, colName);
						}
//						String a = kcbp.KCBPCLI_RsGetColByName(colName);
//						String b = kcbp.KCBP_RsGetColByName(colName);
						
						
						if(paramMap.containsKey(colName1)) {
							colName = colName1;
							System.out.println("#####################################");
						}
						if(i==1){
							result+=colValue;
						}else{
							result+=x+colValue;
						}
						if(!"".equals(paramMap.get(colName))){
							colValue = ",".concat(colValue);
						}
						colValue=paramMap.get(colName)+colValue;
						paramMap.put(colName, colValue);
						System.out.println("第二结果集-----colName:"+colName+"--------colValue:"+colValue);				
					}
				}
				if(rowNum==0){
					result+=y;
					colCount=kcbp.KCBPCLI_SQLNumResultCols();
					System.out.println("colCount:"+colCount);
					for(int i=1;i<=colCount;i++){
						colName=kcbp.KCBPCLI_SQLGetColName(i).trim();
						String colName1=colName+"_out";
						colValue = kcbp.KCBPCLI_RsGetCol(i).trim();
						if(colValue.startsWith("_BLOB")){
							colValue = jsonRes(stKCBPConnection, paramMap, colName);
						}
						if(paramMap.containsKey(colName1)) {
							colName = colName1;
						}
						if(i==1){
							result+=colName;
						}else{
							result+=x+colName;
						}
					}
					result+=y;
					for(int i=1;i<=colCount;i++){
						if(i==1){
							result+=" ";
						}else{
							result+=x+" ";
						}
					}
				}
				result=result.replaceAll("\\*", "");
				flag = kcbp.KCBPCLI_SQLMoreResults();
				System.out.println("FLAG$$$$$$"+flag);
			}
//			paramMap.put("tc_result", "0;业务运行正常");
			paramMap.put("resultstate", 0);
//			System.out.println("result:"+result);
		}else{
			paramMap.put("resultstate", 1);

		}
		System.out.println("KCBPCLI_Exit开始");
		//�Ͽ�l��
		if(!(kcbp.KCBPCLI_SQLDisconnect())){
			kcbp.KCBPCLI_Exit();
		}
		kcbp.KCBPCLI_Exit();
		System.out.println("KCBPCLI_Exit结束");
		System.out.println(paramMap.toString());
	}
	
	public void Exit(Map map,String msg)throws Exception{
		kcbp.KCBPCLI_Exit();
		map.put("tc_result", msg);
		map.put("resultstate", 1);
		throw new Exception();
	}
	
	public String KDEncode(int level,String srcStr,String key){
		return kcbp.KDEncode(level, srcStr, key);
	}
	
	public void test(){
		kcbp.KCBPCLI_RsOpen();
	}	
	public String jsonRes(tagKCBPConnectOption stKCBPConnection,Map map,String col){
		int ret = -1;
	    int handle = -1;
	    KCBPClient pKCBPCli = new KCBPClient();
	    KCBPInt Handle = new KCBPInt();
	    if ((ret = pKCBPCli.KCBPCLI_Init(Handle)) == 1)
	    {
	    	System.out.println("init失败");
	    }
	    handle = Handle.x;
	    pKCBPCli.KCBPCLI_SetOption(handle, 3,new Integer(0));
	    pKCBPCli.KCBPCLI_SetOption(handle, 4, new Integer(0));
	    if (pKCBPCli.KCBPCLI_SetOption(handle,7, stKCBPConnection) != 0) {
	    	System.out.println("set connect option error!");
	    }
	    if (pKCBPCli.KCBPCLI_SetOption(handle, 14, new Integer(0)) != 0) {
	    	System.out.println("set connect option error!");
	    }
	    if (pKCBPCli.KCBPCLI_SetOption(handle,1, Integer.valueOf(20)) != 0) {
	    	System.out.println("set connect option error!");
	    }
	    ret = pKCBPCli.KCBPCLI_SQLConnect(handle, stKCBPConnection.szServerName, map.get("usename").toString(), map.get("passwd").toString());

	    if (ret != 0) {
	    	pKCBPCli.KCBPCLI_Exit(handle);
	    }
	    
	    pKCBPCli.KCBPCLI_BeginWrite(handle);

	    //循环赋值
	    Iterator iter1 =  map.entrySet().iterator();
		while(iter1.hasNext()){
			Map.Entry<String, String> entry1 = (Map.Entry<String, String>)iter1.next();
			if(!(entry1.getKey().equals("trdpwd") || entry1.getKey().equals("fundpwd"))){
				String str =entry1.getValue();
				pKCBPCli.KCBPCLI_SetValue(handle, entry1.getKey(), str);
			}
		}		
	
		if(map.containsKey("g_funcid")) {
			ret = pKCBPCli.KCBPCLI_CallProgramAndCommit(handle, map.get("g_funcid").toString());
		}else if(map.containsKey("funcid")) {
			ret = pKCBPCli.KCBPCLI_CallProgramAndCommit(handle, map.get("funcid").toString());
		}else if(map.containsKey("F_FUNCTION")) {
			ret = pKCBPCli.KCBPCLI_CallProgramAndCommit(handle, map.get("F_FUNCTION").toString());
		}else if(map.containsKey("FUNC_ID")) {
			ret = pKCBPCli.KCBPCLI_CallProgramAndCommit(handle, map.get("FUNC_ID").toString());
		}

	    if (ret != 0) {
	    	System.out.println("KCBPCLI_CallProgramAndCommit error, error code : " + ret);
	    	System.out.println("err msg: " + pKCBPCli.KCBPCLI_GetErrorMsg(handle) + ",ip=" + "10.187.33.204");
	    	if ((ret != 2054) && (ret != 2055));
	    }

	    pKCBPCli.KCBPCLI_RsOpen(handle);

	    ret = pKCBPCli.KCBPCLI_SQLMoreResults(handle);
	    if (ret != 0) {
	    	System.out.println("KCBPCLI_SQLMoreResults error : " + ret);
	    	System.out.println("err msg: "+pKCBPCli.KCBPCLI_GetErrorMsg(handle));
	    }
	    String[] colNames = pKCBPCli.KCBPCLI_RsGetColNames(handle, 500).split(",");
//	    System.out.println(colNames.length);
//	    for (int i = 0; i < colNames.length; i++) {
//	    	System.out.println(colNames[i].trim());
//	    }

	    String jsonRes = "";
	    while (pKCBPCli.KCBPCLI_SQLFetch(handle) == 0)
	    {
	    	byte[] data = pKCBPCli.KCBPCLI_RsGetValByName(handle, col, Handle);
	    	try {
	    		jsonRes = new String(data, "GBK");
	    	}
	    	catch (UnsupportedEncodingException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
	    pKCBPCli.KCBPCLI_SQLCloseCursor(handle);
	    pKCBPCli.KCBPCLI_DisConnectForce(handle);
	    pKCBPCli.KCBPCLI_Exit(handle);
		return jsonRes;
	}
	public static String getStr(Map paramMap,String str){
		String[] n_str = paramMap.get(str).toString().split(",");
		int i;
		for(i = 0;i<n_str.length;i++){
			if(!n_str[i].equals("null")){
				break;
			}
		}
		return n_str[i];
	}
	public static boolean Checkpoint(Map paramMap){
		boolean checkpoint = !(paramMap.get("tc_result").toString().contains(paramMap.get("excvalue").toString()));
		return checkpoint;
	}
}