package com.szkingdom.kcbpcli;

public class tagCallCtrl
{
  public int nFlags;
  public String szId;
  public String szMsgId;
  public String szCorrId;
  public int nExpiry;
  public int nPriority;
  public int tTimeStamp;

  public tagCallCtrl()
  {
    this.szId = new String();
    this.szMsgId = new String();
    this.szCorrId = new String();
  }
}