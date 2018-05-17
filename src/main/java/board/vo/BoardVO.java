package board.vo;

import java.util.Date;

public class BoardVO {

	private int board_seq;
	private int pboard_seq;
	private int category_seq;
	private int gruop_seq;
	private String title;
	private String content;
	private String reg_id;
	private Date reg_dt;
	private String del_yn;
	
	
	
	
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public int getPboard_seq() {
		return pboard_seq;
	}
	public void setPboard_seq(int pboard_seq) {
		this.pboard_seq = pboard_seq;
	}
	public int getCategory_seq() {
		return category_seq;
	}
	public void setCategory_seq(int category_seq) {
		this.category_seq = category_seq;
	}
	public int getGruop_seq() {
		return gruop_seq;
	}
	public void setGruop_seq(int gruop_seq) {
		this.gruop_seq = gruop_seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	
	
	
	
}
