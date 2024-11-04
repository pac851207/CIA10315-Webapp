package com.petSitterServiceItem.model;

import java.util.List;

public class PetSitterServiceItemService {

	private PetSitterServiceItemDAO_interface dao;

	public PetSitterServiceItemService() {
		dao = new PetSitterServiceItemJDBCDAO();
	}

	public PetSitterServiceItemVO addPetSitterServiceItem(String svcDescr, String svcName) {

		PetSitterServiceItemVO petSitterServiceItemVO = new PetSitterServiceItemVO();

//		petSitterServiceItemVO.setSvcId(svcId);
		petSitterServiceItemVO.setSvcDescr(svcDescr);
		petSitterServiceItemVO.setSvcName(svcName);
//		empVO.setSal(sal);
//		empVO.setComm(comm);
//		empVO.setDeptno(deptno);
		dao.insert(petSitterServiceItemVO);

		return petSitterServiceItemVO;
	}

	public PetSitterServiceItemVO updatePetSitterServiceItem(Integer svcId, String svcDescr, String svcName) {

		PetSitterServiceItemVO petSitterServiceItemVO = new PetSitterServiceItemVO();

		petSitterServiceItemVO.setSvcId(svcId);
		petSitterServiceItemVO.setSvcDescr(svcDescr);
		petSitterServiceItemVO.setSvcName(svcName);
//		empVO.setHiredate(hiredate);
//		empVO.setSal(sal);
//		empVO.setComm(comm);
//		empVO.setDeptno(deptno);
		dao.update(petSitterServiceItemVO);

		return petSitterServiceItemVO;
	}

	public void deletePetSitterServiceItem(Integer svcId) {
		dao.delete(svcId);
	}

	public PetSitterServiceItemVO getOnePetSitterServiceItem(Integer svcId) {
		return dao.findByPrimaryKey(svcId);
	}

	public List<PetSitterServiceItemVO> getAll() {
		return dao.getAll();
	}
}
