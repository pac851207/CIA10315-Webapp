package com.petSitterServiceItem.model;

import java.util.*;

public interface PetSitterServiceItemDAO_interface {
          public void insert(PetSitterServiceItemVO PetSitterServiceItemVO);
          public void update(PetSitterServiceItemVO PetSitterServiceItemVO);
          public void delete(Integer svcId);
          public PetSitterServiceItemVO findByPrimaryKey(Integer svcId);
          public List<PetSitterServiceItemVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<PetSitterServiceItemVO> getAll(Map<String, String[]> map); 
}
