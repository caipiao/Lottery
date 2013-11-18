package com.jeecms.cms.dao.main;

import com.jeecms.cms.entity.main.CmsUserExt;
import com.jeecms.common.hibernate3.Updater;

public interface CmsUserExtDao {
	public CmsUserExt findById(Integer id);

	public CmsUserExt save(CmsUserExt bean);

	public CmsUserExt updateByUpdater(Updater<CmsUserExt> updater);
}