package com.QLKTX.Entity;

public class SinhVienTheoPhong {
	  private String id;
	    private String name;
	    private String dob;
	    private String gender;

	    public SinhVienTheoPhong(String id, String name, String dob, String gender) {
	        this.id = id;
	        this.name = name;
	        this.dob = dob;
	        this.gender = gender;
	    }

	    // Getters và Setters
	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDob() {
	        return dob;
	    }

	    public void setDob(String dob) {
	        this.dob = dob;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }
}
