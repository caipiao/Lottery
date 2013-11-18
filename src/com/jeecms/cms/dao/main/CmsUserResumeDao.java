package com.jeecms.cms.dao.main;

import com.jeecms.cms.entity.main.CmsUserResume;
import com.jeecms.common.hibernate3.Updater;

public interface CmsUserResumeDao {
	public CmsUserResume findById(Integer id);

	public CmsUserResume save(CmsUserResume bean);

	public CmsUserResume updateByUpdater(Updater<CmsUserResume> updater);
}