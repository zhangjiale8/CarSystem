package cn.car.manage.util.helper;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class GetSpellLetter {

    public static String converterToFirstSpell(String chines) {  
        String pinyinName = "";  
        char[] nameChar = chines.toCharArray();  
        HanyuPinyinOutputFormat defaulFormat = new HanyuPinyinOutputFormat();  
        defaulFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);  
        defaulFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
        defaulFormat.setVCharType(HanyuPinyinVCharType.WITH_V);  
        for (int i = 0; i < nameChar.length; i++) {  
            if (nameChar[i] > 128) {  
                try {  
                    pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaulFormat)[0].charAt(0);    
                } catch (BadHanyuPinyinOutputFormatCombination ex) {  
                    ex.printStackTrace();  
                }  
            } else {  
                pinyinName += nameChar[i];  
            }  
        }  
        return pinyinName.substring(0, 1);  
    } 
    public static void main(String[] args) {
    	String a=GetSpellLetter.converterToFirstSpell("奥迪");
    	System.out.println(a);
    }
}
