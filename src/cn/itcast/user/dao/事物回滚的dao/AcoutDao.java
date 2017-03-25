package cn.itcast.user.dao.事物回滚的dao;

import cn.itcast.user.DB.JDdbfcp;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by winsion on 2017/3/25.
 */
public class AcoutDao {

    public static void update(String name,double money) throws SQLException {
        //获取连接
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update shiwu set money=money+? where name=?";
        Object[] params = {money,name};
        Connection connection = JDdbfcp.getConnec();
        queryRunner.update(connection,sql,params);

    }


    public static void main(String[] args){
        AcoutDao acoutDao = new AcoutDao();
        try {
            JDdbfcp.beginTransaction();
            acoutDao.update("李四",100);
            acoutDao.update("张三",-100);
            JDdbfcp.commitTransaction();
        } catch (SQLException e) {//回滚事物
            try {
                JDdbfcp.rollbackTransaction();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }

    }
}
