package com.hrms.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.steps.BaseClass;

public class ViewEmployeePageElements {

	@FindBy(id = "empsearch_employee_name_empName")
	public WebElement empName;

	@FindBy(id = "empsearch_id")
	public WebElement empID;

	@FindBy(id = "searchBtn")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//table[@id = 'resultTable']")
	public WebElement employeesTable;
	
		
	/**
	 * this method will check if employees table is diplayed
	 * @return
	 */
	public boolean isTableDisplayed() {
		return employeesTable.isDisplayed();
	}
	
	
	@FindBy(xpath = "//table[@id = 'resultTable']//tbody/tr/td[3]")
	public List<WebElement> tableFirstName;

	
	public List<Map<String, String>> getFirstNameFromTable() {
		List<Map<String, String>> uiName = new ArrayList<>();
		for (WebElement row : tableFirstName) {
			Map<String, String> storeUiNames = new LinkedHashMap<>();
			String tableName = row.getText();
			storeUiNames.put("emp_firstname", tableName);
			uiName.add(storeUiNames);
		}
		return uiName;
	}
	
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[4]")
	public static List<WebElement> tableLastNames;
	
	
	public static List<Map<String, String>> getLastNamefromTable(){
		
		List<Map<String, String>> uiLastName= new ArrayList<>();
		
		for( WebElement listofLastNames: tableLastNames) {
		Map<String, String> storeLastNames= new LinkedHashMap<>();
		
		String allLastNames=listofLastNames.getText();
		
		storeLastNames.put("emp_lastname", allLastNames);
		uiLastName.add(storeLastNames);
		
		
	}
	return uiLastName;
	
	}
	
	
	

	public ViewEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
