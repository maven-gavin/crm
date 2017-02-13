package com.yuanbao.crm.common.plugin.entity;

import com.yuanbao.crm.common.entity.BaseEntity;
import com.yuanbao.crm.common.entity.validate.group.Create;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by gewen on 2017/1/20.
 */
@Entity
@Table(name = "showcase_moveable")
public class Move extends BaseEntity<Long> implements Movable{

    @NotNull(groups = Create.class)
    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "is_show")
    private Boolean show;

    @Override
    public Integer getWeight() {
        return weight;
    }

    @Override
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }
}
