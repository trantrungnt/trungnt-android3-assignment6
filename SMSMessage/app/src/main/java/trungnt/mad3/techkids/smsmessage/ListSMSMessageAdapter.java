package trungnt.mad3.techkids.smsmessage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by TrungNT on 4/25/2016.
 */
public class ListSMSMessageAdapter extends BaseAdapter {
    private ArrayList<SMSMessage> arrListSMSMessage;

    @Override
    public int getCount() {
        return arrListSMSMessage.size();
    }

    @Override
    public SMSMessage getItem(int position) {
        return arrListSMSMessage.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
