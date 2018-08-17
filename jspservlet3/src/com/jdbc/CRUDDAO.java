package com.jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CRUDDAO<T> {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    Class<T> c;
    public CRUDDAO(Class<T> c) {
        this.c = c;
    }

    /**
     * 查询数据表的记录总数
     * @param sql
     * @return
     */
    public int selectCount(String sql){
        try {
            connection= JNDIDAO.getConn();
            if(connection!=null){
                preparedStatement=connection.prepareStatement(sql);
                resultSet=preparedStatement.executeQuery();
                if(resultSet.next()){
                    return resultSet.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JNDIDAO.closeAll(connection, preparedStatement, resultSet);
        }
        return 0;
    }


    /**
     * 执行多条sql 增删改语句
     * @param map
     * @return
     */
    public Map<Integer,Integer> executeUpdate(Map<String, Object[]> map) {
        int i = 1,err = 0;
        Map<Integer, Integer> resultMap = new LinkedHashMap<>();
        try {
            connection = JNDIDAO.getConn();
            if (connection != null) {
                Set<Map.Entry<String, Object[]>> set = map.entrySet();
                connection.setAutoCommit(false);
                for (Map.Entry<String, Object[]> mapEntry : set) {
                    preparedStatement = connection.prepareStatement(mapEntry.getKey());
                    bind(mapEntry.getValue());
                    int row = preparedStatement.executeUpdate();
                    resultMap.put(i++,row);
                }
            }
        } catch (SQLException e) {
            err++;
            e.printStackTrace();
        }finally {
            if (err > 0) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    connection.commit();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultMap;
    }


    /**
     * 执行多条sql查询语句
     * @param map
     * @return
     */
    public Map<Integer, List<T>> executeQuery(Map<String, Object[]> map) {
        int i = 1;
        Map<Integer, List<T>> resultMap = new LinkedHashMap<>();
        Set<Map.Entry<String, Object[]>> set = map.entrySet();
        for (Map.Entry<String, Object[]> mapEntry : set) {
           resultMap.put(i++,executeQuery(mapEntry.getKey(), mapEntry.getValue())) ;
        }
        return resultMap;

    }
    /**
     * 执行单条sql查询语句
     * @param sql
     * @param objects
     * @return
     */
    public List<T> executeQuery(String sql,Object...objects){
        List<T> list = null;
        connection = JNDIDAO.getConn();//创建连接
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);//创建sql执行对象
                bind(objects);//绑定sql参数
                resultSet = preparedStatement.executeQuery();//获取结果集
                list = toBean();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            JNDIDAO.closeAll(connection,preparedStatement,resultSet);
        }


        return list;
    }

    /**
     * 封装结果集带list集合
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private List<T> toBean() throws SQLException, InstantiationException, IllegalAccessException {
        List<T> list = new ArrayList();
        while (resultSet.next()) {
            T t = c.newInstance();
            Field[] fields = c.getDeclaredFields();
            for (Field field :
                    fields) {
                field.setAccessible(true);
                field.set(t,resultSet.getObject(field.getName()));
            }
            list.add(t);
        }
        return list;
    }

    /**
     * 绑定执行对象
     * @param objects
     * @throws SQLException
     */
    private void bind(Object[] objects) throws SQLException {
        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1,objects[i]);
            }
        }
    }
}
