package com.jeecms.cms.entity.assist;

import com.jeecms.cms.entity.assist.base.BaseCmsGuestbookCtg;



public class CmsGuestbookCtg extends BaseCmsGuestbookCtg {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsGuestbookCtg () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsGuestbookCtg (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsGuestbookCtg (
		java.lang.Integer id,
		com.jeecms.cms.entity.main.CmsSite site,
		java.lang.String name,
		java.lang.Integer priority) {

		super (
			id,
			site,
			name,
			priority);
	}

/*[CONSTRUCTOR MARKER END]*/


}