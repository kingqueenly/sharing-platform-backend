package com.benz.user.domain;

public class BenzUser {
    private Long id;
    private String userId;
    private String appellation;//Mr. Miss. Ms.
    private String username;
    private String imgUrl;
    private String organization;
    private String department; //Org abbr+ dept abbr
    private String workArea;
    private String professional;
    private String email;
    private String phone;
    private String mobile;
    private Integer score;
    private String level;
    private Authority authority;
    private String role;
    private Boolean isDCRemember;
    private Boolean deleted;
    private UserCommentLikeShare userCommentLikeShare;

    public BenzUser() {
    }

    public BenzUser(String userId, String appellation, String username, String imgUrl, String organization, String department, String workArea, String professional, String email, String phone, String mobile, Integer score, String level, Authority authority, String role, Boolean isDCRemember, UserCommentLikeShare userCommentLikeShare) {
        this.id = DomainRegistry.userRepository().nextIdentity();
        this.userId = userId;
        this.appellation = appellation;
        this.username = username;
        this.imgUrl = imgUrl;
        this.organization = organization;
        this.department = department;
        this.workArea = workArea;
        this.professional = professional;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.score = score;
        this.level = level;
        this.authority = authority;
        this.role = role;
        this.isDCRemember = isDCRemember;
        this.userCommentLikeShare = userCommentLikeShare;
        this.deleted = false;
    }

    public Boolean getIsDCRemember() {
        return isDCRemember;
    }

    public void setIsDCRemember(Boolean DCRemember) {
        isDCRemember = DCRemember;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public UserCommentLikeShare getUserCommentLikeShare() {
        return userCommentLikeShare;
    }

    public void setUserCommentLikeShare(UserCommentLikeShare userCommentLikeShare) {
        this.userCommentLikeShare = userCommentLikeShare;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public boolean getDeleted() { return deleted; }

    public void setDeleted(boolean deleted) { this.deleted = deleted; }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public void create() {
        DomainRegistry.userRepository().save(this);
    }

    public void update(String appellation, String username, String imageUrl, String organization, String department, String workArea, String professional, String email, String phone, String mobile, Authority authority,String role,Boolean isDCRemember, boolean deleted) {
        this.setAppellation(appellation);
        this.setUsername(username);
        this.setImgUrl(imageUrl);
        this.setOrganization(organization);
        this.setDepartment(department);
        this.setWorkArea(workArea);
        this.setProfessional(professional);
        this.setEmail(email);
        this.setPhone(phone);
        this.setMobile(mobile);
        this.setAuthority(authority);
        this.role=role;
        this.setIsDCRemember(isDCRemember);
        this.setDeleted(deleted);
        DomainRegistry.userRepository().save(this);

    }
    public void delete() {
        DomainRegistry.userRepository().delete(this);
    }

    public void computeScore(int factor) {
        if (getScore() == null) setScore(0);

        setScore(getScore() + factor);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


}
