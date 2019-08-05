package com.school.common.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.github.pagehelper.Page;
import com.school.common.utils.PropertieUtil;

/**
 * 分页信息
 */
public class Pager {
	//private int pageSize = Integer.parseInt(PropertieUtil.config.get("page.pageSize"));// 默认每页的行数
	//private int pageNum = Integer.parseInt(PropertieUtil.config.get("page.pageNum")); // 默认当前页
	private int pageSize =5 ;// 默认每页的行数
	private int pageNum = 1; // 默认当前页
    private String sort; //排序字段名字
    private String order; //排序规则
    private String token; //登录令牌
    private String filter; //过滤条件
    private Boolean search; 
    private Object[] params;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token == null ? null : token.trim();
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter == null ? null : filter.trim();
	}
	public Boolean getSearch() {
		return search;
	}
	public void setSearch(Boolean search) {
		this.search = search;
	}
	public Object[] getParams() {
		return params;
	}
	public void setParams(Object[] params) {
		this.params = params;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort == null ? null : sort.trim();
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order == null ? null : order.trim();
	}
	
    public String getOrderBy(){
        if(sort == null || sort.length() == 0){
            return null;
        }
        if(order == null){
        	order = "";
        }
        return " ".concat(sort).concat(" ").concat(order);
    }
    
    /**
     * 功能描述: 驼峰字符串转换成下划线连接<br>
     * 例如: nextValueMySql 转换为 next_value_my_sql
     * @param param
     * @return
     */
    public static String camelVunderline(String param) {
        Pattern p = Pattern.compile("[A-Z]");
        if (param == null || param.equals("")) {
            return "";
        }
        StringBuilder builder = new StringBuilder(param);
        Matcher mc = p.matcher(param);
        int i = 0;
        while (mc.find()) {
            builder.replace(mc.start() + i, mc.end() + i, "_" + mc.group().toLowerCase());
            i++;
        }
        if ('_' == builder.charAt(0)) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }
}
