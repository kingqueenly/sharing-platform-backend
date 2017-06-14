package com.benz.user.domain;

/**
 * Created by Administrator on 5/2/2017.
 */
public class Role {
    private Long id;
    private String text;

    public Role() {
    }

    public Role(String text) {
        this.id=DomainRegistry.roleRepository().nextIdentity();
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long create() {
        DomainRegistry.roleRepository().save(this);

        return this.getId();
    }

    public void update(String name) {
        setText(name);

        DomainRegistry.roleRepository().save(this);
    }

    public void delete() {
        DomainRegistry.roleRepository().delete(this);
    }
}
