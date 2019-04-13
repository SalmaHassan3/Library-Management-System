/*

 */
package LibraryManagementSystem;

import static LibraryManagementSystem.LibrarySystem.jTable3;
import static LibraryManagementSystem.LibrarySystem.jTable8;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 
 */
public class Media extends Entity {
    private String type,departmentName;
    private int number;
    
     static void edit(List<Media> mediaList,String name){
       
       Media media=search(mediaList,name);
       media.setName(AddMediaFrame.getjTextField1().getText());
       media.setNumber(Integer.parseInt(AddMediaFrame.getjTextField2().getText()));
       media.setType(AddMediaFrame.getjTextField3().getText());
      
      }
    
     static void display(List<Media> mediaList){
          DefaultTableModel model3 = (DefaultTableModel) LibrarySystem.jTable3.getModel();
       int no=jTable3.getRowCount();
        for (int i = 0; i <no; i++) {
            model3.removeRow(0);
            model3.setRowCount(jTable3.getRowCount() + 1);
        }
        int row=0;
       for(Media media : mediaList){
       jTable3.getModel().setValueAt(media.getName(),row, 0);   
       jTable3.getModel().setValueAt(media.number,row, 1);
      jTable3.getModel().setValueAt(media.departmentName,row, 2);
      jTable3.getModel().setValueAt(media.type,row, 3);
      
       model3.setRowCount(jTable3.getRowCount()+1); 
        
         row++;
       }
    }  
      public static Media search(List<Media>media,String name) {
        for(int i=0;i<media.size();i++){
           
           if(media.get(i).getName().equalsIgnoreCase(name)){
               return media.get(i);              
           }
        }
        return null;
    }
        
    public static void delete(List<Media>media,String name){
        Media deletemedia=search(media,name);
        if(deletemedia==null)
              JOptionPane.showMessageDialog(null,"Media NOT found");
        else{
       media.remove(deletemedia);
       Department department;
      department=Department.search(LibrarySystem.departments,deletemedia.getDepartmentName());
      department.media.remove(deletemedia);
    }
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    

   public static  void add(List<Media> media) {
       Media newMedia= new Media(); 
       newMedia.setName(AddMediaFrame.getjTextField1().getText());
       newMedia.setNumber(Integer.parseInt(AddMediaFrame.getjTextField2().getText()));
       newMedia.setType(AddMediaFrame.getjTextField3().getText());
        newMedia.setDepartmentName(AddMediaFrame.getjTextField4().getText());
        Department department=Department.search(LibrarySystem.departments,AddMediaFrame.getjTextField4().getText());
       if(department==null)
       {
           JOptionPane.showMessageDialog(null,"The department of this media is not found NOT found");
           AddMediaFrame.jButton1.setEnabled(false);
       } else {
           department.media.add(newMedia);
           media.add(newMedia);}
    }

   
   
    
}
