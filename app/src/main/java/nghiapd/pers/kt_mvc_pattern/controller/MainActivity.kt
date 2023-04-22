package nghiapd.pers.kt_mvc_pattern.controller

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import nghiapd.pers.kt_mvc_pattern.APIHelper
import nghiapd.pers.kt_mvc_pattern.R
import nghiapd.pers.kt_mvc_pattern.adapter.UserAdapter
import nghiapd.pers.kt_mvc_pattern.model.User
import nghiapd.pers.kt_mvc_pattern.model.UserRespone
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var myRecyclerView: RecyclerView;
    lateinit var myAdapter: UserAdapter;
    private var data = ArrayList<User>();
    lateinit var myRefreshLayout: SwipeRefreshLayout;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.myRecyclerView);
        myRefreshLayout = findViewById(R.id.swipeToRefresh);

        myAdapter = UserAdapter(data);
        myRecyclerView.adapter = myAdapter;
        myRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        loadData();

        myRefreshLayout.setOnRefreshListener {
            data.clear();
            loadData();
            myRefreshLayout.isRefreshing = false;
        }
    }

    private fun loadData(){
        var result = APIHelper.apiService.getUser(10);
        result.enqueue(object : Callback<UserRespone> {
            override fun onResponse(call: Call<UserRespone>, response: Response<UserRespone>) {
                data.addAll(response.body()!!.results)
                myAdapter.notifyDataSetChanged()
                Log.e("Success API", "onResponse: $data" )
            }

            override fun onFailure(call: Call<UserRespone>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                Log.e("Failure API", "onFailure: ${t.message}")
            }

        })
    }
}