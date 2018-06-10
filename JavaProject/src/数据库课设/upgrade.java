package 数据库课设;

public class upgrade {
    public void  initSelect(dataModel m)
    {
        String[] paras={"1"};
        String sql="select * from book where 1=?";
        m.query(sql,paras);
    }
}
