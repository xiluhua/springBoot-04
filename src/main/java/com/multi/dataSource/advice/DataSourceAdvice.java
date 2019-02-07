package com.multi.dataSource.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import com.multi.dataSource.DataSourceContextHolder;
import com.multi.dataSource.MultiDataSource;

public class DataSourceAdvice implements MethodBeforeAdvice,AfterReturningAdvice
{

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		DataSourceContextHolder.clearDataSourceType();
	}

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
	
		int id = (int)args[0];
		System.out.println(DataSourceAdvice.class+": "+id);
		if (id % 2 == 0) {
			DataSourceContextHolder.setDataSourceType(MultiDataSource.dataSource2);
		}else {
			DataSourceContextHolder.setDataSourceType(MultiDataSource.dataSource1);
		}
	}
}
