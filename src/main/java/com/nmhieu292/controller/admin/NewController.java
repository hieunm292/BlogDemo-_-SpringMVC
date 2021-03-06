package com.nmhieu292.controller.admin;

import com.nmhieu292.dto.NewDTO;
import com.nmhieu292.service.ICategoryService;
import com.nmhieu292.service.INewService;
import com.nmhieu292.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "newControllerOfAdmin")
public class NewController {
	
	@Autowired
	private INewService newService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
			public ModelAndView showList(@RequestParam("page") int page,@RequestParam("limit") int limit,HttpServletRequest request) {
		NewDTO model=new NewDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/new/list");
		Pageable pageable=new PageRequest(page-1, limit);
		model.setListResult(newService.findAll(pageable));
		model.setTotalItem((int) newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));

		if(request.getParameter("message")!=null){
//			if(request.getParameter("message").equals("update_success")){
//				mav.addObject("message","Update Success");
//				mav.addObject("alert","cussess");
//
//			}else if(request.getParameter("message").equals("insert_success")){
//				mav.addObject("message","Insert Success");
//				mav.addObject("alert","cussess");
//
//			}else if(request.getParameter("message").equals("error_system")){
//				mav.addObject("message","Error System, Call Devs Now biatch! ");
//				mav.addObject("alert","danger");
//			}
			Map<String,String> message=messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message",message.get("message"));
			mav.addObject("alert",message.get("alert"));
		}

		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/new/edit");

		NewDTO model=new NewDTO();
		if (id != null) { //cap nhat bai viet
			model = newService.findById(id);
		}
		if(request.getParameter("message")!=null){
			Map<String,String> message=messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message",message.get("message"));
			mav.addObject("alert",message.get("alert"));

		}
		mav.addObject("model",model);
		mav.addObject("categories",categoryService.findAll());
		return mav;
	}
}
