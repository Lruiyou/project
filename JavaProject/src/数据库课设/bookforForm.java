package 数据库课设;
/*用户订单*/

import myFont.tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class bookforForm extends JPanel implements ActionListener{
    JLabel text;
    JButton bt,bt1,bt2;
    JPanel jpl1,jpl2,jpl3,jpl4;
    JScrollPane jlp;
    JTable tab;
    static String yId;
    dataModel dml;
    public bookforForm(String userId)

    {
        yId=userId;
        jpl1=new JPanel(new FlowLayout(FlowLayout.CENTER));
        text=new JLabel("已生成的订单");
        text.setFont(tool.f1);
        jpl1.add(text);

        jpl2=new JPanel(new BorderLayout());
        dml=new dataModel();
        String[] paras={yId};
        dml.query("select * from form where 用户名=?",paras);
        tab=new JTable(dml);
        jlp=new JScrollPane(tab);
        jpl2.add(jlp);

        bt=new JButton("清空");
        bt.setFont(tool.f3);
        bt.addActionListener(this);

        bt1=new JButton("刷新");
        bt1.setFont(tool.f3);
        bt1.addActionListener(this);

        bt2=new JButton("删除");
        bt2.setFont(tool.f3);
        bt2.addActionListener(this);

        jpl3=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jpl3.add(bt1);
        jpl3.add(bt2);
        jpl3.add(bt);
        jpl4=new JPanel(new BorderLayout());
        jpl4.add(jpl3,"East");
        this.setLayout(new BorderLayout());
        this.add(jpl1,"North");
        this.add(jpl2,"Center");
        this.add(jpl4,"South");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==bt)
        {
             if (dml.delAllForm(yId))
             {
                 JOptionPane.showMessageDialog(this,"已删除");
             }
            String[] paras={yId};
            String sql="select * from form where 用户名=?";
            dataModel d=new dataModel();
            d.query(sql,paras);
            tab.setModel(d);
        }else if (e.getSource()==bt1)
         {
             String[] paras={yId};
             String sql="select * from form where 用户名=?";
             dataModel d=new dataModel();
             d.query(sql,paras);
             tab.setModel(d);
         }else if (e.getSource()==bt2)
        {
             int row=tab.getSelectedRow();
            String id=(String)tab.getValueAt(row,0);
            if (dml.delOneForm(id))
            {
                JOptionPane.showMessageDialog(null,"删除成功");
            }
            String[] paras={yId};
            String sql="select * from form  where 用户名=?";
            dataModel dm=new dataModel();
            dm.query(sql,paras);
            tab.setModel(dm);
        }
    }
}
