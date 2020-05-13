package ca.sheridancollege.beans;

import java.io.Serializable;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Question implements Serializable{

	private static final long serialVersionUID = 8577219507805747135L;
	
	String question, category, answer1, answer2, answer3, answer4, correctAnswer;
	int value;
	
}
