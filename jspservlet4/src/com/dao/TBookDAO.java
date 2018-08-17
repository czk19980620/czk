package com.dao;

import com.pojo.TBook;
import com.util.CRUDDAO;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TBookDAO {
    private static final CRUDDAO<TBook> cruddao = new CRUDDAO<>(TBook.class);
    public static List<TBook> selectAll(){
        List<TBook> list = null;
        Map<String, Object[]> sqls = new LinkedHashMap<>();
        sqls.put("SELECT * FROM t_book;",null);
        Map<Integer, List<TBook>> allBook = cruddao.executeQuery(sqls);
        for (Map.Entry<Integer, List<TBook>> entry : allBook.entrySet()) {
            list = entry.getValue();
        }
        return list;
    }
}
