package com.shiyilang.common.useful.PDFBoxUtil;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/** 
 * 替换PDF文件某个区域内的文本 
 * @user : caoxu-yiyang@qq.com 
 * @date : 2016年11月8日 
 */  
public class PDFReplacer {  
    private static final Logger logger = LoggerFactory.getLogger(PDFReplacer.class);  
      
    private int fontSize;  
    private Map<String, ReplaceRegion> replaceRegionMap = new HashMap<String, ReplaceRegion>();  
    private Map<String, Object> replaceTextMap =new HashMap<String, Object>();  
    private ByteArrayOutputStream output;  
    private PdfReader reader;  
    private PdfStamper stamper;  
    private PdfContentByte canvas;  
    private Font font;  
      
    public PDFReplacer(byte[] pdfBytes) throws DocumentException, IOException{  
        init(pdfBytes);  
    }


    public PDFReplacer(String fileName) throws IOException, DocumentException{  
        FileInputStream in = null;  
        try{  
            in =new FileInputStream(fileName);  
            byte[] pdfBytes = new byte[in.available()];  
            in.read(pdfBytes);  
            init(pdfBytes);  
        }finally{  
            in.close();  
        }  
    }  
      
    private void init(byte[] pdfBytes) throws DocumentException, IOException{  
        logger.info("初始化开始");  
        reader = new PdfReader(pdfBytes);  
        output = new ByteArrayOutputStream();  
        stamper = new PdfStamper(reader, output);  
        canvas = stamper.getOverContent(1);  
        setFont(10);  
        logger.info("初始化成功");  
    }  
      
    private void close() throws DocumentException, IOException{  
        if(reader != null){  
            reader.close();  
        }  
        if(output != null){  
            output.close();  
        }  
          
        output=null;  
        replaceRegionMap=null;  
        replaceTextMap=null;  
    }  
      
    public void replaceText(float x, float y, float w,float h, String text){  
        ReplaceRegion region = new ReplaceRegion(text);     //用文本作为别名  
        region.setH(h);  
        region.setW(w);  
        region.setX(x);  
        region.setY(y);  
        addReplaceRegion(region);  
        this.replaceText(text, text);  
    }  
      
    public void replaceText(String name, String text){  
        this.replaceTextMap.put(name, text);  
    }  
      
    /** 
     * 替换文本 
     * @throws IOException  
     * @throws DocumentException  
     * @user : caoxu-yiyang@qq.com 
     * @date : 2016年11月9日 
     */  
    private void process() throws DocumentException, IOException{  
        try{  
            parseReplaceText();  
            canvas.saveState();  
            Set<Entry<String, ReplaceRegion>> entrys = replaceRegionMap.entrySet();  
            for (Entry<String, ReplaceRegion> entry : entrys) {  
                ReplaceRegion value = entry.getValue();  
                canvas.setColorFill(BaseColor.WHITE);  
                canvas.rectangle(value.getX(),value.getY(),value.getW(),value.getH());  
            }  
            canvas.fill();  
            canvas.restoreState();  
            //开始写入文本   
            canvas.beginText();   
            for (Entry<String, ReplaceRegion> entry : entrys) {  
                ReplaceRegion value = entry.getValue();  
                //设置字体  
                canvas.setFontAndSize(font.getBaseFont(), getFontSize());    
                canvas.setTextMatrix(value.getX(),value.getY()+2/*修正背景与文本的相对位置*/);    
                canvas.showText((String) replaceTextMap.get(value.getAliasName()));     
            }  
            canvas.endText();  
        }finally{  
            if(stamper != null){  
                stamper.close();  
            }  
        }  
    }  

    private void parseReplaceText() {  
        PDFPositionParse parse = new PDFPositionParse(reader);  
        Set<Entry<String, Object>> entrys = this.replaceTextMap.entrySet();  
        for (Entry<String, Object> entry : entrys) {  
            if(this.replaceRegionMap.get(entry.getKey()) == null){  
                parse.addFindText(entry.getKey());  
            }  
        }  
          
        try {  
            Map<String, ReplaceRegion> parseResult = parse.parse();  
            Set<Entry<String, ReplaceRegion>> parseEntrys = parseResult.entrySet();  
            for (Entry<String, ReplaceRegion> entry : parseEntrys) {  
                if(entry.getValue() != null){  
                    this.replaceRegionMap.put(entry.getKey(), entry.getValue());  
                }  
            }  
        } catch (IOException e) {  
            logger.error(e.getMessage(), e);  
        }  
          
    }  
  
    /** 
     * 生成新的PDF文件 
     * @user : caoxu-yiyang@qq.com 
     * @date : 2016年11月9日 
     * @param fileName 
     * @throws DocumentException 
     * @throws IOException 
     */  
    public void toPdf(String fileName) throws DocumentException, IOException{  
        FileOutputStream fileOutputStream = null;  
        try{  
            process();  
            fileOutputStream = new FileOutputStream(fileName);  
            fileOutputStream.write(output.toByteArray());  
            fileOutputStream.flush();  
        }catch(IOException e){  
            logger.error(e.getMessage(), e);  
            throw e;  
        }finally{  
            if(fileOutputStream != null){  
                fileOutputStream.close();  
            }  
            close();  
        }  
        logger.info("文件生成成功");  
    }  
       
      
    /** 
     * 添加替换区域 
     * @user : caoxu-yiyang@qq.com 
     * @date : 2016年11月9日 
     * @param replaceRegion 
     */  
    public void addReplaceRegion(ReplaceRegion replaceRegion){  
        this.replaceRegionMap.put(replaceRegion.getAliasName(), replaceRegion);  
    }  
      
    public int getFontSize() {  
        return fontSize;  
    }  
  
    /** 
     * 设置字体大小 
     * @user : caoxu-yiyang@qq.com 
     * @date : 2016年11月9日 
     * @param fontSize 
     * @throws DocumentException 
     * @throws IOException 
     */  
    public void setFont(int fontSize) throws DocumentException, IOException{  
        if(fontSize != this.fontSize){  
            this.fontSize = fontSize;  
            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);  
            font = new Font(bf,this.fontSize,Font.BOLD);  
        }  
    }  
      
    public void setFont(Font font){  
        if(font == null){  
            throw new NullPointerException("font is null");  
        }  
        this.font = font;  
    }  
}  