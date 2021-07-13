package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    ArrayList<Truyen> truyen = new ArrayList<Truyen>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh4);
        Anhxa();
        ConTrolbtn();
    }
    private void Anhxa(){
        int  id = getIntent().getExtras().getInt("I");
        ImageView imghinh1 = (ImageView)findViewById(R.id.imgdoc) ;
        truyen.add(new Truyen("Doraemon","Truyện tranh",R.drawable.truyen1,"Fujiko Fujio","Hai Phần","Doraemon là một chú mèo máy được Nôbitô, cháu ba đời của Nôbita gửi về quá khứ cho ông mình để giúp đỡ Nôbita tiến bộ, tức là cũng sẽ cải thiện hoàn cảnh của con cháu Nôbita sau này. Còn ở hiện tại, Nôbita là một cậu bé luôn thất bại ở trường học, và sau đó là thất bại trong công việc, đẩy gia đình và con cháu sau này vào cảnh nợ nần.",R.drawable.truyen1_1,R.drawable.truyen1_2,R.drawable.truyen1_3,R.drawable.truyen1_4));
        truyen.add(new Truyen("Naruto","Truyện tranh",R.drawable.truyen2,"Kishimoto Masashi","Bốn phần","Mười hai năm trước thời khắc loạt truyện bắt đầu , quái thú Cửu Vĩ con cáo tấn công làng Lá , hủy hoại phần lớn ngôi làng và cướp đi biết chừng nào sinh mạng. Địa ngục đứng đầu ngôi làng , Hokage đệ Tứ , đã hi sinh chính bản thân mình để phong ấn Cửu Vĩ vào thân hình một đứa bé sơ sinh tên là Uzumaki Naruto.",R.drawable.truyen2_1,R.drawable.truyen2_2,R.drawable.truyen2_3,R.drawable.truyen2_4));
        truyen.add(new Truyen("Dragon Ball","Truyện tranh",R.drawable.truyen3,"Toriyama Akira","Chín phần , còn nữa","Bộ truyện Dragon Ball đầu tiên bắt đầu với việc Bulma phát hiện ra cả Goku và các Viên ngọc rồng. Trong phần này của nhượng quyền thương mại, Goku gặp Krillin và bắt đầu khóa huấn luyện chiến đấu với Master Roshi.",R.drawable.truyen3_1,R.drawable.truyen3_2,R.drawable.truyen3_3,R.drawable.truyen3_4));
        truyen.add(new Truyen("Truyện Ma","Truyện kinh dị",R.drawable.truyen4,"Nguyễn Ngọc Ngạn","Ba phần","Khi còn là học sinh, Lan thường đến công viên giải trí cùng bạn của mình. Giờ đây Lan đang là sinh viên và sắp đi du học, nhân dịp được tặng mấy tấm vé vào cổng, cô và nhóm bạn quyết định đi chơi ở công viên giải trí để ôn lại kỷ niệm. Công viên đó được đồn đoán trên mạng là có lời nguyền của Quỷ, những chuyện kỳ lạ bắt đầu xảy ra và bạn bè của Lan lần lượt biến mất.",R.drawable.truyen4_1,R.drawable.truyen4_2,R.drawable.truyen4_3,R.drawable.truyen4_4));
        truyen.add(new Truyen("Truyện Trạng cười","Truyện Hài",R.drawable.truyen5,"Đức Anh","Một phần","Nội dung truyện xoay quanh những câu chuyện dân gian xưa hài hước dí dỏm được tác giả sưu tầm lại và xuất bản",R.drawable.truyen5_1,R.drawable.truyen5_2,R.drawable.truyen5_3,R.drawable.truyen5_4));
        truyen.add(new Truyen("Truyện Cười dân gian","Truyện Hài",R.drawable.truyen6,"Ngọc Hà","Hai Phần","Nội dung truyện xoay quanh những câu chuyện dân gian xưa hài hước dí dỏm được tác giả sưu tầm lại và xuất bản",R.drawable.truyen6_1,R.drawable.truyen6_2,R.drawable.truyen6_3,R.drawable.truyen6_4));
        truyen.add(new Truyen("Gửi Thanh Xuân","Tiểu thuyết",R.drawable.truyen7,"Nguyễn Đức Vịnh","Ba phần","Sau nhiều lần gặp nhau bất đắc dĩ, cặp đôi oan gia Cố Dị Vịch và Tư Đồ Mạt phải sống chung với nhau. Họ thu hút nhau bởi sự ngô nghê, sự thiếu xót của đối phương, họ gắn kết với nhau bởi những cử chỉ hay hành động ngọt nào mà đối phương dành cho mình.",R.drawable.truyen1_1,R.drawable.truyen1_2,R.drawable.truyen1_3,R.drawable.truyen1_4));
        truyen.add(new Truyen("Ỷ Thiên Đồ Long Ký","Truyện kiếm hiệp",R.drawable.truyen8,"Kim Dung","76 Phần","Bối cảnh tiểu thuyết lấy vào cuối thời nhà Nguyên, 80 năm sau sự kiện trên đỉnh Hoa Sơn trong Thần điêu hiệp lữ, lúc này nhà Nguyên đang bị suy yếu bởi các cuộc khởi nghĩa và vì sự xa hoa lãng phí của triều đình. Truyện xoay quanh Trương Vô Kỵ và mối tình phức tạp với 4 cô gái.",R.drawable.truyen8_1,R.drawable.truyen8_2,R.drawable.truyen8_3,R.drawable.truyen8_4));
        truyen.add(new Truyen("Hiệp Khách Hành","Truyện kiếm hiệp",R.drawable.truyen9,"Kim Dung","82 Phần","Câu truyện xoay quanh các cuộc phiêu lưu của Thạch Phá Thiên, xoay quanh bài thơ Hiệp khách hành của thi tiên Lý Bạch. Hiệp khách hành là câu chuyện hoàn toàn không có sự liên hệ với lịch sử, với những tình tiết mang tính chất mờ ảo, thần thoại. Chỉ có thể đoán rằng nó xảy ra trong thời kỳ nhà Minh, khi mà đã xuất hiện phái Võ Đang với huyền thoại Trương Tam Phong.",R.drawable.truyen9_1,R.drawable.truyen9_2,R.drawable.truyen9_3,R.drawable.truyen9_4));
        truyen.add(new Truyen("Tự truyện Tô Hoài","Tự Truyện",R.drawable.truyen10,"Tô Hoài","Một Phần","Truyện được chính tay cố nhà văn tô hoài viết , kể về cuộc đời , quá trình sáng tác văn thơ của chính bản thân ông",R.drawable.truyen1_1,R.drawable.truyen1_2,R.drawable.truyen1_3,R.drawable.truyen1_4));
        Truyen TruyenABC = truyen.get(id);
        imghinh1.setImageResource(TruyenABC.getHinh1());
    }
    private void ConTrolbtn(){
        int  id = getIntent().getExtras().getInt("I");
        ImageView imghinh1 = (ImageView)findViewById(R.id.imgdoc) ;
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Truyen TruyenABC = truyen.get(id);
                imghinh1.setImageResource(TruyenABC.getHinh1());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Truyen TruyenABC = truyen.get(id);
                imghinh1.setImageResource(TruyenABC.getHinh2());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Truyen TruyenABC = truyen.get(id);
                imghinh1.setImageResource(TruyenABC.getHinh3());
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Truyen TruyenABC = truyen.get(id);
                imghinh1.setImageResource(TruyenABC.getHinh4());

            }
        });

    }
}