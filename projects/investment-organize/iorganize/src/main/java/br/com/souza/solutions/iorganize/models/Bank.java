package br.com.souza.solutions.iorganize.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 20, nullable = false)
	private String name;
	
	@Column(unique = true, length = 20)
	private String number;

	private Boolean status;
}
