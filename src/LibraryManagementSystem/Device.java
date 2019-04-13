
package LibraryManagementSystem;

import static LibraryManagementSystem.LibrarySystem.jTable11;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import static LibraryManagementSystem.LibrarySystem.jTable4;
import javax.swing.JOptionPane;

public class Device extends Entity{
    
    
    private String type;
    private int number;
    
     static void edit(List<Device> devices,String name){
       
        Device device=search(devices,name);
       device.setName(AddDeviceFrame.getjTextField1().getText());
       device.setNumber(Integer.parseInt(AddDeviceFrame.getjTextField2().getText()));
       device.setType(AddDeviceFrame.getjTextField3().getText());}
    
     static void display(List<Device> devices){
          DefaultTableModel model4 = (DefaultTableModel) LibrarySystem.jTable4.getModel();
      int no=jTable4.getRowCount();
        for (int i = 0; i <no; i++) {
            model4.removeRow(0);
            model4.setRowCount(jTable4.getRowCount() + 1);}
        int row=0;
       for(Device device : devices){
      jTable4.getModel().setValueAt(device.getName(),row, 0);   
      jTable4.getModel().setValueAt(device.type,row, 1);
      jTable4.getModel().setValueAt(device.number,row, 2);
       
      
       model4.setRowCount(jTable4.getRowCount()+1); 
        
         row++;
       }
    }  
     public static void add(List<Device> devices) {
       Device newDevice=new Device();
        newDevice.setName(AddDeviceFrame.getjTextField1().getText());
       newDevice.setNumber(Integer.parseInt(AddDeviceFrame.getjTextField2().getText()));
       newDevice.setType(AddDeviceFrame.getjTextField3().getText());
       devices.add(newDevice);
      
    }
      public static Device search(List<Device> devices,String name) {
        for(int i=0;i<devices.size();i++){
           
           if(devices.get(i).getName().equalsIgnoreCase(name)){
               return devices.get(i);              
           }
        }
        return null;
    }
        
    public static void delete(List<Device>devices,String name){
        Device device=search(devices,name);
        if(device==null)
              JOptionPane.showMessageDialog(null,"Device NOT found");
        else{
       devices.remove(device);
    }
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

   

   
 
    
    
    
    
}
