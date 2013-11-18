package com.jeecms.cms.dao.main;

import com.jeecms.common.hibernate3.Updater;
import com.jeecms.cms.entity.main.CmsSiteCompany;

public interface CmsSiteCompanyDao {

	public CmsSiteCompany save(CmsSiteCompany bean);

	public CmsSiteCompany updateByUpdater(Updater<CmsSiteCompany> updater);
}