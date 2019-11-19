/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: ArticleController.java 
 * @Prject: zhaojian-cms
 * @Package: com.zhaojian.controller 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年11月14日
 * @version: V1.0   
 */
package com.zhaojian.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhaojian.beans.Article;
import com.zhaojian.common.CmsAssert;
import com.zhaojian.service.ArticleService;

/** 
 * @ClassName: ArticleController 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年11月14日 
 */

@RequestMapping("article")
@Controller
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("showdetail")
	public String showDetail(HttpServletRequest request,Integer id) {
		
		Article article = articleService.getById(id); 
		CmsAssert.AssertTrueHtml(article!=null, "文章不存在");
		request.setAttribute("article",article);
		return "article/detail";
		
	}
}