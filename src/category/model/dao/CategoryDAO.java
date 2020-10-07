package category.model.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CategoryDAO {

	//회원 한 명의 카테고리 전체 가져오기
	public List selectAllById(String id) throws SQLException;
	//카테고리 이름과 아이디로 해당 고유번호 반환
	public int selectNumByName(String name, String id) throws SQLException;
	//기본카테고리 설정(회원가입할때 자동으로)
	public void insertCategory(String id) throws SQLException;
	//회원 한명의  수입 카테고리 전체 가져오기
	public List selectAllIncomeCategoryById(String id) throws SQLException;
	//지출 기본카테고리 설정(회원가입할때 자동으로)
	public void outcomeInsertCategory(String id) throws SQLException;
	//수입 기본카테고리 설정(회원가입할때 자동으로)
	public void incomeInsertCategory(String id) throws SQLException;
	//수입 카테고리 추가하기
	public void addIncomeCategory(String category_name,String id) throws SQLException;
	//지출 카테고리 추가하기
	public void addOutcomeCategory(String category_name,String id) throws SQLException;
	//지출 카테고리 이름 수정하기
	public void updateoutcomeCategory(int category_no, String newName,String id) throws SQLException;
	

	
	
	
	
}
