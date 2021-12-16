import com.spire.pdf.*;
import com.spire.pdf.actions.PdfJavaScriptAction;


public class ExpiryDate {

    private static final String PATH="C:\\Users\\mivan\\Desktop\\document\\interview\\2021.12\\ZhangMeng_Android_resume.pdf";
    public static void main(String[] args) {
        //加载PDF测试文档
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(PATH);
//        pdf.loadFromFile("C:\\Users\\mivan\\Desktop\\document\\interview\\2021.12\\张梦_Android-简历.pdf");
        //通过JavaScript设置过期时间，过期警告信息并关闭文档
        String javaScript = "var rightNow = new Date();"
//                + "var endDate = new Date('June 20, 2021 23:59:59');"
                + "var endDate = new Date('January 26, 2022 21:04:00');"
                + "if(rightNow.getTime() > endDate){"
                + "app.alert('该文档已过期，请重新联系管理员获取！',1);"
                + "this.closeDoc();}";

        //根据JS创建PdfJavaScriptAction
        PdfJavaScriptAction js = new PdfJavaScriptAction(javaScript);

        //将PdfJavaScriptAction设置为文档打开后的动作
        pdf.setAfterOpenAction(js);

        //保存文档
        pdf.saveToFile(PATH, FileFormat.PDF);
        pdf.dispose();
    }
}
