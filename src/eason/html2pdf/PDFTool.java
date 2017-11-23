package eason.html2pdf;

import java.io.IOException;

/**
 * Created by Eason on 2017/11/23.
 */
public class PDFTool {
    //wkhtmltopdf在系统中的路径
    private static final String toPdfTool = "D:\\WKHtmlToPdf\\bin\\wkhtmltopdf.exe";
    private static final String floader = "E:\\Project\\url2pdf\\pdf\\";


    public String getCommand(String htmlName , String pdfName){
        String system = System.getProperty("os.name");
        if("Windows XP".equalsIgnoreCase(system)||"Windows 10".equalsIgnoreCase(system)||"Windows 7".equalsIgnoreCase(system)) {   //xp系统
            return toPdfTool + " " + htmlName + " " + floader + pdfName;
        } else  if("Linux".equalsIgnoreCase(system)) {  //linux 系统
            return "wkhtmltopdf-amd64 " + htmlName + " " + pdfName;
        }
        return ""   ;
    }

    public static void main(String[] args){
        PDFTool pdfTool = new PDFTool();
        String command1 = pdfTool.getCommand("https://www.cnblogs.com/licomeback/articles/3056492.html", "test.pdf");
        System.out.println(command1);
        try {
            Runtime.getRuntime().exec(command1);
//            Runtime.getRuntime().exec();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
