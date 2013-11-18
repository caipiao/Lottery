package com.jeecms.cms.manager.main;

import javax.servlet.http.HttpServletRequest;

import com.jeecms.cms.entity.main.CmsLog;
import com.jeecms.cms.entity.main.CmsUser;
import com.jeecms.common.page.Pagination;

public interface CmsLogMng {
	public Pagination getPage(Integer category, Integer siteId,
			String username, String title, String ip, int pageNo, int pageSize);

	public CmsLog findById(Integer id);

	public CmsLog operating(HttpServletRequest request, String title,
			String content);

	public CmsLog loginFailure(HttpServletRequest request, String title,
			String content);

	public CmsLog loginSuccess(HttpServletRequest request, CmsUser user,
			String title);

	public CmsLog save(CmsLog bean);

	public CmsLog deleteById(Integer id);

	public CmsLog[] deleteByIds(Integer[] ids);

	public int deleteBatch(Integer category, Integer siteId, Integer days);
}