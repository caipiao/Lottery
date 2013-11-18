package com.jeecms.cms.dao.main;

import com.jeecms.cms.entity.main.CmsConfig;
import com.jeecms.common.hibernate3.Updater;

public interface CmsConfigDao {
	public CmsConfig findById(Integer id);

	public CmsConfig updateByUpdater(Updater<CmsConfig> updater);
}