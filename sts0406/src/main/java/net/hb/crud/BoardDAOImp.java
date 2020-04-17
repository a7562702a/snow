package net.hb.crud;

import java.util.List;

public interface BoardDAOImp {
		  public void dbInsert(BoardDTO dto); 
		  public List <BoardDTO> dbSelect(int start,int end,String skey,String sval) ;
		  public List <BoardDTO> dbSelect() ;
		  public int dbCount() ;
		  public int dbCount(String skey,String sval) ;
		  public BoardDTO dbDetail(int data);
		  public void dbdelete(int data);
		  public void dbEdit(BoardDTO dto);
}//interface end
