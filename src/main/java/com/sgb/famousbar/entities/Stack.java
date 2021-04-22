package com.sgb.famousbar.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Sebastián Gamboa
 */
@Entity
@Table(name = "arrays")
@Getter
@Setter
public class Stack {

    @Id
    private long id;

    private String inputArray;
}
