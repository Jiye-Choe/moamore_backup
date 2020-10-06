package goals.model.dao;

import java.sql.SQLException;
import java.util.List;

import goals.model.dto.GoalsDTO;

public interface GoalsDAO {

	//CRUD
	
	//목표 하나가져오기
	public GoalsDTO selectOne(int goal_no) throws SQLException;
	
	//아이디로 목표 전체 가져오기
	public List<GoalsDTO> selectAllById(String id) throws SQLException;
	
	//삽입
	public boolean insertGoal(GoalsDTO goal) throws SQLException;
	
	//수정
	public boolean modifyGoal(GoalsDTO goal) throws SQLException;
	
	//삭제
	public boolean deleteGoal(int goal_no) throws SQLException;
	
	
}