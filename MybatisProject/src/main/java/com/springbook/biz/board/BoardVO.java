package com.springbook.biz.board;

import java.sql.Date;


	public class BoardVO {
		private int seq;
		   private String title;
		   private String writer;
		   private String content;
		   private Date regDate;
		   private int cnt;
		   private String searchCondition;
		   private String searchKeyword;
		   
	/**
		 * @return the seq
		 */
		public int getSeq() {
			return seq;
		}

		/**
		 * @param seq the seq to set
		 */
		public void setSeq(int seq) {
			this.seq = seq;
		}

		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @param title the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}

		/**
		 * @return the writer
		 */
		public String getWriter() {
			return writer;
		}

		/**
		 * @param writer the writer to set
		 */
		public void setWriter(String writer) {
			this.writer = writer;
		}

		/**
		 * @return the content
		 */
		public String getContent() {
			return content;
		}

		/**
		 * @param content the content to set
		 */
		public void setContent(String content) {
			this.content = content;
		}

		/**
		 * @return the regDate
		 */
		public Date getRegDate() {
			return regDate;
		}

		/**
		 * @param regDate the regDate to set
		 */
		public void setRegDate(Date regDate) {
			this.regDate = regDate;
		}

		/**
		 * @return the cnt
		 */
		public int getCnt() {
			return cnt;
		}

		/**
		 * @param cnt the cnt to set
		 */
		public void setCnt(int cnt) {
			this.cnt = cnt;
		}

		/**
		 * @return the searchCondition
		 */
		public String getSearchCondition() {
			return searchCondition;
		}

		/**
		 * @param searchCondition the searchCondition to set
		 */
		public void setSearchCondition(String searchCondition) {
			this.searchCondition = searchCondition;
		}

		/**
		 * @return the searchKeyword
		 */
		public String getSearchKeyword() {
			return searchKeyword;
		}

		/**
		 * @param searchKeyword the searchKeyword to set
		 */
		public void setSearchKeyword(String searchKeyword) {
			this.searchKeyword = searchKeyword;
		}

	@Override	   
	public String toString(){
		return "BoardVO [seq=" + seq + ", title = " + title + " , writer = " + writer + ", content = " + content + ",regDate = " + regDate + ", cnt = " + cnt + "]";
		
		
	}
		
	}

