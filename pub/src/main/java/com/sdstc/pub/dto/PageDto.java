package com.sdstc.pub.dto;

import lombok.Data;

@Data
public class PageDto {
	public static Integer DEFAULT_PAGESIZE = 10;
	// 数据总数
	private Integer count;
	// 每页显示数量
	private Integer pageSize;
	// 当前页
	private Integer page;
	// 共几页
	private Integer pages;
	// 起始 limit
	private Integer start;

	public Integer getPages() {
		if (this.pageSize == 0) {
			this.pageSize = DEFAULT_PAGESIZE;
		}
		this.pages = this.count % this.pageSize == 0 ? this.count / this.pageSize : this.count / this.pageSize + 1;
		return this.pages;
	}

	public Integer getStart() {
        if(this.page>this.pages) {
        	this.page=this.pages;
        }
        
        if(this.page==0) {
        	this.page=1;
        }

        this.start=this.pageSize*(this.page-1);
        return this.start;
	}

}
