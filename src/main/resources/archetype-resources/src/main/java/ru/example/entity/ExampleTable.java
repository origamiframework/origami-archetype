#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.time.ZonedDateTime;

import static ru.origami.hibernate.CommonFixtureSteps.DYNAMIC_SCHEMA;

@Entity
@Getter
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "example_table", schema = DYNAMIC_SCHEMA)
public class ExampleTable implements Serializable {

    @ToString.Include
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "version", nullable = false)
    private long version;

    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;

    @ToString.Include
    @Column(name = "rf_id", nullable = false)
    private String rfId;

    @Column(name = "symbol", nullable = false)
    private String symbol;

    @Column(name = "comment")
    private String comment;
}
