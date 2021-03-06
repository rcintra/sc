package com.ccb.br.sc.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.ccb.br.sc.daos.CategoryDao;	
import com.ccb.br.sc.models.Category;	


@Model
@Transactional
public class CategoryController {
	
	@Inject
	private CategoryDao categoryDao;
	private Category category = new Category();
	private List<Category> categoryList = new ArrayList<>();
	
	
	private Integer idToEdit;
	
	public Integer getIdToEdit() {
		return idToEdit;
	}

	public void setIdToEdit(Integer idToEdit) {
		this.idToEdit = idToEdit;
	}
	
	public List<Category> getCategoryList(){
		return this.categoryList;
	}
	
		
	public void setCategory(Category category){
		this.category = category;
	}
	
	public Category getCategory(){
		return this.category;
	}
	
	@PostConstruct
	private void postConstruct() {
		categoryList.addAll(categoryDao.all());
	}	
	
	public void loadDetails(){
		this.category = categoryDao.findById(idToEdit);
	}
	
	public String save() {
		categoryDao.save(category);
		return "/category/list?faces-redirect=true";
	}

	public String update(Integer id) {
		category.setId(id);
		categoryDao.update(category);
		return "/category/list?faces-redirect=true";
	}

	public String remove(Integer id) {
		Category category = categoryDao.findById(id);
		categoryDao.remove(category);
		return "/category/list?faces-redirect=true";
	}		
	
	

}
