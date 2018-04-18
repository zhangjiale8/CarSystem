package cn.car.manage.util.helper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.web.bind.annotation.RequestMapping;




public class JavaScriptRequest {

	/**
	 * 
	 * @Description: 将java对象转换为Javascript对象
	 * @User: 
	 * @Date: 2015年7月22日 下午3:22:08
	 * @param cls
	 */
	public String entityToJSObject(Class<?> cls) {

		String jsObject = "\tvar " + cls.getSimpleName() + " = function(";
		String properties = "";
		String str = "";

		String toString = "\n\t\tthis.toString = function(){\n\t\t\treturn JSON.stringify(this);\n\t\t};\n";

		Field[] fields = cls.getDeclaredFields();

		if (fields != null && fields.length != 0) {
			properties += fields[0].getName();
			str += "\t\tthis." + fields[0].getName() + " = " + fields[0].getName() + ";\n";
		}
		for (int i = 1, len = fields.length; i < len; i++) {
			properties += ", " + fields[i].getName();
			str += "\t\tthis." + fields[i].getName() + " = " + fields[i].getName() + ";\n";
		}

		jsObject = jsObject + properties + "){\n\n" + str + toString + "\t};";

		return jsObject;
	}

	/**
	 * Entiry request object.
	 *
	 * @param cls
	 *            the cls
	 * @return the string
	 */
	public String entiryRequestObject(Class<?> cls) {

		String requestObject = "function " + cls.getSimpleName().substring(0, cls.getSimpleName().indexOf("Controller")) + "(){\n";
		String methodsString = "";

		// 忽略的参数
		/*
		 * List<String> ignoreParameters = new ArrayList<String>();
		 * ignoreParameters.add(HttpServletRequest.class.getSimpleName());
		 * ignoreParameters.add(HttpServletResponse.class.getSimpleName());
		 * ignoreParameters.add(HttpSession.class.getSimpleName());
		 */

		Method[] methods = cls.getDeclaredMethods();

		String URL = "\"" + cls.getAnnotation(RequestMapping.class).value()[0].substring(1);

		for (Method method : methods) {

			String ajaxURL = URL + method.getAnnotation(RequestMapping.class).value()[0] + "\"";

			methodsString += "\tthis." + method.getName() + " = function(";

			String ajaxParams = "{";

			if (method.isAnnotationPresent(RequestMapping.class)) {
				String[] params = method.getAnnotation(RequestMapping.class).params();
				if (params.length == 1) {
					methodsString += "callback";
					ajaxParams = "{\"forward\":\"JSON\"}";
				} else {

					for (String param : params) {

						if (!param.equals("forward")) {
							if (param.contains("[]")) {
								System.err.println(param);
								param = param.substring(0, param.length() - 2);
								System.err.println(param);
							}
							methodsString += param + ",";
							ajaxParams += "\"" + param + "\":" + param + ",";
						}
					}

					if (ajaxParams.endsWith(",")) {
						ajaxParams = ajaxParams.substring(0, ajaxParams.length() - 1) + ", \"forward\":\"JSON\"}";
					}
				}

			} else {
				continue;
			}

			if (methodsString.endsWith(",")) {

				methodsString = methodsString.substring(0, methodsString.length() - 1) + ", callback";
			}

			methodsString += "){\n" + "\t\t$.ajax({\n" + "\t\t\t\"type\":\"POST\",\n" + "\t\t\t\"url\": " + ajaxURL + ",\n" + "\t\t\t\"dataType\":\"json\",\n" + "\t\t\t\"data\":" + ajaxParams + ",\n" + "\t\t\t\"success\":function(data){\n" + "\t\t\t\tcallback(1, data);\n" + "\t\t\t},\n"
					+ "\t\t\t\"error\":function(data){\n" + "\t\t\t\tcallback(0, data);\n" + "\t\t\t}\n" + "\t\t});\n" + "\t};\n";

		}

		requestObject += methodsString + "};";

		return requestObject;
	}

	/**
	 * Entiry request.
	 *
	 * @param cls
	 *            the cls
	 * @return the string
	 */
	public String entiryRequest(Class<?> cls) {

		String requestObject = "";
		String methodsString = "";
		String methodInterfaces = "\treturn {\n";

		// 忽略的参数
		/*
		 * List<String> ignoreParameters = new ArrayList<String>();
		 * ignoreParameters.add(HttpServletRequest.class.getSimpleName());
		 * ignoreParameters.add(HttpServletResponse.class.getSimpleName());
		 * ignoreParameters.add(HttpSession.class.getSimpleName());
		 */

		Method[] methods = cls.getDeclaredMethods();

		String URL = "\"" + cls.getAnnotation(RequestMapping.class).value()[0].substring(1);

		for (Method method : methods) {

			String ajaxURL = URL + method.getAnnotation(RequestMapping.class).value()[0] + "\"";

			methodInterfaces += "\t\t" + method.getName() + ":" + method.getName() + ",\n";

			methodsString += "\tvar " + method.getName() + " = function(";

			String ajaxParams = "{";

			if (method.isAnnotationPresent(RequestMapping.class)) {

				String[] params = method.getAnnotation(RequestMapping.class).params();
				if (params.length <= 1) {
					methodsString += "callback";
					ajaxParams = "{\"forward\":\"JSON\"}";
				} else {

					for (String param : params) {

						if (!param.equals("forward")) {
							if (param.contains("[]")) {
								param = param.substring(0, param.length() - 2);
							}
							methodsString += param + ",";
							ajaxParams += "\"" + param + "\":" + param + ",";
						}
					}

					if (ajaxParams.endsWith(",")) {
						ajaxParams = ajaxParams.substring(0, ajaxParams.length() - 1) + ", \"forward\":\"JSON\"}";
					}
				}

			} else {
				continue;
			}

			if (methodsString.endsWith(",")) {

				methodsString = methodsString.substring(0, methodsString.length() - 1) + ", callback";
			}

			methodsString += "){\n" + "\t\t$.ajax({\n" + "\t\t\t\"type\":\"POST\",\n" + "\t\t\t\"url\": " + ajaxURL + ",\n" + "\t\t\t\"dataType\":\"json\",\n" + "\t\t\t\"data\":" + ajaxParams + ",\n" + "\t\t\t\"success\":function(data){\n" + "\t\t\t\tcallback(1, data);\n" + "\t\t\t},\n"
					+ "\t\t\t\"error\":function(data){\n" + "\t\t\t\tcallback(0, data);\n" + "\t\t\t}\n" + "\t\t});\n" + "\t};\n";

		}

		requestObject += methodsString;
		requestObject = requestObject + "\n\n" + methodInterfaces + "\t};";

		return requestObject;
	}

	/**
	 * Creates the js.
	 *
	 * @param entiryClass
	 *            the entiry class
	 * @param controllerClass
	 *            the controller class
	 */
	public void createJS(Class<?> entiryClass, Class<?> controllerClass) {

		String js = "";

		js += "\n\n" + "define(function(require, exports, module){\n\n\n";
		js += "\tvar jQuery = require('jquery');\n";
		js += "\tvar $ = jQuery;\n\n";
		String entity = entityToJSObject(entiryClass);
		String request = entiryRequest(controllerClass);

		js += entity + "\n\n" + request + "\n});\n";

		System.out.println(js);
	}

	
	
}
