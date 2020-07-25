package com.training.bean;

public class FeaturesBean {
	private String name;
	private String slug;
	private String parentFeature;
	private String description;


	public FeaturesBean() {
	}

	public FeaturesBean(String name, String slug , String description) {
		super();
		this.name = name;
		this.slug = slug;
		//this.parentFeature = parentFeature;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	/*public String getParentFeature() {
		return parentFeature;
	}

	public void setParentFeature(String parentFeature) {
		this.parentFeature = parentFeature;
	}*/
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "LoginBean [name=" + name + ", slug=" + slug + ", description=" + description + "]";
	}


}
