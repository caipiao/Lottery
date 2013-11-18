package com.jeecms.cms.action.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jeecms.cms.entity.main.CmsSite;
import com.jeecms.cms.entity.main.MarkConfig;
import com.jeecms.cms.web.CmsUtils;
import com.jeecms.common.web.ResponseUtils;
import com.jeecms.core.entity.Ftp;
import com.jeecms.core.web.WebErrors;

/**
 * @author Tom
 * 批量上传图片和附件
 */
@Controller
public class SwfUploadAct extends AbstractUpload {
	private static final Logger log = LoggerFactory
			.getLogger(ImageUploadAct.class);
	/**
	 * 结果页
	 */
	/**
	 * 错误信息参数
	 */
	public static final String ERROR = "error";

	@RequestMapping(value = "/common/o_swfPicsUpload.do", method = RequestMethod.POST)
	public void swfPicsUpload(
			String root,
			Integer uploadNum,
			@RequestParam(value = "Filedata", required = false) MultipartFile file,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		WebErrors errors = validate(file.getOriginalFilename(), file, request);
		if (errors.hasErrors()) {
			model.addAttribute(ERROR, errors.getErrors().get(0));
		}
		CmsSite site = CmsUtils.getSite(request);
		String ctx = request.getContextPath();
		MarkConfig conf = site.getConfig().getMarkConfig();
		Boolean mark = conf.getOn();
		String origName = file.getOriginalFilename();
		String ext = FilenameUtils.getExtension(origName).toLowerCase(
				Locale.ENGLISH);
		String fileUrl;
		if (site.getUploadFtp() != null) {
			Ftp ftp = site.getUploadFtp();
			String ftpUrl = ftp.getUrl();
			if (mark) {
				File tempFile = mark(file, conf);
				fileUrl = ftp.storeByExt(site.getUploadPath(), ext,
						new FileInputStream(tempFile));
				tempFile.delete();
			} else {
				fileUrl = ftp.storeByExt(site.getUploadPath(), ext, file
						.getInputStream());
			}
			// 加上url前缀
			fileUrl = ftpUrl + fileUrl;
		} else {
			if (mark) {
				File tempFile = mark(file, conf);
				fileUrl = fileRepository.storeByExt(site.getUploadPath(), ext,
						tempFile);
				tempFile.delete();
			} else {
				fileUrl = fileRepository.storeByExt(site.getUploadPath(), ext,
						file);
			}
		}

		// 加上部署路径
		fileUrl = ctx + fileUrl;
		log.info("file upload seccess: {}, size:{}.", file
				.getOriginalFilename(), file.getSize());
		ResponseUtils.renderText(response, fileUrl);
	}
	@RequestMapping(value = "/common/o_swfAttachsUpload.do", method = RequestMethod.POST)
	public void swfAttachsUpload(
			String root,
			Integer uploadNum,
			@RequestParam(value = "Filedata", required = false) MultipartFile file,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		System.out.println("111111111111111111111");
		WebErrors errors = validate(file.getOriginalFilename(), file, request);
		if (errors.hasErrors()) {
			System.out.println("22222222222222222");
			model.addAttribute(ERROR, errors.getErrors().get(0));
		}
		System.out.println("333333333333333333333333");
		CmsSite site = CmsUtils.getSite(request);
		String ctx = request.getContextPath();
		String origName = file.getOriginalFilename();
		String ext = FilenameUtils.getExtension(origName).toLowerCase(
				Locale.ENGLISH);
		// TODO 检查允许上传的后缀
		String fileUrl="";
		try {
			if (site.getConfig().getUploadToDb()) {
				String dbFilePath = site.getConfig().getDbFileUri();
				fileUrl = dbFileMng.storeByExt(site.getUploadPath(), ext, file
						.getInputStream());
				// 加上访问地址
				fileUrl = request.getContextPath() + dbFilePath + fileUrl;
			} else if (site.getUploadFtp() != null) {
				Ftp ftp = site.getUploadFtp();
				String ftpUrl = ftp.getUrl();
				fileUrl = ftp.storeByExt(site.getUploadPath(), ext, file
						.getInputStream());
				// 加上url前缀
				fileUrl = ftpUrl + fileUrl;
			} else {
				fileUrl = fileRepository.storeByExt(site.getUploadPath(), ext,
						file);
				// 加上部署路径
				System.out.println("fileUrl="+fileUrl);
				fileUrl = ctx + fileUrl;
			}
			fileMng.saveFileByPath(fileUrl, origName, false);
			model.addAttribute("attachmentPath", fileUrl);
		} catch (IllegalStateException e) {
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			log.error("upload file error!", e);
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
			log.error("upload file error!", e);
		}
		JSONObject data=new JSONObject();
		data.put("attachUrl", fileUrl);
		data.put("attachName", origName);
		ResponseUtils.renderJson(response, data.toString());
	//	ResponseUtils.renderText(response, fileUrl);
	//	ResponseUtils.renderText(response, origName);
	}
}
