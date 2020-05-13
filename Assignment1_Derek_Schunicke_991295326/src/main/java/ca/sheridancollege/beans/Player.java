package ca.sheridancollege.beans;

import java.io.Serializable;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Player implements Serializable{
	
	private static final long serialVersionUID = -9116619392021119318L;
	
	private String name;
	private int score;

}
