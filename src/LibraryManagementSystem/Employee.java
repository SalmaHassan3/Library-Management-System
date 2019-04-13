
package LibraryManagementSystem;

import static LibraryManagementSystem.LibrarySystem.jTable11;
import static LibraryManagementSystem.LibrarySystem.jTable5;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Employee extends Person {
    
    private float salary;
    private String departmentName;
    
      static void edit(List<Employee> employees,String name){
       
       Employee employee=search(employees,name);
       employee.setName(AddEmployeeFrame.getjTextField9().getText());
       employee.setId(Integer.parseInt(AddEmployeeFrame.getjTextField7().getText()));
       employee.setSalary(Float.parseFloat(AddEmployeeFrame.getjTextField8().getText()));
      
      }
    
     static void display(List<Employee> employees){
          DefaultTableModel model5 = (DefaultTableModel) LibrarySystem.jTable5.getModel();
       int no=jTable5.getRowCount();
        for (int i = 0; i <no; i++) {
            model5.removeRow(0);
            model5.setRowCount(jTable5.getRowCount() + 1);}
        int row=0;
       for(Employee employee : employees){
       jTable5.getModel().setValueAt(employee.getName(),row, 0);   
       jTable5.getModel().setValueAt(employee.getId(),row, 1);
      jTable5.getModel().setValueAt(employee.salary,row, 2);
      jTable5.getModel().setValueAt(employee.departmentName,row, 3);
       
       model5.setRowCount(jTable5.getRowCount()+1); 
        
         row++;
       }
    }         
     
     
   
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
     

   public static void add(List<Employee> employees) {
      Employee newEmployee=new Employee(); 
       newEmployee.setName(AddEmployeeFrame.getjTextField9().getText());
       newEmployee.setId(Integer.parseInt(AddEmployeeFrame.getjTextField7().getText()));
       newEmployee.setSalary(Float.parseFloat(AddEmployeeFrame.getjTextField8().getText()));
       newEmployee.setDepartmentName(AddEmployeeFrame.getjTextField10().getText());
      
        
         Department department=Department.search(LibrarySystem.departments,AddEmployeeFrame.getjTextField10().getText());
       if(department==null)
       {
           JOptionPane.showMessageDialog(null,"The department of this employee is not found NOT found");
           AddEmployeeFrame.jButton1.setEnabled(false);
       } else {
           department.employees.add(newEmployee);
           employees.add(newEmployee);}
    }
   public static Employee search(List<Employee>employees,String name) {
        for(int i=0;i<employees.size();i++){
           
           if(employees.get(i).getName().equalsIgnoreCase(name)){
               return employees.get(i);              
           }
        }
        return null;
    }
        
    public static void delete(List<Employee>employees,String name){
        Employee employee=search(employees,name);
        if(employee==null)
              JOptionPane.showMessageDialog(null,"Employee NOT found");
        else{
       employees.remove(employee);
       Department department;
      department=Department.search(LibrarySystem.departments,employee.getDepartmentName());
      department.media.remove(employee);
    }
    }

  
}
