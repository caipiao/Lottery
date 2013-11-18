package com.jeecms.cms.manager.main;

import com.jeecms.cms.entity.main.CmsUser;
import com.jeecms.cms.entity.main.CmsUserResume;

public interface CmsUserResumeMng {
	public CmsUserResume save(CmsUserResume ext, CmsUser user);

	public CmsUserResume update(CmsUserResume ext, CmsUser user);
}