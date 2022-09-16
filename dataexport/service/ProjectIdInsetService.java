package com.filevine.dataexport.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.domain.ProjectIDInsert;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import util.CommonUtils;

public class ProjectIdInsetService {
 
	
public static void projectDetailsInsert(String databaseName) throws JXLException, IOException {
		
		File file=new File("INPUT\\filevine_project_id.xls");
		String extn=CommonUtils.getExtensionOfFile(file);
		if(!extn.equalsIgnoreCase("xls")){
			System.out.println("Please provide xls file only !!");
			System.exit(0);
		}

		FileInputStream fIn=new FileInputStream("INPUT\\filevine_project_id.xls");
		Workbook  w=Workbook.getWorkbook(fIn);
		Sheet s=w.getSheet(0);
		int rowCount=s.getRows();
		
		ProjectIDInsert project = new ProjectIDInsert();
		
		for(int i=1;i< rowCount;i++){
			try {
			project.setProjectID(s.getCell(0,i).getContents().trim());
			project.setProjectName(s.getCell(1,i).getContents().trim().replace("'", "''"));
			
			ProjectIdDAO.insertProject(project, databaseName);
		
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
