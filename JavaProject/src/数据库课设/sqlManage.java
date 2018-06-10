package 数据库课设;

import java.sql.*;

//对数据库进行操作
public class sqlManage {
    PreparedStatement ps=null;
    Connection ct=null;
    ResultSet rs=null;
    CallableStatement cs=null;
    String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=bookStore";
    String user="sa";
    String pwd="huizhou";
    public sqlManage()
    {
        try {
            Class.forName(driverName);
            ct=DriverManager.getConnection(url,user,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //调用存储过程
  public  boolean executeNum(String sql,String[] paras)
  {
      boolean b=true;
      try {
           cs=ct.prepareCall(sql);
          for (int i = 0; i <paras.length ; i++) {
              cs.setString(i+1,paras[i]);
          }
          cs.execute();
      }catch (Exception e)
      {
          b=false;
          e.printStackTrace();
      }
      return b;
  }

    //实现增删改的方法
    public boolean exeupdate(String sql,String[] paras)
    {      boolean b=true;
        try {
            ps=ct.prepareStatement(sql);
            for (int i = 0; i < paras.length; i++)
            {
                ps.setString(i+1,paras[i]);
            }
            ps.executeUpdate();
        } catch (Exception e) {
            b=false;
            e.printStackTrace();
        }
       return  b;
    }


    public ResultSet query(String sql,String[] paras)
    {
        try {
            ps=ct.prepareStatement(sql);
            for (int i = 0; i < paras.length; i++)
            {
                ps.setString(i+1,paras[i]);
            }
            rs=ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return rs;
    }

    public void close()
    {
        try {
            if (rs!=null)
            {
                rs.close();
            }
            if (ct!=null)
            {
                ct.close();
            }
            if (ps!=null)
            {
                ps.close();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
