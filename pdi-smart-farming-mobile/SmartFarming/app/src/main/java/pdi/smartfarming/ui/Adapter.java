package pdi.smartfarming.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import pdi.smartfarming.R;
import pdi.smartfarming.dto.Notification;
import pdi.smartfarming.dto.Plant;

/**
 * ionutciuta24@gmail.com on 20.05.2017.
 */

public class Adapter<T> extends RecyclerView.Adapter<Adapter.VH<T>>{
    private List<T> data;
    private Class clazz;
    private int layout;

    public Adapter(List<T> data, int layout, Class clazz) {
        this.data = data;
        this.clazz = clazz;
        this.layout = layout;
    }

    @Override
    public VH<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH<>(LayoutInflater.from(parent.getContext()).inflate(layout, parent, false), clazz);
    }

    @Override
    public void onBindViewHolder(VH<T> holder, int position) {
        holder.set(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void update(List<T> newData) {
        this.data = newData;
        notifyDataSetChanged();
    }

    static class VH<T> extends RecyclerView.ViewHolder {
        private TextView txtPlantName, txtDate, txtStatus, txtH, txtT, txtL;
        private Class clazz;

        VH(View itemView, Class clazz) {
            super(itemView);
            this.clazz = clazz;

            if(Notification.class.equals(clazz)) initNotification(itemView);
            else if(Plant.class.equals(clazz)) initPlant(itemView);
            else throw new UnsupportedOperationException("Invalid class");
        }

        void set(T obj) {
            if(Notification.class.equals(clazz)) setNotification((Notification)obj);
            else if(Plant.class.equals(clazz)) setPlant((Plant)obj);
            else throw new UnsupportedOperationException("Invalid class");
        }

        private void initPlant(View view) {
            txtPlantName = (TextView) view.findViewById(R.id.text_plant_name);
            txtDate = (TextView) view.findViewById(R.id.text_last_updated_field);
            txtStatus = (TextView) view.findViewById(R.id.text_status_field);
        }

        private void initNotification(View view) {
            txtPlantName = (TextView) view.findViewById(R.id.text_plant_name);
            txtDate = (TextView) view.findViewById(R.id.text_notification_date);
            txtH = (TextView) view.findViewById(R.id.text_humidity);
            txtT = (TextView) view.findViewById(R.id.text_temperature);
            txtL = (TextView) view.findViewById(R.id.text_light);
            txtStatus = (TextView) view.findViewById(R.id.text_status);
        }

        private void setPlant(Plant plant) {
            txtPlantName.setText(plant.getName());
            txtStatus.setText(plant.getStatus());
            txtDate.setText(new SimpleDateFormat("dd.MM.yyyy @ hh:mm").format(plant.getLastUpdate()));
        }

        private void setNotification(Notification notification) {
            txtPlantName.setText(notification.getPlantName());
            txtDate.setText(new SimpleDateFormat("dd.MM.yyyy @ hh:mm").format(notification.getReceivedOn()));
            txtH.setText(notification.getH());
            txtT.setText(notification.getT());
            txtL.setText(notification.getL());
            txtStatus.setText(notification.getStatus());
        }
    }
}
