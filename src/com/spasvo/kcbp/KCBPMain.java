package com.spasvo.kcbp;

public class KCBPMain {
	static{
		System.loadLibrary("KCBPMain");
	}
	
	/**
	 * 初始化客户端句柄
	 * @author wangbin
	 * @param serverName KCBP服务器名称
	 * @param protocol 协议类型
	 * @param port 服务器端口号
	 * @param ip 服务器IP
	 * @param sendQName 发送队列名称
	 * @param receiveQName 接收队列名称
	 */
	public native boolean KCBPCLI_Init(String serverName,int protocol,int port,String ip,String sendQName,String receiveQName);
	
	
	
	/**
	 * 设置系统参数
	 * @author wangbin
	 * @param index 选项编号
	 * @param value 选项的值
	 */
	public native boolean KCBPCLI_SetOptions(int index,int value);
	
	/**
	 * 设置通讯参数
	 * @author wangbin
	 * @param index 选项编号
	 * @param value 选项的值
	 */
	public native boolean KCBPCLI_SetSystemParam(int index,String value);
	
	
	/**
	 * 连接sql
	 * @author wangbin
	 * @return "ok"为成功，其他为错误信息
	 */
	public native String KCBPCLI_SQLConnect(String usename,String passwd);
	
	
	
	/**清除缓存区，发请求前的准备
	 * @author wangbin
	 */
	public native boolean KCBPCLI_BeginWrite();
	
	
	/**
	 * 设置要发送请求的内容
	 * @param key 关键字
	 * @param value 值
	 * @return
	 */
	public native boolean KCBPCLI_SetValue(String key,String value );
	
	
	/**
	 * 发送请求
	 * @param funcid
	 * @return "ok"为成功,其他为错误信息
	 */
	public native String KCBPCLI_SQLExecute(String funcid);
	
	
	/**
	 * 打开结果集
	 * @return
	 */
	public native String KCBPCLI_RsOpen();
	
	
	
	/**
	 * 获取第一个结果集
	 * @return
	 */
	public native String KCBPCLI_SQLFetch();
	
	/**
	 * 获取结果集的列名
	 * @param index 列的索引
	 * @return
	 */
	public native String KCBPCLI_SQLGetColName(int index);
	
	/**
	 * 获取结果集的列的值
	 * @param index 列的索引
	 * @return
	 */
	public native String KCBPCLI_RsGetCol(int index);
	
	
	/**
	 * 获取其他结果集
	 * @return
	 */
	public native boolean KCBPCLI_SQLMoreResults();
	
	/**
	 * 通过列名获取值
	 * @param colName
	 * @return
	 */
	public native String KCBPCLI_RsGetColByName(String colName);
	
	
	/**
	 * 断开连接
	 * @return
	 */
	public native boolean KCBPCLI_SQLDisconnect();
	
	/**
	 * 退出系统
	 * @return
	 */
	public native boolean KCBPCLI_Exit();
	
	/**
	 * 加密字符串
	 * @param level 加密等级
	 * @param srcStr 源字符串
	 * @param key
	 * @return 返回加密后的字符串
	 */
	public native String KDEncode(int level,String srcStr,String key);
	
	
	/**
	 * 获取结果集的列数
	 * @return 返回结果集的列数
	 */
	public native int KCBPCLI_SQLNumResultCols();
	
	public native int RsGetRowNum();
}
