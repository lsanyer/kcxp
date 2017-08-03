    package com.spasvo.kcbp;  
      
    import java.sql.Connection;  
    import java.sql.DriverManager;  
    import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;  
      
    public class SqlHelper{    
    	//数据库类型
        private static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //数据库地址、库名
        private static String dbURL="jdbc:sqlserver://10.102.0.57:1433;DatabaseName=run";
        //数据库用户名
        private static String userName="sa";   
        //数据库密码
        private static String userPwd="xz@057~dongcai";  
        //连接数据库
        private static Connection  getCoonection(){  
        	try{  
               Class.forName(driverName);  
               Connection conn=DriverManager.getConnection(dbURL,userName,userPwd);  
               return conn;  
              }catch(Exception e){  
            	  e.printStackTrace();  
            	  System.out.print("----------------连接失败----------------");  
              }   
              return null;  
          } 
        public static ResultSet  executeQuery(String SQL){    
        	try{       
               Connection conn=getCoonection();  
               //System.out.println("---------------连接数据库成功----------------");
               Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
               ResultSet rs = stmt.executeQuery(SQL);    
               return  rs;  
              }catch(Exception e){  
            	  e.printStackTrace();  
            	  System.out.print("----------------查询失败----------------");  
              }  
              return null;  
        }  
        public static boolean  executeUpdate(String SQL){    
              try{  
            	  Connection conn=getCoonection();  
            	  //System.out.println("---------------连接数据库成功----------------");                
            	  Statement stmt = conn.createStatement();  
            	  int result = stmt.executeUpdate(SQL);  
            	  if(result>0)  
            		  return true;
              }catch(Exception e){  
            	  e.printStackTrace();  
            	  System.out.print("----------------更新失败----------------");  
              }  
              return false;  
        }  
        public static String[][] getDatebases(String Sql) throws SQLException{
        	ResultSet rs=SqlHelper.executeQuery(Sql);
        	int colnum = rs.getMetaData().getColumnCount();//查询结果对应二维数组的列数
        	rs.last();
        	int rows = rs.getRow();//查询结果对应二维数组的行数
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