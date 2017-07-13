package com.spasvo.kcbp;

public class KCBPMain {
	static{
		System.loadLibrary("KCBPMain");
	}
	
	/**
	 * ��ʼ���ͻ��˾��
	 * @author wangbin
	 * @param serverName KCBP����������
	 * @param protocol Э������
	 * @param port �������˿ں�
	 * @param ip ������IP
	 * @param sendQName ���Ͷ�������
	 * @param receiveQName ���ն�������
	 */
	public native boolean KCBPCLI_Init(String serverName,int protocol,int port,String ip,String sendQName,String receiveQName);
	
	
	
	/**
	 * ����ϵͳ����
	 * @author wangbin
	 * @param index ѡ����
	 * @param value ѡ���ֵ
	 */
	public native boolean KCBPCLI_SetOptions(int index,int value);
	
	/**
	 * ����ͨѶ����
	 * @author wangbin
	 * @param index ѡ����
	 * @param value ѡ���ֵ
	 */
	public native boolean KCBPCLI_SetSystemParam(int index,String value);
	
	
	/**
	 * ����sql
	 * @author wangbin
	 * @return "ok"Ϊ�ɹ�������Ϊ������Ϣ
	 */
	public native String KCBPCLI_SQLConnect(String usename,String passwd);
	
	
	
	/**�����������������ǰ��׼��
	 * @author wangbin
	 */
	public native boolean KCBPCLI_BeginWrite();
	
	
	/**
	 * ����Ҫ�������������
	 * @param key �ؼ���
	 * @param value ֵ
	 * @return
	 */
	public native boolean KCBPCLI_SetValue(String key,String value );
	
	
	/**
	 * ��������
	 * @param funcid
	 * @return "ok"Ϊ�ɹ�,����Ϊ������Ϣ
	 */
	public native String KCBPCLI_SQLExecute(String funcid);
	
	
	/**
	 * �򿪽����
	 * @return
	 */
	public native String KCBPCLI_RsOpen();
	
	
	
	/**
	 * ��ȡ��һ�������
	 * @return
	 */
	public native String KCBPCLI_SQLFetch();
	
	/**
	 * ��ȡ�����������
	 * @param index �е�����
	 * @return
	 */
	public native String KCBPCLI_SQLGetColName(int index);
	
	/**
	 * ��ȡ��������е�ֵ
	 * @param index �е�����
	 * @return
	 */
	public native String KCBPCLI_RsGetCol(int index);
	
	
	/**
	 * ��ȡ���������
	 * @return
	 */
	public native boolean KCBPCLI_SQLMoreResults();
	
	/**
	 * ͨ��������ȡֵ
	 * @param colName
	 * @return
	 */
	public native String KCBPCLI_RsGetColByName(String colName);
	
	
	/**
	 * �Ͽ�����
	 * @return
	 */
	public native boolean KCBPCLI_SQLDisconnect();
	
	/**
	 * �˳�ϵͳ
	 * @return
	 */
	public native boolean KCBPCLI_Exit();
	
	/**
	 * �����ַ���
	 * @param level ���ܵȼ�
	 * @param srcStr Դ�ַ���
	 * @param key
	 * @return ���ؼ��ܺ���ַ���
	 */
	public native String KDEncode(int level,String srcStr,String key);
	
	
	/**
	 * ��ȡ�����������
	 * @return ���ؽ����������
	 */
	public native int KCBPCLI_SQLNumResultCols();
	
	public native int RsGetRowNum();
}
