package com.example.user.contactsintext;

import android.database.Cursor;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;



public class MainActivity extends AppCompatActivity {
    TextView tv;
    String s="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textview);
    }
    public void btclick(View V)
    {
        try {
            Cursor phones=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
            File contNoFile=new File("/sdcard/contNo.txt");
            contNoFile.createNewFile();
            FileOutputStream fout=new FileOutputStream(contNoFile);
            OutputStream WriterOutStreamFile=new OutputStreamWriter(fout) ;
            OutputStreamfile.append("<b>Contact Name with mobile number</b>"+"<br>");
            while (phones.moveToNext())
            {
                String contName=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String contNo=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                s+="<b><font color=purple>"+contName+"</font></b></br>";
                s+=contNo+"<br><br>";
            }
            Spanned sp= Html.fromHtml(s);
            outStreamFile.append(sp);
            outStreamFile.close();
            fout.close();
            tv.setText(sp);




        }
        catch (Exception e)
        {

        }
    }
}
