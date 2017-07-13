package com.szkingdom.kcbpcli;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;

public class KCBPClient
{
  static
  {
    String os = "windows";
    os = System.getProperty("os.name");
    os = os.trim();
    if ((os.length() >= 7) && 
      (os.substring(0, 7).equalsIgnoreCase("windows")))
      os = "windows";
    try {
      if (os.equalsIgnoreCase("windows"))
    	  System.loadLibrary("libKCBPCliJNI");
//        loadDll();
    	  
      else
        loadSo();
    } catch (Exception ex) {
      System.out.println("load libKCBPCliJNI failed :" + ex.getMessage());
    }
  }

  public native int KCBPCLI_Init(KCBPInt paramKCBPInt);

  public native int KCBPCLI_Exit(int paramInt);

  public native int KCBPCLI_GetVersion(int paramInt);

  public native int KCBPCLI_SetConnectOption(int paramInt, tagKCBPConnectOption paramtagKCBPConnectOption);

  public native int KCBPCLI_GetConnectOption(int paramInt, tagKCBPConnectOption paramtagKCBPConnectOption);

  public native int KCBPCLI_ConnectServer(int paramInt, String paramString1, String paramString2, String paramString3);

  public native int KCBPCLI_DisConnect(int paramInt);

  public native int KCBPCLI_DisConnectForce(int paramInt);

  public native int KCBPCLI_BeginWrite(int paramInt);

  public native int KCBPCLI_Certification(String paramString, int paramInt);

  public native int KCBPCLI_CallProgramAndCommit(int paramInt, String paramString);

  public native int KCBPCLI_CallProgram(int paramInt, String paramString);

  public native int KCBPCLI_Commit(int paramInt);

  public native int KCBPCLI_RollBack(int paramInt);

  public native int KCBPCLI_ACallProgramAndCommit(int paramInt, String paramString, tagCallCtrl paramtagCallCtrl);

  public native int KCBPCLI_ACallProgram(int paramInt, String paramString, tagCallCtrl paramtagCallCtrl);

  public native int KCBPCLI_GetReply(int paramInt, tagCallCtrl paramtagCallCtrl);

  public native int KCBPCLI_Cancel(int paramInt, tagCallCtrl paramtagCallCtrl);

  public native String KCBPCLI_GetValue(int paramInt1, String paramString, int paramInt2);

  public native int KCBPCLI_SetValue(int paramInt, String paramString1, String paramString2);

  public native int KCBPCLI_RsCreate(int paramInt1, String paramString1, int paramInt2, String paramString2);

  public native int KCBPCLI_RsNewTable(int paramInt1, String paramString1, int paramInt2, String paramString2);

  public native int KCBPCLI_RsAddRow(int paramInt);

  public native int KCBPCLI_RsSaveRow(int paramInt);

  public native int KCBPCLI_RsSetCol(int paramInt1, int paramInt2, String paramString);

  public native int KCBPCLI_RsSetColByName(int paramInt, String paramString1, String paramString2);

  public native int KCBPCLI_RsOpen(int paramInt);

  public native int KCBPCLI_RsMore(int paramInt);

  public native int KCBPCLI_RsClose(int paramInt);

  public native String KCBPCLI_RsGetCursorName(int paramInt1, int paramInt2);

  public native String KCBPCLI_RsGetColNames(int paramInt1, int paramInt2);

  public native String KCBPCLI_RsGetColName(int paramInt1, int paramInt2, int paramInt3);

  public native int KCBPCLI_RsFetchRow(int paramInt);

  public native String KCBPCLI_RsGetCol(int paramInt1, int paramInt2);

  public native String KCBPCLI_RsGetColByName(int paramInt, String paramString);

  public native int KCBPCLI_RsGetRowNum(int paramInt);

  public native int KCBPCLI_RsGetColNum(int paramInt, KCBPInt paramKCBPInt);

  public native int KCBPCLI_RsGetTableRowNum(int paramInt1, int paramInt2);

  public native int KCBPCLI_RsGetTableColNum(int paramInt1, int paramInt2);

  public native int KCBPCLI_GetErrorCode(int paramInt);

  public native String KCBPCLI_GetErrorMsg(int paramInt);

  public native int KCBPCLI_GetCommLen(int paramInt);

  public native int KCBPCLI_SetCliTimeOut(int paramInt1, int paramInt2);

  public native int KCBPCLI_SetIntOption(int paramInt1, int paramInt2, int paramInt3);

  public native int KCBPCLI_GetIntOption(int paramInt1, int paramInt2);

  public native int KCBPCLI_SetOption(int paramInt1, int paramInt2, Object paramObject);

  public native Object KCBPCLI_GetOption(int paramInt1, int paramInt2);

