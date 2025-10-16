#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.steps.fixtures;

import ru.origami.common.environment.Environment;
import ru.origami.hibernate.CommonFixtureSteps;
import ru.origami.hibernate.models.DataBaseSessionProperties;
import ru.origami.hibernate.models.EHibernateResource;
import ru.origami.testit_allure.annotations.Step;
import ru.example.entity.ExampleTable;

import java.util.List;

public class ExampleFixtureSteps extends CommonFixtureSteps {

    public ExampleFixtureSteps() {
        sessionProperties = new DataBaseSessionProperties.Builder()
                .setHibernateResource(EHibernateResource.POSTGRES)
                .setDbHost(Environment.get("db.host"))
                .setDbName(Environment.get("db.name"))
                .setDbPort(Environment.get("db.port"))
                .setDbUserName(Environment.get("db.username"))
                .setDbPassword(Environment.get("db.password"))
                .setSchema(Environment.get("db.schema"))
                .build();

        initSession();
    }

    @Step("Получаем данные по id: {id}")
    public List<ExampleTable> getExamplesById(String id) {
        final String hql = """
                SELECT et FROM ExampleTable et
                WHERE et.id=:id
                """;

        return session.createQuery(hql, ExampleTable.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Step("Очищаем таблицу {table}")
    public void deleteFromTableByName(String table) {
        final String sql = """
                DELETE FROM :schemaName.:table
                """;

        session.createNativeQuery(sql)
                .changeParameter("schemaName", this.sessionProperties.getSchema())
                .changeParameter("table", table)
                .executeUpdate();
    }

    @Step("Обновляем статус ${symbol_escape}"{id}${symbol_escape}" на ${symbol_escape}"{status}${symbol_escape}"")
    public void updateStatusById(String id, String status) {
        final String sql = """
                UPDATE :schemaName.example_table
                SET status = :status
                WHERE id = :id
                """;

        session.createNativeQuery(sql)
                .changeParameter("schemaName", this.sessionProperties.getSchema())
                .setParameter("status", status)
                .setParameter("id", id)
                .executeUpdate();
    }
}
