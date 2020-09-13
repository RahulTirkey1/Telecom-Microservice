package com.airtel.ui.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.airtel.ui.model.FriendDTO;
import com.airtel.ui.model.PlanDTO;
import com.airtel.ui.model.UpdateDTO;

@Controller
public class AirtelUIController2 
{
	static String CustomerNum_URL="http://localhost:2332/customers/Customerdetails/getnumber";
	static String FriendNum_URL="http://localhost:2332/friends/Frienddetails/{phoneNum}";
	static String PlanALL_URL="http://localhost:2332/plans/Plandetails/allPlans";
	static String FriendAdd_URL="http://localhost:2332/friends/Frienddetails/addfriend";
	static String FriendDel_URL="http://localhost:2332/friends/Frienddetails/deletefriend";
	
@Autowired	
RestTemplate restTemplate;

@GetMapping("/addfriends")
public String friend(@RequestParam Long phoneNum,Model model,HttpSession session)
{
	if(session.getAttribute("num")==null)
	{
		return "index";
	}
	else
	{
//	 String Url_6="http://localhost:2326/Customerdetails/getnumber";
	 List<Long> friend=restTemplate.getForObject(CustomerNum_URL, List.class);
//	 String Url_7="http://localhost:2325/Frienddetails/{phoneNum}";
	 List<Long> friendList=restTemplate.getForObject(FriendNum_URL, List.class,phoneNum);
	 List<Long> list=new ArrayList<>();
	 list=friend;
//	 
//	 System.out.println(friendList);
	 if(friendList.isEmpty())
	 {
		 list=friend;
	 }	 else
	 {
	 for(Long k:friendList)
	 {
//		 list=friend.stream().filter((p)->p!=k.longValue()).collect(Collectors.toList());
		 list.remove(k);
	 }
	 }
	 list.remove(phoneNum);
//	 friend.remove(phoneNum);
	 FriendDTO dto=new FriendDTO();
	 LinkedHashMap<Long,Long> lh=new LinkedHashMap<>();
	 for(Long l:list)
	 {
		lh.put(l, l);
	 }
//	 System.out.println(friend);
	 dto.setFriends(lh);
	 dto.setPhoneNo(phoneNum);
	 model.addAttribute("friend", dto);
    return "getfriend";
	}
}
  @GetMapping("/allplans")
  public String allplan(Model model,HttpSession session)
   {
	  if(session.getAttribute("num")==null)
	  {
		  return "index";
	  }
	  else
	  {
//	String Url_2="http://localhost:2324/Plandetails/allPlans";
	ParameterizedTypeReference<List<PlanDTO>>   typeRef=new ParameterizedTypeReference<List<PlanDTO>>() { };
	ResponseEntity<List<PlanDTO>>   resp=restTemplate.exchange(PlanALL_URL,HttpMethod.GET,null,typeRef);
	List<PlanDTO> list=resp.getBody();
	model.addAttribute("plan1", list);
	return "allplan";
	  }
     }
  
  @PostMapping("/addfriend")
  public String addedfriend(@ModelAttribute FriendDTO friend,Model model,HttpSession session)
  {
	  if(session.getAttribute("num")==null)
	  {
		  return "index";
	  }
	  
	  else
	  {
//		  String Url_5="http://localhost:2325/Frienddetails/addfriend";
			HttpEntity<FriendDTO>  entity=new HttpEntity<FriendDTO>(friend);
			ResponseEntity<String>  resp1 = restTemplate.exchange(FriendAdd_URL, HttpMethod.POST, entity, String.class);
			String message=resp1.getBody();
			model.addAttribute("message", message);
			return "loginsave";
	  }
  }
  @GetMapping("/delete")
  public String getdelete(@RequestParam Long phoneNo,HttpSession session,Model model)
  {
	  if(session.getAttribute("num")==null)
		{
			return "index";
		}
		else
		{
		 
//		 String Url_7="http://localhost:2325/Frienddetails/{phoneNo}";
		 List<Long> friendList=restTemplate.getForObject(FriendNum_URL, List.class,phoneNo);
		 //		 friend.remove(phoneNum);
		 if(friendList.isEmpty())
		 {
			 model.addAttribute("message", "Sorry You do not have a Friend.");
			 return "loginsave";
		 }
		 else
		 {
		 FriendDTO dto=new FriendDTO();
		 LinkedHashMap<Long,Long> lh=new LinkedHashMap<>();
		 for(Long l:friendList)
		 {
			lh.put(l, l);
		 }
//		 System.out.println(friend);
		 dto.setFriends(lh);
		 dto.setPhoneNo(phoneNo);
		 model.addAttribute("deleted", dto);
	    return "delete";
		}
		}
  }
  
  @PostMapping("/deletedfriend")
  public String deletingfriend(@ModelAttribute FriendDTO deleted,Model model,HttpSession session)
  {
	  if(session.getAttribute("num")==null)
	  {
		  return "index";
	  }
	  
	  else
	  {
//		  String Url_5="http://localhost:2325/Frienddetails/deletefriend";
			HttpEntity<FriendDTO>  entity=new HttpEntity<FriendDTO>(deleted);
			ResponseEntity<String>  resp1 = restTemplate.exchange(FriendDel_URL, HttpMethod.POST, entity, String.class);
			String flag=resp1.getBody();
			if(flag.contentEquals("Yes"))
			{
			model.addAttribute("message","Friend number deleted Successfully");
			return "loginsave";
			}
			else
			{
				model.addAttribute("message","Mentioned Friend Number does Not Exist.!!!");
				return "loginsave";
			}
	  }
  }
}
