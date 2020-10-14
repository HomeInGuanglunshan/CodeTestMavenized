package beanUtilsTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
 
public class ObjectString {
     
    private  String id;
    private  String name;
    private  String url;
    private  String des;
     
     
    public ObjectString(String id, String name, String url, String des) {
        super();
        this.id = id;
        this.name = name;
        this.url = url;
        this.des = des;
    }
 
 
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
 
 
    public String getUrl() {
        return url;
    }
 
 
    public void setUrl(String url) {
        this.url = url;
    }
 
 
    public String getDes() {
        return des;
    }
 
 
    public void setDes(String des) {
        this.des = des;
    }
 
     
    @Override
    public String toString() {
        try {
            return BeanUtils.describe(this).toString();
        } catch (Exception e) {
        }
        return "";
    }
 
 
    public static void main(String[] args) {
         
        ObjectString  obja=new ObjectString("11","aa","aa11","1111111aaaaa");
        ObjectString  objb=new ObjectString("22","bb","bb22","2222bbb");
         
        List<ObjectString>  lists=new ArrayList<ObjectString>();
        lists.add(obja);
        lists.add(objb);
         
        Map<ObjectString,ObjectString>  maps=new HashMap<ObjectString,ObjectString>();
        maps.put(obja, obja);
        maps.put(objb, objb);
         
        System.out.println("【obj String】:"+obja.toString());
        System.out.println("【list String】"+lists.toString());
        System.out.println("【map String】"+maps.toString());
 
    }
     
 
}