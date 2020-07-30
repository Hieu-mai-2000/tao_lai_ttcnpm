package com.example.test_quay;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;
import java.util.ArrayList;

public class gio_hang_activity extends AppCompatActivity {

    Button ThanhToan;
    ListView lvGioHang;
    ArrayList<class_gio_hang> array_gio_hang;
    Adapter_gio_hang adapter;
    Database database;
    //Paypal payment
    private static final int PAYPAL_REQUEST_CODE = 7777;
    static PayPalConfiguration config = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(Config.PAYPAL_CLIENT_ID);
    String Amount = "100";
    @Override
    protected void onDestroy() {
        stopService(new Intent(this,PayPalService.class));
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang_activity);
        //start paypal service
        Intent intent = new Intent(this,PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        startService(intent);

        anhxa();
        GetDataGioHang();
        adapter.notifyDataSetChanged();


        ThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(gio_hang_activity.this, "thanh toán bằng gì,và xác nhận", Toast.LENGTH_SHORT).show();
                database.QueryData("DELETE  FROM gio_hang");
                adapter.notifyDataSetChanged();
                int money = GetDataGioHang();
                if(money > 0) Amount = Integer.toString(money);
                processPayment();

            }
        });
    }

    private void processPayment() {
        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(String.valueOf(Amount)),"USD",
                "Order food",PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
        startActivityForResult(intent,PAYPAL_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == PAYPAL_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirmation != null) {
                    Toast.makeText(gio_hang_activity.this,"Cam on da dat hang",Toast.LENGTH_SHORT).show();
                }
            } else if (resultCode == Activity.RESULT_CANCELED)
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID)
            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
        super.onActivityResult(requestCode, resultCode, data);
    }

    private  int GetDataGioHang(){
        //select data
        int amount = 1;
        Cursor data_gio_hang = database.GetData("SELECT * FROM gio_hang");
        array_gio_hang.clear();
        while (data_gio_hang.moveToNext()){
            int id = data_gio_hang.getInt(0);
            String ten = data_gio_hang.getString(1);
            int gia = data_gio_hang.getInt(2);
            int soluongdat= data_gio_hang.getInt(3);
            String ghichu = data_gio_hang.getString(4);
            String hinh_anh = data_gio_hang.getString(5);
            array_gio_hang.add(new class_gio_hang(id,ten,gia*soluongdat,soluongdat,ghichu,hinh_anh));
            amount += 100;
        }
        return amount;
    }

    public void DialogXoaMonAn(final String monan, final int id){
        final AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Bạn có muốn xóa món ăn\n'"+ monan + "'\nnày khong");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                database.QueryData("DELETE  FROM gio_hang WHERE Id = '"+ id +"'");
                Toast.makeText(gio_hang_activity.this, "Đã Xóa:" + monan, Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
                GetDataGioHang();
            }
        });
        dialogXoa.setNegativeButton("không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialogXoa.show();
    }

    private void anhxa(){

        //tạo database
        database = new Database(this,"gio_hang.sqlite",null,1);
        database.QueryData("CREATE TABLE IF NOT EXISTS gio_hang(Id INTEGER PRIMARY KEY AUTOINCREMENT,TenFood VARCHAR(200),Gia INT,SoLuong INT,GhiChu TEXT, HinhanhFood TEXT)");
        lvGioHang = (ListView) findViewById(R.id.gio_hang_listview_ordered);
        array_gio_hang = new ArrayList<>();
        adapter = new Adapter_gio_hang(this,R.layout.element_gio_hang,array_gio_hang);
        lvGioHang.setAdapter(adapter);
        ThanhToan = (Button) findViewById(R.id.gio_hang_thanh_toan);
    }

}