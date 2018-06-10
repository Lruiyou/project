package 数据库课设;
/*下单界面*/
import myFont.tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class setForm extends JFrame implements ActionListener{
    JLabel jl1,jl2;
    JTextField jtf1,jtf2;
    JButton bt1,bt2;
    static dataModel  dmodel;
    static int[] rownums;
    static  String  uName;
    Calendar c=null;
     public setForm(String uId,dataModel data,int[] rows)
//    public setForm()
    {
         uName=uId;
        rownums=rows;
        dmodel=data;
        this.setLayout(null);
        Container ct=this.getContentPane();
        jl1=new JLabel("手机号");
        jl1.setFont(tool.f2);
        jl1.setBounds(33,23,50,30);
        ct.add(jl1);

        jl2=new JLabel("您的地址");
        jl2.setFont(tool.f3);
        jl2.setBounds(30,63,50,30);
        ct.add(jl2);


        jtf1=new JTextField(20);
        jtf1.setBounds(83,25,170,25);
        jtf1.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(jtf1);

        jtf2=new JTextField(20);
        jtf2.setBounds(83,65,170,25);
        jtf2.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(jtf2);

        bt1=new JButton("确定");
        bt1.setFont(tool.f2);
        bt1.addActionListener(this);
        bt1.setBounds(70,105,65,30);
        bt2=new JButton("取消");
        bt2.setFont(tool.f2);
        bt2.setBounds(160,105,65,30);
        bt2.addActionListener(this);

        ct.add(bt1);
        ct.add(bt2);
        this.setSize(300,180);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==bt1)
        {
            dataModel data=new dataModel();
            int r=rownums.length;
            String[]s1=new String[20];
            String[]s2=new String[20];
            String []s3=new String[20];
            String []s4=new String[20];
            String sinfo="";
            float totalPrice=0;
                c=Calendar.getInstance();
                String month=Integer.toString(c.get(Calendar.MONTH));
                String day=Integer.toString(c.get(Calendar.DAY_OF_MONTH));
                String hour=Integer.toString(c.get(Calendar.HOUR_OF_DAY));
                String minute=Integer.toString(c.get(Calendar.MINUTE));   //生成系统时间
                String orderId=month+day+hour+minute+uName;
               String phone=jtf1.getText();
               String adress=jtf2.getText();
               for (int j=0;j<r;j++)
                {
                    s1[j] = dmodel.getValueAt(rownums[j], 0).toString();
                     s2[j] = dmodel.getValueAt(rownums[j], 1).toString();
                     s3[j] = dmodel.getValueAt(rownums[j], 2).toString();
                     s4[j] = dmodel.getValueAt(rownums[j], 3).toString();
                     data.updateBook(s1[j],s4[j]);
                }
               for (int i=0;i<r;i++)
               {
                   sinfo=sinfo+s2[i]+s4[i]+"本"+"  ";
                   float f1=Float.parseFloat(s3[i]);
                   float f2=Float.parseFloat(s4[i]);
                   totalPrice=totalPrice+f1*f2;
               }
             if (dmodel.insertForm(orderId,uName,sinfo,phone,adress,totalPrice))
             {
                 JOptionPane.showMessageDialog(this,"下单成功，商家会尽快发货");
             }
            this.dispose();
        }else if (e.getSource()==bt2)
        {
            this.dispose();
        }
    }
}
