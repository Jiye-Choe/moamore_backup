package goals.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import goals.model.dao.GoalsDAOImpl;
import goals.model.dto.GoalsDTO;


@Service
public class GoalsServiceImpl implements GoalsService {
	
	@Autowired
	private GoalsDAOImpl goalsDAO = null;
	@Autowired
	public Date date = null;// util.Date

	@Override
	public GoalsDTO selectOne(int goal_no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoalsDTO> selectAllById() throws SQLException {	
		String id = (String)RequestContextHolder.getRequestAttributes().getAttribute("memId", RequestAttributes.SCOPE_SESSION);
		return goalsDAO.selectAllById(id);
	}

	@Override
	public boolean insertGoal(GoalsDTO goal) throws SQLException {
		//아이디, 목표명, 목표액만 받아옴
		//나머지 셋팅
		String id = (String)RequestContextHolder.getRequestAttributes().getAttribute("memId", RequestAttributes.SCOPE_SESSION);
		goal.setId(id);
		goal.setStart_day(new java.sql.Timestamp(date.getTime()));
		goal.setEnd_day(new java.sql.Timestamp(date.getTime()));
		System.out.println(goal.toString());
		boolean ch = goalsDAO.insertGoal(goal);
		
		return ch;
	}

	@Override
	public boolean modifyGoal(GoalsDTO goal) throws SQLException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGoal(int goal_no) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}