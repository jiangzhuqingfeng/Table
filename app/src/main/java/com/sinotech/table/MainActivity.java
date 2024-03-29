package com.sinotech.table;

import android.os.Bundle;
import android.telecom.Call;

import androidx.appcompat.app.AppCompatActivity;

import com.sinotech.view.form.core.SmartTable;
import com.sinotech.view.form.data.format.sequence.BaseSequenceFormat;
import com.sinotech.view.form.data.json.JsonHelper;
import com.sinotech.view.form.data.style.FontStyle;
import com.sinotech.view.form.data.table.MapTableData;
import com.sinotech.view.form.utils.DensityUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private SmartTable table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FontStyle.setDefaultTextSize(DensityUtils.sp2px(this, 15));
        table = (SmartTable) findViewById(R.id.table);
        table.getConfig()
                .setShowTableTitle(true)
                .setFixedYSequence(true)
                .setShowXSequence(true)
                .setYSequenceFormat(new BaseSequenceFormat() {
                    @Override
                    public String format(Integer position) {
                        return position == 1 ? "" : String.valueOf(position - 1);
                    }
                });
//        getData(false);

    }

//    public void getData(final boolean isFoot) {
//        String url = "http://61.175.198.122:29997/HNQZ/MobileTMS/Implement/ReportService.svc/GetReportReceive";
//        String postJson = "{\"parameter\":{\"BillDeptName\":\"\",\"BillDeptType\":\"所有\",\"CurrentBrandId\":\"1\"," +
//                "\"CurrentDeptName\":\"河南旗帜物流\",\"DiscDeptName\":\"\",\"DiscDeptType\":\"所有\"," +
//                "\"EndDate\":\"2018-11-07 \",\"SalesType\":0,\"StartDate\":\"2018-11-07 \",\"UserCode\":\"SUPERMAN\"}}";
//        OkHttpUtils
//                .postString()
//                .url(url)
//                .tag(this)
//                .content(postJson)
//                .mediaType(MediaType.parse("application/json; charset=utf-8"))
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        MapTableData.create("开票信息统计",
//                                JsonHelper.setJsonFormat(new OpenOrderFormat())
//                                        .jsonToMapList(response));
//                        MapTableData tableData = getReportDate();
//                        MapTableData totalDate = getTotalDate();
////                        table.setTableData(tableData,totalDate);
//                        table.setTableData(tableData);
//                    }
//                });
//    }

    private MapTableData getTotalDate() {
        return MapTableData.create("开票信息统计",
                JsonHelper.setJsonFormat(new OpenOrderFormat())
                        .jsonReportDateToMapList(ReportTestJson.totalJson));
    }

    private MapTableData getReportDate() {
        return MapTableData.create("开票信息统计",
                JsonHelper.setJsonFormat(new OpenOrderFormat())
                        .jsonReportTotalToMapList(ReportTestJson.reportJson));
    }

    /*  JsonHelper.setJsonFormat(new IJsonFormat() {
         @Override
         public String getKeyName(String key) {
             return ReportKeyNameUtils.getKeyNameTest(key);
         }

         @Override
         public boolean isShow(String key) {
             return LetterUtils.isChinese(key);
         }

         @Override
         public String getKeyValue(String key, Object value) {
             return (String) value;
         }

         @Override
         public List<String> compare(List<String> keys) {
             return keys;
         }

         @Override
         public int compare(String key, String key1) {
             return LetterUtils.getStringMax(key,key1);
         }

         @Override
         public boolean isSystemCompare() {
             return true;
         }

         @Override
         public Map<Integer, String> getSystemCompareMap() {
             return ReportSystemCompareMap.getSystemCompareMap();
         }

     }*/
    private void myTest() {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
//       list.stream().filter(num -> num.isEmpty()).distinct().collect(Collectors.toList()).forEach(string ->toString());
    }
}
