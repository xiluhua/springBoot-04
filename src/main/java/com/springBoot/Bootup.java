package com.springBoot;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;

import com.multi.dataSource.MultiDataSource;
import com.springBoot.tool.IOTool;
public class Bootup {
	
	public final static String APPLICATION_CONTEXT_XML 			= "applicationContext.xml";
	public final static String APPLICATION_CONTEXT_XML_ORIGIN 	= "applicationContextOrigin.xml";
	private final static String POINTCUT_SPACE 					= "<!--POINTCUT SPACE-->";     
	private final static String ADVISER_SPACE  					= "<!--ADVISER SPACE-->"; 
	private final static String POINTCUT = "<aop:pointcut id=\"datasourcePointCut#INDEX\"  expression=\"execution(* #PKG.*(..))\" />"; 
	private final static String ADVISER  = "<aop:advisor advice-ref=\"dataSourceAdvice\"   pointcut-ref=\"datasourcePointCut#INDEX\" order=\"1\" />"; 
	private String utf8 				 = "utf-8";
	
	public boolean createAopConfig4MultiDatasource() {
		GenericApplicationContext context = null;
		ClassPathBeanDefinitionScanner scanner = null;
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("---------------------------------------- CONFIG BEGIN! ---------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------------");
		boolean flag = true;
		try {
			context = new GenericApplicationContext();
			scanner = new ClassPathBeanDefinitionScanner(context);
			int beanCount = scanner.scan("com.multi");
			System.out.println("beanCount: "+beanCount);
			
			List<String> list      = this.getBeanClasses(context);
			StringBuilder builder1 = this.buildConfPointcut(list);
			StringBuilder builder2 = this.buildConfAdvisor(list);
			
			System.out.println(builder1.toString());
			System.out.println(builder2.toString());
			
			// read
			URL url = Bootup.class.getClassLoader().getResource(APPLICATION_CONTEXT_XML_ORIGIN);
			System.out.println(APPLICATION_CONTEXT_XML_ORIGIN+" path: "+url.getPath());
			String content = IOTool.readFile(url.getPath(), utf8);
			
			// rewrite
			URL url2 = Bootup.class.getClassLoader().getResource(APPLICATION_CONTEXT_XML);
			System.out.println(APPLICATION_CONTEXT_XML+" path: "+url2.getPath());
			content = content.replaceAll(POINTCUT_SPACE, builder1.toString());
			content = content.replaceAll(ADVISER_SPACE,  builder2.toString());
			IOTool.writeIntoTxt(url2.getPath(), content, false, utf8);
			content = IOTool.readFile(url2.getPath(), utf8);
			
			System.out.println(content);
			System.out.println("*********************************************************************************************");
			System.out.println("************************************* CONFIG SUCCESS! ***************************************");
			System.out.println("*********************************************************************************************");
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		} finally {
			context = null;
			scanner = null;
		}
		return flag;
	}

	private StringBuilder buildConfAdvisor(List<String> list) {
		StringBuilder builder2 = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			String advisor  = null;
			if (i == 0) {
				advisor  = new String(ADVISER).replace("#INDEX", String.valueOf(i+1));
			}else {
				advisor  = new String("\t\t"+ADVISER).replace("#INDEX", String.valueOf(i+1));
			}
			builder2.append(advisor);
			builder2.append(System.getProperty("line.separator"));
		}
		return builder2;
	}

	private StringBuilder buildConfPointcut(List<String> list) {
		StringBuilder builder1 = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			String pointcut = null;
			if (i == 0) {
				pointcut = new String(POINTCUT).replace("#INDEX", String.valueOf(i+1));
			}else {
				pointcut = new String("\t\t"+POINTCUT).replace("#INDEX", String.valueOf(i+1));
			}
			pointcut = pointcut.replace("#PKG", list.get(i));
			builder1.append(pointcut);
			builder1.append(System.getProperty("line.separator"));
		}
		return builder1;
	}

	private List<String> getBeanClasses(GenericApplicationContext context) throws ClassNotFoundException {
		List<String> list = new ArrayList<>();
		String[] beans = context.getBeanDefinitionNames();
		for (String bean : beans) {
			// System.out.println(bean);
			String clazz = context.getBeanDefinition(bean).getBeanClassName();
			if (Class.forName(clazz).isAnnotationPresent(MultiDataSource.class)) 
			{
				System.out.println("MultiDataSource class: "+clazz);
				list.add(clazz);
			}
		}
		return list;
	}
}
