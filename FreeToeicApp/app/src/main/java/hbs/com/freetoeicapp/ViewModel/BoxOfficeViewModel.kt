package hbs.com.freetoeicapp.ViewModel

import android.databinding.BaseObservable
import com.bumptech.glide.RequestManager
import hbs.com.freetoeicapp.Model.BoxOfficeItem
import hbs.com.freetoeicapp.databinding.OfficeRecyclerItemBinding

class BoxOfficeViewModel(private var officeItem: BoxOfficeItem?, officeRecyclerItemBinding: OfficeRecyclerItemBinding) : BaseObservable() {
    private val officeItemBinding = officeRecyclerItemBinding
    fun getOfficeData(): BoxOfficeItem? {
        return officeItem
    }

    fun onCreate(itemPosition:Int, mRequestManager:RequestManager){
        //여기서 부터 해야됨.
        //https://www.koreafilm.or.kr/member/kmdb/certification#none
        //officeItem 모델의 제목과 감독을 통해 해당 API의 이미지를 get 해 옴.
    }
}