import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medease.R
import com.example.medease.clickinterface.SpecialisationINterface
import com.example.medease.models.SpecialisationModel

class NameAdapter (var namesList: List<SpecialisationModel>,  var specialisationINterface: SpecialisationINterface) :
RecyclerView.Adapter<NameAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var tvName: TextView = view.findViewById(R.id.tvSpecialisationName)
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val thirdActivity = LayoutInflater.from(parent.context).inflate(R.layout.specialisation_item,parent,false)
        return NameAdapter.ViewHolder(thirdActivity)
    }

    override fun getItemCount(): Int {
        return namesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.setText(namesList[position].name)
        holder.itemView.setOnClickListener {
            specialisationINterface.onNextCLick(namesList[position])
        }
    }
}