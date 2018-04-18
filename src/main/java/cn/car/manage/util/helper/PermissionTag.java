package cn.car.manage.util.helper;

import java.util.HashSet;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


/**
 * 
 * @Description: 权限标签 
 * @User: 
 * @Date: 2016年3月20日 下午5:16:00
 */
public class PermissionTag extends TagSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 权限标识
	 */
	private String id;
	
	
	@Override
	public String getId() {
		return id;
	}
	@Override
	public void setId(String id) {
		this.id = id;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public int doStartTag() throws JspException {
		if(id == null || id.trim().isEmpty()){
			return SKIP_BODY;
		}
		
		HttpSession session = RequestUtil.getSession();
		HashSet<String> permissions = null;
		if(session == null || (permissions = (HashSet<String>)session.getAttribute("permissions")) == null){
			return SKIP_BODY;
		}
		
		//如果拥有该权限
		if(!permissions.contains(this.id)){
			return SKIP_BODY;
		}
		
		return EVAL_BODY_INCLUDE;
	}

	
}
