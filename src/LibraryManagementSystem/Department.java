
package LibraryManagementSystem;

import static LibraryManagementSystem.LibrarySystem.jTable1;
import static LibraryManagementSystem.LibrarySystem.jTable10;
import static LibraryManagementSystem.LibrarySystem.jTable11;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import static LibraryManagementSystem.LibrarySystem.jTable6;
import static LibraryManagementSystem.LibrarySystem.jTable8;
import javax.swing.JOptionPane;

public class Department extends Entity {
  private int number;
   List<Employee> employees=new ArrayList<>();
   List<Book> books=new ArrayList<>();
   List<Media> media=new ArrayList<>();
   
    static void edit(List<Department> departments,String name){
       
        Department department=search(departments,name);
      department.setName(AddDepartmentFrame.getjTextField1().getText());
       department.setNumber(Integer.parseInt(AddDepartmentFrame.getjTextField2().getText()));}
  
  static void display(List<Department> departments){
       DefaultTableModel model6 = (DefaultTableModel) LibrarySystem.jTable6.getModel();
       int no=jTable6.getRowCount();
        for (int i = 0; i <no; i++) {
            model6.removeRow(0);
            model6.setRowCount(jTable6.getRowCount() + 1);}
        int row=0;
        for(Department department : departments){
        jTable6.getModel().setValueAt(department.getName(), row, 0);   
        jTable6.getModel().setValueAt(department.number , row, 1);
      
      
       model6.setRowCount(jTable6.getRowCount()+1); 
        
         row++;
       }
    }
  
  static void displayBooks(List<Department> departments,String departmentname){
      
      
       List<Book> depBooks=  new ArrayList<>();
         for(Department department:departments){
           
           if(department.getName().equalsIgnoreCase(departmentname)){
                     depBooks=department.books;
                     // System.out.println(""+department.getName());
                     // System.out.println(""+department.books.get(0).getName());
                     // System.out.println(""+ department.books.get(1).getName());}}
           }}    
        DefaultTableModel model8 = (DefaultTableModel) LibrarySystem.jTable8.getModel();
        int no=jTable8.getRowCount();
        for (int i = 0; i <no; i++) {
            model8.removeRow(0);
            model8.setRowCount(jTable8.getRowCount() + 1);
        }
       int row=0;
       for(Book book:depBooks){
      jTable8.getModel().setValueAt(book.getName(), row, 0);
     // System.out.println(""+ book.getName());
      jTable8.getModel().setValueAt(book.getNumber() , row, 1);
      jTable8.getModel().setValueAt(book.isAvaliable(), row, 2);
       jTable8.getModel().setValueAt(book.getAuthor(), row, 3);
       jTable8.getModel().setValueAt(book.getNumberOfPages(), row, 4);
      jTable8.getModel().setValueAt(book.getPrice(), row, 5);
     
       model8.setRowCount(jTable8.getRowCount()+1);
        row++;
       }
    }
  
   static void displayMedia(List<Department> departments,String departmentname){
       List<Media> departmentMedia=  new ArrayList<>();
         for(Department department:departments){
           if(department.getName().equalsIgnoreCase(departmentname)){
                     departmentMedia=department.media;}}          
        DefaultTableModel model11 = (DefaultTableModel) LibrarySystem.jTable11.getModel();
        int no=jTable11.getRowCount();
        for (int i = 0; i <no; i++) {
            model11.removeRow(0);
            model11.setRowCount(jTable11.getRowCount() + 1);}
      int row=0;
      for(Media media:departmentMedia){
      jTable11.getModel().setValueAt(media.getName(), row, 0);
      jTable11.getModel().setValueAt(media.getNumber() , row, 1);
      jTable11.getModel().setValueAt(media.getType(), row, 2);
      model11.setRowCount(jTable11.getRowCount()+1);
        row++;}}
   

    static void displayEmployees(List<Department> departments,String departmentname){
       List<Employee> departmentEmployees=  new ArrayList<>();
         for(Department department:departments){
           if(department.getName().equalsIgnoreCase(departmentname)){
                     departmentEmployees=department.employees;}}          
        DefaultTableModel model10 = (DefaultTableModel) LibrarySystem.jTable10.getModel();
        int no=jTable10.getRowCount();
        for (int i = 0; i <no; i++) {
            model10.removeRow(0);
            model10.setRowCount(jTable10.getRowCount() + 1);}
      int row=0;
      for(Employee employee:departmentEmployees){
      jTable10.getModel().setValueAt(employee.getName(), row, 0);
      jTable10.getModel().setValueAt(employee.getId() , row, 1);
      jTable10.getModel().setValueAt(employee.getSalary(), row, 2);
      model10.setRowCount(jTable11.getRowCount()+1);
        row++;}}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
  
