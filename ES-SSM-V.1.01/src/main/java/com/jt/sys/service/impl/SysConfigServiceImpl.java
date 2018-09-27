package com.jt.sys.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysConfigDao;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;

@Service
public class SysConfigServiceImpl  implements SysConfigService {
	@Autowired
	private  SysConfigDao sysConfigDao;
	@Override
	public PageObject<SysConfig> findPageObjects(
			String name,Integer pageCurrent) {
		//1.验证参数的合法性
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("参数不合法");
		//2.基于条件查询总记录数
		int rowCount=sysConfigDao.getRowCount(name);
		if(rowCount==0)
		throw new RuntimeException("没有找到对应记录");
		//3.基于条件查询当前页记录
		int pageSize=2;//页面大小
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysConfig> list=
		sysConfigDao.findPageObjects(name,startIndex,pageSize);
		//计算总页数
		int pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0){
			pageCount++;
		}
		//System.out.println("总页数="+pageCount);
		//System.out.println(list);
		//4.封装数据
		PageObject<SysConfig> pageObject=new PageObject<>();
		pageObject.setRowCount(rowCount);
		pageObject.setPageCount(pageCount);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(list);
		//5.返回数据
		return pageObject;
	}
}
