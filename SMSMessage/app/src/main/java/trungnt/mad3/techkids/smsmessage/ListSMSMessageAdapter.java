package trungnt.mad3.techkids.smsmessage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by TrungNT on 4/25/2016.
 */
public class ListSMSMessageAdapter extends BaseAdapter {
    private ArrayList<SMSMessage> arrListSMSMessage;
    private TextView txtPhone, txtContentSMSMessage;
    private Context mContext;
    private int layoutItemID;

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

    public ListSMSMessageAdapter(Context mContext, int layoutItemID, ArrayList<SMSMessage> arrListSMSMessage)
    {
        this.mContext = mContext;
        this.layoutItemID = layoutItemID;
        this.arrListSMSMessage = arrListSMSMessage;
    }
}
