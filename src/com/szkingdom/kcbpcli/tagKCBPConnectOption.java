package com.szkingdom.kcbpcli;

public class tagKCBPConnectOption
{
  public String szServerName;
  public int nProtocal;
  public String szAddress;
  public int nPort;
  public String szSendQName;
  public String szReceiveQName;
  public String szReserved;

  public tagKCBPConnectOption()
  {
    this.szServerName = new String();
    this.szAddress = new String();
    this.szSendQName = new String();
    this.szReceiveQName = new String();
    this.szReserved = new String();
  }
}