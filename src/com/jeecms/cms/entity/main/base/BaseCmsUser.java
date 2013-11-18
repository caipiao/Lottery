package com.jeecms.cms.entity.main.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the jc_user table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="jc_user"
 */

public abstract class BaseCmsUser  implements Serializable {

	public static String REF = "CmsUser";
	public static String PROP_REGISTER_TIME = "registerTime";
	public static String PROP_LOGIN_COUNT = "loginCount";
	public static String PROP_SELF_ADMIN = "selfAdmin";
	public static String PROP_UPLOAD_TOTAL = "uploadTotal";
	public static String PROP_LAST_LOGIN_IP = "lastLoginIp";
	public static String PROP_DISABLED = "disabled";
	public static String PROP_LAST_LOGIN_TIME = "lastLoginTime";
	public static String PROP_UPLOAD_DATE = "uploadDate";
	public static String PROP_GROUP = "group";
	public static String PROP_EMAIL = "email";
	public static String PROP_UPLOAD_SIZE = "uploadSize";
	public static String PROP_RANK = "rank";
	public static String PROP_VIEWONLY_ADMIN = "viewonlyAdmin";
	public static String PROP_ADMIN = "admin";
	public static String PROP_ID = "id";
	public static String PROP_REGISTER_IP = "registerIp";
	public static String PROP_USERNAME = "username";


