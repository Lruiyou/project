package 数据库课设;
/*管理员订单*/
import myFont.tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formForManager extends JPanel implements ActionListener {
    JLabel txt;
    JButton btn,btn1,btn2;
    JPanel jpl1,jpl2,jpl3,jpl4;
    JScrollPane jlp;
    JTable tb;
    dataModel dmodel;
    public formForManager()
    {

        jpl1=new JPanel(new FlowLayout(FlowLayout.CENTER));
        txt=new JLabel("顾客订单");
        txt.setFont(tool.f1);
        jpl1.add(txt);

        jpl2=new JPanel(new BorderLayout());
        dmodel=new dataModel();
        String[] paras={"1"};
        dmodel.query("select * from managerform where 1=?",paras);
        tb=new JTable(dmodel);
        jlp=new JScrollPane(tb);
        jpl2.add(jlp);

        btn=new JButton("清空");
        btn.setFont(tool.f3);
        btn.addActionListener(this);

        btn1=new JButton("刷新");
        btn1.setFont(tool.f3);
        btn1.addActionListener(this);

        btn2=new JButton("删除");
        btn2.setFont(tool.f3);
        btn2.addActionListener(this);

        jpl3=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jpl3.add(btn1);
        jpl3.add(btn2);
        jpl3.add(btn);
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
        if (e.getSource()==btn)
        {
            if (dmodel.delForm())
            {
                JOptionPane.showMessageDialog(this,"已清空订单记录");
            }
            String[] paras={"1"};
            String sql="select * from managerform where 1=?";
            dataModel d=new dataModel();
            d.query(sql,paras);
            tb.setModel(d);
        }else if (e.getSource()==btn1)
        {
            String[] paras={"1"};
            String sql="select * from managerform where 1=?";
            dataModel d=new dataModel();
            d.query(sql,paras);
            tb.setModel(d);
        }else if (e.getSource()==btn2)
        {
             int row=tb.getSelectedRow();
             String number=(String)tb.getValueAt(row,0);
            if (dmodel.delmanageForm(number))
            {
                JOptionPane.showMessageDialog(this,"删除成功");
            }
            String[] paras={"1"};
            String sql="select * from  managerform  where 1=?";
            dataModel dm=new dataModel();
            dm.query(sql,paras);
            tb.setModel(dm);
        }
    }
}
