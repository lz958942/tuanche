package com.tuanche.common.chinesetpinyin;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Pinyin {
	 private static HanyuPinyinOutputFormat format = null;
     private static String[] pinyin;

     static{
          format = new HanyuPinyinOutputFormat();
          format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
          pinyin = null;
     }
     
     //转换单个字符
     private static String getCharacterPinYin(char c){
               try{
                        pinyin = PinyinHelper.toHanyuPinyinStringArray(c, format);
               }catch(BadHanyuPinyinOutputFormatCombination e){
                        e.printStackTrace();
               }
               // 如果c不是汉字，toHanyuPinyinStringArray会返回null
               if(pinyin == null) return null;
               // 只取一个发音，如果是多音字，仅取第一个发音
               return pinyin[0];   
     }
     
     
     //转换一个字符串
     public static String getStringPinYin(String str){
               StringBuilder sb = new StringBuilder();
               String tempPinyin = null;
               for(int i = 0; i < str.length(); ++i){
                        tempPinyin =getCharacterPinYin(str.charAt(i));
                        if(tempPinyin == null){
                                 // 如果str.charAt(i)非汉字，则保持原样
                                 sb.append(str.charAt(i));
                        }else{
                                 sb.append(tempPinyin);
                        }
               }
               return sb.toString();
     }
	
	public static void main(String args[]){
		Pinyin hanyu = new Pinyin();
        // 中英文混合的一段文字
        String str = "重庆";
        String strPinyin = hanyu.getStringPinYin(str);
        System.out.println(strPinyin);
	}
	
}
