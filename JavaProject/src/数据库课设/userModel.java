package 数据库课设;

import java.sql.ResultSet;

public class userModel {
    public  boolean  checkUser(String uid, String s)
    {
        sqlManage sm = null;
        String str="";
        try {
            String sql = "select * from buyer where 账号=? and 密码=?";
            String paras[] = {uid, s};
            sm = new sqlManage();
            ResultSet rs = sm.query(sql, paras);
            if (rs.next())
            {
                return  true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sm.close();
        }
        return  false;
    }
}
