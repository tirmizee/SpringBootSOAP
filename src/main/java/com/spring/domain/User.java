package com.spring.domain;

import java.sql.Timestamp;

import org.springframework.data.domain.Persistable;

public class User implements Persistable<Long>{

	private static final long serialVersionUID = 5399011411340065307L;

	private transient boolean persisted;
	
	private Long userId;
	private Long profileId;
	private String username;
	private String password;
	private java.sql.Date updateDate;
	private java.sql.Date createDate;
	private java.sql.Date credentialsexpiredDate;
	private java.sql.Date accountExpiredDate;
	private Timestamp accountLockedDate;
	private boolean credentialsnonexpired;
	private boolean accountnonexpired;
	private boolean accountnonlocked;	
	private boolean enabled;
	private boolean firstLogin;
	private Integer fkRoleId;
	private Integer maxSession;
	
	public boolean isPersisted() {
		return persisted;
	}

	public void setPersisted(boolean persisted) {
		this.persisted = persisted;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public java.sql.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.sql.Date updateDate) {
		this.updateDate = updateDate;
	}

	public java.sql.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.sql.Date createDate) {
		this.createDate = createDate;
	}

	public boolean getCredentialsnonexpired() {
		return credentialsnonexpired;
	}

	public java.sql.Date getCredentialsexpiredDate() {
		return credentialsexpiredDate;
	}

	public void setCredentialsexpiredDate(java.sql.Date credentialsexpiredDate) {
		this.credentialsexpiredDate = credentialsexpiredDate;
	}

	public void setCredentialsnonexpired(boolean credentialsnonexpired) {
		this.credentialsnonexpired = credentialsnonexpired;
	}

	public boolean getAccountnonexpired() {
		return accountnonexpired;
	}

	public void setAccountnonexpired(boolean accountnonexpired) {
		this.accountnonexpired = accountnonexpired;
	}

	public boolean getAccountnonlocked() {
		return accountnonlocked;
	}

	public void setAccountnonlocked(boolean accountnonlocked) {
		this.accountnonlocked = accountnonlocked;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean getFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(boolean firstLogin) {
		this.firstLogin = firstLogin;
	}

	public Integer getFkRoleId() {
		return fkRoleId;
	}

	public void setFkRoleId(Integer fkRoleId) {
		this.fkRoleId = fkRoleId;
	}

	public Integer getMaxSession() {
		return maxSession;
	}

	public void setMaxSession(Integer maxSession) {
		this.maxSession = maxSession;
	}

	public java.sql.Date getAccountExpiredDate() {
		return accountExpiredDate;
	}

	public void setAccountExpiredDate(java.sql.Date accountExpiredDate) {
		this.accountExpiredDate = accountExpiredDate;
	}
	
	public Timestamp getAccountLockedDate() {
		return accountLockedDate;
	}

	public void setAccountLockedDate(Timestamp accountLockedDate) {
		this.accountLockedDate = accountLockedDate;
	}

	@Override
	public Long getId() {
		return userId;
	}

	@Override
	public boolean isNew() {
		return !persisted;
	}

	public User withPersisted(boolean persisted) {
		this.persisted = persisted;
		return this;
	}
	
}
