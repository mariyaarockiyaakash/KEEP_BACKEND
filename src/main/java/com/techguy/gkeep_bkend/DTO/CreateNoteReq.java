package com.techguy.gkeep_bkend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CreateNoteReq
{

	private long userId;

	private String title;
	private String description;
	private boolean trashed;
	private String bgColor;
	private String imgUrl;

}
