package com.kh.myapp.bbs.criteria;

import lombok.Data;

@Data
public class FindCriteria extends RecordCriteria {
	private String keyword;
	private String option;

	public FindCriteria(int currPage, String option, String keyword) {
		super(currPage);
		this.option = option;
		this.keyword = keyword;
	}

}
