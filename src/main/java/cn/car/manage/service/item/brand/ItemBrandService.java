package cn.car.manage.service.item.brand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.car.manage.beans.orm.item.ItemSeries;
import cn.car.manage.beans.orm.item.brand.ItemBrand;
import cn.car.manage.mapper.item.SpelLetterMapper;
import cn.car.manage.mapper.item.brand.ItemBrandMapper;
import cn.car.manage.mapper.item.series.ItemBrandSeriesMapper;
import cn.car.manage.util.helper.DataTable;
import cn.car.manage.util.helper.DataTableReturn;
import cn.car.manage.util.helper.GetSpellLetter;

/**
 * @Description 品牌相关业务层
 * @author 
 * @date 2018年3月11日
 */
@Service
public class ItemBrandService {

	@Autowired
	private ItemBrandMapper itemBrandMapper;
	
	@Autowired
	private SpelLetterMapper spelLetterMapper;
	@Autowired
	private ItemBrandSeriesMapper itemBrandSeriesMapper;
	/**
	 * @Description:分页查询
	 * @author
	 * @date 2018年3月10日
	 * 
	 */
	public DataTableReturn<ItemSeries> getItemBrandByBrandName(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		DataTable dataTable = new DataTable(request);
		String itemBrandName = dataTable.getParameters().getOrDefault("brandName", "").toString();
		itemBrandName = itemBrandName.isEmpty() ? null : itemBrandName.trim();
		PageHelper.startPage(dataTable.getStart(), dataTable.getLength(), dataTable.getSort());
		
		List<ItemSeries> list = itemBrandMapper.getItemBrandByBrandName(itemBrandName);
		
		Page<ItemSeries> page = (Page<ItemSeries>) list;
		DataTableReturn<ItemSeries> dtReturn = new DataTableReturn<ItemSeries>(dataTable.getsEcho(), page.getTotal(),
				page.getTotal(), list);
		return dtReturn;
	}
	
	/**
	 * @Description:根据品牌ID查询
	 * @author
	 * @date 2018年3月10日
	 * 
	 */
	public ItemSeries getItemBrandNameByBrandID(int itemBrandID){
		if(itemBrandID==0){
			return null;
		}
		return itemBrandMapper.getItemBrandNameByBrandID(itemBrandID);
		
	}
	/**
	 * @Description:新增品牌
	 * @author
	 * @date 2018年3月10日
	 * 
	 */
	public int addItemBrand(HttpServletRequest request ,ItemBrand itemBrand){
		if(itemBrand==null||request==null){
			return 0;
		}
		String letterName=GetSpellLetter.converterToFirstSpell(itemBrand.getItemBrandName());
		
		int spellID=(int)spelLetterMapper.spelLetterIdByLetterName(letterName);
		itemBrand.setSpellID(spellID);
		ItemBrand brand=itemBrandMapper.getBrandByBrandName(itemBrand.getItemBrandName());
		if(brand==null){
			itemBrandMapper.addItemBrand(itemBrand);
			
			
			return itemBrandSeriesMapper.addItemBrandSeries(new ItemSeries(itemBrand.getItemBrandID(),itemBrand.getItemSeriesName()));	
		}else{
			ItemSeries series=itemBrandSeriesMapper.getItemSeriesBySeriesName(itemBrand.getItemSeriesName());
			if(series==null){
				return itemBrandSeriesMapper.addItemBrandSeries(new ItemSeries(brand.getItemBrandID(),itemBrand.getItemSeriesName()));
			
			}else{
				return 0;
			}
		}
		
	} 
	
	/**
	 * @Description:修改品牌
	 * @author
	 * @date 2018年3月10日
	 * 
	 */
	public int updateItemBrand(ItemBrand itemBrand){
		if(itemBrand==null){
			return 0;
		}
		String letterName=GetSpellLetter.converterToFirstSpell(itemBrand.getItemBrandName());
		
		int spellID=(int)spelLetterMapper.spelLetterIdByLetterName(letterName);
		itemBrand.setSpellID(spellID);
		return itemBrandMapper.updateItemBrand(itemBrand);
	}
	/**
	 * @Description:删除品牌
	 * @author
	 * @date 2018年3月10日
	 * 
	 */
	public int deleteItemBrand(List<Integer> itemBrandIDs){
		if(itemBrandIDs==null||itemBrandIDs.isEmpty()){
			return 0;
		}
		return itemBrandMapper.deleteItemBrand(itemBrandIDs);
	}
	/**
	 * @Description:查询品牌
	 * @author
	 * @date 2018年3月10日
	 * getAllBrandSeries
	 */
	public List<ItemBrand> getAllBrandName(){
		return itemBrandMapper.getAllBrandName();
	}
	/**
	 * @Description:查询品牌下的份，分类
	 * @author
	 * @date 2018年3月10日
	 * 
	 */ 
	public List<Map<String,Object>> getAllBrandLetter(){
		
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> maps= itemBrandMapper.getAllBrandLetter();
		for(int i=0;i<26;i++){
			Map<String,Object> map=new HashMap<String,Object>();
			List<Object> lists=new ArrayList<Object>();
			String letter=Character.toString((char)('A' + i));
            for (Map<String, Object> map2 : maps) {
    			if(letter.equals(map2.get("letter"))){
    				lists.add(map2.get("brandName"));
    			}
    		}
            if(lists.size()==0){
            	continue;
            }
            map.put("letter", letter);
            map.put(letter, lists);
            list.add(map);
        }
		
		return list;
		
	}
	public static void main(String[] args) {
        for(int i=0;i<26;i++){
            System.out.print(((char)('A' + i)) + " ");
        }
    }
 }
