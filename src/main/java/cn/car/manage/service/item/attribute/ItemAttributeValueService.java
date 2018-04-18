package cn.car.manage.service.item.attribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.car.manage.beans.orm.item.attribute.ItemAttributeValue;
import cn.car.manage.mapper.item.attribute.ItemAttributeValueMapper;

/**
 * @Description:商品属性业务层
 * @author 
 * @date 2018年3月10日
 */
@Service
public class ItemAttributeValueService {

	@Autowired
	private ItemAttributeValueMapper itemAttributeValueMapper;
	/**
	 * @Description:商品属性查询
	 * @author 
	 * @date 2018年3月10日
	 */
	/**
	 * @Description:查询商品属性
	 * @author
	 * @date 2018年3月10日
	 * @param item
	 * @return
	 */
	public Map<String, Object> itemAttributeByItemTypeID(int itemTypeID){
		
		List<Map<String, Object>> assetAttributes = itemAttributeValueMapper.selectItemAttribute(itemTypeID);
		List<Map<String, Object>> attrs = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> attrTypes = new ArrayList<Map<String, Object>>();
		
		if (assetAttributes != null && !assetAttributes.isEmpty()) {
			Map<String, Map<String, Object>> attributeType = new LinkedHashMap<String, Map<String, Object>>();
			for (Map<String, Object> assetAttribute : assetAttributes) {
				int attrID = Integer.parseInt(assetAttribute.getOrDefault("attribute_id", 0).toString());
				if (attrID <= 0)
					continue;
				
				String attributeTypeName = assetAttribute.getOrDefault("attribute_type_name", 0).toString();
				if (!attributeType.containsKey(attributeTypeName)) {
					Map<String, Object> att = new HashMap<String, Object>();
					att.put("attribute_type_id", assetAttribute.get("attribute_type_id"));
					att.put("attribute_type_name", assetAttribute.get("attribute_type_name"));
					att.put("attribute_type_show_name", assetAttribute.get("attribute_type_show_name"));
					attributeType.put(attributeTypeName, att);
				}
				assetAttribute.remove("attribute_type_id");
				assetAttribute.remove("attribute_type_show_name");
				attrs.add(assetAttribute);
				
			}

			Iterator<Entry<String, Map<String, Object>>> it = attributeType.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, Map<String, Object>> entry = it.next();
			
				attrTypes.add(entry.getValue());
			}
		}
		Map<String, Object> positionAndAttributes = new HashMap<String, Object>();
		positionAndAttributes.put("attrs", attrs);
		positionAndAttributes.put("attrTypes", attrTypes);
		return positionAndAttributes;
		
	}
	
	public int addItemAttributeValue(List<ItemAttributeValue> itemAttributeValue,int itemID){
		if(itemID<=0){
			return 0;
		}
		if(itemAttributeValue.size()==0||itemAttributeValue==null){
			return 0;
		}
		for (ItemAttributeValue itemAttributeValueList : itemAttributeValue) {
			itemAttributeValueList.setItemID(itemID);
		}
		
		return itemAttributeValueMapper.addItemAttributeValue(itemAttributeValue);
		
	}
	
	public Map<String,Object> getItemAttributeValueByItemID(int itemID){
		List<Map<String, Object>> assetAttributes = itemAttributeValueMapper.getItemAttributeValueByItemID(itemID);
		
		List<Map<String, Object>> attrs = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> attrTypes = new ArrayList<Map<String, Object>>();
		
		if (assetAttributes != null && !assetAttributes.isEmpty()) {
			Map<String, Map<String, Object>> attributeType = new LinkedHashMap<String, Map<String, Object>>();
			for (Map<String, Object> assetAttribute : assetAttributes) {
			
				
				String attributeTypeName = assetAttribute.getOrDefault("attribute_type_name", 0).toString();
				if (!attributeType.containsKey(attributeTypeName)) {
					Map<String, Object> att = new HashMap<String, Object>();
					att.put("attribute_type_show_name", assetAttribute.get("attribute_type_show_name"));
					attributeType.put(attributeTypeName, att);
				}
				assetAttribute.remove("attribute_type_name");
				attrs.add(assetAttribute);
				
			}
			
			Iterator<Entry<String, Map<String, Object>>> it = attributeType.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, Map<String, Object>> entry = it.next();
			
				attrTypes.add(entry.getValue());
			}
		}
		Map<String, Object> positionAndAttributes = new HashMap<String, Object>();
		positionAndAttributes.put("attrs", attrs);
		positionAndAttributes.put("attrTypes", attrTypes);
		
		return positionAndAttributes;
		
	}
 }
