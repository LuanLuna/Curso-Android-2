package com.example.rapha.aula10.DAO;

import com.example.rapha.aula10.util.Professor;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rapha on 17/03/2016.
 */
public class ProfessorDAO extends BaseDaoImpl<Professor, Integer>{
    public ProfessorDAO(ConnectionSource connectionSource) throws SQLException {
        super(Professor.class);
        setConnectionSource(connectionSource);
        initialize();
    }
    //este método retorna um objeto queryBuilder que serve para que você possa construir seu
    //select utilizando clausulas como o where e operações como o like, o and...
    @Override
    public QueryBuilder<Professor, Integer> queryBuilder() {
        return super.queryBuilder();
    }
    //Com este método, você pode fazer os selects específicos utilizando as clausulas construídas
    //utilizando o queryBuilder
    @Override
    public List<Professor> query(PreparedQuery<Professor> preparedQuery) throws SQLException {
        return super.query(preparedQuery);
    }
}
