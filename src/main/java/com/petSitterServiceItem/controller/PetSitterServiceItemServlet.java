
package com.petSitterServiceItem.controller;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.petSitterServiceItem.model.PetSitterServiceItemService;
import com.petSitterServiceItem.model.PetSitterServiceItemVO;

@WebServlet("/back-end/petSitterServiceItem/petSitterServiceItem.do")
public class PetSitterServiceItemServlet extends HttpServlet{


	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("svcId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入服務項目編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/petSitterServiceItem/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer svcId = null;
				try {
					svcId = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("服務項目編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/petSitterServiceItem/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				PetSitterServiceItemService petSitterServiceItemSvc = new PetSitterServiceItemService();
				PetSitterServiceItemVO petSitterServiceItemVO = petSitterServiceItemSvc.getOnePetSitterServiceItem(svcId);
				if (petSitterServiceItemVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/petSitterServiceItem/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("petSitterServiceItemVO", petSitterServiceItemVO); // 資料庫取出的PetGroomerVO物件,存入req
				String url = "/back-end/petSitterServiceItem/listOnePetSitterServiceItem.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer svcId = Integer.valueOf(req.getParameter("svcId"));
//				String svcDescr = req.getParameter("svcDescr");
//		        String svcName = req.getParameter("svcName");
		        
				/***************************2.開始查詢資料****************************************/
				PetSitterServiceItemService petSitterServiceItemSvc = new PetSitterServiceItemService();
				PetSitterServiceItemVO petSitterServiceItemVO = petSitterServiceItemSvc.getOnePetSitterServiceItem(svcId);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("petSitterServiceItemVO", petSitterServiceItemVO);         // 資料庫取出的PetGroomerVO物件,存入req
				String url = "/back-end/petSitterServiceItem/update_petSitterServiceItem_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				
				successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_eve_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer svcId = Integer.valueOf(req.getParameter("svcId").trim());
			String svcDescr = req.getParameter("svcDescr");
			
			
			String svcName = req.getParameter("svcName");
			String svcNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,30}$";
			if (svcName == null || svcName.trim().length() == 0) {
				errorMsgs.add("服務名稱: 請勿空白");
			} else if (!svcName.trim().matches(svcNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("服務名稱: 只能是中、英文字母、數字和_ , 且長度必需在1到30之間");
			}
//
//			String content = req.getParameter("content").trim();
//			if (content == null || content.trim().length() == 0) {
//				errorMsgs.add("內容請勿空白");
//			}

//			Timestamp created = Timestamp.valueOf(req.getParameter("created").trim());
//			Timestamp updated = Timestamp.valueOf(req.getParameter("updated").trim());

//			Integer inftype = null;
//			try {
//				inftype = Integer.valueOf(req.getParameter("inftype").trim());
//			} catch (NumberFormatException e) {
//				inftype = 0;
//				errorMsgs.add("活動公告類型請填數字, 0: 最新消息 1: 常問QA 2. 專欄文章");
//			}

			


			PetSitterServiceItemVO petSitterServiceItemVO = new PetSitterServiceItemVO();
			petSitterServiceItemVO.setSvcId(svcId);
			petSitterServiceItemVO.setSvcDescr(svcDescr);
			petSitterServiceItemVO.setSvcName(svcName);
//			eveVO.setCreated(created);
//			eveVO.setUpdated(updated);
//			eveVO.setInftype(inftype);
			

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("petSitterServiceItemVO", petSitterServiceItemVO); // 含有輸入格式錯誤的eveVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/petSitterServiceItem/update_petSitterServiceItem_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			PetSitterServiceItemService petSitterServiceItemSvc = new PetSitterServiceItemService();
			petSitterServiceItemSvc.updatePetSitterServiceItem(svcId, svcDescr, svcName);
			petSitterServiceItemVO = petSitterServiceItemSvc.getOnePetSitterServiceItem(svcId);
			
			

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("petSitterServiceItemVO", petSitterServiceItemVO); // 資料庫update成功後,正確的的eveVO物件,存入req
			String url = "/back-end/petSitterServiceItem/listOnePetSitterServiceItem.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneeve.jsp
			successView.forward(req, res);
		}

		
		if ("insert".equals(action)) { // 來自addeve.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			
			String svcDescr = req.getParameter("svcDescr");
			String svcName = req.getParameter("svcName");
			String svcNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{0,30}$";
			if (svcName == null || svcName.trim().length() == 0) {
				errorMsgs.add("服務名稱: 請勿空白");
			} else if (!svcName.trim().matches(svcNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("活動公告標題: 只能是中、英文字母、數字和_ , 且長度必需在0到30之間");
			}

//			String content = req.getParameter("content").trim();
//			if (content == null || content.trim().length() == 0) {
//				errorMsgs.add("內容請勿空白");
//			}
			
//			Integer svcDescr = null;
//			try {
//				svcDescr = Integer.valueOf(req.getParameter("svcDescr").trim());
//			} catch (NumberFormatException e) {
//				svcDescr = 0;
//				errorMsgs.add("活動公告類型請填數字, 0: 最新消息 1: 常問QA 2. 專欄文章");
//			}

			

			PetSitterServiceItemVO petSitterServiceItemVO = new PetSitterServiceItemVO();
//			petSitterServiceItemVO.setSvcId(svcId);
			petSitterServiceItemVO.setSvcDescr(svcDescr);
			petSitterServiceItemVO.setSvcName(svcName);
			

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("petSitterServiceItemVO", petSitterServiceItemVO); // 含有輸入格式錯誤的eveVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/petSitterServiceItem/addPetSitterServiceItem.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			PetSitterServiceItemService petSitterServiceItemSvc = new PetSitterServiceItemService();
			petSitterServiceItemVO = petSitterServiceItemSvc.addPetSitterServiceItem(svcDescr, svcName);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/petSitterServiceItem/listAllPetSitterServiceItem.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAlleve.jsp
			successView.forward(req, res);
		}

		
		
		
		
		
		
		if ("delete".equals(action)) { // 來自listAllPg.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer svcId = Integer.valueOf(req.getParameter("svcId"));
				
				/***************************2.開始刪除資料***************************************/
				PetSitterServiceItemService petSitterServiceItemSvc = new PetSitterServiceItemService();
				petSitterServiceItemSvc.deletePetSitterServiceItem(svcId);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back-end/petSitterServiceItem/listAllPetSitterServiceItem.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
		
		
		
		
	}
}