  public native int KCBPCLI_SQLConnect(int paramInt, String paramString1, String paramString2, String paramString3);

  public native int KCBPCLI_SQLDisconnect(int paramInt);

  public native int KCBPCLI_SQLExecute(int paramInt, String paramString);

  public native int KCBPCLI_SQLNumResultCols(int paramInt);

  public native String KCBPCLI_SQLGetCursorName(int paramInt1, int paramInt2);

  public native String KCBPCLI_SQLGetColNames(int paramInt1, int paramInt2);

  public native String KCBPCLI_SQLGetColName(int paramInt1, int paramInt2, int paramInt3);

  public native int KCBPCLI_SQLFetch(int paramInt);

  public native int KCBPCLI_SQLMoreResults(int paramInt);

  public native int KCBPCLI_SQLCloseCursor(int paramInt);

  public native int KCBPCLI_SQLEndTran(int paramInt1, int paramInt2);

  public native int KCBPCLI_Subscribe(int paramInt, tagCallCtrl paramtagCallCtrl, String paramString1, String paramString2);

  public native int KCBPCLI_Unsubscribe(int paramInt, tagCallCtrl paramtagCallCtrl);

  public native int KCBPCLI_ReceivePublication(int paramInt, tagCallCtrl paramtagCallCtrl, byte[] paramArrayOfByte);

  public native int KCBPCLI_RegisterPublisher(int paramInt, tagCallCtrl paramtagCallCtrl, String paramString);

  public native int KCBPCLI_DeregisterPublisher(int paramInt, tagCallCtrl paramtagCallCtrl);

  public native int KCBPCLI_Publish(int paramInt, tagCallCtrl paramtagCallCtrl, String paramString1, String paramString2);

  public native int KCBPCLI_Notify(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3);

  public native int KCBPCLI_Broadcast(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3);

  public native int KCBPCLI_CheckUnsoliciety(int paramInt);

  public native int KCBPCLI_SetUnsoliciety(int paramInt);

  public native byte[] KCBPCLI_GetVal(int paramInt, String paramString, KCBPInt paramKCBPInt);

  public native int KCBPCLI_SetVal(int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2);

  public native byte[] KCBPCLI_RsGetVal(int paramInt1, int paramInt2, KCBPInt paramKCBPInt);

  public native byte[] KCBPCLI_RsGetValByName(int paramInt, String paramString, KCBPInt paramKCBPInt);

  public native int KCBPCLI_RsSetVal(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3);

  public native int KCBPCLI_RsSetValByName(int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2);

  public native int KCBPCLI_SetSystemParam(int paramInt1, int paramInt2, String paramString);

  public native int KCBPCLI_GetSystemParam(int paramInt1, int paramInt2, StringBuffer paramStringBuffer);

  private static void loadJar(String name, String ext)
    throws IOException, SecurityException, UnsatisfiedLinkError
  {
    String sep = "/";
    String path = sep + name + ext;

    String tmpPath = KCBPClient.class.getClassLoader().getResource("")
      .getPath();

    File tmp = new File(tmpPath);
    if (!tmp.exists()) {
      tmp.mkdir();
    }
    File jni = new File(tmpPath + sep + name + ext);

    if (!jni.exists()) {
      InputStream in = KCBPClient.class.getResourceAsStream(path);
      FileOutputStream out = new FileOutputStream(jni);
      byte[] buf = new byte[1024];
      int i;
      while ((i = in.read(buf)) != -1)
      {
//        int i;
        out.write(buf, 0, i);
      }
      in.close();
      out.close();
      jni.deleteOnExit();
    }
    System.load(jni.toString());
  }

  private static void loadDll() throws SecurityException, UnsatisfiedLinkError, IOException
  {
     //loadJar("libidea", ".dll");

   // loadJar("libidea1", ".dll");
   // loadJar("libzlib1", ".dll");
  //  loadJar("libzlib", ".dll");
   // loadJar("libeay32", ".dll");
//    loadJar("SSLeay32", ".dll");
//    loadJar("libdes", ".dll");
//    loadJar("libzip", ".dll");
//    loadJar("kcbpcrypt", ".dll");
//    loadJar("kcxpapi", ".dll");
//    loadJar("KCBPCli", ".dll");
   // loadJar("libKCBPCliJNI", ".dll");
	  
  }

  private static void loadSo() throws SecurityException, UnsatisfiedLinkError, IOException
  {
    loadJar("libidea", ".so");
    loadJar("libidea1", ".so");
    loadJar("libzlib1", ".so");
    loadJar("libzlib", ".so");
    loadJar("libdes", ".so");
    loadJar("libkcbpcrypt", ".so");
    loadJar("libkcxpmq", ".so");
    loadJar("libkcbpcli", ".so");
    loadJar("libKCBPCliJNI", ".so");
  }
}