	// constructors
	public BaseCmsUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsUser (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsUser (
		java.lang.Integer id,
		com.jeecms.cms.entity.main.CmsGroup group,
		java.lang.String username,
		java.util.Date registerTime,
		java.lang.String registerIp,
		java.lang.Integer loginCount,
		java.lang.Integer rank,
		java.lang.Long uploadTotal,
		java.lang.Integer uploadSize,
		java.lang.Boolean admin,
		java.lang.Boolean viewonlyAdmin,
		java.lang.Boolean selfAdmin,
		java.lang.Boolean disabled) {

		this.setId(id);
		this.setGroup(group);
		this.setUsername(username);
		this.setRegisterTime(registerTime);
		this.setRegisterIp(registerIp);
		this.setLoginCount(loginCount);
		this.setRank(rank);
		this.setUploadTotal(uploadTotal);
		this.setUploadSize(uploadSize);
		this.setAdmin(admin);
		this.setViewonlyAdmin(viewonlyAdmin);
		this.setSelfAdmin(selfAdmin);
		this.setDisabled(disabled);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String username;
	private java.lang.String email;
	private java.util.Date registerTime;
	private java.lang.String registerIp;
	private java.util.Date lastLoginTime;
	private java.lang.String lastLoginIp;
	private java.lang.Integer loginCount;
	private java.lang.Integer rank;
	private java.lang.Long uploadTotal;
	private java.lang.Integer uploadSize;
	private java.sql.Date uploadDate;
	private java.lang.Boolean admin;
	private java.lang.Boolean viewonlyAdmin;
	private java.lang.Boolean selfAdmin;
	private java.lang.Boolean disabled;

	// many to one
	private com.jeecms.cms.entity.main.CmsGroup group;

	// collections
	private java.util.Set<com.jeecms.cms.entity.main.CmsUserExt> userExtSet;
	private java.util.Set<com.jeecms.cms.entity.main.CmsUserSite> userSites;
	private java.util.Set<com.jeecms.cms.entity.main.CmsRole> roles;
	private java.util.Set<com.jeecms.cms.entity.main.Channel> channels;
	private java.util.Set<com.jeecms.cms.entity.main.Content> collectContents;
	private java.util.Set<com.jeecms.cms.entity.assist.CmsJobApply> jobApplys;
	private java.util.Set<com.jeecms.cms.entity.main.CmsUserResume> userResumeSet;
	
	private java.util.Set<com.jeecms.cms.entity.assist.CmsMessage> sendMessages;
	private java.util.Set<com.jeecms.cms.entity.assist.CmsMessage> receivMessages;
	private java.util.Set<com.jeecms.cms.entity.assist.CmsReceiverMessage> sendReceiverMessages;
	private java.util.Set<com.jeecms.cms.entity.assist.CmsReceiverMessage> receivReceiverMessages;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="user_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: username
	 */
	public java.lang.String getUsername () {
		return username;
	}

	/**
	 * Set the value related to the column: username
	 * @param username the username value
	 */
	public void setUsername (java.lang.String username) {
		this.username = username;
	}


	/**
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * @param email the email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}


	/**
	 * Return the value associated with the column: register_time
	 */
	public java.util.Date getRegisterTime () {
		return registerTime;
	}

	/**
	 * Set the value related to the column: register_time
	 * @param registerTime the register_time value
	 */
	public void setRegisterTime (java.util.Date registerTime) {
		this.registerTime = registerTime;
	}


	/**
	 * Return the value associated with the column: register_ip
	 */
	public java.lang.String getRegisterIp () {
		return registerIp;
	}

	/**
	 * Set the value related to the column: register_ip
	 * @param registerIp the register_ip value
	 */
	public void setRegisterIp (java.lang.String registerIp) {
		this.registerIp = registerIp;
	}


	/**
	 * Return the value associated with the column: last_login_time
	 */
	public java.util.Date getLastLoginTime () {
		return lastLoginTime;
	}

	/**
	 * Set the value related to the column: last_login_time
	 * @param lastLoginTime the last_login_time value
	 */
	public void setLastLoginTime (java.util.Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}


	/**
	 * Return the value associated with the column: last_login_ip
	 */
	public java.lang.String getLastLoginIp () {
		return lastLoginIp;
	}

	/**
	 * Set the value related to the column: last_login_ip
	 * @param lastLoginIp the last_login_ip value
	 */
	public void setLastLoginIp (java.lang.String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}


	/**
	 * Return the value associated with the column: login_count
	 */
	public java.lang.Integer getLoginCount () {
		return loginCount;
	}

	/**
	 * Set the value related to the column: login_count
	 * @param loginCount the login_count value
	 */
	public void setLoginCount (java.lang.Integer loginCount) {
		this.loginCount = loginCount;
	}


	/**
	 * Return the value associated with the column: rank
	 */
	public java.lang.Integer getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: rank
	 * @param rank the rank value
	 */
	public void setRank (java.lang.Integer rank) {
		this.rank = rank;
	}


	/**
	 * Return the value associated with the column: upload_total
	 */
	public java.lang.Long getUploadTotal () {
		return uploadTotal;
	}

	/**
	 * Set the value related to the column: upload_total
	 * @param uploadTotal the upload_total value
	 */
	public void setUploadTotal (java.lang.Long uploadTotal) {
		this.uploadTotal = uploadTotal;
	}


	/**
	 * Return the value associated with the column: upload_size
	 */
	public java.lang.Integer getUploadSize () {
		return uploadSize;
	}

	/**
	 * Set the value related to the column: upload_size
	 * @param uploadSize the upload_size value
	 */
	public void setUploadSize (java.lang.Integer uploadSize) {
		this.uploadSize = uploadSize;
	}

	/**
	 * Return the value associated with the column: upload_date
	 */
	public java.sql.Date getUploadDate () {
		return uploadDate;
	}

	/**
	 * Set the value related to the column: upload_date
	 * @param uploadDate the upload_date value
	 */
	public void setUploadDate (java.sql.Date uploadDate) {
		this.uploadDate = uploadDate;
	}


	/**
	 * Return the value associated with the column: is_admin
	 */
	public java.lang.Boolean getAdmin () {
		return admin;
	}

	/**
	 * Set the value related to the column: is_admin
	 * @param admin the is_admin value
	 */
	public void setAdmin (java.lang.Boolean admin) {
		this.admin = admin;
	}


	/**
	 * Return the value associated with the column: is_viewonly_admin
	 */
	public java.lang.Boolean getViewonlyAdmin () {
		return viewonlyAdmin;
	}

	/**
	 * Set the value related to the column: is_viewonly_admin
	 * @param viewonlyAdmin the is_viewonly_admin value
	 */
	public void setViewonlyAdmin (java.lang.Boolean viewonlyAdmin) {
		this.viewonlyAdmin = viewonlyAdmin;
	}


	/**
	 * Return the value associated with the column: is_self_admin
	 */
	public java.lang.Boolean getSelfAdmin () {
		return selfAdmin;
	}

	/**
	 * Set the value related to the column: is_self_admin
	 * @param selfAdmin the is_self_admin value
	 */
	public void setSelfAdmin (java.lang.Boolean selfAdmin) {
		this.selfAdmin = selfAdmin;
	}


	/**
	 * Return the value associated with the column: is_disabled
	 */
	public java.lang.Boolean getDisabled () {
		return disabled;
	}

	/**
	 * Set the value related to the column: is_disabled
	 * @param disabled the is_disabled value
	 */
	public void setDisabled (java.lang.Boolean disabled) {
		this.disabled = disabled;
	}
	/**
	 * Return the value associated with the column: group_id
	 */
	public com.jeecms.cms.entity.main.CmsGroup getGroup () {
		return group;
	}

	/**
	 * Set the value related to the column: group_id
	 * @param group the group_id value
	 */
	public void setGroup (com.jeecms.cms.entity.main.CmsGroup group) {
		this.group = group;
	}


	/**
	 * Return the value associated with the column: userExtSet
	 */
	public java.util.Set<com.jeecms.cms.entity.main.CmsUserExt> getUserExtSet () {
		return userExtSet;
	}

	/**
	 * Set the value related to the column: userExtSet
	 * @param userExtSet the userExtSet value
	 */
	public void setUserExtSet (java.util.Set<com.jeecms.cms.entity.main.CmsUserExt> userExtSet) {
		this.userExtSet = userExtSet;
	}


	/**
	 * Return the value associated with the column: userSites
	 */
	public java.util.Set<com.jeecms.cms.entity.main.CmsUserSite> getUserSites () {
		return userSites;
	}

	/**
	 * Set the value related to the column: userSites
	 * @param userSites the userSites value
	 */
	public void setUserSites (java.util.Set<com.jeecms.cms.entity.main.CmsUserSite> userSites) {
		this.userSites = userSites;
	}


	/**
	 * Return the value associated with the column: roles
	 */
	public java.util.Set<com.jeecms.cms.entity.main.CmsRole> getRoles () {
		return roles;
	}

	/**
	 * Set the value related to the column: roles
	 * @param roles the roles value
	 */
	public void setRoles (java.util.Set<com.jeecms.cms.entity.main.CmsRole> roles) {
		this.roles = roles;
	}


	/**
	 * Return the value associated with the column: channels
	 */
	public java.util.Set<com.jeecms.cms.entity.main.Channel> getChannels () {
		return channels;
	}

	/**
	 * Set the value related to the column: channels
	 * @param channels the channels value
	 */
	public void setChannels (java.util.Set<com.jeecms.cms.entity.main.Channel> channels) {
		this.channels = channels;
	}
	

	public java.util.Set<com.jeecms.cms.entity.main.Content> getCollectContents() {
		return collectContents;
	}

	public void setCollectContents(
			java.util.Set<com.jeecms.cms.entity.main.Content> collectContents) {
		this.collectContents = collectContents;
	}

	public java.util.Set<com.jeecms.cms.entity.assist.CmsJobApply> getJobApplys() {
		return jobApplys;
	}

	public void setJobApplys(
			java.util.Set<com.jeecms.cms.entity.assist.CmsJobApply> jobApplys) {
		this.jobApplys = jobApplys;
	}
	
	public java.util.Set<com.jeecms.cms.entity.main.CmsUserResume> getUserResumeSet() {
		return userResumeSet;
	}

	public void setUserResumeSet(
			java.util.Set<com.jeecms.cms.entity.main.CmsUserResume> userResumeSet) {
		this.userResumeSet = userResumeSet;
	}

	public java.util.Set<com.jeecms.cms.entity.assist.CmsMessage> getSendMessages() {
		return sendMessages;
	}

	public void setSendMessages(
			java.util.Set<com.jeecms.cms.entity.assist.CmsMessage> sendMessages) {
		this.sendMessages = sendMessages;
	}

	public java.util.Set<com.jeecms.cms.entity.assist.CmsMessage> getReceivMessages() {
		return receivMessages;
	}

	public void setReceivMessages(
			java.util.Set<com.jeecms.cms.entity.assist.CmsMessage> receivMessages) {
		this.receivMessages = receivMessages;
	}

	public java.util.Set<com.jeecms.cms.entity.assist.CmsReceiverMessage> getSendReceiverMessages() {
		return sendReceiverMessages;
	}

	public void setSendReceiverMessages(
			java.util.Set<com.jeecms.cms.entity.assist.CmsReceiverMessage> sendReceiverMessages) {
		this.sendReceiverMessages = sendReceiverMessages;
	}

	public java.util.Set<com.jeecms.cms.entity.assist.CmsReceiverMessage> getReceivReceiverMessages() {
		return receivReceiverMessages;
	}

	public void setReceivReceiverMessages(
			java.util.Set<com.jeecms.cms.entity.assist.CmsReceiverMessage> receivReceiverMessages) {
		this.receivReceiverMessages = receivReceiverMessages;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.cms.entity.main.CmsUser)) return false;
		else {
			com.jeecms.cms.entity.main.CmsUser cmsUser = (com.jeecms.cms.entity.main.CmsUser) obj;
			if (null == this.getId() || null == cmsUser.getId()) return false;
			else return (this.getId().equals(cmsUser.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}