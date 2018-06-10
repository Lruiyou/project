package 数据库课设;
/*购物车界面*/
import myFont.tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bookForCart extends JPanel implements ActionListener{
    JLabel jl;
    JPanel jp1,jp2,jp3,jp4;
    JButton b1,b2,b3,b4;
    JScrollPane js;
    JTable t;
    dataModel d;
   static String x;
    public bookForCart(String uId)
    {
        x=uId;
        jp1=new JPanel(new FlowLayout(FlowLayout.CENTER));
        jl=new JLabel("我的购物车");
        jl.setFont(tool.f1);
        jp1.add(jl);

        jp2=new JPanel(new BorderLayout());
        d=new dataModel();
        String[]paras={uId};
        d.query("select 编号,书名,价格,购买数量 from shopcart where 用户名=?",paras);
        t=new JTable(d);
            js=new JScrollPane(t);
            jp2.add(js);
        b1=new JButton("删除");
        b1.setFont(tool.f3);
        b1.addActionListener(this);

        b2=new JButton("刷新");
        b2.setFont(tool.f3);
        b2.addActionListener(this);

        b3=new JButton("下单");
        b3.setFont(tool.f3);
        b3.addActionListener(this);

        b4=new JButton("清空购物车");
        b4.setFont(tool.f3);
        b4.addActionListener(this);

        jp3=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jp3.add(b3);
        jp3.add(b2);
        jp3.add(b1);
        jp3.add(b4);

        jp4=new JPanel(new BorderLayout());
        jp4.add(jp3,"East");
        this.setLayout(new BorderLayout());
        this.add(jp1,"North");
        this.add(jp2,"Center");
        this.add(jp4,"South");
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
           if (e.getSource()==b2)
           {
               d=new dataModel();
               String[]paras={x};
               d.query("select 编号,书名,价格,购买数量 from shopcart where 用户名=?",paras);
               t.setModel(d);
           }else if (e.getSource()==b1)
           {
               int rowNum=t.getSelectedRow();
               String Id=(String)d.getValueAt(rowNum,0);
               if (d.delBookFromCart(Id))
               {
                   JOptionPane.showMessageDialog(null,"删除成功");
               }
               String[] paras={x};
               String sql="select 编号,书名,价格,购买数量 from shopcart where 用户名=?";
               dataModel dm=new dataModel();
               dm.query(sql,paras);
               t.setModel(dm);
           }else if (e.getSource()==b3)
           {
               int[] row=t.getSelectedRows();
               if (row.length==0)
               {
                   JOptionPane.showMessageDialog(this,"请选择你要下单的书");
                   return;
               }else
               {
                     for (int i=0;i<row.length;i++)
                     {
                         new setForm(x,d,row);
                     }
               }
           }else if (e.getSource()==b4)
           {
              if (d.delALLCart(x))
              {
                  JOptionPane.showMessageDialog(this,"已清空购物车");
              }
               String[] paras={x};
               String sql="select * from form where 用户名=?";
               dataModel d=new dataModel();
               d.query(sql,paras);
               t.setModel(d);
           }
    }
}
