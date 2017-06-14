package com.benz.usecase.domain;

/**
 * Created by paulliu on 2017/1/18.
 */
public class ContributionBU {
    private Long id;
    private String text;
    private String org;
    private String dept;

    public ContributionBU() {
    }

    public ContributionBU(String text, String org, String dept) {
        this.id = DomainRegistry.contribitionBURepository().nextIdentity();
        this.text = text;
        this.org = org;
        this.dept = dept;
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

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Long create() {
        DomainRegistry.contribitionBURepository().save(this);

        return this.getId();
    }

    public void update(String text, String org, String dept) {
        setText(text);
        setOrg(org);
        setDept(dept);

        DomainRegistry.contribitionBURepository().save(this);
    }

    public void delete() {
        DomainRegistry.contribitionBURepository().delete(this);
    }
}
