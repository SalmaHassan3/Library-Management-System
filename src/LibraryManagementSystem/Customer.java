
package LibraryManagementSystem;

import static LibraryManagementSystem.LibrarySystem.jTable11;
import static LibraryManagementSystem.LibrarySystem.jTable2;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Customer extends Person {
   
   
    private float fees;
    
    
    static void edit(List<Customer> customers,String name){
       
        Customer customer=search(customers,name);
       customer.setName(AddCustomerFrame.getjTextField1().getText());
       customer.setId(Integer.parseInt(AddCustomerFrame.getjTextField2().getText()));
       customer.setFees(Float.parseFloat(AddCustomerFrame.getjTextField3().getText()));}
    
     static void display(List<Customer> customers){
          DefaultTableModel model2 = (DefaultTableModel) LibrarySystem.jTable2.getModel();
      int no=jTable2.getRowCount();
        for (int i = 0; i <no; i++) {
            model2.removeRow(0);
            model2.setRowCount(jTable2.getRowCount() + 1);}
        int row=0;
       for(Customer customer : customers){
      jTable2.getModel().setValueAt(customer.getName(),row, 0);   
      jTable2.getModel().setValueAt(customer.getId(),row, 1);
      jTable2.getModel().setValueAt(customer.fees,row, 2);
       

    
       model2.setRowCount(jTable2.getRowCount()+1); 
        
         row++;
       }
    }        

    public static void add(List<Customer> customers) {
      Customer newCustomer=new Customer();
       newCustomer.setName(AddCustomerFrame.getjTextField1().getText());
       newCustomer.setId(Integer.parseInt(AddCustomerFrame.getjTextField2().getText()));
       newCustomer.setFees(Float.parseFloat(AddCustomerFrame.getjTextField3().getText()));
       customers.add(newCustomer);
     
    }
     public static Customer search(List<Customer> customers,String name) {
        for(int i=0;i<customers.size();i++){
           
           if(customers.get(i).getName().equalsIgnoreCase(name)){
               return customers.get(i);              
           }
        }
        return null;
    }
        
    public static void delete(List<Customer> customers,String name){
        Customer customer=search(customers,name);
        if(customer==null)
              JOptionPane.showMessageDialog(null,"Customer NOT found");
        else{
       customers.remove(customer);
    }
    }

    public float getFees() {
        return fees;
    }

    public void setFees(float fees) {
        this.fees = fees;
    }
    
    
    
}
