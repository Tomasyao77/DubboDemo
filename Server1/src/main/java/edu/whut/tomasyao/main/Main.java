package edu.whut.tomasyao.main;

import edu.whut.tomasyao.sameBean.Student;
import edu.whut.tomasyao.sameBean.Student1;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zouy on 19-9-6.
 */
public class Main {
    public static void main(String[] args){
        //同名bean会被后加载的覆盖掉
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext1.xml", "applicationContext.xml"}, false
        );
        applicationContext.setAllowBeanDefinitionOverriding(false);
        applicationContext.refresh();
        Student student = (Student)applicationContext.getBean("student");
        System.out.println(student.toString());
//        Student1 student1 = (Student1)applicationContext.getBean("student");
//        System.out.println(student1.toString());
    }
}
