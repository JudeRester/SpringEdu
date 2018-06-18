package com.kh.myapp.bbs.criteria;

public class RecordCriteria {
	private int currPage; // 요청페이지
	private int numPerPage; // 한 페이지에 보여줄 레코드수

	public RecordCriteria() {
	} // 디폴트생성자

	public RecordCriteria(int reqPage) {
		this.currPage = reqPage;
		this.numPerPage = 10;
	}

	public RecordCriteria(int reqPage, int numPerPage) {
		this.currPage = reqPage;
		this.numPerPage = numPerPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int reqPage) {
		if (reqPage <= 0) {
			this.currPage = 1;
			return;
		}
		this.currPage = reqPage;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		// 한페이지에 보여줄 목록수는 최소 1~100
		/*
		 * if(numPerPage <=0 || numPerPage > 100) { this.numPerPage = 10; return; }
		 */
		this.numPerPage = numPerPage;
	}

	// 시작 레코드 계산 = ((요청페이지-1) * 한 페이지에 보여줄 레코드수) +1
	public int getStartRecord() {
		return ((this.currPage - 1) * this.numPerPage) + 1;
	}

	// 종료 레코드 계산 = 시작레코드 + 한 페이지에 보여줄 레코드수 -1 or
	// 요청페이지 * 한페이지에 보여줄 레코드수
	public int getEndRecord() {
		// return this.getStartRecord() + this.numPerPage - 1;
		return this.currPage * this.numPerPage;
	}

	@Override
	public String toString() {
		return "PageCriteria [reqPage=" + currPage + ", numPerPage=" + numPerPage + "]";
	}

}