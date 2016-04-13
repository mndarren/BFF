package com.example.harrison.bffofscsu;

/**
 * Created by Darren on 4/11/2016.
 */
public class ProfessorInfo {

    private String professor_id;
    private String professor_first_name;
    private String professor_last_name;
    private String professor_job_title;
    private String professor_icon;
    private String professor_department;
    private String professor_phone;
    private String professor_office;
    private String professor_email;
    private String professor_website;
    private String professor_degree;
    private String professor_interest;

    public static class Builder{
        private String professor_id = "";
        private String professor_first_name = "";
        private String professor_last_name ="";
        private String professor_job_title = "";
        private String professor_icon = "";
        private String professor_department = "";
        private String professor_phone = "";
        private String professor_office = "";
        private String professor_email = "";
        private String professor_website = "";
        private String professor_degree = "";
        private String professor_interest = "";

        public Builder(){ }
        public Builder id(String i){
            professor_id = i; return this;
        }
        public Builder firstName(String f){
            professor_first_name = f; return this;
        }
        public Builder lastName(String l){
            professor_last_name = l; return this;
        }
        public Builder jobTitle(String job){
            professor_job_title = job; return this;
        }
        public Builder icon(String icon){
            professor_icon = icon; return this;
        }
        public Builder department(String d){
            professor_department = d; return this;
        }
        public Builder phone(String p){
            professor_phone = p; return this;
        }
        public Builder office(String o){
            professor_office = o; return this;
        }
        public Builder email(String e){
            professor_email = e; return this;
        }
        public Builder website(String w){
            professor_website = w; return this;
        }
        public Builder degree(String degree){
            professor_degree = degree; return this;
        }
        public Builder interest(String i){
            professor_interest = i; return this;
        }

        public ProfessorInfo build(){
            return new ProfessorInfo(this);
        }
    }
    private ProfessorInfo(Builder b){
        professor_id = b.professor_id; professor_first_name = b.professor_first_name;
        professor_last_name = b.professor_last_name;professor_job_title = b.professor_job_title;
        professor_department = b.professor_department;professor_phone = b.professor_phone;
        professor_office = b.professor_office;professor_email = b.professor_email;
        professor_website = b.professor_website;professor_degree = b.professor_degree;
        professor_icon = b.professor_icon;professor_interest = b.professor_interest;
    }
    public String getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(String professor_id) {
        this.professor_id = professor_id;
    }

    public String getProfessor_first_name() {
        return professor_first_name;
    }

    public void setProfessor_first_name(String professor_first_name) {
        this.professor_first_name = professor_first_name;
    }

    public String getProfessor_last_name() {
        return professor_last_name;
    }

    public void setProfessor_last_name(String professor_last_name) {
        this.professor_last_name = professor_last_name;
    }

    public String getProfessor_job_title() {
        return professor_job_title;
    }

    public void setProfessor_job_title(String professor_job_title) {
        this.professor_job_title = professor_job_title;
    }

    public String getProfessor_icon() {
        return professor_icon;
    }

    public void setProfessor_icon(String professor_icon) {
        this.professor_icon = professor_icon;
    }

    public String getProfessor_department() {
        return professor_department;
    }

    public void setProfessor_department(String professor_department) {
        this.professor_department = professor_department;
    }

    public String getProfessor_phone() {
        return professor_phone;
    }

    public void setProfessor_phone(String professor_phone) {
        this.professor_phone = professor_phone;
    }

    public String getProfessor_office() {
        return professor_office;
    }

    public void setProfessor_office(String professor_office) {
        this.professor_office = professor_office;
    }

    public String getProfessor_email() {
        return professor_email;
    }

    public void setProfessor_email(String professor_email) {
        this.professor_email = professor_email;
    }

    public String getProfessor_website() {
        return professor_website;
    }

    public void setProfessor_website(String professor_website) {
        this.professor_website = professor_website;
    }

    public String getProfessor_degree() {
        return professor_degree;
    }

    public void setProfessor_degree(String professor_degree) {
        this.professor_degree = professor_degree;
    }

    public String getProfessor_interest() {
        return professor_interest;
    }

    public void setProfessor_interest(String professor_interest) {
        this.professor_interest = professor_interest;
    }

    public static abstract class NewProfessorInfo{

        public static final String PROFESSOR_ID = "professor_id";
        public static final String PROFESSOR_FIRST_NAME = "professor_first_name";
        public static final String PROFESSOR_LAST_NAME = "professor_last_name";
        public static final String PROFESSOR_JOB_TITLE = "professor_job_title";
        public static final String PROFESSOR_ICON = "professor_icon";
        public static final String PROFESSOR_DEPARTMENT = "professor_department";
        public static final String PROFESSOR_PHONE = "professor_phone";
        public static final String PROFESSOR_OFFICE = "professor_office";
        public static final String PROFESSOR_EMAIL = "professor_email";
        public static final String PROFESSOR_WEBSITE = "professor_website";
        public static final String PROFESSOR_DEGREE = "professor_degree";
        public static final String PROFESSOR_INTEREST = "professor_interest";
        public static final String TABLE_NAME = "professor_info";
    }
}
