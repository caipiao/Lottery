package com.jeecms.cms.manager.assist;

import net.sf.ehcache.Ehcache;

import com.jeecms.cms.entity.assist.CmsSiteFlow;
import com.jeecms.cms.entity.main.CmsSite;

public interface CmsSiteFlowMng {
	public CmsSiteFlow save(CmsSite site,String ip, String page, String sessionId);
	
	public CmsSiteFlow findUniqueByProperties(Integer siteId, String accessDate, String sessionId, String page);

	public int freshCacheToDB(Ehcache cache);
}
