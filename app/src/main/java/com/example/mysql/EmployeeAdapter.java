package com.example.mysql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ProductViewHolder> {


    private Context mCtx;
    private List<Employee> employeeList;

    public EmployeeAdapter(Context mCtx, List<Employee> employeeList) {
        this.mCtx = mCtx;
        this.employeeList = employeeList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.employee_list, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Employee employee = employeeList.get(position);

        //loading the image
        Glide.with(mCtx)
                ;


        holder.textViewShortDesc.setText(employee.getEpf());
        holder.textlocation.setText(String.valueOf(employee.getLocation()));
        holder.textlongitude.setText(String.valueOf(employee.getLongitude()));
        holder.textlatitude.setText(String.valueOf(employee.getLatitude()));
        holder.texttimeIn.setText(String.valueOf(employee.getTimeIn()));
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;

        TextView textViewTitle, textViewShortDesc, textlocation, textlongitude,textlatitude,texttimeIn;

        public ProductViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textlocation = itemView.findViewById(R.id.textlocation);
            textlongitude = itemView.findViewById(R.id.textlongitude);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textlatitude = itemView.findViewById(R.id.textlatitude);
            texttimeIn = itemView.findViewById(R.id.texttimeIn);

        }
    }
}