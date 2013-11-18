package com.jeecms.cms.action.admin.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeecms.cms.entity.assist.CmsDictionary;
import com.jeecms.cms.entity.main.CmsSite;
import com.jeecms.cms.entity.main.CmsSiteCompany;
import com.jeecms.cms.manager.assist.CmsDictionaryMng;
import com.jeecms.cms.manager.main.CmsLogMng;
import com.jeecms.cms.manager.main.CmsSiteCompanyMng;
import com.jeecms.cms.manager.main.CmsSiteMng;
import com.jeecms.cms.web.CmsUtils;
import com.jeecms.cms.web.WebErrors;
import com.jeecms.core.entity.Ftp;
import com.jeecms.core.manager.FtpMng;

@Controller
public class CmsSiteConfigAct {
	private static final Logger log = LoggerFactory
			.getLogger(CmsSiteConfigAct.class);

	@RequestMapping("/site_config/v_base_edit.do")
	public String baseEdit(HttpServletRequest request, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		List<Ftp> ftpList = ftpMng.getList();
		model.addAttribute("ftpList", ftpList);
		model.addAttribute("cmsSite", site);
		return "site_config/base_edit";
	}

	@RequestMapping("/site_config/o_base_update.do")
	public String baseUpdate(CmsSite bean, Integer uploadFtpId,
			HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateBaseUpdate(bean, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		CmsSite site = CmsUtils.getSite(request);
		bean.setId(site.getId());
		bean = manager.update(bean, uploadFtpId);
		model.addAttribute("message", "global.success");
		log.info("update CmsSite success. id={}", site.getId());
		cmsLogMng.operating(request, "cmsSiteConfig.log.updateBase", null);
		return baseEdit(request, model);
	}
	
	@RequestMapping("/site_config/v_company_edit.do")
	public String companyEdit(HttpServletRequest request, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		CmsSiteCompany company=site.getSiteCompany();
		List<CmsDictionary>scales=dictionaryMng.getList("scale");
		List<CmsDictionary>natures=dictionaryMng.getList("nature");
		List<CmsDictionary>industrys=dictionaryMng.getList("industry");
		model.addAttribute("company", company);
		model.addAttribute("scales", scales);
		model.addAttribute("natures", natures);
		model.addAttribute("industrys", industrys);
		return "site_config/company_edit";
	}
	
	@RequestMapping("/site_config/o_company_update.do")
	public String companyUpdate(CmsSiteCompany company,HttpServletRequest request, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		WebErrors errors = validateCompanyUpdate(site,company, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		siteCompanyMng.update(company);
		model.addAttribute("message", "global.success");
		log.info("update CmsSite success. id={}", site.getId());
		cmsLogMng.operating(request, "cmsSiteConfig.log.updateBase", null);
		return companyEdit(request, model);
	}

	private WebErrors validateBaseUpdate(CmsSite bean,
			HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		return errors;
	}
	
	private WebErrors validateCompanyUpdate(CmsSite site,CmsSiteCompany company,
			HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		if(!company.getId().equals(site.getId())){
			errors.addErrorCode("error.notInSite", CmsSiteCompany.class,company.getId());
		}
		return errors;
	}

	@Autowired
	private FtpMng ftpMng;
	@Autowired
	private CmsLogMng cmsLogMng;
	@Autowired
	private CmsSiteCompanyMng siteCompanyMng;
	@Autowired
	private CmsDictionaryMng dictionaryMng;
	@Autowired
	private CmsSiteMng manager;
}