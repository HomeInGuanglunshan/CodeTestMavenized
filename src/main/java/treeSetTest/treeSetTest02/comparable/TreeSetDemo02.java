package treeSetTest.treeSetTest02.comparable;
import java.util.TreeSet;  
  
/* 
* TreeSet存储自定义对象并保证排序和唯一。 
 *  
 * 需求：请按照姓名的长度排序 
 */  
public class TreeSetDemo02 {  
    public static void main(String[] args) {  
        //创建集合对象          
        TreeSet<Student> ts=new TreeSet<Student>();  
  
          
        //创建元素对象  
        Student s1=new Student("zhangsan",20);  
        Student s2=new Student("lis",22);  
        Student s3=new Student("wangwu",24);  
        Student s4=new Student("chenliu",26);  
        Student s5=new Student("zhangsan",22);  
        Student s6=new Student("qianqi",24);  
          
        //将元素对象添加到集合对象中  
        ts.add(s1);  
        ts.add(s2);  
        ts.add(s3);  
        ts.add(s4);  
        ts.add(s5);  
        ts.add(s6);  
          
        //遍历  
        for(Student s:ts){  
            System.out.println(s.getName()+"-----------"+s.getAge());  
        }  
    }  
}  