package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import biz.FoodBiz;
import biz.FoodCateBiz;

import com.opensymphony.xwork2.ActionSupport;

import entity.Food;

public class FoodAction extends ActionSupport{
	FoodBiz foodBiz;
	private List Foodlist;
	private List FoodList;
	private List FoodCateList;
	private int id;
	private Food food;
	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}



	private Food f;
	FoodCateBiz foodcateBiz;
	private String path;
    public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List getFoodCateList() {
		return FoodCateList;
	}

	public void setFoodCateList(List foodCateList) {
		FoodCateList = foodCateList;
	}

	public void setFoodcateBiz(FoodCateBiz foodcateBiz) {
		this.foodcateBiz = foodcateBiz;
	}

	

	public Food getF() {
		return f;
	}

	public void setF(Food f) {
		this.f = f;
	}



	private final static String UPLOADDIR = "/img";//文件上传的路径，在webContent下建立
    private File file;  //input控件名一定为file 
    //上传文件名集合   
    private String fileFileName;   
    public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	//上传文件内容类型集合   
    private String fileContentType; 
    
    private String filename;
 
    public String upload() throws FileNotFoundException, IOException{
         path=uploadFile();//文件保存数据库的路径
    
        return SUCCESS;
    }
    
    //执行上传功能   
    @SuppressWarnings("deprecation")
    public String uploadFile() throws FileNotFoundException, IOException {   
        try {   
            InputStream in = new FileInputStream(file);   
            String dir="D:\\GraduationProject\\HaoShiRestaurant\\WebRoot\\img";
            //String dir = ServletActionContext.getRequest().getSession().getServletContext().getRealPath(UPLOADDIR);  
            File fileLocation = new File(dir);  
            //此处也可以在应用根目录手动建立目标上传目录  
            if(!fileLocation.exists()){  
                boolean isCreated  = fileLocation.mkdir();  
                if(!isCreated) {  
                    //目标上传目录创建失败,可做其他处理,例如抛出自定义异常等,一般应该不会出现这种情况。  
                    return null;  
                }  
            }
           // this.setFileFileName(getRandomString(20));
            String[] Name=this.getFileFileName().split("\\.");
            String fileName=getRandomString(20)+"."+Name[Name.length-1];
            this.setFileFileName(fileName);
            System.out.println(fileName);
            File uploadFile = new File(dir, fileName);
            OutputStream out = new FileOutputStream(uploadFile);   
            byte[] buffer = new byte[1024 * 1024];   
            int length;   
            while ((length = in.read(buffer)) > 0) {   
                out.write(buffer, 0, length);   
            }
            in.close();   
            out.close();   
            return fileFileName;
            } catch (FileNotFoundException ex) {
                return null;   
            } catch (IOException ex) {
                return null;   
        }   
    }
    
    
    public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
          int number=random.nextInt(62);
          sb.append(str.charAt(number));
        }
        return sb.toString();
    }    

    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List getFoodList() {
		return FoodList;
	}
	public void setFoodList(List foodList) {
		FoodList = foodList;
	}
	public List getFoodlist() {
		return Foodlist;
	}
	public void setFoodlist(List foodlist) {
		Foodlist = foodlist;
	}

	private int cateId;
	
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public void setFoodBiz(FoodBiz foodBiz) {
		this.foodBiz = foodBiz;
	}
	
	public String findFoodByCateId(){
		Foodlist=foodBiz.findFoodByCate(cateId);
		
		return "showFood";
	}
	
	public String findAll(){
		FoodList=foodBiz.findAllFood();
		return "findAll";
	}
	
	public String DeleteFood(){
		int res=foodBiz.DeleteFood(id);
		if(res==1){
			findAll();
			return "DeleteFood";
		}else{
			return "error";
		}
	}
	
	
	public String AddFood() throws FileNotFoundException, IOException{
		upload();
		food.setImg(path);
		int res=foodBiz.AddFood(food);
		if(res==1){
			findAll();
			return "AddFood";
		}
		else{
			return "error";
		}
	}
	
	public String ToAddFood(){
		FoodCateList=foodcateBiz.findFoodCate();		
		return "ToAddFood";
	}
	
	public String ToUpdateFood(){
		findFoodByid();
		FoodCateList=foodcateBiz.findFoodCate();		
		return "ToUpdateFood";
	}
	public void findFoodByid(){
		f=foodBiz.findFoodById(id);
		System.out.println("f:"+f.getFname());
	}
	
	public String FoodUpdate(){
		int res=foodBiz.FoodUpdate(food);
		if(res==1){
			findAll();
			return "FoodUpdate";
		}else{
			return "error";
		}
		
	}
}
