package org.liferayasif.front.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.liferayasif.front.constants.URLConstants;
import org.liferayasif.front.dto.PersonDto;
import org.liferayasif.front.dto.SchoolDto;
import org.liferayasif.front.dto.WiproDto;
import org.liferayasif.front.rest.template.WebRestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/person")
public class ControllerPerson {
	WebRestTemplate webRestTemplate = new WebRestTemplate();
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView findPerson(@ModelAttribute PersonDto personDto)
	{
		ModelAndView mav = new ModelAndView("person-search");
		mav.addObject("person", personDto);
		return mav;
	}
	
	
	@RequestMapping(value="/getPerson", method=RequestMethod.GET)
	public ModelAndView personHome(@RequestParam("id") int id, @ModelAttribute PersonDto personDto)
	{
		ModelAndView mav=new ModelAndView("person-detail");
		
		personDto = webRestTemplate.getForObject(URLConstants.contextPath+"/person/getPersonById?id="+id, PersonDto.class);
		
		mav.addObject("person" ,personDto);
		return mav;
	}
	
	@RequestMapping(value="/feeOfSchool", method=RequestMethod.GET)
	public ModelAndView schoolHome(@ModelAttribute SchoolDto schoolDto)
	{
		
		ModelAndView mav = new ModelAndView("school-search");
		mav.addObject("school" , schoolDto);
		
		return mav;
	}
	
	@RequestMapping(value="/schoolDisplay", method=RequestMethod.GET)
	public ModelAndView schoolDisplay(@RequestParam("fees") int fees, @ModelAttribute SchoolDto schoolDto)
	{
		ModelAndView mav = new ModelAndView("school-display");
		SchoolDto[] schoolDtoArray = webRestTemplate.getForObject(URLConstants.contextPath+"/school/getByFees?fees="+fees, SchoolDto[].class);
		
		List<SchoolDto> schoolDtoList = new ArrayList<SchoolDto>();
		
		if(schoolDtoArray !=null && schoolDtoArray.length > 0){
			schoolDtoList = Arrays.asList(schoolDtoArray);
		}
		
		mav.addObject("school", schoolDto);
		mav.addObject("schoolDtoList", schoolDtoList);
		
		return mav;
				
	}
	

	@RequestMapping(value="wiproClass", method=RequestMethod.GET)
	public ModelAndView wiproHome(@ModelAttribute WiproDto wiproDto)
	{
		ModelAndView mav= new ModelAndView("wipro-input");
		mav.addObject("wipro" , wiproDto);
		
		return mav;
	}
	
	@RequestMapping(value="/wiproResult", method=RequestMethod.GET)
	public ModelAndView wiproResult(@RequestParam("avgSalary") double avgSalary, @ModelAttribute WiproDto wiproDto)
	{
		ModelAndView mav= new ModelAndView("wipro-result");
		WiproDto[] wiproDtoArray = webRestTemplate.getForObject(URLConstants.contextPath+"/wipro/getBySalary?avgSalary="+avgSalary, WiproDto[].class);
	
		List<WiproDto> wiproDtoList=new ArrayList<WiproDto>();
		
		if(wiproDtoArray!=null && wiproDtoArray.length>0)
		{
			wiproDtoList=Arrays.asList(wiproDtoArray);
		}
		
		mav.addObject("wipro" , wiproDto);
		mav.addObject("wiproDtoList" , wiproDtoList);
		
		return mav;
	}
	
}
