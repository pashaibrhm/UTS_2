package com.aquarian.uts;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class PesanActivityListFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] values = new String[] {"Android", "Iphone", "WindowsPhone",
                "BlackBerry", "Linux", "Ubuntu", "Windows", };

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);

        setListAdapter(arrayAdapter);

    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);
    }
}
