package budget.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import budget.model.dto.BudgetDTO;
import budget.model.dto.BudgetDetailDTO;
import budget.model.dto.NoBudgetDTO;

@Repository
public class RecordBudgetDAOImpl implements RecordBudgetDAO {

	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	// 예산지출 내역 입력
	@Override
	public int insertBudget(BudgetDTO budgetDTO) throws SQLException {

		
		sqlSession.update("record.updateCurrentBudget", budgetDTO);	//총예산 현재값에서 차감

		sqlSession.insert("record.insertBudget", budgetDTO);
		// budget 테이블의 예산 구분번호 리턴(방금 +1된 시퀀스값)
		int budget_outcome_no = budgetDTO.getBudget_outcome_no();
		return budget_outcome_no;
	}
	// 예산 지출 세부내역 입력
	@Override
	public void insertBudgetDetail(BudgetDetailDTO budgetDetailDTO) throws SQLException {
		sqlSession.insert("record.insertBudgetDetail", budgetDetailDTO);
				
	}
	
	@Override
	public List selectAllBudgetByNum(int budgetNum, int startRow, int endRow) throws SQLException {		
		List budgetRecordList = new ArrayList();
		
		Map para = new HashMap();
		System.out.println("DAO에서 startRow : " + startRow);
		System.out.println("DAO에서 endRow : " + endRow);
		para.put("budgetNum", budgetNum);
		para.put("startRow", startRow);
		para.put("endRow", endRow);
		
		budgetRecordList = sqlSession.selectList("record.selectBudgetRecord", para); 
		return budgetRecordList;
	}
	@Override
	public int countAllBudgetByNum(int budgetNum) throws SQLException {
		int count = 0;
		count = sqlSession.selectOne("record.countBudgetRecord", budgetNum);
		return count;
	}
	
	@Override
	public int deleteBudgetRecord(int budget_outcome_no) throws SQLException {
		int result = 0;
		result = sqlSession.delete("record.deleteBudgetRecord", budget_outcome_no);
		return result;
	}
	
	@Override
	public int selectSumFromDateAndCatNo(HashMap map) throws SQLException {
		if(sqlSession.selectOne("record.selectSumFromDateAndCatNo", map)==null) {
			return 0;
		} else {
			return sqlSession.selectOne("record.selectSumFromDateAndCatNo", map);
		}
	}
	
	
	
	

	
}
