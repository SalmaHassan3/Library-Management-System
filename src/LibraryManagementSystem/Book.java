
package LibraryManagementSystem;
import static LibraryManagementSystem.LibrarySystem.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Book extends Entity {
    
    private String author,departmentName;
    private int numberOfPages,number;
    private boolean avaliable;
    private float price;
    
    static void display(List<Book> books){
        DefaultTableModel model1 = (DefaultTableModel) LibrarySystem.jTable1.getModel();
        int no=jTable1.getRowCount();
        for (int i = 0; i <no; i++) {
            model1.removeRow(0);
            model1.setRowCount(jTable1.getRowCount() + 1);}
        int row=0;
       for(Book book:books){
       jTable1.getModel().setValueAt(book.getName(), row, 0);   
       jTable1.getModel().setValueAt(book.number , row, 1);
       jTable1.getModel().setValueAt(book.departmentName, row, 2);
       jTable1.getModel().setValueAt(book.avaliable, row, 3);
       jTable1.getModel().setValueAt(book.author, row, 4);
       jTable1.getModel().setValueAt(book.numberOfPages, row, 5);
       jTable1.getModel().setValueAt(book.price, row, 6);
       model1.setRowCount(jTable1.getRowCount()+1);
         row++;
       }
    }
    public static void add(List<Book> books){
       Book newBook =new Book(); 
       newBook.setName(AddBookFrame.getjTextField1().getText());
       newBook.setNumber(Integer.parseInt(AddBookFrame.getjTextField2().getText()));
       newBook.setAuthor(AddBookFrame.getjTextField3().getText());
       newBook.setNumberOfPages(Integer.parseInt(AddBookFrame.getjTextField4().getText()));
       newBook.setPrice(Float.parseFloat(AddBookFrame.getjTextField5().getText()));
       newBook.setDepartmentName(AddBookFrame.jTextField6.getText());
       newBook.setAvaliable(true);
       
       
       Department department=Department.search(LibrarySystem.departments,AddBookFrame.jTextField6.getText());
       if(department==null)
       {
           JOptionPane.showMessageDialog(null,"The department of this book is not found NOT found");
           AddBookFrame.jButton1.setEnabled(false);
       } else {
           department.books.add(newBook);
           books.add(newBook);}
           
    }
     public static Book search(List<Book> books,String name) {
        for(int i=0;i<books.size();i++){
           
           if(books.get(i).getName().equalsIgnoreCase(name)){
               return books.get(i);              
           }
        }
        return null;
    }
        
    public static void delete(List<Book> books,String name){
        Book book=search(books,name);
        if(book==null)
              JOptionPane.showMessageDialog(null,"Book NOT found");
        else{
        books.remove(book);
       Department department;
      department=Department.search(LibrarySystem.departments,book.getDepartmentName());
      department.books.remove(book);
    }
    }
    static void edit(List<Book> books,String name){
       
       Book book=search(books,name);
       book.setName(AddBookFrame.getjTextField1().getText());
       book.setNumber(Integer.parseInt(AddBookFrame.getjTextField2().getText()));
       book.setAuthor(AddBookFrame.getjTextField3().getText());
       book.setNumberOfPages(Integer.parseInt(AddBookFrame.getjTextField4().getText()));
       book.setPrice(Float.parseFloat(AddBookFrame.getjTextField5().getText()));
       book.setAvaliable(true);}
      
      
               
      
        
        
   

   
    
     
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }
    
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }    

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

} 
   