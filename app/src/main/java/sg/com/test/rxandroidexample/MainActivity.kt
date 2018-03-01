package sg.com.test.rxandroidexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    @BindView(R.id.tv_title) lateinit var tvTitle: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        tvTitle.text = "Hello!!!!"
        var str: String = tvTitle.text.toString()
        val observer = object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onComplete() {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onNext(t: String) {
                str += t
                tvTitle.text = str
            }

            override fun onError(e: Throwable) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }


        Observable.just("1", "2", "3")
                .subscribeOn(Schedulers.io())
                .filter { str -> Integer.parseInt(str) % 2 == 0 }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }
}
