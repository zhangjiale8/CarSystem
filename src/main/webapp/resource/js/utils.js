

window.trim = function(str){
	if(!str || str.length == 0){
		return str;
	}
	
	return str.replace(/^\s+|\s+$/g, "");
}

window.urlParse = function(url){
	if(!url){
		return {};
	}
	
	if(url.indexOf("?") >= 0){
		url = url.substring(url.indexOf("?") + 1);
	}
	
	var params = url.split("&");
	if(!params || params.length <= 0){
		return {};
	}
	var urlParams = {};
	
	for(var i=0; i<params.length; i++){
		var param = params[i].split("=");
		urlParams[window.trim(param[0])] = window.trim(param[1]);
	}
	return urlParams;
}

window.attrElement = function(attrInfo){
	if(!attrInfo){
		return null;
	}
	
	var el = null;
	switch(attrInfo.attr_input_type_name){
		case "text":
			el = "<input class='attr' type='text'  data-attr-id='" + attrInfo.attribute_id + "'"
				+ (attrInfo.item_attr_id ? " data-item-attr-id='" + attrInfo.item_attr_id + "' " : "")
				+ (attrInfo.item_attr_value ? "value='" + attrInfo.item_attr_value + "'" : "")
				+ "/>";
			break;
		case "select":
			el = "<select class='attr' data-attr-id='" + attrInfo.attribute_id + "' data-db-type='text'"
				+ (attrInfo.item_attr_id ? " data-item-attr-id='" + attrInfo.item_attr_id + "' " : "")
				+ ">"
				+ "<option value=''>请选择</option>";
			var flag = attrInfo.item_attr_value ? true : false;
			if(attrInfo.attrValues){
				for(var i=0; i<attrInfo.attrValues.length; i++){
					el += "<option value='" + attrInfo.attrValues[i].attr_value + "' ";
					if(flag && attrInfo.attrValues[i].attr_value == attrInfo.item_attr_value){
						el += " selected ";
					}
					
					el += ">" + attrInfo.attrValues[i].attr_value + "</option>";
				}
			}
			el += "</select>";
			break;
		case "textarea":
			el = "<textarea class='attr' type='text' data-attr-id='" + attrInfo.attribute_id + "' data-db-type='text'"
				+ (attrInfo.item_attr_id ? " data-asset-attr-id='" + attrInfo.item_attr_id + "' " : "")
				+ (attrInfo.item_attr_value ? "value='" + item_.attr_value + "'" : "")
				+ "></textarea>";
		default:
			return null;
	}
	
	var attrName = attrInfo.item_attr_name;
	
	var dt = "<dt class='attribute'>"
		+ "<div class='name'>" + attrName + ":</div>"
		+ "<div class='value'>"
		+ el
		+ "</div>"
		+ "</dt>";
	
	return dt;
}