   public static void add(List<Department> departments) {
        Department newDepartment=new Department();
         newDepartment.setName(AddDepartmentFrame.getjTextField1().getText());
        newDepartment.setNumber(Integer.parseInt(AddDepartmentFrame.getjTextField2().getText()));
         departments.add(newDepartment);
      
    }
  public static Department search(List<Department> departments,String name) {
        for(int i=0;i<departments.size();i++){
           
           if(departments.get(i).getName().equalsIgnoreCase(name)){
               return departments.get(i);              
           }
        }
        return null;
    }
        
     public static void delete(List<Department> departments,String name){
        Department department=search(departments,name);
        if(department==null)
              JOptionPane.showMessageDialog(null,"Department NOT found");
        else{
       
       for(Book book:department.books){
           for(Book book1:LibrarySystem.books){
               if(book1.getName().equals(book.getName()))
                   LibrarySystem.books.remove(book1);
           }
       }
        
         for(Media media:department.media){
           for(Media media1:LibrarySystem.media){
               if(media1.getName().equals(media.getName()))
                   LibrarySystem.media.remove(media1);
           }
       }
          for(Employee employee:department.employees){
           for(Employee employee1:LibrarySystem.employees){
               if(employee1.getName().equals(employee.getName()))
                   LibrarySystem.employees.remove(employee1);
           }
       }
        departments.remove(department);
    }
    }
     static void deleteBook(List<Department> departments,List<Book>books,String selectedDepartment,String selectedBook){
       Department department=search(departments,selectedDepartment );
       Book book=Book.search(department.books, selectedBook);
       department.books.remove(book);
       books.remove(book);
    }
    static void deleteMedia(List<Department> departments,List<Media>medias,String selectedDepartment,String selectedMedia){
       Department department=search(departments,selectedDepartment );
       Media media=Media.search(department.media, selectedMedia);
       department.media.remove(media);
      medias.remove(media);
    }
    static void deleteEmployee(List<Department> departments,List<Employee>employees,String selectedDepartment,String selectedEmployee){
       Department department=search(departments,selectedDepartment );
       Employee employee=Employee.search(department.employees, selectedEmployee);
       department.employees.remove(employee);
     employees.remove(employee);
    }
    static void addBook(List<Department> departments,String selectedDepartment){
        Department department=Department.search(departments, selectedDepartment);
        Book newBook =new Book(); 
       newBook.setName(AddBookFrame.getjTextField1().getText());
       newBook.setNumber(Integer.parseInt(AddBookFrame.getjTextField2().getText()));
       newBook.setAuthor(AddBookFrame.getjTextField3().getText());
       newBook.setNumberOfPages(Integer.parseInt(AddBookFrame.getjTextField4().getText()));
       newBook.setPrice(Float.parseFloat(AddBookFrame.getjTextField5().getText()));
       newBook.setDepartmentName( selectedDepartment);
        newBook.setAvaliable(true);
        department.books.add(newBook);
        LibrarySystem.books.add(newBook);
    }
     static void addEmployee(List<Department> departments,String selectedDepartment){
        Department department=Department.search(departments, selectedDepartment);
         Employee newEmployee=new Employee(); 
       newEmployee.setName(AddEmployeeFrame.getjTextField9().getText());
       newEmployee.setId(Integer.parseInt(AddEmployeeFrame.getjTextField7().getText()));
       newEmployee.setSalary(Float.parseFloat(AddEmployeeFrame.getjTextField8().getText()));
       newEmployee.setDepartmentName(selectedDepartment);
        department.employees.add(newEmployee);
        LibrarySystem.employees.add(newEmployee);
    }
      static void addMedia(List<Department> departments,String selectedMedia){
        Department department=Department.search(departments, selectedMedia);
         Media newMedia=new Media(); 
        newMedia.setName(AddMediaFrame.getjTextField1().getText());
       newMedia.setNumber(Integer.parseInt(AddMediaFrame.getjTextField2().getText()));
       newMedia.setType(AddMediaFrame.getjTextField3().getText());
        newMedia.setDepartmentName(selectedMedia);
        department.media.add(newMedia);
        LibrarySystem.media.add(newMedia);
    }
}
