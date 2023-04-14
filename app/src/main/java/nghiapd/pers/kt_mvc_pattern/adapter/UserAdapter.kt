package nghiapd.pers.kt_mvc_pattern.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import nghiapd.pers.kt_mvc_pattern.R
import nghiapd.pers.kt_mvc_pattern.model.User

class UserAdapter(data: ArrayList<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var data = ArrayList<User>();
    lateinit var context: Context;

    init {
        this.data = data;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        context = parent.context;
        var v = LayoutInflater.from(context).inflate(R.layout.user_information, parent, false);
        return UserViewHolder(v);
    }

    override fun getItemCount(): Int {
        return data.size;
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = data[position]
        Glide.with(context)
            .load(user.imgSrc.large)
            .circleCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(holder.img);
        holder.name.text = "${user.name.title} ${user.name.first} ${user.name.last}";
        holder.phone.text = "Phone: ${user.phone}";
        holder.email.text = "Email: ${user.email}";
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.userImgView);
        val name: TextView = itemView.findViewById(R.id.userTvName);
        val phone: TextView = itemView.findViewById(R.id.userTvPhone);
        val email:TextView = itemView.findViewById(R.id.userTvEmail);
    }
}