package Student_Management_System;

public class Students {
    int rollNo;
    String name;
    String department;
    String emailId;

   public Students(int rollNo,String name,String department,String emailId){
       this.rollNo=rollNo;
       this.name=name;
       this.department=department;
       this.emailId=emailId;
   }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName(){
       return name;
    }

    public void setName(String name){
       this.name=name;
    }

    public String getDepartment(){
       return department;
    }
    public void setDepartment(String department){
       this.department=department;
    }

    public String getEmailId(){
       return emailId;
    }

    public  void setEmailId(String emailId){
       this.emailId=emailId;
    }
}
