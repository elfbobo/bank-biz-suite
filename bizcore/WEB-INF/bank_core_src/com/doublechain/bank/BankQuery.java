package com.doublechain.bank;

import com.skynet.infrastructure.graphservice.BaseQuery;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BankQuery extends BaseQuery {
	
	public BankQuery(Class startType, String pStart) {
        super(startType, pStart);
        super.setProject("bank");
  }

  public BankQuery(Object start){
    this(start.getClass(), getId(start));
  }

  private static String getId(Object pStart) {
      BeanWrapper bw = new BeanWrapperImpl(pStart);
      return String.valueOf(bw.getPropertyValue("id"));
  }
}













