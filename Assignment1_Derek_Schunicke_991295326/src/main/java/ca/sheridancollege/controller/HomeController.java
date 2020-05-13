package ca.sheridancollege.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Player;
import ca.sheridancollege.beans.Question;
import ca.sheridancollege.databaseAccess.DatabaseAccess;

@Controller
public class HomeController {
	
	@Autowired
	DatabaseAccess da;

	@GetMapping("/") //home page
	public String goHome() {
		
		return "index.html";
		
	}
	
	@GetMapping("/pickCatagory") //category selection page
	public String pickQuestion(HttpSession session, @RequestParam String name) {
		
		Player player = new Player();
		player.setName(name);
		player.setScore(0);
		session.setAttribute("player", player);
		
		
		
		return "pickCatagory.html";
		
	}
	
	@GetMapping("/answerQuestion") //answer selected question page
	public String answerQuestion(HttpSession session, @RequestParam String category, @RequestParam int value) {
		
		Question ques = da.getQuestion(category, value);
		
		session.setAttribute("question", ques);
		
		return "answerQuestion.html";
		
	}
	
	@GetMapping("/evaluateQuestion") //evaluating the users answer
	public String evaluateQuestion(HttpSession session, @RequestParam("answer") String choice,
			Model model) {
		
		Player player = (Player)session.getAttribute("player");
		Question ques = (Question)session.getAttribute("question");
		model.addAttribute(ques);
		if(choice.equals(ques.getCorrectAnswer()))
			player.setScore(player.getScore() + ques.getValue());
		
		else
			player.setScore(player.getScore() - ques.getValue());
		
		return "pickCatagory.html";
		
	}
	
}
