package com.baseballtalk.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class NoticeBoardDTO {
	
	private int board_Num;
	private String category;
	private String title;
	private String writer;
	private String content;
	private String filename;
	private int views;
	private String b_date;

}
