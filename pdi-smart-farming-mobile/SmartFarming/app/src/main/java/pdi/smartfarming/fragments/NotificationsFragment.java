package pdi.smartfarming.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pdi.smartfarming.R;
import pdi.smartfarming.rest.Notification;
import pdi.smartfarming.tools.Data;
import pdi.smartfarming.ui.Adapter;
import pdi.smartfarming.ui.VerticalDivider;

/**
 * ionutciuta24@gmail.com on 09.05.2017.
 */

public class NotificationsFragment extends AbstractFragment {
    public static NotificationsFragment instance() {
        NotificationsFragment fragment = new NotificationsFragment();
        fragment.setLayout(R.layout.fragment_list);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        setup(root);
        return root;
    }

    @Override
    protected void setup(View view) {
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.list);
        Adapter<Notification> adapter = new Adapter<>(
                Data.getNotifications(), R.layout.item_notification, Notification.class);
        rv.addItemDecoration(new VerticalDivider());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
    }
}
