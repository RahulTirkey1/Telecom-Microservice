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
import com.airtel.ui.model.CallDetailsDTO;
import com.airtel.ui.model.CustomerDTO;
import com.airtel.ui.model.FriendDTO;
import com.airtel.ui.model.PlanDTO;
import com.airtel.ui.model.UpdateDTO;
import com.airtel.ui.model.User;


@Controller
public class AirtelUIController 
{
	static String PlanALL_URL="http://localhost:2332/plans/Plandetails/allPlans";
	static String CustomerReg_URL="http://localhost:2332/customers/Customerdetails/register";
	static String CustomerLog_URL="http://localhost:2332/customers/Customerdetails/login";
	static String CustomerProf_URL="http://localhost:2332/customers/Customerdetails/profile/{phoneNo}";
	static String CustomerUpdate_URL="http://localhost:2332/customers/Customerdetails/update";
//	static String CallProf_URL="http://localhost:2332/calls/Calldetails/profile/{phoneNumber}";
	
@Autowired	
RestTemplate restTemplate;

	@GetMapping("/index")
	public String getIndexPage()
	{
		return "index";
	}
	
	@GetMapping("/register")
	public String registeruser(Model model)
	{
		User user=new User();
		PlanDTO dto=new PlanDTO();
		ParameterizedTypeReference<List<PlanDTO>>   typeRef=new ParameterizedTypeReference<List<PlanDTO>>() { };
		ResponseEntity<List<PlanDTO>>   resp=restTemplate.exchange(PlanALL_URL,HttpMethod.GET,null,typeRef);
		dto.setPlanlist(resp.getBody());
//		List<String> list1=new ArrayList<>();
//		for(PlanDTO li:dto.getPlanlist())
//		{
//			
//	       list1.add(li.getPlanId());
//		}
		LinkedHashMap<String,String> lh=new LinkedHashMap<String,String>();
		for(PlanDTO li:dto.getPlanlist())
		{
			lh.put(li.getPlanId(),li.getPlanId());
		}
		user.setPlanList(lh);
		model.addAttribute("user", user);
		return "register";
	}
	
	 @PostMapping("/save")
	 public String saveUser(@ModelAttribute User user,Model model)
	 {
//		String Url_1="http://localhost:2326/Customerdetails/register";
		HttpEntity<User>  entity=new HttpEntity<User>(user);
		ResponseEntity<String>  resp1 = restTemplate.exchange(CustomerReg_URL, HttpMethod.POST, entity,String.class );
		String flag= resp1.getBody();
		if(flag.equalsIgnoreCase("Yes"))
		{
		model.addAttribute("message", "Customer added to the database");
		return "save";
      }
		else
		{
			model.addAttribute("message", "Customer already exists");
			return "register";
		}
	 }
	 
	 @GetMapping("/login")
	 public String loginUser(Model model)
	 {
		 User use=new User();
		 model.addAttribute("use",use);
		 return "login";
	 }
	 
	 @PostMapping("/loginsave")
	 public String logsave(@ModelAttribute User use,Model model,HttpSession session)
	 {
		 
//		 String Url_3="http://localhost:2326/Customerdetails/login";
			HttpEntity<User>  entity=new HttpEntity<User>(use);
			ResponseEntity<String>  resp1 = restTemplate.exchange(CustomerLog_URL, HttpMethod.POST, entity,String.class);
			String flag = resp1.getBody();
			if(flag.contentEquals("Yes"))
			{	
			session.setAttribute("num", use.getPhoneNo());
			User user=new User();
			user.setPhoneNo(use.getPhoneNo());
			model.addAttribute("user",user);
			String msg="Login is Successfull";
			model.addAttribute("message",msg);
			return "loginsave";
			}
			else 
			{
//				String msg="Either the Username or Password is incorrect";
//				model.addAttribute("message",msg);
				return "login";
			}
	 }
	 
