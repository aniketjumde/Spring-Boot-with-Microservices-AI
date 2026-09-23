package com.tca.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {

	@Id
	private Long bid;
	
	private String bookName;
	
	@ManyToMany(cascade= {
							CascadeType.MERGE,
							CascadeType.PERSIST,
							CascadeType.REFRESH,
							CascadeType.DETACH
					},
				fetch=FetchType.LAZY
				)
	@JoinTable(
				name="BOOK_AUTHOR",
				joinColumns=@JoinColumn(name="BOOK_ID"),
				inverseJoinColumns=@JoinColumn(name="AUTHOR_ID")
			)
	List<Author> authors;
}
