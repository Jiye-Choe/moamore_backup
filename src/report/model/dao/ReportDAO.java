package report.model.dao;

import java.util.HashMap;
import java.util.List;

public interface ReportDAO {
	
	//현재 예산에서 총 사용액
	public int selectOutcomeSumByBudgetId(int num);

	
	//회원의 모든 예산정보를 날짜 내림차순으로 정렬해서 가져오기
	public List selectAllOrderByReg(String id);
	
	//날짜와 예산번호로 지출액 합산
	public int selectOutcomeSumByReg(HashMap map);
}
