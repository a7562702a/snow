package net.hb.crud;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO implements BoardDAOImp {
	  
 @Autowired
	  SqlSessionTemplate temp;
      //model 1 = ����� temp �ʵ�� board.xml���� ����
  public void dbInsert(BoardDTO dto) {//Model 1 = �����(controller �����  xml ����)
	 temp.insert("board.add",dto);
  }//end
  
  public List <BoardDTO>dbSelect() {
	  return temp.selectList("board.selectAll");
  }//end
  
  public List <BoardDTO>dbSelect(int start,int end,String skey,String sval) {
	  BoardDTO dto=new BoardDTO();
	  dto.setStart(start);
	  dto.setEnd(end);
	  dto.setSkey(skey);
	  dto.setSval(sval);
	  return temp.selectList("board.selectAll",dto);
  }//end
  
  public int dbCount() {
	  return temp.selectOne("board.countAll1");
  }//end
  
  public int dbCount(String skey,String sval) {
	  BoardDTO dto=new BoardDTO();
	  dto.setSkey(skey);
	  dto.setSval(sval);
	  return temp.selectOne("board.countAll",dto);
  }//end
  
  public BoardDTO dbDetail(int data) {
	return temp.selectOne("board.detail",data);
  }
  
  public void dbdelete(int data) {
	  temp.delete("board.del",data);
  }
  
  public void dbEdit(BoardDTO dto) {
	   temp.update("board.edit",dto);
  }
}//class end