	 @GetMapping("/viewprofile")
	 public String profileviewer(@RequestParam Long phoneNo,Model model,HttpSession session)
	 {
		 if(session.getAttribute("num")==null)
		 {
			 return "index";
		 }
		 
		 else
		 {
//		 String Url_4="http://localhost:2326/Customerdetails/profile/{phoneNo}";
		 CustomerDTO dto=restTemplate.getForObject(CustomerProf_URL, CustomerDTO.class,phoneNo);
		 CustomerDTO dt1=new CustomerDTO();
		 PlanDTO plan=new PlanDTO();
		 dt1.setPlanId(dto.getPlanId());
		 dt1.setPhoneNo(dto.getPhoneNo());
		 dt1.setName(dto.getName());
		 dt1.setFriends(dto.getFriends());
		 dt1.setCurrentPlan(dto.getCurrentPlan());
		 plan.setPlanId(dt1.getCurrentPlan().getPlanId());
		 plan.setPlanName(dt1.getCurrentPlan().getPlanName());
		 plan.setValidity(dt1.getCurrentPlan().getValidity());
		 model.addAttribute("planned", plan);
		 model.addAttribute("dt1", dt1);
		 return "viewprofile";
		 }
	 }
	 @GetMapping("/logout")
	 public String loggedOut(HttpSession session)
	 {
		 session.invalidate();
		 return "index";
	 }
	 @GetMapping("/changeplan")
	 public String update(@RequestParam("phoneNo")Long phoneNo,HttpSession session,Model model)
	 {
		 if(session.getAttribute("num")==null)
		 {
			 return "index";
		 }
		 
		 else
		 {
		 UpdateDTO dto1=new UpdateDTO();
			PlanDTO dto=new PlanDTO();
//			String Url_2="http://localhost:2324/Plandetails/allPlans";
			ParameterizedTypeReference<List<PlanDTO>>   typeRef=new ParameterizedTypeReference<List<PlanDTO>>() { };
			ResponseEntity<List<PlanDTO>>   resp=restTemplate.exchange(PlanALL_URL,HttpMethod.GET,null,typeRef);
			dto.setPlanlist(resp.getBody());
		
			LinkedHashMap<String,String> lh=new LinkedHashMap<String,String>();
			for(PlanDTO li:dto.getPlanlist())
			{
				lh.put(li.getPlanId(),li.getPlanId());
			}
			dto1.setPlanList(lh);
			dto1.setPhoneNo(phoneNo);
			model.addAttribute("dto1",dto1);
			return "changeplan";
		 }
	 }
	 
	 @PostMapping("/updated")
	 public String updater(@ModelAttribute UpdateDTO dto1,Model model,HttpSession session)
	 {
		 if(session.getAttribute("num")==null)
		 {
			 return "index";
		 }
		 else
		 {
//			 String Url_5="http://localhost:2326/Customerdetails/update";
				HttpEntity<UpdateDTO>  entity=new HttpEntity<UpdateDTO>(dto1);
				ResponseEntity<String>  resp1 = restTemplate.exchange(CustomerUpdate_URL, HttpMethod.POST, entity, String.class);
				String message=resp1.getBody();
				model.addAttribute("message", message);
				return "loginsave";
			    
		 }
     }
	 
	 @GetMapping("/calldetail")
	 public String call(@RequestParam Long phoneNo,HttpSession session,Model model)
	 {
		 if(session.getAttribute("num")==null)
		 {
			 return "index";
		 }
		 else
		 {
//			 String Url_4="http://localhost:2326/Customerdetails/profile/{phoneNo}";
			 CustomerDTO dto=restTemplate.getForObject(CustomerProf_URL, CustomerDTO.class,phoneNo);
			 List<Long> d1=new ArrayList<>();
			 d1.addAll(dto.getFriends());
			 if(d1.isEmpty())
			 {
				 model.addAttribute("message", "You do not have a friend, hence no call details");
				 return "loginsave";
			 }
			 else
			 {
			 model.addAttribute("friend",d1);
			 return "calldetail";
		     }
		 }
	 }
	 
	 @GetMapping("/CallLog")
	 public String logger(@RequestParam Long phoneNumber,HttpSession session,Model model)
	 {
		 if(session.getAttribute("num")==null)
		 {
			 return "index";
		 }
		 else
		 {
			 String Url_8="http://localhost:2323/Calldetails/profile/{phoneNumber}";
			 ParameterizedTypeReference<List<CallDetailsDTO>> typeRef=new ParameterizedTypeReference<List<CallDetailsDTO>>() { };
				ResponseEntity<List<CallDetailsDTO>> resp=restTemplate.exchange(Url_8,HttpMethod.GET,null,typeRef,phoneNumber);
		        List<CallDetailsDTO> dto=resp.getBody();
		        
			 List<CallDetailsDTO> call=new ArrayList<CallDetailsDTO>();
		
//			 System.out.println(phoneNumber);
			 for(CallDetailsDTO d:dto)
			 {
				 if(d.getCalledTo().equals(session.getAttribute("num")))
				 {
					 System.out.println(d.getCalledTo());
				 call.add(d);
				 }
			 }
			 
			 if(call.isEmpty())
			 {
				 model.addAttribute("message", "There was No call from this number");
				 return "loginsave";
				 
				 
			 }
			 else
			 {
			 model.addAttribute("call", call);
			 return "call-log";
		     }
	      }
	 } 
}