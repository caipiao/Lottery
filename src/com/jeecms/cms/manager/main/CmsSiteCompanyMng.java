package com.jeecms.cms.manager.main;

import com.jeecms.cms.entity.main.CmsSite;
import com.jeecms.cms.entity.main.CmsSiteCompany;

public interface CmsSiteCompanyMng {
	public CmsSiteCompany save(CmsSite site,CmsSiteCompany bean);

	public CmsSiteCompany update(CmsSiteCompany bean);
}