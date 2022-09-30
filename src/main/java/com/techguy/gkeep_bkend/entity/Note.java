package com.techguy.gkeep_bkend.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Note
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long userId;
	private String title;
	private String description;
	private LocalDateTime createdOn;
	private boolean trashed;
	private String bgColor;
	private String imgUrl;

}
