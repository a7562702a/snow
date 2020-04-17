package net.hb.order;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class GuestDAO implements GuestDAOImp { 
   
	@Autowired
	SqlSessionTemplate temp ;
	
	public void dbInsert(GuestDTO dto) {
	  temp.insert("guest.add", dto); 
	}//end	
	
	public List<GuestDTO> dbSelect( ) {
	   return temp.selectList("guest.selectAll");
	}//end
	
	public int dbCount() {
	  return temp.selectOne("guest.countAll");
	}//end
	
	public GuestDTO dbDetail(int data) {
	 return	temp.selectOne("guest.detail", data);
	}//end
	
}//class END







