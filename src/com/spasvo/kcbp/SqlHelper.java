    package com.spasvo.kcbp;  
      
    import java.sql.Connection;  
    import java.sql.DriverManager;  
    import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;  
      
    public class SqlHelper{    
    	//���ݿ�����
        private static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //���ݿ��ַ������
        private static String dbURL="jdbc:sqlserver://10.102.0.57:1433;DatabaseName=run";
        //���ݿ��û���
        private static String userName="sa";   
        //���ݿ�����
        private static String userPwd="xz@057~dongcai";  
        //�������ݿ�
        private static Connection  getCoonection(){  
        	try{  
               Class.forName(driverName);  
               Connection conn=DriverManager.getConnection(dbURL,userName,userPwd);  
               return conn;  
              }catch(Exception e){  
            	  e.printStackTrace();  
            	  System.out.print("----------------����ʧ��----------------");  
              }   
              return null;  
          } 
        public static ResultSet  executeQuery(String SQL){    
        	try{       
               Connection conn=getCoonection();  
               //System.out.println("---------------�������ݿ�ɹ�----------------");
               Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
               ResultSet rs = stmt.executeQuery(SQL);    
               return  rs;  
              }catch(Exception e){  
            	  e.printStackTrace();  
            	  System.out.print("----------------��ѯʧ��----------------");  
              }  
              return null;  
        }  
        public static boolean  executeUpdate(String SQL){    
              try{  
            	  Connection conn=getCoonection();  
            	  //System.out.println("---------------�������ݿ�ɹ�----------------");                
            	  Statement stmt = conn.createStatement();  
            	  int result = stmt.executeUpdate(SQL);  
            	  if(result>0)  
            		  return true;
              }catch(Exception e){  
            	  e.printStackTrace();  
            	  System.out.print("----------------����ʧ��----------------");  
              }  
              return false;  
        }  
        public static String[][] getDatebases(String Sql) throws SQLException{
        	ResultSet rs=SqlHelper.executeQuery(Sql);
        	int colnum = rs.getMetaData().getColumnCount();//��ѯ�����Ӧ��ά���������
        	rs.last();
        	int rows = rs.getRow();//��ѯ�����Ӧ��ά���������
        	String[][] str = new String[rows][colnum];
        	rs.beforeFirst();
        	for (int i = 0; rs.next(); i++) {
                for (int j = 0; j < colnum; j++) {
                    str[i][j] = rs.getString(j + 1);
                }
            }
			return str;       	
        }
    }  