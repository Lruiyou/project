package 数据库课设;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

public class dataModel extends AbstractTableModel{
     Vector  colums;
     Vector rows;

     public boolean updateBook(String bookid,String num)//调用存储过程
     {
         boolean b=true;
         String []paras={bookid,num};
         String  sql="{call del(?,?)}";
         sqlManage s=new sqlManage();
         try {
             s.executeNum(sql,paras);
         }catch (Exception e)
         {
             e.printStackTrace();
         }
         return b;
     }

    public boolean delmanageForm(String num)
    {
        boolean b=true;
        String []paras={num};
        String sql="delete  from  managerform  where 订单号=?";
        sqlManage sm=new sqlManage();
        try {
            sm.exeupdate(sql,paras);
        }catch (Exception e)
        {
            b=false;
            e.printStackTrace();
        }
        return  b;
    }

     public  boolean delOneForm(String id)
     {
         boolean b=true;
         String []paras={id};
         String sql="delete  from  form  where 订单号=?";
         sqlManage sm=new sqlManage();
         try {
             sm.exeupdate(sql,paras);
         }catch (Exception e)
         {
             b=false;
             e.printStackTrace();
         }
         return  b;
     }

     public boolean delForm()
     {
         boolean b=true;
         String []paras={"1"};
         String sql="delete  from  form  where 1=?";
         sqlManage sm=new sqlManage();
         try {
             sm.exeupdate(sql,paras);
         }catch (Exception e)
         {
             b=false;
             e.printStackTrace();
         }
         return  b;
     }

     public  boolean delALLCart(String Id)
     {
         boolean b=true;
         String []paras={Id};
         String sql="delete  from shopcart where 用户名=?";
         sqlManage sm=new sqlManage();
         try {
             sm.exeupdate(sql,paras);
         }catch (Exception e)
         {
             b=false;
             e.printStackTrace();
         }
         return  b;
     }

     public  boolean  delAllForm(String uId)
     {
         boolean b=true;
         String []paras={uId};
         String sql="delete  from form where 用户名=?";
         sqlManage sm=new sqlManage();
         try {
             sm.exeupdate(sql,paras);
         }catch (Exception e)
         {
             b=false;
             e.printStackTrace();
         }
         return  b;
     }

   public boolean insertForm(String orderId,String uId,String info,String phone,String adress,float price)//生成订单
   {
       boolean b=true;
       String sql="insert into form values(?,?,?,?,?,?)";
       String[] paras={orderId,uId,info,phone,adress,String.valueOf(price)};
       sqlManage s=new sqlManage();
       try {
           s.exeupdate(sql,paras);
       }catch (Exception e)
       {
           e.printStackTrace();
       }
       return  b;
   }

    public boolean checkId(String bookId,String uId)
    {
        boolean  b=false;
        String sql="select * from shopcart where 编号=? and 用户名=?";
        String[] paras={bookId,uId};
        sqlManage sm=new sqlManage();
        ResultSet rs=null;
        try{
            rs=sm.query(sql,paras);
            if (rs.next())
            {
                return  true;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            sm.close();
        }
        return b;
    }

     public boolean delBookById(String bookId)
     {
         boolean  bl=true;
         String sql="delete from book where 编号=?";
         String[] paras={bookId};
         sqlManage sm=new sqlManage();
         try{
               bl=sm.exeupdate(sql,paras);
         }catch(Exception e)
         {
             e.printStackTrace();
         }finally {
             sm.close();
         }
         return bl;
     }

    public boolean delBookFromCart(String bookId)
    {
        boolean  bl=true;
        String sql="delete from shopcart where 编号=?";
        String[] paras={bookId};
        sqlManage sm=new sqlManage();
        try{
            bl=sm.exeupdate(sql,paras);
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            sm.close();
        }
        return bl;
    }


     public  boolean update(String s1,String s2,String s3,String s4,String s5,String s6,String s7)
     {
         boolean b=true;
          String sql="update book set 书名=?,作者=?,出版社=?,类型=?,库存=?,价格=? where 编号=?";
          String []paras={s2,s3,s4,s5,s6,s7,s1};
          sqlManage s=new sqlManage();
          try {
               s.exeupdate(sql,paras);
          }catch (Exception e)
          {
              e.printStackTrace();
          }
      return b;
     }

     public boolean insert(String s1,String s2,String s3,String s4,String s5,String s6,String s7)
     {
         boolean bl=true;
         String sql="insert into book values(?,?,?,?,?,?,?)";
         String []paras={s1,s2,s3,s4,s5,s6,s7};
         sqlManage sm=new sqlManage();
         try {
               sm.exeupdate(sql,paras);
         }catch (Exception e)
         {
             e.printStackTrace();
         }
         return bl;
     }

     public boolean userInsert(String s1,String s2)
     {
         boolean b=true;
         String[] paras={s1,s2};
         String sql="insert into buyer values(?,?)";
         sqlManage s=new sqlManage();
         try {
             s.exeupdate(sql,paras);
         }catch (Exception e)
         {
             e.printStackTrace();
         }
         return b;
     }

     public boolean  insertCar(String s1,String s2,String s3,String s4,String s5)
     {
         boolean b=true;
         String[]paras={s1,s2,s3,s4,s5};
         String sql="insert into shopcart values(?,?,?,?,?)";
         sqlManage s=new sqlManage();
         try {
             s.exeupdate(sql,paras);
         }catch (Exception e)
         {
             e.printStackTrace();
         }
         return b;
     }

     public boolean checkBookName(String name)
     {
         int row=0;
         boolean b=true;
         String paras[]={name};
         String sql="select * from book where 书名=?";
         sqlManage s=new sqlManage();
         ResultSet rs=null;
         try {
             rs=s.query(sql,paras);
             while(rs.next())
             {
                 row++;
             }
             if (row<1)
             {return  false;}
         }catch (Exception e)
         {
             e.printStackTrace();
         }
       return b;
     }



     public void query(String sql,String[] paras)
     {
         this.colums=new Vector();
         this.rows=new Vector();

         sqlManage s=new sqlManage();//创建sqlManage对象
         ResultSet rs=s.query(sql,paras);


         try {
             ResultSetMetaData rsmt=rs.getMetaData();
             for (int i = 0; i <rsmt.getColumnCount(); i++)
             {
                   this.colums.add(rsmt.getColumnName(i+1));
             }
             while (rs.next())
             {
                 Vector<String> temp = new Vector<String>();
                 for (int i = 0; i <rsmt.getColumnCount() ; i++) {
                     temp.add(rs.getString(i+1));
                 }
                 rows.add(temp);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }finally {
             s.close();
         }
     }
    @Override
    public int getRowCount() {
        return this.rows.size();
    }


    @Override
    public int getColumnCount() {
        return this.colums.size();
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return ((Vector)rows.get(rowIndex)).get(columnIndex);
    }


    @Override
    public String getColumnName(int column) {
        return this.colums.get(column).toString();
    }
}
