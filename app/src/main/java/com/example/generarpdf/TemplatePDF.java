package com.example.generarpdf;

import android.content.Context;
import android.os.Environment;
import android.util.Log;


import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;

public class TemplatePDF {

    private Context context;
    private File pdfFile;
    private Document documemt;

    private PdfWriter pdfWriter;
    public TemplatePDF(){
         this.context = context;
    }

    //crear carpeta dentro del dispositivo
    private void createFile(){
        File folder = new File(Environment.getDataDirectory().toString(), "PDF");
        if(!folder.exists())
            folder.mkdirs();
        pdfFile = new File(folder, "TemplatePDF.pdf");
    }

    public void openDocument(){
        createFile();
        try {
        documemt = new Document(PageSize.A4);
        pdfWriter = PdfWriter.getInstance(documemt, new FileOutputStream(pdfFile));
        documemt.open();

        }catch (Exception e){
            Log.e("openDocument",e.toString());
        }
    }

    public void closeDocument(){
        documemt.close();
    }

    public void addMetaData(String title, String subject, String author){
        documemt.addTitle(title);
        documemt.addSubject(subject);
        documemt.addAuthor(author);
    }

    public void addTitles(String title, String subTitle, String date){
        
    }


}
